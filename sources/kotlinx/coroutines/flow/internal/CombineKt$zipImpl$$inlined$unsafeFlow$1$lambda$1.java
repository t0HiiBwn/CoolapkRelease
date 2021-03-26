package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Combine.kt */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0195 A[Catch:{ all -> 0x0281 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01e1 A[Catch:{ all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01e4 A[Catch:{ all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f0 A[Catch:{ all -> 0x0263 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02a8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
        Throwable th;
        AbortFlowException e;
        AbortFlowException abortFlowException;
        final ReceiveChannel receiveChannel2;
        Throwable th2;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        ChannelIterator channelIterator;
        Throwable th3;
        ChannelIterator channelIterator2;
        CoroutineScope coroutineScope;
        ReceiveChannel receiveChannel5;
        ReceiveChannel receiveChannel6;
        Object obj2;
        ReceiveChannel receiveChannel7;
        ChannelIterator channelIterator3;
        Object obj3;
        ReceiveChannel receiveChannel8;
        ReceiveChannel receiveChannel9;
        ReceiveChannel receiveChannel10;
        CoroutineScope coroutineScope2;
        FlowCollector flowCollector;
        Object obj4;
        Object obj5;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
        ReceiveChannel receiveChannel11;
        ReceiveChannel receiveChannel12;
        ReceiveChannel receiveChannel13;
        Object obj6;
        Symbol symbol;
        Object next;
        Object obj7;
        ChannelIterator channelIterator4;
        ReceiveChannel receiveChannel14;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
        Throwable th4;
        ReceiveChannel receiveChannel15;
        ChannelIterator channelIterator5;
        CoroutineScope coroutineScope3;
        ReceiveChannel receiveChannel16;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = this.p$;
            receiveChannel2 = CombineKt.asChannel(coroutineScope, this.this$0.$flow$inlined);
            receiveChannel = CombineKt.asChannel(coroutineScope, this.this$0.$flow2$inlined);
            if (receiveChannel != null) {
                ((SendChannel) receiveChannel).invokeOnClose(new Function1<Throwable, Unit>(this) {
                    /* class kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.AnonymousClass1 */
                    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke(th);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable th) {
                        if (!receiveChannel2.isClosedForReceive()) {
                            receiveChannel2.cancel((CancellationException) new AbortFlowException(this.this$0.$this_unsafeFlow));
                        }
                    }
                });
                channelIterator2 = receiveChannel.iterator();
                try {
                    th3 = null;
                    try {
                        channelIterator = receiveChannel2.iterator();
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = this;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                        receiveChannel4 = receiveChannel2;
                        receiveChannel3 = receiveChannel4;
                        receiveChannel6 = receiveChannel3;
                    } catch (Throwable th5) {
                        th = th5;
                        th2 = th;
                        throw th2;
                    }
                } catch (AbortFlowException e2) {
                    e = e2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                    FlowExceptions_commonKt.checkOwnership(e, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow);
                    if (!receiveChannel.isClosedForReceive()) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th6) {
                    th = th6;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                    if (!receiveChannel.isClosedForReceive()) {
                    }
                    throw th;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            }
        } else if (i == 1) {
            Throwable th7 = (Throwable) this.L$7;
            receiveChannel2 = (ReceiveChannel) this.L$6;
            CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
            receiveChannel = (ReceiveChannel) this.L$2;
            ResultKt.throwOnFailure(obj);
            obj7 = obj;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
            channelIterator5 = (ChannelIterator) this.L$9;
            receiveChannel16 = (ReceiveChannel) this.L$1;
            receiveChannel14 = (ReceiveChannel) this.L$4;
            th4 = th7;
            receiveChannel15 = (ReceiveChannel) this.L$8;
            coroutineScope3 = (CoroutineScope) this.L$0;
            channelIterator4 = (ChannelIterator) this.L$3;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15;
            try {
                if (!((Boolean) obj7).booleanValue()) {
                    obj2 = channelIterator5.next();
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel16;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel14;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel15;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator5;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$10 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$11 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 2;
                    obj6 = channelIterator4.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1);
                    if (obj6 != coroutine_suspended) {
                        receiveChannel11 = receiveChannel;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                        receiveChannel12 = receiveChannel16;
                        coroutineScope = coroutineScope3;
                        channelIterator2 = channelIterator4;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                        receiveChannel3 = receiveChannel2;
                        receiveChannel13 = receiveChannel15;
                        channelIterator = channelIterator5;
                        th3 = th4;
                        receiveChannel4 = receiveChannel14;
                        obj3 = obj2;
                        if (((Boolean) obj6).booleanValue()) {
                            FlowCollector flowCollector2 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.$this_unsafeFlow;
                            Function3 function3 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.this$0.$transform$inlined;
                            if (obj2 != NullSurrogateKt.NULL) {
                            }
                            symbol = NullSurrogateKt.NULL;
                            next = channelIterator2.next();
                            if (next == symbol) {
                            }
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$0 = coroutineScope;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$1 = receiveChannel12;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$2 = receiveChannel11;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$3 = channelIterator2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$4 = receiveChannel4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$6 = receiveChannel3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$7 = th3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$8 = receiveChannel13;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$9 = channelIterator;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$10 = obj3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$11 = obj2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$12 = flowCollector2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.label = 3;
                            obj5 = function3.invoke(r17, next, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13);
                            obj4 = coroutine_suspended;
                            if (obj5 == obj4) {
                            }
                            return obj4;
                        }
                        receiveChannel6 = receiveChannel13;
                        receiveChannel2 = receiveChannel12;
                        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                        receiveChannel = receiveChannel11;
                    }
                    return coroutine_suspended;
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } catch (Throwable th8) {
                th = th8;
                th2 = th;
                throw th2;
            }
            try {
                ChannelsKt.cancelConsumed(receiveChannel2, th4);
                if (!receiveChannel.isClosedForReceive()) {
                    abortFlowException = new AbortFlowException(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow);
                    receiveChannel.cancel((CancellationException) abortFlowException);
                }
            } catch (AbortFlowException e3) {
                e = e3;
                try {
                    FlowExceptions_commonKt.checkOwnership(e, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow);
                    if (!receiveChannel.isClosedForReceive()) {
                        abortFlowException = new AbortFlowException(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow);
                        receiveChannel.cancel((CancellationException) abortFlowException);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th9) {
                    th = th9;
                    if (!receiveChannel.isClosedForReceive()) {
                        receiveChannel.cancel((CancellationException) new AbortFlowException(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.$this_unsafeFlow));
                    }
                    throw th;
                }
            }
        } else if (i == 2) {
            Object obj8 = this.L$11;
            Object obj9 = this.L$10;
            ReceiveChannel receiveChannel17 = (ReceiveChannel) this.L$6;
            ReceiveChannel receiveChannel18 = (ReceiveChannel) this.L$4;
            ReceiveChannel receiveChannel19 = (ReceiveChannel) this.L$2;
            receiveChannel12 = (ReceiveChannel) this.L$1;
            ResultKt.throwOnFailure(obj);
            obj6 = obj;
            obj2 = obj8;
            coroutineScope = (CoroutineScope) this.L$0;
            receiveChannel11 = receiveChannel19;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = this;
            obj3 = obj9;
            channelIterator2 = (ChannelIterator) this.L$3;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
            receiveChannel3 = receiveChannel17;
            receiveChannel13 = (ReceiveChannel) this.L$8;
            channelIterator = (ChannelIterator) this.L$9;
            th3 = (Throwable) this.L$7;
            receiveChannel4 = receiveChannel18;
            try {
                if (((Boolean) obj6).booleanValue()) {
                    receiveChannel6 = receiveChannel13;
                    receiveChannel2 = receiveChannel12;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                    receiveChannel = receiveChannel11;
                }
                FlowCollector flowCollector2 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.$this_unsafeFlow;
                Function3 function3 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.this$0.$transform$inlined;
                Object obj10 = obj2 != NullSurrogateKt.NULL ? null : obj2;
                symbol = NullSurrogateKt.NULL;
                next = channelIterator2.next();
                if (next == symbol) {
                    next = null;
                }
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$0 = coroutineScope;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$1 = receiveChannel12;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$2 = receiveChannel11;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$3 = channelIterator2;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$4 = receiveChannel4;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$6 = receiveChannel3;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$7 = th3;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$8 = receiveChannel13;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$9 = channelIterator;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$10 = obj3;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$11 = obj2;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.L$12 = flowCollector2;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13.label = 3;
                obj5 = function3.invoke(obj10, next, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13);
                obj4 = coroutine_suspended;
                if (obj5 == obj4) {
                    flowCollector = flowCollector2;
                    receiveChannel9 = receiveChannel12;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                    receiveChannel7 = receiveChannel4;
                    receiveChannel10 = receiveChannel11;
                    channelIterator3 = channelIterator2;
                    coroutineScope2 = coroutineScope;
                    receiveChannel2 = receiveChannel3;
                    receiveChannel8 = receiveChannel13;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel9;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel10;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel7;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel8;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$10 = obj3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$11 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 4;
                    if (flowCollector.emit(obj5, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) == obj4) {
                    }
                    return obj4;
                }
                return obj4;
            } catch (Throwable th10) {
                th2 = th10;
                receiveChannel2 = receiveChannel3;
                throw th2;
            }
        } else if (i == 3) {
            flowCollector = (FlowCollector) this.L$12;
            Object obj11 = this.L$11;
            Object obj12 = this.L$10;
            ChannelIterator channelIterator6 = (ChannelIterator) this.L$9;
            ReceiveChannel receiveChannel20 = (ReceiveChannel) this.L$8;
            Throwable th11 = (Throwable) this.L$7;
            ReceiveChannel receiveChannel21 = (ReceiveChannel) this.L$6;
            CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
            receiveChannel7 = (ReceiveChannel) this.L$4;
            ChannelIterator channelIterator7 = (ChannelIterator) this.L$3;
            ReceiveChannel receiveChannel22 = (ReceiveChannel) this.L$2;
            ReceiveChannel receiveChannel23 = (ReceiveChannel) this.L$1;
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                receiveChannel9 = receiveChannel23;
                channelIterator = channelIterator6;
                obj3 = obj12;
                receiveChannel8 = receiveChannel20;
                receiveChannel2 = receiveChannel21;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                obj4 = coroutine_suspended;
                obj5 = obj;
                obj2 = obj11;
                coroutineScope2 = coroutineScope4;
                receiveChannel10 = receiveChannel22;
                th3 = th11;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$16;
                channelIterator3 = channelIterator7;
                try {
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel9;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel10;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel7;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel8;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$10 = obj3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$11 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 4;
                    if (flowCollector.emit(obj5, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) == obj4) {
                        coroutine_suspended = obj4;
                        coroutineScope = coroutineScope2;
                        receiveChannel5 = receiveChannel8;
                        receiveChannel3 = receiveChannel2;
                        channelIterator2 = channelIterator3;
                        receiveChannel2 = receiveChannel9;
                        receiveChannel = receiveChannel10;
                        receiveChannel4 = receiveChannel7;
                        receiveChannel6 = receiveChannel5;
                    }
                    return obj4;
                } catch (Throwable th12) {
                    th2 = th12;
                    throw th2;
                }
            } catch (Throwable th13) {
                th = th13;
                receiveChannel2 = receiveChannel21;
                th2 = th;
                throw th2;
            }
        } else if (i == 4) {
            ChannelIterator channelIterator8 = (ChannelIterator) this.L$9;
            ReceiveChannel receiveChannel24 = (ReceiveChannel) this.L$8;
            Throwable th14 = (Throwable) this.L$7;
            receiveChannel2 = (ReceiveChannel) this.L$6;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
            ReceiveChannel receiveChannel25 = (ReceiveChannel) this.L$4;
            ChannelIterator channelIterator9 = (ChannelIterator) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            ReceiveChannel receiveChannel26 = (ReceiveChannel) this.L$1;
            CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                channelIterator = channelIterator8;
                coroutineScope = coroutineScope5;
                th3 = th14;
                receiveChannel4 = receiveChannel25;
                channelIterator2 = channelIterator9;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                receiveChannel5 = receiveChannel24;
                receiveChannel3 = receiveChannel2;
                receiveChannel2 = receiveChannel26;
                receiveChannel6 = receiveChannel5;
            } catch (Throwable th15) {
                th = th15;
                th2 = th;
                try {
                    throw th2;
                } catch (Throwable th16) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    throw th16;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$0 = coroutineScope;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$1 = receiveChannel2;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$2 = receiveChannel;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$3 = channelIterator2;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$4 = receiveChannel4;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$6 = receiveChannel3;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$7 = th3;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$8 = receiveChannel6;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.L$9 = channelIterator;
            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.label = 1;
            obj7 = channelIterator.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12);
            if (obj7 != coroutine_suspended) {
                coroutineScope3 = coroutineScope;
                receiveChannel16 = receiveChannel2;
                receiveChannel2 = receiveChannel3;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
                channelIterator4 = channelIterator2;
                th4 = th3;
                channelIterator5 = channelIterator;
                receiveChannel15 = receiveChannel6;
                receiveChannel14 = receiveChannel4;
                if (!((Boolean) obj7).booleanValue()) {
                }
                Unit unit = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(receiveChannel2, th4);
                if (!receiveChannel.isClosedForReceive()) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th17) {
            th2 = th17;
            receiveChannel2 = receiveChannel3;
            throw th2;
        }
    }
}
