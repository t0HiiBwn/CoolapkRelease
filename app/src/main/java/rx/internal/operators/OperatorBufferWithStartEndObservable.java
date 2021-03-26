package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class OperatorBufferWithStartEndObservable<T, TOpening, TClosing> implements Observable.Operator<List<T>, T> {
    final Func1<? super TOpening, ? extends Observable<? extends TClosing>> bufferClosing;
    final Observable<? extends TOpening> bufferOpening;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorBufferWithStartEndObservable(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        this.bufferOpening = observable;
        this.bufferClosing = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
        AnonymousClass1 r1 = new Subscriber<TOpening>() {
            /* class rx.internal.operators.OperatorBufferWithStartEndObservable.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(TOpening topening) {
                bufferingSubscriber.startBuffer(topening);
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
        subscriber.add(r1);
        subscriber.add(bufferingSubscriber);
        this.bufferOpening.unsafeSubscribe(r1);
        return bufferingSubscriber;
    }

    final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        final CompositeSubscription closingSubscriptions;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.closingSubscriptions = compositeSubscription;
            add(compositeSubscription);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            synchronized (this) {
                for (List<T> list : this.chunks) {
                    list.add(t);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.chunks.clear();
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            LinkedList<List> linkedList;
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        linkedList = new LinkedList(this.chunks);
                        this.chunks.clear();
                    } else {
                        return;
                    }
                }
                for (List list : linkedList) {
                    this.child.onNext(list);
                }
                this.child.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this.child);
            }
        }

        void startBuffer(TOpening topening) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.chunks.add(arrayList);
                    try {
                        Observable observable = (Observable) OperatorBufferWithStartEndObservable.this.bufferClosing.call(topening);
                        AnonymousClass1 r1 = new Subscriber<TClosing>() {
                            /* class rx.internal.operators.OperatorBufferWithStartEndObservable.BufferingSubscriber.AnonymousClass1 */

                            @Override // rx.Observer
                            public void onNext(TClosing tclosing) {
                                BufferingSubscriber.this.closingSubscriptions.remove(this);
                                BufferingSubscriber.this.endBuffer(arrayList);
                            }

                            @Override // rx.Observer
                            public void onError(Throwable th) {
                                BufferingSubscriber.this.onError(th);
                            }

                            @Override // rx.Observer
                            public void onCompleted() {
                                BufferingSubscriber.this.closingSubscriptions.remove(this);
                                BufferingSubscriber.this.endBuffer(arrayList);
                            }
                        };
                        this.closingSubscriptions.add(r1);
                        observable.unsafeSubscribe(r1);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this);
                    }
                }
            }
        }

        void endBuffer(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it2 = this.chunks.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next() == list) {
                                z = true;
                                it2.remove();
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    return;
                }
            }
            if (z) {
                this.child.onNext(list);
            }
        }
    }
}
