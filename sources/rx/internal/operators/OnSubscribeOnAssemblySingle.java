package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssemblySingle<T> implements Single.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Single.OnSubscribe<T> source;
    final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public OnSubscribeOnAssemblySingle(Single.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.Single$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        this.source.call(new OnAssemblySingleSubscriber(singleSubscriber, this.stacktrace));
    }

    static final class OnAssemblySingleSubscriber<T> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySingleSubscriber(SingleSubscriber<? super T> singleSubscriber, String str) {
            this.actual = singleSubscriber;
            this.stacktrace = str;
            singleSubscriber.add(this);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th);
            this.actual.onError(th);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }
}
