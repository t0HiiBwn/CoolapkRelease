package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: Channels.common.kt */
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        CancellationException cancellationException = null;
        int i = 1;
        try {
            return (R) function1.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(i);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, cancellationException, i, (Object) cancellationException);
            InlineMarker.finallyEnd(i);
        }
    }

    public static final <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        if (receiveChannel != null) {
            return receiveChannel.receiveOrNull(continuation);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E?>");
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause1<? extends E>, kotlinx.coroutines.selects.SelectClause1<E> */
    public static final <E> SelectClause1<E> onReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
        if (receiveChannel != null) {
            return (SelectClause1<? extends E>) receiveChannel.getOnReceiveOrNull();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E?>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$1;
        int i;
        Throwable th;
        ReceiveChannel<E> receiveChannel;
        BroadcastChannel<E> broadcastChannel2;
        ChannelIterator<E> channelIterator;
        ReceiveChannel<E> receiveChannel2;
        Object obj;
        BroadcastChannel<E> broadcastChannel3;
        ReceiveChannel<E> receiveChannel3;
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$12;
        Function1<? super E, Unit> function12;
        BroadcastChannel<E> broadcastChannel4;
        Object obj2;
        ReceiveChannel<E> receiveChannel4;
        ChannelIterator<E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$1) {
            channelsKt__Channels_commonKt$consumeEach$1 = (ChannelsKt__Channels_commonKt$consumeEach$1) continuation;
            if ((channelsKt__Channels_commonKt$consumeEach$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$consumeEach$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEach$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    receiveChannel3 = broadcastChannel.openSubscription();
                    obj2 = coroutine_suspended;
                    receiveChannel4 = receiveChannel3;
                    channelsKt__Channels_commonKt$consumeEach$12 = channelsKt__Channels_commonKt$consumeEach$1;
                    function12 = function1;
                    broadcastChannel2 = broadcastChannel;
                    channelIterator2 = receiveChannel3.iterator();
                    broadcastChannel4 = broadcastChannel2;
                } else if (i == 1) {
                    ChannelIterator<E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$1.L$5;
                    ReceiveChannel<E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$4;
                    receiveChannel = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$3;
                    broadcastChannel3 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$1.L$2;
                    Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$1.L$1;
                    BroadcastChannel<E> broadcastChannel5 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel3 = receiveChannel5;
                        broadcastChannel2 = broadcastChannel5;
                        receiveChannel2 = receiveChannel;
                        channelsKt__Channels_commonKt$consumeEach$12 = channelsKt__Channels_commonKt$consumeEach$1;
                        function12 = function13;
                        obj = coroutine_suspended;
                        channelIterator = channelIterator3;
                        try {
                            if (!((Boolean) obj3).booleanValue()) {
                                function12.invoke(channelIterator.next());
                                broadcastChannel4 = broadcastChannel3;
                                obj2 = obj;
                                receiveChannel4 = receiveChannel2;
                                channelIterator2 = channelIterator;
                            }
                            Unit unit = Unit.INSTANCE;
                            InlineMarker.finallyStart(1);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
                            InlineMarker.finallyEnd(1);
                            return unit;
                        } catch (Throwable th2) {
                            th = th2;
                            receiveChannel = receiveChannel2;
                            InlineMarker.finallyStart(1);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                            InlineMarker.finallyEnd(1);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        InlineMarker.finallyStart(1);
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$consumeEach$12.L$0 = broadcastChannel2;
                channelsKt__Channels_commonKt$consumeEach$12.L$1 = function12;
                channelsKt__Channels_commonKt$consumeEach$12.L$2 = broadcastChannel4;
                channelsKt__Channels_commonKt$consumeEach$12.L$3 = receiveChannel4;
                channelsKt__Channels_commonKt$consumeEach$12.L$4 = receiveChannel3;
                channelsKt__Channels_commonKt$consumeEach$12.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$consumeEach$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$12);
                if (hasNext == obj2) {
                    broadcastChannel3 = broadcastChannel4;
                    obj3 = hasNext;
                    receiveChannel2 = receiveChannel4;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
                    InlineMarker.finallyEnd(1);
                    return unit;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$1 = new ChannelsKt__Channels_commonKt$consumeEach$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$consumeEach$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEach$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$consumeEach$12.L$0 = broadcastChannel2;
            channelsKt__Channels_commonKt$consumeEach$12.L$1 = function12;
            channelsKt__Channels_commonKt$consumeEach$12.L$2 = broadcastChannel4;
            channelsKt__Channels_commonKt$consumeEach$12.L$3 = receiveChannel4;
            channelsKt__Channels_commonKt$consumeEach$12.L$4 = receiveChannel3;
            channelsKt__Channels_commonKt$consumeEach$12.L$5 = channelIterator2;
            channelsKt__Channels_commonKt$consumeEach$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th4) {
            th = th4;
            receiveChannel = receiveChannel4;
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> receiveChannel) {
        return new ChannelsKt__Channels_commonKt$consumes$1(receiveChannel);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.concurrent.CancellationException */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = th;
            }
            cancellationException = cancellationException;
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?>... receiveChannelArr) {
        return new ChannelsKt__Channels_commonKt$consumesAll$1(receiveChannelArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r2, r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        Throwable th = null;
        R r = (R) function1.invoke(receiveChannel);
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(1);
        return r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$32;
        Function1<? super E, Unit> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$3) {
            channelsKt__Channels_commonKt$consumeEach$3 = (ChannelsKt__Channels_commonKt$consumeEach$3) continuation;
            if ((channelsKt__Channels_commonKt$consumeEach$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$consumeEach$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEach$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        function12 = function1;
                        receiveChannel3 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                        receiveChannel5 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$4;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$consumeEach$3.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                    Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel6;
                        receiveChannel3 = receiveChannel7;
                        th2 = th5;
                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                        obj = coroutine_suspended;
                        function12 = function13;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            function12.invoke((Object) channelIterator.next());
                            receiveChannel2 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel4, th2);
                        InlineMarker.finallyEnd(1);
                        return unit;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel4;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$consumeEach$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$consumeEach$32.L$1 = function12;
                channelsKt__Channels_commonKt$consumeEach$32.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$consumeEach$32.L$3 = th3;
                channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$consumeEach$32.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$consumeEach$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel2;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel4, th2);
                    InlineMarker.finallyEnd(1);
                    return unit;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$consumeEach$3 = new ChannelsKt__Channels_commonKt$consumeEach$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$consumeEach$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEach$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$consumeEach$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$consumeEach$32.L$1 = function12;
            channelsKt__Channels_commonKt$consumeEach$32.L$2 = receiveChannel2;
            channelsKt__Channels_commonKt$consumeEach$32.L$3 = th3;
            channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$consumeEach$32.L$5 = channelIterator2;
            channelsKt__Channels_commonKt$consumeEach$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8 A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E> Object consumeEachIndexed(ReceiveChannel<? extends E> receiveChannel, Function1<? super IndexedValue<? extends E>, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEachIndexed$1 channelsKt__Channels_commonKt$consumeEachIndexed$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.IntRef intRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$consumeEachIndexed$1 channelsKt__Channels_commonKt$consumeEachIndexed$12;
        Function1<? super IndexedValue<? extends E>, Unit> function12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEachIndexed$1) {
            channelsKt__Channels_commonKt$consumeEachIndexed$1 = (ChannelsKt__Channels_commonKt$consumeEachIndexed$1) continuation;
            if ((channelsKt__Channels_commonKt$consumeEachIndexed$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEachIndexed$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$consumeEachIndexed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEachIndexed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12 = channelsKt__Channels_commonKt$consumeEachIndexed$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                        function12 = function1;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$3;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$2;
                    Function1<? super IndexedValue<? extends E>, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$consumeEachIndexed$12 = channelsKt__Channels_commonKt$consumeEachIndexed$1;
                        receiveChannel5 = receiveChannel9;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        function12 = function13;
                        intRef = intRef3;
                        th3 = th5;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i2 = intRef.element;
                            intRef.element = i2 + 1;
                            function12.invoke(new IndexedValue(i2, next));
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return Unit.INSTANCE;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$1 = function12;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$2 = intRef;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$5 = th3;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$6 = receiveChannel4;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$consumeEachIndexed$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEachIndexed$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$consumeEachIndexed$1 = new ChannelsKt__Channels_commonKt$consumeEachIndexed$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$consumeEachIndexed$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEachIndexed$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$1 = function12;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$2 = intRef;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$3 = receiveChannel5;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$5 = th3;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$6 = receiveChannel4;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$consumeEachIndexed$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$consumeEachIndexed$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0094 A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2 A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    public static final <E> Object elementAt(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAt$1 channelsKt__Channels_commonKt$elementAt$1;
        int i2;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel4;
        Object obj;
        ChannelsKt__Channels_commonKt$elementAt$1 channelsKt__Channels_commonKt$elementAt$12;
        ChannelIterator<? extends E> channelIterator;
        int i3;
        ReceiveChannel<? extends E> receiveChannel5;
        int i4;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator2;
        int i5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAt$1) {
            channelsKt__Channels_commonKt$elementAt$1 = (ChannelsKt__Channels_commonKt$elementAt$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAt$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAt$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$elementAt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__Channels_commonKt$elementAt$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    if (i >= 0) {
                        try {
                            i3 = i;
                            th3 = th4;
                            channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                            obj = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            i5 = 0;
                            receiveChannel7 = receiveChannel;
                            receiveChannel6 = receiveChannel7;
                            receiveChannel2 = receiveChannel6;
                            receiveChannel5 = receiveChannel2;
                        } catch (Throwable th5) {
                            th2 = th5;
                            receiveChannel2 = receiveChannel;
                            th = th2;
                            throw th;
                        }
                    } else {
                        Boxing.boxInt(i).intValue();
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                    }
                } else if (i2 == 1) {
                    i4 = channelsKt__Channels_commonKt$elementAt$1.I$1;
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$elementAt$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$4;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$elementAt$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$2;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$1;
                    int i6 = channelsKt__Channels_commonKt$elementAt$1.I$0;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                        receiveChannel2 = receiveChannel9;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel8;
                        channelIterator = channelIterator3;
                        i3 = i6;
                        th3 = th6;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i7 = i4 + 1;
                            if (i3 != i4) {
                                receiveChannel6 = receiveChannel4;
                                receiveChannel7 = receiveChannel3;
                                channelIterator2 = channelIterator;
                                i5 = i7;
                            }
                            ChannelsKt.cancelConsumed(receiveChannel2, th3);
                            return next;
                        }
                        Boxing.boxInt(i3).intValue();
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i3 + '.');
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$elementAt$12.I$0 = i3;
                channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel6;
                channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$elementAt$12.L$3 = th3;
                channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$elementAt$12.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$elementAt$12.I$1 = i5;
                channelsKt__Channels_commonKt$elementAt$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAt$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    i4 = i5;
                    channelIterator = channelIterator2;
                    receiveChannel4 = receiveChannel6;
                    obj2 = hasNext;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Boxing.boxInt(i3).intValue();
                    throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i3 + '.');
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$elementAt$1 = new ChannelsKt__Channels_commonKt$elementAt$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$elementAt$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__Channels_commonKt$elementAt$1.label;
        if (i2 != 0) {
        }
        try {
            channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$elementAt$12.I$0 = i3;
            channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel6;
            channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
            channelsKt__Channels_commonKt$elementAt$12.L$3 = th3;
            channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$elementAt$12.L$5 = channelIterator2;
            channelsKt__Channels_commonKt$elementAt$12.I$1 = i5;
            channelsKt__Channels_commonKt$elementAt$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAt$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th2 = th9;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object elementAtOrElse(ReceiveChannel<? extends E> receiveChannel, int i, Function1<? super Integer, ? extends E> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAtOrElse$1 channelsKt__Channels_commonKt$elementAtOrElse$1;
        int i2;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        int i4;
        Object obj;
        ChannelsKt__Channels_commonKt$elementAtOrElse$1 channelsKt__Channels_commonKt$elementAtOrElse$12;
        Throwable th2;
        Function1<? super Integer, ? extends E> function12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        int i5;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th3;
        int i6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAtOrElse$1) {
            channelsKt__Channels_commonKt$elementAtOrElse$1 = (ChannelsKt__Channels_commonKt$elementAtOrElse$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAtOrElse$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAtOrElse$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$elementAtOrElse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__Channels_commonKt$elementAtOrElse$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    if (i < 0) {
                        try {
                            Object invoke = function1.invoke(Boxing.boxInt(i));
                            InlineMarker.finallyStart(4);
                            ChannelsKt.cancelConsumed(receiveChannel, th4);
                            InlineMarker.finallyEnd(4);
                            return invoke;
                        } catch (Throwable th5) {
                            receiveChannel2 = receiveChannel;
                            th = th5;
                            throw th;
                        }
                    } else {
                        i6 = 0;
                        th3 = th4;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel;
                        function12 = function1;
                        receiveChannel2 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$elementAtOrElse$12 = channelsKt__Channels_commonKt$elementAtOrElse$1;
                        i5 = i;
                        receiveChannel6 = receiveChannel2;
                    }
                } else if (i2 == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$elementAtOrElse$1.L$5;
                    i3 = channelsKt__Channels_commonKt$elementAtOrElse$1.I$1;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrElse$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$elementAtOrElse$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrElse$1.L$2;
                    Function1<? super Integer, ? extends E> function13 = (Function1) channelsKt__Channels_commonKt$elementAtOrElse$1.L$1;
                    i4 = channelsKt__Channels_commonKt$elementAtOrElse$1.I$0;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrElse$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel4 = receiveChannel7;
                        receiveChannel2 = receiveChannel8;
                        channelsKt__Channels_commonKt$elementAtOrElse$12 = channelsKt__Channels_commonKt$elementAtOrElse$1;
                        obj = coroutine_suspended;
                        function12 = function13;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i7 = i3 + 1;
                            if (i4 != i3) {
                                receiveChannel5 = receiveChannel4;
                                i5 = i4;
                                receiveChannel6 = receiveChannel3;
                                th3 = th2;
                                i6 = i7;
                                channelIterator2 = channelIterator;
                            }
                            InlineMarker.finallyStart(3);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(3);
                            return next;
                        }
                        Object invoke2 = function12.invoke(Boxing.boxInt(i4));
                        InlineMarker.finallyStart(2);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(2);
                        return invoke2;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$elementAtOrElse$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$elementAtOrElse$12.I$0 = i5;
                channelsKt__Channels_commonKt$elementAtOrElse$12.L$1 = function12;
                channelsKt__Channels_commonKt$elementAtOrElse$12.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$elementAtOrElse$12.L$3 = th3;
                channelsKt__Channels_commonKt$elementAtOrElse$12.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$elementAtOrElse$12.I$1 = i6;
                channelsKt__Channels_commonKt$elementAtOrElse$12.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$elementAtOrElse$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAtOrElse$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    i3 = i6;
                    th2 = th3;
                    i4 = i5;
                    receiveChannel4 = receiveChannel5;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Object invoke2 = function12.invoke(Boxing.boxInt(i4));
                    InlineMarker.finallyStart(2);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(2);
                    return invoke2;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$elementAtOrElse$1 = new ChannelsKt__Channels_commonKt$elementAtOrElse$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$elementAtOrElse$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__Channels_commonKt$elementAtOrElse$1.label;
        if (i2 != 0) {
        }
        try {
            channelsKt__Channels_commonKt$elementAtOrElse$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$elementAtOrElse$12.I$0 = i5;
            channelsKt__Channels_commonKt$elementAtOrElse$12.L$1 = function12;
            channelsKt__Channels_commonKt$elementAtOrElse$12.L$2 = receiveChannel2;
            channelsKt__Channels_commonKt$elementAtOrElse$12.L$3 = th3;
            channelsKt__Channels_commonKt$elementAtOrElse$12.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$elementAtOrElse$12.I$1 = i6;
            channelsKt__Channels_commonKt$elementAtOrElse$12.L$5 = channelIterator2;
            channelsKt__Channels_commonKt$elementAtOrElse$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAtOrElse$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E> Object elementAtOrNull(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAtOrNull$1 channelsKt__Channels_commonKt$elementAtOrNull$1;
        int i2;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$elementAtOrNull$1 channelsKt__Channels_commonKt$elementAtOrNull$12;
        Object obj;
        int i4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        int i5;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAtOrNull$1) {
            channelsKt__Channels_commonKt$elementAtOrNull$1 = (ChannelsKt__Channels_commonKt$elementAtOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAtOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAtOrNull$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$elementAtOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__Channels_commonKt$elementAtOrNull$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Throwable th3 = null;
                    if (i < 0) {
                        ChannelsKt.cancelConsumed(receiveChannel, th3);
                        return null;
                    }
                    i5 = 0;
                    try {
                        th2 = th3;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        i4 = i;
                        receiveChannel6 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                        receiveChannel5 = receiveChannel6;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i2 == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$elementAtOrNull$1.L$4;
                    i3 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$1;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$3;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$elementAtOrNull$1.L$2;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$1;
                    int i6 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$0;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                        receiveChannel5 = receiveChannel7;
                        obj = coroutine_suspended;
                        i4 = i6;
                        th2 = th5;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object next = channelIterator.next();
                            int i7 = i3 + 1;
                            if (i4 != i3) {
                                receiveChannel2 = receiveChannel4;
                                receiveChannel6 = receiveChannel3;
                                obj2 = obj;
                                i5 = i7;
                                channelIterator2 = channelIterator;
                            }
                            ChannelsKt.cancelConsumed(receiveChannel4, th2);
                            return next;
                        }
                        ChannelsKt.cancelConsumed(receiveChannel4, th2);
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel4;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$elementAtOrNull$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$elementAtOrNull$12.I$0 = i4;
                channelsKt__Channels_commonKt$elementAtOrNull$12.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$elementAtOrNull$12.L$2 = th2;
                channelsKt__Channels_commonKt$elementAtOrNull$12.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$elementAtOrNull$12.I$1 = i5;
                channelsKt__Channels_commonKt$elementAtOrNull$12.L$4 = channelIterator2;
                channelsKt__Channels_commonKt$elementAtOrNull$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAtOrNull$12);
                if (hasNext == obj2) {
                    receiveChannel3 = receiveChannel6;
                    i3 = i5;
                    obj = obj2;
                    receiveChannel4 = receiveChannel2;
                    obj3 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    ChannelsKt.cancelConsumed(receiveChannel4, th2);
                    return null;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$elementAtOrNull$1 = new ChannelsKt__Channels_commonKt$elementAtOrNull$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$elementAtOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__Channels_commonKt$elementAtOrNull$1.label;
        if (i2 != 0) {
        }
        try {
            channelsKt__Channels_commonKt$elementAtOrNull$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$elementAtOrNull$12.I$0 = i4;
            channelsKt__Channels_commonKt$elementAtOrNull$12.L$1 = receiveChannel2;
            channelsKt__Channels_commonKt$elementAtOrNull$12.L$2 = th2;
            channelsKt__Channels_commonKt$elementAtOrNull$12.L$3 = receiveChannel5;
            channelsKt__Channels_commonKt$elementAtOrNull$12.I$1 = i5;
            channelsKt__Channels_commonKt$elementAtOrNull$12.L$4 = channelIterator2;
            channelsKt__Channels_commonKt$elementAtOrNull$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$elementAtOrNull$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    public static final <E> Object find(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$find$1 channelsKt__Channels_commonKt$find$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$find$1 channelsKt__Channels_commonKt$find$12;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$find$1) {
            channelsKt__Channels_commonKt$find$1 = (ChannelsKt__Channels_commonKt$find$1) continuation;
            if ((channelsKt__Channels_commonKt$find$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$find$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$find$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$find$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        receiveChannel4 = receiveChannel;
                        function12 = function1;
                        th3 = null;
                        channelsKt__Channels_commonKt$find$12 = channelsKt__Channels_commonKt$find$1;
                        obj = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel4;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$find$1.L$7;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$find$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$find$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$find$12 = channelsKt__Channels_commonKt$find$1;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        receiveChannel2 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        th3 = th5;
                        function12 = function13;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object obj3 = (Object) channelIterator.next();
                            if (!function12.invoke(obj3).booleanValue()) {
                                receiveChannel7 = receiveChannel3;
                                channelIterator2 = channelIterator;
                            }
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th3);
                            InlineMarker.finallyEnd(2);
                            return obj3;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$find$12.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$find$12.L$1 = function12;
                channelsKt__Channels_commonKt$find$12.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$find$12.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$find$12.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$find$12.L$5 = th3;
                channelsKt__Channels_commonKt$find$12.L$6 = receiveChannel4;
                channelsKt__Channels_commonKt$find$12.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$find$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$find$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return null;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$find$1 = new ChannelsKt__Channels_commonKt$find$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$find$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$find$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$find$12.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$find$12.L$1 = function12;
            channelsKt__Channels_commonKt$find$12.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$find$12.L$3 = receiveChannel5;
            channelsKt__Channels_commonKt$find$12.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$find$12.L$5 = th3;
            channelsKt__Channels_commonKt$find$12.L$6 = receiveChannel4;
            channelsKt__Channels_commonKt$find$12.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$find$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$find$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E> Object findLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$findLast$1 channelsKt__Channels_commonKt$findLast$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.ObjectRef objectRef;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object obj;
        ChannelsKt__Channels_commonKt$findLast$1 channelsKt__Channels_commonKt$findLast$12;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th3;
        Ref.ObjectRef objectRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$findLast$1) {
            channelsKt__Channels_commonKt$findLast$1 = (ChannelsKt__Channels_commonKt$findLast$1) continuation;
            if ((channelsKt__Channels_commonKt$findLast$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$findLast$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$findLast$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$findLast$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = null;
                    try {
                        objectRef2 = objectRef3;
                        channelsKt__Channels_commonKt$findLast$12 = channelsKt__Channels_commonKt$findLast$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$findLast$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$findLast$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$4;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) channelsKt__Channels_commonKt$findLast$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$findLast$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel5 = receiveChannel8;
                        receiveChannel3 = receiveChannel11;
                        objectRef = objectRef4;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel9;
                        function12 = function13;
                        th2 = th5;
                        channelsKt__Channels_commonKt$findLast$12 = channelsKt__Channels_commonKt$findLast$1;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            ?? r15 = (Object) channelIterator.next();
                            if (function12.invoke(r15).booleanValue()) {
                                objectRef.element = r15;
                            }
                            receiveChannel7 = receiveChannel4;
                            th3 = th2;
                            objectRef2 = objectRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return objectRef.element;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$findLast$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$findLast$12.L$1 = function12;
                channelsKt__Channels_commonKt$findLast$12.L$2 = receiveChannel7;
                channelsKt__Channels_commonKt$findLast$12.L$3 = objectRef2;
                channelsKt__Channels_commonKt$findLast$12.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$findLast$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$findLast$12.L$6 = th3;
                channelsKt__Channels_commonKt$findLast$12.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$findLast$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$findLast$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$findLast$12);
                if (hasNext == obj) {
                    receiveChannel4 = receiveChannel7;
                    obj2 = hasNext;
                    objectRef = objectRef2;
                    th2 = th3;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return objectRef.element;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$findLast$1 = new ChannelsKt__Channels_commonKt$findLast$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$findLast$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$findLast$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$findLast$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$findLast$12.L$1 = function12;
            channelsKt__Channels_commonKt$findLast$12.L$2 = receiveChannel7;
            channelsKt__Channels_commonKt$findLast$12.L$3 = objectRef2;
            channelsKt__Channels_commonKt$findLast$12.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$findLast$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$findLast$12.L$6 = th3;
            channelsKt__Channels_commonKt$findLast$12.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$findLast$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$findLast$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$findLast$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$first$1 channelsKt__Channels_commonKt$first$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        Throwable th2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$first$1) {
            channelsKt__Channels_commonKt$first$1 = (ChannelsKt__Channels_commonKt$first$1) continuation;
            if ((channelsKt__Channels_commonKt$first$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$first$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$first$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$first$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$2 = th3;
                        channelsKt__Channels_commonKt$first$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$4 = it2;
                        channelsKt__Channels_commonKt$first$1.label = 1;
                        Object hasNext = it2.hasNext(channelsKt__Channels_commonKt$first$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th3;
                        obj = hasNext;
                        receiveChannel2 = receiveChannel;
                        channelIterator = it2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$first$1.L$4;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$first$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return next;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__Channels_commonKt$first$1 = new ChannelsKt__Channels_commonKt$first$1(continuation);
        obj = channelsKt__Channels_commonKt$first$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$first$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$first$3 channelsKt__Channels_commonKt$first$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$first$3 channelsKt__Channels_commonKt$first$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$first$3) {
            channelsKt__Channels_commonKt$first$3 = (ChannelsKt__Channels_commonKt$first$3) continuation;
            if ((channelsKt__Channels_commonKt$first$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$first$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$first$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$first$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$first$32 = channelsKt__Channels_commonKt$first$3;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$first$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$first$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$first$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        function12 = function13;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$first$32 = channelsKt__Channels_commonKt$first$3;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            if (!function12.invoke(obj4).booleanValue()) {
                                receiveChannel6 = receiveChannel4;
                                obj2 = obj;
                                th3 = th2;
                                channelIterator2 = channelIterator;
                            }
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(2);
                            return obj4;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$first$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$first$32.L$1 = function12;
                channelsKt__Channels_commonKt$first$32.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$first$32.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$first$32.L$4 = th3;
                channelsKt__Channels_commonKt$first$32.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$first$32.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$first$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$first$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$first$3 = new ChannelsKt__Channels_commonKt$first$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$first$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$first$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$first$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$first$32.L$1 = function12;
            channelsKt__Channels_commonKt$first$32.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$first$32.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$first$32.L$4 = th3;
            channelsKt__Channels_commonKt$first$32.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$first$32.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$first$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$first$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$firstOrNull$1 channelsKt__Channels_commonKt$firstOrNull$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        Throwable th2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$firstOrNull$1) {
            channelsKt__Channels_commonKt$firstOrNull$1 = (ChannelsKt__Channels_commonKt$firstOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$firstOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$firstOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$firstOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$firstOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$firstOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$2 = th3;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$4 = it2;
                        channelsKt__Channels_commonKt$firstOrNull$1.label = 1;
                        Object hasNext = it2.hasNext(channelsKt__Channels_commonKt$firstOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th3;
                        obj = hasNext;
                        receiveChannel2 = receiveChannel;
                        channelIterator = it2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$firstOrNull$1.L$4;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$firstOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return null;
                }
                Object next = channelIterator.next();
                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                return next;
            }
        }
        channelsKt__Channels_commonKt$firstOrNull$1 = new ChannelsKt__Channels_commonKt$firstOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$firstOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$firstOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$firstOrNull$3 channelsKt__Channels_commonKt$firstOrNull$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$firstOrNull$3 channelsKt__Channels_commonKt$firstOrNull$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$firstOrNull$3) {
            channelsKt__Channels_commonKt$firstOrNull$3 = (ChannelsKt__Channels_commonKt$firstOrNull$3) continuation;
            if ((channelsKt__Channels_commonKt$firstOrNull$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$firstOrNull$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$firstOrNull$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$firstOrNull$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$firstOrNull$32 = channelsKt__Channels_commonKt$firstOrNull$3;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$firstOrNull$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$firstOrNull$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$firstOrNull$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        function12 = function13;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$firstOrNull$32 = channelsKt__Channels_commonKt$firstOrNull$3;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            if (!function12.invoke(obj4).booleanValue()) {
                                receiveChannel6 = receiveChannel4;
                                obj2 = obj;
                                th3 = th2;
                                channelIterator2 = channelIterator;
                            }
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(2);
                            return obj4;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$firstOrNull$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$firstOrNull$32.L$1 = function12;
                channelsKt__Channels_commonKt$firstOrNull$32.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$firstOrNull$32.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$firstOrNull$32.L$4 = th3;
                channelsKt__Channels_commonKt$firstOrNull$32.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$firstOrNull$32.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$firstOrNull$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$firstOrNull$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return null;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$firstOrNull$3 = new ChannelsKt__Channels_commonKt$firstOrNull$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$firstOrNull$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$firstOrNull$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$firstOrNull$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$firstOrNull$32.L$1 = function12;
            channelsKt__Channels_commonKt$firstOrNull$32.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$firstOrNull$32.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$firstOrNull$32.L$4 = th3;
            channelsKt__Channels_commonKt$firstOrNull$32.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$firstOrNull$32.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$firstOrNull$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$firstOrNull$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object indexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOf$1 channelsKt__Channels_commonKt$indexOf$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.IntRef intRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$indexOf$1 channelsKt__Channels_commonKt$indexOf$12;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj3;
        Throwable th3;
        Ref.IntRef intRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$indexOf$1) {
            channelsKt__Channels_commonKt$indexOf$1 = (ChannelsKt__Channels_commonKt$indexOf$1) continuation;
            if ((channelsKt__Channels_commonKt$indexOf$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$indexOf$1.label -= Integer.MIN_VALUE;
                Object obj4 = channelsKt__Channels_commonKt$indexOf$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$indexOf$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        intRef2 = intRef3;
                        obj3 = coroutine_suspended;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        obj2 = e;
                        receiveChannel3 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$indexOf$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$indexOf$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$3;
                    Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOf$1.L$2;
                    Object obj5 = channelsKt__Channels_commonKt$indexOf$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj4);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        intRef = intRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
                        receiveChannel2 = receiveChannel8;
                        th2 = th5;
                        obj2 = obj5;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj4).booleanValue()) {
                            if (!Intrinsics.areEqual(obj2, channelIterator.next())) {
                                intRef.element++;
                                receiveChannel6 = receiveChannel4;
                                obj3 = obj;
                                th3 = th2;
                                intRef2 = intRef;
                                channelIterator2 = channelIterator;
                            }
                            Integer boxInt = Boxing.boxInt(intRef.element);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            return boxInt;
                        }
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return Boxing.boxInt(-1);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$indexOf$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$indexOf$12.L$1 = obj2;
                channelsKt__Channels_commonKt$indexOf$12.L$2 = intRef2;
                channelsKt__Channels_commonKt$indexOf$12.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$indexOf$12.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$indexOf$12.L$5 = th3;
                channelsKt__Channels_commonKt$indexOf$12.L$6 = receiveChannel5;
                channelsKt__Channels_commonKt$indexOf$12.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$indexOf$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOf$12);
                if (hasNext == obj3) {
                    receiveChannel4 = receiveChannel6;
                    obj4 = hasNext;
                    intRef = intRef2;
                    th2 = th3;
                    obj = obj3;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj4).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return Boxing.boxInt(-1);
                }
                return obj3;
            }
        }
        channelsKt__Channels_commonKt$indexOf$1 = new ChannelsKt__Channels_commonKt$indexOf$1(continuation);
        Object obj4 = channelsKt__Channels_commonKt$indexOf$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$indexOf$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$indexOf$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$indexOf$12.L$1 = obj2;
            channelsKt__Channels_commonKt$indexOf$12.L$2 = intRef2;
            channelsKt__Channels_commonKt$indexOf$12.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$indexOf$12.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$indexOf$12.L$5 = th3;
            channelsKt__Channels_commonKt$indexOf$12.L$6 = receiveChannel5;
            channelsKt__Channels_commonKt$indexOf$12.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$indexOf$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOf$12);
            if (hasNext == obj3) {
            }
            return obj3;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object indexOfFirst(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOfFirst$1 channelsKt__Channels_commonKt$indexOfFirst$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.IntRef intRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$indexOfFirst$1 channelsKt__Channels_commonKt$indexOfFirst$12;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.IntRef intRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$indexOfFirst$1) {
            channelsKt__Channels_commonKt$indexOfFirst$1 = (ChannelsKt__Channels_commonKt$indexOfFirst$1) continuation;
            if ((channelsKt__Channels_commonKt$indexOfFirst$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$indexOfFirst$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$indexOfFirst$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$indexOfFirst$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        intRef2 = intRef3;
                        obj2 = coroutine_suspended;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$indexOfFirst$12 = channelsKt__Channels_commonKt$indexOfFirst$1;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$indexOfFirst$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$indexOfFirst$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$3;
                    Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOfFirst$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$indexOfFirst$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        intRef = intRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$indexOfFirst$12 = channelsKt__Channels_commonKt$indexOfFirst$1;
                        receiveChannel2 = receiveChannel8;
                        th2 = th5;
                        function12 = function13;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            if (!function12.invoke((Object) channelIterator.next()).booleanValue()) {
                                intRef.element++;
                                receiveChannel6 = receiveChannel4;
                                obj2 = obj;
                                th3 = th2;
                                intRef2 = intRef;
                                channelIterator2 = channelIterator;
                            }
                            Integer boxInt = Boxing.boxInt(intRef.element);
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(2);
                            return boxInt;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxInt(-1);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$indexOfFirst$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$1 = function12;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$2 = intRef2;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$5 = th3;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$6 = receiveChannel5;
                channelsKt__Channels_commonKt$indexOfFirst$12.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$indexOfFirst$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOfFirst$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    intRef = intRef2;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxInt(-1);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$indexOfFirst$1 = new ChannelsKt__Channels_commonKt$indexOfFirst$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$indexOfFirst$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$indexOfFirst$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$indexOfFirst$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$1 = function12;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$2 = intRef2;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$5 = th3;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$6 = receiveChannel5;
            channelsKt__Channels_commonKt$indexOfFirst$12.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$indexOfFirst$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOfFirst$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4 A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object indexOfLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOfLast$1 channelsKt__Channels_commonKt$indexOfLast$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$indexOfLast$1 channelsKt__Channels_commonKt$indexOfLast$12;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.IntRef intRef3;
        Ref.IntRef intRef4;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$indexOfLast$1) {
            channelsKt__Channels_commonKt$indexOfLast$1 = (ChannelsKt__Channels_commonKt$indexOfLast$1) continuation;
            if ((channelsKt__Channels_commonKt$indexOfLast$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$indexOfLast$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$indexOfLast$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$indexOfLast$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    intRef5.element = -1;
                    Ref.IntRef intRef6 = new Ref.IntRef();
                    intRef6.element = 0;
                    try {
                        intRef4 = intRef5;
                        intRef3 = intRef6;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        function12 = function1;
                        channelsKt__Channels_commonKt$indexOfLast$12 = channelsKt__Channels_commonKt$indexOfLast$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel2 = receiveChannel3;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$indexOfLast$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$indexOfLast$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$4;
                    Ref.IntRef intRef7 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOfLast$1.L$3;
                    Ref.IntRef intRef8 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOfLast$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$indexOfLast$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        intRef = intRef8;
                        th2 = th5;
                        function12 = function13;
                        intRef2 = intRef7;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$indexOfLast$12 = channelsKt__Channels_commonKt$indexOfLast$1;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            if (function12.invoke((Object) channelIterator.next()).booleanValue()) {
                                intRef.element = intRef2.element;
                            }
                            intRef2.element++;
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            intRef3 = intRef2;
                            intRef4 = intRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxInt(intRef.element);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$indexOfLast$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$indexOfLast$12.L$1 = function12;
                channelsKt__Channels_commonKt$indexOfLast$12.L$2 = intRef4;
                channelsKt__Channels_commonKt$indexOfLast$12.L$3 = intRef3;
                channelsKt__Channels_commonKt$indexOfLast$12.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$indexOfLast$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$indexOfLast$12.L$6 = th3;
                channelsKt__Channels_commonKt$indexOfLast$12.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$indexOfLast$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$indexOfLast$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOfLast$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    intRef = intRef4;
                    intRef2 = intRef3;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxInt(intRef.element);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$indexOfLast$1 = new ChannelsKt__Channels_commonKt$indexOfLast$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$indexOfLast$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$indexOfLast$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$indexOfLast$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$indexOfLast$12.L$1 = function12;
            channelsKt__Channels_commonKt$indexOfLast$12.L$2 = intRef4;
            channelsKt__Channels_commonKt$indexOfLast$12.L$3 = intRef3;
            channelsKt__Channels_commonKt$indexOfLast$12.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$indexOfLast$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$indexOfLast$12.L$6 = th3;
            channelsKt__Channels_commonKt$indexOfLast$12.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$indexOfLast$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$indexOfLast$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$indexOfLast$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$last$1 channelsKt__Channels_commonKt$last$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator channelIterator;
        Object next;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel7;
        if (continuation instanceof ChannelsKt__Channels_commonKt$last$1) {
            channelsKt__Channels_commonKt$last$1 = (ChannelsKt__Channels_commonKt$last$1) continuation;
            if ((channelsKt__Channels_commonKt$last$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$last$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$last$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$last$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$2 = th4;
                        channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$4 = it2;
                        channelsKt__Channels_commonKt$last$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$last$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        channelIterator2 = it2;
                        receiveChannel7 = receiveChannel6;
                        th3 = th4;
                        obj = hasNext2;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                    receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                    th3 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } else if (i == 2) {
                    Object obj2 = channelsKt__Channels_commonKt$last$1.L$5;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator.next();
                            receiveChannel5 = receiveChannel8;
                            channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel5;
                            channelsKt__Channels_commonKt$last$1.L$2 = th2;
                            channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$last$1.L$4 = channelIterator;
                            channelsKt__Channels_commonKt$last$1.L$5 = next;
                            channelsKt__Channels_commonKt$last$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$last$1);
                            if (hasNext == coroutine_suspended) {
                                receiveChannel8 = receiveChannel5;
                                obj2 = next;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        ChannelsKt.cancelConsumed(receiveChannel8, th2);
                        return obj2;
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel2 = receiveChannel8;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator2.next();
                    receiveChannel3 = receiveChannel6;
                    channelIterator = channelIterator2;
                    receiveChannel5 = receiveChannel2;
                    th2 = th3;
                    receiveChannel4 = receiveChannel7;
                    channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel3;
                    channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel5;
                    channelsKt__Channels_commonKt$last$1.L$2 = th2;
                    channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel4;
                    channelsKt__Channels_commonKt$last$1.L$4 = channelIterator;
                    channelsKt__Channels_commonKt$last$1.L$5 = next;
                    channelsKt__Channels_commonKt$last$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$last$1);
                    if (hasNext == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
        }
        channelsKt__Channels_commonKt$last$1 = new ChannelsKt__Channels_commonKt$last$1(continuation);
        obj = channelsKt__Channels_commonKt$last$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$last$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4 A[Catch:{ all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3 A[Catch:{ all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$last$3 channelsKt__Channels_commonKt$last$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.ObjectRef objectRef;
        Ref.BooleanRef booleanRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$last$3 channelsKt__Channels_commonKt$last$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$last$3) {
            channelsKt__Channels_commonKt$last$3 = (ChannelsKt__Channels_commonKt$last$3) continuation;
            if ((channelsKt__Channels_commonKt$last$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$last$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$last$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$last$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = null;
                    Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                    booleanRef3.element = false;
                    try {
                        objectRef2 = objectRef3;
                        th3 = null;
                        booleanRef2 = booleanRef3;
                        receiveChannel6 = receiveChannel;
                        function12 = function1;
                        channelsKt__Channels_commonKt$last$32 = channelsKt__Channels_commonKt$last$3;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel2 = receiveChannel3;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$last$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$last$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$4;
                    Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) channelsKt__Channels_commonKt$last$3.L$3;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) channelsKt__Channels_commonKt$last$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$last$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        objectRef = objectRef4;
                        th2 = th5;
                        function12 = function13;
                        booleanRef = booleanRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$last$32 = channelsKt__Channels_commonKt$last$3;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            ?? r15 = (Object) channelIterator.next();
                            if (function12.invoke(r15).booleanValue()) {
                                objectRef.element = r15;
                                booleanRef.element = true;
                            }
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            booleanRef2 = booleanRef;
                            objectRef2 = objectRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        if (!booleanRef.element) {
                            return objectRef.element;
                        }
                        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$last$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$last$32.L$1 = function12;
                channelsKt__Channels_commonKt$last$32.L$2 = objectRef2;
                channelsKt__Channels_commonKt$last$32.L$3 = booleanRef2;
                channelsKt__Channels_commonKt$last$32.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$last$32.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$last$32.L$6 = th3;
                channelsKt__Channels_commonKt$last$32.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$last$32.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$last$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$last$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    objectRef = objectRef2;
                    booleanRef = booleanRef2;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    if (!booleanRef.element) {
                    }
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$last$3 = new ChannelsKt__Channels_commonKt$last$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$last$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$last$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$last$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$last$32.L$1 = function12;
            channelsKt__Channels_commonKt$last$32.L$2 = objectRef2;
            channelsKt__Channels_commonKt$last$32.L$3 = booleanRef2;
            channelsKt__Channels_commonKt$last$32.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$last$32.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$last$32.L$6 = th3;
            channelsKt__Channels_commonKt$last$32.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$last$32.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$last$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$last$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3 A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2 A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object lastIndexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$lastIndexOf$1 channelsKt__Channels_commonKt$lastIndexOf$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$lastIndexOf$1 channelsKt__Channels_commonKt$lastIndexOf$12;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj3;
        Throwable th3;
        Ref.IntRef intRef3;
        Ref.IntRef intRef4;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$lastIndexOf$1) {
            channelsKt__Channels_commonKt$lastIndexOf$1 = (ChannelsKt__Channels_commonKt$lastIndexOf$1) continuation;
            if ((channelsKt__Channels_commonKt$lastIndexOf$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$lastIndexOf$1.label -= Integer.MIN_VALUE;
                Object obj4 = channelsKt__Channels_commonKt$lastIndexOf$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$lastIndexOf$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    Ref.IntRef intRef5 = new Ref.IntRef();
                    intRef5.element = -1;
                    Ref.IntRef intRef6 = new Ref.IntRef();
                    intRef6.element = 0;
                    try {
                        intRef4 = intRef5;
                        intRef3 = intRef6;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        obj2 = e;
                        channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel2 = receiveChannel3;
                        channelIterator2 = receiveChannel.iterator();
                        obj3 = coroutine_suspended;
                        receiveChannel5 = receiveChannel2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$lastIndexOf$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$lastIndexOf$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$4;
                    Ref.IntRef intRef7 = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$3;
                    Ref.IntRef intRef8 = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$2;
                    Object obj5 = channelsKt__Channels_commonKt$lastIndexOf$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj4);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        intRef = intRef8;
                        th2 = th5;
                        obj2 = obj5;
                        intRef2 = intRef7;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj4).booleanValue()) {
                            if (Intrinsics.areEqual(obj2, channelIterator.next())) {
                                intRef.element = intRef2.element;
                            }
                            intRef2.element++;
                            receiveChannel6 = receiveChannel4;
                            obj3 = obj;
                            th3 = th2;
                            intRef3 = intRef2;
                            intRef4 = intRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return Boxing.boxInt(intRef.element);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj2;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef4;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef3;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th3;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$lastIndexOf$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
                if (hasNext == obj3) {
                    receiveChannel4 = receiveChannel6;
                    obj4 = hasNext;
                    intRef = intRef4;
                    intRef2 = intRef3;
                    th2 = th3;
                    obj = obj3;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj4).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return Boxing.boxInt(intRef.element);
                }
                return obj3;
            }
        }
        channelsKt__Channels_commonKt$lastIndexOf$1 = new ChannelsKt__Channels_commonKt$lastIndexOf$1(continuation);
        Object obj4 = channelsKt__Channels_commonKt$lastIndexOf$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$lastIndexOf$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj2;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef4;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef3;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th3;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$lastIndexOf$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
            if (hasNext == obj3) {
            }
            return obj3;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$lastOrNull$1 channelsKt__Channels_commonKt$lastOrNull$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator channelIterator;
        Object next;
        Object hasNext;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel5;
        if (continuation instanceof ChannelsKt__Channels_commonKt$lastOrNull$1) {
            channelsKt__Channels_commonKt$lastOrNull$1 = (ChannelsKt__Channels_commonKt$lastOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$lastOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$lastOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$lastOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$lastOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th3;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$lastOrNull$1.L$4 = it2;
                        channelsKt__Channels_commonKt$lastOrNull$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        channelIterator2 = it2;
                        receiveChannel5 = receiveChannel3;
                        th2 = th3;
                        obj = hasNext2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    Object obj2 = channelsKt__Channels_commonKt$lastOrNull$1.L$5;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator.next();
                            channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel2;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th2;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$5 = next;
                            channelsKt__Channels_commonKt$lastOrNull$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                            if (hasNext == coroutine_suspended) {
                                receiveChannel2 = receiveChannel2;
                                obj2 = next;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return obj2;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return null;
                }
                next = channelIterator2.next();
                receiveChannel4 = receiveChannel5;
                channelIterator = channelIterator2;
                channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th2;
                channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel4;
                channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$lastOrNull$1.L$5 = next;
                channelsKt__Channels_commonKt$lastOrNull$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                if (hasNext == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__Channels_commonKt$lastOrNull$1 = new ChannelsKt__Channels_commonKt$lastOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$lastOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$lastOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095 A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3 A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$lastOrNull$3 channelsKt__Channels_commonKt$lastOrNull$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.ObjectRef objectRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$lastOrNull$3 channelsKt__Channels_commonKt$lastOrNull$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.ObjectRef objectRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$lastOrNull$3) {
            channelsKt__Channels_commonKt$lastOrNull$3 = (ChannelsKt__Channels_commonKt$lastOrNull$3) continuation;
            if ((channelsKt__Channels_commonKt$lastOrNull$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$lastOrNull$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$lastOrNull$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$lastOrNull$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = null;
                    try {
                        objectRef2 = objectRef3;
                        obj2 = coroutine_suspended;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$lastOrNull$32 = channelsKt__Channels_commonKt$lastOrNull$3;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$3.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$3;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) channelsKt__Channels_commonKt$lastOrNull$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$lastOrNull$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        objectRef = objectRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$lastOrNull$32 = channelsKt__Channels_commonKt$lastOrNull$3;
                        receiveChannel2 = receiveChannel8;
                        th2 = th5;
                        function12 = function13;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            ?? r15 = (Object) channelIterator.next();
                            if (function12.invoke(r15).booleanValue()) {
                                objectRef.element = r15;
                            }
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            objectRef2 = objectRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return objectRef.element;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$lastOrNull$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$lastOrNull$32.L$1 = function12;
                channelsKt__Channels_commonKt$lastOrNull$32.L$2 = objectRef2;
                channelsKt__Channels_commonKt$lastOrNull$32.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$lastOrNull$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$lastOrNull$32.L$5 = th3;
                channelsKt__Channels_commonKt$lastOrNull$32.L$6 = receiveChannel5;
                channelsKt__Channels_commonKt$lastOrNull$32.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$lastOrNull$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastOrNull$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    objectRef = objectRef2;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return objectRef.element;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$lastOrNull$3 = new ChannelsKt__Channels_commonKt$lastOrNull$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$lastOrNull$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$lastOrNull$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$lastOrNull$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$lastOrNull$32.L$1 = function12;
            channelsKt__Channels_commonKt$lastOrNull$32.L$2 = objectRef2;
            channelsKt__Channels_commonKt$lastOrNull$32.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$lastOrNull$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$lastOrNull$32.L$5 = th3;
            channelsKt__Channels_commonKt$lastOrNull$32.L$6 = receiveChannel5;
            channelsKt__Channels_commonKt$lastOrNull$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$lastOrNull$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastOrNull$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$single$1 channelsKt__Channels_commonKt$single$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        if (continuation instanceof ChannelsKt__Channels_commonKt$single$1) {
            channelsKt__Channels_commonKt$single$1 = (ChannelsKt__Channels_commonKt$single$1) continuation;
            if ((channelsKt__Channels_commonKt$single$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$single$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$single$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$single$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$2 = th4;
                        channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$4 = it2;
                        channelsKt__Channels_commonKt$single$1.label = 1;
                        Object hasNext = it2.hasNext(channelsKt__Channels_commonKt$single$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel4 = receiveChannel2;
                        channelIterator = it2;
                        receiveChannel5 = receiveChannel4;
                        th3 = th4;
                        obj = hasNext;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                    th3 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } else if (i == 2) {
                    obj2 = channelsKt__Channels_commonKt$single$1.L$5;
                    ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel3, th2);
                            return obj2;
                        }
                        throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel2 = receiveChannel3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel4;
                    channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel2;
                    channelsKt__Channels_commonKt$single$1.L$2 = th3;
                    channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel5;
                    channelsKt__Channels_commonKt$single$1.L$4 = channelIterator;
                    channelsKt__Channels_commonKt$single$1.L$5 = next;
                    channelsKt__Channels_commonKt$single$1.label = 2;
                    Object hasNext2 = channelIterator.hasNext(channelsKt__Channels_commonKt$single$1);
                    if (hasNext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th2 = th3;
                    receiveChannel3 = receiveChannel2;
                    obj = hasNext2;
                    obj2 = next;
                    if (((Boolean) obj).booleanValue()) {
                    }
                } else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
            }
        }
        channelsKt__Channels_commonKt$single$1 = new ChannelsKt__Channels_commonKt$single$1(continuation);
        obj = channelsKt__Channels_commonKt$single$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$single$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4 A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3 A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$single$3 channelsKt__Channels_commonKt$single$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.ObjectRef objectRef;
        Ref.BooleanRef booleanRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$single$3 channelsKt__Channels_commonKt$single$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$single$3) {
            channelsKt__Channels_commonKt$single$3 = (ChannelsKt__Channels_commonKt$single$3) continuation;
            if ((channelsKt__Channels_commonKt$single$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$single$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$single$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$single$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = null;
                    Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                    booleanRef3.element = false;
                    try {
                        objectRef2 = objectRef3;
                        th3 = null;
                        booleanRef2 = booleanRef3;
                        receiveChannel6 = receiveChannel;
                        function12 = function1;
                        channelsKt__Channels_commonKt$single$32 = channelsKt__Channels_commonKt$single$3;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel2 = receiveChannel3;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$single$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$single$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$4;
                    Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) channelsKt__Channels_commonKt$single$3.L$3;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) channelsKt__Channels_commonKt$single$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$single$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        objectRef = objectRef4;
                        th2 = th5;
                        function12 = function13;
                        booleanRef = booleanRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$single$32 = channelsKt__Channels_commonKt$single$3;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            ?? r15 = (Object) channelIterator.next();
                            if (function12.invoke(r15).booleanValue()) {
                                if (!booleanRef.element) {
                                    objectRef.element = r15;
                                    booleanRef.element = true;
                                }
                                throw new IllegalArgumentException("ReceiveChannel contains more than one matching element.");
                            }
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            booleanRef2 = booleanRef;
                            objectRef2 = objectRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        if (!booleanRef.element) {
                            return objectRef.element;
                        }
                        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$single$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$single$32.L$1 = function12;
                channelsKt__Channels_commonKt$single$32.L$2 = objectRef2;
                channelsKt__Channels_commonKt$single$32.L$3 = booleanRef2;
                channelsKt__Channels_commonKt$single$32.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$single$32.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$single$32.L$6 = th3;
                channelsKt__Channels_commonKt$single$32.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$single$32.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$single$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$single$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    objectRef = objectRef2;
                    booleanRef = booleanRef2;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    if (!booleanRef.element) {
                    }
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$single$3 = new ChannelsKt__Channels_commonKt$single$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$single$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$single$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$single$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$single$32.L$1 = function12;
            channelsKt__Channels_commonKt$single$32.L$2 = objectRef2;
            channelsKt__Channels_commonKt$single$32.L$3 = booleanRef2;
            channelsKt__Channels_commonKt$single$32.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$single$32.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$single$32.L$6 = th3;
            channelsKt__Channels_commonKt$single$32.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$single$32.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$single$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$single$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$singleOrNull$1 channelsKt__Channels_commonKt$singleOrNull$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        if (continuation instanceof ChannelsKt__Channels_commonKt$singleOrNull$1) {
            channelsKt__Channels_commonKt$singleOrNull$1 = (ChannelsKt__Channels_commonKt$singleOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$singleOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$singleOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$singleOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$singleOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th4;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$4 = it2;
                        channelsKt__Channels_commonKt$singleOrNull$1.label = 1;
                        Object hasNext = it2.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel4 = receiveChannel2;
                        channelIterator = it2;
                        receiveChannel5 = receiveChannel4;
                        th3 = th4;
                        obj = hasNext;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                    th3 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } else if (i == 2) {
                    obj2 = channelsKt__Channels_commonKt$singleOrNull$1.L$5;
                    ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel3, th2);
                            return null;
                        }
                        ChannelsKt.cancelConsumed(receiveChannel3, th2);
                        return obj2;
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel2 = receiveChannel3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    return null;
                }
                Object next = channelIterator.next();
                channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th3;
                channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$singleOrNull$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$singleOrNull$1.L$5 = next;
                channelsKt__Channels_commonKt$singleOrNull$1.label = 2;
                Object hasNext2 = channelIterator.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                if (hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                th2 = th3;
                receiveChannel3 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__Channels_commonKt$singleOrNull$1 = new ChannelsKt__Channels_commonKt$singleOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$singleOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$singleOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad A[Catch:{ all -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b8 A[Catch:{ all -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ec A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$singleOrNull$3 channelsKt__Channels_commonKt$singleOrNull$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.ObjectRef objectRef;
        Ref.BooleanRef booleanRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$singleOrNull$3 channelsKt__Channels_commonKt$singleOrNull$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$singleOrNull$3) {
            channelsKt__Channels_commonKt$singleOrNull$3 = (ChannelsKt__Channels_commonKt$singleOrNull$3) continuation;
            if ((channelsKt__Channels_commonKt$singleOrNull$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$singleOrNull$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$singleOrNull$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$singleOrNull$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = null;
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    booleanRef2.element = false;
                    try {
                        objectRef = objectRef2;
                        obj = coroutine_suspended;
                        booleanRef = booleanRef2;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel4 = receiveChannel2;
                        function12 = function1;
                        channelsKt__Channels_commonKt$singleOrNull$32 = channelsKt__Channels_commonKt$singleOrNull$3;
                        receiveChannel5 = receiveChannel4;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$4;
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) channelsKt__Channels_commonKt$singleOrNull$3.L$3;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$singleOrNull$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$singleOrNull$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$singleOrNull$32 = channelsKt__Channels_commonKt$singleOrNull$3;
                        receiveChannel5 = receiveChannel9;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        function12 = function13;
                        objectRef = objectRef3;
                        booleanRef = booleanRef3;
                        th3 = th5;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        if (!((Boolean) obj2).booleanValue()) {
                            ?? r0 = (Object) channelIterator.next();
                            if (function12.invoke(r0).booleanValue()) {
                                if (!booleanRef.element) {
                                    objectRef.element = r0;
                                    booleanRef.element = true;
                                }
                                InlineMarker.finallyStart(2);
                                ChannelsKt.cancelConsumed(receiveChannel2, th3);
                                InlineMarker.finallyEnd(2);
                                return null;
                            }
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        if (booleanRef.element) {
                            return null;
                        }
                        return objectRef.element;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$singleOrNull$32.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$singleOrNull$32.L$1 = function12;
                channelsKt__Channels_commonKt$singleOrNull$32.L$2 = objectRef;
                channelsKt__Channels_commonKt$singleOrNull$32.L$3 = booleanRef;
                channelsKt__Channels_commonKt$singleOrNull$32.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$singleOrNull$32.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$singleOrNull$32.L$6 = th3;
                channelsKt__Channels_commonKt$singleOrNull$32.L$7 = receiveChannel4;
                channelsKt__Channels_commonKt$singleOrNull$32.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$singleOrNull$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$singleOrNull$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    if (booleanRef.element) {
                    }
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$singleOrNull$3 = new ChannelsKt__Channels_commonKt$singleOrNull$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$singleOrNull$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$singleOrNull$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$singleOrNull$32.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$singleOrNull$32.L$1 = function12;
            channelsKt__Channels_commonKt$singleOrNull$32.L$2 = objectRef;
            channelsKt__Channels_commonKt$singleOrNull$32.L$3 = booleanRef;
            channelsKt__Channels_commonKt$singleOrNull$32.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$singleOrNull$32.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$singleOrNull$32.L$6 = th3;
            channelsKt__Channels_commonKt$singleOrNull$32.L$7 = receiveChannel4;
            channelsKt__Channels_commonKt$singleOrNull$32.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$singleOrNull$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$singleOrNull$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.drop(receiveChannel, i, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> drop(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$drop$1(receiveChannel, i, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> dropWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$dropWhile$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$filter$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E> ReceiveChannel<E> filterIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$filterIndexed$1(receiveChannel, function3, null), 6, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac A[Catch:{ all -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b9 A[Catch:{ all -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, C extends Collection<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterIndexedTo$1 channelsKt__Channels_commonKt$filterIndexedTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.IntRef intRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$filterIndexedTo$1 channelsKt__Channels_commonKt$filterIndexedTo$12;
        Function2<? super Integer, ? super E, Boolean> function22;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterIndexedTo$1) {
            channelsKt__Channels_commonKt$filterIndexedTo$1 = (ChannelsKt__Channels_commonKt$filterIndexedTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterIndexedTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterIndexedTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterIndexedTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterIndexedTo$1.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        collection = c;
                        function22 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$filterIndexedTo$12 = channelsKt__Channels_commonKt$filterIndexedTo$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterIndexedTo$1.L$9;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$8;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$filterIndexedTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$5;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$filterIndexedTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$3;
                    Function2<? super Integer, ? super E, Boolean> function23 = (Function2) channelsKt__Channels_commonKt$filterIndexedTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterIndexedTo$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$filterIndexedTo$12 = channelsKt__Channels_commonKt$filterIndexedTo$1;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        receiveChannel2 = receiveChannel8;
                        function22 = function23;
                        th3 = th5;
                        collection = collection2;
                        intRef = intRef3;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i3 = intRef.element;
                            intRef.element = i3 + 1;
                            IndexedValue indexedValue = new IndexedValue(i3, next);
                            int component1 = indexedValue.component1();
                            Object obj3 = (Object) indexedValue.component2();
                            if (function22.invoke(Boxing.boxInt(component1), obj3).booleanValue()) {
                                collection.add(obj3);
                            }
                            receiveChannel7 = receiveChannel3;
                            i2 = 1;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$1 = collection;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$2 = function22;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$4 = intRef;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$7 = th3;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$8 = receiveChannel4;
                channelsKt__Channels_commonKt$filterIndexedTo$12.L$9 = channelIterator2;
                channelsKt__Channels_commonKt$filterIndexedTo$12.label = i2;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$filterIndexedTo$1 = new ChannelsKt__Channels_commonKt$filterIndexedTo$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$filterIndexedTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterIndexedTo$1.label;
        int i2 = 1;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$1 = collection;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$2 = function22;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$4 = intRef;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$7 = th3;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$8 = receiveChannel4;
            channelsKt__Channels_commonKt$filterIndexedTo$12.L$9 = channelIterator2;
            channelsKt__Channels_commonKt$filterIndexedTo$12.label = i2;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r13v11, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e3 A[Catch:{ all -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fe A[Catch:{ all -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterIndexedTo$3 channelsKt__Channels_commonKt$filterIndexedTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th3;
        Object obj;
        ChannelsKt__Channels_commonKt$filterIndexedTo$3 channelsKt__Channels_commonKt$filterIndexedTo$32;
        Ref.IntRef intRef;
        Function2<? super Integer, ? super E, Boolean> function22;
        C c2;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        C c3;
        Function2<? super Integer, ? super E, Boolean> function23;
        ReceiveChannel<? extends E> receiveChannel8;
        Ref.IntRef intRef2;
        ReceiveChannel<? extends E> receiveChannel9;
        ReceiveChannel<? extends E> receiveChannel10;
        Throwable th4;
        ChannelIterator<? extends E> channelIterator2;
        ChannelIterator<? extends E> channelIterator3;
        SendChannel sendChannel;
        ChannelIterator<? extends E> channelIterator4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterIndexedTo$3) {
            channelsKt__Channels_commonKt$filterIndexedTo$3 = (ChannelsKt__Channels_commonKt$filterIndexedTo$3) continuation;
            if ((channelsKt__Channels_commonKt$filterIndexedTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterIndexedTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterIndexedTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterIndexedTo$3.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        c2 = c;
                        function22 = function2;
                        intRef = intRef3;
                        channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator4 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$8;
                    th4 = (Throwable) channelsKt__Channels_commonKt$filterIndexedTo$3.L$7;
                    receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$5;
                    intRef2 = (Ref.IntRef) channelsKt__Channels_commonKt$filterIndexedTo$3.L$4;
                    receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$3;
                    function23 = (Function2) channelsKt__Channels_commonKt$filterIndexedTo$3.L$2;
                    SendChannel sendChannel2 = (SendChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterIndexedTo$3.L$9;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$6;
                    sendChannel = sendChannel2;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object next = channelIterator3.next();
                        int i3 = intRef2.element;
                        intRef2.element = i3 + 1;
                        IndexedValue indexedValue = new IndexedValue(i3, next);
                        int component1 = indexedValue.component1();
                        Object obj3 = (Object) indexedValue.component2();
                        if (function23.invoke(Boxing.boxInt(component1), obj3).booleanValue()) {
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$2 = function23;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$3 = receiveChannel8;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$4 = intRef2;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$5 = receiveChannel9;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$6 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$7 = th4;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$8 = receiveChannel4;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$9 = channelIterator3;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$10 = next;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$11 = next;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$12 = indexedValue;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.I$0 = component1;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.L$13 = obj3;
                            channelsKt__Channels_commonKt$filterIndexedTo$3.label = 2;
                            if (sendChannel.send(obj3, channelsKt__Channels_commonKt$filterIndexedTo$3) != coroutine_suspended) {
                                coroutine_suspended = coroutine_suspended;
                                receiveChannel10 = receiveChannel2;
                                channelIterator2 = channelIterator3;
                                c3 = sendChannel;
                                channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                                receiveChannel6 = receiveChannel8;
                                obj = coroutine_suspended;
                                receiveChannel5 = receiveChannel9;
                                intRef = intRef2;
                                channelIterator = channelIterator2;
                                receiveChannel2 = receiveChannel10;
                                function22 = function23;
                                th3 = th4;
                                c2 = c3;
                                receiveChannel7 = receiveChannel3;
                                i2 = 1;
                                channelIterator4 = channelIterator;
                            }
                            return coroutine_suspended;
                        }
                        receiveChannel5 = receiveChannel9;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                        receiveChannel6 = receiveChannel8;
                        obj = coroutine_suspended;
                        th3 = th4;
                        c2 = sendChannel;
                        function22 = function23;
                        channelIterator = channelIterator3;
                        receiveChannel7 = receiveChannel3;
                        i2 = 1;
                        channelIterator4 = channelIterator;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th4);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$filterIndexedTo$3.L$13;
                    int i4 = channelsKt__Channels_commonKt$filterIndexedTo$3.I$0;
                    IndexedValue indexedValue2 = (IndexedValue) channelsKt__Channels_commonKt$filterIndexedTo$3.L$12;
                    Object obj5 = channelsKt__Channels_commonKt$filterIndexedTo$3.L$11;
                    Object obj6 = channelsKt__Channels_commonKt$filterIndexedTo$3.L$10;
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$filterIndexedTo$3.L$9;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$8;
                    th4 = (Throwable) channelsKt__Channels_commonKt$filterIndexedTo$3.L$7;
                    receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$6;
                    receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$5;
                    intRef2 = (Ref.IntRef) channelsKt__Channels_commonKt$filterIndexedTo$3.L$4;
                    receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$3;
                    function23 = (Function2) channelsKt__Channels_commonKt$filterIndexedTo$3.L$2;
                    ?? r13 = (SendChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        c3 = r13;
                        channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                        receiveChannel6 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        intRef = intRef2;
                        channelIterator = channelIterator2;
                        receiveChannel2 = receiveChannel10;
                        function22 = function23;
                        th3 = th4;
                        c2 = c3;
                        receiveChannel7 = receiveChannel3;
                        i2 = 1;
                        channelIterator4 = channelIterator;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel10;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$1 = c2;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$2 = function22;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$4 = intRef;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$7 = th3;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$8 = receiveChannel4;
                channelsKt__Channels_commonKt$filterIndexedTo$32.L$9 = channelIterator4;
                channelsKt__Channels_commonKt$filterIndexedTo$32.label = i2;
                hasNext = channelIterator4.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    receiveChannel8 = receiveChannel6;
                    channelsKt__Channels_commonKt$filterIndexedTo$3 = channelsKt__Channels_commonKt$filterIndexedTo$32;
                    intRef2 = intRef;
                    receiveChannel9 = receiveChannel5;
                    coroutine_suspended = obj;
                    sendChannel = c2;
                    th4 = th3;
                    function23 = function22;
                    channelIterator3 = channelIterator4;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th4);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$filterIndexedTo$3 = new ChannelsKt__Channels_commonKt$filterIndexedTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$filterIndexedTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterIndexedTo$3.label;
        int i2 = 1;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$1 = c2;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$2 = function22;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$4 = intRef;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$7 = th3;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$8 = receiveChannel4;
            channelsKt__Channels_commonKt$filterIndexedTo$32.L$9 = channelIterator4;
            channelsKt__Channels_commonKt$filterIndexedTo$32.label = i2;
            hasNext = channelIterator4.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt.filter(receiveChannel, coroutineContext, new ChannelsKt__Channels_commonKt$filterNot$1(function2, null));
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> receiveChannel2 = filter$default(receiveChannel, null, new ChannelsKt__Channels_commonKt$filterNotNull$1(null), 1, null);
        if (receiveChannel2 != null) {
            return receiveChannel2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, C extends Collection<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotNullTo$1 channelsKt__Channels_commonKt$filterNotNullTo$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$filterNotNullTo$1 channelsKt__Channels_commonKt$filterNotNullTo$12;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotNullTo$1) {
            channelsKt__Channels_commonKt$filterNotNullTo$1 = (ChannelsKt__Channels_commonKt$filterNotNullTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotNullTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$filterNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterNotNullTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        collection = c;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterNotNullTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        collection = collection2;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            Object next = channelIterator.next();
                            if (next != null) {
                                collection.add(next);
                            }
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return collection;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$1 = collection;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$4 = th3;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$filterNotNullTo$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$filterNotNullTo$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return collection;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$filterNotNullTo$1 = new ChannelsKt__Channels_commonKt$filterNotNullTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$filterNotNullTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotNullTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$1 = collection;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$4 = th3;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$filterNotNullTo$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$filterNotNullTo$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$32;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$33;
        Object obj2;
        ChannelIterator channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotNullTo$3) {
            channelsKt__Channels_commonKt$filterNotNullTo$3 = (ChannelsKt__Channels_commonKt$filterNotNullTo$3) continuation;
            if ((channelsKt__Channels_commonKt$filterNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotNullTo$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$filterNotNullTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterNotNullTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Throwable th3 = null;
                    try {
                        channelsKt__Channels_commonKt$filterNotNullTo$33 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                        obj2 = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel5 = receiveChannel;
                        sendChannel = c;
                        th2 = th3;
                        receiveChannel3 = receiveChannel5;
                        receiveChannel6 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    th2 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                    SendChannel sendChannel2 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                    ResultKt.throwOnFailure(obj3);
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                    receiveChannel = receiveChannel7;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                    channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                    obj = coroutine_suspended;
                    sendChannel = sendChannel2;
                    if (((Boolean) obj3).booleanValue()) {
                        Object next = channelIterator.next();
                        if (next != null) {
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th2;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel5;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$7 = next;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$8 = next;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.label = 2;
                            if (sendChannel.send(next, channelsKt__Channels_commonKt$filterNotNullTo$32) == obj) {
                                return obj;
                            }
                        }
                        receiveChannel6 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterNotNullTo$33 = channelsKt__Channels_commonKt$filterNotNullTo$32;
                        obj2 = obj;
                        channelIterator2 = channelIterator;
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel4, th2);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$filterNotNullTo$3.L$8;
                    Object obj5 = channelsKt__Channels_commonKt$filterNotNullTo$3.L$7;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                    th2 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                    SendChannel sendChannel3 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterNotNullTo$33 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                        receiveChannel5 = receiveChannel8;
                        receiveChannel3 = receiveChannel9;
                        obj2 = coroutine_suspended;
                        sendChannel = sendChannel3;
                        channelIterator2 = channelIterator3;
                        receiveChannel = receiveChannel10;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$1 = sendChannel;
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$2 = receiveChannel3;
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$4 = th2;
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$filterNotNullTo$33.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$filterNotNullTo$33.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$33);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    channelIterator = channelIterator2;
                    obj = obj2;
                    channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$33;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel4, th2);
                    return sendChannel;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$filterNotNullTo$3 = new ChannelsKt__Channels_commonKt$filterNotNullTo$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$filterNotNullTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotNullTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$1 = sendChannel;
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$2 = receiveChannel3;
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$4 = th2;
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$filterNotNullTo$33.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$filterNotNullTo$33.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$33);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            receiveChannel2 = receiveChannel6;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, C extends Collection<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$12;
        Function1<? super E, Boolean> function12;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, Boolean> function13;
        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotTo$1) {
            channelsKt__Channels_commonKt$filterNotTo$1 = (ChannelsKt__Channels_commonKt$filterNotTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterNotTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$filterNotTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterNotTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$filterNotTo$13 = channelsKt__Channels_commonKt$filterNotTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$filterNotTo$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$filterNotTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterNotTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        collection = collection2;
                        channelsKt__Channels_commonKt$filterNotTo$12 = channelsKt__Channels_commonKt$filterNotTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            if (!function12.invoke(obj4).booleanValue()) {
                                collection.add(obj4);
                            }
                            receiveChannel2 = receiveChannel5;
                            function13 = function12;
                            channelsKt__Channels_commonKt$filterNotTo$13 = channelsKt__Channels_commonKt$filterNotTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel5, th2);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterNotTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$filterNotTo$13.L$1 = collection;
                channelsKt__Channels_commonKt$filterNotTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$filterNotTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$filterNotTo$13.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$filterNotTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$filterNotTo$13.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$filterNotTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$filterNotTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$13);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel2;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$filterNotTo$12 = channelsKt__Channels_commonKt$filterNotTo$13;
                    function12 = function13;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel5, th2);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$filterNotTo$1 = new ChannelsKt__Channels_commonKt$filterNotTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$filterNotTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterNotTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$filterNotTo$13.L$1 = collection;
            channelsKt__Channels_commonKt$filterNotTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$filterNotTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$filterNotTo$13.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$filterNotTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$filterNotTo$13.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$filterNotTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$filterNotTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v8. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r11v7, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2 A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, C extends SendChannel<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotTo$3 channelsKt__Channels_commonKt$filterNotTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$filterNotTo$3 channelsKt__Channels_commonKt$filterNotTo$32;
        Throwable th3;
        Function1<? super E, Boolean> function12;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator channelIterator2;
        C c2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotTo$3) {
            channelsKt__Channels_commonKt$filterNotTo$3 = (ChannelsKt__Channels_commonKt$filterNotTo$3) continuation;
            if ((channelsKt__Channels_commonKt$filterNotTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterNotTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterNotTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        c2 = c;
                        function12 = function1;
                        th3 = null;
                        channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                        obj = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$3;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$filterNotTo$3.L$2;
                    SendChannel sendChannel2 = (SendChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                    receiveChannel5 = receiveChannel7;
                    obj = coroutine_suspended;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$4;
                    th3 = (Throwable) channelsKt__Channels_commonKt$filterNotTo$3.L$5;
                    function12 = function13;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotTo$3.L$7;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$6;
                    sendChannel = sendChannel2;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object obj3 = (Object) channelIterator.next();
                        if (!function12.invoke(obj3).booleanValue()) {
                            channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function12;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel5;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th3;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$8 = obj3;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$9 = obj3;
                            channelsKt__Channels_commonKt$filterNotTo$32.label = 2;
                            if (sendChannel.send(obj3, channelsKt__Channels_commonKt$filterNotTo$32) == obj) {
                                return obj;
                            }
                        }
                        receiveChannel6 = receiveChannel3;
                        c2 = sendChannel;
                        channelIterator2 = channelIterator;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$filterNotTo$3.L$9;
                    Object obj5 = channelsKt__Channels_commonKt$filterNotTo$3.L$8;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterNotTo$3.L$7;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$filterNotTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$3;
                    Function1<? super E, Boolean> function14 = (Function1) channelsKt__Channels_commonKt$filterNotTo$3.L$2;
                    ?? r11 = (SendChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel6 = receiveChannel11;
                        channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                        receiveChannel5 = receiveChannel10;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel9;
                        th3 = th5;
                        function12 = function14;
                        channelIterator2 = channelIterator3;
                        receiveChannel4 = receiveChannel8;
                        c2 = r11;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$filterNotTo$32.L$1 = c2;
                channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function12;
                channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th3;
                channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel4;
                channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$filterNotTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    sendChannel = c2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$filterNotTo$3 = new ChannelsKt__Channels_commonKt$filterNotTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$filterNotTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$filterNotTo$32.L$1 = c2;
            channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function12;
            channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel5;
            channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th3;
            channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel4;
            channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$filterNotTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, C extends Collection<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$12;
        Function1<? super E, Boolean> function12;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, Boolean> function13;
        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterTo$1) {
            channelsKt__Channels_commonKt$filterTo$1 = (ChannelsKt__Channels_commonKt$filterTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$filterTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$filterTo$13 = channelsKt__Channels_commonKt$filterTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$filterTo$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$filterTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        collection = collection2;
                        channelsKt__Channels_commonKt$filterTo$12 = channelsKt__Channels_commonKt$filterTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            if (function12.invoke(obj4).booleanValue()) {
                                collection.add(obj4);
                            }
                            receiveChannel2 = receiveChannel5;
                            function13 = function12;
                            channelsKt__Channels_commonKt$filterTo$13 = channelsKt__Channels_commonKt$filterTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel5, th2);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$filterTo$13.L$1 = collection;
                channelsKt__Channels_commonKt$filterTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$filterTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$filterTo$13.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$filterTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$filterTo$13.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$filterTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$filterTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$13);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel2;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$filterTo$12 = channelsKt__Channels_commonKt$filterTo$13;
                    function12 = function13;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel5, th2);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$filterTo$1 = new ChannelsKt__Channels_commonKt$filterTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$filterTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$filterTo$13.L$1 = collection;
            channelsKt__Channels_commonKt$filterTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$filterTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$filterTo$13.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$filterTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$filterTo$13.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$filterTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$filterTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v8. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r11v7, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2 A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, C extends SendChannel<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterTo$3 channelsKt__Channels_commonKt$filterTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$filterTo$3 channelsKt__Channels_commonKt$filterTo$32;
        Throwable th3;
        Function1<? super E, Boolean> function12;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator channelIterator2;
        C c2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterTo$3) {
            channelsKt__Channels_commonKt$filterTo$3 = (ChannelsKt__Channels_commonKt$filterTo$3) continuation;
            if ((channelsKt__Channels_commonKt$filterTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        c2 = c;
                        function12 = function1;
                        th3 = null;
                        channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                        obj = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$3;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$filterTo$3.L$2;
                    SendChannel sendChannel2 = (SendChannel) channelsKt__Channels_commonKt$filterTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                    receiveChannel5 = receiveChannel7;
                    obj = coroutine_suspended;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$4;
                    th3 = (Throwable) channelsKt__Channels_commonKt$filterTo$3.L$5;
                    function12 = function13;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterTo$3.L$7;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$6;
                    sendChannel = sendChannel2;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object obj3 = (Object) channelIterator.next();
                        if (function12.invoke(obj3).booleanValue()) {
                            channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterTo$32.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$filterTo$32.L$2 = function12;
                            channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel5;
                            channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterTo$32.L$5 = th3;
                            channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator;
                            channelsKt__Channels_commonKt$filterTo$32.L$8 = obj3;
                            channelsKt__Channels_commonKt$filterTo$32.L$9 = obj3;
                            channelsKt__Channels_commonKt$filterTo$32.label = 2;
                            if (sendChannel.send(obj3, channelsKt__Channels_commonKt$filterTo$32) == obj) {
                                return obj;
                            }
                        }
                        receiveChannel6 = receiveChannel3;
                        c2 = sendChannel;
                        channelIterator2 = channelIterator;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$filterTo$3.L$9;
                    Object obj5 = channelsKt__Channels_commonKt$filterTo$3.L$8;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterTo$3.L$7;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$filterTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$3;
                    Function1<? super E, Boolean> function14 = (Function1) channelsKt__Channels_commonKt$filterTo$3.L$2;
                    ?? r11 = (SendChannel) channelsKt__Channels_commonKt$filterTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel6 = receiveChannel11;
                        channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                        receiveChannel5 = receiveChannel10;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel9;
                        th3 = th5;
                        function12 = function14;
                        channelIterator2 = channelIterator3;
                        receiveChannel4 = receiveChannel8;
                        c2 = r11;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$filterTo$32.L$1 = c2;
                channelsKt__Channels_commonKt$filterTo$32.L$2 = function12;
                channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$filterTo$32.L$5 = th3;
                channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel4;
                channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$filterTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    sendChannel = c2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$filterTo$3 = new ChannelsKt__Channels_commonKt$filterTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$filterTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$filterTo$32.L$1 = c2;
            channelsKt__Channels_commonKt$filterTo$32.L$2 = function12;
            channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel5;
            channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$filterTo$32.L$5 = th3;
            channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel4;
            channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$filterTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.take(receiveChannel, i, coroutineContext);
    }

    public static final <E> ReceiveChannel<E> take(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$take$1(receiveChannel, i, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> takeWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$takeWhile$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K, V> Object associate(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super Map<K, ? extends V>> continuation) {
        ChannelsKt__Channels_commonKt$associate$1 channelsKt__Channels_commonKt$associate$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Map map;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object obj;
        ChannelsKt__Channels_commonKt$associate$1 channelsKt__Channels_commonKt$associate$12;
        Function1<? super E, ? extends Pair<? extends K, ? extends V>> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th3;
        LinkedHashMap linkedHashMap;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associate$1) {
            channelsKt__Channels_commonKt$associate$1 = (ChannelsKt__Channels_commonKt$associate$1) continuation;
            if ((channelsKt__Channels_commonKt$associate$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associate$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$associate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associate$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    try {
                        linkedHashMap = new LinkedHashMap();
                        channelsKt__Channels_commonKt$associate$12 = channelsKt__Channels_commonKt$associate$1;
                        obj = coroutine_suspended;
                        th3 = th4;
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$associate$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$7;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$associate$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$4;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associate$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$2;
                    Function1<? super E, ? extends Pair<? extends K, ? extends V>> function13 = (Function1) channelsKt__Channels_commonKt$associate$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel5 = receiveChannel8;
                        receiveChannel3 = receiveChannel11;
                        map = map2;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel9;
                        function12 = function13;
                        th2 = th6;
                        channelsKt__Channels_commonKt$associate$12 = channelsKt__Channels_commonKt$associate$1;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            Pair pair = (Pair) function12.invoke((Object) channelIterator.next());
                            map.put(pair.getFirst(), pair.getSecond());
                            receiveChannel7 = receiveChannel4;
                            th3 = th2;
                            linkedHashMap = map;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$associate$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$associate$12.L$1 = function12;
                channelsKt__Channels_commonKt$associate$12.L$2 = receiveChannel7;
                channelsKt__Channels_commonKt$associate$12.L$3 = linkedHashMap;
                channelsKt__Channels_commonKt$associate$12.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$associate$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$associate$12.L$6 = th3;
                channelsKt__Channels_commonKt$associate$12.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$associate$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$associate$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associate$12);
                if (hasNext == obj) {
                    receiveChannel4 = receiveChannel7;
                    obj2 = hasNext;
                    map = linkedHashMap;
                    th2 = th3;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$associate$1 = new ChannelsKt__Channels_commonKt$associate$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$associate$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associate$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$associate$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$associate$12.L$1 = function12;
            channelsKt__Channels_commonKt$associate$12.L$2 = receiveChannel7;
            channelsKt__Channels_commonKt$associate$12.L$3 = linkedHashMap;
            channelsKt__Channels_commonKt$associate$12.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$associate$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$associate$12.L$6 = th3;
            channelsKt__Channels_commonKt$associate$12.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$associate$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$associate$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associate$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th = th9;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        throw r8;
     */
    private static final Object associate$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Pair pair = (Pair) function1.invoke(it2.next());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends E>> continuation) {
        ChannelsKt__Channels_commonKt$associateBy$1 channelsKt__Channels_commonKt$associateBy$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Map map;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object obj;
        ChannelsKt__Channels_commonKt$associateBy$1 channelsKt__Channels_commonKt$associateBy$12;
        Function1<? super E, ? extends K> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Throwable th3;
        LinkedHashMap linkedHashMap;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateBy$1) {
            channelsKt__Channels_commonKt$associateBy$1 = (ChannelsKt__Channels_commonKt$associateBy$1) continuation;
            if ((channelsKt__Channels_commonKt$associateBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateBy$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$associateBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    try {
                        linkedHashMap = new LinkedHashMap();
                        channelsKt__Channels_commonKt$associateBy$12 = channelsKt__Channels_commonKt$associateBy$1;
                        obj = coroutine_suspended;
                        th3 = th4;
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$associateBy$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$7;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$associateBy$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$4;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateBy$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$2;
                    Function1<? super E, ? extends K> function13 = (Function1) channelsKt__Channels_commonKt$associateBy$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel5 = receiveChannel8;
                        receiveChannel3 = receiveChannel11;
                        map = map2;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel9;
                        function12 = function13;
                        th2 = th6;
                        channelsKt__Channels_commonKt$associateBy$12 = channelsKt__Channels_commonKt$associateBy$1;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object obj3 = (Object) channelIterator.next();
                            map.put(function12.invoke(obj3), obj3);
                            receiveChannel7 = receiveChannel4;
                            th3 = th2;
                            linkedHashMap = map;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$associateBy$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$associateBy$12.L$1 = function12;
                channelsKt__Channels_commonKt$associateBy$12.L$2 = receiveChannel7;
                channelsKt__Channels_commonKt$associateBy$12.L$3 = linkedHashMap;
                channelsKt__Channels_commonKt$associateBy$12.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$associateBy$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$associateBy$12.L$6 = th3;
                channelsKt__Channels_commonKt$associateBy$12.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$associateBy$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$associateBy$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateBy$12);
                if (hasNext == obj) {
                    receiveChannel4 = receiveChannel7;
                    obj2 = hasNext;
                    map = linkedHashMap;
                    th2 = th3;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$associateBy$1 = new ChannelsKt__Channels_commonKt$associateBy$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$associateBy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateBy$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$associateBy$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$associateBy$12.L$1 = function12;
            channelsKt__Channels_commonKt$associateBy$12.L$2 = receiveChannel7;
            channelsKt__Channels_commonKt$associateBy$12.L$3 = linkedHashMap;
            channelsKt__Channels_commonKt$associateBy$12.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$associateBy$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$associateBy$12.L$6 = th3;
            channelsKt__Channels_commonKt$associateBy$12.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$associateBy$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$associateBy$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateBy$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th = th9;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        throw r8;
     */
    private static final Object associateBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                linkedHashMap.put(function1.invoke(next), next);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K, V> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends V>> continuation) {
        ChannelsKt__Channels_commonKt$associateBy$2 channelsKt__Channels_commonKt$associateBy$2;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Map map;
        Object obj;
        Function1<? super E, ? extends V> function13;
        ChannelsKt__Channels_commonKt$associateBy$2 channelsKt__Channels_commonKt$associateBy$22;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Function1<? super E, ? extends K> function14;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Function1<? super E, ? extends V> function15;
        Object obj2;
        LinkedHashMap linkedHashMap;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateBy$2) {
            channelsKt__Channels_commonKt$associateBy$2 = (ChannelsKt__Channels_commonKt$associateBy$2) continuation;
            if ((channelsKt__Channels_commonKt$associateBy$2.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateBy$2.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$associateBy$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateBy$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Throwable th3 = null;
                    try {
                        linkedHashMap = new LinkedHashMap();
                        channelsKt__Channels_commonKt$associateBy$22 = channelsKt__Channels_commonKt$associateBy$2;
                        obj2 = coroutine_suspended;
                        th2 = th3;
                        receiveChannel7 = receiveChannel;
                        receiveChannel2 = receiveChannel7;
                        receiveChannel6 = receiveChannel2;
                        function14 = function1;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function15 = function12;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$associateBy$2.L$9;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$8;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$associateBy$2.L$7;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$6;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$5;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateBy$2.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$3;
                    function13 = (Function1) channelsKt__Channels_commonKt$associateBy$2.L$2;
                    Function1<? super E, ? extends K> function16 = (Function1) channelsKt__Channels_commonKt$associateBy$2.L$1;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel8;
                        receiveChannel4 = receiveChannel11;
                        map = map2;
                        th2 = th5;
                        receiveChannel3 = receiveChannel10;
                        channelsKt__Channels_commonKt$associateBy$22 = channelsKt__Channels_commonKt$associateBy$2;
                        receiveChannel2 = receiveChannel9;
                        function14 = function16;
                        obj = coroutine_suspended;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            map.put(function14.invoke(obj4), function13.invoke(obj4));
                            receiveChannel7 = receiveChannel5;
                            function15 = function13;
                            obj2 = obj;
                            linkedHashMap = map;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$associateBy$22.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$associateBy$22.L$1 = function14;
                channelsKt__Channels_commonKt$associateBy$22.L$2 = function15;
                channelsKt__Channels_commonKt$associateBy$22.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$associateBy$22.L$4 = linkedHashMap;
                channelsKt__Channels_commonKt$associateBy$22.L$5 = receiveChannel7;
                channelsKt__Channels_commonKt$associateBy$22.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$associateBy$22.L$7 = th2;
                channelsKt__Channels_commonKt$associateBy$22.L$8 = receiveChannel6;
                channelsKt__Channels_commonKt$associateBy$22.L$9 = channelIterator2;
                channelsKt__Channels_commonKt$associateBy$22.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateBy$22);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel7;
                    obj3 = hasNext;
                    map = linkedHashMap;
                    obj = obj2;
                    function13 = function15;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$associateBy$2 = new ChannelsKt__Channels_commonKt$associateBy$2(continuation);
        Object obj3 = channelsKt__Channels_commonKt$associateBy$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateBy$2.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$associateBy$22.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$associateBy$22.L$1 = function14;
            channelsKt__Channels_commonKt$associateBy$22.L$2 = function15;
            channelsKt__Channels_commonKt$associateBy$22.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$associateBy$22.L$4 = linkedHashMap;
            channelsKt__Channels_commonKt$associateBy$22.L$5 = receiveChannel7;
            channelsKt__Channels_commonKt$associateBy$22.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$associateBy$22.L$7 = th2;
            channelsKt__Channels_commonKt$associateBy$22.L$8 = receiveChannel6;
            channelsKt__Channels_commonKt$associateBy$22.L$9 = channelIterator2;
            channelsKt__Channels_commonKt$associateBy$22.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateBy$22);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        throw r8;
     */
    private static final Object associateBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Function1 function12, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                linkedHashMap.put(function1.invoke(next), function12.invoke(next));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$12;
        Function1<? super E, ? extends K> function12;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Map map;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, ? extends K> function13;
        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateByTo$1) {
            channelsKt__Channels_commonKt$associateByTo$1 = (ChannelsKt__Channels_commonKt$associateByTo$1) continuation;
            if ((channelsKt__Channels_commonKt$associateByTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateByTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$associateByTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateByTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$associateByTo$13 = channelsKt__Channels_commonKt$associateByTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        map = m;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$associateByTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$associateByTo$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$associateByTo$1.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateByTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        map = map2;
                        channelsKt__Channels_commonKt$associateByTo$12 = channelsKt__Channels_commonKt$associateByTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            map.put(function12.invoke(obj4), obj4);
                            receiveChannel2 = receiveChannel5;
                            function13 = function12;
                            channelsKt__Channels_commonKt$associateByTo$13 = channelsKt__Channels_commonKt$associateByTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel5, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$associateByTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$associateByTo$13.L$1 = map;
                channelsKt__Channels_commonKt$associateByTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$associateByTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$associateByTo$13.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$associateByTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$associateByTo$13.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$associateByTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$associateByTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateByTo$13);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel2;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$associateByTo$12 = channelsKt__Channels_commonKt$associateByTo$13;
                    function12 = function13;
                    map = map;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel5, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$associateByTo$1 = new ChannelsKt__Channels_commonKt$associateByTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$associateByTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateByTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$associateByTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$associateByTo$13.L$1 = map;
            channelsKt__Channels_commonKt$associateByTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$associateByTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$associateByTo$13.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$associateByTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$associateByTo$13.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$associateByTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$associateByTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateByTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$associateByTo$3 channelsKt__Channels_commonKt$associateByTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        Map map;
        ChannelsKt__Channels_commonKt$associateByTo$3 channelsKt__Channels_commonKt$associateByTo$32;
        Function1<? super E, ? extends V> function13;
        Throwable th2;
        Function1<? super E, ? extends K> function14;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        M m2;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateByTo$3) {
            channelsKt__Channels_commonKt$associateByTo$3 = (ChannelsKt__Channels_commonKt$associateByTo$3) continuation;
            if ((channelsKt__Channels_commonKt$associateByTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateByTo$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$associateByTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateByTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Throwable th3 = null;
                    try {
                        function13 = function12;
                        channelsKt__Channels_commonKt$associateByTo$32 = channelsKt__Channels_commonKt$associateByTo$3;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        m2 = m;
                        function14 = function1;
                        receiveChannel4 = receiveChannel2;
                        receiveChannel3 = receiveChannel4;
                        channelIterator2 = receiveChannel.iterator();
                        th2 = th3;
                        receiveChannel6 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$associateByTo$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$associateByTo$3.L$6;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$4;
                    function13 = (Function1) channelsKt__Channels_commonKt$associateByTo$3.L$3;
                    Function1<? super E, ? extends K> function15 = (Function1) channelsKt__Channels_commonKt$associateByTo$3.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateByTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        function14 = function15;
                        channelsKt__Channels_commonKt$associateByTo$32 = channelsKt__Channels_commonKt$associateByTo$3;
                        th2 = th5;
                        receiveChannel3 = receiveChannel8;
                        map = map2;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            map.put(function14.invoke(obj4), function13.invoke(obj4));
                            receiveChannel6 = receiveChannel5;
                            m2 = map;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$associateByTo$32.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$associateByTo$32.L$1 = m2;
                channelsKt__Channels_commonKt$associateByTo$32.L$2 = function14;
                channelsKt__Channels_commonKt$associateByTo$32.L$3 = function13;
                channelsKt__Channels_commonKt$associateByTo$32.L$4 = receiveChannel3;
                channelsKt__Channels_commonKt$associateByTo$32.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$associateByTo$32.L$6 = th2;
                channelsKt__Channels_commonKt$associateByTo$32.L$7 = receiveChannel6;
                channelsKt__Channels_commonKt$associateByTo$32.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$associateByTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateByTo$32);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel6;
                    obj3 = hasNext;
                    obj = obj2;
                    map = m2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$associateByTo$3 = new ChannelsKt__Channels_commonKt$associateByTo$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$associateByTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateByTo$3.label;
        if (i != 0) {
        }
        channelsKt__Channels_commonKt$associateByTo$32.L$0 = receiveChannel4;
        channelsKt__Channels_commonKt$associateByTo$32.L$1 = m2;
        channelsKt__Channels_commonKt$associateByTo$32.L$2 = function14;
        channelsKt__Channels_commonKt$associateByTo$32.L$3 = function13;
        channelsKt__Channels_commonKt$associateByTo$32.L$4 = receiveChannel3;
        channelsKt__Channels_commonKt$associateByTo$32.L$5 = receiveChannel2;
        channelsKt__Channels_commonKt$associateByTo$32.L$6 = th2;
        channelsKt__Channels_commonKt$associateByTo$32.L$7 = receiveChannel6;
        channelsKt__Channels_commonKt$associateByTo$32.L$8 = channelIterator2;
        channelsKt__Channels_commonKt$associateByTo$32.label = 1;
        hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateByTo$32);
        if (hasNext == obj2) {
        }
        return obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$12;
        Function1<? super E, ? extends Pair<? extends K, ? extends V>> function12;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Map map;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, ? extends Pair<? extends K, ? extends V>> function13;
        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateTo$1) {
            channelsKt__Channels_commonKt$associateTo$1 = (ChannelsKt__Channels_commonKt$associateTo$1) continuation;
            if ((channelsKt__Channels_commonKt$associateTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$associateTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$associateTo$13 = channelsKt__Channels_commonKt$associateTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        map = m;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$associateTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$associateTo$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$associateTo$1.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        map = map2;
                        channelsKt__Channels_commonKt$associateTo$12 = channelsKt__Channels_commonKt$associateTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Pair pair = (Pair) function12.invoke((Object) channelIterator.next());
                            map.put(pair.getFirst(), pair.getSecond());
                            receiveChannel2 = receiveChannel5;
                            function13 = function12;
                            channelsKt__Channels_commonKt$associateTo$13 = channelsKt__Channels_commonKt$associateTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel5, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$associateTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$associateTo$13.L$1 = map;
                channelsKt__Channels_commonKt$associateTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$associateTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$associateTo$13.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$associateTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$associateTo$13.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$associateTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$associateTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateTo$13);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel2;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$associateTo$12 = channelsKt__Channels_commonKt$associateTo$13;
                    function12 = function13;
                    map = map;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel5, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$associateTo$1 = new ChannelsKt__Channels_commonKt$associateTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$associateTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$associateTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$associateTo$13.L$1 = map;
            channelsKt__Channels_commonKt$associateTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$associateTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$associateTo$13.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$associateTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$associateTo$13.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$associateTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$associateTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$associateTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        ChannelIterator channelIterator2;
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$12;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        Object obj2;
        C c2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toChannel$1) {
            channelsKt__Channels_commonKt$toChannel$1 = (ChannelsKt__Channels_commonKt$toChannel$1) continuation;
            if ((channelsKt__Channels_commonKt$toChannel$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toChannel$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$toChannel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$toChannel$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Throwable th3 = null;
                    try {
                        channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                        obj2 = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        c2 = c;
                        th2 = th3;
                        receiveChannel7 = receiveChannel6;
                        receiveChannel2 = receiveChannel7;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                    th2 = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    obj = obj3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                    receiveChannel5 = receiveChannel8;
                    sendChannel = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = channelIterator.next();
                        channelsKt__Channels_commonKt$toChannel$1.L$0 = receiveChannel5;
                        channelsKt__Channels_commonKt$toChannel$1.L$1 = sendChannel;
                        channelsKt__Channels_commonKt$toChannel$1.L$2 = receiveChannel4;
                        channelsKt__Channels_commonKt$toChannel$1.L$3 = receiveChannel2;
                        channelsKt__Channels_commonKt$toChannel$1.L$4 = th2;
                        channelsKt__Channels_commonKt$toChannel$1.L$5 = receiveChannel3;
                        channelsKt__Channels_commonKt$toChannel$1.L$6 = channelIterator;
                        channelsKt__Channels_commonKt$toChannel$1.L$7 = next;
                        channelsKt__Channels_commonKt$toChannel$1.L$8 = next;
                        channelsKt__Channels_commonKt$toChannel$1.label = 2;
                        if (sendChannel.send(next, channelsKt__Channels_commonKt$toChannel$1) != coroutine_suspended) {
                            channelIterator2 = channelIterator;
                            receiveChannel = receiveChannel5;
                            channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                            receiveChannel6 = receiveChannel3;
                            receiveChannel7 = receiveChannel4;
                            obj2 = coroutine_suspended;
                            c2 = sendChannel;
                        }
                        return coroutine_suspended;
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$toChannel$1.L$8;
                    Object obj5 = channelsKt__Channels_commonKt$toChannel$1.L$7;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                    th2 = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                    ?? r7 = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel2 = receiveChannel10;
                        channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                        receiveChannel6 = receiveChannel9;
                        receiveChannel7 = receiveChannel11;
                        obj2 = coroutine_suspended;
                        c2 = r7;
                        channelIterator2 = channelIterator3;
                        receiveChannel = receiveChannel12;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel10;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$toChannel$12.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$toChannel$12.L$1 = c2;
                channelsKt__Channels_commonKt$toChannel$12.L$2 = receiveChannel7;
                channelsKt__Channels_commonKt$toChannel$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$toChannel$12.L$4 = th2;
                channelsKt__Channels_commonKt$toChannel$12.L$5 = receiveChannel6;
                channelsKt__Channels_commonKt$toChannel$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$toChannel$12.label = 1;
                obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$toChannel$12);
                if (obj == obj2) {
                    receiveChannel5 = receiveChannel;
                    channelIterator = channelIterator2;
                    sendChannel = c2;
                    coroutine_suspended = obj2;
                    receiveChannel4 = receiveChannel7;
                    receiveChannel3 = receiveChannel6;
                    channelsKt__Channels_commonKt$toChannel$1 = channelsKt__Channels_commonKt$toChannel$12;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return sendChannel;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$toChannel$1 = new ChannelsKt__Channels_commonKt$toChannel$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$toChannel$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toChannel$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$toChannel$12.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$toChannel$12.L$1 = c2;
            channelsKt__Channels_commonKt$toChannel$12.L$2 = receiveChannel7;
            channelsKt__Channels_commonKt$toChannel$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$toChannel$12.L$4 = th2;
            channelsKt__Channels_commonKt$toChannel$12.L$5 = receiveChannel6;
            channelsKt__Channels_commonKt$toChannel$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toChannel$12.label = 1;
            obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$toChannel$12);
            if (obj == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$toCollection$1 channelsKt__Channels_commonKt$toCollection$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$toCollection$1 channelsKt__Channels_commonKt$toCollection$12;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toCollection$1) {
            channelsKt__Channels_commonKt$toCollection$1 = (ChannelsKt__Channels_commonKt$toCollection$1) continuation;
            if ((channelsKt__Channels_commonKt$toCollection$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toCollection$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$toCollection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$toCollection$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        collection = c;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$toCollection$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$toCollection$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$toCollection$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        collection = collection2;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            collection.add(channelIterator.next());
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return collection;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$toCollection$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$toCollection$12.L$1 = collection;
                channelsKt__Channels_commonKt$toCollection$12.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$toCollection$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$toCollection$12.L$4 = th3;
                channelsKt__Channels_commonKt$toCollection$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$toCollection$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$toCollection$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toCollection$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return collection;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$toCollection$1 = new ChannelsKt__Channels_commonKt$toCollection$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$toCollection$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toCollection$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$toCollection$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$toCollection$12.L$1 = collection;
            channelsKt__Channels_commonKt$toCollection$12.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$toCollection$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$toCollection$12.L$4 = th3;
            channelsKt__Channels_commonKt$toCollection$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$toCollection$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toCollection$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toCollection$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt.toMutableList(receiveChannel, continuation);
    }

    public static final <K, V> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt.toMap(receiveChannel, new LinkedHashMap(), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$toMap$2 channelsKt__Channels_commonKt$toMap$2;
        int i;
        Throwable th;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel3;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel4;
        ChannelsKt__Channels_commonKt$toMap$2 channelsKt__Channels_commonKt$toMap$22;
        Map map;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel5;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$toMap$2) {
            channelsKt__Channels_commonKt$toMap$2 = (ChannelsKt__Channels_commonKt$toMap$2) continuation;
            if ((channelsKt__Channels_commonKt$toMap$2.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$toMap$2.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$toMap$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$toMap$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        map = m;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$toMap$2.L$6;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$toMap$2.L$4;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$toMap$2.L$1;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        map = map2;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Pair pair = (Pair) channelIterator.next();
                            map.put(pair.getFirst(), pair.getSecond());
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return map;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$toMap$22.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$toMap$22.L$1 = map;
                channelsKt__Channels_commonKt$toMap$22.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$toMap$22.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$toMap$22.L$4 = th3;
                channelsKt__Channels_commonKt$toMap$22.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$toMap$22.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$toMap$22.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toMap$22);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    map = map;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return map;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$toMap$2 = new ChannelsKt__Channels_commonKt$toMap$2(continuation);
        Object obj3 = channelsKt__Channels_commonKt$toMap$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toMap$2.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$toMap$22.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$toMap$22.L$1 = map;
            channelsKt__Channels_commonKt$toMap$22.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$toMap$22.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$toMap$22.L$4 = th3;
            channelsKt__Channels_commonKt$toMap$22.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$toMap$22.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toMap$22.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$toMap$22);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    public static final <E> Object toMutableList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new ArrayList(), continuation);
    }

    public static final <E> Object toSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<? extends E>> continuation) {
        return ChannelsKt.toMutableSet(receiveChannel, continuation);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> flatMap(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$flatMap$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3 A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, K> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends List<? extends E>>> continuation) {
        ChannelsKt__Channels_commonKt$groupBy$1 channelsKt__Channels_commonKt$groupBy$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Map map;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$groupBy$1 channelsKt__Channels_commonKt$groupBy$12;
        Function1<? super E, ? extends K> function12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupBy$1) {
            channelsKt__Channels_commonKt$groupBy$1 = (ChannelsKt__Channels_commonKt$groupBy$1) continuation;
            if ((channelsKt__Channels_commonKt$groupBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupBy$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$groupBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    try {
                        function12 = function1;
                        map = new LinkedHashMap();
                        channelsKt__Channels_commonKt$groupBy$12 = channelsKt__Channels_commonKt$groupBy$1;
                        obj = coroutine_suspended;
                        th3 = th4;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$groupBy$1.L$8;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$7;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$groupBy$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$4;
                    Map map2 = (Map) channelsKt__Channels_commonKt$groupBy$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$2;
                    Function1<? super E, ? extends K> function13 = (Function1) channelsKt__Channels_commonKt$groupBy$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$groupBy$12 = channelsKt__Channels_commonKt$groupBy$1;
                        receiveChannel6 = receiveChannel10;
                        th3 = th6;
                        function12 = function13;
                        map = map2;
                        channelIterator = channelIterator3;
                        receiveChannel2 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        if (((Boolean) obj2).booleanValue()) {
                            Object obj3 = (Object) channelIterator.next();
                            Object invoke = function12.invoke(obj3);
                            Object obj4 = map.get(invoke);
                            if (obj4 == null) {
                                obj4 = new ArrayList();
                                map.put(invoke, obj4);
                            }
                            ((List) obj4).add(obj3);
                            receiveChannel7 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$groupBy$12.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$groupBy$12.L$1 = function12;
                channelsKt__Channels_commonKt$groupBy$12.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$groupBy$12.L$3 = map;
                channelsKt__Channels_commonKt$groupBy$12.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$groupBy$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$groupBy$12.L$6 = th3;
                channelsKt__Channels_commonKt$groupBy$12.L$7 = receiveChannel4;
                channelsKt__Channels_commonKt$groupBy$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$groupBy$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupBy$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    map = map;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$groupBy$1 = new ChannelsKt__Channels_commonKt$groupBy$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$groupBy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupBy$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$groupBy$12.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$groupBy$12.L$1 = function12;
            channelsKt__Channels_commonKt$groupBy$12.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$groupBy$12.L$3 = map;
            channelsKt__Channels_commonKt$groupBy$12.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$groupBy$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$groupBy$12.L$6 = th3;
            channelsKt__Channels_commonKt$groupBy$12.L$7 = receiveChannel4;
            channelsKt__Channels_commonKt$groupBy$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$groupBy$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupBy$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th2 = th9;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        throw r9;
     */
    private static final Object groupBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                Object invoke = function1.invoke(next);
                Object obj = linkedHashMap.get(invoke);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(invoke, obj);
                }
                ((List) obj).add(next);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b8 A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, K, V> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        ChannelsKt__Channels_commonKt$groupBy$2 channelsKt__Channels_commonKt$groupBy$2;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Map map;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$groupBy$2 channelsKt__Channels_commonKt$groupBy$22;
        Function1<? super E, ? extends V> function13;
        Function1<? super E, ? extends K> function14;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupBy$2) {
            channelsKt__Channels_commonKt$groupBy$2 = (ChannelsKt__Channels_commonKt$groupBy$2) continuation;
            if ((channelsKt__Channels_commonKt$groupBy$2.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupBy$2.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$groupBy$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupBy$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    try {
                        function14 = function1;
                        function13 = function12;
                        map = new LinkedHashMap();
                        channelsKt__Channels_commonKt$groupBy$22 = channelsKt__Channels_commonKt$groupBy$2;
                        obj = coroutine_suspended;
                        th3 = th4;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$groupBy$2.L$9;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$8;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$groupBy$2.L$7;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$5;
                    Map map2 = (Map) channelsKt__Channels_commonKt$groupBy$2.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$3;
                    Function1<? super E, ? extends V> function15 = (Function1) channelsKt__Channels_commonKt$groupBy$2.L$2;
                    Function1<? super E, ? extends K> function16 = (Function1) channelsKt__Channels_commonKt$groupBy$2.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$groupBy$22 = channelsKt__Channels_commonKt$groupBy$2;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        receiveChannel2 = receiveChannel8;
                        function13 = function15;
                        th3 = th6;
                        function14 = function16;
                        map = map2;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        if (((Boolean) obj2).booleanValue()) {
                            Object obj3 = (Object) channelIterator.next();
                            Object invoke = function14.invoke(obj3);
                            Object obj4 = map.get(invoke);
                            if (obj4 == null) {
                                obj4 = new ArrayList();
                                map.put(invoke, obj4);
                            }
                            ((List) obj4).add(function13.invoke(obj3));
                            receiveChannel7 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$groupBy$22.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$groupBy$22.L$1 = function14;
                channelsKt__Channels_commonKt$groupBy$22.L$2 = function13;
                channelsKt__Channels_commonKt$groupBy$22.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$groupBy$22.L$4 = map;
                channelsKt__Channels_commonKt$groupBy$22.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$groupBy$22.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$groupBy$22.L$7 = th3;
                channelsKt__Channels_commonKt$groupBy$22.L$8 = receiveChannel4;
                channelsKt__Channels_commonKt$groupBy$22.L$9 = channelIterator2;
                channelsKt__Channels_commonKt$groupBy$22.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupBy$22);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    map = map;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$groupBy$2 = new ChannelsKt__Channels_commonKt$groupBy$2(continuation);
        Object obj2 = channelsKt__Channels_commonKt$groupBy$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupBy$2.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$groupBy$22.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$groupBy$22.L$1 = function14;
            channelsKt__Channels_commonKt$groupBy$22.L$2 = function13;
            channelsKt__Channels_commonKt$groupBy$22.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$groupBy$22.L$4 = map;
            channelsKt__Channels_commonKt$groupBy$22.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$groupBy$22.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$groupBy$22.L$7 = th3;
            channelsKt__Channels_commonKt$groupBy$22.L$8 = receiveChannel4;
            channelsKt__Channels_commonKt$groupBy$22.L$9 = channelIterator2;
            channelsKt__Channels_commonKt$groupBy$22.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupBy$22);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th2 = th9;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        throw r9;
     */
    private static final Object groupBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Function1 function12, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                Object invoke = function1.invoke(next);
                Object obj = linkedHashMap.get(invoke);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(invoke, obj);
                }
                ((List) obj).add(function12.invoke(next));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return linkedHashMap;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$12;
        Function1<? super E, ? extends K> function12;
        Throwable th2;
        Map map;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, ? extends K> function13;
        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupByTo$1) {
            channelsKt__Channels_commonKt$groupByTo$1 = (ChannelsKt__Channels_commonKt$groupByTo$1) continuation;
            if ((channelsKt__Channels_commonKt$groupByTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupByTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$groupByTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupByTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$groupByTo$13 = channelsKt__Channels_commonKt$groupByTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        map = m;
                        receiveChannel4 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$groupByTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$groupByTo$1.L$5;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$groupByTo$1.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$groupByTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        map = map2;
                        channelsKt__Channels_commonKt$groupByTo$12 = channelsKt__Channels_commonKt$groupByTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            Object invoke = function12.invoke(obj4);
                            Object obj5 = map.get(invoke);
                            if (obj5 == null) {
                                obj5 = new ArrayList();
                                map.put(invoke, obj5);
                            }
                            ((List) obj5).add(obj4);
                            receiveChannel6 = receiveChannel2;
                            function13 = function12;
                            channelsKt__Channels_commonKt$groupByTo$13 = channelsKt__Channels_commonKt$groupByTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$groupByTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$groupByTo$13.L$1 = map;
                channelsKt__Channels_commonKt$groupByTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$groupByTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$groupByTo$13.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$groupByTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$groupByTo$13.L$6 = receiveChannel5;
                channelsKt__Channels_commonKt$groupByTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$groupByTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupByTo$13);
                if (hasNext == obj2) {
                    receiveChannel2 = receiveChannel6;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$groupByTo$12 = channelsKt__Channels_commonKt$groupByTo$13;
                    function12 = function13;
                    map = map;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$groupByTo$1 = new ChannelsKt__Channels_commonKt$groupByTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$groupByTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupByTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$groupByTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$groupByTo$13.L$1 = map;
            channelsKt__Channels_commonKt$groupByTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$groupByTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$groupByTo$13.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$groupByTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$groupByTo$13.L$6 = receiveChannel5;
            channelsKt__Channels_commonKt$groupByTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$groupByTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupByTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            receiveChannel2 = receiveChannel6;
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2 A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad A[Catch:{ all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$groupByTo$3 channelsKt__Channels_commonKt$groupByTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$groupByTo$3 channelsKt__Channels_commonKt$groupByTo$32;
        Function1<? super E, ? extends V> function13;
        Function1<? super E, ? extends K> function14;
        Map map;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupByTo$3) {
            channelsKt__Channels_commonKt$groupByTo$3 = (ChannelsKt__Channels_commonKt$groupByTo$3) continuation;
            if ((channelsKt__Channels_commonKt$groupByTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupByTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$groupByTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupByTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        map = m;
                        function14 = function1;
                        function13 = function12;
                        th3 = null;
                        channelsKt__Channels_commonKt$groupByTo$32 = channelsKt__Channels_commonKt$groupByTo$3;
                        obj = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$groupByTo$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$groupByTo$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$4;
                    Function1<? super E, ? extends V> function15 = (Function1) channelsKt__Channels_commonKt$groupByTo$3.L$3;
                    Function1<? super E, ? extends K> function16 = (Function1) channelsKt__Channels_commonKt$groupByTo$3.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$groupByTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$groupByTo$32 = channelsKt__Channels_commonKt$groupByTo$3;
                        receiveChannel5 = receiveChannel9;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        function13 = function15;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        map = map2;
                        th3 = th5;
                        function14 = function16;
                        if (((Boolean) obj2).booleanValue()) {
                            Object obj3 = (Object) channelIterator.next();
                            Object invoke = function14.invoke(obj3);
                            Object obj4 = map.get(invoke);
                            if (obj4 == null) {
                                obj4 = new ArrayList();
                                map.put(invoke, obj4);
                            }
                            ((List) obj4).add(function13.invoke(obj3));
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return map;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$groupByTo$32.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$groupByTo$32.L$1 = map;
                channelsKt__Channels_commonKt$groupByTo$32.L$2 = function14;
                channelsKt__Channels_commonKt$groupByTo$32.L$3 = function13;
                channelsKt__Channels_commonKt$groupByTo$32.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$groupByTo$32.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$groupByTo$32.L$6 = th3;
                channelsKt__Channels_commonKt$groupByTo$32.L$7 = receiveChannel4;
                channelsKt__Channels_commonKt$groupByTo$32.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$groupByTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupByTo$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    map = map;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$groupByTo$3 = new ChannelsKt__Channels_commonKt$groupByTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$groupByTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupByTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$groupByTo$32.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$groupByTo$32.L$1 = map;
            channelsKt__Channels_commonKt$groupByTo$32.L$2 = function14;
            channelsKt__Channels_commonKt$groupByTo$32.L$3 = function13;
            channelsKt__Channels_commonKt$groupByTo$32.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$groupByTo$32.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$groupByTo$32.L$6 = th3;
            channelsKt__Channels_commonKt$groupByTo$32.L$7 = receiveChannel4;
            channelsKt__Channels_commonKt$groupByTo$32.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$groupByTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$groupByTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$map$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$mapIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac A[Catch:{ all -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b9 A[Catch:{ all -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1 channelsKt__Channels_commonKt$mapIndexedNotNullTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.IntRef intRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1 channelsKt__Channels_commonKt$mapIndexedNotNullTo$12;
        Function2<? super Integer, ? super E, ? extends R> function22;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1) {
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$1 = (ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        collection = c;
                        function22 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$9;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$8;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$5;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$3;
                    Function2<? super Integer, ? super E, ? extends R> function23 = (Function2) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1;
                        receiveChannel6 = receiveChannel10;
                        channelIterator = channelIterator3;
                        receiveChannel2 = receiveChannel8;
                        function22 = function23;
                        th3 = th5;
                        collection = collection2;
                        intRef = intRef3;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object next = channelIterator.next();
                            int i3 = intRef.element;
                            intRef.element = i3 + 1;
                            IndexedValue indexedValue = new IndexedValue(i3, next);
                            Object invoke = function22.invoke(Boxing.boxInt(indexedValue.component1()), (Object) indexedValue.component2());
                            if (invoke != null) {
                                Boxing.boxBoolean(collection.add(invoke));
                            }
                            receiveChannel7 = receiveChannel3;
                            i2 = 1;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$1 = collection;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$2 = function22;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$4 = intRef;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$7 = th3;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$8 = receiveChannel4;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$9 = channelIterator2;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.label = i2;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$mapIndexedNotNullTo$1 = new ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label;
        int i2 = 1;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$1 = collection;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$2 = function22;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$4 = intRef;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$7 = th3;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$8 = receiveChannel4;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$9 = channelIterator2;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.label = i2;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r13v11, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e5 A[Catch:{ all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0100 A[Catch:{ all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th3;
        Object obj;
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 channelsKt__Channels_commonKt$mapIndexedNotNullTo$32;
        Ref.IntRef intRef;
        Function2<? super Integer, ? super E, ? extends R> function22;
        C c2;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        C c3;
        Function2<? super Integer, ? super E, ? extends R> function23;
        ReceiveChannel<? extends E> receiveChannel8;
        Ref.IntRef intRef2;
        ReceiveChannel<? extends E> receiveChannel9;
        ReceiveChannel<? extends E> receiveChannel10;
        Throwable th4;
        ChannelIterator<? extends E> channelIterator2;
        ChannelIterator<? extends E> channelIterator3;
        SendChannel sendChannel;
        ChannelIterator<? extends E> channelIterator4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3) {
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3 = (ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        c2 = c;
                        function22 = function2;
                        intRef = intRef3;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator4 = receiveChannel.iterator();
                        receiveChannel7 = receiveChannel;
                        receiveChannel6 = receiveChannel7;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$8;
                    th4 = (Throwable) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$7;
                    receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$5;
                    intRef2 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$4;
                    receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$3;
                    function23 = (Function2) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$2;
                    SendChannel sendChannel2 = (SendChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$9;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$6;
                    sendChannel = sendChannel2;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object next = channelIterator3.next();
                        int i3 = intRef2.element;
                        intRef2.element = i3 + 1;
                        IndexedValue indexedValue = new IndexedValue(i3, next);
                        int component1 = indexedValue.component1();
                        Object obj3 = (Object) indexedValue.component2();
                        Object invoke = function23.invoke(Boxing.boxInt(component1), obj3);
                        if (invoke != null) {
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$2 = function23;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$3 = receiveChannel8;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$4 = intRef2;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$5 = receiveChannel9;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$6 = receiveChannel2;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$7 = th4;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$8 = receiveChannel4;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$9 = channelIterator3;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$10 = next;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$11 = next;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$12 = indexedValue;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.I$0 = component1;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$13 = obj3;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$14 = invoke;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label = 2;
                            if (sendChannel.send(invoke, channelsKt__Channels_commonKt$mapIndexedNotNullTo$3) != coroutine_suspended) {
                                coroutine_suspended = coroutine_suspended;
                                receiveChannel10 = receiveChannel2;
                                channelIterator2 = channelIterator3;
                                c3 = sendChannel;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                                receiveChannel6 = receiveChannel8;
                                obj = coroutine_suspended;
                                receiveChannel5 = receiveChannel9;
                                intRef = intRef2;
                                channelIterator = channelIterator2;
                                receiveChannel2 = receiveChannel10;
                                function22 = function23;
                                th3 = th4;
                                c2 = c3;
                                receiveChannel7 = receiveChannel3;
                                i2 = 1;
                                channelIterator4 = channelIterator;
                            }
                            return coroutine_suspended;
                        }
                        receiveChannel5 = receiveChannel9;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                        receiveChannel6 = receiveChannel8;
                        obj = coroutine_suspended;
                        th3 = th4;
                        c2 = sendChannel;
                        function22 = function23;
                        channelIterator = channelIterator3;
                        receiveChannel7 = receiveChannel3;
                        i2 = 1;
                        channelIterator4 = channelIterator;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th4);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$14;
                    Object obj5 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$13;
                    int i4 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.I$0;
                    IndexedValue indexedValue2 = (IndexedValue) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$12;
                    Object obj6 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$11;
                    Object obj7 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$10;
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$9;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$8;
                    th4 = (Throwable) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$7;
                    receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$6;
                    receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$5;
                    intRef2 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$4;
                    receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$3;
                    function23 = (Function2) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$2;
                    ?? r13 = (SendChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        c3 = r13;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                        receiveChannel6 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel9;
                        intRef = intRef2;
                        channelIterator = channelIterator2;
                        receiveChannel2 = receiveChannel10;
                        function22 = function23;
                        th3 = th4;
                        c2 = c3;
                        receiveChannel7 = receiveChannel3;
                        i2 = 1;
                        channelIterator4 = channelIterator;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel10;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$0 = receiveChannel7;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$1 = c2;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$2 = function22;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$4 = intRef;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$7 = th3;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$8 = receiveChannel4;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$9 = channelIterator4;
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.label = i2;
                hasNext = channelIterator4.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    receiveChannel8 = receiveChannel6;
                    channelsKt__Channels_commonKt$mapIndexedNotNullTo$3 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$32;
                    intRef2 = intRef;
                    receiveChannel9 = receiveChannel5;
                    coroutine_suspended = obj;
                    sendChannel = c2;
                    th4 = th3;
                    function23 = function22;
                    channelIterator3 = channelIterator4;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th4);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3 = new ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label;
        int i2 = 1;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$1 = c2;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$2 = function22;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$4 = intRef;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$7 = th3;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$8 = receiveChannel4;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$9 = channelIterator4;
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.label = i2;
            hasNext = channelIterator4.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9 A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4 A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedTo$1 channelsKt__Channels_commonKt$mapIndexedTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.IntRef intRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$mapIndexedTo$1 channelsKt__Channels_commonKt$mapIndexedTo$12;
        Function2<? super Integer, ? super E, ? extends R> function22;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedTo$1) {
            channelsKt__Channels_commonKt$mapIndexedTo$1 = (ChannelsKt__Channels_commonKt$mapIndexedTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        function22 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedTo$12 = channelsKt__Channels_commonKt$mapIndexedTo$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                        collection = c;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedTo$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$mapIndexedTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$4;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedTo$1.L$3;
                    Function2<? super Integer, ? super E, ? extends R> function23 = (Function2) channelsKt__Channels_commonKt$mapIndexedTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapIndexedTo$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$mapIndexedTo$12 = channelsKt__Channels_commonKt$mapIndexedTo$1;
                        receiveChannel5 = receiveChannel9;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        collection = collection2;
                        intRef = intRef3;
                        th3 = th5;
                        function22 = function23;
                        if (!((Boolean) obj2).booleanValue()) {
                            int i2 = intRef.element;
                            intRef.element = i2 + 1;
                            collection.add(function22.invoke(Boxing.boxInt(i2), (Object) channelIterator.next()));
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$1 = collection;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$2 = function22;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$3 = intRef;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$6 = th3;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$7 = receiveChannel4;
                channelsKt__Channels_commonKt$mapIndexedTo$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$mapIndexedTo$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$mapIndexedTo$1 = new ChannelsKt__Channels_commonKt$mapIndexedTo$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$mapIndexedTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$1 = collection;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$2 = function22;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$3 = intRef;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$6 = th3;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$7 = receiveChannel4;
            channelsKt__Channels_commonKt$mapIndexedTo$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$mapIndexedTo$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v8. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r12v8, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e5 A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0102 A[Catch:{ all -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedTo$3 channelsKt__Channels_commonKt$mapIndexedTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        SendChannel sendChannel;
        Function2<? super Integer, ? super E, ? extends R> function22;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        Ref.IntRef intRef;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelsKt__Channels_commonKt$mapIndexedTo$3 channelsKt__Channels_commonKt$mapIndexedTo$32;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel8;
        C c2;
        Throwable th4;
        Function2<? super Integer, ? super E, ? extends R> function23;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedTo$3) {
            channelsKt__Channels_commonKt$mapIndexedTo$3 = (ChannelsKt__Channels_commonKt$mapIndexedTo$3) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        function23 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedTo$32 = channelsKt__Channels_commonKt$mapIndexedTo$3;
                        obj = coroutine_suspended;
                        th4 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel7 = receiveChannel6;
                        receiveChannel2 = receiveChannel7;
                        receiveChannel8 = receiveChannel2;
                        c2 = c;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedTo$3.L$8;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$7;
                    th3 = (Throwable) channelsKt__Channels_commonKt$mapIndexedTo$3.L$6;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$4;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedTo$3.L$3;
                    function22 = (Function2) channelsKt__Channels_commonKt$mapIndexedTo$3.L$2;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = coroutine_suspended;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$5;
                    intRef = intRef3;
                    sendChannel = (SendChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$1;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object obj3 = (Object) channelIterator.next();
                        int i2 = intRef.element;
                        intRef.element = i2 + 1;
                        Object invoke = function22.invoke(Boxing.boxInt(i2), obj3);
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$1 = sendChannel;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$2 = function22;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$3 = intRef;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$6 = th3;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$7 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$8 = channelIterator;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$9 = obj3;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.L$10 = obj3;
                        channelsKt__Channels_commonKt$mapIndexedTo$3.label = 2;
                        if (sendChannel.send(invoke, channelsKt__Channels_commonKt$mapIndexedTo$3) != obj) {
                            receiveChannel6 = receiveChannel3;
                            channelsKt__Channels_commonKt$mapIndexedTo$32 = channelsKt__Channels_commonKt$mapIndexedTo$3;
                            receiveChannel7 = receiveChannel4;
                            channelIterator2 = channelIterator;
                            receiveChannel8 = receiveChannel5;
                            c2 = sendChannel;
                            th4 = th3;
                            function23 = function22;
                        }
                        return obj;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$mapIndexedTo$3.L$10;
                    Object obj5 = channelsKt__Channels_commonKt$mapIndexedTo$3.L$9;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedTo$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$7;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$mapIndexedTo$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$4;
                    Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedTo$3.L$3;
                    Function2<? super Integer, ? super E, ? extends R> function24 = (Function2) channelsKt__Channels_commonKt$mapIndexedTo$3.L$2;
                    ?? r12 = (SendChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel6 = receiveChannel12;
                        channelsKt__Channels_commonKt$mapIndexedTo$32 = channelsKt__Channels_commonKt$mapIndexedTo$3;
                        receiveChannel7 = receiveChannel11;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel10;
                        intRef = intRef4;
                        channelIterator2 = channelIterator3;
                        receiveChannel8 = receiveChannel9;
                        c2 = r12;
                        th4 = th6;
                        function23 = function24;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel10;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$1 = c2;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$2 = function23;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$3 = intRef;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$4 = receiveChannel7;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$6 = th4;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$7 = receiveChannel8;
                channelsKt__Channels_commonKt$mapIndexedTo$32.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$mapIndexedTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$32);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    receiveChannel4 = receiveChannel7;
                    channelsKt__Channels_commonKt$mapIndexedTo$3 = channelsKt__Channels_commonKt$mapIndexedTo$32;
                    receiveChannel5 = receiveChannel8;
                    channelIterator = channelIterator2;
                    sendChannel = c2;
                    function22 = function23;
                    th3 = th4;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$mapIndexedTo$3 = new ChannelsKt__Channels_commonKt$mapIndexedTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$mapIndexedTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$1 = c2;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$2 = function23;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$3 = intRef;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$4 = receiveChannel7;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$6 = th4;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$7 = receiveChannel8;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$mapIndexedTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th9) {
            th2 = th9;
            th = th2;
            throw th;
        }
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> mapNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$12;
        Function1<? super E, ? extends R> function12;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, ? extends R> function13;
        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapNotNullTo$1) {
            channelsKt__Channels_commonKt$mapNotNullTo$1 = (ChannelsKt__Channels_commonKt$mapNotNullTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapNotNullTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$mapNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapNotNullTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$mapNotNullTo$13 = channelsKt__Channels_commonKt$mapNotNullTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapNotNullTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapNotNullTo$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$mapNotNullTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapNotNullTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        collection = collection2;
                        channelsKt__Channels_commonKt$mapNotNullTo$12 = channelsKt__Channels_commonKt$mapNotNullTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            Object invoke = function12.invoke((Object) channelIterator.next());
                            if (invoke != null) {
                                Boxing.boxBoolean(collection.add(invoke));
                            }
                            receiveChannel2 = receiveChannel5;
                            function13 = function12;
                            channelsKt__Channels_commonKt$mapNotNullTo$13 = channelsKt__Channels_commonKt$mapNotNullTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel5, th2);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$1 = collection;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$mapNotNullTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$mapNotNullTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$13);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel2;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$mapNotNullTo$12 = channelsKt__Channels_commonKt$mapNotNullTo$13;
                    function12 = function13;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel5, th2);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$mapNotNullTo$1 = new ChannelsKt__Channels_commonKt$mapNotNullTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$mapNotNullTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapNotNullTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$1 = collection;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$mapNotNullTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$mapNotNullTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r15v6. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r7v10, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c6 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapNotNullTo$3 channelsKt__Channels_commonKt$mapNotNullTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        C c2;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        ChannelsKt__Channels_commonKt$mapNotNullTo$3 channelsKt__Channels_commonKt$mapNotNullTo$32;
        C c3;
        ChannelIterator<? extends E> channelIterator2;
        Throwable th3;
        Object obj;
        Function1<? super E, ? extends R> function13;
        SendChannel sendChannel;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapNotNullTo$3) {
            channelsKt__Channels_commonKt$mapNotNullTo$3 = (ChannelsKt__Channels_commonKt$mapNotNullTo$3) continuation;
            if ((channelsKt__Channels_commonKt$mapNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapNotNullTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapNotNullTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapNotNullTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th4 = null;
                    try {
                        channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                        obj = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        c3 = c;
                        function13 = function1;
                        th3 = th4;
                        receiveChannel8 = receiveChannel;
                        receiveChannel2 = receiveChannel8;
                        receiveChannel7 = receiveChannel2;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapNotNullTo$3.L$7;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$mapNotNullTo$3.L$2;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    th3 = (Throwable) channelsKt__Channels_commonKt$mapNotNullTo$3.L$5;
                    receiveChannel2 = receiveChannel9;
                    sendChannel = (SendChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$1;
                    if (((Boolean) obj2).booleanValue()) {
                        Object obj3 = (Object) channelIterator.next();
                        Object invoke = function12.invoke(obj3);
                        if (invoke != null) {
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$1 = sendChannel;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$2 = function12;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$3 = receiveChannel5;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$5 = th3;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$6 = receiveChannel3;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$7 = channelIterator;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$8 = obj3;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$9 = obj3;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$10 = invoke;
                            channelsKt__Channels_commonKt$mapNotNullTo$3.label = 2;
                            if (sendChannel.send(invoke, channelsKt__Channels_commonKt$mapNotNullTo$3) != coroutine_suspended) {
                                receiveChannel6 = receiveChannel2;
                                th2 = th3;
                                c2 = sendChannel;
                                receiveChannel7 = receiveChannel3;
                                receiveChannel8 = receiveChannel5;
                                channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                                c3 = c2;
                                channelIterator2 = channelIterator;
                                receiveChannel = receiveChannel4;
                                th3 = th2;
                                receiveChannel2 = receiveChannel6;
                                obj = coroutine_suspended;
                                function13 = function12;
                            }
                            return coroutine_suspended;
                        }
                        receiveChannel7 = receiveChannel3;
                        receiveChannel8 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                        c3 = sendChannel;
                        channelIterator2 = channelIterator;
                        receiveChannel = receiveChannel4;
                        obj = coroutine_suspended;
                        function13 = function12;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$mapNotNullTo$3.L$10;
                    Object obj5 = channelsKt__Channels_commonKt$mapNotNullTo$3.L$9;
                    Object obj6 = channelsKt__Channels_commonKt$mapNotNullTo$3.L$8;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapNotNullTo$3.L$7;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$6;
                    th2 = (Throwable) channelsKt__Channels_commonKt$mapNotNullTo$3.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$mapNotNullTo$3.L$2;
                    ?? r7 = (SendChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$1;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        c2 = r7;
                        receiveChannel7 = receiveChannel3;
                        receiveChannel8 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                        c3 = c2;
                        channelIterator2 = channelIterator;
                        receiveChannel = receiveChannel4;
                        th3 = th2;
                        receiveChannel2 = receiveChannel6;
                        obj = coroutine_suspended;
                        function13 = function12;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$1 = c3;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$2 = function13;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$3 = receiveChannel8;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$5 = th3;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$6 = receiveChannel7;
                channelsKt__Channels_commonKt$mapNotNullTo$32.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$mapNotNullTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$32);
                if (hasNext == obj) {
                    receiveChannel4 = receiveChannel;
                    channelIterator = channelIterator2;
                    sendChannel = c3;
                    channelsKt__Channels_commonKt$mapNotNullTo$3 = channelsKt__Channels_commonKt$mapNotNullTo$32;
                    receiveChannel5 = receiveChannel8;
                    receiveChannel3 = receiveChannel7;
                    obj2 = hasNext;
                    function12 = function13;
                    coroutine_suspended = obj;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$mapNotNullTo$3 = new ChannelsKt__Channels_commonKt$mapNotNullTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$mapNotNullTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapNotNullTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$1 = c3;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$2 = function13;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$3 = receiveChannel8;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$5 = th3;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$6 = receiveChannel7;
            channelsKt__Channels_commonKt$mapNotNullTo$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$mapNotNullTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E, R, C extends Collection<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$12;
        Function1<? super E, ? extends R> function12;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel6;
        Function1<? super E, ? extends R> function13;
        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$13;
        Object obj2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapTo$1) {
            channelsKt__Channels_commonKt$mapTo$1 = (ChannelsKt__Channels_commonKt$mapTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapTo$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$mapTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$mapTo$13 = channelsKt__Channels_commonKt$mapTo$1;
                        obj2 = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel6 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel6;
                        channelIterator2 = receiveChannel.iterator();
                        function13 = function1;
                        receiveChannel3 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapTo$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$mapTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel6 = receiveChannel7;
                        receiveChannel4 = receiveChannel9;
                        obj = coroutine_suspended;
                        collection = collection2;
                        channelsKt__Channels_commonKt$mapTo$12 = channelsKt__Channels_commonKt$mapTo$1;
                        th2 = th4;
                        receiveChannel3 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            collection.add(function12.invoke((Object) channelIterator.next()));
                            receiveChannel2 = receiveChannel5;
                            function13 = function12;
                            channelsKt__Channels_commonKt$mapTo$13 = channelsKt__Channels_commonKt$mapTo$12;
                            obj2 = obj;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel5, th2);
                        InlineMarker.finallyEnd(1);
                        return collection;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapTo$13.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$mapTo$13.L$1 = collection;
                channelsKt__Channels_commonKt$mapTo$13.L$2 = function13;
                channelsKt__Channels_commonKt$mapTo$13.L$3 = receiveChannel3;
                channelsKt__Channels_commonKt$mapTo$13.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$mapTo$13.L$5 = th2;
                channelsKt__Channels_commonKt$mapTo$13.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$mapTo$13.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$mapTo$13.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapTo$13);
                if (hasNext == obj2) {
                    receiveChannel5 = receiveChannel2;
                    obj3 = hasNext;
                    obj = obj2;
                    channelsKt__Channels_commonKt$mapTo$12 = channelsKt__Channels_commonKt$mapTo$13;
                    function12 = function13;
                    collection = collection;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel5, th2);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$mapTo$1 = new ChannelsKt__Channels_commonKt$mapTo$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$mapTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapTo$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapTo$13.L$0 = receiveChannel4;
            channelsKt__Channels_commonKt$mapTo$13.L$1 = collection;
            channelsKt__Channels_commonKt$mapTo$13.L$2 = function13;
            channelsKt__Channels_commonKt$mapTo$13.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$mapTo$13.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$mapTo$13.L$5 = th2;
            channelsKt__Channels_commonKt$mapTo$13.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$mapTo$13.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$mapTo$13.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapTo$13);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r15v5. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <E, R, C extends SendChannel<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapTo$3 channelsKt__Channels_commonKt$mapTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        SendChannel sendChannel;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelsKt__Channels_commonKt$mapTo$3 channelsKt__Channels_commonKt$mapTo$32;
        C c2;
        ChannelIterator channelIterator2;
        Object obj;
        Function1<? super E, ? extends R> function13;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapTo$3) {
            channelsKt__Channels_commonKt$mapTo$3 = (ChannelsKt__Channels_commonKt$mapTo$3) continuation;
            if ((channelsKt__Channels_commonKt$mapTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th3 = null;
                    try {
                        channelsKt__Channels_commonKt$mapTo$32 = channelsKt__Channels_commonKt$mapTo$3;
                        obj = coroutine_suspended;
                        channelIterator2 = receiveChannel.iterator();
                        c2 = c;
                        function13 = function1;
                        th2 = th3;
                        receiveChannel7 = receiveChannel;
                        receiveChannel2 = receiveChannel7;
                        receiveChannel6 = receiveChannel2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapTo$3.L$7;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$4;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$3;
                    function12 = (Function1) channelsKt__Channels_commonKt$mapTo$3.L$2;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$0;
                    ResultKt.throwOnFailure(obj2);
                    th2 = (Throwable) channelsKt__Channels_commonKt$mapTo$3.L$5;
                    receiveChannel2 = receiveChannel8;
                    sendChannel = (SendChannel) channelsKt__Channels_commonKt$mapTo$3.L$1;
                    if (!((Boolean) obj2).booleanValue()) {
                        Object obj3 = (Object) channelIterator.next();
                        Object invoke = function12.invoke(obj3);
                        channelsKt__Channels_commonKt$mapTo$3.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapTo$3.L$1 = sendChannel;
                        channelsKt__Channels_commonKt$mapTo$3.L$2 = function12;
                        channelsKt__Channels_commonKt$mapTo$3.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapTo$3.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapTo$3.L$5 = th2;
                        channelsKt__Channels_commonKt$mapTo$3.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapTo$3.L$7 = channelIterator;
                        channelsKt__Channels_commonKt$mapTo$3.L$8 = obj3;
                        channelsKt__Channels_commonKt$mapTo$3.L$9 = obj3;
                        channelsKt__Channels_commonKt$mapTo$3.label = 2;
                        if (sendChannel.send(invoke, channelsKt__Channels_commonKt$mapTo$3) != coroutine_suspended) {
                            receiveChannel6 = receiveChannel3;
                            receiveChannel7 = receiveChannel5;
                            channelsKt__Channels_commonKt$mapTo$32 = channelsKt__Channels_commonKt$mapTo$3;
                            c2 = sendChannel;
                            channelIterator2 = channelIterator;
                            receiveChannel = receiveChannel4;
                            obj = coroutine_suspended;
                            function13 = function12;
                        }
                        return coroutine_suspended;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                } else if (i == 2) {
                    Object obj4 = channelsKt__Channels_commonKt$mapTo$3.L$9;
                    Object obj5 = channelsKt__Channels_commonKt$mapTo$3.L$8;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapTo$3.L$7;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$mapTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$3;
                    Function1<? super E, ? extends R> function14 = (Function1) channelsKt__Channels_commonKt$mapTo$3.L$2;
                    ?? r7 = (SendChannel) channelsKt__Channels_commonKt$mapTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        receiveChannel6 = receiveChannel9;
                        receiveChannel7 = receiveChannel11;
                        channelsKt__Channels_commonKt$mapTo$32 = channelsKt__Channels_commonKt$mapTo$3;
                        c2 = r7;
                        channelIterator2 = channelIterator3;
                        receiveChannel = receiveChannel12;
                        th2 = th5;
                        receiveChannel2 = receiveChannel10;
                        obj = coroutine_suspended;
                        function13 = function14;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel10;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$mapTo$32.L$0 = receiveChannel;
                channelsKt__Channels_commonKt$mapTo$32.L$1 = c2;
                channelsKt__Channels_commonKt$mapTo$32.L$2 = function13;
                channelsKt__Channels_commonKt$mapTo$32.L$3 = receiveChannel7;
                channelsKt__Channels_commonKt$mapTo$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$mapTo$32.L$5 = th2;
                channelsKt__Channels_commonKt$mapTo$32.L$6 = receiveChannel6;
                channelsKt__Channels_commonKt$mapTo$32.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$mapTo$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapTo$32);
                if (hasNext == obj) {
                    receiveChannel4 = receiveChannel;
                    channelIterator = channelIterator2;
                    sendChannel = c2;
                    channelsKt__Channels_commonKt$mapTo$3 = channelsKt__Channels_commonKt$mapTo$32;
                    receiveChannel5 = receiveChannel7;
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    function12 = function13;
                    coroutine_suspended = obj;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$mapTo$3 = new ChannelsKt__Channels_commonKt$mapTo$3(continuation);
        Object obj2 = channelsKt__Channels_commonKt$mapTo$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapTo$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$mapTo$32.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$mapTo$32.L$1 = c2;
            channelsKt__Channels_commonKt$mapTo$32.L$2 = function13;
            channelsKt__Channels_commonKt$mapTo$32.L$3 = receiveChannel7;
            channelsKt__Channels_commonKt$mapTo$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$mapTo$32.L$5 = th2;
            channelsKt__Channels_commonKt$mapTo$32.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$mapTo$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$mapTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapTo$32);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.withIndex(receiveChannel, coroutineContext);
    }

    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$withIndex$1(receiveChannel, null), 6, null);
    }

    public static final <E> ReceiveChannel<E> distinct(ReceiveChannel<? extends E> receiveChannel) {
        return distinctBy$default(receiveChannel, null, new ChannelsKt__Channels_commonKt$distinct$1(null), 1, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__Channels_commonKt$distinctBy$1(receiveChannel, function2, null), 6, null);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object all(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$all$1 channelsKt__Channels_commonKt$all$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$all$1 channelsKt__Channels_commonKt$all$12;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$all$1) {
            channelsKt__Channels_commonKt$all$1 = (ChannelsKt__Channels_commonKt$all$1) continuation;
            if ((channelsKt__Channels_commonKt$all$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$all$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$all$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$all$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$all$12 = channelsKt__Channels_commonKt$all$1;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$all$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$all$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$all$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        function12 = function13;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$all$12 = channelsKt__Channels_commonKt$all$1;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            if (function12.invoke((Object) channelIterator.next()).booleanValue()) {
                                receiveChannel6 = receiveChannel4;
                                obj2 = obj;
                                th3 = th2;
                                channelIterator2 = channelIterator;
                            }
                            Boolean boxBoolean = Boxing.boxBoolean(false);
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(2);
                            return boxBoolean;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxBoolean(true);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$all$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$all$12.L$1 = function12;
                channelsKt__Channels_commonKt$all$12.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$all$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$all$12.L$4 = th3;
                channelsKt__Channels_commonKt$all$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$all$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$all$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$all$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxBoolean(true);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$all$1 = new ChannelsKt__Channels_commonKt$all$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$all$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$all$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$all$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$all$12.L$1 = function12;
            channelsKt__Channels_commonKt$all$12.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$all$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$all$12.L$4 = th3;
            channelsKt__Channels_commonKt$all$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$all$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$all$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$all$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$any$1 channelsKt__Channels_commonKt$any$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        Object obj;
        if (continuation instanceof ChannelsKt__Channels_commonKt$any$1) {
            channelsKt__Channels_commonKt$any$1 = (ChannelsKt__Channels_commonKt$any$1) continuation;
            if ((channelsKt__Channels_commonKt$any$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$any$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$any$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$any$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    th2 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$any$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.L$2 = th2;
                        channelsKt__Channels_commonKt$any$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.label = 1;
                        obj = it2.hasNext(channelsKt__Channels_commonKt$any$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$3;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$any$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        obj = obj2;
                        th2 = th4;
                        receiveChannel = receiveChannel2;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                return obj;
            }
        }
        channelsKt__Channels_commonKt$any$1 = new ChannelsKt__Channels_commonKt$any$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$any$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$any$1.label;
        if (i != 0) {
        }
        ChannelsKt.cancelConsumed(receiveChannel, th2);
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$any$3 channelsKt__Channels_commonKt$any$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$any$3 channelsKt__Channels_commonKt$any$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$any$3) {
            channelsKt__Channels_commonKt$any$3 = (ChannelsKt__Channels_commonKt$any$3) continuation;
            if ((channelsKt__Channels_commonKt$any$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$any$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$any$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$any$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$any$32 = channelsKt__Channels_commonKt$any$3;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$any$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$any$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$any$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        function12 = function13;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$any$32 = channelsKt__Channels_commonKt$any$3;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            if (!function12.invoke((Object) channelIterator.next()).booleanValue()) {
                                receiveChannel6 = receiveChannel4;
                                obj2 = obj;
                                th3 = th2;
                                channelIterator2 = channelIterator;
                            }
                            Boolean boxBoolean = Boxing.boxBoolean(true);
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(2);
                            return boxBoolean;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxBoolean(false);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$any$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$any$32.L$1 = function12;
                channelsKt__Channels_commonKt$any$32.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$any$32.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$any$32.L$4 = th3;
                channelsKt__Channels_commonKt$any$32.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$any$32.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$any$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$any$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxBoolean(false);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$any$3 = new ChannelsKt__Channels_commonKt$any$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$any$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$any$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$any$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$any$32.L$1 = function12;
            channelsKt__Channels_commonKt$any$32.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$any$32.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$any$32.L$4 = th3;
            channelsKt__Channels_commonKt$any$32.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$any$32.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$any$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$any$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0096 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$count$1 channelsKt__Channels_commonKt$count$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.IntRef intRef;
        Throwable th2;
        Object obj;
        ChannelsKt__Channels_commonKt$count$1 channelsKt__Channels_commonKt$count$12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$count$1) {
            channelsKt__Channels_commonKt$count$1 = (ChannelsKt__Channels_commonKt$count$1) continuation;
            if ((channelsKt__Channels_commonKt$count$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$count$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$count$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$count$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        intRef = intRef2;
                        obj = coroutine_suspended;
                        th2 = null;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel4 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                        receiveChannel5 = receiveChannel4;
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$count$1.L$6;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$5;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$count$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$2;
                    intRef = (Ref.IntRef) channelsKt__Channels_commonKt$count$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                        receiveChannel5 = receiveChannel8;
                        th2 = th4;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj2).booleanValue()) {
                            channelIterator.next();
                            intRef.element++;
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return Boxing.boxInt(intRef.element);
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$count$12.L$1 = intRef;
                channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel5;
                channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$count$12.L$4 = th2;
                channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
                channelsKt__Channels_commonKt$count$12.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$count$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$count$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return Boxing.boxInt(intRef.element);
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$count$1 = new ChannelsKt__Channels_commonKt$count$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$count$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$count$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$count$12.L$1 = intRef;
            channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel5;
            channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$count$12.L$4 = th2;
            channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
            channelsKt__Channels_commonKt$count$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$count$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$count$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th7) {
            th = th7;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$count$3 channelsKt__Channels_commonKt$count$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.IntRef intRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$count$3 channelsKt__Channels_commonKt$count$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.IntRef intRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$count$3) {
            channelsKt__Channels_commonKt$count$3 = (ChannelsKt__Channels_commonKt$count$3) continuation;
            if ((channelsKt__Channels_commonKt$count$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$count$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$count$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$count$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        intRef2 = intRef3;
                        obj2 = coroutine_suspended;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$count$32 = channelsKt__Channels_commonKt$count$3;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$count$3.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$count$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$3;
                    Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$count$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$count$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        intRef = intRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$count$32 = channelsKt__Channels_commonKt$count$3;
                        receiveChannel2 = receiveChannel8;
                        th2 = th5;
                        function12 = function13;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            if (function12.invoke((Object) channelIterator.next()).booleanValue()) {
                                intRef.element++;
                            }
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            intRef2 = intRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxInt(intRef.element);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$count$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$count$32.L$1 = function12;
                channelsKt__Channels_commonKt$count$32.L$2 = intRef2;
                channelsKt__Channels_commonKt$count$32.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$count$32.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$count$32.L$5 = th3;
                channelsKt__Channels_commonKt$count$32.L$6 = receiveChannel5;
                channelsKt__Channels_commonKt$count$32.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$count$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$count$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    intRef = intRef2;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxInt(intRef.element);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$count$3 = new ChannelsKt__Channels_commonKt$count$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$count$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$count$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$count$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$count$32.L$1 = function12;
            channelsKt__Channels_commonKt$count$32.L$2 = intRef2;
            channelsKt__Channels_commonKt$count$32.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$count$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$count$32.L$5 = th3;
            channelsKt__Channels_commonKt$count$32.L$6 = receiveChannel5;
            channelsKt__Channels_commonKt$count$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$count$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$count$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0 A[Catch:{ all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, R> Object fold(ReceiveChannel<? extends E> receiveChannel, R r, Function2<? super R, ? super E, ? extends R> function2, Continuation<? super R> continuation) {
        ChannelsKt__Channels_commonKt$fold$1 channelsKt__Channels_commonKt$fold$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.ObjectRef objectRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$fold$1 channelsKt__Channels_commonKt$fold$12;
        Function2<? super R, ? super E, ? extends R> function22;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$fold$1) {
            channelsKt__Channels_commonKt$fold$1 = (ChannelsKt__Channels_commonKt$fold$1) continuation;
            if ((channelsKt__Channels_commonKt$fold$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$fold$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$fold$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$fold$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = r;
                    try {
                        objectRef = objectRef2;
                        channelsKt__Channels_commonKt$fold$12 = channelsKt__Channels_commonKt$fold$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        function22 = function2;
                        obj2 = r;
                        receiveChannel4 = receiveChannel2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$fold$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$fold$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$4;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$fold$1.L$3;
                    Function2<? super R, ? super E, ? extends R> function23 = (Function2) channelsKt__Channels_commonKt$fold$1.L$2;
                    Object obj4 = channelsKt__Channels_commonKt$fold$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        channelsKt__Channels_commonKt$fold$12 = channelsKt__Channels_commonKt$fold$1;
                        receiveChannel5 = receiveChannel9;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        obj2 = obj4;
                        objectRef = objectRef3;
                        th3 = th5;
                        function22 = function23;
                        if (!((Boolean) obj3).booleanValue()) {
                            objectRef.element = (T) function22.invoke(objectRef.element, (Object) channelIterator.next());
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return objectRef.element;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$fold$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$fold$12.L$1 = obj2;
                channelsKt__Channels_commonKt$fold$12.L$2 = function22;
                channelsKt__Channels_commonKt$fold$12.L$3 = objectRef;
                channelsKt__Channels_commonKt$fold$12.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$fold$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$fold$12.L$6 = th3;
                channelsKt__Channels_commonKt$fold$12.L$7 = receiveChannel4;
                channelsKt__Channels_commonKt$fold$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$fold$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$fold$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj3 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return objectRef.element;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$fold$1 = new ChannelsKt__Channels_commonKt$fold$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$fold$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$fold$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$fold$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$fold$12.L$1 = obj2;
            channelsKt__Channels_commonKt$fold$12.L$2 = function22;
            channelsKt__Channels_commonKt$fold$12.L$3 = objectRef;
            channelsKt__Channels_commonKt$fold$12.L$4 = receiveChannel5;
            channelsKt__Channels_commonKt$fold$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$fold$12.L$6 = th3;
            channelsKt__Channels_commonKt$fold$12.L$7 = receiveChannel4;
            channelsKt__Channels_commonKt$fold$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$fold$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$fold$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v3, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b5 A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2 A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E, R> Object foldIndexed(ReceiveChannel<? extends E> receiveChannel, R r, Function3<? super Integer, ? super R, ? super E, ? extends R> function3, Continuation<? super R> continuation) {
        ChannelsKt__Channels_commonKt$foldIndexed$1 channelsKt__Channels_commonKt$foldIndexed$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.IntRef intRef;
        Ref.ObjectRef objectRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$foldIndexed$1 channelsKt__Channels_commonKt$foldIndexed$12;
        Function3<? super Integer, ? super R, ? super E, ? extends R> function32;
        T t;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$foldIndexed$1) {
            channelsKt__Channels_commonKt$foldIndexed$1 = (ChannelsKt__Channels_commonKt$foldIndexed$1) continuation;
            if ((channelsKt__Channels_commonKt$foldIndexed$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$foldIndexed$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$foldIndexed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$foldIndexed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    t = (T) r;
                    objectRef2.element = t;
                    try {
                        intRef = intRef2;
                        obj = coroutine_suspended;
                        objectRef = objectRef2;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel4 = receiveChannel2;
                        function32 = function3;
                        channelsKt__Channels_commonKt$foldIndexed$12 = channelsKt__Channels_commonKt$foldIndexed$1;
                        receiveChannel5 = receiveChannel4;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$foldIndexed$1.L$9;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$8;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$foldIndexed$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$5;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$foldIndexed$1.L$4;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$foldIndexed$1.L$3;
                    Function3<? super Integer, ? super R, ? super E, ? extends R> function33 = (Function3) channelsKt__Channels_commonKt$foldIndexed$1.L$2;
                    Object obj3 = channelsKt__Channels_commonKt$foldIndexed$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$foldIndexed$12 = channelsKt__Channels_commonKt$foldIndexed$1;
                        receiveChannel5 = receiveChannel9;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        t = obj3;
                        intRef = intRef3;
                        th3 = th5;
                        function32 = function33;
                        objectRef = objectRef3;
                        if (!((Boolean) obj2).booleanValue()) {
                            int i2 = intRef.element;
                            intRef.element = i2 + 1;
                            objectRef.element = (T) function32.invoke(Boxing.boxInt(i2), objectRef.element, (Object) channelIterator.next());
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return objectRef.element;
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$foldIndexed$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$foldIndexed$12.L$1 = t;
                channelsKt__Channels_commonKt$foldIndexed$12.L$2 = function32;
                channelsKt__Channels_commonKt$foldIndexed$12.L$3 = intRef;
                channelsKt__Channels_commonKt$foldIndexed$12.L$4 = objectRef;
                channelsKt__Channels_commonKt$foldIndexed$12.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$foldIndexed$12.L$6 = receiveChannel2;
                channelsKt__Channels_commonKt$foldIndexed$12.L$7 = th3;
                channelsKt__Channels_commonKt$foldIndexed$12.L$8 = receiveChannel4;
                channelsKt__Channels_commonKt$foldIndexed$12.L$9 = channelIterator2;
                channelsKt__Channels_commonKt$foldIndexed$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$foldIndexed$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return objectRef.element;
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$foldIndexed$1 = new ChannelsKt__Channels_commonKt$foldIndexed$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$foldIndexed$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$foldIndexed$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$foldIndexed$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$foldIndexed$12.L$1 = t;
            channelsKt__Channels_commonKt$foldIndexed$12.L$2 = function32;
            channelsKt__Channels_commonKt$foldIndexed$12.L$3 = intRef;
            channelsKt__Channels_commonKt$foldIndexed$12.L$4 = objectRef;
            channelsKt__Channels_commonKt$foldIndexed$12.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$foldIndexed$12.L$6 = receiveChannel2;
            channelsKt__Channels_commonKt$foldIndexed$12.L$7 = th3;
            channelsKt__Channels_commonKt$foldIndexed$12.L$8 = receiveChannel4;
            channelsKt__Channels_commonKt$foldIndexed$12.L$9 = channelIterator2;
            channelsKt__Channels_commonKt$foldIndexed$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$foldIndexed$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    public static final <E, R extends Comparable<? super R>> Object maxBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$maxBy$1 channelsKt__Channels_commonKt$maxBy$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Function1<? super E, ? extends R> function12;
        Throwable th2;
        ChannelIterator channelIterator;
        Comparable comparable;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Object hasNext;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Function1<? super E, ? extends R> function13;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel7 = receiveChannel;
        if (continuation instanceof ChannelsKt__Channels_commonKt$maxBy$1) {
            channelsKt__Channels_commonKt$maxBy$1 = (ChannelsKt__Channels_commonKt$maxBy$1) continuation;
            if ((channelsKt__Channels_commonKt$maxBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$maxBy$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$maxBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$maxBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$maxBy$1.L$0 = receiveChannel7;
                        channelsKt__Channels_commonKt$maxBy$1.L$1 = function1;
                        channelsKt__Channels_commonKt$maxBy$1.L$2 = receiveChannel7;
                        channelsKt__Channels_commonKt$maxBy$1.L$3 = th4;
                        channelsKt__Channels_commonKt$maxBy$1.L$4 = receiveChannel7;
                        channelsKt__Channels_commonKt$maxBy$1.L$5 = it2;
                        channelsKt__Channels_commonKt$maxBy$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$maxBy$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel5 = receiveChannel7;
                        function13 = function1;
                        receiveChannel6 = receiveChannel5;
                        th3 = th4;
                        channelIterator = it2;
                        obj = hasNext2;
                        th2 = th3;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$maxBy$1.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$4;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$maxBy$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$2;
                    function13 = (Function1) channelsKt__Channels_commonKt$maxBy$1.L$1;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        th3 = th6;
                        channelIterator = channelIterator3;
                        receiveChannel7 = receiveChannel8;
                        th2 = th3;
                        if (((Boolean) obj).booleanValue()) {
                            InlineMarker.finallyStart(3);
                            ChannelsKt.cancelConsumed(receiveChannel7, th2);
                            InlineMarker.finallyEnd(3);
                            return null;
                        }
                        Object next = channelIterator.next();
                        comparable = (Comparable) function13.invoke(next);
                        receiveChannel2 = receiveChannel5;
                        function12 = function13;
                        obj2 = next;
                        receiveChannel3 = receiveChannel6;
                        channelsKt__Channels_commonKt$maxBy$1.L$0 = receiveChannel2;
                        channelsKt__Channels_commonKt$maxBy$1.L$1 = function12;
                        channelsKt__Channels_commonKt$maxBy$1.L$2 = receiveChannel7;
                        channelsKt__Channels_commonKt$maxBy$1.L$3 = th2;
                        channelsKt__Channels_commonKt$maxBy$1.L$4 = receiveChannel3;
                        channelsKt__Channels_commonKt$maxBy$1.L$5 = channelIterator;
                        channelsKt__Channels_commonKt$maxBy$1.L$6 = obj2;
                        channelsKt__Channels_commonKt$maxBy$1.L$7 = comparable;
                        channelsKt__Channels_commonKt$maxBy$1.label = 2;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$maxBy$1);
                        if (hasNext == coroutine_suspended) {
                            channelIterator2 = channelIterator;
                            receiveChannel4 = receiveChannel3;
                            obj = hasNext;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel7 = receiveChannel8;
                        throw th;
                    }
                } else if (i == 2) {
                    Comparable comparable2 = (Comparable) channelsKt__Channels_commonKt$maxBy$1.L$7;
                    obj2 = channelsKt__Channels_commonKt$maxBy$1.L$6;
                    ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$maxBy$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$maxBy$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$2;
                    function12 = (Function1) channelsKt__Channels_commonKt$maxBy$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        channelIterator2 = channelIterator4;
                        comparable = comparable2;
                        receiveChannel7 = receiveChannel9;
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel7 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel7, th);
                            InlineMarker.finallyEnd(1);
                            throw th9;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next2 = channelIterator2.next();
                    Comparable comparable3 = (Comparable) function12.invoke(next2);
                    if (comparable.compareTo(comparable3) < 0) {
                        obj2 = next2;
                        comparable = comparable3;
                    }
                    receiveChannel3 = receiveChannel4;
                    channelIterator = channelIterator2;
                    th2 = th2;
                    channelsKt__Channels_commonKt$maxBy$1.L$0 = receiveChannel2;
                    channelsKt__Channels_commonKt$maxBy$1.L$1 = function12;
                    channelsKt__Channels_commonKt$maxBy$1.L$2 = receiveChannel7;
                    channelsKt__Channels_commonKt$maxBy$1.L$3 = th2;
                    channelsKt__Channels_commonKt$maxBy$1.L$4 = receiveChannel3;
                    channelsKt__Channels_commonKt$maxBy$1.L$5 = channelIterator;
                    channelsKt__Channels_commonKt$maxBy$1.L$6 = obj2;
                    channelsKt__Channels_commonKt$maxBy$1.L$7 = comparable;
                    channelsKt__Channels_commonKt$maxBy$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$maxBy$1);
                    if (hasNext == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                InlineMarker.finallyStart(2);
                ChannelsKt.cancelConsumed(receiveChannel7, th2);
                InlineMarker.finallyEnd(2);
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$maxBy$1 = new ChannelsKt__Channels_commonKt$maxBy$1(continuation);
        obj = channelsKt__Channels_commonKt$maxBy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$maxBy$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel7, th2);
        InlineMarker.finallyEnd(2);
        return obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E> Object maxWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$maxWith$1 channelsKt__Channels_commonKt$maxWith$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        Comparator<? super E> comparator2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object next;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$maxWith$1) {
            channelsKt__Channels_commonKt$maxWith$1 = (ChannelsKt__Channels_commonKt$maxWith$1) continuation;
            if ((channelsKt__Channels_commonKt$maxWith$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$maxWith$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$maxWith$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$maxWith$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator;
                        channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$maxWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$maxWith$1.L$5 = it2;
                        channelsKt__Channels_commonKt$maxWith$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel3 = receiveChannel;
                        comparator2 = comparator;
                        receiveChannel5 = receiveChannel3;
                        channelIterator2 = it2;
                        obj = hasNext2;
                        receiveChannel2 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                    th3 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                    comparator2 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    Object obj2 = channelsKt__Channels_commonKt$maxWith$1.L$6;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                    comparator2 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator.next();
                            if (comparator2.compare(obj2, next) >= 0) {
                                next = obj2;
                            }
                            channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator2;
                            channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
                            channelsKt__Channels_commonKt$maxWith$1.L$3 = th2;
                            channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator;
                            channelsKt__Channels_commonKt$maxWith$1.L$6 = next;
                            channelsKt__Channels_commonKt$maxWith$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                            if (hasNext == coroutine_suspended) {
                                receiveChannel2 = receiveChannel2;
                                obj2 = next;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return obj2;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    return null;
                }
                next = channelIterator2.next();
                th2 = th3;
                receiveChannel4 = receiveChannel5;
                channelIterator = channelIterator2;
                channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator2;
                channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$maxWith$1.L$3 = th2;
                channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel4;
                channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator;
                channelsKt__Channels_commonKt$maxWith$1.L$6 = next;
                channelsKt__Channels_commonKt$maxWith$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                if (hasNext == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__Channels_commonKt$maxWith$1 = new ChannelsKt__Channels_commonKt$maxWith$1(continuation);
        obj = channelsKt__Channels_commonKt$maxWith$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$maxWith$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    public static final <E, R extends Comparable<? super R>> Object minBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$minBy$1 channelsKt__Channels_commonKt$minBy$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Function1<? super E, ? extends R> function12;
        Throwable th2;
        ChannelIterator channelIterator;
        Comparable comparable;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel3;
        Object hasNext;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Function1<? super E, ? extends R> function13;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel7 = receiveChannel;
        if (continuation instanceof ChannelsKt__Channels_commonKt$minBy$1) {
            channelsKt__Channels_commonKt$minBy$1 = (ChannelsKt__Channels_commonKt$minBy$1) continuation;
            if ((channelsKt__Channels_commonKt$minBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$minBy$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$minBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$minBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$minBy$1.L$0 = receiveChannel7;
                        channelsKt__Channels_commonKt$minBy$1.L$1 = function1;
                        channelsKt__Channels_commonKt$minBy$1.L$2 = receiveChannel7;
                        channelsKt__Channels_commonKt$minBy$1.L$3 = th4;
                        channelsKt__Channels_commonKt$minBy$1.L$4 = receiveChannel7;
                        channelsKt__Channels_commonKt$minBy$1.L$5 = it2;
                        channelsKt__Channels_commonKt$minBy$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$minBy$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel5 = receiveChannel7;
                        function13 = function1;
                        receiveChannel6 = receiveChannel5;
                        th3 = th4;
                        channelIterator = it2;
                        obj = hasNext2;
                        th2 = th3;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$minBy$1.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$4;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$minBy$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$2;
                    function13 = (Function1) channelsKt__Channels_commonKt$minBy$1.L$1;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        th3 = th6;
                        channelIterator = channelIterator3;
                        receiveChannel7 = receiveChannel8;
                        th2 = th3;
                        if (((Boolean) obj).booleanValue()) {
                            InlineMarker.finallyStart(3);
                            ChannelsKt.cancelConsumed(receiveChannel7, th2);
                            InlineMarker.finallyEnd(3);
                            return null;
                        }
                        Object next = channelIterator.next();
                        comparable = (Comparable) function13.invoke(next);
                        receiveChannel2 = receiveChannel5;
                        function12 = function13;
                        obj2 = next;
                        receiveChannel3 = receiveChannel6;
                        channelsKt__Channels_commonKt$minBy$1.L$0 = receiveChannel2;
                        channelsKt__Channels_commonKt$minBy$1.L$1 = function12;
                        channelsKt__Channels_commonKt$minBy$1.L$2 = receiveChannel7;
                        channelsKt__Channels_commonKt$minBy$1.L$3 = th2;
                        channelsKt__Channels_commonKt$minBy$1.L$4 = receiveChannel3;
                        channelsKt__Channels_commonKt$minBy$1.L$5 = channelIterator;
                        channelsKt__Channels_commonKt$minBy$1.L$6 = obj2;
                        channelsKt__Channels_commonKt$minBy$1.L$7 = comparable;
                        channelsKt__Channels_commonKt$minBy$1.label = 2;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$minBy$1);
                        if (hasNext == coroutine_suspended) {
                            channelIterator2 = channelIterator;
                            receiveChannel4 = receiveChannel3;
                            obj = hasNext;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel7 = receiveChannel8;
                        throw th;
                    }
                } else if (i == 2) {
                    Comparable comparable2 = (Comparable) channelsKt__Channels_commonKt$minBy$1.L$7;
                    obj2 = channelsKt__Channels_commonKt$minBy$1.L$6;
                    ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__Channels_commonKt$minBy$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$minBy$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$2;
                    function12 = (Function1) channelsKt__Channels_commonKt$minBy$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        channelIterator2 = channelIterator4;
                        comparable = comparable2;
                        receiveChannel7 = receiveChannel9;
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel7 = receiveChannel9;
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel7, th);
                            InlineMarker.finallyEnd(1);
                            throw th9;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next2 = channelIterator2.next();
                    Comparable comparable3 = (Comparable) function12.invoke(next2);
                    if (comparable.compareTo(comparable3) > 0) {
                        obj2 = next2;
                        comparable = comparable3;
                    }
                    receiveChannel3 = receiveChannel4;
                    channelIterator = channelIterator2;
                    th2 = th2;
                    channelsKt__Channels_commonKt$minBy$1.L$0 = receiveChannel2;
                    channelsKt__Channels_commonKt$minBy$1.L$1 = function12;
                    channelsKt__Channels_commonKt$minBy$1.L$2 = receiveChannel7;
                    channelsKt__Channels_commonKt$minBy$1.L$3 = th2;
                    channelsKt__Channels_commonKt$minBy$1.L$4 = receiveChannel3;
                    channelsKt__Channels_commonKt$minBy$1.L$5 = channelIterator;
                    channelsKt__Channels_commonKt$minBy$1.L$6 = obj2;
                    channelsKt__Channels_commonKt$minBy$1.L$7 = comparable;
                    channelsKt__Channels_commonKt$minBy$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$minBy$1);
                    if (hasNext == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                InlineMarker.finallyStart(2);
                ChannelsKt.cancelConsumed(receiveChannel7, th2);
                InlineMarker.finallyEnd(2);
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$minBy$1 = new ChannelsKt__Channels_commonKt$minBy$1(continuation);
        obj = channelsKt__Channels_commonKt$minBy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$minBy$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel7, th2);
        InlineMarker.finallyEnd(2);
        return obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E> Object minWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$minWith$1 channelsKt__Channels_commonKt$minWith$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        Comparator<? super E> comparator2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object next;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$minWith$1) {
            channelsKt__Channels_commonKt$minWith$1 = (ChannelsKt__Channels_commonKt$minWith$1) continuation;
            if ((channelsKt__Channels_commonKt$minWith$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$minWith$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$minWith$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$minWith$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$minWith$1.L$1 = comparator;
                        channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$minWith$1.L$3 = th3;
                        channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$minWith$1.L$5 = it2;
                        channelsKt__Channels_commonKt$minWith$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$minWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel3 = receiveChannel;
                        comparator2 = comparator;
                        receiveChannel5 = receiveChannel3;
                        channelIterator2 = it2;
                        obj = hasNext2;
                        receiveChannel2 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                    th3 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                    comparator2 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    Object obj2 = channelsKt__Channels_commonKt$minWith$1.L$6;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                    comparator2 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator.next();
                            if (comparator2.compare(obj2, next) <= 0) {
                                next = obj2;
                            }
                            channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$minWith$1.L$1 = comparator2;
                            channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
                            channelsKt__Channels_commonKt$minWith$1.L$3 = th2;
                            channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator;
                            channelsKt__Channels_commonKt$minWith$1.L$6 = next;
                            channelsKt__Channels_commonKt$minWith$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$minWith$1);
                            if (hasNext == coroutine_suspended) {
                                receiveChannel2 = receiveChannel2;
                                obj2 = next;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        return obj2;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    return null;
                }
                next = channelIterator2.next();
                th2 = th3;
                receiveChannel4 = receiveChannel5;
                channelIterator = channelIterator2;
                channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$minWith$1.L$1 = comparator2;
                channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel2;
                channelsKt__Channels_commonKt$minWith$1.L$3 = th2;
                channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel4;
                channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator;
                channelsKt__Channels_commonKt$minWith$1.L$6 = next;
                channelsKt__Channels_commonKt$minWith$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$minWith$1);
                if (hasNext == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__Channels_commonKt$minWith$1 = new ChannelsKt__Channels_commonKt$minWith$1(continuation);
        obj = channelsKt__Channels_commonKt$minWith$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$minWith$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$none$1 channelsKt__Channels_commonKt$none$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        Object obj;
        if (continuation instanceof ChannelsKt__Channels_commonKt$none$1) {
            channelsKt__Channels_commonKt$none$1 = (ChannelsKt__Channels_commonKt$none$1) continuation;
            if ((channelsKt__Channels_commonKt$none$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$none$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$none$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$none$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    th2 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$none$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.L$2 = th2;
                        channelsKt__Channels_commonKt$none$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.label = 1;
                        obj = it2.hasNext(channelsKt__Channels_commonKt$none$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$3;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$none$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        obj = obj2;
                        th2 = th4;
                        receiveChannel = receiveChannel2;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th6;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    z = false;
                }
                Boolean boxBoolean = Boxing.boxBoolean(z);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                return boxBoolean;
            }
        }
        channelsKt__Channels_commonKt$none$1 = new ChannelsKt__Channels_commonKt$none$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$none$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$none$1.label;
        boolean z = true;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        Boolean boxBoolean = Boxing.boxBoolean(z);
        ChannelsKt.cancelConsumed(receiveChannel, th2);
        return boxBoolean;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$none$3 channelsKt__Channels_commonKt$none$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$none$3 channelsKt__Channels_commonKt$none$32;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$none$3) {
            channelsKt__Channels_commonKt$none$3 = (ChannelsKt__Channels_commonKt$none$3) continuation;
            if ((channelsKt__Channels_commonKt$none$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$none$3.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$none$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$none$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    try {
                        th3 = null;
                        channelsKt__Channels_commonKt$none$32 = channelsKt__Channels_commonKt$none$3;
                        obj2 = coroutine_suspended;
                        receiveChannel6 = receiveChannel;
                        receiveChannel2 = receiveChannel6;
                        receiveChannel5 = receiveChannel2;
                        channelIterator2 = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$none$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$5;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$none$3.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$none$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        th2 = th5;
                        function12 = function13;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$none$32 = channelsKt__Channels_commonKt$none$3;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (((Boolean) obj3).booleanValue()) {
                            if (!function12.invoke((Object) channelIterator.next()).booleanValue()) {
                                receiveChannel6 = receiveChannel4;
                                obj2 = obj;
                                th3 = th2;
                                channelIterator2 = channelIterator;
                            }
                            Boolean boxBoolean = Boxing.boxBoolean(false);
                            InlineMarker.finallyStart(2);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(2);
                            return boxBoolean;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxBoolean(true);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$none$32.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$none$32.L$1 = function12;
                channelsKt__Channels_commonKt$none$32.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$none$32.L$3 = receiveChannel2;
                channelsKt__Channels_commonKt$none$32.L$4 = th3;
                channelsKt__Channels_commonKt$none$32.L$5 = receiveChannel5;
                channelsKt__Channels_commonKt$none$32.L$6 = channelIterator2;
                channelsKt__Channels_commonKt$none$32.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$none$32);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxBoolean(true);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$none$3 = new ChannelsKt__Channels_commonKt$none$3(continuation);
        Object obj3 = channelsKt__Channels_commonKt$none$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$none$3.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$none$32.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$none$32.L$1 = function12;
            channelsKt__Channels_commonKt$none$32.L$2 = receiveChannel6;
            channelsKt__Channels_commonKt$none$32.L$3 = receiveChannel2;
            channelsKt__Channels_commonKt$none$32.L$4 = th3;
            channelsKt__Channels_commonKt$none$32.L$5 = receiveChannel5;
            channelsKt__Channels_commonKt$none$32.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$none$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$none$32);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <S, E extends S> Object reduce(ReceiveChannel<? extends E> receiveChannel, Function2<? super S, ? super E, ? extends S> function2, Continuation<? super S> continuation) {
        ChannelsKt__Channels_commonKt$reduce$1 channelsKt__Channels_commonKt$reduce$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        Function2<? super S, ? super E, ? extends S> function22;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object invoke;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel7;
        Function2<? super S, ? super E, ? extends S> function23;
        Throwable th3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$reduce$1) {
            channelsKt__Channels_commonKt$reduce$1 = (ChannelsKt__Channels_commonKt$reduce$1) continuation;
            if ((channelsKt__Channels_commonKt$reduce$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$reduce$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$reduce$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$reduce$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$reduce$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$reduce$1.L$1 = function2;
                        channelsKt__Channels_commonKt$reduce$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$reduce$1.L$3 = th3;
                        channelsKt__Channels_commonKt$reduce$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$reduce$1.L$5 = it2;
                        channelsKt__Channels_commonKt$reduce$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$reduce$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel7 = receiveChannel;
                        function23 = function2;
                        receiveChannel6 = receiveChannel7;
                        channelIterator2 = it2;
                        obj = hasNext2;
                        receiveChannel2 = receiveChannel6;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$reduce$1.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$4;
                    th3 = (Throwable) channelsKt__Channels_commonKt$reduce$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$2;
                    function23 = (Function2) channelsKt__Channels_commonKt$reduce$1.L$1;
                    receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else if (i == 2) {
                    Object obj2 = channelsKt__Channels_commonKt$reduce$1.L$6;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$reduce$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$reduce$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$2;
                    function22 = (Function2) channelsKt__Channels_commonKt$reduce$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            invoke = function22.invoke(obj2, (Object) channelIterator.next());
                            receiveChannel5 = receiveChannel8;
                            channelsKt__Channels_commonKt$reduce$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$reduce$1.L$1 = function22;
                            channelsKt__Channels_commonKt$reduce$1.L$2 = receiveChannel5;
                            channelsKt__Channels_commonKt$reduce$1.L$3 = th2;
                            channelsKt__Channels_commonKt$reduce$1.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$reduce$1.L$5 = channelIterator;
                            channelsKt__Channels_commonKt$reduce$1.L$6 = invoke;
                            channelsKt__Channels_commonKt$reduce$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$reduce$1);
                            if (hasNext == coroutine_suspended) {
                                receiveChannel8 = receiveChannel5;
                                obj2 = invoke;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        InlineMarker.finallyStart(2);
                        ChannelsKt.cancelConsumed(receiveChannel8, th2);
                        InlineMarker.finallyEnd(2);
                        return obj2;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel8;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    invoke = channelIterator2.next();
                    receiveChannel3 = receiveChannel7;
                    function22 = function23;
                    channelIterator = channelIterator2;
                    receiveChannel5 = receiveChannel2;
                    th2 = th3;
                    receiveChannel4 = receiveChannel6;
                    channelsKt__Channels_commonKt$reduce$1.L$0 = receiveChannel3;
                    channelsKt__Channels_commonKt$reduce$1.L$1 = function22;
                    channelsKt__Channels_commonKt$reduce$1.L$2 = receiveChannel5;
                    channelsKt__Channels_commonKt$reduce$1.L$3 = th2;
                    channelsKt__Channels_commonKt$reduce$1.L$4 = receiveChannel4;
                    channelsKt__Channels_commonKt$reduce$1.L$5 = channelIterator;
                    channelsKt__Channels_commonKt$reduce$1.L$6 = invoke;
                    channelsKt__Channels_commonKt$reduce$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$reduce$1);
                    if (hasNext == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw new UnsupportedOperationException("Empty channel can't be reduced.");
            }
        }
        channelsKt__Channels_commonKt$reduce$1 = new ChannelsKt__Channels_commonKt$reduce$1(continuation);
        obj = channelsKt__Channels_commonKt$reduce$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$reduce$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <S, E extends S> Object reduceIndexed(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super S, ? super E, ? extends S> function3, Continuation<? super S> continuation) {
        ChannelsKt__Channels_commonKt$reduceIndexed$1 channelsKt__Channels_commonKt$reduceIndexed$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        int i2;
        ReceiveChannel<? extends E> receiveChannel3;
        Function3<? super Integer, ? super S, ? super E, ? extends S> function32;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator channelIterator;
        Object invoke;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel7;
        Function3<? super Integer, ? super S, ? super E, ? extends S> function33;
        Throwable th3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$reduceIndexed$1) {
            channelsKt__Channels_commonKt$reduceIndexed$1 = (ChannelsKt__Channels_commonKt$reduceIndexed$1) continuation;
            if ((channelsKt__Channels_commonKt$reduceIndexed$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$reduceIndexed$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$reduceIndexed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$reduceIndexed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th3 = null;
                    try {
                        ChannelIterator<? extends E> it2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$1 = function3;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$3 = th3;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$5 = it2;
                        channelsKt__Channels_commonKt$reduceIndexed$1.label = 1;
                        Object hasNext2 = it2.hasNext(channelsKt__Channels_commonKt$reduceIndexed$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel7 = receiveChannel;
                        function33 = function3;
                        receiveChannel6 = receiveChannel7;
                        channelIterator2 = it2;
                        obj = hasNext2;
                        receiveChannel2 = receiveChannel6;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th5;
                        }
                    }
                } else if (i == 1) {
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$reduceIndexed$1.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$4;
                    th3 = (Throwable) channelsKt__Channels_commonKt$reduceIndexed$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$2;
                    function33 = (Function3) channelsKt__Channels_commonKt$reduceIndexed$1.L$1;
                    receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else if (i == 2) {
                    Object obj2 = channelsKt__Channels_commonKt$reduceIndexed$1.L$6;
                    i2 = channelsKt__Channels_commonKt$reduceIndexed$1.I$0;
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$reduceIndexed$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$reduceIndexed$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$2;
                    function32 = (Function3) channelsKt__Channels_commonKt$reduceIndexed$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            Integer boxInt = Boxing.boxInt(i2);
                            i2++;
                            invoke = function32.invoke(boxInt, obj2, (Object) channelIterator.next());
                            receiveChannel5 = receiveChannel8;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$1 = function32;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$2 = receiveChannel5;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$3 = th2;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$5 = channelIterator;
                            channelsKt__Channels_commonKt$reduceIndexed$1.I$0 = i2;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$6 = invoke;
                            channelsKt__Channels_commonKt$reduceIndexed$1.label = 2;
                            hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$reduceIndexed$1);
                            if (hasNext == coroutine_suspended) {
                                receiveChannel8 = receiveChannel5;
                                obj2 = invoke;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        InlineMarker.finallyStart(2);
                        ChannelsKt.cancelConsumed(receiveChannel8, th2);
                        InlineMarker.finallyEnd(2);
                        return obj2;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel8;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    invoke = channelIterator2.next();
                    function32 = function33;
                    receiveChannel3 = receiveChannel7;
                    th2 = th3;
                    channelIterator = channelIterator2;
                    receiveChannel5 = receiveChannel2;
                    receiveChannel4 = receiveChannel6;
                    i2 = 1;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$0 = receiveChannel3;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$1 = function32;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$2 = receiveChannel5;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$3 = th2;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$4 = receiveChannel4;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$5 = channelIterator;
                    channelsKt__Channels_commonKt$reduceIndexed$1.I$0 = i2;
                    channelsKt__Channels_commonKt$reduceIndexed$1.L$6 = invoke;
                    channelsKt__Channels_commonKt$reduceIndexed$1.label = 2;
                    hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$reduceIndexed$1);
                    if (hasNext == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                throw new UnsupportedOperationException("Empty channel can't be reduced.");
            }
        }
        channelsKt__Channels_commonKt$reduceIndexed$1 = new ChannelsKt__Channels_commonKt$reduceIndexed$1(continuation);
        obj = channelsKt__Channels_commonKt$reduceIndexed$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$reduceIndexed$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object sumBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Integer> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$sumBy$1 channelsKt__Channels_commonKt$sumBy$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        Ref.IntRef intRef;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$sumBy$1 channelsKt__Channels_commonKt$sumBy$12;
        Function1<? super E, Integer> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        Ref.IntRef intRef2;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$sumBy$1) {
            channelsKt__Channels_commonKt$sumBy$1 = (ChannelsKt__Channels_commonKt$sumBy$1) continuation;
            if ((channelsKt__Channels_commonKt$sumBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$sumBy$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$sumBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$sumBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        intRef2 = intRef3;
                        obj2 = coroutine_suspended;
                        th3 = null;
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        function12 = function1;
                        receiveChannel3 = receiveChannel5;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$sumBy$12 = channelsKt__Channels_commonKt$sumBy$1;
                        receiveChannel2 = receiveChannel3;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$sumBy$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$sumBy$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$3;
                    Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$sumBy$1.L$2;
                    Function1<? super E, Integer> function13 = (Function1) channelsKt__Channels_commonKt$sumBy$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        intRef = intRef4;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$sumBy$12 = channelsKt__Channels_commonKt$sumBy$1;
                        receiveChannel2 = receiveChannel8;
                        th2 = th5;
                        function12 = function13;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            intRef.element += function12.invoke((Object) channelIterator.next()).intValue();
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            intRef2 = intRef;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxInt(intRef.element);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$sumBy$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$sumBy$12.L$1 = function12;
                channelsKt__Channels_commonKt$sumBy$12.L$2 = intRef2;
                channelsKt__Channels_commonKt$sumBy$12.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$sumBy$12.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$sumBy$12.L$5 = th3;
                channelsKt__Channels_commonKt$sumBy$12.L$6 = receiveChannel5;
                channelsKt__Channels_commonKt$sumBy$12.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$sumBy$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$sumBy$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    intRef = intRef2;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxInt(intRef.element);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$sumBy$1 = new ChannelsKt__Channels_commonKt$sumBy$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$sumBy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$sumBy$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$sumBy$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$sumBy$12.L$1 = function12;
            channelsKt__Channels_commonKt$sumBy$12.L$2 = intRef2;
            channelsKt__Channels_commonKt$sumBy$12.L$3 = receiveChannel6;
            channelsKt__Channels_commonKt$sumBy$12.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$sumBy$12.L$5 = th3;
            channelsKt__Channels_commonKt$sumBy$12.L$6 = receiveChannel5;
            channelsKt__Channels_commonKt$sumBy$12.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$sumBy$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$sumBy$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0 A[Catch:{ all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad A[Catch:{ all -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public static final <E> Object sumByDouble(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Double> function1, Continuation<? super Double> continuation) {
        ChannelsKt__Channels_commonKt$sumByDouble$1 channelsKt__Channels_commonKt$sumByDouble$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Ref.DoubleRef doubleRef;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        Object obj;
        ChannelsKt__Channels_commonKt$sumByDouble$1 channelsKt__Channels_commonKt$sumByDouble$12;
        Function1<? super E, Double> function12;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$sumByDouble$1) {
            channelsKt__Channels_commonKt$sumByDouble$1 = (ChannelsKt__Channels_commonKt$sumByDouble$1) continuation;
            if ((channelsKt__Channels_commonKt$sumByDouble$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$sumByDouble$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$sumByDouble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$sumByDouble$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.DoubleRef doubleRef2 = new Ref.DoubleRef();
                    doubleRef2.element = 0.0d;
                    try {
                        doubleRef = doubleRef2;
                        channelsKt__Channels_commonKt$sumByDouble$12 = channelsKt__Channels_commonKt$sumByDouble$1;
                        obj = coroutine_suspended;
                        th3 = null;
                        channelIterator2 = receiveChannel.iterator();
                        receiveChannel6 = receiveChannel;
                        receiveChannel5 = receiveChannel6;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel4 = receiveChannel2;
                        function12 = function1;
                    } catch (Throwable th4) {
                        th2 = th4;
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$sumByDouble$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$6;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$sumByDouble$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$3;
                    Ref.DoubleRef doubleRef3 = (Ref.DoubleRef) channelsKt__Channels_commonKt$sumByDouble$1.L$2;
                    Function1<? super E, Double> function13 = (Function1) channelsKt__Channels_commonKt$sumByDouble$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$sumByDouble$12 = channelsKt__Channels_commonKt$sumByDouble$1;
                        receiveChannel5 = receiveChannel9;
                        channelIterator = channelIterator3;
                        receiveChannel4 = receiveChannel7;
                        function12 = function13;
                        doubleRef = doubleRef3;
                        th3 = th5;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel8;
                        if (!((Boolean) obj2).booleanValue()) {
                            doubleRef.element += function12.invoke((Object) channelIterator.next()).doubleValue();
                            receiveChannel6 = receiveChannel3;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th3);
                        InlineMarker.finallyEnd(1);
                        return Boxing.boxDouble(doubleRef.element);
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th7;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$sumByDouble$12.L$0 = receiveChannel6;
                channelsKt__Channels_commonKt$sumByDouble$12.L$1 = function12;
                channelsKt__Channels_commonKt$sumByDouble$12.L$2 = doubleRef;
                channelsKt__Channels_commonKt$sumByDouble$12.L$3 = receiveChannel5;
                channelsKt__Channels_commonKt$sumByDouble$12.L$4 = receiveChannel2;
                channelsKt__Channels_commonKt$sumByDouble$12.L$5 = th3;
                channelsKt__Channels_commonKt$sumByDouble$12.L$6 = receiveChannel4;
                channelsKt__Channels_commonKt$sumByDouble$12.L$7 = channelIterator2;
                channelsKt__Channels_commonKt$sumByDouble$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$sumByDouble$12);
                if (hasNext == obj) {
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th3);
                    InlineMarker.finallyEnd(1);
                    return Boxing.boxDouble(doubleRef.element);
                }
                return obj;
            }
        }
        channelsKt__Channels_commonKt$sumByDouble$1 = new ChannelsKt__Channels_commonKt$sumByDouble$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$sumByDouble$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$sumByDouble$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$sumByDouble$12.L$0 = receiveChannel6;
            channelsKt__Channels_commonKt$sumByDouble$12.L$1 = function12;
            channelsKt__Channels_commonKt$sumByDouble$12.L$2 = doubleRef;
            channelsKt__Channels_commonKt$sumByDouble$12.L$3 = receiveChannel5;
            channelsKt__Channels_commonKt$sumByDouble$12.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$sumByDouble$12.L$5 = th3;
            channelsKt__Channels_commonKt$sumByDouble$12.L$6 = receiveChannel4;
            channelsKt__Channels_commonKt$sumByDouble$12.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$sumByDouble$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$sumByDouble$12);
            if (hasNext == obj) {
            }
            return obj;
        } catch (Throwable th8) {
            th2 = th8;
            th = th2;
            throw th;
        }
    }

    public static final <E> ReceiveChannel<E> requireNoNulls(ReceiveChannel<? extends E> receiveChannel) {
        return map$default(receiveChannel, null, new ChannelsKt__Channels_commonKt$requireNoNulls$1(receiveChannel, null), 1, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f A[Catch:{ all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae A[Catch:{ all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <E> Object partition(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> continuation) {
        ChannelsKt__Channels_commonKt$partition$1 channelsKt__Channels_commonKt$partition$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ArrayList arrayList;
        ArrayList arrayList2;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelsKt__Channels_commonKt$partition$1 channelsKt__Channels_commonKt$partition$12;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj2;
        Throwable th3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$partition$1) {
            channelsKt__Channels_commonKt$partition$1 = (ChannelsKt__Channels_commonKt$partition$1) continuation;
            if ((channelsKt__Channels_commonKt$partition$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$partition$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$partition$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$partition$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Throwable th4 = null;
                    try {
                        arrayList4 = new ArrayList();
                        arrayList3 = new ArrayList();
                        th3 = th4;
                        receiveChannel6 = receiveChannel;
                        function12 = function1;
                        channelsKt__Channels_commonKt$partition$12 = channelsKt__Channels_commonKt$partition$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel2 = receiveChannel3;
                        channelIterator2 = receiveChannel.iterator();
                        obj2 = coroutine_suspended;
                        receiveChannel5 = receiveChannel2;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$partition$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$7;
                    Throwable th6 = (Throwable) channelsKt__Channels_commonKt$partition$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$5;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$4;
                    ArrayList arrayList5 = (ArrayList) channelsKt__Channels_commonKt$partition$1.L$3;
                    ArrayList arrayList6 = (ArrayList) channelsKt__Channels_commonKt$partition$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$partition$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        receiveChannel5 = receiveChannel7;
                        receiveChannel3 = receiveChannel9;
                        arrayList = arrayList6;
                        th2 = th6;
                        function12 = function13;
                        arrayList2 = arrayList5;
                        obj = coroutine_suspended;
                        channelsKt__Channels_commonKt$partition$12 = channelsKt__Channels_commonKt$partition$1;
                        receiveChannel2 = receiveChannel8;
                        channelIterator = channelIterator3;
                        if (!((Boolean) obj3).booleanValue()) {
                            Object obj4 = (Object) channelIterator.next();
                            if (function12.invoke(obj4).booleanValue()) {
                                arrayList.add(obj4);
                            } else {
                                arrayList2.add(obj4);
                            }
                            receiveChannel6 = receiveChannel4;
                            obj2 = obj;
                            th3 = th2;
                            arrayList3 = arrayList2;
                            arrayList4 = arrayList;
                            channelIterator2 = channelIterator;
                        }
                        Unit unit = Unit.INSTANCE;
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        InlineMarker.finallyEnd(1);
                        return new Pair(arrayList, arrayList2);
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel8;
                        try {
                            throw th;
                        } catch (Throwable th8) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                            throw th8;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelsKt__Channels_commonKt$partition$12.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$partition$12.L$1 = function12;
                channelsKt__Channels_commonKt$partition$12.L$2 = arrayList4;
                channelsKt__Channels_commonKt$partition$12.L$3 = arrayList3;
                channelsKt__Channels_commonKt$partition$12.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$partition$12.L$5 = receiveChannel2;
                channelsKt__Channels_commonKt$partition$12.L$6 = th3;
                channelsKt__Channels_commonKt$partition$12.L$7 = receiveChannel5;
                channelsKt__Channels_commonKt$partition$12.L$8 = channelIterator2;
                channelsKt__Channels_commonKt$partition$12.label = 1;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$partition$12);
                if (hasNext == obj2) {
                    receiveChannel4 = receiveChannel6;
                    obj3 = hasNext;
                    arrayList = arrayList4;
                    arrayList2 = arrayList3;
                    th2 = th3;
                    obj = obj2;
                    channelIterator = channelIterator2;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    InlineMarker.finallyEnd(1);
                    return new Pair(arrayList, arrayList2);
                }
                return obj2;
            }
        }
        channelsKt__Channels_commonKt$partition$1 = new ChannelsKt__Channels_commonKt$partition$1(continuation);
        Object obj3 = channelsKt__Channels_commonKt$partition$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$partition$1.label;
        if (i != 0) {
        }
        try {
            channelsKt__Channels_commonKt$partition$12.L$0 = receiveChannel3;
            channelsKt__Channels_commonKt$partition$12.L$1 = function12;
            channelsKt__Channels_commonKt$partition$12.L$2 = arrayList4;
            channelsKt__Channels_commonKt$partition$12.L$3 = arrayList3;
            channelsKt__Channels_commonKt$partition$12.L$4 = receiveChannel6;
            channelsKt__Channels_commonKt$partition$12.L$5 = receiveChannel2;
            channelsKt__Channels_commonKt$partition$12.L$6 = th3;
            channelsKt__Channels_commonKt$partition$12.L$7 = receiveChannel5;
            channelsKt__Channels_commonKt$partition$12.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$partition$12.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$partition$12);
            if (hasNext == obj2) {
            }
            return obj2;
        } catch (Throwable th9) {
            th = th9;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        throw r9;
     */
    private static final Object partition$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return new Pair(arrayList, arrayList2);
            }
        }
    }

    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2) {
        return zip$default(receiveChannel, receiveChannel2, null, ChannelsKt__Channels_commonKt$zip$1.INSTANCE, 2, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new ChannelsKt__Channels_commonKt$zip$2(receiveChannel, receiveChannel2, function2, null), 6, null);
    }

    private static final Object consumeEach$$forInline(BroadcastChannel broadcastChannel, Function1 function1, Continuation continuation) {
        ReceiveChannel openSubscription = broadcastChannel.openSubscription();
        CancellationException cancellationException = null;
        int i = 1;
        try {
            ChannelIterator it2 = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it2.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    return Unit.INSTANCE;
                }
                function1.invoke(it2.next());
            }
        } finally {
            InlineMarker.finallyStart(i);
            ReceiveChannel.DefaultImpls.cancel$default(openSubscription, cancellationException, i, (Object) cancellationException);
            InlineMarker.finallyEnd(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        throw r6;
     */
    private static final Object consumeEach$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                function1.invoke(it2.next());
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return unit;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        throw r10;
     */
    private static final Object consumeEachIndexed$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                function1.invoke(new IndexedValue(i, it2.next()));
                i++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        throw r9;
     */
    private static final Object elementAtOrElse$$forInline(ReceiveChannel receiveChannel, int i, Function1 function1, Continuation continuation) {
        Object invoke;
        int i2;
        Throwable th = null;
        if (i >= 0) {
            ChannelIterator it2 = receiveChannel.iterator();
            int i3 = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it2.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    invoke = function1.invoke(Integer.valueOf(i));
                    i2 = 2;
                    InlineMarker.finallyStart(2);
                    break;
                }
                Object next = it2.next();
                int i4 = i3 + 1;
                if (i == i3) {
                    InlineMarker.finallyStart(3);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(3);
                    return next;
                }
                i3 = i4;
            }
        } else {
            invoke = function1.invoke(Integer.valueOf(i));
            i2 = 4;
            InlineMarker.finallyStart(4);
        }
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(i2);
        return invoke;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        throw r8;
     */
    private static final Object find$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object next;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                next = it2.next();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return null;
            }
        } while (!((Boolean) function1.invoke(next)).booleanValue());
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(2);
        return next;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        throw r8;
     */
    private static final Object findLast$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    obj = next;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        throw r7;
     */
    private static final Object first$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object next;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                next = it2.next();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
            }
        } while (!((Boolean) function1.invoke(next)).booleanValue());
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(2);
        return next;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        throw r8;
     */
    private static final Object firstOrNull$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object next;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                next = it2.next();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return null;
            }
        } while (!((Boolean) function1.invoke(next)).booleanValue());
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(2);
        return next;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        throw r8;
     */
    private static final Object indexOfFirst$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return -1;
            } else if (((Boolean) function1.invoke(it2.next())).booleanValue()) {
                Integer valueOf = Integer.valueOf(i);
                InlineMarker.finallyStart(2);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(2);
                return valueOf;
            } else {
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        throw r9;
     */
    private static final Object indexOfLast$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = -1;
        int i2 = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                if (((Boolean) function1.invoke(it2.next())).booleanValue()) {
                    i = i2;
                }
                i2++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return Integer.valueOf(i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        throw r10;
     */
    private static final Object last$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        boolean z = false;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                break;
            }
            Object next = it2.next();
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                obj = next;
                z = true;
            }
        }
        Unit unit = Unit.INSTANCE;
        InlineMarker.finallyStart(1);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(1);
        if (z) {
            return obj;
        }
        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        throw r8;
     */
    private static final Object lastOrNull$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    obj = next;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        throw r10;
     */
    private static final Object single$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        boolean z = false;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    if (!z) {
                        obj = next;
                        z = true;
                    } else {
                        throw new IllegalArgumentException("ReceiveChannel contains more than one matching element.");
                    }
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                if (z) {
                    return obj;
                }
                throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r10);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        throw r11;
     */
    private static final Object singleOrNull$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        Object obj = null;
        boolean z = false;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    if (z) {
                        InlineMarker.finallyStart(2);
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        InlineMarker.finallyEnd(2);
                        return null;
                    }
                    obj = next;
                    z = true;
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                if (!z) {
                    return null;
                }
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        throw r10;
     */
    private static final Object filterIndexedTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, it2.next());
                int component1 = indexedValue.component1();
                Object component2 = indexedValue.component2();
                if (((Boolean) function2.invoke(Integer.valueOf(component1), component2)).booleanValue()) {
                    collection.add(component2);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        throw r10;
     */
    private static final Object filterIndexedTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, it2.next());
                int component1 = indexedValue.component1();
                Object component2 = indexedValue.component2();
                if (((Boolean) function2.invoke(Integer.valueOf(component1), component2)).booleanValue()) {
                    InlineMarker.mark(0);
                    sendChannel.send(component2, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        throw r7;
     */
    private static final Object filterNotTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (!((Boolean) function1.invoke(next)).booleanValue()) {
                    collection.add(next);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        throw r8;
     */
    private static final Object filterNotTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (!((Boolean) function1.invoke(next)).booleanValue()) {
                    InlineMarker.mark(0);
                    sendChannel.send(next, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        throw r7;
     */
    private static final Object filterTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    collection.add(next);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        throw r8;
     */
    private static final Object filterTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    InlineMarker.mark(0);
                    sendChannel.send(next, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        throw r7;
     */
    private static final Object associateByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                map.put(function1.invoke(next), next);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return map;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r7;
     */
    private static final Object associateByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Function1 function12, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                map.put(function1.invoke(next), function12.invoke(next));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return map;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        throw r7;
     */
    private static final Object associateTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Pair pair = (Pair) function1.invoke(it2.next());
                map.put(pair.getFirst(), pair.getSecond());
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return map;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        throw r8;
     */
    private static final Object groupByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                Object invoke = function1.invoke(next);
                Object obj = map.get(invoke);
                if (obj == null) {
                    obj = new ArrayList();
                    map.put(invoke, obj);
                }
                ((List) obj).add(next);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return map;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        throw r8;
     */
    private static final Object groupByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Function1 function12, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object next = it2.next();
                Object invoke = function1.invoke(next);
                Object obj = map.get(invoke);
                if (obj == null) {
                    obj = new ArrayList();
                    map.put(invoke, obj);
                }
                ((List) obj).add(function12.invoke(next));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return map;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        throw r10;
     */
    private static final Object mapIndexedNotNullTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, it2.next());
                Object invoke = function2.invoke(Integer.valueOf(indexedValue.component1()), indexedValue.component2());
                if (invoke != null) {
                    collection.add(invoke);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        throw r10;
     */
    private static final Object mapIndexedNotNullTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                int i2 = i + 1;
                IndexedValue indexedValue = new IndexedValue(i, it2.next());
                Object invoke = function2.invoke(Integer.valueOf(indexedValue.component1()), indexedValue.component2());
                if (invoke != null) {
                    InlineMarker.mark(0);
                    sendChannel.send(invoke, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        throw r9;
     */
    private static final Object mapIndexedTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                collection.add(function2.invoke(Integer.valueOf(i), it2.next()));
                i++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        throw r9;
     */
    private static final Object mapIndexedTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                int i2 = i + 1;
                Object invoke = function2.invoke(Integer.valueOf(i), it2.next());
                InlineMarker.mark(0);
                sendChannel.send(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
                i = i2;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        throw r6;
     */
    private static final Object mapNotNullTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object invoke = function1.invoke(it2.next());
                if (invoke != null) {
                    collection.add(invoke);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        throw r7;
     */
    private static final Object mapNotNullTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object invoke = function1.invoke(it2.next());
                if (invoke != null) {
                    InlineMarker.mark(0);
                    sendChannel.send(invoke, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        throw r6;
     */
    private static final Object mapTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                collection.add(function1.invoke(it2.next()));
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return collection;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        throw r7;
     */
    private static final Object mapTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                Object invoke = function1.invoke(it2.next());
                InlineMarker.mark(0);
                sendChannel.send(invoke, continuation);
                InlineMarker.mark(2);
                InlineMarker.mark(1);
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return sendChannel;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        throw r7;
     */
    private static final Object all$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return true;
            }
        } while (((Boolean) function1.invoke(it2.next())).booleanValue());
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(2);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        throw r7;
     */
    private static final Object any$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return false;
            }
        } while (!((Boolean) function1.invoke(it2.next())).booleanValue());
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        throw r8;
     */
    private static final Object count$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return Integer.valueOf(i);
            } else if (((Boolean) function1.invoke(it2.next())).booleanValue()) {
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        throw r6;
     */
    private static final Object fold$$forInline(ReceiveChannel receiveChannel, Object obj, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                obj = function2.invoke(obj, it2.next());
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        throw r9;
     */
    private static final Object foldIndexed$$forInline(ReceiveChannel receiveChannel, Object obj, Function3 function3, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                obj = function3.invoke(Integer.valueOf(i), obj, it2.next());
                i++;
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r10);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        throw r11;
     */
    private static final Object maxBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        int i;
        Object obj = null;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it2.hasNext(continuation);
        InlineMarker.mark(1);
        if (!((Boolean) hasNext).booleanValue()) {
            i = 3;
            InlineMarker.finallyStart(3);
        } else {
            obj = it2.next();
            Comparable comparable = (Comparable) function1.invoke(obj);
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it2.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext2).booleanValue()) {
                    break;
                }
                Object next = it2.next();
                Comparable comparable2 = (Comparable) function1.invoke(next);
                if (comparable.compareTo(comparable2) < 0) {
                    obj = next;
                    comparable = comparable2;
                }
            }
            i = 2;
            InlineMarker.finallyStart(2);
        }
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(i);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r10);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        throw r11;
     */
    private static final Object minBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        int i;
        Object obj = null;
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it2.hasNext(continuation);
        InlineMarker.mark(1);
        if (!((Boolean) hasNext).booleanValue()) {
            i = 3;
            InlineMarker.finallyStart(3);
        } else {
            obj = it2.next();
            Comparable comparable = (Comparable) function1.invoke(obj);
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it2.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext2).booleanValue()) {
                    break;
                }
                Object next = it2.next();
                Comparable comparable2 = (Comparable) function1.invoke(next);
                if (comparable.compareTo(comparable2) > 0) {
                    obj = next;
                    comparable = comparable2;
                }
            }
            i = 2;
            InlineMarker.finallyStart(2);
        }
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(i);
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        throw r7;
     */
    private static final Object none$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        do {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return true;
            }
        } while (!((Boolean) function1.invoke(it2.next())).booleanValue());
        InlineMarker.finallyStart(2);
        ChannelsKt.cancelConsumed(receiveChannel, th);
        InlineMarker.finallyEnd(2);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        throw r8;
     */
    private static final Object reduce$$forInline(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it2.hasNext(continuation);
        InlineMarker.mark(1);
        if (((Boolean) hasNext).booleanValue()) {
            Object next = it2.next();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it2.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext2).booleanValue()) {
                    next = function2.invoke(next, it2.next());
                } else {
                    InlineMarker.finallyStart(2);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(2);
                    return next;
                }
            }
        } else {
            throw new UnsupportedOperationException("Empty channel can't be reduced.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r9);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        throw r10;
     */
    private static final Object reduceIndexed$$forInline(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        InlineMarker.mark(0);
        Object hasNext = it2.hasNext(continuation);
        InlineMarker.mark(1);
        if (((Boolean) hasNext).booleanValue()) {
            Object next = it2.next();
            int i = 1;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it2.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext2).booleanValue()) {
                    Integer valueOf = Integer.valueOf(i);
                    i++;
                    next = function3.invoke(valueOf, next, it2.next());
                } else {
                    InlineMarker.finallyStart(2);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(2);
                    return next;
                }
            }
        } else {
            throw new UnsupportedOperationException("Empty channel can't be reduced.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        throw r8;
     */
    private static final Object sumBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        int i = 0;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                i += ((Number) function1.invoke(it2.next())).intValue();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return Integer.valueOf(i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r8);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        throw r9;
     */
    private static final Object sumByDouble$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        ChannelIterator it2 = receiveChannel.iterator();
        double d = 0.0d;
        while (true) {
            InlineMarker.mark(0);
            Object hasNext = it2.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                d += ((Number) function1.invoke(it2.next())).doubleValue();
            } else {
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th);
                InlineMarker.finallyEnd(1);
                return Double.valueOf(d);
            }
        }
    }
}
