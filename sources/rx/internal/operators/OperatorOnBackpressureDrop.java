package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.plugins.RxJavaHooks;

public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    final Action1<? super T> onDrop;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return (OperatorOnBackpressureDrop<T>) Holder.INSTANCE;
    }

    OperatorOnBackpressureDrop() {
        this(null);
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.onDrop = action1;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorOnBackpressureDrop.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long j) {
                BackpressureUtils.getAndAddRequest(atomicLong, j);
            }
        });
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorOnBackpressureDrop.AnonymousClass2 */
            boolean done;

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    subscriber.onCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    subscriber.onError(th);
                    return;
                }
                RxJavaHooks.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.done) {
                    if (atomicLong.get() > 0) {
                        subscriber.onNext(t);
                        atomicLong.decrementAndGet();
                    } else if (OperatorOnBackpressureDrop.this.onDrop != null) {
                        try {
                            OperatorOnBackpressureDrop.this.onDrop.call(t);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, this, t);
                        }
                    }
                }
            }
        };
    }
}
