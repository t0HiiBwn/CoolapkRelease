package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$mapIndexed$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {1423, 1424, 1424}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "e", "$this$produce", "index", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1", "L$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_mapIndexed;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$mapIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexed$1 channelsKt__Channels_commonKt$mapIndexed$1 = new ChannelsKt__Channels_commonKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, continuation);
        channelsKt__Channels_commonKt$mapIndexed$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$mapIndexed$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$mapIndexed$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChannelsKt__Channels_commonKt$mapIndexed$1 channelsKt__Channels_commonKt$mapIndexed$1;
        Object obj2;
        int i;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        ProducerScope producerScope2;
        ChannelIterator channelIterator2;
        ProducerScope producerScope3;
        int i2;
        ChannelsKt__Channels_commonKt$mapIndexed$1 channelsKt__Channels_commonKt$mapIndexed$12;
        ChannelsKt__Channels_commonKt$mapIndexed$1 channelsKt__Channels_commonKt$mapIndexed$13;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope3 = this.p$;
            channelsKt__Channels_commonKt$mapIndexed$12 = this;
            channelIterator2 = this.$this_mapIndexed.iterator();
            i2 = 0;
        } else if (i3 == 1) {
            channelIterator2 = (ChannelIterator) this.L$1;
            i2 = this.I$0;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__Channels_commonKt$mapIndexed$13 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator2.next();
                Function3 function3 = channelsKt__Channels_commonKt$mapIndexed$13.$transform;
                Integer boxInt = Boxing.boxInt(i2);
                int i4 = i2 + 1;
                channelsKt__Channels_commonKt$mapIndexed$13.L$0 = producerScope;
                channelsKt__Channels_commonKt$mapIndexed$13.I$0 = i4;
                channelsKt__Channels_commonKt$mapIndexed$13.L$1 = next;
                channelsKt__Channels_commonKt$mapIndexed$13.L$2 = channelIterator2;
                channelsKt__Channels_commonKt$mapIndexed$13.L$3 = producerScope;
                channelsKt__Channels_commonKt$mapIndexed$13.label = 2;
                Object invoke = function3.invoke(boxInt, next, channelsKt__Channels_commonKt$mapIndexed$13);
                if (invoke != coroutine_suspended) {
                    channelsKt__Channels_commonKt$mapIndexed$1 = channelsKt__Channels_commonKt$mapIndexed$13;
                    i = i4;
                    channelIterator = channelIterator2;
                    producerScope2 = producerScope;
                    obj2 = next;
                    obj = invoke;
                    channelsKt__Channels_commonKt$mapIndexed$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$mapIndexed$1.I$0 = i;
                    channelsKt__Channels_commonKt$mapIndexed$1.L$1 = obj2;
                    channelsKt__Channels_commonKt$mapIndexed$1.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$mapIndexed$1.label = 3;
                    if (producerScope2.send(obj, channelsKt__Channels_commonKt$mapIndexed$1) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (i3 == 2) {
            producerScope2 = (ProducerScope) this.L$3;
            channelIterator = (ChannelIterator) this.L$2;
            Object obj3 = this.L$1;
            i = this.I$0;
            ProducerScope producerScope4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__Channels_commonKt$mapIndexed$1 = this;
            obj2 = obj3;
            producerScope = producerScope4;
            channelsKt__Channels_commonKt$mapIndexed$1.L$0 = producerScope;
            channelsKt__Channels_commonKt$mapIndexed$1.I$0 = i;
            channelsKt__Channels_commonKt$mapIndexed$1.L$1 = obj2;
            channelsKt__Channels_commonKt$mapIndexed$1.L$2 = channelIterator;
            channelsKt__Channels_commonKt$mapIndexed$1.label = 3;
            if (producerScope2.send(obj, channelsKt__Channels_commonKt$mapIndexed$1) == coroutine_suspended) {
                channelIterator2 = channelIterator;
                producerScope3 = producerScope;
                i2 = i;
                channelsKt__Channels_commonKt$mapIndexed$12 = channelsKt__Channels_commonKt$mapIndexed$1;
            }
            return coroutine_suspended;
        } else if (i3 == 3) {
            channelIterator2 = (ChannelIterator) this.L$2;
            i2 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope3 = (ProducerScope) this.L$0;
            channelsKt__Channels_commonKt$mapIndexed$12 = this;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__Channels_commonKt$mapIndexed$12.L$0 = producerScope3;
        channelsKt__Channels_commonKt$mapIndexed$12.I$0 = i2;
        channelsKt__Channels_commonKt$mapIndexed$12.L$1 = channelIterator2;
        channelsKt__Channels_commonKt$mapIndexed$12.label = 1;
        Object hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexed$12);
        if (hasNext != coroutine_suspended) {
            producerScope = producerScope3;
            obj = hasNext;
            channelsKt__Channels_commonKt$mapIndexed$13 = channelsKt__Channels_commonKt$mapIndexed$12;
            if (!((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
