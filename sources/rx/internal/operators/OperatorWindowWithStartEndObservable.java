package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    final Observable<? extends U> windowOpenings;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.windowOpenings = observable;
        this.windowClosingSelector = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        final SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, compositeSubscription);
        AnonymousClass1 r3 = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorWindowWithStartEndObservable.AnonymousClass1 */

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onNext(U u) {
                sourceSubscriber.beginWindow(u);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                sourceSubscriber.onError(th);
            }

            @Override // rx.Observer
            public void onCompleted() {
                sourceSubscriber.onCompleted();
            }
        };
        compositeSubscription.add(sourceSubscriber);
        compositeSubscription.add(r3);
        this.windowOpenings.unsafeSubscribe(r3);
        return sourceSubscriber;
    }

    static final class SerializedSubject<T> {
        final Observer<T> consumer;
        final Observable<T> producer;

        public SerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    final class SourceSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<SerializedSubject<T>> chunks = new LinkedList();
        final CompositeSubscription composite;
        boolean done;
        final Object guard = new Object();

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.child = new SerializedSubscriber(subscriber);
            this.composite = compositeSubscription;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            ArrayList<SerializedSubject> arrayList;
            synchronized (this.guard) {
                if (!this.done) {
                    arrayList = new ArrayList(this.chunks);
                } else {
                    return;
                }
            }
            for (SerializedSubject serializedSubject : arrayList) {
                serializedSubject.consumer.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            ArrayList<SerializedSubject> arrayList;
            try {
                synchronized (this.guard) {
                    if (!this.done) {
                        this.done = true;
                        arrayList = new ArrayList(this.chunks);
                        this.chunks.clear();
                    } else {
                        return;
                    }
                }
                for (SerializedSubject serializedSubject : arrayList) {
                    serializedSubject.consumer.onError(th);
                }
                this.child.onError(th);
                this.composite.unsubscribe();
            } finally {
                this.composite.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            ArrayList<SerializedSubject> arrayList;
            try {
                synchronized (this.guard) {
                    if (!this.done) {
                        this.done = true;
                        arrayList = new ArrayList(this.chunks);
                        this.chunks.clear();
                    } else {
                        return;
                    }
                }
                for (SerializedSubject serializedSubject : arrayList) {
                    serializedSubject.consumer.onCompleted();
                }
                this.child.onCompleted();
                this.composite.unsubscribe();
            } finally {
                this.composite.unsubscribe();
            }
        }

        void beginWindow(U u) {
            final SerializedSubject<T> createSerializedSubject = createSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(createSerializedSubject);
                    this.child.onNext(createSerializedSubject.producer);
                    try {
                        Observable observable = (Observable) OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(u);
                        AnonymousClass1 r1 = new Subscriber<V>() {
                            /* class rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.AnonymousClass1 */
                            boolean once = true;

                            @Override // rx.Observer
                            public void onNext(V v) {
                                onCompleted();
                            }

                            @Override // rx.Observer
                            public void onError(Throwable th) {
                                SourceSubscriber.this.onError(th);
                            }

                            @Override // rx.Observer
                            public void onCompleted() {
                                if (this.once) {
                                    this.once = false;
                                    SourceSubscriber.this.endWindow(createSerializedSubject);
                                    SourceSubscriber.this.composite.remove(this);
                                }
                            }
                        };
                        this.composite.add(r1);
                        observable.unsafeSubscribe(r1);
                    } catch (Throwable th) {
                        onError(th);
                    }
                }
            }
        }

        void endWindow(SerializedSubject<T> serializedSubject) {
            boolean z;
            synchronized (this.guard) {
                if (!this.done) {
                    Iterator<SerializedSubject<T>> it2 = this.chunks.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next() == serializedSubject) {
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
                serializedSubject.consumer.onCompleted();
            }
        }

        SerializedSubject<T> createSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new SerializedSubject<>(create, create);
        }
    }
}
