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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterIndexed$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {774, 775, 775}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "e", "$this$produce", "index", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1", "L$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$filterIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $predicate;
    final /* synthetic */ ReceiveChannel $this_filterIndexed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$filterIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$1 = new ChannelsKt__Channels_commonKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__Channels_commonKt$filterIndexed$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$filterIndexed$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$filterIndexed$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChannelIterator channelIterator;
        Object obj2;
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$1;
        ChannelsKt__Channels_commonKt$filterIndexed$1 channelsKt__Channels_commonKt$filterIndexed$12;
        ChannelIterator channelIterator2;
        int i;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        int i2;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = this.p$;
            channelIterator2 = this.$this_filterIndexed.iterator();
            i = 0;
        } else if (i3 == 1) {
            int i4 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope2 = (ProducerScope) this.L$0;
            i2 = i4;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$filterIndexed$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        } else if (i3 == 2) {
            Object obj3 = this.L$1;
            int i5 = this.I$0;
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope3 = (ProducerScope) this.L$0;
            Object obj4 = obj3;
            channelIterator = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$filterIndexed$1 = this;
            if (((Boolean) obj).booleanValue()) {
                channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope3;
                channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i5;
                channelsKt__Channels_commonKt$filterIndexed$1.L$1 = obj4;
                channelsKt__Channels_commonKt$filterIndexed$1.L$2 = channelIterator;
                channelsKt__Channels_commonKt$filterIndexed$1.label = 3;
                if (producerScope3.send(obj4, channelsKt__Channels_commonKt$filterIndexed$1) == obj2) {
                    return obj2;
                }
            }
            channelsKt__Channels_commonKt$filterIndexed$12 = channelsKt__Channels_commonKt$filterIndexed$1;
            coroutine_suspended = obj2;
            channelIterator2 = channelIterator;
            i = i5;
            producerScope = producerScope3;
            channelsKt__Channels_commonKt$filterIndexed$12.L$0 = producerScope;
            channelsKt__Channels_commonKt$filterIndexed$12.I$0 = i;
            channelsKt__Channels_commonKt$filterIndexed$12.L$1 = channelIterator2;
            channelsKt__Channels_commonKt$filterIndexed$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterIndexed$12);
            if (hasNext != coroutine_suspended) {
                channelsKt__Channels_commonKt$filterIndexed$1 = channelsKt__Channels_commonKt$filterIndexed$12;
                obj = hasNext;
                producerScope2 = producerScope;
                i2 = i;
                channelIterator = channelIterator2;
                obj2 = coroutine_suspended;
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    Function3 function3 = channelsKt__Channels_commonKt$filterIndexed$1.$predicate;
                    Integer boxInt = Boxing.boxInt(i2);
                    i5 = i2 + 1;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$0 = producerScope2;
                    channelsKt__Channels_commonKt$filterIndexed$1.I$0 = i5;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$1 = next;
                    channelsKt__Channels_commonKt$filterIndexed$1.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$filterIndexed$1.label = 2;
                    Object invoke = function3.invoke(boxInt, next, channelsKt__Channels_commonKt$filterIndexed$1);
                    if (invoke != obj2) {
                        obj4 = next;
                        obj = invoke;
                        producerScope3 = producerScope2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                        channelsKt__Channels_commonKt$filterIndexed$12 = channelsKt__Channels_commonKt$filterIndexed$1;
                        coroutine_suspended = obj2;
                        channelIterator2 = channelIterator;
                        i = i5;
                        producerScope = producerScope3;
                        channelsKt__Channels_commonKt$filterIndexed$12.L$0 = producerScope;
                        channelsKt__Channels_commonKt$filterIndexed$12.I$0 = i;
                        channelsKt__Channels_commonKt$filterIndexed$12.L$1 = channelIterator2;
                        channelsKt__Channels_commonKt$filterIndexed$12.label = 1;
                        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterIndexed$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    }
                    return obj2;
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } else if (i3 == 3) {
            channelIterator2 = (ChannelIterator) this.L$2;
            i = this.I$0;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__Channels_commonKt$filterIndexed$12 = this;
        channelsKt__Channels_commonKt$filterIndexed$12.L$0 = producerScope;
        channelsKt__Channels_commonKt$filterIndexed$12.I$0 = i;
        channelsKt__Channels_commonKt$filterIndexed$12.L$1 = channelIterator2;
        channelsKt__Channels_commonKt$filterIndexed$12.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterIndexed$12);
        if (hasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
