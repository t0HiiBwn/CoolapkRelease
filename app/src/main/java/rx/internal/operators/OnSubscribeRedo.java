package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T> implements Observable.OnSubscribe<T> {
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1<Observable<? extends Notification<?>>, Observable<?>>() {
        /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass1 */

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<?> */
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return (Observable<R>) observable.map(new Func1<Notification<?>, Notification<?>>() {
                /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass1.AnonymousClass1 */

                public Notification<?> call(Notification<?> notification) {
                    return Notification.createOnNext(null);
                }
            });
        }
    };
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
    private final Scheduler scheduler;
    final Observable<T> source;
    final boolean stopOnComplete;
    final boolean stopOnError;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public static final class RedoFinite implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final long count;

        public RedoFinite(long j) {
            this.count = j;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.Observable<T2>, rx.Observable<?> */
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return (Observable<T2>) observable.map(new Func1<Notification<?>, Notification<?>>() {
                /* class rx.internal.operators.OnSubscribeRedo.RedoFinite.AnonymousClass1 */
                int num;

                public Notification<?> call(Notification<?> notification) {
                    if (RedoFinite.this.count == 0) {
                        return notification;
                    }
                    int i = this.num + 1;
                    this.num = i;
                    return ((long) i) <= RedoFinite.this.count ? Notification.createOnNext(Integer.valueOf(this.num)) : notification;
                }
            }).dematerialize();
        }
    }

    public static final class RetryWithPredicate implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>> {
        final Func2<Integer, Throwable, Boolean> predicate;

        public RetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
            this.predicate = func2;
        }

        public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> observable) {
            return observable.scan(Notification.createOnNext(0), new Func2<Notification<Integer>, Notification<?>, Notification<Integer>>() {
                /* class rx.internal.operators.OnSubscribeRedo.RetryWithPredicate.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.Notification<?> */
                /* JADX WARN: Multi-variable type inference failed */
                public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                    int intValue = notification.getValue().intValue();
                    return RetryWithPredicate.this.predicate.call(Integer.valueOf(intValue), notification2.getThrowable()).booleanValue() ? Notification.createOnNext(Integer.valueOf(intValue + 1)) : notification2;
                }
            });
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable) {
        return retry(observable, REDO_INFINITE);
    }

    public static <T> Observable<T> retry(Observable<T> observable, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 expected");
        } else if (i == 0) {
            return observable;
        } else {
            return retry(observable, new RedoFinite(j));
        }
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, true, false, Schedulers.trampoline()));
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, true, false, scheduler2));
    }

    public static <T> Observable<T> repeat(Observable<T> observable) {
        return repeat(observable, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Scheduler scheduler2) {
        return repeat(observable, REDO_INFINITE, scheduler2);
    }

    public static <T> Observable<T> repeat(Observable<T> observable, long j) {
        return repeat(observable, j, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> observable, long j, Scheduler scheduler2) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return Observable.empty();
        }
        if (i >= 0) {
            return repeat(observable, new RedoFinite(j - 1), scheduler2);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, true, Schedulers.trampoline()));
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, true, scheduler2));
    }

    public static <T> Observable<T> redo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler2) {
        return Observable.unsafeCreate(new OnSubscribeRedo(observable, func1, false, false, scheduler2));
    }

    private OnSubscribeRedo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z, boolean z2, Scheduler scheduler2) {
        this.source = observable;
        this.controlHandlerFunction = func1;
        this.stopOnComplete = z;
        this.stopOnError = z2;
        this.scheduler = scheduler2;
    }

    public void call(final Subscriber<? super T> subscriber) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicLong atomicLong = new AtomicLong();
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        final SerializedSubject serialized = BehaviorSubject.create().toSerialized();
        serialized.subscribe((Subscriber) Subscribers.empty());
        final ProducerArbiter producerArbiter = new ProducerArbiter();
        final AnonymousClass2 r12 = new Action0() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                if (!subscriber.isUnsubscribed()) {
                    AnonymousClass1 r0 = new Subscriber<T>() {
                        /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass2.AnonymousClass1 */
                        boolean done;

                        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.subjects.Subject */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // rx.Observer
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serialized.onNext(Notification.createOnCompleted());
                            }
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.subjects.Subject */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // rx.Observer
                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                unsubscribe();
                                serialized.onNext(Notification.createOnError(th));
                            }
                        }

                        @Override // rx.Observer
                        public void onNext(T t) {
                            if (!this.done) {
                                subscriber.onNext(t);
                                decrementConsumerCapacity();
                                producerArbiter.produced(1);
                            }
                        }

                        private void decrementConsumerCapacity() {
                            long j;
                            do {
                                j = atomicLong.get();
                                if (j == Long.MAX_VALUE) {
                                    return;
                                }
                            } while (!atomicLong.compareAndSet(j, j - 1));
                        }

                        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                        public void setProducer(Producer producer) {
                            producerArbiter.setProducer(producer);
                        }
                    };
                    serialSubscription.set(r0);
                    OnSubscribeRedo.this.source.unsafeSubscribe(r0);
                }
            }
        };
        final Observable observable = (Observable) this.controlHandlerFunction.call(serialized.lift(new Observable.Operator<Notification<?>, Notification<?>>() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass3 */

            public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> subscriber) {
                return new Subscriber<Notification<?>>(subscriber) {
                    /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass3.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    public void onNext(Notification<?> notification) {
                        if (notification.isOnCompleted() && OnSubscribeRedo.this.stopOnComplete) {
                            subscriber.onCompleted();
                        } else if (!notification.isOnError() || !OnSubscribeRedo.this.stopOnError) {
                            subscriber.onNext(notification);
                        } else {
                            subscriber.onError(notification.getThrowable());
                        }
                    }

                    @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                    public void setProducer(Producer producer) {
                        producer.request(Long.MAX_VALUE);
                    }
                };
            }
        }));
        createWorker.schedule(new Action0() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass4 */

            @Override // rx.functions.Action0
            public void call() {
                observable.unsafeSubscribe(new Subscriber<Object>(subscriber) {
                    /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass4.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        subscriber.onError(th);
                    }

                    @Override // rx.Observer
                    public void onNext(Object obj) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (atomicLong.get() > 0) {
                            createWorker.schedule(r12);
                        } else {
                            atomicBoolean.compareAndSet(false, true);
                        }
                    }

                    @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                    public void setProducer(Producer producer) {
                        producer.request(Long.MAX_VALUE);
                    }
                });
            }
        });
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeRedo.AnonymousClass5 */

            @Override // rx.Producer
            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.getAndAddRequest(atomicLong, j);
                    producerArbiter.request(j);
                    if (atomicBoolean.compareAndSet(true, false)) {
                        createWorker.schedule(r12);
                    }
                }
            }
        });
    }
}
