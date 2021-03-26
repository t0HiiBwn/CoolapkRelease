package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: StackTraceRecovery.kt */
public final class StackTraceRecoveryKt {
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        String str;
        String str2;
        String str3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        String str4 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        try {
            Result.Companion companion = Result.Companion;
            str = Result.m687constructorimpl(Class.forName(str4).getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            str = Result.m687constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m690exceptionOrNullimpl(str) == null) {
            str4 = str;
        }
        baseContinuationImplClassName = str4;
        try {
            Result.Companion companion3 = Result.Companion;
            str2 = Result.m687constructorimpl(Class.forName(str3).getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            str2 = Result.m687constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m690exceptionOrNullimpl(str2) == null) {
            str3 = str2;
        }
        stackTraceRecoveryClassName = str3;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e) {
        Throwable tryCopyException;
        return (DebugKt.getRECOVER_STACK_TRACES() && (tryCopyException = ExceptionsConstuctorKt.tryCopyException(e)) != null) ? (E) sanitizeStackTrace(tryCopyException) : e;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int frameIndex = frameIndex(stackTrace, stackTraceRecoveryClassName);
        int i = frameIndex + 1;
        int frameIndex2 = frameIndex(stackTrace, baseContinuationImplClassName);
        int i2 = (length - frameIndex) - (frameIndex2 == -1 ? 0 : length - frameIndex2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e, Continuation<?> continuation) {
        return (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation instanceof CoroutineStackFrame)) ? e : (E) recoverFromStackFrame(e, (CoroutineStackFrame) continuation);
    }

    public static final <E extends Throwable> E recoverFromStackFrame(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e);
        Throwable th = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstuctorKt.tryCopyException(th);
        if (tryCopyException == null || (!Intrinsics.areEqual(tryCopyException.getMessage(), th.getMessage()))) {
            return e;
        }
        ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e;
        }
        if (th != e) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return (E) createFinalException(th, tryCopyException, createStackTrace);
    }

    private static final <E extends Throwable> E createFinalException(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int frameIndex = frameIndex(stackTrace, baseContinuationImplClassName);
        int i = 0;
        if (frameIndex == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e2.setStackTrace((StackTraceElement[]) array);
                return e2;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + frameIndex)];
        for (int i2 = 0; i2 < frameIndex; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        Iterator<T> it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            stackTraceElementArr[frameIndex + i] = it2.next();
            i++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !Intrinsics.areEqual(cause.getClass(), e.getClass())) {
            return TuplesKt.to(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (isArtificial(stackTrace[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return TuplesKt.to(cause, stackTrace);
        }
        return TuplesKt.to(e, new StackTraceElement[0]);
    }

    public static final Object recoverAndThrow(Throwable th, Continuation<?> continuation) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw th;
        } else if (!(continuation instanceof CoroutineStackFrame)) {
            throw th;
        } else {
            throw recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
    }

    private static final Object recoverAndThrow$$forInline(Throwable th, Continuation continuation) {
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            InlineMarker.mark(0);
            if (!(continuation instanceof CoroutineStackFrame)) {
                throw th;
            }
            throw recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
        throw th;
    }

    public static final <E extends Throwable> E unwrap(E e) {
        return !DebugKt.getRECOVER_STACK_TRACES() ? e : (E) unwrapImpl(e);
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (isArtificial(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            if (coroutineStackFrame == null || (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final StackTraceElement artificialFrame(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final void initCause(Throwable th, Throwable th2) {
        th.initCause(th2);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 >= i2) {
            while (true) {
                if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i2) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    private static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }
}
