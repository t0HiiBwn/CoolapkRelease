package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1}, l = {1658, 1659}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_withIndex;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$withIndex$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1 = new ChannelsKt__Channels_commonKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__Channels_commonKt$withIndex$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$withIndex$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$withIndex$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1;
        ProducerScope producerScope;
        int i;
        ChannelIterator channelIterator;
        ChannelIterator channelIterator2;
        ProducerScope producerScope2;
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$12;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope2 = this.p$;
            i2 = 0;
            channelIterator2 = this.$this_withIndex.iterator();
            channelsKt__Channels_commonKt$withIndex$12 = this;
        } else if (i3 == 1) {
            channelIterator = (ChannelIterator) this.L$1;
            i = this.I$0;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            channelsKt__Channels_commonKt$withIndex$1 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                int i4 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, next);
                channelsKt__Channels_commonKt$withIndex$1.L$0 = producerScope;
                channelsKt__Channels_commonKt$withIndex$1.I$0 = i4;
                channelsKt__Channels_commonKt$withIndex$1.L$1 = next;
                channelsKt__Channels_commonKt$withIndex$1.L$2 = channelIterator;
                channelsKt__Channels_commonKt$withIndex$1.label = 2;
                if (producerScope.send(indexedValue, channelsKt__Channels_commonKt$withIndex$1) != coroutine_suspended) {
                    channelIterator2 = channelIterator;
                    producerScope2 = producerScope;
                    channelsKt__Channels_commonKt$withIndex$12 = channelsKt__Channels_commonKt$withIndex$1;
                    i2 = i4;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (i3 == 2) {
            int i5 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope2 = (ProducerScope) this.L$0;
            channelsKt__Channels_commonKt$withIndex$12 = this;
            channelIterator2 = (ChannelIterator) this.L$2;
            i2 = i5;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__Channels_commonKt$withIndex$12.L$0 = producerScope2;
        channelsKt__Channels_commonKt$withIndex$12.I$0 = i2;
        channelsKt__Channels_commonKt$withIndex$12.L$1 = channelIterator2;
        channelsKt__Channels_commonKt$withIndex$12.label = 1;
        Object hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$withIndex$12);
        if (hasNext != coroutine_suspended) {
            producerScope = producerScope2;
            obj = hasNext;
            channelsKt__Channels_commonKt$withIndex$1 = channelsKt__Channels_commonKt$withIndex$12;
            i = i2;
            channelIterator = channelIterator2;
            if (!((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
