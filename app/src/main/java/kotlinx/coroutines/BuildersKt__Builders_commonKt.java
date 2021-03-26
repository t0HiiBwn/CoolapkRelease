package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: Builders.common.kt */
final /* synthetic */ class BuildersKt__Builders_commonKt {
    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Job launch(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        LazyStandaloneCoroutine lazyStandaloneCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            lazyStandaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
        } else {
            lazyStandaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        lazyStandaloneCoroutine.start(coroutineStart, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        LazyDeferredCoroutine lazyDeferredCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            lazyDeferredCoroutine = new LazyDeferredCoroutine(newCoroutineContext, function2);
        } else {
            lazyDeferredCoroutine = new DeferredCoroutine(newCoroutineContext, true);
        }
        lazyDeferredCoroutine.start(coroutineStart, lazyDeferredCoroutine, function2);
        return lazyDeferredCoroutine;
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object withContext(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        YieldKt.checkCompletion(plus);
        if (plus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(plus, continuation);
            obj = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        } else if (Intrinsics.areEqual((ContinuationInterceptor) plus.get(ContinuationInterceptor.Key), (ContinuationInterceptor) context.get(ContinuationInterceptor.Key))) {
            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(plus, continuation);
            Object updateThreadContext = ThreadContextKt.updateThreadContext(plus, null);
            try {
                Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
                ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                obj = startUndispatchedOrReturn;
            } catch (Throwable th) {
                ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                throw th;
            }
        } else {
            DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(plus, continuation);
            dispatchedCoroutine.initParentJob$kotlinx_coroutines_core();
            CancellableKt.startCoroutineCancellable(function2, dispatchedCoroutine, dispatchedCoroutine);
            obj = dispatchedCoroutine.getResult();
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }

    public static final <T> Object invoke(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, function2, continuation);
    }

    private static final Object invoke$$forInline(CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation) {
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(coroutineDispatcher, function2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }
}
