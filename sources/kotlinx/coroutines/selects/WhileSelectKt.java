package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006HHø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* compiled from: WhileSelect.kt */
public final class WhileSelectKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object whileSelect(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$1;
        Object coroutine_suspended;
        int i;
        SelectBuilderImpl selectBuilderImpl;
        Object result;
        if (continuation instanceof WhileSelectKt$whileSelect$1) {
            whileSelectKt$whileSelect$1 = (WhileSelectKt$whileSelect$1) continuation;
            if ((whileSelectKt$whileSelect$1.label & Integer.MIN_VALUE) != 0) {
                whileSelectKt$whileSelect$1.label -= Integer.MIN_VALUE;
                Object obj = whileSelectKt$whileSelect$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = whileSelectKt$whileSelect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                } else if (i == 1) {
                    function1 = (Function1) whileSelectKt$whileSelect$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                whileSelectKt$whileSelect$1.L$0 = function1;
                whileSelectKt$whileSelect$1.label = 1;
                WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
                selectBuilderImpl = new SelectBuilderImpl(whileSelectKt$whileSelect$12);
                function1.invoke(selectBuilderImpl);
                result = selectBuilderImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(whileSelectKt$whileSelect$12);
                }
                if (result != coroutine_suspended) {
                    obj = result;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    whileSelectKt$whileSelect$1.L$0 = function1;
                    whileSelectKt$whileSelect$1.label = 1;
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
                    selectBuilderImpl = new SelectBuilderImpl(whileSelectKt$whileSelect$12);
                    function1.invoke(selectBuilderImpl);
                    result = selectBuilderImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    }
                    if (result != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        whileSelectKt$whileSelect$1 = new WhileSelectKt$whileSelect$1(continuation);
        Object obj = whileSelectKt$whileSelect$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = whileSelectKt$whileSelect$1.label;
        if (i != 0) {
        }
        whileSelectKt$whileSelect$1.L$0 = function1;
        whileSelectKt$whileSelect$1.label = 1;
        WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
        selectBuilderImpl = new SelectBuilderImpl(whileSelectKt$whileSelect$12);
        try {
            function1.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        result = selectBuilderImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
        if (result != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    private static final Object whileSelect$$forInline(Function1 function1, Continuation continuation) {
        Object result;
        do {
            InlineMarker.mark(0);
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
            try {
                function1.invoke(selectBuilderImpl);
            } catch (Throwable th) {
                selectBuilderImpl.handleBuilderException(th);
            }
            result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
        } while (((Boolean) result).booleanValue());
        return Unit.INSTANCE;
    }
}
