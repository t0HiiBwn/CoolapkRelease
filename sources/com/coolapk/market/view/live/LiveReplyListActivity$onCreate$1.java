package com.coolapk.market.view.live;

import android.widget.LinearLayout;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.widget.view.SlideUpView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/live/LiveReplyListActivity$onCreate$1", "Lcom/coolapk/market/widget/view/SlideUpView$Callback;", "onDismiss", "", "onShow", "onTranslateYChange", "y", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveReplyListActivity.kt */
public final class LiveReplyListActivity$onCreate$1 implements SlideUpView.Callback {
    final /* synthetic */ LiveReplyListActivity this$0;

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onShow() {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LiveReplyListActivity$onCreate$1(LiveReplyListActivity liveReplyListActivity) {
        this.this$0 = liveReplyListActivity;
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onTranslateYChange(int i) {
        SlideUpView slideUpView = LiveReplyListActivity.access$getBinding$p(this.this$0).slideUpView;
        Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.slideUpView");
        float height = ((float) i) / ((float) slideUpView.getHeight());
        LinearLayout linearLayout = LiveReplyListActivity.access$getBinding$p(this.this$0).mainContent;
        Object evaluate = this.this$0.evaluator.evaluate(height, -1728053248, 0);
        Objects.requireNonNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
        linearLayout.setBackgroundColor(((Integer) evaluate).intValue());
        if (i == 0) {
            ThemeUtils.setStatusBarColor(this.this$0.getActivity(), ThemeUtils.getStatusBarColor());
        } else {
            ThemeUtils.setTranslucentStatusBar(this.this$0.getActivity());
        }
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onDismiss() {
        this.this$0.finish();
    }
}
