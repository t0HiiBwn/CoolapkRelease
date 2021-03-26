package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: EventLoop.common.kt */
public final class EventLoop_commonKt {
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final long MAX_DELAY_NS = 4611686018427387903L;
    private static final long MAX_MS = 9223372036854L;
    private static final long MS_TO_NS = 1000000;
    private static final int SCHEDULE_COMPLETED = 1;
    private static final int SCHEDULE_DISPOSED = 2;
    private static final int SCHEDULE_OK = 0;

    private static /* synthetic */ void CLOSED_EMPTY$annotations() {
    }

    private static /* synthetic */ void DISPOSED_TASK$annotations() {
    }

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }

    public static final long delayNanosToMillis(long j) {
        return j / 1000000;
    }
}
