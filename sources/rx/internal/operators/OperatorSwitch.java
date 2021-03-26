package rx.internal.operators;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);

        Holder() {
        }
    }

    static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);

        HolderDelayError() {
        }
    }

    public static <T> OperatorSwitch<T> instance(boolean z) {
        return z ? (OperatorSwitch<T>) HolderDelayError.INSTANCE : (OperatorSwitch<T>) Holder.INSTANCE;
    }

    OperatorSwitch(boolean z) {
        this.delayError = z;
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }

    static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        final AtomicLong index;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        Producer producer;
        final SpscLinkedArrayQueue<Object> queue;
        long requested;
        final SerialSubscription serial = new SerialSubscription();

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Observable) ((Observable) obj));
        }

        SwitchSubscriber(Subscriber<? super T> subscriber, boolean z) {
            this.child = subscriber;
            this.delayError = z;
            this.index = new AtomicLong();
            this.queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);
        }

        void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorSwitch.SwitchSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() {
                /* class rx.internal.operators.OperatorSwitch.SwitchSubscriber.AnonymousClass2 */

                @Override // rx.Producer
                public void request(long j) {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i > 0) {
                        SwitchSubscriber.this.childRequested(j);
                    } else if (i < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was " + j);
                    }
                }
            });
        }

        void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long incrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.serial.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(incrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.serial.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            boolean updateError;
            synchronized (this) {
                updateError = updateError(th);
            }
            if (updateError) {
                this.mainDone = true;
                drain();
                return;
            }
            pluginError(th);
        }

        boolean updateError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == TERMINAL_ERROR) {
                return false;
            }
            if (th2 == null) {
                this.error = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.error = new CompositeException(arrayList);
            } else {
                this.error = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        void emit(T t, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                if (this.index.get() == ((InnerSubscriber) innerSubscriber).id) {
                    this.queue.offer(innerSubscriber, NotificationLite.next(t));
                    drain();
                }
            }
        }

        void error(Throwable th, long j) {
            boolean z;
            synchronized (this) {
                if (this.index.get() == j) {
                    z = updateError(th);
                    this.innerActive = false;
                    this.producer = null;
                } else {
                    z = true;
                }
            }
            if (z) {
                drain();
            } else {
                pluginError(th);
            }
        }

        void complete(long j) {
            synchronized (this) {
                if (this.index.get() == j) {
                    this.innerActive = false;
                    this.producer = null;
                    drain();
                }
            }
        }

        void pluginError(Throwable th) {
            RxJavaHooks.onError(th);
        }

        void innerProducer(Producer producer2, long j) {
            synchronized (this) {
                if (this.index.get() == j) {
                    long j2 = this.requested;
                    this.producer = producer2;
                    producer2.request(j2);
                }
            }
        }

        void childRequested(long j) {
            Producer producer2;
            synchronized (this) {
                producer2 = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j);
            }
            if (producer2 != null) {
                producer2.request(j);
            }
            drain();
        }

        void drain() {
            boolean z;
            long j;
            Throwable th;
            int i;
            Throwable th2;
            Throwable th3;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                z = this.innerActive;
                j = this.requested;
                th = this.error;
                if (!(th == null || th == (th3 = TERMINAL_ERROR) || this.delayError)) {
                    this.error = th3;
                }
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            AtomicLong atomicLong = this.index;
            Subscriber<? super T> subscriber = this.child;
            long j2 = j;
            Throwable th4 = th;
            boolean z2 = this.mainDone;
            while (true) {
                long j3 = 0;
                while (true) {
                    i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (!subscriber.isUnsubscribed()) {
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (!checkTerminated(z2, z, th4, spscLinkedArrayQueue, subscriber, isEmpty)) {
                            if (isEmpty) {
                                break;
                            }
                            Object obj = (Object) NotificationLite.getValue(spscLinkedArrayQueue.poll());
                            if (atomicLong.get() == ((InnerSubscriber) spscLinkedArrayQueue.poll()).id) {
                                subscriber.onNext(obj);
                                j3++;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i != 0 || (!subscriber.isUnsubscribed() && !checkTerminated(this.mainDone, z, th4, spscLinkedArrayQueue, subscriber, spscLinkedArrayQueue.isEmpty()))) {
                    synchronized (this) {
                        long j4 = this.requested;
                        if (j4 != Long.MAX_VALUE) {
                            j4 -= j3;
                            this.requested = j4;
                        }
                        j2 = j4;
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        z2 = this.mainDone;
                        z = this.innerActive;
                        th4 = this.error;
                        if (!(th4 == null || th4 == (th2 = TERMINAL_ERROR) || this.delayError)) {
                            this.error = th2;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        protected boolean checkTerminated(boolean z, boolean z2, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z3) {
            if (this.delayError) {
                if (!z || z2 || !z3) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            } else if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            } else if (!z || z2 || !z3) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        private final long id;
        private final SwitchSubscriber<T> parent;

        InnerSubscriber(long j, SwitchSubscriber<T> switchSubscriber) {
            this.id = j;
            this.parent = switchSubscriber;
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.id);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.parent.emit(t, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.parent.error(th, this.id);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.complete(this.id);
        }
    }
}
