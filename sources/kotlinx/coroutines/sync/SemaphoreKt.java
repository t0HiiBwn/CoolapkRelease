package kotlinx.coroutines.sync;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: Semaphore.kt */
public final class SemaphoreKt {
    private static final Symbol BROKEN = new Symbol("BROKEN");
    private static final Symbol CANCELLED = new Symbol("CANCELLED");
    private static final int MAX_SPIN_CYCLES = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    private static final Symbol PERMIT = new Symbol("PERMIT");
    private static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);
    private static final Symbol TAKEN = new Symbol("TAKEN");

    private static /* synthetic */ void getBROKEN$annotations() {
    }

    private static /* synthetic */ void getCANCELLED$annotations() {
    }

    private static /* synthetic */ void getMAX_SPIN_CYCLES$annotations() {
    }

    private static /* synthetic */ void getPERMIT$annotations() {
    }

    private static /* synthetic */ void getSEGMENT_SIZE$annotations() {
    }

    private static /* synthetic */ void getTAKEN$annotations() {
    }

    public static final Semaphore Semaphore(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object withPermit(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        SemaphoreKt$withPermit$1 semaphoreKt$withPermit$1;
        int i;
        if (continuation instanceof SemaphoreKt$withPermit$1) {
            semaphoreKt$withPermit$1 = (SemaphoreKt$withPermit$1) continuation;
            if ((semaphoreKt$withPermit$1.label & Integer.MIN_VALUE) != 0) {
                semaphoreKt$withPermit$1.label -= Integer.MIN_VALUE;
                Object obj = semaphoreKt$withPermit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = semaphoreKt$withPermit$1.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    semaphoreKt$withPermit$1.L$0 = semaphore;
                    semaphoreKt$withPermit$1.L$1 = function0;
                    semaphoreKt$withPermit$1.label = 1;
                    if (semaphore.acquire(semaphoreKt$withPermit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    function0 = (Function0) semaphoreKt$withPermit$1.L$1;
                    semaphore = (Semaphore) semaphoreKt$withPermit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return function0.invoke();
            }
        }
        semaphoreKt$withPermit$1 = new SemaphoreKt$withPermit$1(continuation);
        Object obj = semaphoreKt$withPermit$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = semaphoreKt$withPermit$1.label;
        int i2 = 1;
        if (i != 0) {
        }
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(i2);
            semaphore.release();
            InlineMarker.finallyEnd(i2);
        }
    }

    private static final Object withPermit$$forInline(Semaphore semaphore, Function0 function0, Continuation continuation) {
        InlineMarker.mark(0);
        semaphore.acquire(continuation);
        InlineMarker.mark(2);
        int i = 1;
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(i);
            semaphore.release();
            InlineMarker.finallyEnd(i);
        }
    }

    public static final SemaphoreSegment createSegment(long j, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j, semaphoreSegment, 0);
    }
}
