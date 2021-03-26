package com.coolapk.market.view.feed.vote;

import android.view.View;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.model.Vote;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"com/coolapk/market/view/feed/vote/FeedVoteDetailFragment$setToolbarUI$1", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "headerRange", "", "getHeaderRange", "()I", "lastValue", "", "getLastValue", "()F", "setLastValue", "(F)V", "title", "", "getTitle", "()Ljava/lang/String;", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
public final class FeedVoteDetailFragment$setToolbarUI$1 implements AppBarLayout.OnOffsetChangedListener {
    final /* synthetic */ AlphableToolbar $alphaToolbar;
    final /* synthetic */ RefreshRecyclerTabsBinding $tabBinding;
    final /* synthetic */ Vote $vote;
    private final int headerRange;
    private float lastValue = -1.0f;
    final /* synthetic */ FeedVoteDetailFragment this$0;
    private final String title;

    FeedVoteDetailFragment$setToolbarUI$1(FeedVoteDetailFragment feedVoteDetailFragment, AlphableToolbar alphableToolbar, RefreshRecyclerTabsBinding refreshRecyclerTabsBinding, Vote vote) {
        this.this$0 = feedVoteDetailFragment;
        this.$alphaToolbar = alphableToolbar;
        this.$tabBinding = refreshRecyclerTabsBinding;
        this.$vote = vote;
        this.headerRange = UiUtils.getStatusBarHeight(feedVoteDetailFragment.getActivity()) + UiUtils.getActionBarSize(feedVoteDetailFragment.getActivity());
        this.title = vote.getMessageTitle();
    }

    public final float getLastValue() {
        return this.lastValue;
    }

    public final void setLastValue(float f) {
        this.lastValue = f;
    }

    public final int getHeaderRange() {
        return this.headerRange;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        float constrain = KotlinExtendKt.constrain(((float) Math.abs(i)) / ((float) this.headerRange), 1.0f, 0.0f);
        AlphaToolbarActivity alphaToolbarActivity = null;
        if (constrain != this.lastValue) {
            this.lastValue = constrain;
            boolean z = true;
            this.$alphaToolbar.setToolbarTitle(constrain >= ((float) 1) ? this.title : "");
            AlphableToolbar alphableToolbar = this.$alphaToolbar;
            if (!(alphableToolbar instanceof AlphaToolbarActivity)) {
                alphableToolbar = null;
            }
            AlphaToolbarActivity alphaToolbarActivity2 = (AlphaToolbarActivity) alphableToolbar;
            if (alphaToolbarActivity2 != null) {
                if (this.lastValue < 1.0f) {
                    z = false;
                }
                alphaToolbarActivity2.setToolbarElevationVisible(z);
            }
        }
        if (Math.abs(i) == appBarLayout.getTotalScrollRange()) {
            View view = this.$tabBinding.divider;
            Intrinsics.checkNotNullExpressionValue(view, "tabBinding.divider");
            view.setVisibility(8);
            AlphableToolbar alphableToolbar2 = this.$alphaToolbar;
            if (alphableToolbar2 instanceof AlphaToolbarActivity) {
                alphaToolbarActivity = alphableToolbar2;
            }
            AlphaToolbarActivity alphaToolbarActivity3 = alphaToolbarActivity;
            if (alphaToolbarActivity3 != null) {
                alphaToolbarActivity3.setLightElevation();
                return;
            }
            return;
        }
        View view2 = this.$tabBinding.divider;
        Intrinsics.checkNotNullExpressionValue(view2, "tabBinding.divider");
        view2.setVisibility(0);
    }
}
