package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class WorkerWrapper implements Runnable {
    static final String TAG = Logger.tagWithPrefix("WorkerWrapper");
    Context mAppContext;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    SettableFuture<Boolean> mFuture = SettableFuture.create();
    ListenableFuture<ListenableWorker.Result> mInnerFuture = null;
    private volatile boolean mInterrupted;
    ListenableWorker.Result mResult = ListenableWorker.Result.failure();
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<Scheduler> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private String mWorkSpecId;
    private WorkTagDao mWorkTagDao;
    private TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;

    WorkerWrapper(Builder builder) {
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpecId = builder.mWorkSpecId;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = builder.mWorker;
        this.mConfiguration = builder.mConfiguration;
        WorkDatabase workDatabase = builder.mWorkDatabase;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mWorkTagDao = this.mWorkDatabase.workTagDao();
    }

    public ListenableFuture<Boolean> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> tagsForWorkSpecId = this.mWorkTagDao.getTagsForWorkSpecId(this.mWorkSpecId);
        this.mTags = tagsForWorkSpecId;
        this.mWorkDescription = createWorkDescription(tagsForWorkSpecId);
        runWorker();
    }

    private void runWorker() {
        Data merge;
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpec workSpec = this.mWorkSpecDao.getWorkSpec(this.mWorkSpecId);
                this.mWorkSpec = workSpec;
                if (workSpec == null) {
                    Logger.get().error(TAG, String.format("Didn't find WorkSpec for id %s", this.mWorkSpecId), new Throwable[0]);
                    resolve(false);
                } else if (workSpec.state != WorkInfo.State.ENQUEUED) {
                    resolveIncorrectStatus();
                    this.mWorkDatabase.setTransactionSuccessful();
                    Logger.get().debug(TAG, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.mWorkSpec.workerClassName), new Throwable[0]);
                    this.mWorkDatabase.endTransaction();
                } else {
                    if (this.mWorkSpec.isPeriodic() || this.mWorkSpec.isBackedOff()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!(this.mWorkSpec.periodStartTime == 0) && currentTimeMillis < this.mWorkSpec.calculateNextRunTime()) {
                            Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.workerClassName), new Throwable[0]);
                            resolve(true);
                            this.mWorkDatabase.endTransaction();
                            return;
                        }
                    }
                    this.mWorkDatabase.setTransactionSuccessful();
                    this.mWorkDatabase.endTransaction();
                    if (this.mWorkSpec.isPeriodic()) {
                        merge = this.mWorkSpec.input;
                    } else {
                        InputMerger createInputMergerWithDefaultFallback = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.mWorkSpec.inputMergerClassName);
                        if (createInputMergerWithDefaultFallback == null) {
                            Logger.get().error(TAG, String.format("Could not create Input Merger %s", this.mWorkSpec.inputMergerClassName), new Throwable[0]);
                            setFailedAndResolve();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.mWorkSpec.input);
                        arrayList.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
                        merge = createInputMergerWithDefaultFallback.merge(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.mWorkSpecId), merge, this.mTags, this.mRuntimeExtras, this.mWorkSpec.runAttemptCount, this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
                    if (this.mWorker == null) {
                        this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.mWorker;
                    if (listenableWorker == null) {
                        Logger.get().error(TAG, String.format("Could not create Worker %s", this.mWorkSpec.workerClassName), new Throwable[0]);
                        setFailedAndResolve();
                    } else if (listenableWorker.isUsed()) {
                        Logger.get().error(TAG, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.mWorkSpec.workerClassName), new Throwable[0]);
                        setFailedAndResolve();
                    } else {
                        this.mWorker.setUsed();
                        if (!trySetRunning()) {
                            resolveIncorrectStatus();
                        } else if (!tryCheckForInterruptionAndResolve()) {
                            final SettableFuture create = SettableFuture.create();
                            this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Runnable() {
                                /* class androidx.work.impl.WorkerWrapper.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        Logger.get().debug(WorkerWrapper.TAG, String.format("Starting work for %s", WorkerWrapper.this.mWorkSpec.workerClassName), new Throwable[0]);
                                        WorkerWrapper workerWrapper = WorkerWrapper.this;
                                        workerWrapper.mInnerFuture = workerWrapper.mWorker.startWork();
                                        create.setFuture(WorkerWrapper.this.mInnerFuture);
                                    } catch (Throwable th) {
                                        create.setException(th);
                                    }
                                }
                            });
                            final String str = this.mWorkDescription;
                            create.addListener(new Runnable() {
                                /* class androidx.work.impl.WorkerWrapper.AnonymousClass2 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ListenableWorker.Result result = (ListenableWorker.Result) create.get();
                                        if (result == null) {
                                            Logger.get().error(WorkerWrapper.TAG, String.format("%s returned a null result. Treating it as a failure.", WorkerWrapper.this.mWorkSpec.workerClassName), new Throwable[0]);
                                        } else {
                                            Logger.get().debug(WorkerWrapper.TAG, String.format("%s returned a %s result.", WorkerWrapper.this.mWorkSpec.workerClassName, result), new Throwable[0]);
                                            WorkerWrapper.this.mResult = result;
                                        }
                                    } catch (CancellationException e) {
                                        Logger.get().info(WorkerWrapper.TAG, String.format("%s was cancelled", str), e);
                                    } catch (InterruptedException | ExecutionException e2) {
                                        Logger.get().error(WorkerWrapper.TAG, String.format("%s failed because it threw an exception/error", str), e2);
                                    } catch (Throwable th) {
                                        WorkerWrapper.this.onWorkFinished();
                                        throw th;
                                    }
                                    WorkerWrapper.this.onWorkFinished();
                                }
                            }, this.mWorkTaskExecutor.getBackgroundExecutor());
                        }
                    }
                }
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    void onWorkFinished() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
                this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
                if (state == null) {
                    resolve(false);
                } else if (state == WorkInfo.State.RUNNING) {
                    handleResult(this.mResult);
                } else if (!state.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
        List<Scheduler> list = this.mSchedulers;
        if (list != null) {
            for (Scheduler scheduler : list) {
                scheduler.cancel(this.mWorkSpecId);
            }
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    public void interrupt() {
        boolean z;
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.mInnerFuture;
        if (listenableFuture != null) {
            z = listenableFuture.isDone();
            this.mInnerFuture.cancel(true);
        } else {
            z = false;
        }
        ListenableWorker listenableWorker = this.mWorker;
        if (listenableWorker == null || z) {
            Logger.get().debug(TAG, String.format("WorkSpec %s is already done. Not interrupting.", this.mWorkSpec), new Throwable[0]);
        } else {
            listenableWorker.stop();
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(TAG, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.mWorkSpecId), new Throwable[0]);
            resolve(true);
            return;
        }
        Logger.get().debug(TAG, String.format("Status for %s is %s; not doing any work", this.mWorkSpecId, state), new Throwable[0]);
        resolve(false);
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger.get().debug(TAG, String.format("Work interrupted for %s", this.mWorkDescription), new Throwable[0]);
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == null) {
            resolve(false);
        } else {
            resolve(!state.isFinished());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[Catch:{ all -> 0x0059 }] */
    private void resolve(boolean z) {
        boolean z2;
        ListenableWorker listenableWorker;
        this.mWorkDatabase.beginTransaction();
        try {
            List<String> allUnfinishedWork = this.mWorkDatabase.workSpecDao().getAllUnfinishedWork();
            if (allUnfinishedWork != null) {
                if (!allUnfinishedWork.isEmpty()) {
                    z2 = false;
                    if (z2) {
                        PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
                    }
                    if (z) {
                        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
                    }
                    if (!(this.mWorkSpec == null || (listenableWorker = this.mWorker) == null || !listenableWorker.isRunInForeground())) {
                        this.mForegroundProcessor.stopForeground(this.mWorkSpecId);
                    }
                    this.mWorkDatabase.setTransactionSuccessful();
                    this.mWorkDatabase.endTransaction();
                    this.mFuture.set(Boolean.valueOf(z));
                }
            }
            z2 = true;
            if (z2) {
            }
            if (z) {
            }
            this.mForegroundProcessor.stopForeground(this.mWorkSpecId);
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            this.mFuture.set(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.mWorkDatabase.endTransaction();
            throw th;
        }
    }

    private void handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(TAG, String.format("Worker result SUCCESS for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setSucceededAndResolve();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(TAG, String.format("Worker result RETRY for %s", this.mWorkDescription), new Throwable[0]);
            rescheduleAndResolve();
        } else {
            Logger.get().info(TAG, String.format("Worker result FAILURE for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setFailedAndResolve();
            }
        }
    }

    private boolean trySetRunning() {
        this.mWorkDatabase.beginTransaction();
        try {
            boolean z = true;
            if (this.mWorkSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.ENQUEUED) {
                this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
            } else {
                z = false;
            }
            this.mWorkDatabase.setTransactionSuccessful();
            return z;
        } finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        boolean z = false;
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Failure) this.mResult).getOutputData());
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(z);
        }
    }

    private void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.mWorkSpecDao.getState(str2) != WorkInfo.State.CANCELLED) {
                this.mWorkSpecDao.setState(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.mDependencyDao.getDependentWorkIds(str2));
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        boolean z = true;
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(z);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        boolean z = false;
        try {
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(z);
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        boolean z = false;
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Success) this.mResult).getOutputData());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.getState(str) == WorkInfo.State.BLOCKED && this.mDependencyDao.hasCompletedAllPrerequisites(str)) {
                    Logger.get().info(TAG, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, str);
                    this.mWorkSpecDao.setPeriodStartTime(str, currentTimeMillis);
                }
            }
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(z);
        }
    }

    private String createWorkDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.mWorkSpecId);
        sb.append(", tags={ ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    public static class Builder {
        Context mAppContext;
        Configuration mConfiguration;
        ForegroundProcessor mForegroundProcessor;
        WorkerParameters.RuntimeExtras mRuntimeExtras = new WorkerParameters.RuntimeExtras();
        List<Scheduler> mSchedulers;
        WorkDatabase mWorkDatabase;
        String mWorkSpecId;
        TaskExecutor mWorkTaskExecutor;
        ListenableWorker mWorker;

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, String str) {
            this.mAppContext = context.getApplicationContext();
            this.mWorkTaskExecutor = taskExecutor;
            this.mForegroundProcessor = foregroundProcessor;
            this.mConfiguration = configuration;
            this.mWorkDatabase = workDatabase;
            this.mWorkSpecId = str;
        }

        public Builder withSchedulers(List<Scheduler> list) {
            this.mSchedulers = list;
            return this;
        }

        public Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.mRuntimeExtras = runtimeExtras;
            }
            return this;
        }

        public Builder withWorker(ListenableWorker listenableWorker) {
            this.mWorker = listenableWorker;
            return this;
        }

        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }
    }
}
