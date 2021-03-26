package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    CompletableFutureCallAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
            if (getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }

    private static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // retrofit2.CallAdapter
        public CompletableFuture<R> adapt(Call<R> call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        private class BodyCallback implements Callback<R> {
            private final CompletableFuture<R> future;

            public BodyCallback(CompletableFuture<R> completableFuture) {
                this.future = completableFuture;
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<R> call, Response<R> response) {
                if (response.isSuccessful()) {
                    this.future.complete(response.body());
                } else {
                    this.future.completeExceptionally(new HttpException(response));
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }
        }
    }

    private static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        @Override // retrofit2.CallAdapter
        public CompletableFuture<Response<R>> adapt(Call<R> call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        private class ResponseCallback implements Callback<R> {
            private final CompletableFuture<Response<R>> future;

            public ResponseCallback(CompletableFuture<Response<R>> completableFuture) {
                this.future = completableFuture;
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<R> call, Response<R> response) {
                this.future.complete(response);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }
        }
    }

    private static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        private final Call<?> call;

        CallCancelCompletableFuture(Call<?> call2) {
            this.call = call2;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }
}
