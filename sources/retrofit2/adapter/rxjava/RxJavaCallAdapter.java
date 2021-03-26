package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.Observable;
import rx.Scheduler;

final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    @Nullable
    private final Scheduler scheduler;

    RxJavaCallAdapter(Type type, @Nullable Scheduler scheduler2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = scheduler2;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        Scheduler scheduler2;
        Observable.OnSubscribe bodyOnSubscribe;
        Observable.OnSubscribe callEnqueueOnSubscribe = this.isAsync ? new CallEnqueueOnSubscribe(call) : new CallExecuteOnSubscribe(call);
        if (this.isResult) {
            bodyOnSubscribe = new ResultOnSubscribe(callEnqueueOnSubscribe);
        } else {
            if (this.isBody) {
                bodyOnSubscribe = new BodyOnSubscribe(callEnqueueOnSubscribe);
            }
            Observable create = Observable.create(callEnqueueOnSubscribe);
            scheduler2 = this.scheduler;
            if (scheduler2 != null) {
                create = create.subscribeOn(scheduler2);
            }
            if (!this.isSingle) {
                return create.toSingle();
            }
            return this.isCompletable ? create.toCompletable() : create;
        }
        callEnqueueOnSubscribe = bodyOnSubscribe;
        Observable create = Observable.create(callEnqueueOnSubscribe);
        scheduler2 = this.scheduler;
        if (scheduler2 != null) {
        }
        if (!this.isSingle) {
        }
    }
}
