package rx.observers;

import rx.Observer;
import rx.Subscriber;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.functions.Action1;

public final class Subscribers {
    private Subscribers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Subscriber<T> empty() {
        return from(Observers.empty());
    }

    public static <T> Subscriber<T> from(final Observer<? super T> observer) {
        return new Subscriber<T>() {
            /* class rx.observers.Subscribers.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                observer.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                observer.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                observer.onNext(t);
            }
        };
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1) {
        if (action1 != null) {
            return new Subscriber<T>() {
                /* class rx.observers.Subscribers.AnonymousClass2 */

                @Override // rx.Observer
                public final void onCompleted() {
                }

                @Override // rx.Observer
                public final void onError(Throwable th) {
                    throw new OnErrorNotImplementedException(th);
                }

                @Override // rx.Observer
                public final void onNext(T t) {
                    action1.call(t);
                }
            };
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1, final Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 != null) {
            return new Subscriber<T>() {
                /* class rx.observers.Subscribers.AnonymousClass3 */

                @Override // rx.Observer
                public final void onCompleted() {
                }

                @Override // rx.Observer
                public final void onError(Throwable th) {
                    action12.call(th);
                }

                @Override // rx.Observer
                public final void onNext(T t) {
                    action1.call(t);
                }
            };
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1, final Action1<Throwable> action12, final Action0 action0) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 == null) {
            throw new IllegalArgumentException("onError can not be null");
        } else if (action0 != null) {
            return new Subscriber<T>() {
                /* class rx.observers.Subscribers.AnonymousClass4 */

                @Override // rx.Observer
                public final void onCompleted() {
                    action0.call();
                }

                @Override // rx.Observer
                public final void onError(Throwable th) {
                    action12.call(th);
                }

                @Override // rx.Observer
                public final void onNext(T t) {
                    action1.call(t);
                }
            };
        } else {
            throw new IllegalArgumentException("onComplete can not be null");
        }
    }

    public static <T> Subscriber<T> wrap(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.observers.Subscribers.AnonymousClass5 */

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                subscriber.onNext(t);
            }
        };
    }
}
