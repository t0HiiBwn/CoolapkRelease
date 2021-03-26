package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000C2\u000601j\u0002`22\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\bø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001bH\b¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\bø\u0001\u0000¢\u0006\u0004\b$\u0010!J \u0010%\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010!J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\b'\u0010(J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R\u001e\u0010-\u001a\u0004\u0018\u00010&8\u0000@\u0000X\u000e¢\u0006\f\n\u0004\b-\u0010.\u0012\u0004\b/\u00100R$\u00103\u001a\n\u0018\u000101j\u0004\u0018\u0001`28\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u00109R\u0016\u0010:\u001a\u00020&8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b:\u0010.R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u0013\u0010?\u001a\u00020\u001b8F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010#R\u0019\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 1, 16})
/* compiled from: DispatchedContinuation.kt */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public Object _state = DispatchedContinuationKt.access$getUNDEFINED$p();
    private final CoroutineStackFrame callerFrame;
    public final Continuation<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    public static /* synthetic */ void _state$annotations() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation2) {
        super(0);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation2;
        this.callerFrame = (CoroutineStackFrame) (!(continuation2 instanceof CoroutineStackFrame) ? null : continuation2);
        this.countOrElement = ThreadContextKt.threadContextElements(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.callerFrame;
    }

    public final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl)) {
            obj = null;
        }
        return (CancellableContinuationImpl) obj;
    }

    public final boolean isReusable() {
        return this._reusableCancellableContinuation != null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj != DispatchedContinuationKt.access$getUNDEFINED$p())) {
                throw new AssertionError();
            }
        }
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return obj;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.continuation.getContext();
        Object state = CompletedExceptionallyKt.toState(obj);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = state;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        DispatchedContinuation<T> dispatchedContinuation = this;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            CoroutineContext context2 = getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(obj);
                Unit unit = Unit.INSTANCE;
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            } finally {
                ThreadContextKt.restoreThreadContext(context2, updateThreadContext);
            }
        } catch (Throwable th) {
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            throw th;
        }
    }

    public final void resumeCancellableWith(Object obj) {
        boolean z;
        Object state = CompletedExceptionallyKt.toState(obj);
        int i = 1;
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = state;
            this.resumeMode = 1;
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state;
            this.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        DispatchedContinuation<T> dispatchedContinuation = this;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) getContext().get(Job.Key);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                Result.Companion companion = Result.Companion;
                resumeWith(Result.m687constructorimpl(ResultKt.createFailure(job.getCancellationException())));
                z = true;
            }
            if (!z) {
                CoroutineContext context = getContext();
                Object updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
                try {
                    this.continuation.resumeWith(obj);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    InlineMarker.finallyStart(i);
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    InlineMarker.finallyEnd(i);
                }
            }
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw th;
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
    }

    public final boolean resumeCancelled() {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null || job.isActive()) {
            return false;
        }
        Result.Companion companion = Result.Companion;
        resumeWith(Result.m687constructorimpl(ResultKt.createFailure(job.getCancellationException())));
        return true;
    }

    public final void resumeUndispatchedWith(Object obj) {
        CoroutineContext context = getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
        int i = 1;
        try {
            this.continuation.resumeWith(obj);
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(i);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            InlineMarker.finallyEnd(i);
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext coroutineContext, T t) {
        this._state = t;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    @Override // java.lang.Object
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
        Object obj;
        do {
            obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = DispatchedContinuationKt.REUSABLE_CLAIMED;
                return null;
            } else if (!(obj instanceof CancellableContinuationImpl)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, obj, DispatchedContinuationKt.REUSABLE_CLAIMED));
        return (CancellableContinuationImpl) obj;
    }

    public final Throwable checkPostponedCancellation(CancellableContinuation<?> cancellableContinuation) {
        do {
            Object obj = this._reusableCancellableContinuation;
            if (obj != DispatchedContinuationKt.REUSABLE_CLAIMED) {
                if (obj == null) {
                    return null;
                }
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, cancellableContinuation));
        return null;
    }

    public final boolean postponeCancellation(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (Intrinsics.areEqual(obj, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }
}
