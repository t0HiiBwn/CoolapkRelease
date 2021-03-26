package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$1", f = "Broadcast.kt", i = {0, 1, 1}, l = {30, 31}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast", "e"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: Broadcast.kt */
final class BroadcastKt$broadcast$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_broadcast;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastKt$broadcast$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1 = new BroadcastKt$broadcast$1(this.$this_broadcast, continuation);
        broadcastKt$broadcast$1.p$ = (ProducerScope) obj;
        return broadcastKt$broadcast$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((BroadcastKt$broadcast$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChannelIterator channelIterator;
        ProducerScope producerScope;
        BroadcastKt$broadcast$1 broadcastKt$broadcast$1;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            channelIterator = this.$this_broadcast.iterator();
        } else if (i == 1) {
            channelIterator = (ChannelIterator) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            BroadcastKt$broadcast$1 broadcastKt$broadcast$12 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                broadcastKt$broadcast$12.L$0 = producerScope2;
                broadcastKt$broadcast$12.L$1 = next;
                broadcastKt$broadcast$12.L$2 = channelIterator;
                broadcastKt$broadcast$12.label = 2;
                if (producerScope2.send(next, broadcastKt$broadcast$12) != coroutine_suspended) {
                    producerScope = producerScope2;
                    broadcastKt$broadcast$1 = broadcastKt$broadcast$12;
                    broadcastKt$broadcast$1.L$0 = producerScope;
                    broadcastKt$broadcast$1.L$1 = channelIterator;
                    broadcastKt$broadcast$1.label = 1;
                    hasNext = channelIterator.hasNext(broadcastKt$broadcast$1);
                    if (hasNext == coroutine_suspended) {
                        producerScope2 = producerScope;
                        obj = hasNext;
                        broadcastKt$broadcast$12 = broadcastKt$broadcast$1;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (i == 2) {
            channelIterator = (ChannelIterator) this.L$2;
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        broadcastKt$broadcast$1 = this;
        broadcastKt$broadcast$1.L$0 = producerScope;
        broadcastKt$broadcast$1.L$1 = channelIterator;
        broadcastKt$broadcast$1.label = 1;
        hasNext = channelIterator.hasNext(broadcastKt$broadcast$1);
        if (hasNext == coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
