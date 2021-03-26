package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function4;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 r0;
        int i;
        FlowCollector flowCollector2;
        int i2;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        Continuation continuation2;
        long j;
        FlowCollector flowCollector3;
        AnonymousClass1 r1;
        AnonymousClass1 r02;
        Object obj;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        Throwable th;
        FlowCollector flowCollector4;
        Throwable th2;
        Object invoke;
        Object catchImpl;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    j = 0;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = this;
                    obj = coroutine_suspended;
                    r1 = r0;
                    r02 = r0;
                    flowCollector2 = flowCollector;
                } else if (i == 1) {
                    i2 = r0.I$0;
                    j = r0.J$0;
                    flowCollector3 = (FlowCollector) r0.L$3;
                    continuation2 = (Continuation) r0.L$2;
                    flowCollector4 = (FlowCollector) r0.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                    th2 = (Throwable) obj2;
                    if (th2 == null) {
                        Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$predicate$inlined;
                        Long boxLong = Boxing.boxLong(j);
                        r0.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                        r0.L$1 = flowCollector4;
                        r0.L$2 = continuation2;
                        r0.L$3 = flowCollector3;
                        r0.J$0 = j;
                        r0.L$4 = th2;
                        r0.label = 2;
                        invoke = function4.invoke(flowCollector3, th2, boxLong, r0);
                        if (invoke == coroutine_suspended) {
                            obj2 = invoke;
                            th = th2;
                            if (!((Boolean) obj2).booleanValue()) {
                            }
                            throw th;
                        }
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector4;
                    r1 = r0;
                    r02 = continuation2;
                    if (i2 != 0) {
                    }
                    return Unit.INSTANCE;
                } else if (i == 2) {
                    th = (Throwable) r0.L$4;
                    j = r0.J$0;
                    flowCollector3 = (FlowCollector) r0.L$3;
                    continuation2 = (Continuation) r0.L$2;
                    flowCollector4 = (FlowCollector) r0.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                    if (!((Boolean) obj2).booleanValue()) {
                        j++;
                        flowCollector2 = flowCollector4;
                        i2 = 1;
                        r1 = r0;
                        r02 = continuation2;
                        if (i2 != 0) {
                            flowCollector = flowCollector3;
                            obj = coroutine_suspended;
                            j = j;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                        }
                        return Unit.INSTANCE;
                    }
                    throw th;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
                r1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                r1.L$1 = flowCollector2;
                r1.L$2 = r02;
                r1.L$3 = flowCollector;
                r1.J$0 = j;
                r1.I$0 = 0;
                r1.label = 1;
                catchImpl = FlowKt.catchImpl(flow, flowCollector, r1);
                if (catchImpl == obj) {
                    flowCollector4 = flowCollector2;
                    obj2 = catchImpl;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                    continuation2 = r02;
                    r0 = r1;
                    coroutine_suspended = obj;
                    flowCollector3 = flowCollector;
                    i2 = 0;
                    th2 = (Throwable) obj2;
                    if (th2 == null) {
                        flowCollector2 = flowCollector4;
                        r1 = r0;
                        r02 = continuation2;
                        if (i2 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$predicate$inlined;
                    Long boxLong = Boxing.boxLong(j);
                    r0.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    r0.L$1 = flowCollector4;
                    r0.L$2 = continuation2;
                    r0.L$3 = flowCollector3;
                    r0.J$0 = j;
                    r0.L$4 = th2;
                    r0.label = 2;
                    invoke = function4.invoke(flowCollector3, th2, boxLong, r0);
                    if (invoke == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1 */
            int I$0;
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 this$0;

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
        Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$this_retryWhen$inlined;
        r1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        r1.L$1 = flowCollector2;
        r1.L$2 = r02;
        r1.L$3 = flowCollector;
        r1.J$0 = j;
        r1.I$0 = 0;
        r1.label = 1;
        catchImpl = FlowKt.catchImpl(flow, flowCollector, r1);
        if (catchImpl == obj) {
        }
        return obj;
    }
}
