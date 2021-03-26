package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OnSubscribeSkipTimed<T> implements Observable.OnSubscribe<T> {
    final Scheduler scheduler;
    final Observable<T> source;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeSkipTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.source = observable;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SkipTimedSubscriber skipTimedSubscriber = new SkipTimedSubscriber(subscriber);
        skipTimedSubscriber.add(createWorker);
        subscriber.add(skipTimedSubscriber);
        createWorker.schedule(skipTimedSubscriber, this.time, this.unit);
        this.source.unsafeSubscribe(skipTimedSubscriber);
    }

    static final class SkipTimedSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;
        volatile boolean gate;

        SkipTimedSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // rx.functions.Action0
        public void call() {
            this.gate = true;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.gate) {
                this.child.onNext(t);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                this.child.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                this.child.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }
}
