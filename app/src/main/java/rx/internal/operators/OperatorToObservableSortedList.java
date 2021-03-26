package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableSortedList<T> implements Observable.Operator<List<T>, T> {
    private static final Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction();
    final int initialCapacity;
    final Comparator<? super T> sortFunction;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorToObservableSortedList(int i) {
        this.sortFunction = DEFAULT_SORT_FUNCTION;
        this.initialCapacity = i;
    }

    public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> func2, int i) {
        this.initialCapacity = i;
        this.sortFunction = new Comparator<T>() {
            /* class rx.internal.operators.OperatorToObservableSortedList.AnonymousClass1 */

            @Override // java.util.Comparator
            public int compare(T t, T t2) {
                return ((Integer) func2.call(t, t2)).intValue();
            }
        };
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        AnonymousClass2 r1 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorToObservableSortedList.AnonymousClass2 */
            boolean completed;
            List<T> list;

            {
                this.list = new ArrayList(OperatorToObservableSortedList.this.initialCapacity);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    List<T> list2 = this.list;
                    this.list = null;
                    try {
                        Collections.sort(list2, OperatorToObservableSortedList.this.sortFunction);
                        singleDelayedProducer.setValue(list2);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.completed) {
                    this.list.add(t);
                }
            }
        };
        subscriber.add(r1);
        subscriber.setProducer(singleDelayedProducer);
        return r1;
    }

    static final class DefaultComparableFunction implements Comparator<Object> {
        DefaultComparableFunction() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Comparable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }
}
