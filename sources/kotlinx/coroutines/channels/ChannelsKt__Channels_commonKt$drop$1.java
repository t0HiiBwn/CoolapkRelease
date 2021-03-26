package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {695, 700, 701}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "remaining", "e"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, continuation);
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        Object obj2;
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1;
        ProducerScope producerScope2;
        Object hasNext;
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$12;
        ChannelIterator channelIterator2;
        ProducerScope producerScope3;
        int i2;
        Object hasNext2;
        ProducerScope producerScope4;
        ChannelIterator channelIterator3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope2 = this.p$;
            int i4 = this.$n;
            if (!(i4 >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + this.$n + " is less than zero.").toString());
            } else if (i4 > 0) {
                producerScope3 = producerScope2;
                channelsKt__Channels_commonKt$drop$12 = this;
                channelIterator2 = this.$this_drop.iterator();
                i2 = i4;
                channelsKt__Channels_commonKt$drop$12.L$0 = producerScope3;
                channelsKt__Channels_commonKt$drop$12.I$0 = i2;
                channelsKt__Channels_commonKt$drop$12.L$1 = channelIterator2;
                channelsKt__Channels_commonKt$drop$12.label = 1;
                hasNext2 = channelIterator2.hasNext(channelsKt__Channels_commonKt$drop$12);
                if (hasNext2 == coroutine_suspended) {
                    channelsKt__Channels_commonKt$drop$1 = channelsKt__Channels_commonKt$drop$12;
                    obj = hasNext2;
                    producerScope4 = producerScope3;
                    i = i2;
                    channelIterator3 = channelIterator2;
                    obj2 = coroutine_suspended;
                }
                return coroutine_suspended;
            } else {
                i = i4;
                obj2 = coroutine_suspended;
                channelsKt__Channels_commonKt$drop$1 = this;
                channelIterator = channelsKt__Channels_commonKt$drop$1.$this_drop.iterator();
                channelsKt__Channels_commonKt$drop$1.L$0 = producerScope2;
                channelsKt__Channels_commonKt$drop$1.I$0 = i;
                channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                channelsKt__Channels_commonKt$drop$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                if (hasNext == obj2) {
                }
                return obj2;
            }
        } else if (i3 == 1) {
            int i5 = this.I$0;
            ResultKt.throwOnFailure(obj);
            producerScope4 = (ProducerScope) this.L$0;
            i = i5;
            channelIterator3 = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
        } else if (i3 == 2) {
            int i6 = this.I$0;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i6;
            channelIterator = (ChannelIterator) this.L$1;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            if (!((Boolean) obj).booleanValue()) {
            }
            return Unit.INSTANCE;
        } else if (i3 == 3) {
            int i7 = this.I$0;
            ResultKt.throwOnFailure(obj);
            i = i7;
            producerScope2 = (ProducerScope) this.L$0;
            channelIterator = (ChannelIterator) this.L$2;
            obj2 = coroutine_suspended;
            channelsKt__Channels_commonKt$drop$1 = this;
            channelsKt__Channels_commonKt$drop$1.L$0 = producerScope2;
            channelsKt__Channels_commonKt$drop$1.I$0 = i;
            channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
            channelsKt__Channels_commonKt$drop$1.label = 2;
            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
            if (hasNext == obj2) {
                producerScope = producerScope2;
                obj = hasNext;
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    channelsKt__Channels_commonKt$drop$1.L$0 = producerScope;
                    channelsKt__Channels_commonKt$drop$1.I$0 = i;
                    channelsKt__Channels_commonKt$drop$1.L$1 = next;
                    channelsKt__Channels_commonKt$drop$1.L$2 = channelIterator;
                    channelsKt__Channels_commonKt$drop$1.label = 3;
                    if (producerScope.send(next, channelsKt__Channels_commonKt$drop$1) != obj2) {
                        producerScope2 = producerScope;
                        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope2;
                        channelsKt__Channels_commonKt$drop$1.I$0 = i;
                        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
                        channelsKt__Channels_commonKt$drop$1.label = 2;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
                        if (hasNext == obj2) {
                        }
                    }
                    return obj2;
                }
                return Unit.INSTANCE;
            }
            return obj2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            channelIterator3.next();
            int i8 = i - 1;
            if (i8 != 0) {
                producerScope3 = producerScope4;
                channelIterator2 = channelIterator3;
                i2 = i8;
                channelsKt__Channels_commonKt$drop$12 = channelsKt__Channels_commonKt$drop$1;
                coroutine_suspended = obj2;
                channelsKt__Channels_commonKt$drop$12.L$0 = producerScope3;
                channelsKt__Channels_commonKt$drop$12.I$0 = i2;
                channelsKt__Channels_commonKt$drop$12.L$1 = channelIterator2;
                channelsKt__Channels_commonKt$drop$12.label = 1;
                hasNext2 = channelIterator2.hasNext(channelsKt__Channels_commonKt$drop$12);
                if (hasNext2 == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            i = i8;
        }
        producerScope2 = producerScope4;
        channelIterator = channelsKt__Channels_commonKt$drop$1.$this_drop.iterator();
        channelsKt__Channels_commonKt$drop$1.L$0 = producerScope2;
        channelsKt__Channels_commonKt$drop$1.I$0 = i;
        channelsKt__Channels_commonKt$drop$1.L$1 = channelIterator;
        channelsKt__Channels_commonKt$drop$1.label = 2;
        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$drop$1);
        if (hasNext == obj2) {
        }
        return obj2;
    }
}
