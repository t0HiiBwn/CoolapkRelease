package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Observable;
import rx.Subscriber;

public class OperatorSkipLast<T> implements Observable.Operator<T, T> {
    final int count;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorSkipLast(int i) {
        if (i >= 0) {
            this.count = i;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorSkipLast.AnonymousClass1 */
            private final Deque<Object> deque = new ArrayDeque();

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: rx.Subscriber */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                if (OperatorSkipLast.this.count == 0) {
                    subscriber.onNext(t);
                    return;
                }
                if (this.deque.size() == OperatorSkipLast.this.count) {
                    subscriber.onNext(NotificationLite.getValue(this.deque.removeFirst()));
                } else {
                    request(1);
                }
                this.deque.offerLast(NotificationLite.next(t));
            }
        };
    }
}
