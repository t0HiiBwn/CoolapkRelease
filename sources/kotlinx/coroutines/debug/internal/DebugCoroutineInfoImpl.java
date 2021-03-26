package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010$\u001a\u00020\u000eH\u0016J!\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020\u000e2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0000¢\u0006\u0002\b)J%\u0010*\u001a\u00020&*\b\u0012\u0004\u0012\u00020\u00150+2\b\u0010'\u001a\u0004\u0018\u00010\fHPø\u0001\u0000¢\u0006\u0002\u0010,R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\f8@@@X\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "_state", "", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCreationStackBottom", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "value", "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedThread", "Ljava/lang/Thread;", "state", "getState", "()Ljava/lang/String;", "lastObservedStackTrace", "toString", "updateState", "", "frame", "Lkotlin/coroutines/Continuation;", "updateState$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: DebugCoroutineInfoImpl.kt */
public final class DebugCoroutineInfoImpl {
    private final WeakReference<CoroutineContext> _context;
    private WeakReference<CoroutineStackFrame> _lastObservedFrame;
    private String _state = "CREATED";
    private final StackTraceFrame creationStackBottom;
    public Thread lastObservedThread;
    public final long sequenceNumber;

    public DebugCoroutineInfoImpl(CoroutineContext coroutineContext, StackTraceFrame stackTraceFrame, long j) {
        this.creationStackBottom = stackTraceFrame;
        this.sequenceNumber = j;
        this._context = new WeakReference<>(coroutineContext);
    }

    public final StackTraceFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    public final CoroutineContext getContext() {
        return this._context.get();
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return creationStackTrace();
    }

    public final String getState() {
        return this._state;
    }

    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference<CoroutineStackFrame> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(CoroutineStackFrame coroutineStackFrame) {
        this._lastObservedFrame = coroutineStackFrame != null ? new WeakReference<>(coroutineStackFrame) : null;
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (lastObservedFrame$kotlinx_coroutines_core != null) {
            StackTraceElement stackTraceElement = lastObservedFrame$kotlinx_coroutines_core.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            lastObservedFrame$kotlinx_coroutines_core = lastObservedFrame$kotlinx_coroutines_core.getCallerFrame();
        }
        return arrayList;
    }

    private final List<StackTraceElement> creationStackTrace() {
        StackTraceFrame stackTraceFrame = this.creationStackBottom;
        if (stackTraceFrame != null) {
            return SequencesKt.toList(SequencesKt.sequence(new DebugCoroutineInfoImpl$creationStackTrace$1(this, stackTraceFrame, null)));
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    final /* synthetic */ Object yieldFrames(SequenceScope<? super StackTraceElement> sequenceScope, CoroutineStackFrame coroutineStackFrame, Continuation<? super Unit> continuation) {
        DebugCoroutineInfoImpl$yieldFrames$1 debugCoroutineInfoImpl$yieldFrames$1;
        int i;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl;
        SequenceScope<? super StackTraceElement> sequenceScope2;
        CoroutineStackFrame coroutineStackFrame2;
        if (continuation instanceof DebugCoroutineInfoImpl$yieldFrames$1) {
            debugCoroutineInfoImpl$yieldFrames$1 = (DebugCoroutineInfoImpl$yieldFrames$1) continuation;
            if ((debugCoroutineInfoImpl$yieldFrames$1.label & Integer.MIN_VALUE) != 0) {
                debugCoroutineInfoImpl$yieldFrames$1.label -= Integer.MIN_VALUE;
                Object obj = debugCoroutineInfoImpl$yieldFrames$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = debugCoroutineInfoImpl$yieldFrames$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    debugCoroutineInfoImpl = this;
                } else if (i == 1) {
                    StackTraceElement stackTraceElement = (StackTraceElement) debugCoroutineInfoImpl$yieldFrames$1.L$3;
                    coroutineStackFrame2 = (CoroutineStackFrame) debugCoroutineInfoImpl$yieldFrames$1.L$2;
                    sequenceScope2 = (SequenceScope) debugCoroutineInfoImpl$yieldFrames$1.L$1;
                    debugCoroutineInfoImpl = (DebugCoroutineInfoImpl) debugCoroutineInfoImpl$yieldFrames$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineStackFrame = coroutineStackFrame2;
                    sequenceScope = sequenceScope2;
                    coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                    if (coroutineStackFrame == null) {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (coroutineStackFrame != null) {
                    StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
                    if (stackTraceElement2 != null) {
                        debugCoroutineInfoImpl$yieldFrames$1.L$0 = debugCoroutineInfoImpl;
                        debugCoroutineInfoImpl$yieldFrames$1.L$1 = sequenceScope;
                        debugCoroutineInfoImpl$yieldFrames$1.L$2 = coroutineStackFrame;
                        debugCoroutineInfoImpl$yieldFrames$1.L$3 = stackTraceElement2;
                        debugCoroutineInfoImpl$yieldFrames$1.label = 1;
                        if (sequenceScope.yield(stackTraceElement2, debugCoroutineInfoImpl$yieldFrames$1) != coroutine_suspended) {
                            sequenceScope2 = sequenceScope;
                            coroutineStackFrame2 = coroutineStackFrame;
                            coroutineStackFrame = coroutineStackFrame2;
                            sequenceScope = sequenceScope2;
                        }
                        return coroutine_suspended;
                    }
                    coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                    if (coroutineStackFrame == null) {
                    }
                    if (coroutineStackFrame != null) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        debugCoroutineInfoImpl$yieldFrames$1 = new DebugCoroutineInfoImpl$yieldFrames$1(this, continuation);
        Object obj = debugCoroutineInfoImpl$yieldFrames$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = debugCoroutineInfoImpl$yieldFrames$1.label;
        if (i != 0) {
        }
        if (coroutineStackFrame != null) {
        }
        return Unit.INSTANCE;
    }

    public final void updateState$kotlinx_coroutines_core(String str, Continuation<?> continuation) {
        if (!Intrinsics.areEqual(this._state, str) || !Intrinsics.areEqual(str, "SUSPENDED") || getLastObservedFrame$kotlinx_coroutines_core() == null) {
            this._state = str;
            Thread thread = null;
            if (!(continuation instanceof CoroutineStackFrame)) {
                continuation = null;
            }
            setLastObservedFrame$kotlinx_coroutines_core((CoroutineStackFrame) continuation);
            if (Intrinsics.areEqual(str, "RUNNING")) {
                thread = Thread.currentThread();
            }
            this.lastObservedThread = thread;
        }
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + getState() + ",context=" + getContext() + ')';
    }
}
