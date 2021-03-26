package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> actual;
    private boolean emitting;
    private FastList queue;
    private volatile boolean terminated;

    static final class FastList {
        Object[] array;
        int size;

        FastList() {
        }

        public void add(Object obj) {
            int i = this.size;
            Object[] objArr = this.array;
            if (objArr == null) {
                objArr = new Object[16];
                this.array = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[((i >> 2) + i)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.array = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.size = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.actual = observer;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        FastList fastList;
        int i;
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    if (this.emitting) {
                        FastList fastList2 = this.queue;
                        if (fastList2 == null) {
                            fastList2 = new FastList();
                            this.queue = fastList2;
                        }
                        fastList2.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                } else {
                    return;
                }
            }
            try {
                this.actual.onNext(t);
                while (true) {
                    synchronized (this) {
                        fastList = this.queue;
                        if (fastList == null) {
                            this.emitting = false;
                            return;
                        }
                        this.queue = null;
                    }
                    Object[] objArr = fastList.array;
                    for (Object obj : objArr) {
                        if (obj == null) {
                            continue;
                            break;
                        }
                        try {
                            if (NotificationLite.accept(this.actual, obj)) {
                                this.terminated = true;
                                return;
                            }
                        } catch (Throwable th) {
                            this.terminated = true;
                            Exceptions.throwIfFatal(th);
                            this.actual.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                this.terminated = true;
                Exceptions.throwOrReport(th2, this.actual, t);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Exceptions.throwIfFatal(th);
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        FastList fastList = this.queue;
                        if (fastList == null) {
                            fastList = new FastList();
                            this.queue = fastList;
                        }
                        fastList.add(NotificationLite.error(th));
                        return;
                    }
                    this.emitting = true;
                    this.actual.onError(th);
                }
            }
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (!this.terminated) {
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.emitting) {
                        FastList fastList = this.queue;
                        if (fastList == null) {
                            fastList = new FastList();
                            this.queue = fastList;
                        }
                        fastList.add(NotificationLite.completed());
                        return;
                    }
                    this.emitting = true;
                    this.actual.onCompleted();
                }
            }
        }
    }
}
