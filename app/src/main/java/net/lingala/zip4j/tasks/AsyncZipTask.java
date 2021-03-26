package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

public abstract class AsyncZipTask<T> {
    private ExecutorService executorService;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;

    protected abstract long calculateTotalWork(T t) throws ZipException;

    protected abstract void executeTask(T t, ProgressMonitor progressMonitor2) throws IOException;

    protected abstract ProgressMonitor.Task getTask();

    public AsyncZipTask(AsyncTaskParameters asyncTaskParameters) {
        this.progressMonitor = asyncTaskParameters.progressMonitor;
        this.runInThread = asyncTaskParameters.runInThread;
        this.executorService = asyncTaskParameters.executorService;
    }

    public void execute(T t) throws ZipException {
        this.progressMonitor.fullReset();
        this.progressMonitor.setState(ProgressMonitor.State.BUSY);
        this.progressMonitor.setCurrentTask(getTask());
        if (this.runInThread) {
            this.progressMonitor.setTotalWork(calculateTotalWork(t));
            this.executorService.execute(new Runnable(t) {
                /* class net.lingala.zip4j.tasks.$$Lambda$AsyncZipTask$2bcvY2LHtfElCmmFtqo8tCYuE */
                public final /* synthetic */ Object f$1;

                {
                    this.f$1 = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AsyncZipTask.this.lambda$execute$0$AsyncZipTask(this.f$1);
                }
            });
            return;
        }
        performTaskWithErrorHandling(t, this.progressMonitor);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$execute$0$AsyncZipTask(Object obj) {
        try {
            performTaskWithErrorHandling(obj, this.progressMonitor);
        } catch (ZipException unused) {
        } catch (Throwable th) {
            this.executorService.shutdown();
            throw th;
        }
        this.executorService.shutdown();
    }

    private void performTaskWithErrorHandling(T t, ProgressMonitor progressMonitor2) throws ZipException {
        try {
            executeTask(t, progressMonitor2);
            progressMonitor2.endProgressMonitor();
        } catch (ZipException e) {
            progressMonitor2.endProgressMonitor(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor2.endProgressMonitor(e2);
            throw new ZipException(e2);
        }
    }

    protected void verifyIfTaskIsCancelled() throws ZipException {
        if (this.progressMonitor.isCancelAllTasks()) {
            this.progressMonitor.setResult(ProgressMonitor.Result.CANCELLED);
            this.progressMonitor.setState(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }

    public static class AsyncTaskParameters {
        private ExecutorService executorService;
        private ProgressMonitor progressMonitor;
        private boolean runInThread;

        public AsyncTaskParameters(ExecutorService executorService2, boolean z, ProgressMonitor progressMonitor2) {
            this.executorService = executorService2;
            this.runInThread = z;
            this.progressMonitor = progressMonitor2;
        }
    }
}
