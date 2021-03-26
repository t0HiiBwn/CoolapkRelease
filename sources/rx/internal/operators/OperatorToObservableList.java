package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableList<T> implements Observable.Operator<List<T>, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorToObservableList<Object> INSTANCE = new OperatorToObservableList<>();

        Holder() {
        }
    }

    public static <T> OperatorToObservableList<T> instance() {
        return (OperatorToObservableList<T>) Holder.INSTANCE;
    }

    OperatorToObservableList() {
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        AnonymousClass1 r1 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorToObservableList.AnonymousClass1 */
            boolean completed;
            List<T> list = new LinkedList();

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        ArrayList arrayList = new ArrayList(this.list);
                        this.list = null;
                        singleDelayedProducer.setValue(arrayList);
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
}
