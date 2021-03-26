package com.coolapk.market.view.main;

import android.view.View;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"com/coolapk/market/view/main/TranslucentHeaderConverter$compatScrollWithTitleVisible$1", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "lastValue", "", "getLastValue", "()F", "setLastValue", "(F)V", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TranslucentHeaderConverter.kt */
public final class TranslucentHeaderConverter$compatScrollWithTitleVisible$1 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ AlphableToolbar $alphaToolbar;
    final /* synthetic */ RefreshRecyclerTabsBinding $tabBinding;
    final /* synthetic */ String $title;
    private float lastValue = -1.0f;
    final /* synthetic */ TranslucentHeaderConverter this$0;

    TranslucentHeaderConverter$compatScrollWithTitleVisible$1(TranslucentHeaderConverter translucentHeaderConverter, AlphableToolbar alphableToolbar, String str, RefreshRecyclerTabsBinding refreshRecyclerTabsBinding) {
        this.this$0 = translucentHeaderConverter;
        this.$alphaToolbar = alphableToolbar;
        this.$title = str;
        this.$tabBinding = refreshRecyclerTabsBinding;
    }

    public final float getLastValue() {
        return this.lastValue;
    }

    public final void setLastValue(float f) {
        this.lastValue = f;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        float constrain = KotlinExtendKt.constrain(((float) Math.abs(i)) / ((float) this.this$0.getHeaderRange()), 1.0f, 0.0f);
        if (constrain != this.lastValue) {
            this.lastValue = constrain;
            this.$alphaToolbar.setToolbarAlpha(constrain);
            this.$alphaToolbar.setToolbarTitle(this.lastValue >= ((float) 1) ? this.$title : "");
        }
        if (Math.abs(i) == appBarLayout.getTotalScrollRange()) {
            View view = this.$tabBinding.divider;
            Intrinsics.checkNotNullExpressionValue(view, "tabBinding.divider");
            view.setVisibility(8);
            AlphableToolbar alphableToolbar = this.$alphaToolbar;
            if (!(alphableToolbar instanceof AlphaToolbarActivity)) {
                alphableToolbar = null;
            }
            AlphaToolbarActivity alphaToolbarActivity = (AlphaToolbarActivity) alphableToolbar;
            if (alphaToolbarActivity != null) {
                alphaToolbarActivity.setLightElevation();
                return;
            }
            return;
        }
        this.$alphaToolbar.setToolbarAlpha(this.lastValue);
        View view2 = this.$tabBinding.divider;
        Intrinsics.checkNotNullExpressionValue(view2, "tabBinding.divider");
        view2.setVisibility(0);
    }
}
