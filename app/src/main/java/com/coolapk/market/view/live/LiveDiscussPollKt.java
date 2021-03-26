package com.coolapk.market.view.live;

import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\t"}, d2 = {"liveDiscussPollLogD", "", "message", "", "liveDiscussPollLogE", "error", "", "liveDiscussPollLogI", "liveDiscussPollLogW", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
public final class LiveDiscussPollKt {
    public static final void liveDiscussPollLogD(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LogUtils.d(str, new Object[0]);
    }

    public static final void liveDiscussPollLogI(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LogUtils.i(str, new Object[0]);
    }

    public static final void liveDiscussPollLogW(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LogUtils.w(str, new Object[0]);
    }

    public static final void liveDiscussPollLogE(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "error");
        LogUtils.e(th, str, new Object[0]);
    }
}
