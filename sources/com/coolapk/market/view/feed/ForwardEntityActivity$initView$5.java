package com.coolapk.market.view.feed;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/feed/ForwardEntityActivity$initView$5", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
public final class ForwardEntityActivity$initView$5 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ ForwardEntityActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ForwardEntityActivity$initView$5(ForwardEntityActivity forwardEntityActivity) {
        this.this$0 = forwardEntityActivity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View root = ForwardEntityActivity.access$getBinding$p(this.this$0).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.startOpenAnimation();
        return false;
    }
}
