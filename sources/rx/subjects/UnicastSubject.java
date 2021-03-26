package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    public static <T> UnicastSubject<T> create(int i) {
        return new UnicastSubject<>(new State(i, false, null));
    }

    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(new State(16, z, null));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0) {
        return new UnicastSubject<>(new State(i, false, action0));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0, boolean z) {
        return new UnicastSubject<>(new State(i, z, action0));
    }

    private UnicastSubject(State<T> state2) {
        super(state2);
        this.state = state2;
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

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.subscriber.get() != null;
    }

    static final class State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        final boolean delayError;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<Action0> terminateOnce;

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public State(int i, boolean z, Action0 action0) {
            Queue<Object> queue2;
            this.terminateOnce = action0 != null ? new AtomicReference<>(action0) : null;
            this.delayError = z;
            if (i > 1) {
                queue2 = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            } else {
                queue2 = UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            }
            this.queue = queue2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.next(t));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                Subscriber<? super T> subscriber2 = this.subscriber.get();
                try {
                    subscriber2.onNext(t);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber2, t);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!this.done) {
                doTerminate();
                this.error = th;
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(th);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                doTerminate();
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        @Override // rx.Producer
        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (i > 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public void call(Subscriber<? super T> subscriber2) {
            if (this.subscriber.compareAndSet(null, subscriber2)) {
                subscriber2.add(this);
                subscriber2.setProducer(this);
                return;
            }
            subscriber2.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        void replay() {
            boolean z;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
            }
            Queue<Object> queue2 = this.queue;
            boolean z2 = this.delayError;
            while (true) {
                Subscriber<? super T> subscriber2 = this.subscriber.get();
                if (subscriber2 == null) {
                    z = false;
                } else if (!checkTerminated(this.done, queue2.isEmpty(), z2, subscriber2)) {
                    long j = get();
                    z = j == Long.MAX_VALUE;
                    long j2 = 0;
                    while (j != 0) {
                        boolean z3 = this.done;
                        Object poll = queue2.poll();
                        boolean z4 = poll == null;
                        if (!checkTerminated(z3, z4, z2, subscriber2)) {
                            if (z4) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.getValue(poll);
                            try {
                                subscriber2.onNext(obj);
                                j--;
                                j2++;
                            } catch (Throwable th) {
                                queue2.clear();
                                Exceptions.throwIfFatal(th);
                                subscriber2.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    if (!z && j2 != 0) {
                        addAndGet(-j2);
                    }
                } else {
                    return;
                }
                synchronized (this) {
                    if (!this.missed) {
                        if (z && queue2.isEmpty()) {
                            this.caughtUp = true;
                        }
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (!this.emitting) {
                    this.emitting = true;
                    this.queue.clear();
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.done;
        }

        boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber2) {
            if (subscriber2.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (th != null && !z3) {
                    this.queue.clear();
                    subscriber2.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    if (th != null) {
                        subscriber2.onError(th);
                    } else {
                        subscriber2.onCompleted();
                    }
                    return true;
                }
            }
        }

        void doTerminate() {
            Action0 action0;
            AtomicReference<Action0> atomicReference = this.terminateOnce;
            if (atomicReference != null && (action0 = atomicReference.get()) != null && atomicReference.compareAndSet(action0, null)) {
                action0.call();
            }
        }
    }
}
