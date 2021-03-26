package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T> implements Observable.Operator<T, T> {
    final Func2<? super T, Integer, Boolean> predicate;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> func2) {
        this.predicate = func2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorSkipWhile.AnonymousClass1 */
            int index;
            boolean skipping = true;

            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.skipping) {
                    subscriber.onNext(t);
                    return;
                }
                try {
                    Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.predicate;
                    int i = this.index;
                    this.index = i + 1;
                    if (!func2.call(t, Integer.valueOf(i)).booleanValue()) {
                        this.skipping = false;
                        subscriber.onNext(t);
                        return;
                    }
                    request(1);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber, t);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }
        };
    }

    public static <T> Func2<T, Integer, Boolean> toPredicate2(final Func1<? super T, Boolean> func1) {
        return new Func2<T, Integer, Boolean>() {
            /* class rx.internal.operators.OperatorSkipWhile.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
                return call((AnonymousClass2) obj, num);
            }

            public Boolean call(T t, Integer num) {
                return (Boolean) func1.call(t);
            }
        };
    }
}
