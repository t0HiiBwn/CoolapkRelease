package net.lingala.zip4j.progress;

public class ProgressMonitor {
    private boolean cancelAllTasks;
    private Task currentTask;
    private Exception exception;
    private String fileName;
    private boolean pause;
    private int percentDone;
    private Result result;
    private State state;
    private long totalWork;
    private long workCompleted;

    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    public enum State {
        READY,
        BUSY
    }

    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        reset();
    }

    public void updateWorkCompleted(long j) {
        long j2 = this.workCompleted + j;
        this.workCompleted = j2;
        long j3 = this.totalWork;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.percentDone = i;
            if (i > 100) {
                this.percentDone = 100;
            }
        }
        while (this.pause) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void endProgressMonitor() {
        this.result = Result.SUCCESS;
        this.percentDone = 100;
        reset();
    }

    public void endProgressMonitor(Exception exc) {
        this.result = Result.ERROR;
        this.exception = exc;
        reset();
    }

    public void fullReset() {
        reset();
        this.fileName = null;
        this.totalWork = 0;
        this.workCompleted = 0;
        this.percentDone = 0;
    }

    private void reset() {
        this.currentTask = Task.NONE;
        this.state = State.READY;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state2) {
        this.state = state2;
    }

    public long getTotalWork() {
        return this.totalWork;
    }

    public void setTotalWork(long j) {
        this.totalWork = j;
    }

    public long getWorkCompleted() {
        return this.workCompleted;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public void setPercentDone(int i) {
        this.percentDone = i;
    }

    public Task getCurrentTask() {
        return this.currentTask;
    }

    public void setCurrentTask(Task task) {
        this.currentTask = task;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result2) {
        this.result = result2;
    }

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    public boolean isCancelAllTasks() {
        return this.cancelAllTasks;
    }

    public void setCancelAllTasks(boolean z) {
        this.cancelAllTasks = z;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void setPause(boolean z) {
        this.pause = z;
    }
}
