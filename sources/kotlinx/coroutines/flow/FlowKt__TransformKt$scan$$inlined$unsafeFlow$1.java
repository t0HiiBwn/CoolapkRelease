package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_scan$inlined;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        Object coroutine_suspended;
        int i;
        FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Continuation continuation2;
        Ref.ObjectRef objectRef;
        Flow flow;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 r11 = r0;
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = (T) this.$initial$inlined;
                    T t = objectRef.element;
                    r0.L$0 = this;
                    r0.L$1 = flowCollector;
                    r0.L$2 = r11;
                    r0.L$3 = flowCollector;
                    r0.L$4 = objectRef;
                    r0.label = 1;
                    if (flowCollector.emit(t, r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$scan$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    continuation2 = r11;
                } else if (i == 1) {
                    FlowCollector flowCollector3 = (FlowCollector) r0.L$3;
                    continuation2 = (Continuation) r0.L$2;
                    flowCollector2 = (FlowCollector) r0.L$1;
                    flowKt__TransformKt$scan$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$scan$$inlined$unsafeFlow$1) r0.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = (Ref.ObjectRef) r0.L$4;
                    flowCollector = flowCollector3;
                } else if (i == 2) {
                    Flow flow2 = (Flow) r0.L$5;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) r0.L$4;
                    FlowCollector flowCollector4 = (FlowCollector) r0.L$3;
                    Continuation continuation3 = (Continuation) r0.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) r0.L$1;
                    FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 flowKt__TransformKt$scan$$inlined$unsafeFlow$12 = (FlowKt__TransformKt$scan$$inlined$unsafeFlow$1) r0.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flow = flowKt__TransformKt$scan$$inlined$unsafeFlow$1.$this_scan$inlined;
                r0.L$0 = flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
                r0.L$1 = flowCollector2;
                r0.L$2 = continuation2;
                r0.L$3 = flowCollector;
                r0.L$4 = objectRef;
                r0.L$5 = flow;
                r0.label = 2;
                if (flow.collect(new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1(flowCollector, objectRef, flowKt__TransformKt$scan$$inlined$unsafeFlow$1), r0) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 this$0;

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
        Object obj = r0.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        flow = flowKt__TransformKt$scan$$inlined$unsafeFlow$1.$this_scan$inlined;
        r0.L$0 = flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
        r0.L$1 = flowCollector2;
        r0.L$2 = continuation2;
        r0.L$3 = flowCollector;
        r0.L$4 = objectRef;
        r0.L$5 = flow;
        r0.label = 2;
        if (flow.collect(new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1(flowCollector, objectRef, flowKt__TransformKt$scan$$inlined$unsafeFlow$1), r0) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(Flow flow, Object obj, Function3 function3) {
        this.$this_scan$inlined = flow;
        this.$initial$inlined = obj;
        this.$operation$inlined = function3;
    }
}
