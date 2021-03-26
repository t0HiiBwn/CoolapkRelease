package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;

public final class OperatorWindowWithObservable<T, U> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Observable<U> other;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorWindowWithObservable(Observable<U> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber);
        BoundarySubscriber boundarySubscriber = new BoundarySubscriber(sourceSubscriber);
        subscriber.add(sourceSubscriber);
        subscriber.add(boundarySubscriber);
        sourceSubscriber.replaceWindow();
        this.other.unsafeSubscribe(boundarySubscriber);
        return sourceSubscriber;
    }

    static final class SourceSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        Observer<T> consumer;
        boolean emitting;
        final Object guard = new Object();
        Observable<T> producer;
        List<Object> queue;

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber) {
            this.child = new SerializedSubscriber(subscriber);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            List<Object> list;
            boolean z;
            Throwable th;
            Throwable th2;
            List<Object> list2;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t);
                    return;
                }
                list = this.queue;
                this.queue = null;
                z = true;
                this.emitting = true;
            }
            boolean z2 = true;
            while (true) {
                try {
                    drain(list);
                    if (z2) {
                        emitValue(t);
                        z2 = false;
                    }
                    synchronized (this.guard) {
                        try {
                            list2 = this.queue;
                            this.queue = null;
                            if (list2 == null) {
                                this.emitting = false;
                                try {
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    try {
                                        throw th2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            z = false;
                            throw th2;
                        }
                    }
                    if (this.child.isUnsubscribed()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    list = list2;
                } catch (Throwable th6) {
                    th = th6;
                    z = false;
                    if (!z) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.internal.operators.OperatorWindowWithObservable$SourceSubscriber<T> */
        /* JADX WARN: Multi-variable type inference failed */
        void drain(List<Object> list) {
            if (list != null) {
                for (Object obj : list) {
                    if (obj == OperatorWindowWithObservable.NEXT_SUBJECT) {
                        replaceSubject();
                    } else if (NotificationLite.isError(obj)) {
                        error(NotificationLite.getError(obj));
                        return;
                    } else if (NotificationLite.isCompleted(obj)) {
                        complete();
                        return;
                    } else {
                        emitValue(obj);
                    }
                }
            }
        }

        void replaceSubject() {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        void createNewWindow() {
            UnicastSubject create = UnicastSubject.create();
            this.consumer = create;
            this.producer = create;
        }

        void emitValue(T t) {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(NotificationLite.error(th));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(th);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(NotificationLite.completed());
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                this.emitting = true;
                try {
                    drain(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void replaceWindow() {
            List<Object> list;
            boolean z;
            Throwable th;
            Throwable th2;
            List<Object> list2;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithObservable.NEXT_SUBJECT);
                    return;
                }
                list = this.queue;
                this.queue = null;
                z = true;
                this.emitting = true;
            }
            boolean z2 = true;
            while (true) {
                try {
                    drain(list);
                    if (z2) {
                        replaceSubject();
                        z2 = false;
                    }
                    synchronized (this.guard) {
                        try {
                            list2 = this.queue;
                            this.queue = null;
                            if (list2 == null) {
                                this.emitting = false;
                                try {
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    try {
                                        throw th2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            z = false;
                            throw th2;
                        }
                    }
                    if (this.child.isUnsubscribed()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    list = list2;
                } catch (Throwable th6) {
                    th = th6;
                    z = false;
                    if (!z) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                    }
                    throw th;
                }
            }
        }

        void complete() {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void error(Throwable th) {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }
    }

    static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        final SourceSubscriber<T> sub;

        public BoundarySubscriber(SourceSubscriber<T> sourceSubscriber) {
            this.sub = sourceSubscriber;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(U u) {
            this.sub.replaceWindow();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.sub.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.sub.onCompleted();
        }
    }
}
