package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u001f\b\u0004\u0010\u000f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013HHø\u0001\u0000¢\u0006\u0002\u0010\u0014\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u000b8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"ALREADY_SELECTED", "", "ALREADY_SELECTED$annotations", "()V", "getALREADY_SELECTED", "()Ljava/lang/Object;", "RESUMED", "RESUMED$annotations", "UNDECIDED", "UNDECIDED$annotations", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;", "selectOpSequenceNumber$annotations", "select", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: Select.kt */
public final class SelectKt {
    private static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");
    private static final Object RESUMED = new Symbol("RESUMED");
    private static final Object UNDECIDED = new Symbol("UNDECIDED");
    private static final SeqNumber selectOpSequenceNumber = new SeqNumber();

    public static /* synthetic */ void ALREADY_SELECTED$annotations() {
    }

    private static /* synthetic */ void RESUMED$annotations() {
    }

    private static /* synthetic */ void UNDECIDED$annotations() {
    }

    private static /* synthetic */ void selectOpSequenceNumber$annotations() {
    }

    private static final Object select$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final <R> Object select(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final Object getALREADY_SELECTED() {
        return ALREADY_SELECTED;
    }
}
