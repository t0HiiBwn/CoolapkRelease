package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.RxRingBuffer;

public final class BlockingOperatorToIterator {
    private BlockingOperatorToIterator() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> toIterator(Observable<? extends T> observable) {
        SubscriberIterator subscriberIterator = new SubscriberIterator();
        observable.materialize().subscribe((Subscriber<? super Notification<? extends T>>) subscriberIterator);
        return subscriberIterator;
    }

    public static final class SubscriberIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        static final int LIMIT = ((RxRingBuffer.SIZE * 3) / 4);
        private Notification<? extends T> buf;
        private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
        private int received;

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Notification) ((Notification) obj));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.notifications.offer(Notification.createOnError(th));
        }

        public void onNext(Notification<? extends T> notification) {
            this.notifications.offer(notification);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.buf == null) {
                this.buf = take();
                int i = this.received + 1;
                this.received = i;
                if (i >= LIMIT) {
                    request((long) i);
                    this.received = 0;
                }
            }
            if (!this.buf.isOnError()) {
                return !this.buf.isOnCompleted();
            }
            throw Exceptions.propagate(this.buf.getThrowable());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) this.buf.getValue();
                this.buf = null;
                return t;
            }
            throw new NoSuchElementException();
        }

        private Notification<? extends T> take() {
            try {
                Notification<? extends T> poll = this.notifications.poll();
                if (poll != null) {
                    return poll;
                }
                return this.notifications.take();
            } catch (InterruptedException e) {
                unsubscribe();
                throw Exceptions.propagate(e);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }
}
