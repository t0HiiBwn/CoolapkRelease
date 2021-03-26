package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {137}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounce$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_debounce;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private CoroutineScope p$;
    private FlowCollector p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$2(Flow flow, long j, Continuation continuation) {
        super(3, continuation);
        this.$this_debounce = flow;
        this.$timeoutMillis = j;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2 = new FlowKt__DelayKt$debounce$2(this.$this_debounce, this.$timeoutMillis, continuation);
        flowKt__DelayKt$debounce$2.p$ = coroutineScope;
        flowKt__DelayKt$debounce$2.p$0 = flowCollector;
        return flowKt__DelayKt$debounce$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounce$2) create(coroutineScope, (FlowCollector) obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:9|(2:10|11)|12|13|14|(4:16|17|18|19)(1:21)|27|(1:29)|(0)(4:32|33|7|(0)(0))|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bb, code lost:
        r16 = r10;
        r19 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bf, code lost:
        r1.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0060  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2;
        Object obj2;
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$22;
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$23;
        SelectBuilderImpl selectBuilderImpl;
        SelectBuilderImpl selectBuilderImpl2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = this.p$;
            FlowCollector flowCollector2 = this.p$0;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope2, null, -1, new FlowKt__DelayKt$debounce$2$values$1(this, null), 1, null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = null;
            flowKt__DelayKt$debounce$2 = this;
            coroutineScope = coroutineScope2;
            receiveChannel = produce$default;
            objectRef = objectRef2;
            flowCollector = flowCollector2;
            obj2 = coroutine_suspended;
        } else if (i == 1) {
            FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$24 = (FlowKt__DelayKt$debounce$2) this.L$4;
            ResultKt.throwOnFailure(obj);
            flowKt__DelayKt$debounce$2 = this;
            objectRef = (Ref.ObjectRef) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            flowCollector = (FlowCollector) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            obj2 = coroutine_suspended;
            i2 = 1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef.element == NullSurrogateKt.DONE) {
            flowKt__DelayKt$debounce$2.L$0 = coroutineScope;
            flowKt__DelayKt$debounce$2.L$1 = flowCollector;
            flowKt__DelayKt$debounce$2.L$2 = receiveChannel;
            flowKt__DelayKt$debounce$2.L$3 = objectRef;
            flowKt__DelayKt$debounce$2.L$4 = flowKt__DelayKt$debounce$2;
            flowKt__DelayKt$debounce$2.label = i2;
            FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$25 = flowKt__DelayKt$debounce$2;
            SelectBuilderImpl selectBuilderImpl3 = new SelectBuilderImpl(flowKt__DelayKt$debounce$25);
            try {
                selectBuilderImpl2 = selectBuilderImpl3;
            } catch (Throwable th) {
                Throwable th2 = th;
                selectBuilderImpl = selectBuilderImpl3;
            }
            selectBuilderImpl = selectBuilderImpl3;
            selectBuilderImpl2.invoke(receiveChannel.getOnReceiveOrNull(), new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1(null, flowKt__DelayKt$debounce$2, receiveChannel, objectRef, flowCollector));
            T t = objectRef.element;
            if (t != null) {
                flowKt__DelayKt$debounce$23 = flowKt__DelayKt$debounce$25;
                flowKt__DelayKt$debounce$22 = flowKt__DelayKt$debounce$2;
                selectBuilderImpl2.onTimeout(flowKt__DelayKt$debounce$2.$timeoutMillis, new FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(t, null, selectBuilderImpl2, flowKt__DelayKt$debounce$2, receiveChannel, objectRef, flowCollector));
            } else {
                flowKt__DelayKt$debounce$23 = flowKt__DelayKt$debounce$25;
                flowKt__DelayKt$debounce$22 = flowKt__DelayKt$debounce$2;
            }
            Object result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(flowKt__DelayKt$debounce$23);
            }
            if (result == obj2) {
                flowKt__DelayKt$debounce$2 = flowKt__DelayKt$debounce$22;
                i2 = 1;
                if (objectRef.element == NullSurrogateKt.DONE) {
                }
            }
            return obj2;
        }
        return Unit.INSTANCE;
    }
}
