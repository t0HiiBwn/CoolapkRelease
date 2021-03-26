package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2201, 2191, 2193}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "element2"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $other;
    final /* synthetic */ ReceiveChannel $this_zip;
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$zip$2(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_zip = receiveChannel;
        this.$other = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2 = new ChannelsKt__Channels_commonKt$zip$2(this.$this_zip, this.$other, this.$transform, continuation);
        channelsKt__Channels_commonKt$zip$2.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$zip$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$zip$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2;
        ProducerScope producerScope;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel;
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$22;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator2;
        Object obj2;
        Object obj3;
        ChannelIterator channelIterator3;
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$23;
        Throwable th2;
        Object obj4;
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$24;
        Object invoke;
        Object obj5;
        Throwable th3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 2;
        int i3 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope2 = this.p$;
            ChannelIterator it2 = this.$other.iterator();
            receiveChannel2 = this.$this_zip;
            th = null;
            channelsKt__Channels_commonKt$zip$2 = this;
            producerScope = producerScope2;
            channelIterator = it2;
            receiveChannel3 = receiveChannel2;
            receiveChannel = receiveChannel3;
            channelIterator2 = receiveChannel2.iterator();
            channelsKt__Channels_commonKt$zip$22 = channelsKt__Channels_commonKt$zip$2;
        } else if (i == 1) {
            channelIterator2 = (ChannelIterator) this.L$7;
            receiveChannel3 = (ReceiveChannel) this.L$6;
            th = (Throwable) this.L$5;
            receiveChannel2 = (ReceiveChannel) this.L$4;
            channelsKt__Channels_commonKt$zip$22 = (ChannelsKt__Channels_commonKt$zip$2) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            channelIterator = (ChannelIterator) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj5 = obj;
            channelsKt__Channels_commonKt$zip$2 = this;
            if (!((Boolean) obj5).booleanValue()) {
                obj3 = channelIterator2.next();
                channelsKt__Channels_commonKt$zip$2.L$0 = producerScope;
                channelsKt__Channels_commonKt$zip$2.L$1 = channelIterator;
                channelsKt__Channels_commonKt$zip$2.L$2 = receiveChannel;
                channelsKt__Channels_commonKt$zip$2.L$3 = channelsKt__Channels_commonKt$zip$22;
                channelsKt__Channels_commonKt$zip$2.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$zip$2.L$5 = th;
                channelsKt__Channels_commonKt$zip$2.L$6 = receiveChannel3;
                channelsKt__Channels_commonKt$zip$2.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$zip$2.L$8 = obj3;
                channelsKt__Channels_commonKt$zip$2.L$9 = obj3;
                channelsKt__Channels_commonKt$zip$2.label = i2;
                obj2 = channelIterator.hasNext(channelsKt__Channels_commonKt$zip$2);
                if (obj2 != coroutine_suspended) {
                    channelsKt__Channels_commonKt$zip$24 = channelsKt__Channels_commonKt$zip$2;
                    channelIterator3 = channelIterator;
                    channelsKt__Channels_commonKt$zip$23 = channelsKt__Channels_commonKt$zip$22;
                    th2 = th;
                    obj4 = obj3;
                    if (((Boolean) obj2).booleanValue()) {
                        Object next = channelIterator3.next();
                        invoke = channelsKt__Channels_commonKt$zip$24.$transform.invoke(obj3, next);
                        channelsKt__Channels_commonKt$zip$24.L$0 = producerScope;
                        channelsKt__Channels_commonKt$zip$24.L$1 = channelIterator3;
                        channelsKt__Channels_commonKt$zip$24.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$zip$24.L$3 = channelsKt__Channels_commonKt$zip$23;
                        channelsKt__Channels_commonKt$zip$24.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$zip$24.L$5 = th2;
                        channelsKt__Channels_commonKt$zip$24.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$zip$24.L$7 = channelIterator2;
                        channelsKt__Channels_commonKt$zip$24.L$8 = obj4;
                        channelsKt__Channels_commonKt$zip$24.L$9 = obj3;
                        channelsKt__Channels_commonKt$zip$24.L$10 = next;
                        channelsKt__Channels_commonKt$zip$24.label = 3;
                        if (producerScope.send(invoke, channelsKt__Channels_commonKt$zip$24) == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    th = th2;
                    channelsKt__Channels_commonKt$zip$22 = channelsKt__Channels_commonKt$zip$23;
                    channelIterator = channelIterator3;
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$24;
                    i2 = 2;
                }
                return coroutine_suspended;
            }
            Unit unit = Unit.INSTANCE;
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            return Unit.INSTANCE;
        } else if (i == 2) {
            Object obj6 = this.L$9;
            Object obj7 = this.L$8;
            ChannelIterator channelIterator4 = (ChannelIterator) this.L$7;
            ReceiveChannel receiveChannel4 = (ReceiveChannel) this.L$6;
            th2 = (Throwable) this.L$5;
            ReceiveChannel receiveChannel5 = (ReceiveChannel) this.L$4;
            channelsKt__Channels_commonKt$zip$23 = (ChannelsKt__Channels_commonKt$zip$2) this.L$3;
            ReceiveChannel receiveChannel6 = (ReceiveChannel) this.L$2;
            channelIterator3 = (ChannelIterator) this.L$1;
            ProducerScope producerScope3 = (ProducerScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                channelsKt__Channels_commonKt$zip$24 = this;
                obj3 = obj6;
                channelIterator2 = channelIterator4;
                obj4 = obj7;
                receiveChannel3 = receiveChannel4;
                receiveChannel2 = receiveChannel5;
                receiveChannel = receiveChannel6;
                producerScope = producerScope3;
                if (((Boolean) obj2).booleanValue()) {
                    th = th2;
                    channelsKt__Channels_commonKt$zip$22 = channelsKt__Channels_commonKt$zip$23;
                    channelIterator = channelIterator3;
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$24;
                    i2 = 2;
                }
                Object next = channelIterator3.next();
                invoke = channelsKt__Channels_commonKt$zip$24.$transform.invoke(obj3, next);
                channelsKt__Channels_commonKt$zip$24.L$0 = producerScope;
                channelsKt__Channels_commonKt$zip$24.L$1 = channelIterator3;
                channelsKt__Channels_commonKt$zip$24.L$2 = receiveChannel;
                channelsKt__Channels_commonKt$zip$24.L$3 = channelsKt__Channels_commonKt$zip$23;
                channelsKt__Channels_commonKt$zip$24.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$zip$24.L$5 = th2;
                channelsKt__Channels_commonKt$zip$24.L$6 = receiveChannel3;
                channelsKt__Channels_commonKt$zip$24.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$zip$24.L$8 = obj4;
                channelsKt__Channels_commonKt$zip$24.L$9 = obj3;
                channelsKt__Channels_commonKt$zip$24.L$10 = next;
                channelsKt__Channels_commonKt$zip$24.label = 3;
                if (producerScope.send(invoke, channelsKt__Channels_commonKt$zip$24) == coroutine_suspended) {
                    th = th2;
                    channelsKt__Channels_commonKt$zip$22 = channelsKt__Channels_commonKt$zip$23;
                    channelIterator = channelIterator3;
                    channelsKt__Channels_commonKt$zip$2 = channelsKt__Channels_commonKt$zip$24;
                    i2 = 2;
                    i3 = 1;
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th3 = th4;
                receiveChannel2 = receiveChannel5;
                throw th3;
            }
        } else if (i == 3) {
            channelIterator2 = (ChannelIterator) this.L$7;
            receiveChannel3 = (ReceiveChannel) this.L$6;
            th = (Throwable) this.L$5;
            receiveChannel2 = (ReceiveChannel) this.L$4;
            channelsKt__Channels_commonKt$zip$22 = (ChannelsKt__Channels_commonKt$zip$2) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            channelIterator = (ChannelIterator) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                channelsKt__Channels_commonKt$zip$2 = this;
                i2 = 2;
                i3 = 1;
            } catch (Throwable th5) {
                th3 = th5;
                try {
                    throw th3;
                } catch (Throwable th6) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    throw th6;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        channelsKt__Channels_commonKt$zip$2.L$0 = producerScope;
        channelsKt__Channels_commonKt$zip$2.L$1 = channelIterator;
        channelsKt__Channels_commonKt$zip$2.L$2 = receiveChannel;
        channelsKt__Channels_commonKt$zip$2.L$3 = channelsKt__Channels_commonKt$zip$22;
        channelsKt__Channels_commonKt$zip$2.L$4 = receiveChannel2;
        channelsKt__Channels_commonKt$zip$2.L$5 = th;
        channelsKt__Channels_commonKt$zip$2.L$6 = receiveChannel3;
        channelsKt__Channels_commonKt$zip$2.L$7 = channelIterator2;
        channelsKt__Channels_commonKt$zip$2.label = i3;
        obj5 = channelIterator2.hasNext(channelsKt__Channels_commonKt$zip$22);
        if (obj5 == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj5).booleanValue()) {
        }
        Unit unit = Unit.INSTANCE;
        ChannelsKt.cancelConsumed(receiveChannel2, th);
        return Unit.INSTANCE;
    }
}
