package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    protected OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i;
    }

    public void call(Subscriber<? super R> subscriber) {
        final FlattenIterableSubscriber flattenIterableSubscriber = new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch);
        subscriber.add(flattenIterableSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeFlattenIterable.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long j) {
                flattenIterableSubscriber.requestMore(j);
            }
        });
        this.source.unsafeSubscribe(flattenIterableSubscriber);
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        if (observable instanceof ScalarSynchronousObservable) {
            return Observable.unsafeCreate(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) observable).get(), func1));
        }
        return Observable.unsafeCreate(new OnSubscribeFlattenIterable(observable, func1, i));
    }

    static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        long produced;
        final Queue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            if (i == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = (long) (i - (i >> 2));
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(i);
                } else {
                    this.queue = new SpscAtomicArrayQueue(i);
                }
            }
            request((long) i);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaHooks.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void requestMore(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            } else if (i < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ca, code lost:
            if (r0 != null) goto L_0x00cf;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00af  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0010 A[SYNTHETIC] */
        void drain() {
            Iterator<? extends R> it2;
            int i;
            long j;
            long j2;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                Queue<?> queue2 = this.queue;
                int i2 = 1;
                while (true) {
                    it2 = this.active;
                    boolean z = false;
                    if (it2 == null) {
                        boolean z2 = this.done;
                        Object poll = queue2.poll();
                        boolean z3 = poll == null;
                        if (!checkTerminated(z2, z3, subscriber, queue2)) {
                            if (!z3) {
                                long j3 = this.produced + 1;
                                i = i2;
                                if (j3 == this.limit) {
                                    this.produced = 0;
                                    request(j3);
                                } else {
                                    this.produced = j3;
                                }
                                try {
                                    it2 = ((Iterable) this.mapper.call((Object) NotificationLite.getValue(poll))).iterator();
                                    if (it2.hasNext()) {
                                        this.active = it2;
                                        if (it2 != null) {
                                            j = this.requested.get();
                                            j2 = 0;
                                            while (true) {
                                                if (j2 == j) {
                                                    break;
                                                } else if (!checkTerminated(this.done, false, subscriber, queue2)) {
                                                    try {
                                                        subscriber.onNext((Object) it2.next());
                                                        if (!checkTerminated(this.done, false, subscriber, queue2)) {
                                                            j2++;
                                                            try {
                                                                if (!it2.hasNext()) {
                                                                    this.active = null;
                                                                    break;
                                                                }
                                                            } catch (Throwable th) {
                                                                Exceptions.throwIfFatal(th);
                                                                this.active = null;
                                                                onError(th);
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } catch (Throwable th2) {
                                                        Exceptions.throwIfFatal(th2);
                                                        this.active = null;
                                                        onError(th2);
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            if (j2 == j) {
                                                boolean z4 = this.done;
                                                if (queue2.isEmpty() && it2 == null) {
                                                    z = true;
                                                }
                                                if (checkTerminated(z4, z, subscriber, queue2)) {
                                                    return;
                                                }
                                            }
                                            if (j2 != 0) {
                                                BackpressureUtils.produced(this.requested, j2);
                                            }
                                        }
                                        i2 = this.wip.addAndGet(-i);
                                        if (i2 != 0) {
                                            return;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    onError(th3);
                                }
                                i2 = i;
                            }
                        } else {
                            return;
                        }
                    }
                    i = i2;
                    if (it2 != null) {
                    }
                    i2 = this.wip.addAndGet(-i);
                    if (i2 != 0) {
                    }
                }
            } else {
                return;
            }
            it2 = null;
            if (j2 == j) {
            }
            if (j2 != 0) {
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue2) {
            if (subscriber.isUnsubscribed()) {
                queue2.clear();
                this.active = null;
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    queue2.clear();
                    this.active = null;
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onCompleted();
                    return true;
                }
            }
        }
    }

    static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public OnSubscribeScalarFlattenIterable(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.value = t;
            this.mapper = func1;
        }

        public void call(Subscriber<? super R> subscriber) {
            try {
                Iterator<T> it2 = ((Iterable) this.mapper.call(this.value)).iterator();
                if (!it2.hasNext()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(subscriber, it2));
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, subscriber, this.value);
            }
        }
    }
}
