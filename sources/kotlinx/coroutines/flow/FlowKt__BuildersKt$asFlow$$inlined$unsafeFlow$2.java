package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 implements Flow<T> {
    final /* synthetic */ Function1 $this_asFlow$inlined;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        Object obj;
        Object coroutine_suspended;
        int i;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
        FlowCollector flowCollector2;
        Continuation continuation2;
        FlowCollector flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                obj = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 r9 = r0;
                    Function1 function1 = this.$this_asFlow$inlined;
                    r0.L$0 = this;
                    r0.L$1 = flowCollector;
                    r0.L$2 = r9;
                    r0.L$3 = flowCollector;
                    r0.L$4 = flowCollector;
                    r0.label = 1;
                    Object invoke = function1.invoke(r0);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 = this;
                    flowCollector2 = flowCollector;
                    continuation2 = r9;
                    obj = invoke;
                    flowCollector3 = flowCollector2;
                } else if (i == 1) {
                    flowCollector = (FlowCollector) r0.L$4;
                    flowCollector3 = (FlowCollector) r0.L$3;
                    continuation2 = (Continuation) r0.L$2;
                    flowCollector2 = (FlowCollector) r0.L$1;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2) r0.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    FlowCollector flowCollector4 = (FlowCollector) r0.L$3;
                    Continuation continuation3 = (Continuation) r0.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) r0.L$1;
                    FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$22 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2) r0.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r0.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
                r0.L$1 = flowCollector2;
                r0.L$2 = continuation2;
                r0.L$3 = flowCollector3;
                r0.label = 2;
                if (flowCollector.emit(obj, r0) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect(null, this);
            }
        };
        obj = r0.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        r0.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2;
        r0.L$1 = flowCollector2;
        r0.L$2 = continuation2;
        r0.L$3 = flowCollector3;
        r0.label = 2;
        if (flowCollector.emit(obj, r0) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 function1) {
        this.$this_asFlow$inlined = function1;
    }
}
