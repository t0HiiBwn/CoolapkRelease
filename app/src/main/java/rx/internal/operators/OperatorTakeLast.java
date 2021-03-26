package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeLast<T> implements Observable.Operator<T, T> {
    final int count;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorTakeLast(int i) {
        if (i >= 0) {
            this.count = i;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastSubscriber takeLastSubscriber = new TakeLastSubscriber(subscriber, this.count);
        subscriber.add(takeLastSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorTakeLast.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long j) {
                takeLastSubscriber.requestMore(j);
            }
        });
        return takeLastSubscriber;
    }

    static final class TakeLastSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        final Subscriber<? super T> actual;
        final int count;
        final ArrayDeque<Object> queue = new ArrayDeque<>();
        final AtomicLong requested = new AtomicLong();

        public TakeLastSubscriber(Subscriber<? super T> subscriber, int i) {
            this.actual = subscriber;
            this.count = i;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.queue.size() == this.count) {
                this.queue.poll();
            }
            this.queue.offer(NotificationLite.next(t));
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.queue.clear();
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        @Override // rx.functions.Func1
        public T call(Object obj) {
            return (T) NotificationLite.getValue(obj);
        }

        void requestMore(long j) {
            if (j > 0) {
                BackpressureUtils.postCompleteRequest(this.requested, j, this.queue, this.actual, this);
            }
        }
    }
}
