package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilderImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {354, 358}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_debounceInternal;
    final /* synthetic */ Function1 $timeoutMillisSelector;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    private CoroutineScope p$;
    private FlowCollector p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Flow flow, Function1 function1, Continuation continuation) {
        super(3, continuation);
        this.$this_debounceInternal = flow;
        this.$timeoutMillisSelector = function1;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$this_debounceInternal, this.$timeoutMillisSelector, continuation);
        flowKt__DelayKt$debounceInternal$1.p$ = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.p$0 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1) create(coroutineScope, (FlowCollector) obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:7|29|30|33|(4:35|(1:40)(1:39)|41|(2:43|44))|45|46|47|(5:49|50|51|52|53)(1:56)|57|58|63|(1:65)|(0)(2:68|69)|67) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:49|50|51|52|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0154, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0155, code lost:
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x017b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x017d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017e, code lost:
        r8 = r10;
        r19 = r11;
        r20 = r12;
        r21 = r11;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0186, code lost:
        r8.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0134 A[Catch:{ all -> 0x017d }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0199  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        FlowCollector flowCollector;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1;
        Ref.LongRef longRef;
        FlowCollector flowCollector2;
        CoroutineScope coroutineScope2;
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$12;
        SelectBuilderImpl selectBuilderImpl;
        Ref.ObjectRef objectRef3;
        Object result;
        SelectBuilderImpl selectBuilderImpl2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 2;
        long j = 0;
        int i3 = 1;
        T t = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = this.p$;
            FlowCollector flowCollector3 = this.p$0;
            objectRef = new Ref.ObjectRef();
            objectRef.element = (T) ProduceKt.produce$default(coroutineScope3, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this, null), 3, null);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = null;
            coroutineScope = coroutineScope3;
            flowKt__DelayKt$debounceInternal$1 = this;
            flowCollector = flowCollector3;
            objectRef2 = objectRef4;
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$3;
            objectRef = (Ref.ObjectRef) this.L$2;
            flowCollector = (FlowCollector) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            longRef = (Ref.LongRef) this.L$4;
            flowKt__DelayKt$debounceInternal$1 = this;
            objectRef2.element = t;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!Boxing.boxBoolean(objectRef2.element == null || longRef.element > j).booleanValue()) {
                    throw new AssertionError();
                }
            }
            flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
            flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
            flowKt__DelayKt$debounceInternal$1.L$2 = objectRef;
            flowKt__DelayKt$debounceInternal$1.L$3 = objectRef2;
            flowKt__DelayKt$debounceInternal$1.L$4 = longRef;
            flowKt__DelayKt$debounceInternal$1.L$5 = flowKt__DelayKt$debounceInternal$1;
            flowKt__DelayKt$debounceInternal$1.label = i2;
            FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$13 = flowKt__DelayKt$debounceInternal$1;
            SelectBuilderImpl selectBuilderImpl3 = new SelectBuilderImpl(flowKt__DelayKt$debounceInternal$13);
            SelectBuilderImpl selectBuilderImpl4 = selectBuilderImpl3;
            if (objectRef2.element == null) {
                selectBuilderImpl2 = selectBuilderImpl4;
                selectBuilderImpl = selectBuilderImpl3;
                flowKt__DelayKt$debounceInternal$12 = flowKt__DelayKt$debounceInternal$13;
                coroutineScope2 = coroutineScope;
                flowCollector2 = flowCollector;
                selectBuilderImpl2.onTimeout(longRef.element, new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1(null, objectRef2, longRef, flowCollector, objectRef));
                objectRef3 = objectRef;
            } else {
                selectBuilderImpl2 = selectBuilderImpl4;
                selectBuilderImpl = selectBuilderImpl3;
                flowKt__DelayKt$debounceInternal$12 = flowKt__DelayKt$debounceInternal$13;
                coroutineScope2 = coroutineScope;
                flowCollector2 = flowCollector;
                objectRef3 = objectRef;
            }
            selectBuilderImpl2.invoke(objectRef3.element.getOnReceiveOrNull(), new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(null, objectRef2, longRef, flowCollector2, objectRef3));
            result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(flowKt__DelayKt$debounceInternal$12);
            }
            if (result != coroutine_suspended) {
                coroutine_suspended = coroutine_suspended;
                objectRef2 = objectRef2;
                objectRef = objectRef3;
                flowKt__DelayKt$debounceInternal$1 = flowKt__DelayKt$debounceInternal$1;
                coroutineScope = coroutineScope2;
                flowCollector = flowCollector2;
                i2 = 2;
                j = 0;
                i3 = 1;
                t = null;
            }
            return coroutine_suspended;
        } else if (i == 2) {
            FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$14 = (FlowKt__DelayKt$debounceInternal$1) this.L$5;
            Ref.LongRef longRef2 = (Ref.LongRef) this.L$4;
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            flowCollector = (FlowCollector) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$2;
            objectRef2 = (Ref.ObjectRef) this.L$3;
            flowKt__DelayKt$debounceInternal$1 = this;
            i2 = 2;
            j = 0;
            i3 = 1;
            t = null;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef2.element != NullSurrogateKt.DONE) {
            longRef = new Ref.LongRef();
            longRef.element = j;
            if (objectRef2.element != null) {
                Function1 function1 = flowKt__DelayKt$debounceInternal$1.$timeoutMillisSelector;
                Symbol symbol = NullSurrogateKt.NULL;
                T t2 = objectRef2.element;
                if (t2 == symbol) {
                    t2 = t;
                }
                longRef.element = ((Number) function1.invoke(t2)).longValue();
                if (longRef.element >= j) {
                    if (longRef.element == j) {
                        Symbol symbol2 = NullSurrogateKt.NULL;
                        T t3 = objectRef2.element;
                        if (t3 == symbol2) {
                            t3 = t;
                        }
                        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
                        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
                        flowKt__DelayKt$debounceInternal$1.L$2 = objectRef;
                        flowKt__DelayKt$debounceInternal$1.L$3 = objectRef2;
                        flowKt__DelayKt$debounceInternal$1.L$4 = longRef;
                        flowKt__DelayKt$debounceInternal$1.label = i3;
                        if (flowCollector.emit(t3, flowKt__DelayKt$debounceInternal$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2.element = t;
                    }
                }
                throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
            }
            flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
            flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
            flowKt__DelayKt$debounceInternal$1.L$2 = objectRef;
            flowKt__DelayKt$debounceInternal$1.L$3 = objectRef2;
            flowKt__DelayKt$debounceInternal$1.L$4 = longRef;
            flowKt__DelayKt$debounceInternal$1.L$5 = flowKt__DelayKt$debounceInternal$1;
            flowKt__DelayKt$debounceInternal$1.label = i2;
            FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$13 = flowKt__DelayKt$debounceInternal$1;
            SelectBuilderImpl selectBuilderImpl3 = new SelectBuilderImpl(flowKt__DelayKt$debounceInternal$13);
            SelectBuilderImpl selectBuilderImpl4 = selectBuilderImpl3;
            if (objectRef2.element == null) {
            }
            selectBuilderImpl2.invoke(objectRef3.element.getOnReceiveOrNull(), new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(null, objectRef2, longRef, flowCollector2, objectRef3));
            result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
