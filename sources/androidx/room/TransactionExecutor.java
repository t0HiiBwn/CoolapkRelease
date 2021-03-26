package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    TransactionExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() {
            /* class androidx.room.TransactionExecutor.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }
}
