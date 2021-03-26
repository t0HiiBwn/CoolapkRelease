package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public class RxRingBuffer implements Subscription {
    public static final int SIZE;
    private Queue<Object> queue;
    private final int size;
    public volatile Object terminalState;

    static {
        int i = PlatformDependent.isAndroid() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        SIZE = i;
    }

    public static RxRingBuffer getSpscInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(false, SIZE);
        }
        return new RxRingBuffer();
    }

    public static RxRingBuffer getSpmcInstance() {
        if (UnsafeAccess.isUnsafeAvailable()) {
            return new RxRingBuffer(true, SIZE);
        }
        return new RxRingBuffer();
    }

    private RxRingBuffer(Queue<Object> queue2, int i) {
        this.queue = queue2;
        this.size = i;
    }

    private RxRingBuffer(boolean z, int i) {
        this.queue = z ? new SpmcArrayQueue<>(i) : new SpscArrayQueue<>(i);
        this.size = i;
    }

    public synchronized void release() {
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        release();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    RxRingBuffer() {
        this(new SpscAtomicArrayQueue(r1), r1);
        int i = SIZE;
    }

    public void onNext(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue2 = this.queue;
            z = true;
            z2 = false;
            if (queue2 != null) {
                z2 = !queue2.offer(NotificationLite.next(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public void onCompleted() {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.completed();
        }
    }

    public void onError(Throwable th) {
        if (this.terminalState == null) {
            this.terminalState = NotificationLite.error(th);
        }
    }

    public int available() {
        return this.size - count();
    }

    public int capacity() {
        return this.size;
    }

    public int count() {
        Queue<Object> queue2 = this.queue;
        if (queue2 == null) {
            return 0;
        }
        return queue2.size();
    }

    public boolean isEmpty() {
        Queue<Object> queue2 = this.queue;
        return queue2 == null || queue2.isEmpty();
    }

    public Object poll() {
        synchronized (this) {
            Queue<Object> queue2 = this.queue;
            if (queue2 == null) {
                return null;
            }
            Object poll = queue2.poll();
            Object obj = this.terminalState;
            if (poll == null && obj != null && queue2.peek() == null) {
                this.terminalState = null;
                poll = obj;
            }
            return poll;
        }
    }

    public Object peek() {
        synchronized (this) {
            Queue<Object> queue2 = this.queue;
            if (queue2 == null) {
                return null;
            }
            Object peek = queue2.peek();
            Object obj = this.terminalState;
            if (peek == null && obj != null && queue2.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public boolean isCompleted(Object obj) {
        return NotificationLite.isCompleted(obj);
    }

    public boolean isError(Object obj) {
        return NotificationLite.isError(obj);
    }

    public Object getValue(Object obj) {
        return NotificationLite.getValue(obj);
    }

    public boolean accept(Object obj, Observer observer) {
        return NotificationLite.accept(observer, obj);
    }

    public Throwable asError(Object obj) {
        return NotificationLite.getError(obj);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.queue == null;
    }
}
