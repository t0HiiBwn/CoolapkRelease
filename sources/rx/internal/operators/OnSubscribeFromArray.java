package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeFromArray<T> implements Observable.OnSubscribe<T> {
    final T[] array;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.array = tArr;
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.setProducer(new FromArrayProducer(subscriber, this.array));
    }

    static final class FromArrayProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;
        final T[] array;
        final Subscriber<? super T> child;
        int index;

        public FromArrayProducer(Subscriber<? super T> subscriber, T[] tArr) {
            this.child = subscriber;
            this.array = tArr;
        }

        @Override // rx.Producer
        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (j == Long.MAX_VALUE) {
                if (BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    fastPath();
                }
            } else if (i != 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                slowPath(j);
            }
        }

        void fastPath() {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            for (T t : tArr) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(t);
                } else {
                    return;
                }
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }

        void slowPath(long j) {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (j == 0 || i == length) {
                        j = get() + j2;
                        if (j == 0) {
                            this.index = i;
                            j = addAndGet(j2);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(tArr[i]);
                        i++;
                        if (i != length) {
                            j--;
                            j2--;
                        } else if (!subscriber.isUnsubscribed()) {
                            subscriber.onCompleted();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }
}
