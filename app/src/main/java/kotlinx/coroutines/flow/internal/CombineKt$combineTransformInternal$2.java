package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.selects.SelectBuilderImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {143}, m = "invokeSuspend", n = {"$this$coroutineScope", "firstChannel", "secondChannel", "firstValue", "secondValue", "firstIsClosed", "secondIsClosed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* compiled from: Combine.kt */
final class CombineKt$combineTransformInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $first;
    final /* synthetic */ Flow $second;
    final /* synthetic */ FlowCollector $this_combineTransformInternal;
    final /* synthetic */ Function4 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineTransformInternal$2(FlowCollector flowCollector, Flow flow, Flow flow2, Function4 function4, Continuation continuation) {
        super(2, continuation);
        this.$this_combineTransformInternal = flowCollector;
        this.$first = flow;
        this.$second = flow2;
        this.$transform = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$2 = new CombineKt$combineTransformInternal$2(this.$this_combineTransformInternal, this.$first, this.$second, this.$transform, continuation);
        combineKt$combineTransformInternal$2.p$ = (CoroutineScope) obj;
        return combineKt$combineTransformInternal$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineTransformInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(1:(2:3|41)(2:4|5))(1:6)|7|(13:13|14|15|16|17|18|(1:20)(4:21|22|23|24)|25|(1:27)(1:28)|35|(1:37)|(0)(16:40|41|7|(0)|13|14|15|16|17|18|(0)(0)|25|(0)(0)|35|(0)|(0))|39)(2:11|12)|9|13|14|15|16|17|18|(0)(0)|25|(0)(0)|35|(0)|(0)(0)|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0132, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0134, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0136, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0137, code lost:
        r3 = r6;
        r19 = r7;
        r20 = r8;
        r21 = r9;
        r22 = r10;
        r23 = r11;
        r24 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0144, code lost:
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0146, code lost:
        r3.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cd A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d0 A[Catch:{ all -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0110 A[Catch:{ all -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0111 A[Catch:{ all -> 0x0132 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0159  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        CoroutineScope coroutineScope;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$2;
        Object obj2;
        Ref.ObjectRef objectRef3;
        Object result;
        boolean z;
        boolean z2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = this.p$;
            ReceiveChannel receiveChannel3 = CombineKt.asFairChannel(coroutineScope2, this.$first);
            ReceiveChannel receiveChannel4 = CombineKt.asFairChannel(coroutineScope2, this.$second);
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = null;
            Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            objectRef5.element = null;
            Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            booleanRef3.element = false;
            Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
            booleanRef4.element = false;
            coroutineScope = coroutineScope2;
            receiveChannel = receiveChannel4;
            objectRef2 = objectRef4;
            booleanRef = booleanRef3;
            objectRef = objectRef5;
            booleanRef2 = booleanRef4;
            obj2 = coroutine_suspended;
            combineKt$combineTransformInternal$2 = this;
            receiveChannel2 = receiveChannel3;
        } else if (i == 1) {
            CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$22 = (CombineKt$combineTransformInternal$2) this.L$7;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            booleanRef2 = (Ref.BooleanRef) this.L$6;
            booleanRef = (Ref.BooleanRef) this.L$5;
            objectRef = (Ref.ObjectRef) this.L$4;
            objectRef2 = (Ref.ObjectRef) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            receiveChannel2 = (ReceiveChannel) this.L$1;
            obj2 = coroutine_suspended;
            combineKt$combineTransformInternal$2 = this;
            i2 = 1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!booleanRef.element && booleanRef2.element) {
            return Unit.INSTANCE;
        }
        combineKt$combineTransformInternal$2.L$0 = coroutineScope;
        combineKt$combineTransformInternal$2.L$1 = receiveChannel2;
        combineKt$combineTransformInternal$2.L$2 = receiveChannel;
        combineKt$combineTransformInternal$2.L$3 = objectRef2;
        combineKt$combineTransformInternal$2.L$4 = objectRef;
        combineKt$combineTransformInternal$2.L$5 = booleanRef;
        combineKt$combineTransformInternal$2.L$6 = booleanRef2;
        combineKt$combineTransformInternal$2.L$7 = combineKt$combineTransformInternal$2;
        combineKt$combineTransformInternal$2.label = i2;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$23 = combineKt$combineTransformInternal$2;
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(combineKt$combineTransformInternal$23);
        SelectBuilderImpl selectBuilderImpl2 = selectBuilderImpl;
        z = booleanRef.element;
        SelectBuilderImpl selectBuilderImpl3 = selectBuilderImpl;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$24 = combineKt$combineTransformInternal$23;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$25 = combineKt$combineTransformInternal$2;
        CoroutineScope coroutineScope3 = coroutineScope;
        ReceiveChannel receiveChannel5 = receiveChannel2;
        ReceiveChannel receiveChannel6 = receiveChannel;
        Ref.ObjectRef objectRef6 = objectRef2;
        CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1(null, combineKt$combineTransformInternal$2, booleanRef, receiveChannel2, objectRef2, objectRef, booleanRef2, receiveChannel6);
        if (z) {
            objectRef3 = objectRef;
        } else {
            objectRef3 = objectRef;
            selectBuilderImpl2.invoke(receiveChannel5.getOnReceiveOrNull(), new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$2(combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1, null, combineKt$combineTransformInternal$25, booleanRef, receiveChannel5, objectRef6, objectRef, booleanRef2, receiveChannel6));
        }
        z2 = booleanRef2.element;
        CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3(null, combineKt$combineTransformInternal$25, booleanRef, receiveChannel5, objectRef6, objectRef3, booleanRef2, receiveChannel6);
        if (!z2) {
            selectBuilderImpl2.invoke(receiveChannel6.getOnReceiveOrNull(), new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4(combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3, null, combineKt$combineTransformInternal$25, booleanRef, receiveChannel5, objectRef6, objectRef3, booleanRef2, receiveChannel6));
        }
        result = selectBuilderImpl3.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(combineKt$combineTransformInternal$24);
        }
        if (result != obj2) {
            objectRef = objectRef3;
            combineKt$combineTransformInternal$2 = combineKt$combineTransformInternal$25;
            coroutineScope = coroutineScope3;
            receiveChannel2 = receiveChannel5;
            receiveChannel = receiveChannel6;
            objectRef2 = objectRef6;
            i2 = 1;
            if (!booleanRef.element) {
            }
            combineKt$combineTransformInternal$2.L$0 = coroutineScope;
            combineKt$combineTransformInternal$2.L$1 = receiveChannel2;
            combineKt$combineTransformInternal$2.L$2 = receiveChannel;
            combineKt$combineTransformInternal$2.L$3 = objectRef2;
            combineKt$combineTransformInternal$2.L$4 = objectRef;
            combineKt$combineTransformInternal$2.L$5 = booleanRef;
            combineKt$combineTransformInternal$2.L$6 = booleanRef2;
            combineKt$combineTransformInternal$2.L$7 = combineKt$combineTransformInternal$2;
            combineKt$combineTransformInternal$2.label = i2;
            CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$23 = combineKt$combineTransformInternal$2;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(combineKt$combineTransformInternal$23);
            SelectBuilderImpl selectBuilderImpl2 = selectBuilderImpl;
            z = booleanRef.element;
            SelectBuilderImpl selectBuilderImpl3 = selectBuilderImpl;
            CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$24 = combineKt$combineTransformInternal$23;
            CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$25 = combineKt$combineTransformInternal$2;
            CoroutineScope coroutineScope3 = coroutineScope;
            ReceiveChannel receiveChannel5 = receiveChannel2;
            ReceiveChannel receiveChannel6 = receiveChannel;
            Ref.ObjectRef objectRef6 = objectRef2;
            CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1(null, combineKt$combineTransformInternal$2, booleanRef, receiveChannel2, objectRef2, objectRef, booleanRef2, receiveChannel6);
            if (z) {
            }
            z2 = booleanRef2.element;
            CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3(null, combineKt$combineTransformInternal$25, booleanRef, receiveChannel5, objectRef6, objectRef3, booleanRef2, receiveChannel6);
            if (!z2) {
            }
            result = selectBuilderImpl3.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != obj2) {
            }
        }
        return obj2;
        combineKt$combineTransformInternal$2.L$0 = coroutineScope;
        combineKt$combineTransformInternal$2.L$1 = receiveChannel2;
        combineKt$combineTransformInternal$2.L$2 = receiveChannel;
        combineKt$combineTransformInternal$2.L$3 = objectRef2;
        combineKt$combineTransformInternal$2.L$4 = objectRef;
        combineKt$combineTransformInternal$2.L$5 = booleanRef;
        combineKt$combineTransformInternal$2.L$6 = booleanRef2;
        combineKt$combineTransformInternal$2.L$7 = combineKt$combineTransformInternal$2;
        combineKt$combineTransformInternal$2.label = i2;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$23 = combineKt$combineTransformInternal$2;
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(combineKt$combineTransformInternal$23);
        SelectBuilderImpl selectBuilderImpl2 = selectBuilderImpl;
        z = booleanRef.element;
        SelectBuilderImpl selectBuilderImpl3 = selectBuilderImpl;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$24 = combineKt$combineTransformInternal$23;
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$25 = combineKt$combineTransformInternal$2;
        CoroutineScope coroutineScope3 = coroutineScope;
        ReceiveChannel receiveChannel5 = receiveChannel2;
        ReceiveChannel receiveChannel6 = receiveChannel;
        Ref.ObjectRef objectRef6 = objectRef2;
        CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1(null, combineKt$combineTransformInternal$2, booleanRef, receiveChannel2, objectRef2, objectRef, booleanRef2, receiveChannel6);
        if (z) {
        }
        z2 = booleanRef2.element;
        CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3(null, combineKt$combineTransformInternal$25, booleanRef, receiveChannel5, objectRef6, objectRef3, booleanRef2, receiveChannel6);
        if (!z2) {
        }
        result = selectBuilderImpl3.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
        if (result != obj2) {
        }
        return obj2;
    }
}
