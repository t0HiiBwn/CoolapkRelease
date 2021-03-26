package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {
    final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
    final Object guard;
    Subscription guardedSubscription;
    final Observable<? extends T> source;
    final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
    Subscriber<T> subscription;
    final List<Subscriber<? super R>> waitingForConnect;

    public OperatorMulticast(Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        this(new Object(), new AtomicReference(), new ArrayList(), observable, func0);
    }

    private OperatorMulticast(final Object obj, final AtomicReference<Subject<? super T, ? extends R>> atomicReference, final List<Subscriber<? super R>> list, Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        super(new Observable.OnSubscribe<R>() {
            /* class rx.internal.operators.OperatorMulticast.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super R> subscriber) {
                synchronized (obj) {
                    if (atomicReference.get() == null) {
                        list.add(subscriber);
                    } else {
                        ((Subject) atomicReference.get()).unsafeSubscribe(subscriber);
                    }
                }
            }
        });
        this.guard = obj;
        this.connectedSubject = atomicReference;
        this.waitingForConnect = list;
        this.source = observable;
        this.subjectFactory = func0;
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> action1) {
        Subscriber<T> subscriber;
        synchronized (this.guard) {
            if (this.subscription != null) {
                action1.call(this.guardedSubscription);
                return;
            }
            Subject<? super T, ? extends R> subject = (Subject) this.subjectFactory.call();
            this.subscription = Subscribers.from(subject);
            final AtomicReference atomicReference = new AtomicReference();
            atomicReference.set(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorMulticast.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    Subscriber<T> subscriber;
                    synchronized (OperatorMulticast.this.guard) {
                        if (OperatorMulticast.this.guardedSubscription == atomicReference.get()) {
                            subscriber = OperatorMulticast.this.subscription;
                            OperatorMulticast.this.subscription = null;
                            OperatorMulticast.this.guardedSubscription = null;
                            OperatorMulticast.this.connectedSubject.set(null);
                        } else {
                            return;
                        }
                    }
                    if (subscriber != null) {
                        subscriber.unsubscribe();
                    }
                }
            }));
            this.guardedSubscription = (Subscription) atomicReference.get();
            for (final Subscriber<? super R> subscriber2 : this.waitingForConnect) {
                subject.unsafeSubscribe(new Subscriber<R>(subscriber2) {
                    /* class rx.internal.operators.OperatorMulticast.AnonymousClass3 */

                    @Override // rx.Observer
                    public void onNext(R r) {
                        subscriber2.onNext(r);
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        subscriber2.onError(th);
                    }

                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber2.onCompleted();
                    }
                });
            }
            this.waitingForConnect.clear();
            this.connectedSubject.set(subject);
        }
        action1.call(this.guardedSubscription);
        synchronized (this.guard) {
            subscriber = this.subscription;
        }
        if (subscriber != null) {
            this.source.subscribe((Subscriber<? super Object>) subscriber);
        }
    }
}
