package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class OperatorMaterialize<T> implements Observable.Operator<Notification<T>, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();

        Holder() {
        }
    }

    public static <T> OperatorMaterialize<T> instance() {
        return (OperatorMaterialize<T>) Holder.INSTANCE;
    }

    OperatorMaterialize() {
    }

    public Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorMaterialize.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long j) {
                if (j > 0) {
                    parentSubscriber.requestMore(j);
                }
            }
        });
        return parentSubscriber;
    }

    static class ParentSubscriber<T> extends Subscriber<T> {
        private boolean busy;
        private final Subscriber<? super Notification<T>> child;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();
        private volatile Notification<T> terminalNotification;

        ParentSubscriber(Subscriber<? super Notification<T>> subscriber) {
            this.child = subscriber;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0);
        }

        void requestMore(long j) {
            BackpressureUtils.getAndAddRequest(this.requested, j);
            request(j);
            drain();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.terminalNotification = Notification.createOnCompleted();
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.terminalNotification = Notification.createOnError(th);
            RxJavaHooks.onError(th);
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(Notification.createOnNext(t));
            decrementRequested();
        }

        private void decrementRequested() {
            long j;
            AtomicLong atomicLong = this.requested;
            do {
                j = atomicLong.get();
                if (j == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j - 1));
        }

        private void drain() {
            synchronized (this) {
                if (this.busy) {
                    this.missed = true;
                    return;
                }
                this.busy = true;
            }
            AtomicLong atomicLong = this.requested;
            while (!this.child.isUnsubscribed()) {
                Notification<T> notification = this.terminalNotification;
                if (notification == null || atomicLong.get() <= 0) {
                    synchronized (this) {
                        if (!this.missed) {
                            this.busy = false;
                            return;
                        }
                    }
                } else {
                    this.terminalNotification = null;
                    this.child.onNext(notification);
                    if (!this.child.isUnsubscribed()) {
                        this.child.onCompleted();
                        return;
                    }
                    return;
                }
            }
        }
    }
}
