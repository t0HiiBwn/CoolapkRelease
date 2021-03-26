package rx.internal.operators;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends T> is;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.is = iterable;
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it2 = this.is.iterator();
            boolean hasNext = it2.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new IterableProducer(subscriber, it2));
            }
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
        }
    }

    static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;

        /* renamed from: it  reason: collision with root package name */
        private final Iterator<? extends T> f1516it;
        private final Subscriber<? super T> o;

        IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it2) {
            this.o = subscriber;
            this.f1516it = it2;
        }

        @Override // rx.Producer
        public void request(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        void slowPath(long j) {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it2 = this.f1516it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            j = BackpressureUtils.produced(this, j2);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        try {
                            subscriber.onNext((Object) it2.next());
                            if (!subscriber.isUnsubscribed()) {
                                try {
                                    if (it2.hasNext()) {
                                        j2++;
                                    } else if (!subscriber.isUnsubscribed()) {
                                        subscriber.onCompleted();
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwOrReport(th, subscriber);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }

        void fastPath() {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it2 = this.f1516it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext((Object) it2.next());
                    if (!subscriber.isUnsubscribed()) {
                        try {
                            if (!it2.hasNext()) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, subscriber);
                    return;
                }
            }
        }
    }
}
