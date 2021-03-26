package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return (OperatorOnBackpressureLatest<T>) Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }

    static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        @Override // rx.Producer
        public void request(long j) {
            long j2;
            int i;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        i = (j2 > -4611686018427387904L ? 1 : (j2 == -4611686018427387904L ? 0 : -1));
                        if (i == 0) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                if (i == 0) {
                    this.parent.requestMore(Long.MAX_VALUE);
                }
                emit();
            }
        }

        long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        void emit() {
            boolean z;
            boolean z2;
            Throwable th;
            Throwable th2;
            Object obj;
            synchronized (this) {
                z = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                } else {
                    this.emitting = true;
                    this.missed = false;
                }
            }
            while (true) {
                try {
                    long j = get();
                    if (j != Long.MIN_VALUE) {
                        Object obj2 = this.value.get();
                        if (j > 0 && obj2 != (obj = EMPTY)) {
                            this.child.onNext(obj2);
                            this.value.compareAndSet(obj2, obj);
                            produced(1);
                            obj2 = obj;
                        }
                        if (obj2 == EMPTY && this.done) {
                            Throwable th3 = this.terminal;
                            if (th3 != null) {
                                this.child.onError(th3);
                            } else {
                                this.child.onCompleted();
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    this.emitting = false;
                                    try {
                                        return;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                    }
                                } else {
                                    this.missed = false;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                z = false;
                                try {
                                    throw th2;
                                } catch (Throwable th6) {
                                    z2 = z;
                                    th = th6;
                                }
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    z2 = false;
                    if (!z2) {
                        synchronized (this) {
                            this.emitting = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }

    static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.producer.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.producer.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.onCompleted();
        }

        void requestMore(long j) {
            request(j);
        }
    }
}
