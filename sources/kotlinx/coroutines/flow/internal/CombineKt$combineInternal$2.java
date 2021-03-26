package kotlinx.coroutines.flow.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "B$0", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    byte B$0;
    int I$0;
    int I$1;
    int I$2;
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

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0131 A[LOOP:1: B:24:0x0131->B:31:0x0152, LOOP_START, PHI: r2 r5 
      PHI: (r2v5 int) = (r2v4 int), (r2v6 int) binds: [B:23:0x012f, B:31:0x0152] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v5 kotlin.collections.IndexedValue) = (r5v4 kotlin.collections.IndexedValue), (r5v9 kotlin.collections.IndexedValue) binds: [B:23:0x012f, B:31:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        Object[] objArr;
        final AtomicInteger atomicInteger;
        CoroutineScope coroutineScope;
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        int i2;
        Channel channel;
        byte[] bArr;
        int i3;
        CoroutineScope coroutineScope2;
        Object obj2;
        Object[] objArr2;
        Channel channel2;
        byte[] bArr2;
        int i4;
        Object[] objArr3;
        int i5;
        int i6;
        Object[] objArr4;
        int i7;
        CoroutineScope coroutineScope3;
        Symbol[] symbolArr;
        Object obj3;
        byte b;
        IndexedValue indexedValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        int i9 = 0;
        int i10 = 1;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = this.p$;
            int length = this.$flows.length;
            if (length == 0) {
                return Unit.INSTANCE;
            }
            objArr = new Object[length];
            ArraysKt.fill$default(objArr, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (Object) null);
            final Channel Channel$default = ChannelKt.Channel$default(length, null, null, 6, null);
            atomicInteger = new AtomicInteger(length);
            final int i11 = 0;
            while (i11 < length) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, null), 3, null);
                i11++;
                atomicInteger = atomicInteger;
                objArr = objArr;
                length = length;
            }
            bArr = new byte[length];
            i2 = length;
            i = i2;
            combineKt$combineInternal$2 = this;
            channel = Channel$default;
        } else if (i8 == 1) {
            byte b = this.B$0;
            bArr2 = (byte[]) this.L$4;
            i2 = this.I$1;
            channel2 = (Channel) this.L$2;
            int i = this.I$0;
            ResultKt.throwOnFailure(obj);
            atomicInteger = (AtomicInteger) this.L$3;
            combineKt$combineInternal$2 = this;
            coroutineScope3 = (CoroutineScope) this.L$0;
            i3 = i;
            obj2 = coroutine_suspended;
            symbolArr = (Object[]) this.L$1;
            obj3 = obj;
            b = b;
            indexedValue = (IndexedValue) obj3;
            if (indexedValue == null) {
                while (true) {
                    int index = indexedValue.getIndex();
                    Symbol symbol = symbolArr[index];
                    symbolArr[index] = indexedValue.getValue();
                    if (symbol == NullSurrogateKt.UNINITIALIZED) {
                        i2--;
                    }
                    if (bArr2[index] == b) {
                        break;
                    }
                    bArr2[index] = b;
                    IndexedValue indexedValue = (IndexedValue) channel2.poll();
                    if (indexedValue == null) {
                        break;
                    }
                    indexedValue = indexedValue;
                }
                if (i2 != 0) {
                    coroutineScope2 = coroutineScope3;
                    i4 = b;
                    objArr2 = symbolArr;
                    i5 = i4;
                    objArr3 = objArr2;
                    objArr = objArr3;
                    coroutine_suspended = obj2;
                    i = i3;
                    i9 = i5 == 1 ? 1 : 0;
                    bArr = bArr2;
                    channel = channel2;
                    coroutineScope = coroutineScope2;
                    i10 = 1;
                }
                Object[] objArr = (Object[]) combineKt$combineInternal$2.$arrayFactory.invoke();
                if (objArr == null) {
                    Function3 function3 = combineKt$combineInternal$2.$transform;
                    FlowCollector flowCollector = combineKt$combineInternal$2.$this_combineInternal;
                    Objects.requireNonNull(symbolArr, "null cannot be cast to non-null type kotlin.Array<T>");
                    combineKt$combineInternal$2.L$0 = coroutineScope3;
                    combineKt$combineInternal$2.I$0 = i3;
                    combineKt$combineInternal$2.L$1 = symbolArr;
                    combineKt$combineInternal$2.L$2 = channel2;
                    combineKt$combineInternal$2.L$3 = atomicInteger;
                    combineKt$combineInternal$2.I$1 = i2;
                    combineKt$combineInternal$2.L$4 = bArr2;
                    combineKt$combineInternal$2.I$2 = b;
                    combineKt$combineInternal$2.L$5 = indexedValue;
                    combineKt$combineInternal$2.L$6 = objArr;
                    combineKt$combineInternal$2.label = 2;
                    if (function3.invoke(flowCollector, symbolArr, combineKt$combineInternal$2) != obj2) {
                        objArr4 = symbolArr;
                        coroutine_suspended = obj2;
                        i6 = i3;
                        coroutineScope = coroutineScope3;
                        i7 = b;
                        objArr = objArr4;
                        i = i6;
                        i9 = i7 == 1 ? 1 : 0;
                        bArr = bArr2;
                        channel = channel2;
                        i10 = 1;
                    }
                    return obj2;
                }
                Objects.requireNonNull(symbolArr, "null cannot be cast to non-null type kotlin.Array<T?>");
                coroutineScope2 = coroutineScope3;
                ArraysKt.copyInto$default(symbolArr, objArr, 0, 0, 0, 14, (Object) null);
                Function3 function32 = combineKt$combineInternal$2.$transform;
                FlowCollector flowCollector2 = combineKt$combineInternal$2.$this_combineInternal;
                combineKt$combineInternal$2.L$0 = coroutineScope2;
                combineKt$combineInternal$2.I$0 = i3;
                combineKt$combineInternal$2.L$1 = symbolArr;
                combineKt$combineInternal$2.L$2 = channel2;
                combineKt$combineInternal$2.L$3 = atomicInteger;
                combineKt$combineInternal$2.I$1 = i2;
                combineKt$combineInternal$2.L$4 = bArr2;
                combineKt$combineInternal$2.I$2 = b;
                combineKt$combineInternal$2.L$5 = indexedValue;
                combineKt$combineInternal$2.L$6 = objArr;
                combineKt$combineInternal$2.label = 3;
                i5 = b;
                objArr3 = symbolArr;
                if (function32.invoke(flowCollector2, objArr, combineKt$combineInternal$2) == obj2) {
                    return obj2;
                }
                objArr = objArr3;
                coroutine_suspended = obj2;
                i = i3;
                i9 = i5 == 1 ? 1 : 0;
                bArr = bArr2;
                channel = channel2;
                coroutineScope = coroutineScope2;
                i10 = 1;
            }
            return Unit.INSTANCE;
        } else if (i8 == 2) {
            Object[] objArr2 = (Object[]) this.L$6;
            IndexedValue indexedValue2 = (IndexedValue) this.L$5;
            int i2 = this.I$2;
            bArr2 = (byte[]) this.L$4;
            i2 = this.I$1;
            channel2 = (Channel) this.L$2;
            objArr4 = (Object[]) this.L$1;
            i6 = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            atomicInteger = (AtomicInteger) this.L$3;
            combineKt$combineInternal$2 = this;
            i7 = i2;
            objArr = objArr4;
            i = i6;
            i9 = i7 == 1 ? 1 : 0;
            bArr = bArr2;
            channel = channel2;
            i10 = 1;
        } else if (i8 == 3) {
            Object[] objArr3 = (Object[]) this.L$6;
            IndexedValue indexedValue3 = (IndexedValue) this.L$5;
            int i3 = this.I$2;
            bArr2 = (byte[]) this.L$4;
            i2 = this.I$1;
            channel2 = (Channel) this.L$2;
            int i4 = this.I$0;
            ResultKt.throwOnFailure(obj);
            atomicInteger = (AtomicInteger) this.L$3;
            combineKt$combineInternal$2 = this;
            coroutineScope2 = (CoroutineScope) this.L$0;
            i3 = i4;
            obj2 = coroutine_suspended;
            objArr2 = (Object[]) this.L$1;
            i4 = i3;
            i5 = i4;
            objArr3 = objArr2;
            objArr = objArr3;
            coroutine_suspended = obj2;
            i = i3;
            i9 = i5 == 1 ? 1 : 0;
            bArr = bArr2;
            channel = channel2;
            coroutineScope = coroutineScope2;
            i10 = 1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        byte b2 = (byte) (i9 + i10);
        combineKt$combineInternal$2.L$0 = coroutineScope;
        combineKt$combineInternal$2.I$0 = i;
        combineKt$combineInternal$2.L$1 = objArr;
        combineKt$combineInternal$2.L$2 = channel;
        combineKt$combineInternal$2.L$3 = atomicInteger;
        combineKt$combineInternal$2.I$1 = i2;
        combineKt$combineInternal$2.L$4 = bArr;
        combineKt$combineInternal$2.B$0 = b2;
        combineKt$combineInternal$2.label = i10;
        obj3 = ChannelsKt.receiveOrNull(channel, combineKt$combineInternal$2);
        if (obj3 != coroutine_suspended) {
            obj2 = coroutine_suspended;
            symbolArr = objArr;
            bArr2 = bArr;
            b = b2;
            channel2 = channel;
            coroutineScope3 = coroutineScope;
            i3 = i;
            indexedValue = (IndexedValue) obj3;
            if (indexedValue == null) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$launch", "$this$collect$iv"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* compiled from: Combine.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ CombineKt$combineInternal$2 this$0;

        {
            this.this$0 = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, i11, Channel$default, atomicInteger, continuation);
            r6.p$ = (CoroutineScope) obj;
            return r6;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                Flow flow = this.this$0.$flows[i11];
                this.L$0 = coroutineScope;
                this.L$1 = flow;
                this.label = 1;
                if (flow.collect(new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                Flow flow2 = (Flow) this.L$1;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    if (atomicInteger.decrementAndGet() == 0) {
                        SendChannel.DefaultImpls.close$default(Channel$default, null, 1, null);
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (atomicInteger.decrementAndGet() == 0) {
                SendChannel.DefaultImpls.close$default(Channel$default, null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }
}
