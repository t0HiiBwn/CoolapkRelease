package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final int bufferSize;
    final FuncN<? extends R> combiner;
    final boolean delayError;
    final Observable<? extends T>[] sources;
    final Iterable<? extends Observable<? extends T>> sourcesIterable;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        this(null, iterable, funcN, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] observableArr, Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN, int i, boolean z) {
        this.sources = observableArr;
        this.sourcesIterable = iterable;
        this.combiner = funcN;
        this.bufferSize = i;
        this.delayError = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    public void call(Subscriber<? super R> subscriber) {
        int i;
        int i2;
        Observable<? extends T>[] observableArr = this.sources;
        if (observableArr == null) {
            Iterable<? extends Observable<? extends T>> iterable = this.sourcesIterable;
            if (iterable instanceof List) {
                List list = (List) iterable;
                observableArr = (Observable[]) list.toArray(new Observable[list.size()]);
                i2 = observableArr.length;
            } else {
                Observable<? extends T>[] observableArr2 = new Observable[8];
                int i3 = 0;
                for (Observable<? extends T> observable : iterable) {
                    if (i3 == observableArr2.length) {
                        Observable<? extends T>[] observableArr3 = new Observable[((i3 >> 2) + i3)];
                        System.arraycopy(observableArr2, 0, observableArr3, 0, i3);
                        observableArr2 = observableArr3;
                    }
                    observableArr2[i3] = observable;
                    i3++;
                }
                observableArr = observableArr2;
                i = i3;
                if (i != 0) {
                    subscriber.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(subscriber, this.combiner, i, this.bufferSize, this.delayError).subscribe(observableArr);
                    return;
                }
            }
        } else {
            i2 = observableArr.length;
        }
        i = i2;
        if (i != 0) {
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final FuncN<? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final Object[] latest;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new CombinerSubscriber[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void subscribe(Observable<? extends T>[] observableArr) {
            CombinerSubscriber<T, R>[] combinerSubscriberArr = this.subscribers;
            int length = combinerSubscriberArr.length;
            for (int i = 0; i < length; i++) {
                combinerSubscriberArr[i] = new CombinerSubscriber<>(this, i);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                observableArr[i2].subscribe((Subscriber<? super Object>) combinerSubscriberArr[i2]);
            }
        }

        @Override // rx.Producer
        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        void cancel(Queue<?> queue2) {
            queue2.clear();
            for (CombinerSubscriber<T, R> combinerSubscriber : this.subscribers) {
                combinerSubscriber.unsubscribe();
            }
        }

        void combine(Object obj, int i) {
            boolean z;
            CombinerSubscriber<T, R> combinerSubscriber = this.subscribers[i];
            synchronized (this) {
                Object[] objArr = this.latest;
                int length = objArr.length;
                Object obj2 = objArr[i];
                int i2 = this.active;
                Object obj3 = MISSING;
                if (obj2 == obj3) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    objArr[i] = NotificationLite.getValue(obj);
                }
                boolean z2 = false;
                z = i2 == length;
                if (i3 == length || (obj == null && obj2 == obj3)) {
                    z2 = true;
                }
                if (z2) {
                    this.done = true;
                } else if (obj != null && z) {
                    this.queue.offer(combinerSubscriber, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                    this.done = true;
                }
            }
            if (z || obj == null) {
                drain();
            } else {
                combinerSubscriber.requestMore(1);
            }
        }

        void drain() {
            long j;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                Subscriber<? super R> subscriber = this.actual;
                boolean z = this.delayError;
                AtomicLong atomicLong = this.requested;
                int i = 1;
                while (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue, z)) {
                    long j2 = atomicLong.get();
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2) {
                            j = j3;
                            break;
                        }
                        boolean z2 = this.done;
                        CombinerSubscriber combinerSubscriber = (CombinerSubscriber) spscLinkedArrayQueue.peek();
                        boolean z3 = combinerSubscriber == null;
                        if (!checkTerminated(z2, z3, subscriber, spscLinkedArrayQueue, z)) {
                            if (z3) {
                                j = j3;
                                break;
                            }
                            spscLinkedArrayQueue.poll();
                            Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                            if (objArr == null) {
                                this.cancelled = true;
                                cancel(spscLinkedArrayQueue);
                                subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                return;
                            }
                            try {
                                subscriber.onNext((Object) this.combiner.call(objArr));
                                combinerSubscriber.requestMore(1);
                                j3++;
                            } catch (Throwable th) {
                                this.cancelled = true;
                                cancel(spscLinkedArrayQueue);
                                subscriber.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                        BackpressureUtils.produced(atomicLong, j);
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue2, boolean z3) {
            if (this.cancelled) {
                cancel(queue2);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancel(queue2);
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onCompleted();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error.get();
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
            }
        }

        void onError(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    th3 = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException(arrayList);
                } else {
                    th3 = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        boolean done;
        final int index;
        final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
            request((long) latestCoordinator.bufferSize);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                this.parent.combine(NotificationLite.next(t), this.index);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.parent.onError(th);
            this.done = true;
            this.parent.combine(null, this.index);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.parent.combine(null, this.index);
            }
        }

        public void requestMore(long j) {
            request(j);
        }
    }
}
