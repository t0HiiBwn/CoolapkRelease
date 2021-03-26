package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class CallEnqueueOnSubscribe<T> implements Observable.OnSubscribe<Response<T>> {
    private final Call<T> originalCall;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    CallEnqueueOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    public void call(Subscriber<? super Response<T>> subscriber) {
        Call<T> clone = this.originalCall.clone();
        final CallArbiter callArbiter = new CallArbiter(clone, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        clone.enqueue(new Callback<T>() {
            /* class retrofit2.adapter.rxjava.CallEnqueueOnSubscribe.AnonymousClass1 */

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                callArbiter.emitResponse(response);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                Exceptions.throwIfFatal(th);
                callArbiter.emitError(th);
            }
        });
    }
}
