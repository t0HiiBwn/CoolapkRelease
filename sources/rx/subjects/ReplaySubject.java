package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final ReplayState<T> state;

    interface ReplayBuffer<T> {
        void complete();

        void drain(ReplayProducer<T> replayProducer);

        Throwable error();

        void error(Throwable th);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t);

        int size();

        T[] toArray(T[] tArr);
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    public static <T> ReplaySubject<T> create(int i) {
        if (i > 0) {
            return new ReplaySubject<>(new ReplayState(new ReplayUnboundedBuffer(i)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i);
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(Integer.MAX_VALUE)));
    }

    static <T> ReplaySubject<T> createUnboundedTime() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(Integer.MAX_VALUE, Long.MAX_VALUE, Schedulers.immediate())));
    }

    public static <T> ReplaySubject<T> createWithSize(int i) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(i)));
    }

    public static <T> ReplaySubject<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return createWithTimeAndSize(j, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(i, timeUnit.toMillis(j), scheduler)));
    }

    ReplaySubject(ReplayState<T> replayState) {
        super(replayState);
        this.state = replayState;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.state.onNext(t);
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.state.onError(th);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.state.onCompleted();
    }

    int subscriberCount() {
        return ((ReplayProducer[]) this.state.get()).length;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return ((ReplayProducer[]) this.state.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.state.isTerminated() && this.state.buffer.error() != null;
    }

    public boolean hasCompleted() {
        return this.state.isTerminated() && this.state.buffer.error() == null;
    }

    public Throwable getThrowable() {
        if (this.state.isTerminated()) {
            return this.state.buffer.error();
        }
        return null;
    }

    public int size() {
        return this.state.buffer.size();
    }

    public boolean hasAnyValue() {
        return !this.state.buffer.isEmpty();
    }

    public boolean hasValue() {
        return hasAnyValue();
    }

    public T[] getValues(T[] tArr) {
        return this.state.buffer.toArray(tArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.subjects.ReplaySubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public T getValue() {
        return this.state.buffer.last();
    }

    static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        final ReplayBuffer<T> buffer;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public ReplayState(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            lazySet(EMPTY);
        }

        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(subscriber, this);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!add(replayProducer) || !replayProducer.isUnsubscribed()) {
                this.buffer.drain(replayProducer);
            } else {
                remove(replayProducer);
            }
        }

        boolean add(ReplayProducer<T> replayProducer) {
            ReplayProducer[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = (ReplayProducer[]) get();
                if (replayProducerArr == TERMINATED) {
                    return false;
                }
                int length = replayProducerArr.length;
                replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
            return true;
        }

        void remove(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = (ReplayProducer[]) get();
                if (replayProducerArr != TERMINATED && replayProducerArr != EMPTY) {
                    int length = replayProducerArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayProducerArr[i2] == replayProducer) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            replayProducerArr2 = EMPTY;
                        } else {
                            ReplayProducer[] replayProducerArr3 = new ReplayProducer[(length - 1)];
                            System.arraycopy(replayProducerArr, 0, replayProducerArr3, 0, i);
                            System.arraycopy(replayProducerArr, i + 1, replayProducerArr3, i, (length - i) - 1);
                            replayProducerArr2 = replayProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
        }

        @Override // rx.Observer
        public void onNext(T t) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.next(t);
            for (ReplayProducer<T> replayProducer : (ReplayProducer[]) get()) {
                replayBuffer.drain(replayProducer);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.error(th);
            ArrayList arrayList = null;
            for (ReplayProducer<T> replayProducer : (ReplayProducer[]) getAndSet(TERMINATED)) {
                try {
                    replayBuffer.drain(replayProducer);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }

        @Override // rx.Observer
        public void onCompleted() {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.complete();
            for (ReplayProducer<T> replayProducer : (ReplayProducer[]) getAndSet(TERMINATED)) {
                replayBuffer.drain(replayProducer);
            }
        }

        boolean isTerminated() {
            return get() == TERMINATED;
        }
    }

    static final class ReplayUnboundedBuffer<T> implements ReplayBuffer<T> {
        final int capacity;
        volatile boolean done;
        Throwable error;
        final Object[] head;
        volatile int size;
        Object[] tail;
        int tailIndex;

        public ReplayUnboundedBuffer(int i) {
            this.capacity = i;
            Object[] objArr = new Object[(i + 1)];
            this.head = objArr;
            this.tail = objArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            if (!this.done) {
                int i = this.tailIndex;
                Object[] objArr = this.tail;
                if (i == objArr.length - 1) {
                    Object[] objArr2 = new Object[objArr.length];
                    objArr2[0] = t;
                    this.tailIndex = 1;
                    objArr[i] = objArr2;
                    this.tail = objArr2;
                } else {
                    objArr[i] = t;
                    this.tailIndex = i + 1;
                }
                this.size++;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> replayProducer) {
            int i;
            if (replayProducer.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replayProducer.actual;
                int i2 = this.capacity;
                int i3 = 1;
                do {
                    long j = replayProducer.requested.get();
                    Object[] objArr = (Object[]) replayProducer.node;
                    if (objArr == null) {
                        objArr = this.head;
                    }
                    int i4 = replayProducer.tailIndex;
                    int i5 = replayProducer.index;
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        } else {
                            boolean z = this.done;
                            boolean z2 = i5 == this.size;
                            if (z && z2) {
                                replayProducer.node = null;
                                Throwable th = this.error;
                                if (th != null) {
                                    subscriber.onError(th);
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                if (i4 == i2) {
                                    objArr = (Object[]) objArr[i4];
                                    i4 = 0;
                                }
                                subscriber.onNext(objArr[i4]);
                                j2++;
                                i4++;
                                i5++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (subscriber.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        }
                        boolean z3 = this.done;
                        boolean z4 = i5 == this.size;
                        if (z3 && z4) {
                            replayProducer.node = null;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        BackpressureUtils.produced(replayProducer.requested, j2);
                    }
                    replayProducer.index = i5;
                    replayProducer.tailIndex = i4;
                    replayProducer.node = objArr;
                    i3 = replayProducer.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            Object[] objArr = this.head;
            int i2 = this.capacity;
            while (i >= i2) {
                objArr = objArr[i2];
                i -= i2;
            }
            return (T) objArr[i - 1];
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            int i = this.size;
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            Object[] objArr = this.head;
            int i2 = this.capacity;
            int i3 = 0;
            while (true) {
                int i4 = i3 + i2;
                if (i4 >= i) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i3, i2);
                objArr = objArr[i2];
                i3 = i4;
            }
            System.arraycopy(objArr, 0, tArr, i3, i - i3);
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }
    }

    static final class ReplaySizeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int limit;
        int size;
        Node<T> tail;

        public ReplaySizeBoundBuffer(int i) {
            this.limit = i;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            Node<T> node = new Node<>(t);
            this.tail.set(node);
            this.tail = node;
            int i = this.size;
            if (i == this.limit) {
                this.head = (Node) this.head.get();
            } else {
                this.size = i + 1;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th) {
            this.error = th;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> replayProducer) {
            boolean z;
            int i;
            if (replayProducer.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replayProducer.actual;
                int i2 = 1;
                do {
                    long j = replayProducer.requested.get();
                    Node<T> node = (Node) replayProducer.node;
                    if (node == null) {
                        node = this.head;
                    }
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        } else {
                            boolean z2 = this.done;
                            Node<T> node2 = (Node) node.get();
                            boolean z3 = node2 == null;
                            if (z2 && z3) {
                                replayProducer.node = null;
                                Throwable th = this.error;
                                if (th != null) {
                                    subscriber.onError(th);
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(node2.value);
                                j2++;
                                node = node2;
                            }
                        }
                    }
                    if (i == 0) {
                        if (subscriber.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        }
                        boolean z4 = this.done;
                        if (node.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            replayProducer.node = null;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        BackpressureUtils.produced(replayProducer.requested, j2);
                    }
                    replayProducer.node = node;
                    i2 = replayProducer.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final T value;

            public Node(T t) {
                this.value = t;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            Node node = (Node) this.head.get();
            int i = 0;
            while (node != null && i != Integer.MAX_VALUE) {
                node = (Node) node.get();
                i++;
            }
            return i;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.head.get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (Node node = (Node) this.head.get(); node != null; node = (Node) node.get()) {
                arrayList.add(node.value);
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static final class ReplaySizeAndTimeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final int limit;
        final long maxAgeMillis;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;

        public ReplaySizeAndTimeBoundBuffer(int i, long j, Scheduler scheduler2) {
            this.limit = i;
            TimedNode<T> timedNode = new TimedNode<>(null, 0);
            this.tail = timedNode;
            this.head = timedNode;
            this.maxAgeMillis = j;
            this.scheduler = scheduler2;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            TimedNode<T> timedNode;
            long now = this.scheduler.now();
            TimedNode<T> timedNode2 = new TimedNode<>(t, now);
            this.tail.set(timedNode2);
            this.tail = timedNode2;
            long j = now - this.maxAgeMillis;
            int i = this.size;
            TimedNode<T> timedNode3 = this.head;
            if (i == this.limit) {
                timedNode = (TimedNode) timedNode3.get();
            } else {
                i++;
                timedNode = timedNode3;
            }
            while (true) {
                TimedNode<T> timedNode4 = (TimedNode) timedNode.get();
                if (timedNode4 == null || timedNode4.timestamp > j) {
                    break;
                }
                i--;
                timedNode = timedNode4;
            }
            this.size = i;
            if (timedNode != timedNode3) {
                this.head = timedNode;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th) {
            evictFinal();
            this.error = th;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            evictFinal();
            this.done = true;
        }

        void evictFinal() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            TimedNode<T> timedNode2 = timedNode;
            while (true) {
                TimedNode<T> timedNode3 = (TimedNode) timedNode2.get();
                if (timedNode3 == null || timedNode3.timestamp > now) {
                    break;
                }
                timedNode2 = timedNode3;
            }
            if (timedNode != timedNode2) {
                this.head = timedNode2;
            }
        }

        TimedNode<T> latestHead() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null || timedNode2.timestamp > now) {
                    break;
                }
                timedNode = timedNode2;
            }
            return timedNode;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> replayProducer) {
            boolean z;
            int i;
            if (replayProducer.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replayProducer.actual;
                int i2 = 1;
                do {
                    long j = replayProducer.requested.get();
                    TimedNode<T> timedNode = (TimedNode) replayProducer.node;
                    if (timedNode == null) {
                        timedNode = latestHead();
                    }
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        } else {
                            boolean z2 = this.done;
                            TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                            boolean z3 = timedNode2 == null;
                            if (z2 && z3) {
                                replayProducer.node = null;
                                Throwable th = this.error;
                                if (th != null) {
                                    subscriber.onError(th);
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(timedNode2.value);
                                j2++;
                                timedNode = timedNode2;
                            }
                        }
                    }
                    if (i == 0) {
                        if (subscriber.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        }
                        boolean z4 = this.done;
                        if (timedNode.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            replayProducer.node = null;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onCompleted();
                                return;
                            }
                        }
                    }
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        BackpressureUtils.produced(replayProducer.requested, j2);
                    }
                    replayProducer.node = timedNode;
                    i2 = replayProducer.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final long timestamp;
            final T value;

            public TimedNode(T t, long j) {
                this.value = t;
                this.timestamp = j;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            TimedNode<T> latestHead = latestHead();
            while (true) {
                TimedNode<T> timedNode = (TimedNode) latestHead.get();
                if (timedNode == null) {
                    return latestHead.value;
                }
                latestHead = timedNode;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            TimedNode timedNode = (TimedNode) latestHead().get();
            int i = 0;
            while (timedNode != null && i != Integer.MAX_VALUE) {
                timedNode = (TimedNode) timedNode.get();
                i++;
            }
            return i;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return latestHead().get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (TimedNode timedNode = (TimedNode) latestHead().get(); timedNode != null; timedNode = (TimedNode) timedNode.get()) {
                arrayList.add(timedNode.value);
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static final class ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        final Subscriber<? super T> actual;
        int index;
        Object node;
        final AtomicLong requested = new AtomicLong();
        final ReplayState<T> state;
        int tailIndex;

        public ReplayProducer(Subscriber<? super T> subscriber, ReplayState<T> replayState) {
            this.actual = subscriber;
            this.state = replayState;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.state.remove(this);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.Producer
        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                this.state.buffer.drain(this);
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
        }
    }
}
