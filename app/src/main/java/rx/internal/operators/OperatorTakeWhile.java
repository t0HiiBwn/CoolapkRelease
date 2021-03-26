package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorTakeWhile<T> implements Observable.Operator<T, T> {
    final Func2<? super T, ? super Integer, Boolean> predicate;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorTakeWhile(final Func1<? super T, Boolean> func1) {
        this(new Func2<T, Integer, Boolean>() {
            /* class rx.internal.operators.OperatorTakeWhile.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
                return call((AnonymousClass1) obj, num);
            }

            public Boolean call(T t, Integer num) {
                return (Boolean) Func1.this.call(t);
            }
        });
    }

    public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> func2) {
        this.predicate = func2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass2 r0 = new Subscriber<T>(false, subscriber) {
            /* class rx.internal.operators.OperatorTakeWhile.AnonymousClass2 */
            private int counter;
            private boolean done;

            @Override // rx.Observer
            public void onNext(T t) {
                try {
                    Func2<? super T, ? super Integer, Boolean> func2 = OperatorTakeWhile.this.predicate;
                    int i = this.counter;
                    this.counter = i + 1;
                    if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                        subscriber.onNext(t);
                        return;
                    }
                    this.done = true;
                    subscriber.onCompleted();
                    unsubscribe();
                } catch (Throwable th) {
                    this.done = true;
                    Exceptions.throwOrReport(th, subscriber, t);
                    unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    subscriber.onCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (!this.done) {
                    subscriber.onError(th);
                }
            }
        };
        subscriber.add(r0);
        return r0;
    }
}
