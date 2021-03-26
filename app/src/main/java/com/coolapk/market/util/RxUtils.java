package com.coolapk.market.util;

import android.os.Bundle;
import com.coolapk.market.event.RequestEvent;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.EmitNullException;
import com.coolapk.market.network.Result;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import rx.Notification;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class RxUtils {
    public static <T> Observable.Transformer<T, T> withEvent(final Bundle bundle) {
        return new Observable.Transformer<T, T>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass1 */

            public Observable<T> call(Observable<T> observable) {
                return observable.doOnEach(new Action1<Notification<? super T>>() {
                    /* class com.coolapk.market.util.RxUtils.AnonymousClass1.AnonymousClass1 */

                    public void call(Notification<? super T> notification) {
                        EventBus.getDefault().post(new RequestEvent(notification, bundle));
                    }
                });
            }
        };
    }

    public static <T> Observable.Transformer<T, T> applyIOSchedulers() {
        return new Observable.Transformer<T, T>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass2 */

            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Func1<Result<T>, Observable<Result<T>>> flatCheckResult() {
        return new Func1<Result<T>, Observable<Result<T>>>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass3 */

            public Observable<Result<T>> call(Result<T> result) {
                ClientException checkResult = result.checkResult();
                if (checkResult != null) {
                    return Observable.error(checkResult);
                }
                return Observable.just(result);
            }
        };
    }

    public static <T> Func1<Result<T>, Result<T>> checkResult() {
        return new Func1<Result<T>, Result<T>>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass4 */

            public Result<T> call(Result<T> result) {
                ClientException checkResult = result.checkResult();
                if (checkResult == null) {
                    return result;
                }
                throw Exceptions.propagate(checkResult);
            }
        };
    }

    public static <T> Func1<Result<T>, Observable<T>> flatCheckResultToData() {
        return new Func1<Result<T>, Observable<T>>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass5 */

            public Observable<T> call(Result<T> result) {
                ClientException checkResult = result.checkResult();
                if (checkResult != null) {
                    return Observable.error(checkResult);
                }
                return Observable.just(result.getData());
            }
        };
    }

    public static <T> Func1<Result<T>, T> checkResultToData() {
        return new Func1<Result<T>, T>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass6 */

            @Override // rx.functions.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Result<Object>) ((Result) obj));
            }

            public T call(Result<T> result) {
                ClientException checkResult = result.checkResult();
                if (checkResult == null) {
                    return result.getData();
                }
                throw Exceptions.propagate(checkResult);
            }
        };
    }

    public static <T extends Result> Action1<T> action1CheckResult() {
        return new Action1<T>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass7 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((AnonymousClass7) ((Result) obj));
            }

            public void call(T t) {
                ClientException checkResult = t.checkResult();
                if (checkResult != null) {
                    throw Exceptions.propagate(checkResult);
                }
            }
        };
    }

    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public static <T> Observable.Transformer<Result<T>, Result<T>> apiCommon() {
        return new Observable.Transformer<Result<T>, Result<T>>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass8 */

            public Observable<Result<T>> call(Observable<Result<T>> observable) {
                return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(RxUtils.flatCheckResult());
            }
        };
    }

    public static <T> Observable.Transformer<Result<T>, T> apiCommonToData() {
        return new Observable.Transformer<Result<T>, T>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass9 */

            /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
            public Observable<T> call(Observable<Result<T>> observable) {
                return (Observable<R>) observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(RxUtils.flatCheckResultToData());
            }
        };
    }

    public static <T> Observable.Transformer<T, T> retryWhenEmitNull() {
        return retryWhenEmitNull(3);
    }

    private static <T> Observable.Transformer<T, T> retryWhenEmitNull(final int i) {
        return new Observable.Transformer<T, T>() {
            /* class com.coolapk.market.util.RxUtils.AnonymousClass10 */

            public Observable<T> call(Observable<T> observable) {
                return observable.doOnNext(new Action1<T>() {
                    /* class com.coolapk.market.util.RxUtils.AnonymousClass10.AnonymousClass2 */

                    @Override // rx.functions.Action1
                    public void call(T t) {
                        if (t == null) {
                            throw new EmitNullException();
                        }
                    }
                }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    /* class com.coolapk.market.util.RxUtils.AnonymousClass10.AnonymousClass1 */

                    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<?> */
                    public Observable<?> call(Observable<? extends Throwable> observable) {
                        return (Observable<R>) observable.zipWith(Observable.range(1, i), new Func2<Throwable, Integer, Integer>() {
                            /* class com.coolapk.market.util.RxUtils.AnonymousClass10.AnonymousClass1.AnonymousClass2 */

                            public Integer call(Throwable th, Integer num) {
                                if (num.intValue() >= i || !(th instanceof EmitNullException)) {
                                    throw Exceptions.propagate(th);
                                }
                                LogUtils.e("emit a null value from remote service", new Object[0]);
                                LogUtils.e("[API] We will retry: %d", num);
                                return num;
                            }
                        }).flatMap(new Func1<Integer, Observable<Long>>() {
                            /* class com.coolapk.market.util.RxUtils.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                            public Observable<Long> call(Integer num) {
                                long intValue = (long) num.intValue();
                                LogUtils.v("[API] Retry count: %d, delay: %ds", num, Long.valueOf(intValue));
                                return Observable.timer(intValue, TimeUnit.SECONDS);
                            }
                        });
                    }
                });
            }
        };
    }
}
