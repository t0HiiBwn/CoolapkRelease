package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorMostRecent {
    private BlockingOperatorMostRecent() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> mostRecent(final Observable<? extends T> observable, final T t) {
        return new Iterable<T>() {
            /* class rx.internal.operators.BlockingOperatorMostRecent.AnonymousClass1 */

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                MostRecentObserver mostRecentObserver = new MostRecentObserver(t);
                observable.subscribe((Subscriber) mostRecentObserver);
                return mostRecentObserver.getIterable();
            }
        };
    }

    static final class MostRecentObserver<T> extends Subscriber<T> {
        volatile Object value;

        MostRecentObserver(T t) {
            this.value = NotificationLite.next(t);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.value = NotificationLite.completed();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.value = NotificationLite.error(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.value = NotificationLite.next(t);
        }

        public Iterator<T> getIterable() {
            return new Iterator<T>() {
                /* class rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver.AnonymousClass1 */
                private Object buf;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    Object obj = MostRecentObserver.this.value;
                    this.buf = obj;
                    return !NotificationLite.isCompleted(obj);
                }

                @Override // java.util.Iterator
                public T next() {
                    Object obj = null;
                    try {
                        if (this.buf == null) {
                            Object obj2 = MostRecentObserver.this.value;
                        }
                        if (NotificationLite.isCompleted(this.buf)) {
                            throw new NoSuchElementException();
                        } else if (!NotificationLite.isError(this.buf)) {
                            T t = (T) NotificationLite.getValue(this.buf);
                            this.buf = null;
                            return t;
                        } else {
                            throw Exceptions.propagate(NotificationLite.getError(this.buf));
                        }
                    } finally {
                        this.buf = obj;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Read only iterator");
                }
            };
        }
    }
}
