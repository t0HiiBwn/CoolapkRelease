package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.ranges.LongRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 implements Flow<Long> {
    final /* synthetic */ LongRange $this_asFlow$inlined;

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(LongRange longRange) {
        this.$this_asFlow$inlined = longRange;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Long> flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        int i;
        FlowCollector<? super Long> flowCollector2;
        Iterator it2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10;
        Continuation continuation2;
        Iterable iterable;
        Object obj;
        AnonymousClass1 r1;
        FlowCollector<? super Long> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    LongRange longRange = this.$this_asFlow$inlined;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 = this;
                    continuation2 = r0;
                    flowCollector2 = flowCollector;
                    it2 = longRange.iterator();
                    iterable = longRange;
                    obj = coroutine_suspended;
                    r1 = r0;
                    flowCollector3 = flowCollector2;
                } else if (i == 1) {
                    long j = r0.J$0;
                    Object obj3 = r0.L$6;
                    it2 = (Iterator) r0.L$5;
                    continuation2 = (Continuation) r0.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                    flowCollector2 = (FlowCollector) r0.L$3;
                    iterable = (Iterable) r0.L$4;
                    obj = coroutine_suspended;
                    r1 = r0;
                    flowCollector3 = (FlowCollector) r0.L$1;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it2.hasNext()) {
                    Object next = it2.next();
                    long longValue = ((Number) next).longValue();
                    Long boxLong = Boxing.boxLong(longValue);
                    r1.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10;
                    r1.L$1 = flowCollector3;
                    r1.L$2 = continuation2;
                    r1.L$3 = flowCollector2;
                    r1.L$4 = iterable;
                    r1.L$5 = it2;
                    r1.L$6 = next;
                    r1.J$0 = longValue;
                    r1.label = 1;
                    if (flowCollector2.emit(boxLong, r1) == obj) {
                        return obj;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.AnonymousClass1 */
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 this$0;

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
        while (it2.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
