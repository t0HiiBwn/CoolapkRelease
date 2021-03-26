package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 implements Flow<T> {
    final /* synthetic */ Object[] $this_asFlow$inlined;

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(Object[] objArr) {
        this.$this_asFlow$inlined = objArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        int i;
        FlowCollector flowCollector2;
        int i2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6;
        Continuation continuation2;
        Object[] objArr;
        Object[] objArr2;
        int i3;
        Object obj;
        AnonymousClass1 r1;
        FlowCollector flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Object[] objArr3 = this.$this_asFlow$inlined;
                    i3 = objArr3.length;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 = this;
                    continuation2 = r0;
                    objArr2 = objArr3;
                    objArr = objArr2;
                    flowCollector2 = flowCollector;
                    obj = coroutine_suspended;
                    r1 = r0;
                    flowCollector3 = flowCollector2;
                    i2 = 0;
                } else if (i == 1) {
                    Object obj3 = r0.L$7;
                    Object obj4 = r0.L$6;
                    i2 = r0.I$1;
                    int i4 = r0.I$0;
                    continuation2 = (Continuation) r0.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                    flowCollector2 = (FlowCollector) r0.L$3;
                    objArr = (Object[]) r0.L$4;
                    objArr2 = (Object[]) r0.L$5;
                    i3 = i4;
                    obj = coroutine_suspended;
                    r1 = r0;
                    flowCollector3 = (FlowCollector) r0.L$1;
                    i2++;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i2 < i3) {
                    Object obj5 = objArr2[i2];
                    r1.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6;
                    r1.L$1 = flowCollector3;
                    r1.L$2 = continuation2;
                    r1.L$3 = flowCollector2;
                    r1.L$4 = objArr;
                    r1.L$5 = objArr2;
                    r1.I$0 = i3;
                    r1.I$1 = i2;
                    r1.L$6 = obj5;
                    r1.L$7 = obj5;
                    r1.label = 1;
                    if (flowCollector2.emit(obj5, r1) == obj) {
                        return obj;
                    }
                    i2++;
                    if (i2 < i3) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.AnonymousClass1 */
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 this$0;

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
        Object obj2 = r0.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        if (i2 < i3) {
        }
        return Unit.INSTANCE;
    }
}
