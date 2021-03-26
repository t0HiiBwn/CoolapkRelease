package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Collect.kt */
public final class ChannelFlowMerge$collectTo$$inlined$collect$1 implements FlowCollector<Flow<? extends T>> {
    final /* synthetic */ SendingCollector $collector$inlined;
    final /* synthetic */ Job $job$inlined;
    final /* synthetic */ ProducerScope $scope$inlined;
    final /* synthetic */ Semaphore $semaphore$inlined;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 r0;
        int i;
        Flow flow;
        ChannelFlowMerge$collectTo$$inlined$collect$1 channelFlowMerge$collectTo$$inlined$collect$1;
        if (continuation instanceof AnonymousClass1) {
            r0 = (AnonymousClass1) continuation;
            if ((r0.label & Integer.MIN_VALUE) != 0) {
                r0.label -= Integer.MIN_VALUE;
                Object obj2 = r0.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = r0.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass1 r9 = r0;
                    Flow flow2 = (Flow) obj;
                    Job job = this.$job$inlined;
                    if (job != null) {
                        JobKt.ensureActive(job);
                    }
                    Semaphore semaphore = this.$semaphore$inlined;
                    r0.L$0 = this;
                    r0.L$1 = obj;
                    r0.L$2 = r9;
                    r0.L$3 = flow2;
                    r0.label = 1;
                    if (semaphore.acquire(r0) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    channelFlowMerge$collectTo$$inlined$collect$1 = this;
                    flow = flow2;
                } else if (i == 1) {
                    flow = (Flow) r0.L$3;
                    Continuation continuation2 = (Continuation) r0.L$2;
                    Object obj3 = r0.L$1;
                    channelFlowMerge$collectTo$$inlined$collect$1 = (ChannelFlowMerge$collectTo$$inlined$collect$1) r0.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(channelFlowMerge$collectTo$$inlined$collect$1.$scope$inlined, null, null, new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(flow, null, channelFlowMerge$collectTo$$inlined$collect$1), 3, null);
                return Unit.INSTANCE;
            }
        }
        r0 = new ContinuationImpl(this, continuation) {
            /* class kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.AnonymousClass1 */
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 this$0;

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
        Job unused = BuildersKt__Builders_commonKt.launch$default(channelFlowMerge$collectTo$$inlined$collect$1.$scope$inlined, null, null, new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(flow, null, channelFlowMerge$collectTo$$inlined$collect$1), 3, null);
        return Unit.INSTANCE;
    }

    public ChannelFlowMerge$collectTo$$inlined$collect$1(Job job, Semaphore semaphore, ProducerScope producerScope, SendingCollector sendingCollector) {
        this.$job$inlined = job;
        this.$semaphore$inlined = semaphore;
        this.$scope$inlined = producerScope;
        this.$collector$inlined = sendingCollector;
    }
}
