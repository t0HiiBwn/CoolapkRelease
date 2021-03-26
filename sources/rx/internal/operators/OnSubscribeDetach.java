package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeDetach<T> implements Observable.OnSubscribe<T> {
    final Observable<T> source;

    enum TerminatedProducer implements Producer {
        INSTANCE;

        @Override // rx.Producer
        public void request(long j) {
        }
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeDetach(Observable<T> observable) {
        this.source = observable;
    }

    public void call(Subscriber<? super T> subscriber) {
        DetachSubscriber detachSubscriber = new DetachSubscriber(subscriber);
        DetachProducer detachProducer = new DetachProducer(detachSubscriber);
        subscriber.add(detachProducer);
        subscriber.setProducer(detachProducer);
        this.source.unsafeSubscribe(detachSubscriber);
    }

    static final class DetachSubscriber<T> extends Subscriber<T> {
        final AtomicReference<Subscriber<? super T>> actual;
        final AtomicReference<Producer> producer = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        public DetachSubscriber(Subscriber<? super T> subscriber) {
            this.actual = new AtomicReference<>(subscriber);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            Subscriber<? super T> subscriber = this.actual.get();
            if (subscriber != null) {
                subscriber.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th);
            } else {
                RxJavaHooks.onError(th);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        void innerRequest(long j) {
            if (j >= 0) {
                Producer producer2 = this.producer.get();
                if (producer2 != null) {
                    producer2.request(j);
                    return;
                }
                BackpressureUtils.getAndAddRequest(this.requested, j);
                Producer producer3 = this.producer.get();
                if (producer3 != null && producer3 != TerminatedProducer.INSTANCE) {
                    producer3.request(this.requested.getAndSet(0));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer2) {
            if (this.producer.compareAndSet(null, producer2)) {
                producer2.request(this.requested.getAndSet(0));
            } else if (this.producer.get() != TerminatedProducer.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }

        void innerUnsubscribe() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            this.actual.lazySet(null);
            unsubscribe();
        }
    }

    static final class DetachProducer<T> implements Producer, Subscription {
        final DetachSubscriber<T> parent;

        public DetachProducer(DetachSubscriber<T> detachSubscriber) {
            this.parent = detachSubscriber;
        }

        @Override // rx.Producer
        public void request(long j) {
            this.parent.innerRequest(j);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.parent.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.parent.innerUnsubscribe();
        }
    }
}
