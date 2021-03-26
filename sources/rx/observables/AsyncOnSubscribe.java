package rx.observables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {
    protected abstract S generateState();

    protected abstract S next(S s, long j, Observer<Observable<? extends T>> observer);

    protected void onUnsubscribe(S s) {
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object obj, Long l, Object obj2) {
                return call((AnonymousClass1) obj, l, (Observer) ((Observer) obj2));
            }

            public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object obj, Long l, Object obj2) {
                return call((AnonymousClass2) obj, l, (Observer) ((Observer) obj2));
            }

            public S call(S s, Long l, Observer<Observable<? extends T>> observer) {
                action3.call(s, l, observer);
                return s;
            }
        }, action1);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, func3, action1);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new AsyncOnSubscribeImpl(func0, func3);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Void call(Void r1, Long l, Object obj) {
                return call(r1, l, (Observer) ((Observer) obj));
            }

            public Void call(Void r2, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return r2;
            }
        });
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2, final Action0 action0) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Void call(Void r1, Long l, Object obj) {
                return call(r1, l, (Observer) ((Observer) obj));
            }

            public Void call(Void r1, Long l, Observer<Observable<? extends T>> observer) {
                action2.call(l, observer);
                return null;
            }
        }, new Action1<Void>() {
            /* class rx.observables.AsyncOnSubscribe.AnonymousClass5 */

            public void call(Void r1) {
                action0.call();
            }
        });
    }

    static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        @Override // rx.observables.AsyncOnSubscribe, rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            AsyncOnSubscribe.super.call((Subscriber) ((Subscriber) obj));
        }

        AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func3;
            this.onUnsubscribe = action1;
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this(null, func3, action1);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this(null, func3, null);
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return (S) func0.call();
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected S next(S s, long j, Observer<Observable<? extends T>> observer) {
            return (S) this.next.call(s, Long.valueOf(j), observer);
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected void onUnsubscribe(S s) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s);
            }
        }
    }

    public final void call(final Subscriber<? super T> subscriber) {
        try {
            S generateState = generateState();
            UnicastSubject create = UnicastSubject.create();
            final AsyncOuterManager asyncOuterManager = new AsyncOuterManager(this, generateState, create);
            AnonymousClass6 r0 = new Subscriber<T>() {
                /* class rx.observables.AsyncOnSubscribe.AnonymousClass6 */

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
                    asyncOuterManager.setConcatProducer(producer);
                }
            };
            create.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() {
                /* class rx.observables.AsyncOnSubscribe.AnonymousClass7 */

                @Override // rx.functions.Func1
                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    return call((Observable) ((Observable) obj));
                }

                public Observable<T> call(Observable<T> observable) {
                    return observable.onBackpressureBuffer();
                }
            }).unsafeSubscribe(r0);
            subscriber.add(r0);
            subscriber.add(asyncOuterManager);
            subscriber.setProducer(asyncOuterManager);
        } catch (Throwable th) {
            subscriber.onError(th);
        }
    }

    static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        Producer concatProducer;
        boolean emitting;
        long expectedDelivery;
        private boolean hasTerminated;
        final AtomicBoolean isUnsubscribed;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        List<Long> requests;
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
        private S state;
        final CompositeSubscription subscriptions = new CompositeSubscription();

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Observable) ((Observable) obj));
        }

        public AsyncOuterManager(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s, UnicastSubject<Observable<T>> unicastSubject) {
            this.parent = asyncOnSubscribe;
            this.serializedSubscriber = new SerializedObserver<>(this);
            this.state = s;
            this.merger = unicastSubject;
            this.isUnsubscribed = new AtomicBoolean();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        ArrayList arrayList = new ArrayList();
                        this.requests = arrayList;
                        arrayList.add(0L);
                        return;
                    }
                    this.emitting = true;
                    cleanup();
                }
            }
        }

        void setConcatProducer(Producer producer) {
            if (this.concatProducer == null) {
                this.concatProducer = producer;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long j) {
            this.state = this.parent.next(this.state, j, this.serializedSubscriber);
        }

        void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th) {
                handleThrownError(th);
            }
        }

        @Override // rx.Producer
        public void request(long j) {
            boolean z;
            List<Long> list;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0) {
                if (i >= 0) {
                    synchronized (this) {
                        z = true;
                        if (this.emitting) {
                            List list2 = this.requests;
                            if (list2 == null) {
                                list2 = new ArrayList();
                                this.requests = list2;
                            }
                            list2.add(Long.valueOf(j));
                        } else {
                            this.emitting = true;
                            z = false;
                        }
                    }
                    this.concatProducer.request(j);
                    if (z || tryEmit(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            list = this.requests;
                            if (list == null) {
                                this.emitting = false;
                                return;
                            }
                            this.requests = null;
                        }
                        Iterator<Long> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (tryEmit(it2.next().longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
            }
        }

        public void requestRemaining(long j) {
            List<Long> list;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0) {
                if (i >= 0) {
                    synchronized (this) {
                        if (this.emitting) {
                            List list2 = this.requests;
                            if (list2 == null) {
                                list2 = new ArrayList();
                                this.requests = list2;
                            }
                            list2.add(Long.valueOf(j));
                            return;
                        }
                        this.emitting = true;
                    }
                    if (tryEmit(j)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            list = this.requests;
                            if (list == null) {
                                this.emitting = false;
                                return;
                            }
                            this.requests = null;
                        }
                        Iterator<Long> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (tryEmit(it2.next().longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("Request can't be negative! " + j);
                }
            }
        }

        boolean tryEmit(long j) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = j;
                nextIteration(j);
                if ((this.hasTerminated && !this.subscriptions.hasSubscriptions()) || isUnsubscribed()) {
                    cleanup();
                    return true;
                } else if (this.onNextCalled) {
                    return false;
                } else {
                    handleThrownError(new IllegalStateException("No events emitted!"));
                    return true;
                }
            } catch (Throwable th) {
                handleThrownError(th);
                return true;
            }
        }

        private void handleThrownError(Throwable th) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(th);
            cleanup();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onNext(Observable<? extends T> observable) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                if (!this.hasTerminated) {
                    subscribeBufferToObservable(observable);
                    return;
                }
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        private void subscribeBufferToObservable(Observable<? extends T> observable) {
            BufferUntilSubscriber create = BufferUntilSubscriber.create();
            final AnonymousClass1 r3 = new Subscriber<T>(this.expectedDelivery, create) {
                /* class rx.observables.AsyncOnSubscribe.AsyncOuterManager.AnonymousClass1 */
                long remaining;
                final /* synthetic */ BufferUntilSubscriber val$buffer;
                final /* synthetic */ long val$expected;

                {
                    this.val$expected = r2;
                    this.val$buffer = r4;
                    this.remaining = r2;
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    this.remaining--;
                    this.val$buffer.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    this.val$buffer.onError(th);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    this.val$buffer.onCompleted();
                    long j = this.remaining;
                    if (j > 0) {
                        AsyncOuterManager.this.requestRemaining(j);
                    }
                }
            };
            this.subscriptions.add(r3);
            observable.doOnTerminate(new Action0() {
                /* class rx.observables.AsyncOnSubscribe.AsyncOuterManager.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(r3);
                }
            }).subscribe((Subscriber<? super Object>) r3);
            this.merger.onNext(create);
        }
    }

    static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        protected UnicastSubject(State<T> state2) {
            super(state2);
            this.state = state2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.state.subscriber.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.state.subscriber.onNext(t);
        }

        static final class State<T> implements Observable.OnSubscribe<T> {
            Subscriber<? super T> subscriber;

            State() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super T> subscriber2) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = subscriber2;
                    } else {
                        subscriber2.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }
    }
}
