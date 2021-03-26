package kotlinx.coroutines.channels;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {1695, 1696, 1698}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "e", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $selector;
    final /* synthetic */ ReceiveChannel $this_distinctBy;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$distinctBy$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$1 = new ChannelsKt__Channels_commonKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__Channels_commonKt$distinctBy$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$distinctBy$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$distinctBy$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        HashSet hashSet;
        ChannelIterator channelIterator;
        Object obj2;
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$1;
        ChannelsKt__Channels_commonKt$distinctBy$1 channelsKt__Channels_commonKt$distinctBy$12;
        ChannelIterator channelIterator2;
        HashSet hashSet2;
        ProducerScope producerScope2;
        ProducerScope producerScope3;
        HashSet hashSet3;
        Object obj3;
        ProducerScope producerScope4;
        HashSet hashSet4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope5 = this.p$;
            HashSet hashSet5 = new HashSet();
            producerScope2 = producerScope5;
            channelsKt__Channels_commonKt$distinctBy$12 = this;
            hashSet2 = hashSet5;
            channelIterator2 = this.$this_distinctBy.iterator();
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            producerScope4 = (ProducerScope) this.L$0;
            hashSet4 = (HashSet) this.L$1;
            channelIterator = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$distinctBy$1 = this;
            if (!((Boolean) obj).booleanValue()) {
                Object next = channelIterator.next();
                Function2 function2 = channelsKt__Channels_commonKt$distinctBy$1.$selector;
                channelsKt__Channels_commonKt$distinctBy$1.L$0 = producerScope4;
                channelsKt__Channels_commonKt$distinctBy$1.L$1 = hashSet4;
                channelsKt__Channels_commonKt$distinctBy$1.L$2 = next;
                channelsKt__Channels_commonKt$distinctBy$1.L$3 = channelIterator;
                channelsKt__Channels_commonKt$distinctBy$1.label = 2;
                Object invoke = function2.invoke(next, channelsKt__Channels_commonKt$distinctBy$1);
                if (invoke != obj2) {
                    obj3 = next;
                    obj = invoke;
                    producerScope3 = producerScope4;
                    hashSet3 = hashSet4;
                    if (hashSet3.contains(obj)) {
                        channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
                        coroutine_suspended = obj2;
                        channelIterator2 = channelIterator;
                        hashSet2 = hashSet3;
                        producerScope2 = producerScope3;
                    }
                    channelsKt__Channels_commonKt$distinctBy$1.L$0 = producerScope3;
                    channelsKt__Channels_commonKt$distinctBy$1.L$1 = hashSet3;
                    channelsKt__Channels_commonKt$distinctBy$1.L$2 = obj3;
                    channelsKt__Channels_commonKt$distinctBy$1.L$3 = channelIterator;
                    channelsKt__Channels_commonKt$distinctBy$1.L$4 = obj;
                    channelsKt__Channels_commonKt$distinctBy$1.label = 3;
                    if (producerScope3.send(obj3, channelsKt__Channels_commonKt$distinctBy$1) == obj2) {
                    }
                    return obj2;
                }
                return obj2;
            }
            return Unit.INSTANCE;
        } else if (i == 2) {
            Object obj4 = this.L$2;
            ResultKt.throwOnFailure(obj);
            producerScope3 = (ProducerScope) this.L$0;
            hashSet3 = (HashSet) this.L$1;
            obj3 = obj4;
            channelIterator = (ChannelIterator) this.L$3;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$distinctBy$1 = this;
            if (hashSet3.contains(obj)) {
                channelsKt__Channels_commonKt$distinctBy$1.L$0 = producerScope3;
                channelsKt__Channels_commonKt$distinctBy$1.L$1 = hashSet3;
                channelsKt__Channels_commonKt$distinctBy$1.L$2 = obj3;
                channelsKt__Channels_commonKt$distinctBy$1.L$3 = channelIterator;
                channelsKt__Channels_commonKt$distinctBy$1.L$4 = obj;
                channelsKt__Channels_commonKt$distinctBy$1.label = 3;
                if (producerScope3.send(obj3, channelsKt__Channels_commonKt$distinctBy$1) == obj2) {
                    hashSet = hashSet3;
                    producerScope = producerScope3;
                    hashSet.add(obj);
                    channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
                    coroutine_suspended = obj2;
                    channelIterator2 = channelIterator;
                    hashSet2 = hashSet;
                    producerScope2 = producerScope;
                }
                return obj2;
            }
            channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
            coroutine_suspended = obj2;
            channelIterator2 = channelIterator;
            hashSet2 = hashSet3;
            producerScope2 = producerScope3;
        } else if (i == 3) {
            Object obj5 = this.L$4;
            channelIterator = (ChannelIterator) this.L$3;
            hashSet = (HashSet) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj = obj5;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$distinctBy$1 = this;
            hashSet.add(obj);
            channelsKt__Channels_commonKt$distinctBy$12 = channelsKt__Channels_commonKt$distinctBy$1;
            coroutine_suspended = obj2;
            channelIterator2 = channelIterator;
            hashSet2 = hashSet;
            producerScope2 = producerScope;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__Channels_commonKt$distinctBy$12.L$0 = producerScope2;
        channelsKt__Channels_commonKt$distinctBy$12.L$1 = hashSet2;
        channelsKt__Channels_commonKt$distinctBy$12.L$2 = channelIterator2;
        channelsKt__Channels_commonKt$distinctBy$12.label = 1;
        Object hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$distinctBy$12);
        if (hasNext != coroutine_suspended) {
            channelsKt__Channels_commonKt$distinctBy$1 = channelsKt__Channels_commonKt$distinctBy$12;
            obj = hasNext;
            producerScope4 = producerScope2;
            hashSet4 = hashSet2;
            channelIterator = channelIterator2;
            obj2 = coroutine_suspended;
            if (!((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
