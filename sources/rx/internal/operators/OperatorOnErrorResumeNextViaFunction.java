package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T> implements Observable.Operator<T, T> {
    final Func1<? super Throwable, ? extends Observable<? extends T>> resumeFunction;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(final Func1<? super Throwable, ? extends T> func1) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass1 */

            public Observable<? extends T> call(Throwable th) {
                return Observable.just(func1.call(th));
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(final Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass2 */

            public Observable<? extends T> call(Throwable th) {
                return observable;
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(final Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass3 */

            public Observable<? extends T> call(Throwable th) {
                if (th instanceof Exception) {
                    return observable;
                }
                return Observable.error(th);
            }
        });
    }

    public OperatorOnErrorResumeNextViaFunction(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        this.resumeFunction = func1;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final ProducerArbiter producerArbiter = new ProducerArbiter();
        final SerialSubscription serialSubscription = new SerialSubscription();
        AnonymousClass4 r2 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass4 */
            private boolean done;
            long produced;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    subscriber.onCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (this.done) {
                    Exceptions.throwIfFatal(th);
                    RxJavaHooks.onError(th);
                    return;
                }
                this.done = true;
                try {
                    unsubscribe();
                    AnonymousClass1 r0 = new Subscriber<T>() {
                        /* class rx.internal.operators.OperatorOnErrorResumeNextViaFunction.AnonymousClass4.AnonymousClass1 */

                        @Override // rx.Observer
                        public void onNext(T t) {
                            subscriber.onNext(t);
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th) {
                            subscriber.onError(th);
                        }

                        @Override // rx.Observer
                        public void onCompleted() {
                            subscriber.onCompleted();
                        }

                        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                        public void setProducer(Producer producer) {
                            producerArbiter.setProducer(producer);
                        }
                    };
                    serialSubscription.set(r0);
                    long j = this.produced;
                    if (j != 0) {
                        producerArbiter.produced(j);
                    }
                    ((Observable) OperatorOnErrorResumeNextViaFunction.this.resumeFunction.call(th)).unsafeSubscribe(r0);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, subscriber);
                }
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.done) {
                    this.produced++;
                    subscriber.onNext(t);
                }
            }

            @Override // rx.Subscriber, rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                producerArbiter.setProducer(producer);
            }
        };
        serialSubscription.set(r2);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return r2;
    }
}
