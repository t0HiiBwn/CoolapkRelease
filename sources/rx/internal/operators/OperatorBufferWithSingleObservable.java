package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.Operator<List<T>, T> {
    final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    final int initialCapacity;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> func0, int i) {
        this.bufferClosingSelector = func0;
        this.initialCapacity = i;
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> observable, int i) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() {
            /* class rx.internal.operators.OperatorBufferWithSingleObservable.AnonymousClass1 */

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public Observable<? extends TClosing> call() {
                return observable;
            }
        };
        this.initialCapacity = i;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        try {
            Observable observable = (Observable) this.bufferClosingSelector.call();
            final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
            AnonymousClass2 r2 = new Subscriber<TClosing>() {
                /* class rx.internal.operators.OperatorBufferWithSingleObservable.AnonymousClass2 */

                @Override // rx.Observer
                public void onNext(TClosing tclosing) {
                    bufferingSubscriber.emit();
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    bufferingSubscriber.onError(th);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    bufferingSubscriber.onCompleted();
                }
            };
            subscriber.add(r2);
            subscriber.add(bufferingSubscriber);
            observable.unsafeSubscribe(r2);
            return bufferingSubscriber;
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
            return Subscribers.empty();
        }
    }

    final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            synchronized (this) {
                if (!this.done) {
                    this.chunk.add(t);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunk = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.chunk;
                        this.chunk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.child);
            }
        }

        void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.chunk;
                    this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th) {
                        unsubscribe();
                        synchronized (this) {
                            if (!this.done) {
                                this.done = true;
                                Exceptions.throwOrReport(th, this.child);
                            }
                        }
                    }
                }
            }
        }
    }
}
