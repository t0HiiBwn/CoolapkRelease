package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

public final class BehaviorSubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private final SubjectSubscriptionManager<T> state;

    public static <T> BehaviorSubject<T> create() {
        return create((Object) null, false);
    }

    public static <T> BehaviorSubject<T> create(T t) {
        return create((Object) t, true);
    }

    private static <T> BehaviorSubject<T> create(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.next(t));
        }
        subjectSubscriptionManager.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            /* class rx.subjects.BehaviorSubject.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new BehaviorSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected BehaviorSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.getLatest() == null || this.state.active) {
            Object completed = NotificationLite.completed();
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(completed)) {
                subjectObserver.emitNext(completed);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        if (this.state.getLatest() == null || this.state.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(error)) {
                try {
                    subjectObserver.emitNext(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (this.state.getLatest() == null || this.state.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.next(next)) {
                subjectObserver.emitNext(next);
            }
        }
    }

    int subscriberCount() {
        return this.state.observers().length;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public boolean hasValue() {
        return NotificationLite.isNext(this.state.getLatest());
    }

    public boolean hasThrowable() {
        return NotificationLite.isError(this.state.getLatest());
    }

    public boolean hasCompleted() {
        return NotificationLite.isCompleted(this.state.getLatest());
    }

    public T getValue() {
        Object latest = this.state.getLatest();
        if (NotificationLite.isNext(latest)) {
            return (T) NotificationLite.getValue(latest);
        }
        return null;
    }

    public Throwable getThrowable() {
        Object latest = this.state.getLatest();
        if (NotificationLite.isError(latest)) {
            return NotificationLite.getError(latest);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public T[] getValues(T[] tArr) {
        Object latest = this.state.getLatest();
        if (NotificationLite.isNext(latest)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = NotificationLite.getValue(latest);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.subjects.BehaviorSubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }
}
