package com.coolapk.market.widget.video.util;

import android.content.Context;
import com.kk.taurus.playerbase.touch.BaseGestureCallbackHandler;
import com.kk.taurus.playerbase.widget.SuperContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/video/util/FixTouchSuperContainer;", "Lcom/kk/taurus/playerbase/widget/SuperContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getGestureCallBackHandler", "Lcom/kk/taurus/playerbase/touch/BaseGestureCallbackHandler;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FixTouchSuperContainer.kt */
public final class FixTouchSuperContainer extends SuperContainer {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixTouchSuperContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.kk.taurus.playerbase.widget.SuperContainer
    protected BaseGestureCallbackHandler getGestureCallBackHandler() {
        return new FixTouchSuperContainer$getGestureCallBackHandler$1(this, this);
    }
}
