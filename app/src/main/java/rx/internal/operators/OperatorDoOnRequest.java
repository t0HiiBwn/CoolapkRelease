package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorDoOnRequest<T> implements Observable.Operator<T, T> {
    final Action1<? super Long> request;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorDoOnRequest(Action1<? super Long> action1) {
        this.request = action1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorDoOnRequest.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long j) {
                OperatorDoOnRequest.this.request.call(Long.valueOf(j));
                parentSubscriber.requestMore(j);
            }
        });
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }

    static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;

        ParentSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            request(0);
        }

        /* access modifiers changed from: private */
        public void requestMore(long j) {
            request(j);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(t);
        }
    }
}
