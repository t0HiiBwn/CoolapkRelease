package com.coolapk.market.view.live;

import android.os.Handler;
import android.os.Message;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000eR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/live/LiveRefreshTimer;", "", "fragment", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "minDuration", "", "(Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;J)V", "handler", "Lcom/coolapk/market/view/live/LiveRefreshTimer$MyHandler;", "lastRefreshTime", "Ljava/lang/Long;", "cancel", "", "checkState", "", "scheduleNext", "immediately", "MyHandler", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveRefreshTimer.kt */
public final class LiveRefreshTimer {
    private final NewAsyncListFragment<?> fragment;
    private final MyHandler handler = new MyHandler();
    private Long lastRefreshTime;
    private final long minDuration;

    public LiveRefreshTimer(NewAsyncListFragment<?> newAsyncListFragment, long j) {
        Intrinsics.checkNotNullParameter(newAsyncListFragment, "fragment");
        this.fragment = newAsyncListFragment;
        this.minDuration = j;
    }

    public final void cancel() {
        this.handler.removeMessages(0);
    }

    public static /* synthetic */ void scheduleNext$default(LiveRefreshTimer liveRefreshTimer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        liveRefreshTimer.scheduleNext(z);
    }

    public final void scheduleNext(boolean z) {
        LogUtils.d(this.fragment + " 重新安排计时器", new Object[0]);
        this.handler.removeMessages(0);
        long j = 0;
        if (!z) {
            Long l = this.lastRefreshTime;
            if (l == null) {
                j = this.minDuration;
            } else {
                j = Math.max(this.minDuration - (System.currentTimeMillis() - l.longValue()), 0L);
            }
        }
        Message obtain = Message.obtain();
        obtain.obj = Boolean.valueOf(z);
        this.handler.sendMessageDelayed(obtain, j);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/live/LiveRefreshTimer$MyHandler;", "Landroid/os/Handler;", "(Lcom/coolapk/market/view/live/LiveRefreshTimer;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveRefreshTimer.kt */
    private final class MyHandler extends Handler {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
            if (Intrinsics.areEqual(message.obj, (Object) true) || LiveRefreshTimer.this.checkState()) {
                LogUtils.d(LiveRefreshTimer.this.fragment + " time to refresh data", new Object[0]);
                LiveRefreshTimer.this.lastRefreshTime = Long.valueOf(System.currentTimeMillis());
                LiveRefreshTimer.this.fragment.reloadData();
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean checkState() {
        return this.fragment.isAdded() && !this.fragment.isDetached() && this.fragment.isResumed() && this.fragment.isVisible() && this.fragment.isDataLoaded() && !this.fragment.isRefreshing() && !this.fragment.isLoadingMore();
    }
}
