package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeAmb<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends Observable<? extends T>> sources;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        arrayList.add(observable9);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> iterable) {
        return new OnSubscribeAmb(iterable);
    }

    static final class AmbSubscriber<T> extends Subscriber<T> {
        private boolean chosen;
        private final Selection<T> selection;
        private final Subscriber<? super T> subscriber;

        AmbSubscriber(long j, Subscriber<? super T> subscriber2, Selection<T> selection2) {
            this.subscriber = subscriber2;
            this.selection = selection2;
            request(j);
        }

        /* access modifiers changed from: private */
        public void requestMore(long j) {
            request(j);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (isSelected()) {
                this.subscriber.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (isSelected()) {
                this.subscriber.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (isSelected()) {
                this.subscriber.onError(th);
            }
        }

        private boolean isSelected() {
            if (this.chosen) {
                return true;
            }
            if (this.selection.get() == this) {
                this.chosen = true;
                return true;
            } else if (this.selection.compareAndSet(null, this)) {
                this.selection.unsubscribeOthers(this);
                this.chosen = true;
                return true;
            } else {
                this.selection.unsubscribeLosers();
                return false;
            }
        }
    }

    static final class Selection<T> extends AtomicReference<AmbSubscriber<T>> {
        final Collection<AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();

        Selection() {
        }

        public void unsubscribeLosers() {
            AmbSubscriber<T> ambSubscriber = (AmbSubscriber) get();
            if (ambSubscriber != null) {
                unsubscribeOthers(ambSubscriber);
            }
        }

        public void unsubscribeOthers(AmbSubscriber<T> ambSubscriber) {
            for (AmbSubscriber<T> ambSubscriber2 : this.ambSubscribers) {
                if (ambSubscriber2 != ambSubscriber) {
                    ambSubscriber2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }

    private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> iterable) {
        this.sources = iterable;
    }

    public void call(Subscriber<? super T> subscriber) {
        final Selection selection = new Selection();
        subscriber.add(Subscriptions.create(new Action0() {
            /* class rx.internal.operators.OnSubscribeAmb.AnonymousClass1 */

            @Override // rx.functions.Action0
            public void call() {
                AmbSubscriber ambSubscriber = (AmbSubscriber) selection.get();
                if (ambSubscriber != null) {
                    ambSubscriber.unsubscribe();
                }
                OnSubscribeAmb.unsubscribeAmbSubscribers(selection.ambSubscribers);
            }
        }));
        Iterator<? extends Observable<? extends T>> it2 = this.sources.iterator();
        while (it2.hasNext()) {
            Observable observable = (Observable) it2.next();
            if (subscriber.isUnsubscribed()) {
                break;
            }
            AmbSubscriber<T> ambSubscriber = new AmbSubscriber<>(0, subscriber, selection);
            selection.ambSubscribers.add(ambSubscriber);
            AmbSubscriber<T> ambSubscriber2 = (AmbSubscriber) selection.get();
            if (ambSubscriber2 != null) {
                selection.unsubscribeOthers(ambSubscriber2);
                return;
            }
            observable.unsafeSubscribe(ambSubscriber);
        }
        if (subscriber.isUnsubscribed()) {
            unsubscribeAmbSubscribers(selection.ambSubscribers);
        }
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OnSubscribeAmb.AnonymousClass2 */

            @Override // rx.Producer
            public void request(long j) {
                AmbSubscriber ambSubscriber = (AmbSubscriber) selection.get();
                if (ambSubscriber != null) {
                    ambSubscriber.requestMore(j);
                    return;
                }
                for (AmbSubscriber<T> ambSubscriber2 : selection.ambSubscribers) {
                    if (!ambSubscriber2.isUnsubscribed()) {
                        if (selection.get() == ambSubscriber2) {
                            ambSubscriber2.requestMore(j);
                            return;
                        }
                        ambSubscriber2.requestMore(j);
                    }
                }
            }
        });
    }

    static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> collection) {
        if (!collection.isEmpty()) {
            for (AmbSubscriber<T> ambSubscriber : collection) {
                ambSubscriber.unsubscribe();
            }
            collection.clear();
        }
    }
}
