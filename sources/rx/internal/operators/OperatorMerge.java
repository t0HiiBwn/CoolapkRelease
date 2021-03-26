package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        return z ? (OperatorMerge<T>) HolderDelayErrors.INSTANCE : (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
        } else if (i == Integer.MAX_VALUE) {
            return instance(z);
        } else {
            return new OperatorMerge<>(z, i);
        }
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        @Override // rx.Producer
        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                if (get() != Long.MAX_VALUE) {
                    BackpressureUtils.getAndAddRequest(this, j);
                    this.subscriber.emit();
                }
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public long produced(int i) {
            return addAndGet((long) (-i));
        }
    }

    static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Observable) ((Observable) obj));
        }

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.scalarEmissionLimit = Math.max(1, i >> 1);
            request((long) i);
        }

        Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        CompositeSubscription getOrCreateComposite() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.subscriptions;
            if (compositeSubscription2 != null) {
                return compositeSubscription2;
            }
            boolean z = false;
            synchronized (this) {
                compositeSubscription = this.subscriptions;
                if (compositeSubscription == null) {
                    CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                    this.subscriptions = compositeSubscription3;
                    compositeSubscription = compositeSubscription3;
                    z = true;
                }
            }
            if (z) {
                add(compositeSubscription);
            }
            return compositeSubscription;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$MergeSubscriber<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(Observable<? extends T> observable) {
            if (observable != null) {
                if (observable == Observable.empty()) {
                    emitEmpty();
                } else if (observable instanceof ScalarSynchronousObservable) {
                    tryEmit(((ScalarSynchronousObservable) observable).get());
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    addInner(innerSubscriber);
                    observable.unsafeSubscribe(innerSubscriber);
                    emit();
                }
            }
        }

        void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) i);
                return;
            }
            this.scalarEmissionCount = i;
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.OperatorMerge$InnerSubscriber<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerSubscriber.equals(innerSubscriberArr[i2])) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.innerSubscribers = EMPTY;
                        return;
                    }
                    InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length - 1)];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                    this.innerSubscribers = innerSubscriberArr2;
                }
            }
        }

        void tryEmit(InnerSubscriber<T> innerSubscriber, T t) {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                if (rxRingBuffer == null || rxRingBuffer.isEmpty()) {
                    emitScalar(innerSubscriber, t, j);
                    return;
                }
                queueScalar(innerSubscriber, t);
                emitLoop();
                return;
            }
            queueScalar(innerSubscriber, t);
            emit();
        }

        protected void queueScalar(InnerSubscriber<T> innerSubscriber, T t) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(rxRingBuffer);
                innerSubscriber.queue = rxRingBuffer;
            }
            try {
                rxRingBuffer.onNext(NotificationLite.next(t));
            } catch (MissingBackpressureException e) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e);
            } catch (IllegalStateException e2) {
                if (!innerSubscriber.isUnsubscribed()) {
                    innerSubscriber.unsubscribe();
                    innerSubscriber.onError(e2);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x004a  */
        protected void emitScalar(InnerSubscriber<T> innerSubscriber, T t, long j) {
            Throwable th;
            boolean z = true;
            try {
                this.child.onNext(t);
            } catch (Throwable th2) {
                th = th2;
                if (!z) {
                }
                throw th;
            }
            if (j != Long.MAX_VALUE) {
                this.producer.produced(1);
            }
            innerSubscriber.requestMore(1);
            synchronized (this) {
                if (!this.missed) {
                    this.emitting = false;
                    return;
                }
                this.missed = false;
                emitLoop();
            }
        }

        public void requestMore(long j) {
            request(j);
        }

        void tryEmit(T t) {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue2 = this.queue;
                if (queue2 == null || queue2.isEmpty()) {
                    emitScalar(t, j);
                    return;
                }
                queueScalar(t);
                emitLoop();
                return;
            }
            queueScalar(t);
            emit();
        }

        protected void queueScalar(T t) {
            Queue<Object> queue2;
            Queue<Object> queue3 = this.queue;
            if (queue3 == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    queue3 = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (!Pow2.isPowerOfTwo(i)) {
                        queue2 = new SpscExactAtomicArrayQueue<>(i);
                    } else if (UnsafeAccess.isUnsafeAvailable()) {
                        queue2 = new SpscArrayQueue<>(i);
                    } else {
                        queue2 = new SpscAtomicArrayQueue<>(i);
                    }
                    queue3 = queue2;
                }
                this.queue = queue3;
            }
            if (!queue3.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x0055  */
        protected void emitScalar(T t, long j) {
            Throwable th;
            boolean z = true;
            try {
                this.child.onNext(t);
            } catch (Throwable th2) {
                th = th2;
                if (!z) {
                }
                throw th;
            }
            if (j != Long.MAX_VALUE) {
                this.producer.produced(1);
            }
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) i);
            } else {
                this.scalarEmissionCount = i;
            }
            synchronized (this) {
                if (!this.missed) {
                    this.emitting = false;
                    return;
                }
                this.missed = false;
                emitLoop();
            }
        }

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:147:0x0193, code lost:
            r0 = th;
         */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x019b  */
        void emitLoop() {
            boolean z;
            Throwable th;
            long j;
            int i;
            boolean z2;
            Throwable th2;
            int i2;
            try {
                Subscriber<? super T> subscriber = this.child;
                while (!checkTerminate()) {
                    Queue<Object> queue2 = this.queue;
                    long j2 = this.producer.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
                    if (queue2 != null) {
                        int i3 = 0;
                        while (true) {
                            j = j2;
                            int i4 = 0;
                            i = i3;
                            Object obj = null;
                            while (true) {
                                if (j <= 0) {
                                    break;
                                }
                                Object poll = queue2.poll();
                                if (!checkTerminate()) {
                                    if (poll == null) {
                                        obj = poll;
                                        break;
                                    }
                                    try {
                                        subscriber.onNext((Object) NotificationLite.getValue(poll));
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = true;
                                        if (!z) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                    i++;
                                    i4++;
                                    j--;
                                    obj = poll;
                                } else {
                                    return;
                                }
                            }
                            if (i4 > 0) {
                                j = z3 ? Long.MAX_VALUE : this.producer.produced(i4);
                            }
                            if (j == 0 || obj == null) {
                                break;
                            }
                            i3 = i;
                            j2 = j;
                        }
                    } else {
                        j = j2;
                        i = 0;
                    }
                    boolean z4 = this.done;
                    Queue<Object> queue3 = this.queue;
                    InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                    int length = innerSubscriberArr.length;
                    if (!z4 || ((queue3 != null && !queue3.isEmpty()) || length != 0)) {
                        if (length > 0) {
                            long j3 = this.lastId;
                            int i5 = this.lastIndex;
                            if (length <= i5 || innerSubscriberArr[i5].id != j3) {
                                if (length <= i5) {
                                    i5 = 0;
                                }
                                for (int i6 = 0; i6 < length && innerSubscriberArr[i5].id != j3; i6++) {
                                    i5++;
                                    if (i5 == length) {
                                        i5 = 0;
                                    }
                                }
                                this.lastIndex = i5;
                                this.lastId = innerSubscriberArr[i5].id;
                            }
                            z2 = false;
                            for (int i7 = 0; i7 < length; i7++) {
                                if (!checkTerminate()) {
                                    InnerSubscriber<?> innerSubscriber = innerSubscriberArr[i5];
                                    Object obj2 = null;
                                    do {
                                        int i8 = 0;
                                        while (j > 0) {
                                            if (!checkTerminate()) {
                                                RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                                                if (rxRingBuffer == null || (obj2 = rxRingBuffer.poll()) == null) {
                                                    break;
                                                }
                                                try {
                                                    subscriber.onNext((Object) NotificationLite.getValue(obj2));
                                                    j--;
                                                    i8++;
                                                } catch (Throwable th4) {
                                                    unsubscribe();
                                                    throw th4;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (i8 > 0) {
                                            j = !z3 ? this.producer.produced(i8) : Long.MAX_VALUE;
                                            innerSubscriber.requestMore((long) i8);
                                        }
                                        i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                                        if (i2 == 0) {
                                            break;
                                        }
                                    } while (obj2 != null);
                                    boolean z5 = innerSubscriber.done;
                                    RxRingBuffer rxRingBuffer2 = innerSubscriber.queue;
                                    if (z5 && (rxRingBuffer2 == null || rxRingBuffer2.isEmpty())) {
                                        removeInner(innerSubscriber);
                                        if (!checkTerminate()) {
                                            i++;
                                            z2 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (i2 == 0) {
                                        break;
                                    }
                                    i5++;
                                    if (i5 == length) {
                                        i5 = 0;
                                    }
                                } else {
                                    return;
                                }
                            }
                            this.lastIndex = i5;
                            this.lastId = innerSubscriberArr[i5].id;
                        } else {
                            z2 = false;
                        }
                        if (i > 0) {
                            request((long) i);
                        }
                        if (!z2) {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        try {
                                            this.emitting = false;
                                            return;
                                        } catch (Throwable th5) {
                                            th2 = th5;
                                            z = true;
                                            while (true) {
                                                try {
                                                    break;
                                                } catch (Throwable th6) {
                                                    th2 = th6;
                                                }
                                            }
                                            throw th2;
                                        }
                                    } else {
                                        this.missed = false;
                                    }
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    z = false;
                                    while (true) {
                                        break;
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } else {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
                        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                            subscriber.onCompleted();
                            return;
                        } else {
                            reportError();
                            return;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                z = false;
                if (!z) {
                }
                throw th;
            }
        }

        boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = (RxRingBuffer.SIZE / 4);
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        @Override // rx.Subscriber
        public void onStart() {
            this.outstanding = RxRingBuffer.SIZE;
            request((long) RxRingBuffer.SIZE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.parent.tryEmit(this, t);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.parent.getOrCreateErrorQueue().offer(th);
            this.done = true;
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        public void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > LIMIT) {
                this.outstanding = i;
                return;
            }
            this.outstanding = RxRingBuffer.SIZE;
            int i2 = RxRingBuffer.SIZE - i;
            if (i2 > 0) {
                request((long) i2);
            }
        }
    }
}
