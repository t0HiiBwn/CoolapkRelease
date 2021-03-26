package com.coolapk.market.view.feed.reply;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "verticalOffset", "", "onOffsetChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: PictureDetailFragment.kt */
final class PictureDetailFragment$onViewCreated$1 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ PictureDetailFragment this$0;

    PictureDetailFragment$onViewCreated$1(PictureDetailFragment pictureDetailFragment) {
        this.this$0 = pictureDetailFragment;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Toolbar toolbar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
        float constrain = KotlinExtendKt.constrain(((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()), 1.0f, 0.0f);
        if (this.this$0.getBackImageFullScreen()) {
            View view = this.this$0.getBinding().fakeBgView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.fakeBgView");
            view.setAlpha((0.3f * constrain) + 0.7f);
        }
        FragmentActivity activity = this.this$0.getActivity();
        AlphableToolbar alphableToolbar = null;
        if (!(activity instanceof AlphaToolbarActivity)) {
            activity = null;
        }
        AlphaToolbarActivity alphaToolbarActivity = (AlphaToolbarActivity) activity;
        if (!(alphaToolbarActivity == null || (toolbar = alphaToolbarActivity.getToolbar()) == null)) {
            ViewExtendsKt.adjustTintColorByAlpha$default(toolbar, constrain, false, 2, null);
        }
        if (constrain >= 1.0f) {
            FragmentActivity activity2 = this.this$0.getActivity();
            if (activity2 instanceof AlphableToolbar) {
                alphableToolbar = activity2;
            }
            AlphableToolbar alphableToolbar2 = (AlphableToolbar) alphableToolbar;
            if (alphableToolbar2 != null) {
                alphableToolbar2.setToolbarTitle(this.this$0.getFeed().getFeedTypeName());
                return;
            }
            return;
        }
        FragmentActivity activity3 = this.this$0.getActivity();
        if (activity3 instanceof AlphableToolbar) {
            alphableToolbar = activity3;
        }
        AlphableToolbar alphableToolbar3 = alphableToolbar;
        if (alphableToolbar3 != null) {
            alphableToolbar3.setToolbarTitle("");
        }
    }
}
