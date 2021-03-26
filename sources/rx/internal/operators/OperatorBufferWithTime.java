package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithTime<T> implements Observable.Operator<List<T>, T> {
    final int count;
    final Scheduler scheduler;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorBufferWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler2) {
        this.timespan = j;
        this.timeshift = j2;
        this.unit = timeUnit;
        this.count = i;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.timespan == this.timeshift) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(serializedSubscriber, createWorker);
            exactSubscriber.add(createWorker);
            subscriber.add(exactSubscriber);
            exactSubscriber.scheduleExact();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(serializedSubscriber, createWorker);
        inexactSubscriber.add(createWorker);
        subscriber.add(inexactSubscriber);
        inexactSubscriber.startNewChunk();
        inexactSubscriber.scheduleChunk();
        return inexactSubscriber;
    }

    final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        final List<List<T>> chunks = new LinkedList();
        boolean done;
        final Scheduler.Worker inner;

        public InexactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            LinkedList<List> linkedList;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it2 = this.chunks.iterator();
                    linkedList = null;
                    while (it2.hasNext()) {
                        List<T> next = it2.next();
                        next.add(t);
                        if (next.size() == OperatorBufferWithTime.this.count) {
                            it2.remove();
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(next);
                        }
                    }
                } else {
                    return;
                }
            }
            if (linkedList != null) {
                for (List list : linkedList) {
                    this.child.onNext(list);
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

        void scheduleChunk() {
            this.inner.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.timeshift, OperatorBufferWithTime.this.unit);
        }

        void startNewChunk() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.chunks.add(arrayList);
                    this.inner.schedule(new Action0() {
                        /* class rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.AnonymousClass2 */

                        @Override // rx.functions.Action0
                        public void call() {
                            InexactSubscriber.this.emitChunk(arrayList);
                        }
                    }, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
                }
            }
        }

        void emitChunk(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it2 = this.chunks.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next() == list) {
                                it2.remove();
                                z = true;
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
                try {
                    this.child.onNext(list);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        }
    }

    final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk = new ArrayList();
        boolean done;
        final Scheduler.Worker inner;

        public ExactSubscriber(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.child = subscriber;
            this.inner = worker;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            List<T> list;
            synchronized (this) {
                if (!this.done) {
                    this.chunk.add(t);
                    if (this.chunk.size() == OperatorBufferWithTime.this.count) {
                        list = this.chunk;
                        this.chunk = new ArrayList();
                    } else {
                        list = null;
                    }
                } else {
                    return;
                }
            }
            if (list != null) {
                this.child.onNext(list);
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
                this.inner.unsubscribe();
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

        void scheduleExact() {
            this.inner.schedulePeriodically(new Action0() {
                /* class rx.internal.operators.OperatorBufferWithTime.ExactSubscriber.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    ExactSubscriber.this.emit();
                }
            }, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.timespan, OperatorBufferWithTime.this.unit);
        }

        void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.chunk;
                    this.chunk = new ArrayList();
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this);
                    }
                }
            }
        }
    }
}
