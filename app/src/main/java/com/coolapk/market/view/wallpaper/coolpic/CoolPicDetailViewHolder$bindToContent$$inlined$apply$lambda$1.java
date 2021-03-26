package com.coolapk.market.view.wallpaper.coolpic;

import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.ImageIndicatorView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailViewHolder$bindToContent$5$2", "Lcom/coolapk/market/widget/view/ImageIndicatorView$ClickItem;", "onClick", "", "index", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailViewHolder.kt */
public final class CoolPicDetailViewHolder$bindToContent$$inlined$apply$lambda$1 implements ImageIndicatorView.ClickItem {
    final /* synthetic */ Feed $entity$inlined;
    final /* synthetic */ CoolPicListFragment $listFragment$inlined;
    final /* synthetic */ CoolPicViewPager $viewPager$inlined;
    final /* synthetic */ CoolPicDetailViewHolder this$0;

    CoolPicDetailViewHolder$bindToContent$$inlined$apply$lambda$1(CoolPicDetailViewHolder coolPicDetailViewHolder, Feed feed, CoolPicListFragment coolPicListFragment, CoolPicViewPager coolPicViewPager) {
        this.this$0 = coolPicDetailViewHolder;
        this.$entity$inlined = feed;
        this.$listFragment$inlined = coolPicListFragment;
        this.$viewPager$inlined = coolPicViewPager;
    }

    @Override // com.coolapk.market.widget.view.ImageIndicatorView.ClickItem
    public void onClick(int i) {
        this.$viewPager$inlined.setCurrentItem(i);
    }
}
