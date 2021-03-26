package com.coolapk.market.remote;

import com.coolapk.market.util.LogUtils;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public class RxErrorHandlingCallAdapterFactory extends CallAdapter.Factory {
    private final RxJavaCallAdapterFactory original = RxJavaCallAdapterFactory.create();

    private RxErrorHandlingCallAdapterFactory() {
    }

    public static CallAdapter.Factory create() {
        return new RxErrorHandlingCallAdapterFactory();
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new RxCallAdapterWrapper(retrofit, this.original.get(type, annotationArr, retrofit));
    }

    private static class RxCallAdapterWrapper<R> implements CallAdapter<R, Observable<?>> {
        private final Retrofit retrofit;
        private final CallAdapter wrapped;

        public RxCallAdapterWrapper(Retrofit retrofit3, CallAdapter<?, Observable<?>> callAdapter) {
            this.retrofit = retrofit3;
            this.wrapped = callAdapter;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.wrapped.responseType();
        }

        @Override // retrofit2.CallAdapter
        public Observable<?> adapt(Call<R> call) {
            return ((Observable) this.wrapped.adapt(call)).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                /* class com.coolapk.market.remote.RxErrorHandlingCallAdapterFactory.RxCallAdapterWrapper.AnonymousClass1 */

                /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<?> */
                public Observable<?> call(Observable<? extends Throwable> observable) {
                    return (Observable<R>) observable.zipWith(Observable.range(1, 3), new Func2<Throwable, Integer, Integer>() {
                        /* class com.coolapk.market.remote.RxErrorHandlingCallAdapterFactory.RxCallAdapterWrapper.AnonymousClass1.AnonymousClass2 */

                        public Integer call(Throwable th, Integer num) {
                            if (num.intValue() >= 3 || !(th instanceof IOException)) {
                                throw Exceptions.propagate(th);
                            }
                            LogUtils.e(th);
                            LogUtils.e("[API] We will retry: %d", num);
                            return num;
                        }
                    }).flatMap(new Func1<Integer, Observable<Long>>() {
                        /* class com.coolapk.market.remote.RxErrorHandlingCallAdapterFactory.RxCallAdapterWrapper.AnonymousClass1.AnonymousClass1 */

                        public Observable<Long> call(Integer num) {
                            long intValue = (long) num.intValue();
                            LogUtils.v("[API] Retry count: %d, delay: %ds", num, Long.valueOf(intValue));
                            return Observable.timer(intValue, TimeUnit.SECONDS);
                        }
                    });
                }
            });
        }

        private RetrofitException asRetrofitException(Throwable th) {
            if (th instanceof HttpException) {
                Response<?> response = ((HttpException) th).response();
                return RetrofitException.httpError(response.raw().request().url().toString(), response, this.retrofit);
            } else if (th instanceof IOException) {
                return RetrofitException.networkError((IOException) th);
            } else {
                return RetrofitException.unexpectedError(th);
            }
        }
    }
}
