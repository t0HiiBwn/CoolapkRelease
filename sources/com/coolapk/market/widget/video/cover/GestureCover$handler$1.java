package com.coolapk.market.widget.video.cover;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/widget/video/cover/GestureCover$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GestureCover.kt */
public final class GestureCover$handler$1 extends Handler {
    GestureCover$handler$1(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
    }
}
