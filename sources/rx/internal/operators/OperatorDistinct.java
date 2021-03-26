package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class OperatorDistinct<T, U> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends U> keySelector;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorDistinct<?, ?> INSTANCE = new OperatorDistinct<>(UtilityFunctions.identity());

        Holder() {
        }
    }

    public static <T> OperatorDistinct<T, T> instance() {
        return (OperatorDistinct<T, T>) Holder.INSTANCE;
    }

    public OperatorDistinct(Func1<? super T, ? extends U> func1) {
        this.keySelector = func1;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorDistinct.AnonymousClass1 */
            Set<U> keyMemory = new HashSet();

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Set<U> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                if (this.keyMemory.add(OperatorDistinct.this.keySelector.call(t))) {
                    subscriber.onNext(t);
                } else {
                    request(1);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                this.keyMemory = null;
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.keyMemory = null;
                subscriber.onCompleted();
            }
        };
    }
}
