package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$2"}, k = 1, mv = {1, 1, 16})
/* compiled from: Collect.kt */
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 implements FlowCollector<T> {
    final /* synthetic */ Ref.BooleanRef $matched$inlined;
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    final /* synthetic */ FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 this$0;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 r0;
        Object obj2;
        int i;
        FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1;
        Object obj3;
        AnonymousClass1 r2;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            obj = r0.L$3;
                            r2 = (Continuation) r0.L$2;
                            obj3 = r0.L$1;
                            flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 = (FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1) r0.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    Object obj4 = r0.L$3;
                    Continuation continuation2 = (Continuation) r0.L$2;
                    Object obj5 = r0.L$1;
                    FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$12 = (FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj2);
                r2 = r0;
                if (this.$matched$inlined.element) {
                    FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
                    r0.L$0 = this;
                    r0.L$1 = obj;
                    r0.L$2 = r2;
                    r0.L$3 = obj;
                    r0.label = 1;
                    if (flowCollector.emit(obj, r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                Function2 function2 = this.this$0.$predicate$inlined;
                r0.L$0 = this;
                r0.L$1 = obj;
                r0.L$2 = r2;
                r0.L$3 = obj;
                r0.label = 2;
                obj2 = function2.invoke(obj, r0);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 = this;
                obj3 = obj;
                if (!((Boolean) obj2).booleanValue()) {
                    flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1.$matched$inlined.element = true;
                    FlowCollector flowCollector2 = flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow$inlined;
                    r0.L$0 = flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1;
                    r0.L$1 = obj3;
                    r0.L$2 = r2;
                    r0.L$3 = obj;
                    r0.label = 3;
                    if (flowCollector2.emit(obj, r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 this$0;

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
        if (i == 0) {
        }
        if (!((Boolean) obj2).booleanValue()) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Ref.BooleanRef booleanRef, FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.$matched$inlined = booleanRef;
        this.this$0 = flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1;
    }
}
