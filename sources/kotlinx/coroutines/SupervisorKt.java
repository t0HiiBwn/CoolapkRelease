package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: Supervisor.kt */
public final class SupervisorKt {
    public static final CompletableJob SupervisorJob(Job job) {
        return new SupervisorJobImpl(job);
    }

    public static final <R> Object supervisorScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(continuation.getContext(), continuation);
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(supervisorCoroutine, supervisorCoroutine, function2);
        if (startUndispatchedOrReturn == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return startUndispatchedOrReturn;
    }
}
