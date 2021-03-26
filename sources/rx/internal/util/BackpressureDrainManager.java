package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminate(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
        }
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminateAndDrain(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
    }

    @Override // rx.Producer
    public void request(long j) {
        boolean z;
        if (j != 0) {
            while (true) {
                long j2 = get();
                boolean z2 = true;
                z = j2 == 0;
                long j3 = Long.MAX_VALUE;
                if (j2 == Long.MAX_VALUE) {
                    break;
                }
                if (j == Long.MAX_VALUE) {
                    j3 = j;
                } else {
                    if (j2 <= Long.MAX_VALUE - j) {
                        j3 = j2 + j;
                    }
                    z2 = z;
                }
                if (compareAndSet(j2, j3)) {
                    z = z2;
                    break;
                }
            }
            if (z) {
                drain();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0088  */
    public void drain() {
        boolean z;
        boolean z2;
        Throwable th;
        BackpressureQueueCallback backpressureQueueCallback;
        Throwable th2;
        boolean z3;
        synchronized (this) {
            if (!this.emitting) {
                z = true;
                this.emitting = true;
                z2 = this.terminated;
            } else {
                return;
            }
        }
        long j = get();
        try {
            backpressureQueueCallback = this.actual;
            this.emitting = false;
            return;
        } catch (Throwable th3) {
            th = th3;
            z = false;
            if (!z) {
                synchronized (this) {
                    this.emitting = false;
                }
            }
            throw th;
        }
        while (true) {
            int i = 0;
            while (true) {
                int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i2 <= 0 && !z2) {
                    break;
                }
                if (z2) {
                    if (backpressureQueueCallback.peek() != null) {
                        if (i2 == 0) {
                            break;
                        }
                    } else {
                        try {
                            backpressureQueueCallback.complete(this.exception);
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z) {
                            }
                            throw th;
                        }
                    }
                }
                Object poll = backpressureQueueCallback.poll();
                if (poll == null) {
                    break;
                } else if (!backpressureQueueCallback.accept(poll)) {
                    j--;
                    i++;
                } else {
                    return;
                }
            }
            synchronized (this) {
                try {
                    z2 = this.terminated;
                    z3 = backpressureQueueCallback.peek() != null;
                } catch (Throwable th5) {
                    th2 = th5;
                    throw th2;
                }
                if (get() != Long.MAX_VALUE) {
                    long addAndGet = addAndGet((long) (-i));
                    if ((addAndGet == 0 || !z3) && (!z2 || z3)) {
                        break;
                    }
                    j = addAndGet;
                } else if (z3 || z2) {
                    j = Long.MAX_VALUE;
                } else {
                    try {
                        this.emitting = false;
                        return;
                    } catch (Throwable th6) {
                        th2 = th6;
                        throw th2;
                    }
                }
            }
        }
    }
}
