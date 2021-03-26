package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.TimeSource;
import kotlinx.coroutines.TimeSourceKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: TickerChannels.kt */
public final class TickerChannelsKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j, j2, null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    static final /* synthetic */ Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i;
        long j3;
        long j4;
        long j5;
        SendChannel<? super Unit> sendChannel2;
        long j6;
        long j7;
        long j8;
        SendChannel<? super Unit> sendChannel3;
        long j9;
        long coerceAtLeast;
        long delayNanosToMillis;
        Long boxLong;
        Unit unit;
        SendChannel<? super Unit> sendChannel4;
        Long boxLong2;
        long j10 = j2;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            if ((tickerChannelsKt$fixedPeriodTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                int i2 = 2;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TimeSource timeSource = TimeSourceKt.getTimeSource();
                    long nanoTime = ((timeSource == null || (boxLong2 = Boxing.boxLong(timeSource.nanoTime())) == null) ? System.nanoTime() : boxLong2.longValue()) + EventLoop_commonKt.delayToNanos(j2);
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                    sendChannel4 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = nanoTime;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j10, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j5 = nanoTime;
                    j7 = j;
                } else if (i == 1) {
                    long j11 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    long j12 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j7 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    sendChannel4 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j10 = j12;
                    j5 = j11;
                } else if (i != 2) {
                    if (i == 3) {
                        long j13 = tickerChannelsKt$fixedPeriodTicker$1.J$6;
                        long j14 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                        long j15 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i == 4) {
                        long j16 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                        long j17 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                        j6 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                        j5 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                        sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j7 = j3;
                    j8 = j6;
                    j10 = j4;
                    sendChannel3 = sendChannel2;
                    i2 = 2;
                    j9 = j5 + j8;
                    unit = Unit.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                    tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                    tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                    if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        sendChannel2 = sendChannel3;
                        j6 = j8;
                        j3 = j7;
                        j4 = j10;
                        TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                        long nanoTime2 = (timeSource2 != null || (boxLong = Boxing.boxLong(timeSource2.nanoTime())) == null) ? System.nanoTime() : boxLong.longValue();
                        coerceAtLeast = RangesKt.coerceAtLeast(j9 - nanoTime2, 0L);
                        if (coerceAtLeast == 0 || j6 == 0) {
                            delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                            tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                            if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                j5 = j9;
                                tickerChannelsKt$fixedPeriodTicker$1 = tickerChannelsKt$fixedPeriodTicker$1;
                                j4 = j4;
                                j7 = j3;
                                j8 = j6;
                                j10 = j4;
                                sendChannel3 = sendChannel2;
                                i2 = 2;
                                j9 = j5 + j8;
                                unit = Unit.INSTANCE;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                                tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                                if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        long j18 = j6 - ((nanoTime2 - j9) % j6);
                        long j19 = nanoTime2 + j18;
                        long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j18);
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j19;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                        tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                        tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                        tickerChannelsKt$fixedPeriodTicker$1.J$6 = j18;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                        if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                            tickerChannelsKt$fixedPeriodTicker$1 = tickerChannelsKt$fixedPeriodTicker$1;
                            j5 = j19;
                            j7 = j3;
                            j8 = j6;
                            j10 = j4;
                            sendChannel3 = sendChannel2;
                            i2 = 2;
                            j9 = j5 + j8;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                            tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                            tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                            if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                        delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                        tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                        tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                        tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                        if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return coroutine_suspended;
                } else {
                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                    j9 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                    if (timeSource2 != null) {
                    }
                    coerceAtLeast = RangesKt.coerceAtLeast(j9 - nanoTime2, 0L);
                    if (coerceAtLeast == 0) {
                    }
                    delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                    tickerChannelsKt$fixedPeriodTicker$1.J$3 = j6;
                    tickerChannelsKt$fixedPeriodTicker$1.J$4 = nanoTime2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$5 = coerceAtLeast;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                    if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                j8 = EventLoop_commonKt.delayToNanos(j7);
                sendChannel3 = sendChannel4;
                j9 = j5 + j8;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
                tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
                tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        int i2 = 2;
        if (i != 0) {
        }
        j8 = EventLoop_commonKt.delayToNanos(j7);
        sendChannel3 = sendChannel4;
        j9 = j5 + j8;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j7;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j9;
        tickerChannelsKt$fixedPeriodTicker$1.J$3 = j8;
        tickerChannelsKt$fixedPeriodTicker$1.label = i2;
        if (sendChannel3.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    static final /* synthetic */ Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i;
        long j3;
        long j4;
        SendChannel<? super Unit> sendChannel2;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            if ((tickerChannelsKt$fixedDelayTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.delay(j2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unit = Unit.INSTANCE;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.label = 2;
                    if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    j2 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    unit = Unit.INSTANCE;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.label = 2;
                    if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        sendChannel2 = sendChannel;
                        j4 = j2;
                        j3 = j;
                        tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                        tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                        tickerChannelsKt$fixedDelayTicker$1.label = 3;
                        if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                } else if (i == 2) {
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                    if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 3) {
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sendChannel = sendChannel2;
                j2 = j4;
                j = j3;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i != 0) {
        }
        sendChannel = sendChannel2;
        j2 = j4;
        j = j3;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
