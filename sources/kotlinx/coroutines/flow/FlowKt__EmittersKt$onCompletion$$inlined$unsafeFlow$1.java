package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        Object coroutine_suspended;
        int i;
        FlowCollector flowCollector2;
        Throwable th;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        FlowCollector flowCollector3;
        AnonymousClass1 r2;
        Throwable th2;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        Object invoke;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj = r0.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    r2 = r0;
                    try {
                        Flow flow = this.$this_onCompletion$inlined;
                        r0.L$0 = this;
                        r0.L$1 = flowCollector;
                        r0.L$2 = r2;
                        r0.L$3 = flowCollector;
                        r0.label = 1;
                        if (flow.collect(flowCollector, r0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        flowCollector3 = flowCollector;
                    } catch (Throwable th3) {
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        flowCollector3 = flowCollector;
                        th = th3;
                        flowCollector2 = flowCollector3;
                        Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                        r0.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                        r0.L$1 = flowCollector3;
                        r0.L$2 = r2;
                        r0.L$3 = flowCollector2;
                        r0.L$4 = th;
                        r0.label = 2;
                        if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(new ThrowingCollector(th), function3, th, r0) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw th;
                    }
                } else if (i == 1) {
                    flowCollector = (FlowCollector) r0.L$3;
                    r2 = (Continuation) r0.L$2;
                    flowCollector3 = (FlowCollector) r0.L$1;
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        flowCollector2 = flowCollector;
                        th = th4;
                    }
                } else if (i == 2) {
                    Throwable th5 = (Throwable) r0.L$4;
                    FlowCollector flowCollector4 = (FlowCollector) r0.L$3;
                    Continuation continuation2 = (Continuation) r0.L$2;
                    FlowCollector flowCollector5 = (FlowCollector) r0.L$1;
                    FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$12 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th5;
                } else if (i == 3) {
                    safeCollector = (SafeCollector) r0.L$4;
                    FlowCollector flowCollector6 = (FlowCollector) r0.L$3;
                    Continuation continuation3 = (Continuation) r0.L$2;
                    FlowCollector flowCollector7 = (FlowCollector) r0.L$1;
                    FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$13 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        safeCollector.releaseIntercepted();
                        return Unit.INSTANCE;
                    } catch (Throwable th6) {
                        th2 = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                safeCollector2 = new SafeCollector(flowCollector, r0.getContext());
                Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                r0.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
                r0.L$1 = flowCollector3;
                r0.L$2 = r2;
                r0.L$3 = flowCollector;
                r0.L$4 = safeCollector2;
                r0.label = 3;
                InlineMarker.mark(6);
                invoke = function32.invoke(safeCollector2, null, r0);
                InlineMarker.mark(7);
                if (invoke != coroutine_suspended) {
                    return coroutine_suspended;
                }
                safeCollector = safeCollector2;
                safeCollector.releaseIntercepted();
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 this$0;

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
        safeCollector2 = new SafeCollector(flowCollector, r0.getContext());
        try {
            Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            r0.L$0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
            r0.L$1 = flowCollector3;
            r0.L$2 = r2;
            r0.L$3 = flowCollector;
            r0.L$4 = safeCollector2;
            r0.label = 3;
            InlineMarker.mark(6);
            invoke = function32.invoke(safeCollector2, null, r0);
            InlineMarker.mark(7);
            if (invoke != coroutine_suspended) {
            }
        } catch (Throwable th7) {
            th2 = th7;
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            throw th2;
        }
    }
}
