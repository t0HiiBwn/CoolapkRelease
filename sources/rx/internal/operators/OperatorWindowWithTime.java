package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Scheduler scheduler;
    final int size;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorWindowWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler2) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(subscriber, createWorker);
            exactSubscriber.add(createWorker);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(subscriber, createWorker);
        inexactSubscriber.add(createWorker);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }

    static final class State<T> {
        static final State<Object> EMPTY = new State<>(null, null, 0);
        final Observer<T> consumer;
        final int count;
        final Observable<T> producer;

        public State(Observer<T> observer, Observable<T> observable, int i) {
            this.consumer = observer;
            this.producer = observable;
            this.count = i;
        }

        public State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }

        public State<T> create(Observer<T> observer, Observable<T> observable) {
            return new State<>(observer, observable, 0);
        }

        public State<T> clear() {
            return empty();
        }

        public static <T> State<T> empty() {
            return (State<T>) EMPTY;
        }
    }

    final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        boolean emitting;
        final Object guard = new Object();
        List<Object> queue;
        volatile State<T> state = State.empty();
        final Scheduler.Worker worker;

        public ExactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker2) {
            this.child = new SerializedSubscriber(subscriber);
            this.worker = worker2;
            subscriber.add(Subscriptions.create(new Action0(OperatorWindowWithTime.this) {
                /* class rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            boolean z;
            Throwable th;
            Throwable th2;
            List<Object> list;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t);
                    return;
                }
                z = true;
                this.emitting = true;
            }
            try {
                if (!emitValue(t)) {
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                    return;
                }
                do {
                    synchronized (this.guard) {
                        try {
                            list = this.queue;
                            if (list == null) {
                                this.emitting = false;
                                try {
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                }
                            } else {
                                this.queue = null;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            z = false;
                        }
                    }
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } while (drain(list));
                synchronized (this.guard) {
                    this.emitting = false;
                }
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

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: rx.internal.operators.OperatorWindowWithTime$ExactSubscriber */
        /* JADX WARN: Multi-variable type inference failed */
        boolean drain(List<Object> list) {
            if (list == null) {
                return true;
            }
            Iterator<Object> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (next == OperatorWindowWithTime.NEXT_SUBJECT) {
                    if (!replaceSubject()) {
                        return false;
                    }
                } else if (NotificationLite.isError(next)) {
                    error(NotificationLite.getError(next));
                    break;
                } else if (NotificationLite.isCompleted(next)) {
                    complete();
                    break;
                } else if (!emitValue(next)) {
                    return false;
                }
            }
            return true;
        }

        boolean replaceSubject() {
            Observer<T> observer = this.state.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            UnicastSubject create = UnicastSubject.create();
            this.state = this.state.create(create, create);
            this.child.onNext(create);
            return true;
        }

        boolean emitValue(T t) {
            State<T> state2;
            State<T> state3 = this.state;
            if (state3.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                state3 = this.state;
            }
            state3.consumer.onNext(t);
            if (state3.count == OperatorWindowWithTime.this.size - 1) {
                state3.consumer.onCompleted();
                state2 = state3.clear();
            } else {
                state2 = state3.next();
            }
            this.state = state2;
            return true;
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

        void error(Throwable th) {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            Observer<T> observer = this.state.consumer;
            this.state = this.state.clear();
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
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

        void scheduleExact() {
            this.worker.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    ExactSubscriber.this.nextWindow();
                }
            }, 0, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
        }

        void nextWindow() {
            boolean z;
            boolean z2;
            Throwable th;
            Throwable th2;
            List<Object> list;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithTime.NEXT_SUBJECT);
                    return;
                }
                z = true;
                this.emitting = true;
            }
            try {
                if (!replaceSubject()) {
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                    return;
                }
                do {
                    synchronized (this.guard) {
                        try {
                            list = this.queue;
                            if (list == null) {
                                this.emitting = false;
                                try {
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                }
                            } else {
                                this.queue = null;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            z = false;
                        }
                    }
                    try {
                        throw th2;
                    } catch (Throwable th5) {
                        z2 = z;
                        th = th5;
                    }
                } while (drain(list));
                synchronized (this.guard) {
                    this.emitting = false;
                }
            } catch (Throwable th6) {
                th = th6;
                z2 = false;
                if (!z2) {
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }
    }

    static final class CountedSerializedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<CountedSerializedSubject<T>> chunks = new LinkedList();
        boolean done;
        final Object guard = new Object();
        final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> subscriber, Scheduler.Worker worker2) {
            super(subscriber);
            this.child = subscriber;
            this.worker = worker2;
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            ArrayList<CountedSerializedSubject> arrayList;
            synchronized (this.guard) {
                if (!this.done) {
                    arrayList = new ArrayList(this.chunks);
                    Iterator<CountedSerializedSubject<T>> it2 = this.chunks.iterator();
                    while (it2.hasNext()) {
                        CountedSerializedSubject<T> next = it2.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == OperatorWindowWithTime.this.size) {
                            it2.remove();
                        }
                    }
                } else {
                    return;
                }
            }
            for (CountedSerializedSubject countedSerializedSubject : arrayList) {
                countedSerializedSubject.consumer.onNext(t);
                if (countedSerializedSubject.count == OperatorWindowWithTime.this.size) {
                    countedSerializedSubject.consumer.onCompleted();
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            ArrayList<CountedSerializedSubject> arrayList;
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                } else {
                    return;
                }
            }
            for (CountedSerializedSubject countedSerializedSubject : arrayList) {
                countedSerializedSubject.consumer.onError(th);
            }
            this.child.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            ArrayList<CountedSerializedSubject> arrayList;
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                } else {
                    return;
                }
            }
            for (CountedSerializedSubject countedSerializedSubject : arrayList) {
                countedSerializedSubject.consumer.onCompleted();
            }
            this.child.onCompleted();
        }

        void scheduleChunk() {
            this.worker.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.unit);
        }

        void startNewChunk() {
            final CountedSerializedSubject<T> createCountedSerializedSubject = createCountedSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(createCountedSerializedSubject);
                    try {
                        this.child.onNext(createCountedSerializedSubject.producer);
                        this.worker.schedule(new Action0() {
                            /* class rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.AnonymousClass2 */

                            @Override // rx.functions.Action0
                            public void call() {
                                InexactSubscriber.this.terminateChunk(createCountedSerializedSubject);
                            }
                        }, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
                    } catch (Throwable th) {
                        onError(th);
                    }
                }
            }
        }

        void terminateChunk(CountedSerializedSubject<T> countedSerializedSubject) {
            boolean z;
            synchronized (this.guard) {
                if (!this.done) {
                    Iterator<CountedSerializedSubject<T>> it2 = this.chunks.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next() == countedSerializedSubject) {
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
                countedSerializedSubject.consumer.onCompleted();
            }
        }

        CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new CountedSerializedSubject<>(create, create);
        }
    }
}
