package com.coolapk.market.download;

import android.text.TextUtils;
import com.coolapk.market.download.DownloadJob;
import com.coolapk.market.model.Extra;
import com.coolapk.market.util.LogUtils;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class DownloadQueue {
    private final int parallelTaskCount;
    private final LinkedList<InternalJob> taskQueue = new LinkedList<>();

    public DownloadQueue(int i) {
        this.parallelTaskCount = i;
    }

    public void add(String str, String str2, String str3, OnDownloadListener onDownloadListener, Extra extra, NetworkExecutor networkExecutor) {
        synchronized (this.taskQueue) {
            LogUtils.v("Add download job to task queue, [%s]", str);
            this.taskQueue.add(new InternalJob(str, str2, str3, onDownloadListener, extra, networkExecutor));
            schedule();
        }
    }

    public void cancel(String str) {
        synchronized (this.taskQueue) {
            for (InternalJob internalJob : getDownloadJob(str)) {
                if (internalJob != null && internalJob.isAdded() && !internalJob.isCancelled()) {
                    LogUtils.v("Mark cancel job, [%s]", internalJob.getFileName());
                    internalJob.markCancel();
                }
            }
        }
        schedule();
    }

    public void cancelAll() {
        synchronized (this.taskQueue) {
            LogUtils.v("Clear task queue", new Object[0]);
            Iterator<InternalJob> it2 = this.taskQueue.iterator();
            while (it2.hasNext()) {
                InternalJob next = it2.next();
                if (next != null && next.isAdded() && !next.isCancelled()) {
                    LogUtils.v("Mark cancel job, [%s]", next.getFileName());
                    next.markCancel();
                }
            }
        }
        schedule();
    }

    public boolean isDownloadJobAlive(String str) {
        for (InternalJob internalJob : getDownloadJob(str)) {
            if (!(internalJob == null || !internalJob.isAdded() || internalJob.isCancelled())) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        return this.taskQueue.size();
    }

    private List<InternalJob> getDownloadJob(String str) {
        ArrayList arrayList;
        synchronized (this.taskQueue) {
            Iterator<InternalJob> it2 = this.taskQueue.iterator();
            arrayList = null;
            while (it2.hasNext()) {
                InternalJob next = it2.next();
                if (TextUtils.equals(next.getUrl(), str)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    /* access modifiers changed from: private */
    public void schedule() {
        synchronized (this.taskQueue) {
            if (count() != 0) {
                LogUtils.v("=========================================================================", new Object[0]);
                LogUtils.v("Schedule download queue", new Object[0]);
                Iterator<InternalJob> it2 = this.taskQueue.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    InternalJob next = it2.next();
                    LogUtils.d("Job [%s], state: %s, isCanceled: %s", next.getFileName(), getJobStateString(next.getDownloadJob()), Boolean.valueOf(next.isCancelled()));
                    if (!next.isDeliverWait() && getCanceledDownloadJob(next.getUrl()).isEmpty()) {
                        next.deliverWait();
                    }
                    if (next.isDeploy()) {
                        i++;
                    }
                }
                Iterator<InternalJob> it3 = this.taskQueue.iterator();
                while (it3.hasNext()) {
                    InternalJob next2 = it3.next();
                    if (!next2.isDeploy() && !next2.isDeliverResult() && next2.isCancelled()) {
                        LogUtils.v("Job is cancel before deploy, [%s]", next2.getFileName());
                        it3.remove();
                        next2.deliverCancel();
                    }
                }
                LogUtils.v("Job in queue: %d, deploy: %d, wait: %d", Integer.valueOf(this.taskQueue.size()), Integer.valueOf(i), Integer.valueOf(this.taskQueue.size() - i));
                if (i < this.parallelTaskCount) {
                    Iterator<InternalJob> it4 = this.taskQueue.iterator();
                    while (it4.hasNext()) {
                        InternalJob next3 = it4.next();
                        if (next3.isWait() && !next3.isDeploy() && !next3.isCancelled()) {
                            if (!getCanceledDownloadJob(next3.getUrl()).isEmpty()) {
                                LogUtils.v("Wait same job cancel done, [%s]", next3.getFileName());
                            } else {
                                deploy(next3);
                                i++;
                                if (i >= this.parallelTaskCount) {
                                    return;
                                }
                            }
                        }
                    }
                    LogUtils.v("=========================================================================", new Object[0]);
                }
            }
        }
    }

    private void deploy(final InternalJob internalJob) {
        if (internalJob.isDeploy()) {
            throw new IllegalStateException("The job is deploy! Do not deploy again!!");
        } else if (!internalJob.isDone()) {
            LogUtils.v("Deploy job, [%s]", internalJob.getFileName());
            internalJob.markDeploy();
            internalJob.deliverStart();
            Observable.create(new Observable.OnSubscribe<Object>() {
                /* class com.coolapk.market.download.DownloadQueue.AnonymousClass4 */

                public void call(Subscriber<? super Object> subscriber) {
                    try {
                        internalJob.run();
                        subscriber.onNext(null);
                        subscriber.onCompleted();
                    } catch (Throwable th) {
                        subscriber.onError(th);
                    }
                }
            }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                /* class com.coolapk.market.download.DownloadQueue.AnonymousClass3 */

                /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<?> */
                public Observable<?> call(Observable<? extends Throwable> observable) {
                    return (Observable<R>) observable.zipWith(Observable.range(1, 4), new Func2<Throwable, Integer, Integer>() {
                        /* class com.coolapk.market.download.DownloadQueue.AnonymousClass3.AnonymousClass2 */

                        public Integer call(Throwable th, Integer num) {
                            if (num.intValue() >= 4 || (!(th instanceof HttpException) && !(th instanceof SocketTimeoutException))) {
                                throw Exceptions.propagate(th);
                            }
                            LogUtils.e(th.getMessage(), new Object[0]);
                            LogUtils.e("[DownloadJob] We will retry: %d, [%s]", num, internalJob.getFileName());
                            return num;
                        }
                    }).flatMap(new Func1<Integer, Observable<Long>>() {
                        /* class com.coolapk.market.download.DownloadQueue.AnonymousClass3.AnonymousClass1 */

                        public Observable<Long> call(Integer num) {
                            long pow = (long) Math.pow(2.0d, (double) num.intValue());
                            LogUtils.v("[DownloadJob] Retry count: %d, delay: %ds, [%s] ", num, Long.valueOf(pow), internalJob.getFileName());
                            return Observable.timer(pow, TimeUnit.SECONDS);
                        }
                    });
                }
            }).onErrorResumeNext(new Func1<Throwable, Observable<?>>() {
                /* class com.coolapk.market.download.DownloadQueue.AnonymousClass2 */

                public Observable<?> call(Throwable th) {
                    return ((!(th instanceof RuntimeException) || !(th.getCause() instanceof HttpException)) ? th : th.getCause()) instanceof HttpException ? Observable.create(new Observable.OnSubscribe<Object>() {
                        /* class com.coolapk.market.download.DownloadQueue.AnonymousClass2.AnonymousClass1 */

                        public void call(Subscriber<? super Object> subscriber) {
                            try {
                                internalJob.getExtra().put("RESUME_ON_ERROR", true);
                                internalJob.run();
                                subscriber.onNext(null);
                                subscriber.onCompleted();
                            } catch (Throwable th) {
                                subscriber.onError(th);
                            }
                        }
                    }) : Observable.error(th);
                }
            }).subscribeOn(Schedulers.io()).subscribe((Subscriber) new Subscriber<Object>() {
                /* class com.coolapk.market.download.DownloadQueue.AnonymousClass1 */

                @Override // rx.Observer
                public void onCompleted() {
                    LogUtils.v("[DownloadJob] onCompleted, [%s]", internalJob.getFileName());
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    LogUtils.e(th, "[DownloadJob], onError, [%s]", internalJob.getFileName());
                    internalJob.markCancel();
                    DownloadQueue.this.remove(internalJob);
                    internalJob.deliverError(th);
                    DownloadQueue.this.schedule();
                }

                @Override // rx.Observer
                public void onNext(Object obj) {
                    LogUtils.v("[DownloadJob] onNext, [%s]", internalJob.getFileName());
                    DownloadQueue.this.remove(internalJob);
                    if (internalJob.isCancelled()) {
                        internalJob.deliverCancel();
                    } else {
                        internalJob.deliverSuccess();
                    }
                    DownloadQueue.this.schedule();
                }
            });
        } else {
            throw new IllegalStateException("The job is done before! Do not deploy again!!");
        }
    }

    private List<DownloadJob> getCanceledDownloadJob(String str) {
        ArrayList arrayList;
        synchronized (this.taskQueue) {
            Iterator<InternalJob> it2 = this.taskQueue.iterator();
            arrayList = null;
            while (it2.hasNext()) {
                InternalJob next = it2.next();
                if (TextUtils.equals(next.getUrl(), str) && next.isCancelled()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next.getDownloadJob());
                }
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    /* access modifiers changed from: private */
    public void remove(InternalJob internalJob) {
        synchronized (this.taskQueue) {
            LogUtils.v("Remove download job to task queue, [%s]", internalJob.getFileName());
            this.taskQueue.remove(internalJob);
        }
    }

    private String getJobStateString(DownloadJob downloadJob) {
        if (downloadJob.isWait()) {
            return "wait";
        }
        if (downloadJob.isRunning()) {
            return "running";
        }
        return downloadJob.isDone() ? "done" : "unknown";
    }

    private static class InternalJob implements DownloadJob.Callback {
        private boolean isDeliverResult = false;
        private boolean isDeliverStart = false;
        private boolean isDeliverWait = false;
        private boolean isDeploy = false;
        private final DownloadJob job;
        private final OnDownloadListener onDownloadListener;

        public InternalJob(String str, String str2, String str3, OnDownloadListener onDownloadListener2, Extra extra, NetworkExecutor networkExecutor) {
            this.job = new DownloadJob(str, str2, str3, this, extra, networkExecutor);
            this.onDownloadListener = onDownloadListener2;
        }

        public void deliverWait() {
            if (!this.isDeliverWait) {
                this.isDeliverWait = true;
                this.onDownloadListener.onDownloadJobWait(this.job);
                return;
            }
            throw new IllegalStateException("Deliver wait only once! " + this.job.getFileName());
        }

        public void deliverStart() {
            if (!this.isDeliverStart) {
                this.isDeliverStart = true;
                this.onDownloadListener.onDownloadJobStart(this.job);
                return;
            }
            throw new IllegalStateException("Deliver start only once! " + this.job.getFileName());
        }

        @Override // com.coolapk.market.download.DownloadJob.Callback
        public void onProcess(DownloadJob downloadJob) {
            this.onDownloadListener.onDownloadJobRunning(downloadJob);
        }

        public void deliverSuccess() {
            if (!this.isDeliverResult) {
                this.isDeliverResult = true;
                this.onDownloadListener.onDownloadJobSuccess(this.job);
                return;
            }
            throw new IllegalStateException("Deliver result only once! " + this.job.getFileName());
        }

        public void deliverCancel() {
            if (!this.isDeliverResult) {
                this.isDeliverResult = true;
                this.onDownloadListener.onDownloadJobCancel(this.job);
                return;
            }
            throw new IllegalStateException("Deliver result only once! " + this.job.getFileName());
        }

        public void deliverError(Throwable th) {
            if (!this.isDeliverResult) {
                this.isDeliverResult = true;
                this.onDownloadListener.onDownloadJobError(this.job, th);
                return;
            }
            throw new IllegalStateException("Deliver result only once! " + this.job.getFileName());
        }

        public boolean isDeliverWait() {
            return this.isDeliverWait;
        }

        public boolean isDeliverResult() {
            return this.isDeliverResult;
        }

        public boolean isDeploy() {
            return this.isDeploy;
        }

        public void markDeploy() {
            this.isDeploy = true;
        }

        public boolean isAdded() {
            return this.job.isAdded();
        }

        public void markCancel() {
            this.job.markCancel();
        }

        public String getUrl() {
            return this.job.getUrl();
        }

        public String getFileName() {
            return this.job.getFileName();
        }

        public DownloadJob getDownloadJob() {
            return this.job;
        }

        public boolean isCancelled() {
            return this.job.isCancelled();
        }

        public boolean isRunning() {
            return this.job.isRunning();
        }

        public boolean isWait() {
            return this.job.isWait();
        }

        public boolean isDone() {
            return this.job.isDone();
        }

        public void run() throws Throwable {
            this.job.run();
        }

        public Extra getExtra() {
            return this.job.getExtra();
        }
    }
}
