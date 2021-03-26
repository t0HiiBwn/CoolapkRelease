package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public static <T> TestSubject<T> create(TestScheduler testScheduler) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            /* class rx.subjects.TestSubject.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new TestSubject<>(subjectSubscriptionManager, subjectSubscriptionManager, testScheduler);
    }

    protected TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, TestScheduler testScheduler) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
        this.innerScheduler = testScheduler.createWorker();
    }

    @Override // rx.Observer
    public void onCompleted() {
        onCompleted(0);
    }

    void internalOnCompleted() {
        if (this.state.active) {
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(NotificationLite.completed())) {
                subjectObserver.onCompleted();
            }
        }
    }

    public void onCompleted(long j) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        onError(th, 0);
    }

    void internalOnError(Throwable th) {
        if (this.state.active) {
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(NotificationLite.error(th))) {
                subjectObserver.onError(th);
            }
        }
    }

    public void onError(final Throwable th, long j) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnError(th);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @Override // rx.Observer
    public void onNext(T t) {
        onNext(t, 0);
    }

    void internalOnNext(T t) {
        for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.observers()) {
            subjectObserver.onNext(t);
        }
    }

    public void onNext(final T t, long j) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass4 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.subjects.TestSubject */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.Action0
            public void call() {
                TestSubject.this.internalOnNext(t);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }
}
