package rx.internal.operators;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorPublish.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super T> subscriber) {
                while (true) {
                    PublishSubscriber publishSubscriber = (PublishSubscriber) atomicReference.get();
                    if (publishSubscriber == null || publishSubscriber.isUnsubscribed()) {
                        PublishSubscriber publishSubscriber2 = new PublishSubscriber(atomicReference);
                        publishSubscriber2.init();
                        if (!atomicReference.compareAndSet(publishSubscriber, publishSubscriber2)) {
                            continue;
                        } else {
                            publishSubscriber = publishSubscriber2;
                        }
                    }
                    InnerProducer<T> innerProducer = new InnerProducer<>(publishSubscriber, subscriber);
                    if (publishSubscriber.add((InnerProducer) innerProducer)) {
                        subscriber.add(innerProducer);
                        subscriber.setProducer(innerProducer);
                        return;
                    }
                }
            }
        }, observable, atomicReference);
    }

    public static <T, R> Observable<R> create(Observable<? extends T> observable, Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return create(observable, func1, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> observable, final Func1<? super Observable<T>, ? extends Observable<R>> func1, final boolean z) {
        return unsafeCreate(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorPublish.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: rx.functions.Func1 */
            /* JADX WARN: Multi-variable type inference failed */
            public void call(final Subscriber<? super R> subscriber) {
                final OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.SIZE, z);
                AnonymousClass1 r1 = new Subscriber<R>() {
                    /* class rx.internal.operators.OperatorPublish.AnonymousClass2.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onNext(R r) {
                        subscriber.onNext(r);
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onError(th);
                    }

                    @Override // rx.Observer
                    public void onCompleted() {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onCompleted();
                    }

                    @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                    public void setProducer(Producer producer) {
                        subscriber.setProducer(producer);
                    }
                };
                subscriber.add(onSubscribePublishMulticast);
                subscriber.add(r1);
                ((Observable) func1.call(Observable.unsafeCreate(onSubscribePublishMulticast))).unsafeSubscribe(r1);
                observable.unsafeSubscribe(onSubscribePublishMulticast.subscriber());
            }
        });
    }

    private OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<PublishSubscriber<T>> atomicReference) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> action1) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isUnsubscribed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current);
            publishSubscriber2.init();
            if (this.current.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = true;
        if (publishSubscriber.shouldConnect.get() || !publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        action1.call(publishSubscriber);
        if (z) {
            this.source.unsafeSubscribe(publishSubscriber);
        }
    }

    static final class PublishSubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference) {
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue<>(RxRingBuffer.SIZE) : new SpscAtomicArrayQueue<>(RxRingBuffer.SIZE);
            this.producers = new AtomicReference<>(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        void init() {
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorPublish.PublishSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    PublishSubscriber.this.producers.getAndSet(PublishSubscriber.TERMINATED);
                    PublishSubscriber.this.current.compareAndSet(PublishSubscriber.this, null);
                }
            }));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.queue.offer(NotificationLite.next(t))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.completed();
                dispatch();
            }
        }

        boolean add(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            Objects.requireNonNull(innerProducer);
            do {
                innerProducerArr = this.producers.get();
                if (innerProducerArr == TERMINATED) {
                    return false;
                }
                int length = innerProducerArr.length;
                innerProducerArr2 = new InnerProducer[(length + 1)];
                System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                innerProducerArr2[length] = innerProducer;
            } while (!this.producers.compareAndSet(innerProducerArr, innerProducerArr2));
            return true;
        }

        void remove(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.producers.get();
                if (innerProducerArr != EMPTY && innerProducerArr != TERMINATED) {
                    int i = -1;
                    int length = innerProducerArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerProducerArr[i2].equals(innerProducer)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerProducerArr2 = EMPTY;
                        } else {
                            InnerProducer[] innerProducerArr3 = new InnerProducer[(length - 1)];
                            System.arraycopy(innerProducerArr, 0, innerProducerArr3, 0, i);
                            System.arraycopy(innerProducerArr, i + 1, innerProducerArr3, i, (length - i) - 1);
                            innerProducerArr2 = innerProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.producers.compareAndSet(innerProducerArr, innerProducerArr2));
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isCompleted(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet = this.producers.getAndSet(TERMINATED);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet2 = this.producers.getAndSet(TERMINATED);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onCompleted();
                            i++;
                        }
                        return true;
                    } finally {
                        unsubscribe();
                    }
                }
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c3, code lost:
            if (r4 == false) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x00dc, code lost:
            r0 = th;
         */
        void dispatch() {
            boolean z;
            Throwable th;
            long j;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                } else {
                    this.emitting = true;
                    this.missed = false;
                }
            }
            while (true) {
                try {
                    Object obj = this.terminalEvent;
                    boolean isEmpty = this.queue.isEmpty();
                    if (!checkTerminated(obj, isEmpty)) {
                        if (!isEmpty) {
                            InnerProducer[] innerProducerArr = this.producers.get();
                            int length = innerProducerArr.length;
                            long j2 = Long.MAX_VALUE;
                            int i = 0;
                            for (InnerProducer innerProducer : innerProducerArr) {
                                long j3 = innerProducer.get();
                                if (j3 >= 0) {
                                    j2 = Math.min(j2, j3);
                                } else if (j3 == Long.MIN_VALUE) {
                                    i++;
                                }
                            }
                            if (length != i) {
                                int i2 = 0;
                                while (true) {
                                    j = (long) i2;
                                    if (j >= j2) {
                                        break;
                                    }
                                    Object obj2 = this.terminalEvent;
                                    Object poll = this.queue.poll();
                                    boolean z2 = poll == null;
                                    if (!checkTerminated(obj2, z2)) {
                                        if (z2) {
                                            isEmpty = z2;
                                            break;
                                        }
                                        Object value = NotificationLite.getValue(poll);
                                        for (InnerProducer innerProducer2 : innerProducerArr) {
                                            if (innerProducer2.get() > 0) {
                                                try {
                                                    innerProducer2.child.onNext(value);
                                                    innerProducer2.produced(1);
                                                } catch (Throwable th2) {
                                                    innerProducer2.unsubscribe();
                                                    Exceptions.throwOrReport(th2, innerProducer2.child, value);
                                                }
                                            }
                                        }
                                        i2++;
                                        isEmpty = z2;
                                    } else {
                                        return;
                                    }
                                }
                                if (i2 > 0) {
                                    request(j);
                                }
                                if (j2 != 0) {
                                }
                            } else if (!checkTerminated(this.terminalEvent, this.queue.poll() == null)) {
                                request(1);
                            } else {
                                return;
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    this.emitting = false;
                                    try {
                                        return;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        }
                                        throw th;
                                    }
                                } else {
                                    this.missed = false;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                z = false;
                                while (true) {
                                    break;
                                }
                                throw th;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th6) {
                    Throwable th7 = th6;
                    z = false;
                    if (!z) {
                        synchronized (this) {
                            this.emitting = false;
                        }
                    }
                    throw th7;
                }
            }
        }
    }

    static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> publishSubscriber, Subscriber<? super T> subscriber) {
            this.parent = publishSubscriber;
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        @Override // rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 >= 0 && i == 0) {
                            return;
                        }
                        if (j2 == -4611686018427387904L) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.dispatch();
            }
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == -4611686018427387904L) {
                        throw new IllegalStateException("Produced without request");
                    } else if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    } else {
                        j3 = j2 - j;
                        if (j3 < 0) {
                            throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                        }
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.dispatch();
            }
        }
    }
}
