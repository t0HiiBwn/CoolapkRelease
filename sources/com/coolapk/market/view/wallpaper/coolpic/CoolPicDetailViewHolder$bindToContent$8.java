package com.coolapk.market.view.wallpaper.coolpic;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailViewHolder$bindToContent$8", "Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicViewPager$VpClick;", "canScroll", "", "clickItem", "", "view", "Landroid/view/View;", "doubleClickItem", "xDown", "", "yDown", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailViewHolder.kt */
public final class CoolPicDetailViewHolder$bindToContent$8 implements CoolPicViewPager.VpClick {
    final /* synthetic */ CoolPicListFragment $fragment;
    final /* synthetic */ CoolPicViewPager $viewPager;
    final /* synthetic */ CoolPicDetailViewHolder this$0;

    @Override // com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager.VpClick
    public void doubleClickItem(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    CoolPicDetailViewHolder$bindToContent$8(CoolPicDetailViewHolder coolPicDetailViewHolder, CoolPicViewPager coolPicViewPager, CoolPicListFragment coolPicListFragment) {
        this.this$0 = coolPicDetailViewHolder;
        this.$viewPager = coolPicViewPager;
        this.$fragment = coolPicListFragment;
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager.VpClick
    public boolean canScroll() {
        PagerAdapter adapter = this.$viewPager.getAdapter();
        ImageViewFragment imageViewFragment = null;
        Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) this.$viewPager, CoolPicDetailViewHolder.access$getPicIndex$p(this.this$0)) : null;
        if (instantiateItem instanceof ImageViewFragment) {
            imageViewFragment = instantiateItem;
        }
        ImageViewFragment imageViewFragment2 = imageViewFragment;
        Intrinsics.checkNotNull(imageViewFragment2);
        return imageViewFragment2.canScroll();
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager.VpClick
    public void clickItem(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.$fragment.isShown()) {
            CoolPicDetailViewHolder.access$viewOut(this.this$0);
        } else {
            CoolPicDetailViewHolder.access$viewIn(this.this$0);
        }
        CoolPicListFragment coolPicListFragment = this.$fragment;
        coolPicListFragment.setShown(!coolPicListFragment.isShown());
    }
}
