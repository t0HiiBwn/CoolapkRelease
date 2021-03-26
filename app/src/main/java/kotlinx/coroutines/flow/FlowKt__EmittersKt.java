package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001as\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\u0010\u0004\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001023\u0010\u0004\u001a/\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001al\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102D\u0010\u0004\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aU\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001as\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00102D\b\u0005\u0010\u0015\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u0003\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\fH\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001as\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00102D\b\u0005\u0010\u0015\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u0003\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\b\fH\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"invokeSafely", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCompletion", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onStart", "transform", "R", "value", "unsafeTransform", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 16}, xs = "kotlinx/coroutines/flow/FlowKt")
/* compiled from: Emitters.kt */
final /* synthetic */ class FlowKt__EmittersKt {
    public static final <T, R> Flow<R> transform(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt.flow(new FlowKt__EmittersKt$transform$1(flow, function3, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    static final /* synthetic */ <T> Object invokeSafely$FlowKt__EmittersKt(FlowCollector<? super T> flowCollector, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3, Throwable th, Continuation<? super Unit> continuation) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        int i;
        if (continuation instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuation;
            if ((flowKt__EmittersKt$invokeSafely$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__EmittersKt$invokeSafely$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__EmittersKt$invokeSafely$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__EmittersKt$invokeSafely$1.L$0 = flowCollector;
                    flowKt__EmittersKt$invokeSafely$1.L$1 = function3;
                    flowKt__EmittersKt$invokeSafely$1.L$2 = th;
                    flowKt__EmittersKt$invokeSafely$1.label = 1;
                    if (function3.invoke(flowCollector, th, flowKt__EmittersKt$invokeSafely$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    Throwable th2 = (Throwable) flowKt__EmittersKt$invokeSafely$1.L$2;
                    Function3 function32 = (Function3) flowKt__EmittersKt$invokeSafely$1.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) flowKt__EmittersKt$invokeSafely$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th3, th2);
                        }
                        throw th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
        Object obj = flowKt__EmittersKt$invokeSafely$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__EmittersKt$invokeSafely$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public static final <T, R> Flow<R> unsafeTransform(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(flow, function3);
    }

    public static final <T> Flow<T> onStart(Flow<? extends T> flow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(flow, function2);
    }

    public static final <T> Flow<T> onCompletion(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(flow, function3);
    }
}
