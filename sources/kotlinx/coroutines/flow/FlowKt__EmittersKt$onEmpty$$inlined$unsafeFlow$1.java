package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onEmpty$inlined;

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_onEmpty$inlined = flow;
        this.$action$inlined = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        Ref.BooleanRef booleanRef;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        Continuation continuation2;
        FlowCollector flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 r10 = r0;
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    booleanRef2.element = true;
                    Flow flow = this.$this_onEmpty$inlined;
                    r0.L$0 = this;
                    r0.L$1 = flowCollector;
                    r0.L$2 = r10;
                    r0.L$3 = flowCollector;
                    r0.L$4 = booleanRef2;
                    r0.L$5 = flow;
                    r0.label = 1;
                    if (flow.collect(new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$lambda$1(flowCollector, booleanRef2), r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    continuation2 = r10;
                    booleanRef = booleanRef2;
                    flowCollector3 = flowCollector2;
                } else if (i == 1) {
                    Flow flow2 = (Flow) r0.L$5;
                    booleanRef = (Ref.BooleanRef) r0.L$4;
                    flowCollector3 = (FlowCollector) r0.L$3;
                    continuation2 = (Continuation) r0.L$2;
                    flowCollector2 = (FlowCollector) r0.L$1;
                    flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) r0.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    safeCollector = (SafeCollector) r0.L$5;
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) r0.L$4;
                    FlowCollector flowCollector4 = (FlowCollector) r0.L$3;
                    Continuation continuation3 = (Continuation) r0.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) r0.L$1;
                    FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$12 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) r0.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        safeCollector.releaseIntercepted();
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (booleanRef.element) {
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector3, r0.getContext());
                    try {
                        Function2 function2 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.$action$inlined;
                        r0.L$0 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
                        r0.L$1 = flowCollector2;
                        r0.L$2 = continuation2;
                        r0.L$3 = flowCollector3;
                        r0.L$4 = booleanRef;
                        r0.L$5 = safeCollector2;
                        r0.label = 2;
                        InlineMarker.mark(6);
                        Object invoke = function2.invoke(safeCollector2, r0);
                        InlineMarker.mark(7);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 this$0;

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
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = r0.label;
        if (i != 0) {
        }
        if (booleanRef.element) {
        }
        return Unit.INSTANCE;
    }
}
