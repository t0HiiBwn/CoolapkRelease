package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    private final Executor callbackExecutor;

    DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        final Executor executor = null;
        if (getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.callbackExecutor;
            }
            return new CallAdapter<Object, Call<?>>() {
                /* class retrofit2.DefaultCallAdapterFactory.AnonymousClass1 */

                @Override // retrofit2.CallAdapter
                public Type responseType() {
                    return parameterUpperBound;
                }

                /* Return type fixed from 'retrofit2.Call<java.lang.Object>' to match base method */
                @Override // retrofit2.CallAdapter
                public Call<?> adapt(Call<Object> call) {
                    Executor executor = executor;
                    return executor == null ? call : new ExecutorCallbackCall(executor, call);
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void enqueue(final Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new Callback<T>() {
                /* class retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 */

                @Override // retrofit2.Callback
                public void onResponse(Call<T> call, Response<T> response) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable(callback, response) {
                        /* class retrofit2.$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$hVGjmafRi6VitDIrPNdoFizVAdk */
                        public final /* synthetic */ Callback f$1;
                        public final /* synthetic */ Response f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this.lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
                        }
                    });
                }

                public /* synthetic */ void lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Response response) {
                    if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                        callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                    } else {
                        callback.onResponse(ExecutorCallbackCall.this, response);
                    }
                }

                public /* synthetic */ void lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Throwable th) {
                    callback.onFailure(ExecutorCallbackCall.this, th);
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<T> call, Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable(callback, th) {
                        /* class retrofit2.$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$G9BY9eQQk64nBfFjfIpxYzJzUo */
                        public final /* synthetic */ Callback f$1;
                        public final /* synthetic */ Throwable f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this.lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
                        }
                    });
                }
            });
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call, java.lang.Object
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public Timeout timeout() {
            return this.delegate.timeout();
        }
    }
}
