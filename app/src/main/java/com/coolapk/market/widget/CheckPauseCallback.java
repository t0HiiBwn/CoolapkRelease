package com.coolapk.market.widget;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/coolapk/market/widget/CheckPauseCallback;", "", "deadlineNano", "", "(J)V", "getDeadlineNano", "()J", "setDeadlineNano", "checkNeedPause", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainSpareHandler.kt */
public abstract class CheckPauseCallback {
    private long deadlineNano;

    public abstract boolean checkNeedPause();

    public CheckPauseCallback(long j) {
        this.deadlineNano = j;
    }

    public final long getDeadlineNano() {
        return this.deadlineNano;
    }

    public final void setDeadlineNano(long j) {
        this.deadlineNano = j;
    }
}
