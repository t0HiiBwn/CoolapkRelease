package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    public static <T> CachedObservable<T> from(Observable<? extends T> observable) {
        return from(observable, 16);
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable, int i) {
        if (i >= 1) {
            CacheState cacheState = new CacheState(observable, i);
            return new CachedObservable<>(new CachedSubscribe(cacheState), cacheState);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    boolean hasObservers() {
        return this.state.producers.length != 0;
    }

    static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection = new SerialSubscription();
        volatile boolean isConnected;
        volatile ReplayProducer<?>[] producers = EMPTY;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i) {
            super(i);
            this.source = observable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.CachedObservable$ReplayProducer<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void addProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.producers = replayProducerArr2;
            }
        }

        public void removeProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replayProducerArr[i2].equals(replayProducer)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.producers = EMPTY;
                        return;
                    }
                    ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length - 1)];
                    System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i);
                    System.arraycopy(replayProducerArr, i + 1, replayProducerArr2, i, (length - i) - 1);
                    this.producers = replayProducerArr2;
                }
            }
        }

        public void connect() {
            AnonymousClass1 r0 = new Subscriber<T>() {
                /* class rx.internal.operators.CachedObservable.CacheState.AnonymousClass1 */

                @Override // rx.Observer
                public void onNext(T t) {
                    CacheState.this.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    CacheState.this.onError(th);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    CacheState.this.onCompleted();
                }
            };
            this.connection.set(r0);
            this.source.unsafeSubscribe(r0);
            this.isConnected = true;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t));
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        void dispatch() {
            for (ReplayProducer<?> replayProducer : this.producers) {
                replayProducer.replay();
            }
        }
    }

    static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public CachedSubscribe(CacheState<T> cacheState) {
            this.state = cacheState;
        }

        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(subscriber, this.state);
            this.state.addProducer(replayProducer);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        @Override // rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = Long.MAX_VALUE;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            replay();
        }

        public long produced(long j) {
            return addAndGet(-j);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.state.removeProducer(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:89:0x00dd  */
        public void replay() {
            boolean z;
            boolean z2;
            Throwable th;
            Throwable th2;
            Throwable th3;
            synchronized (this) {
                z = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
            }
            try {
                Subscriber<? super T> subscriber = this.child;
                while (true) {
                    long j = get();
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i >= 0) {
                        int size = this.state.size();
                        if (size != 0) {
                            Object[] objArr = this.currentBuffer;
                            if (objArr == null) {
                                objArr = this.state.head();
                                this.currentBuffer = objArr;
                            }
                            int length = objArr.length - 1;
                            int i2 = this.index;
                            int i3 = this.currentIndexInBuffer;
                            if (i == 0) {
                                Object obj = objArr[i3];
                                if (NotificationLite.isCompleted(obj)) {
                                    subscriber.onCompleted();
                                    try {
                                        unsubscribe();
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z2 = true;
                                        if (!z2) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                } else if (NotificationLite.isError(obj)) {
                                    subscriber.onError(NotificationLite.getError(obj));
                                    unsubscribe();
                                    return;
                                }
                            } else if (i > 0) {
                                int i4 = 0;
                                while (i2 < size && j > 0) {
                                    if (!subscriber.isUnsubscribed()) {
                                        if (i3 == length) {
                                            objArr = (Object[]) objArr[length];
                                            i3 = 0;
                                        }
                                        Object obj2 = objArr[i3];
                                        try {
                                            if (NotificationLite.accept(subscriber, obj2)) {
                                                try {
                                                    unsubscribe();
                                                    return;
                                                } catch (Throwable th5) {
                                                    th3 = th5;
                                                    z2 = true;
                                                    try {
                                                        Exceptions.throwIfFatal(th3);
                                                        unsubscribe();
                                                        if (!NotificationLite.isError(obj2) && !NotificationLite.isCompleted(obj2)) {
                                                            subscriber.onError(OnErrorThrowable.addValueAsLastCause(th3, NotificationLite.getValue(obj2)));
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        if (!z2) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                            } else {
                                                i3++;
                                                i2++;
                                                j--;
                                                i4++;
                                            }
                                        } catch (Throwable th7) {
                                            th3 = th7;
                                            z2 = false;
                                            Exceptions.throwIfFatal(th3);
                                            unsubscribe();
                                            if (!NotificationLite.isError(obj2)) {
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if (!subscriber.isUnsubscribed()) {
                                    this.index = i2;
                                    this.currentIndexInBuffer = i3;
                                    this.currentBuffer = objArr;
                                    produced((long) i4);
                                } else {
                                    return;
                                }
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    this.emitting = false;
                                    try {
                                        return;
                                    } catch (Throwable th8) {
                                        th2 = th8;
                                        try {
                                            throw th2;
                                        } catch (Throwable th9) {
                                            z2 = z;
                                            th = th9;
                                        }
                                    }
                                } else {
                                    this.missed = false;
                                }
                            } catch (Throwable th10) {
                                th2 = th10;
                                z = false;
                                throw th2;
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                z2 = false;
                if (!z2) {
                }
                throw th;
            }
        }
    }
}
