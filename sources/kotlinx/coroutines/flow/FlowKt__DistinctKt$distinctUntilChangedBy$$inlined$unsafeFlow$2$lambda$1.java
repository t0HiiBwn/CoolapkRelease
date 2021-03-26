package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__DistinctKt$$special$$inlined$collect$2"}, k = 1, mv = {1, 1, 16})
/* compiled from: Collect.kt */
public final class FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1 implements FlowCollector<T> {
    final /* synthetic */ Ref.ObjectRef $previousKey$inlined;
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    final /* synthetic */ FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2 this$0;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 r0;
        int i;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    T t = (T) this.this$0.$keySelector$inlined.invoke(obj);
                    if (this.$previousKey$inlined.element == NullSurrogateKt.NULL || !((Boolean) this.this$0.$areEquivalent$inlined.invoke(this.$previousKey$inlined.element, t)).booleanValue()) {
                        this.$previousKey$inlined.element = t;
                        FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
                        r0.L$0 = this;
                        r0.L$1 = obj;
                        r0.L$2 = r0;
                        r0.L$3 = obj;
                        r0.L$4 = t;
                        r0.label = 1;
                        if (flowCollector.emit(obj, r0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 1) {
                    Object obj3 = r0.L$4;
                    Object obj4 = r0.L$3;
                    AnonymousClass1 r6 = (AnonymousClass1) r0.L$2;
                    Object obj5 = r0.L$1;
                    FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1 flowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1 = (FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1 this$0;

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
        Object obj2 = r0.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1(FlowCollector flowCollector, Ref.ObjectRef objectRef, FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2 flowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.$previousKey$inlined = objectRef;
        this.this$0 = flowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2;
    }

    public Object emit$$forInline(Object obj, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$2$lambda$1 this$0;

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
        InlineMarker.mark(5);
        T t = (T) this.this$0.$keySelector$inlined.invoke(obj);
        if (this.$previousKey$inlined.element == NullSurrogateKt.NULL || !((Boolean) this.this$0.$areEquivalent$inlined.invoke(this.$previousKey$inlined.element, t)).booleanValue()) {
            this.$previousKey$inlined.element = t;
            FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
            InlineMarker.mark(0);
            Object emit = flowCollector.emit(obj, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            Unit unit = (Unit) emit;
        }
        return Unit.INSTANCE;
    }
}
