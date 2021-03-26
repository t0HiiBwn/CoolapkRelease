package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements Flow<Long> {
    final /* synthetic */ long[] $this_asFlow$inlined;

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.$this_asFlow$inlined = jArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super Long> flowCollector, Continuation continuation) {
        AnonymousClass1 r2;
        int i;
        int i2;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8;
        Continuation continuation2;
        long[] jArr;
        long[] jArr2;
        Object obj;
        int i3;
        AnonymousClass1 r3;
        FlowCollector<? super Long> flowCollector2;
        FlowCollector<? super Long> flowCollector3;
        int i4;
        Object obj2;
        int i5;
        FlowCollector<? super Long> flowCollector4;
        if (continuation instanceof AnonymousClass1) {
            r2 = (AnonymousClass1) continuation;
            if ((r2.label & Integer.MIN_VALUE) != 0) {
                r2.label -= Integer.MIN_VALUE;
                Object obj3 = r2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    long[] jArr3 = this.$this_asFlow$inlined;
                    i5 = jArr3.length;
                    i4 = 0;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 = this;
                    continuation2 = r2;
                    jArr2 = jArr3;
                    jArr = jArr2;
                    FlowCollector<? super Long> flowCollector5 = flowCollector;
                    obj2 = coroutine_suspended;
                    r3 = r2;
                    flowCollector2 = flowCollector5;
                    flowCollector4 = flowCollector5;
                } else if (i == 1) {
                    long j = r2.J$1;
                    long j2 = r2.J$0;
                    i3 = r2.I$1;
                    int i6 = r2.I$0;
                    continuation2 = (Continuation) r2.L$2;
                    flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8) r2.L$0;
                    ResultKt.throwOnFailure(obj3);
                    i2 = i6;
                    flowCollector3 = (FlowCollector) r2.L$3;
                    obj = coroutine_suspended;
                    jArr = (long[]) r2.L$4;
                    r3 = r2;
                    jArr2 = (long[]) r2.L$5;
                    flowCollector2 = (FlowCollector) r2.L$1;
                    i4 = i3 + 1;
                    obj2 = obj;
                    i5 = i2;
                    flowCollector4 = flowCollector3;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i4 < i5) {
                    long j3 = jArr2[i4];
                    long longValue = Boxing.boxLong(j3).longValue();
                    Long boxLong = Boxing.boxLong(longValue);
                    r3.L$0 = flowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8;
                    r3.L$1 = flowCollector2;
                    r3.L$2 = continuation2;
                    r3.L$3 = flowCollector4;
                    r3.L$4 = jArr;
                    r3.L$5 = jArr2;
                    i2 = i5;
                    r3.I$0 = i2;
                    r3.I$1 = i4;
                    r3.J$0 = j3;
                    r3.J$1 = longValue;
                    r3.label = 1;
                    if (flowCollector4.emit(boxLong, r3) != obj2) {
                        obj = obj2;
                        i3 = i4;
                        flowCollector3 = flowCollector4;
                        i4 = i3 + 1;
                        obj2 = obj;
                        i5 = i2;
                        flowCollector4 = flowCollector3;
                        if (i4 < i5) {
                        }
                    }
                    return obj2;
                }
                return Unit.INSTANCE;
            }
        }
        r2 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.AnonymousClass1 */
            int I$0;
            int I$1;
            long J$0;
            long J$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 this$0;

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
        Object obj3 = r2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r2.label;
        if (i != 0) {
        }
        if (i4 < i5) {
        }
        return Unit.INSTANCE;
    }
}
