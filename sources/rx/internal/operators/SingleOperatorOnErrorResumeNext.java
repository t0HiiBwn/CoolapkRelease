package rx.internal.operators;

import java.util.Objects;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class SingleOperatorOnErrorResumeNext<T> implements Single.OnSubscribe<T> {
    private final Single<? extends T> originalSingle;
    final Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    private SingleOperatorOnErrorResumeNext(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        Objects.requireNonNull(single, "originalSingle must not be null");
        Objects.requireNonNull(func1, "resumeFunctionInCaseOfError must not be null");
        this.originalSingle = single;
        this.resumeFunctionInCaseOfError = func1;
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withFunction(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        return new SingleOperatorOnErrorResumeNext<>(single, func1);
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withOther(Single<? extends T> single, final Single<? extends T> single2) {
        Objects.requireNonNull(single2, "resumeSingleInCaseOfError must not be null");
        return new SingleOperatorOnErrorResumeNext<>(single, new Func1<Throwable, Single<? extends T>>() {
            /* class rx.internal.operators.SingleOperatorOnErrorResumeNext.AnonymousClass1 */

            public Single<? extends T> call(Throwable th) {
                return single2;
            }
        });
    }

    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        AnonymousClass2 r0 = new SingleSubscriber<T>() {
            /* class rx.internal.operators.SingleOperatorOnErrorResumeNext.AnonymousClass2 */

            @Override // rx.SingleSubscriber
            public void onSuccess(T t) {
                singleSubscriber.onSuccess(t);
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable th) {
                try {
                    ((Single) SingleOperatorOnErrorResumeNext.this.resumeFunctionInCaseOfError.call(th)).subscribe(singleSubscriber);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, singleSubscriber);
                }
            }
        };
        singleSubscriber.add(r0);
        this.originalSingle.subscribe(r0);
    }
}
