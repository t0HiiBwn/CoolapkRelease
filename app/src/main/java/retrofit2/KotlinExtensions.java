package retrofit2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001a\u0010\b\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\tH\b¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00060\rj\u0002`\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"await", "T", "", "Lretrofit2/Call;", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "awaitResponse", "Lretrofit2/Response;", "create", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "suspendAndThrow", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 1, 15})
/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions {
    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "$this$create");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) retrofit.create(Object.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object suspendAndThrow(Exception exc, Continuation<?> continuation) {
        KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        int i;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            if ((kotlinExtensions$suspendAndThrow$1.label & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label -= Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kotlinExtensions$suspendAndThrow$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = exc;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$12 = kotlinExtensions$suspendAndThrow$1;
                    Dispatchers.getDefault().dispatch(kotlinExtensions$suspendAndThrow$12.getContext(), new KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(kotlinExtensions$suspendAndThrow$12, exc));
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (coroutine_suspended2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(kotlinExtensions$suspendAndThrow$12);
                    }
                    if (coroutine_suspended2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    Exception exc2 = (Exception) kotlinExtensions$suspendAndThrow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        Object obj = kotlinExtensions$suspendAndThrow$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kotlinExtensions$suspendAndThrow$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public static final <T> Object await(Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$await$2$2(cancellableContinuationImpl2));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitNullable(Call<T> call, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new KotlinExtensions$await$4$2(cancellableContinuationImpl2));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitResponse(Call<T> call, Continuation<? super Response<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$awaitResponse$2$2(cancellableContinuationImpl2));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
