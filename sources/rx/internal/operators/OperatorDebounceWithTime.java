package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(createWorker);
        serializedSubscriber.add(serialSubscription);
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorDebounceWithTime.AnonymousClass1 */
            final Subscriber<?> self = this;
            final DebounceState<T> state = new DebounceState<>();

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                final int next = this.state.next(t);
                serialSubscription.set(createWorker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorDebounceWithTime.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        AnonymousClass1.this.state.emit(next, serializedSubscriber, AnonymousClass1.this.self);
                    }
                }, OperatorDebounceWithTime.this.timeout, OperatorDebounceWithTime.this.unit));
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
                this.state.clear();
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.state.emitAndComplete(serializedSubscriber, this);
            }
        };
    }

    static final class DebounceState<T> {
        boolean emitting;
        boolean hasValue;
        int index;
        boolean terminate;
        T value;

        DebounceState() {
        }

        public synchronized int next(T t) {
            int i;
            this.value = t;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }

        public void emit(int i, Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            T t;
            synchronized (this) {
                if (!this.emitting && this.hasValue) {
                    if (i == this.index) {
                        t = this.value;
                        this.value = null;
                        this.hasValue = false;
                        this.emitting = true;
                    }
                }
                return;
            }
            try {
                subscriber.onNext(t);
                synchronized (this) {
                    if (!this.terminate) {
                        this.emitting = false;
                    } else {
                        subscriber.onCompleted();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, subscriber2, t);
            }
        }

        public void emitAndComplete(Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            T t;
            boolean z;
            synchronized (this) {
                if (this.emitting) {
                    this.terminate = true;
                    return;
                }
                t = this.value;
                z = this.hasValue;
                this.value = null;
                this.hasValue = false;
                this.emitting = true;
            }
            if (z) {
                try {
                    subscriber.onNext(t);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber2, t);
                    return;
                }
            }
            subscriber.onCompleted();
        }

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }
    }
}
