package com.coolapk.market.view.wallpaper.coolpic;

import androidx.fragment.app.Fragment;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailActivity$onCreate$5", "Lcom/coolapk/market/widget/view/SwipeScaleView$OnCanSwipeListener;", "canSwipe", "", "isIgnoreTrack", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailActivity.kt */
public final class CoolPicDetailActivity$onCreate$5 implements SwipeScaleView.OnCanSwipeListener {
    final /* synthetic */ CoolPicDetailActivity this$0;

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnCanSwipeListener
    public boolean isIgnoreTrack() {
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicDetailActivity$onCreate$5(CoolPicDetailActivity coolPicDetailActivity) {
        this.this$0 = coolPicDetailActivity;
    }

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnCanSwipeListener
    public boolean canSwipe() {
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(2131362318);
        Boolean bool = null;
        if (!(findFragmentById instanceof CoolPicListFragment)) {
            findFragmentById = null;
        }
        CoolPicListFragment coolPicListFragment = (CoolPicListFragment) findFragmentById;
        if (coolPicListFragment != null) {
            bool = Boolean.valueOf(coolPicListFragment.canSwipe());
        }
        if (bool == null) {
            bool = false;
        }
        return bool.booleanValue();
    }
}
