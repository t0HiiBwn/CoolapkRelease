package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.selects.SelectBuilderImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {143}, m = "invokeSuspend", n = {"$this$coroutineScope", "size", "channels", "latestValues", "isClosed", "nonClosed", "remainingNulls"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, continuation);
        combineKt$combineInternal$2.p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Boolean[] boolArr;
        Object[] objArr;
        ReceiveChannel[] receiveChannelArr;
        int i;
        CoroutineScope coroutineScope;
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        Object obj2;
        Ref.IntRef intRef3;
        Boolean[] boolArr2;
        Object[] objArr2;
        ReceiveChannel[] receiveChannelArr2;
        int i2;
        CoroutineScope coroutineScope2;
        CombineKt$combineInternal$2 combineKt$combineInternal$22;
        CombineKt$combineInternal$2 combineKt$combineInternal$23;
        Ref.IntRef intRef4;
        SelectBuilderImpl selectBuilderImpl;
        Object result;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i4 = 1;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = this.p$;
            int length = this.$flows.length;
            ReceiveChannel[] receiveChannelArr3 = new ReceiveChannel[length];
            for (int i5 = 0; i5 < length; i5++) {
                receiveChannelArr3[i5] = CombineKt.asFairChannel(coroutineScope3, this.$flows[Boxing.boxInt(i5).intValue()]);
            }
            Object[] objArr3 = new Object[length];
            Boolean[] boolArr3 = new Boolean[length];
            for (int i6 = 0; i6 < length; i6++) {
                Boxing.boxInt(i6).intValue();
                boolArr3[i6] = Boxing.boxBoolean(false);
            }
            Ref.IntRef intRef5 = new Ref.IntRef();
            intRef5.element = length;
            Ref.IntRef intRef6 = new Ref.IntRef();
            intRef6.element = length;
            receiveChannelArr = receiveChannelArr3;
            objArr = objArr3;
            boolArr = boolArr3;
            intRef2 = intRef5;
            intRef = intRef6;
            combineKt$combineInternal$2 = this;
            coroutineScope = coroutineScope3;
            i = length;
            obj2 = coroutine_suspended;
        } else if (i3 == 1) {
            CombineKt$combineInternal$2 combineKt$combineInternal$24 = (CombineKt$combineInternal$2) this.L$6;
            int i7 = this.I$0;
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            intRef = (Ref.IntRef) this.L$5;
            intRef2 = (Ref.IntRef) this.L$4;
            boolArr = (Boolean[]) this.L$3;
            objArr = (Object[]) this.L$2;
            receiveChannelArr = (ReceiveChannel[]) this.L$1;
            obj2 = coroutine_suspended;
            combineKt$combineInternal$2 = this;
            i = i7;
            coroutineScope = coroutineScope4;
            i4 = 1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (intRef2.element == 0) {
            combineKt$combineInternal$2.L$0 = coroutineScope;
            combineKt$combineInternal$2.I$0 = i;
            combineKt$combineInternal$2.L$1 = receiveChannelArr;
            combineKt$combineInternal$2.L$2 = objArr;
            combineKt$combineInternal$2.L$3 = boolArr;
            combineKt$combineInternal$2.L$4 = intRef2;
            combineKt$combineInternal$2.L$5 = intRef;
            combineKt$combineInternal$2.L$6 = combineKt$combineInternal$2;
            combineKt$combineInternal$2.label = i4;
            CombineKt$combineInternal$2 combineKt$combineInternal$25 = combineKt$combineInternal$2;
            SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(combineKt$combineInternal$25);
            try {
            } catch (Throwable th2) {
                th = th2;
                selectBuilderImpl = selectBuilderImpl2;
                combineKt$combineInternal$22 = combineKt$combineInternal$25;
                combineKt$combineInternal$23 = combineKt$combineInternal$2;
                coroutineScope2 = coroutineScope;
                i2 = i;
                receiveChannelArr2 = receiveChannelArr;
                objArr2 = objArr;
                boolArr2 = boolArr;
                intRef3 = intRef2;
            }
            SelectBuilderImpl selectBuilderImpl3 = selectBuilderImpl2;
            int i8 = 0;
            while (i8 < i) {
                boolean booleanValue = boolArr[i8].booleanValue();
                ReceiveChannel receiveChannel = receiveChannelArr[i8];
                selectBuilderImpl = selectBuilderImpl2;
                combineKt$combineInternal$22 = combineKt$combineInternal$25;
                combineKt$combineInternal$23 = combineKt$combineInternal$2;
                coroutineScope2 = coroutineScope;
                i2 = i;
                receiveChannelArr2 = receiveChannelArr;
                objArr2 = objArr;
                boolArr2 = boolArr;
                intRef3 = intRef2;
                try {
                } catch (Throwable th3) {
                    th = th3;
                    intRef4 = intRef;
                    selectBuilderImpl.handleBuilderException(th);
                    result = selectBuilderImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    }
                    if (result == obj2) {
                    }
                    return obj2;
                }
                CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1(i8, null, combineKt$combineInternal$2, i, boolArr, receiveChannelArr, objArr, intRef, intRef2);
                if (booleanValue) {
                    intRef4 = intRef;
                } else {
                    intRef4 = intRef;
                    try {
                        selectBuilderImpl3.invoke(receiveChannel.getOnReceiveOrNull(), new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1, null, i8, combineKt$combineInternal$23, i2, boolArr2, receiveChannelArr2, objArr2, intRef, intRef3));
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                i8++;
                selectBuilderImpl2 = selectBuilderImpl;
                intRef = intRef4;
                combineKt$combineInternal$2 = combineKt$combineInternal$23;
                combineKt$combineInternal$25 = combineKt$combineInternal$22;
                coroutineScope = coroutineScope2;
                i = i2;
                receiveChannelArr = receiveChannelArr2;
                objArr = objArr2;
                boolArr = boolArr2;
                intRef2 = intRef3;
            }
            selectBuilderImpl = selectBuilderImpl2;
            combineKt$combineInternal$22 = combineKt$combineInternal$25;
            combineKt$combineInternal$23 = combineKt$combineInternal$2;
            coroutineScope2 = coroutineScope;
            i2 = i;
            receiveChannelArr2 = receiveChannelArr;
            objArr2 = objArr;
            boolArr2 = boolArr;
            intRef3 = intRef2;
            intRef4 = intRef;
            result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(combineKt$combineInternal$22);
            }
            if (result == obj2) {
                intRef = intRef4;
                combineKt$combineInternal$2 = combineKt$combineInternal$23;
                coroutineScope = coroutineScope2;
                i = i2;
                receiveChannelArr = receiveChannelArr2;
                objArr = objArr2;
                boolArr = boolArr2;
                intRef2 = intRef3;
                i4 = 1;
                if (intRef2.element == 0) {
                }
            }
            return obj2;
        }
        return Unit.INSTANCE;
    }
}
