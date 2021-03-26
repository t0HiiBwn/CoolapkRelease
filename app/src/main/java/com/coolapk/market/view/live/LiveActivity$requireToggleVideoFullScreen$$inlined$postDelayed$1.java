package com.coolapk.market.view.live;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$postDelayed$runnable$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class LiveActivity$requireToggleVideoFullScreen$$inlined$postDelayed$1 implements Runnable {
    final /* synthetic */ LiveActivity this$0;

    public LiveActivity$requireToggleVideoFullScreen$$inlined$postDelayed$1(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinearLayout linearLayout = LiveActivity.access$getBinding$p(this.this$0).videoContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
        linearLayout.setVisibility(8);
        ViewExtendsKt.detachFromParent(LiveActivity.access$getLiveVideoViewPart$p(this.this$0).getView());
        LiveActivity.access$getBinding$p(this.this$0).playerHolder.addView(LiveActivity.access$getLiveVideoViewPart$p(this.this$0).getView(), new FrameLayout.LayoutParams(-1, -1));
    }
}
