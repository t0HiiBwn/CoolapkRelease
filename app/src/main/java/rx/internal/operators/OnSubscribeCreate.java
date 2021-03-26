package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeCreate<T> implements Observable.OnSubscribe<T> {
    final Action1<Emitter<T>> Emitter;
    final Emitter.BackpressureMode backpressure;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeCreate(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.Emitter = action1;
        this.backpressure = backpressureMode;
    }

    /* renamed from: rx.internal.operators.OnSubscribeCreate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$rx$Emitter$BackpressureMode;

        static {
            int[] iArr = new int[Emitter.BackpressureMode.values().length];
            $SwitchMap$rx$Emitter$BackpressureMode = iArr;
            try {
                iArr[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void call(Subscriber<? super T> subscriber) {
        BaseEmitter baseEmitter;
        int i = AnonymousClass1.$SwitchMap$rx$Emitter$BackpressureMode[this.backpressure.ordinal()];
        if (i == 1) {
            baseEmitter = new NoneEmitter(subscriber);
        } else if (i == 2) {
            baseEmitter = new ErrorEmitter(subscriber);
        } else if (i == 3) {
            baseEmitter = new DropEmitter(subscriber);
        } else if (i != 4) {
            baseEmitter = new BufferEmitter(subscriber, RxRingBuffer.SIZE);
        } else {
            baseEmitter = new LatestEmitter(subscriber);
        }
        subscriber.add(baseEmitter);
        subscriber.setProducer(baseEmitter);
        this.Emitter.call(baseEmitter);
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SerialSubscription serial = new SerialSubscription();

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onError(th);
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.Subscription
        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }

        @Override // rx.Subscription
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.Producer
        public final void request(long j) {
            if (BackpressureUtils.validate(j)) {
                BackpressureUtils.getAndAddRequest(this, j);
                onRequested();
            }
        }

        @Override // rx.Emitter
        public final void setSubscription(Subscription subscription) {
            this.serial.set(subscription);
        }

        @Override // rx.Emitter
        public final void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        @Override // rx.Emitter
        public final long requested() {
            return get();
        }
    }

    static final class NoneEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            long j;
            if (!this.actual.isUnsubscribed()) {
                this.actual.onNext(t);
                do {
                    j = get();
                    if (j == 0) {
                        return;
                    }
                } while (!compareAndSet(j, j - 1));
            }
        }
    }

    static abstract class NoOverflowBaseEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        public NoOverflowBaseEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.actual.isUnsubscribed()) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    BackpressureUtils.produced(this, 1);
                    return;
                }
                onOverflow();
            }
        }
    }

    static final class DropEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        @Override // rx.internal.operators.OnSubscribeCreate.NoOverflowBaseEmitter
        void onOverflow() {
        }

        public DropEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    static final class ErrorEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public ErrorEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.internal.operators.OnSubscribeCreate.NoOverflowBaseEmitter, rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                super.onNext(t);
            }
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter, rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                super.onCompleted();
            }
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter, rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.done = true;
            super.onError(th);
        }

        @Override // rx.internal.operators.OnSubscribeCreate.NoOverflowBaseEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class BufferEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public BufferEmitter(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            this.wip = new AtomicInteger();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter, rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.Subscriber */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            int i;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber subscriber = this.actual;
                Queue<Object> queue2 = this.queue;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            queue2.clear();
                            return;
                        } else {
                            boolean z = this.done;
                            Object poll = queue2.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable th = this.error;
                                if (th != null) {
                                    super.onError(th);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(NotificationLite.getValue(poll));
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (subscriber.isUnsubscribed()) {
                            queue2.clear();
                            return;
                        }
                        boolean z3 = this.done;
                        boolean isEmpty = queue2.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureUtils.produced(this, j2);
                    }
                    i2 = this.wip.addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    static final class LatestEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<Object> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        public LatestEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.set(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter, rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: rx.Subscriber */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            boolean z;
            int i;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber subscriber = this.actual;
                AtomicReference<Object> atomicReference = this.queue;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z2 = this.done;
                            Object andSet = atomicReference.getAndSet(null);
                            boolean z3 = andSet == null;
                            if (z2 && z3) {
                                Throwable th = this.error;
                                if (th != null) {
                                    super.onError(th);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(NotificationLite.getValue(andSet));
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (subscriber.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z4 = this.done;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureUtils.produced(this, j2);
                    }
                    i2 = this.wip.addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }
}
