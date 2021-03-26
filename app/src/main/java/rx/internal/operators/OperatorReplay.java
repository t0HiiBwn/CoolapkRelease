package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public final class OperatorReplay<T> extends ConnectableObservable<T> implements Subscription {
    static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() {
        /* class rx.internal.operators.OperatorReplay.AnonymousClass1 */

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Func0<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Observable<? extends T> source;

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> func0, final Func1<? super Observable<U>, ? extends Observable<R>> func1) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.functions.Func1 */
            /* JADX WARN: Multi-variable type inference failed */
            public void call(final Subscriber<? super R> subscriber) {
                try {
                    ConnectableObservable connectableObservable = (ConnectableObservable) func0.call();
                    ((Observable) func1.call(connectableObservable)).subscribe((Subscriber) subscriber);
                    connectableObservable.connect(new Action1<Subscription>() {
                        /* class rx.internal.operators.OperatorReplay.AnonymousClass2.AnonymousClass1 */

                        public void call(Subscription subscription) {
                            subscriber.add(subscription);
                        }
                    });
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        final Observable<T> observeOn = connectableObservable.observeOn(scheduler);
        return new ConnectableObservable<T>(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass3 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super T> subscriber) {
                observeOn.unsafeSubscribe(new Subscriber<T>(subscriber) {
                    /* class rx.internal.operators.OperatorReplay.AnonymousClass3.AnonymousClass1 */

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
                });
            }
        }) {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass4 */

            @Override // rx.observables.ConnectableObservable
            public void connect(Action1<? super Subscription> action1) {
                connectableObservable.connect(action1);
            }
        };
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        return create(observable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final int i) {
        if (i == Integer.MAX_VALUE) {
            return create(observable);
        }
        return create(observable, new Func0<ReplayBuffer<T>>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass5 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(i);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j, TimeUnit timeUnit, final Scheduler scheduler, final int i) {
        final long millis = timeUnit.toMillis(j);
        return create(observable, new Func0<ReplayBuffer<T>>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass6 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i, millis, scheduler);
            }
        });
    }

    static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final Func0<? extends ReplayBuffer<T>> func0) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new Observable.OnSubscribe<T>() {
            /* class rx.internal.operators.OperatorReplay.AnonymousClass7 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super T> subscriber) {
                ReplaySubscriber replaySubscriber;
                while (true) {
                    replaySubscriber = (ReplaySubscriber) atomicReference.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) func0.call());
                    replaySubscriber2.init();
                    if (atomicReference.compareAndSet(replaySubscriber, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(replaySubscriber, subscriber);
                replaySubscriber.add((InnerProducer) innerProducer);
                subscriber.add(innerProducer);
                replaySubscriber.buffer.replay(innerProducer);
                subscriber.setProducer(innerProducer);
            }
        }, observable, atomicReference, func0);
    }

    private OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<ReplaySubscriber<T>> atomicReference, Func0<? extends ReplayBuffer<T>> func0) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
        this.bufferFactory = func0;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.current.lazySet(null);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        ReplaySubscriber<T> replaySubscriber = this.current.get();
        return replaySubscriber == null || replaySubscriber.isUnsubscribed();
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> action1) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>((ReplayBuffer) this.bufferFactory.call());
            replaySubscriber2.init();
            if (this.current.compareAndSet(replaySubscriber, replaySubscriber2)) {
                replaySubscriber = replaySubscriber2;
                break;
            }
        }
        boolean z = true;
        if (replaySubscriber.shouldConnect.get() || !replaySubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        action1.call(replaySubscriber);
        if (z) {
            this.source.unsafeSubscribe(replaySubscriber);
        }
    }

    static final class ReplaySubscriber<T> extends Subscriber<T> implements Subscription {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final ReplayBuffer<T> buffer;
        boolean coordinateAll;
        List<InnerProducer<T>> coordinationQueue;
        boolean done;
        boolean emitting;
        long maxChildRequested;
        long maxUpstreamRequested;
        boolean missed;
        volatile Producer producer;
        final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        InnerProducer<T>[] producersCache = EMPTY;
        long producersCacheVersion;
        volatile long producersVersion;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        volatile boolean terminated;

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            request(0);
        }

        void init() {
            add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorReplay.ReplaySubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    if (!ReplaySubscriber.this.terminated) {
                        synchronized (ReplaySubscriber.this.producers) {
                            if (!ReplaySubscriber.this.terminated) {
                                ReplaySubscriber.this.producers.terminate();
                                ReplaySubscriber.this.producersVersion++;
                                ReplaySubscriber.this.terminated = true;
                            }
                        }
                    }
                }
            }));
        }

        boolean add(InnerProducer<T> innerProducer) {
            Objects.requireNonNull(innerProducer);
            if (this.terminated) {
                return false;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return false;
                }
                this.producers.add(innerProducer);
                this.producersVersion++;
                return true;
            }
        }

        void remove(InnerProducer<T> innerProducer) {
            if (!this.terminated) {
                synchronized (this.producers) {
                    if (!this.terminated) {
                        this.producers.remove(innerProducer);
                        if (this.producers.isEmpty()) {
                            this.producersCache = EMPTY;
                        }
                        this.producersVersion++;
                    }
                }
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer2) {
            if (this.producer == null) {
                this.producer = producer2;
                manageRequests(null);
                replay();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.error(th);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        void manageRequests(InnerProducer<T> innerProducer) {
            long j;
            List<InnerProducer<T>> list;
            boolean z;
            long j2;
            if (!isUnsubscribed()) {
                synchronized (this) {
                    if (this.emitting) {
                        if (innerProducer != null) {
                            List list2 = this.coordinationQueue;
                            if (list2 == null) {
                                list2 = new ArrayList();
                                this.coordinationQueue = list2;
                            }
                            list2.add(innerProducer);
                        } else {
                            this.coordinateAll = true;
                        }
                        this.missed = true;
                        return;
                    }
                    this.emitting = true;
                }
                long j3 = this.maxChildRequested;
                if (innerProducer != null) {
                    j = Math.max(j3, innerProducer.totalRequested.get());
                } else {
                    InnerProducer<T>[] copyProducers = copyProducers();
                    long j4 = j3;
                    for (InnerProducer<T> innerProducer2 : copyProducers) {
                        if (innerProducer2 != null) {
                            j4 = Math.max(j4, innerProducer2.totalRequested.get());
                        }
                    }
                    j = j4;
                }
                makeRequest(j, j3);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        list = this.coordinationQueue;
                        this.coordinationQueue = null;
                        z = this.coordinateAll;
                        this.coordinateAll = false;
                    }
                    long j5 = this.maxChildRequested;
                    if (list != null) {
                        j2 = j5;
                        for (InnerProducer<T> innerProducer3 : list) {
                            j2 = Math.max(j2, innerProducer3.totalRequested.get());
                        }
                    } else {
                        j2 = j5;
                    }
                    if (z) {
                        InnerProducer<T>[] copyProducers2 = copyProducers();
                        for (InnerProducer<T> innerProducer4 : copyProducers2) {
                            if (innerProducer4 != null) {
                                j2 = Math.max(j2, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    makeRequest(j2, j5);
                }
            }
        }

        InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.producers) {
                InnerProducer<T>[] values = this.producers.values();
                int length = values.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(values, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        void makeRequest(long j, long j2) {
            long j3 = this.maxUpstreamRequested;
            Producer producer2 = this.producer;
            long j4 = j - j2;
            if (j4 != 0) {
                this.maxChildRequested = j;
                if (producer2 == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.maxUpstreamRequested = j5;
                } else if (j3 != 0) {
                    this.maxUpstreamRequested = 0;
                    producer2.request(j3 + j4);
                } else {
                    producer2.request(j4);
                }
            } else if (j3 != 0 && producer2 != null) {
                this.maxUpstreamRequested = 0;
                producer2.request(j3);
            }
        }

        void replay() {
            InnerProducer<T>[] innerProducerArr = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    innerProducerArr = this.producersCache;
                    InnerProducer<T>[] values = this.producers.values();
                    int length = values.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.producersCache = innerProducerArr;
                    }
                    System.arraycopy(values, 0, innerProducerArr, 0, length);
                    this.producersCacheVersion = this.producersVersion;
                }
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    replayBuffer.replay(innerProducer);
                }
            }
        }
    }

    static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
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
                        if (j2 < 0 || i != 0) {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                addTotalRequested(j);
                this.parent.manageRequests(this);
                this.parent.buffer.replay(this);
            }
        }

        void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
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
                this.parent.manageRequests(this);
                this.child = null;
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.completed());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void replay(InnerProducer<T> innerProducer) {
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
            }
            while (!innerProducer.isUnsubscribed()) {
                int i = this.size;
                Integer num = (Integer) innerProducer.index();
                int intValue = num != null ? num.intValue() : 0;
                Subscriber<? super T> subscriber = innerProducer.child;
                if (subscriber != null) {
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (!NotificationLite.accept(subscriber, obj) && !innerProducer.isUnsubscribed()) {
                                intValue++;
                                j2++;
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            innerProducer.unsubscribe();
                            if (!NotificationLite.isError(obj) && !NotificationLite.isCompleted(obj)) {
                                subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.getValue(obj)));
                                return;
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            innerProducer.produced(j2);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                } else {
                    return;
                }
            }
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        void truncate() {
        }

        void truncateFinal() {
        }

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void removeSome(int i) {
            Node node = (Node) get();
            while (i > 0) {
                node = (Node) node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        final void setFirst(Node node) {
            set(node);
        }

        Node getInitialHead() {
            return (Node) get();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.completed());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void replay(InnerProducer<T> innerProducer) {
            Subscriber<? super T> subscriber;
            Node node;
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
            }
            while (!innerProducer.isUnsubscribed()) {
                Node node2 = (Node) innerProducer.index();
                if (node2 == null) {
                    node2 = getInitialHead();
                    innerProducer.index = node2;
                    innerProducer.addTotalRequested(node2.index);
                }
                if (!innerProducer.isUnsubscribed() && (subscriber = innerProducer.child) != null) {
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && (node = (Node) node2.get()) != null) {
                        Object leaveTransform = leaveTransform(node.value);
                        try {
                            if (NotificationLite.accept(subscriber, leaveTransform)) {
                                innerProducer.index = null;
                                return;
                            }
                            j2++;
                            if (!innerProducer.isUnsubscribed()) {
                                node2 = node;
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            innerProducer.index = null;
                            Exceptions.throwIfFatal(th);
                            innerProducer.unsubscribe();
                            if (!NotificationLite.isError(leaveTransform) && !NotificationLite.isCompleted(leaveTransform)) {
                                subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.getValue(leaveTransform)));
                                return;
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = node2;
                        if (j != Long.MAX_VALUE) {
                            innerProducer.produced(j2);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                } else {
                    return;
                }
            }
        }

        final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = (Node) initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!NotificationLite.isCompleted(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add((Object) NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.isError(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.isCompleted(leaveTransform(this.tail.value));
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, Scheduler scheduler2) {
            this.scheduler = scheduler2;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new Timestamped(this.scheduler.now(), obj);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((Timestamped) obj).getValue();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Node getInitialHead() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Object obj = node.get();
            while (true) {
                node = (Node) obj;
                if (node == null) {
                    break;
                }
                Object obj2 = node.value;
                Object leaveTransform = leaveTransform(obj2);
                if (NotificationLite.isCompleted(leaveTransform) || NotificationLite.isError(leaveTransform) || ((Timestamped) obj2).getTimestampMillis() > now) {
                    break;
                }
                obj = node.get();
            }
            return node;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                node = node2;
                if (node != null) {
                    if (this.size <= this.limit) {
                        if (((Timestamped) node.value).getTimestampMillis() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node2 = (Node) node.get();
                    } else {
                        i++;
                        this.size--;
                        node2 = (Node) node.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncateFinal() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                node = node2;
                if (node == null || this.size <= 1 || ((Timestamped) node.value).getTimestampMillis() > now) {
                    break;
                }
                i++;
                this.size--;
                node2 = (Node) node.get();
            }
            if (i != 0) {
                setFirst(node);
            }
        }
    }
}
