package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Collect.kt */
public final class FlowKt__CountKt$count$$inlined$collect$2 implements FlowCollector<T> {
    final /* synthetic */ Ref.IntRef $i$inlined;
    final /* synthetic */ Function2 $predicate$inlined;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 r0;
        Object obj2;
        int i;
        FlowKt__CountKt$count$$inlined$collect$2 flowKt__CountKt$count$$inlined$collect$2;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Function2 function2 = this.$predicate$inlined;
                    r0.L$0 = this;
                    r0.L$1 = obj;
                    r0.L$2 = r0;
                    r0.L$3 = obj;
                    r0.label = 1;
                    obj2 = function2.invoke(obj, r0);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__CountKt$count$$inlined$collect$2 = this;
                } else if (i == 1) {
                    Object obj3 = r0.L$3;
                    Continuation continuation2 = (Continuation) r0.L$2;
                    Object obj4 = r0.L$1;
                    flowKt__CountKt$count$$inlined$collect$2 = (FlowKt__CountKt$count$$inlined$collect$2) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj2).booleanValue()) {
                    Ref.IntRef intRef = flowKt__CountKt$count$$inlined$collect$2.$i$inlined;
                    intRef.element++;
                    int i2 = intRef.element;
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__CountKt$count$$inlined$collect$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        };
        obj2 = r0.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        if (((Boolean) obj2).booleanValue()) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__CountKt$count$$inlined$collect$2(Function2 function2, Ref.IntRef intRef) {
        this.$predicate$inlined = function2;
        this.$i$inlined = intRef;
    }
}
