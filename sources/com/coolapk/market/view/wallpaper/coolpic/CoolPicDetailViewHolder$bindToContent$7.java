package com.coolapk.market.view.wallpaper.coolpic;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.databinding.ItemCoolpicDetailBinding;
import com.coolapk.market.util.UiUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailViewHolder$bindToContent$7", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailViewHolder.kt */
public final class CoolPicDetailViewHolder$bindToContent$7 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ CoolPicListFragment $listFragment;
    final /* synthetic */ ArrayList $sizeList;
    final /* synthetic */ CoolPicViewPager $viewPager;
    final /* synthetic */ CoolPicDetailViewHolder this$0;

    CoolPicDetailViewHolder$bindToContent$7(CoolPicDetailViewHolder coolPicDetailViewHolder, CoolPicListFragment coolPicListFragment, ArrayList arrayList, CoolPicViewPager coolPicViewPager) {
        this.this$0 = coolPicDetailViewHolder;
        this.$listFragment = coolPicListFragment;
        this.$sizeList = arrayList;
        this.$viewPager = coolPicViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        CoolPicListFragment coolPicListFragment = this.$listFragment;
        Intrinsics.checkNotNull(coolPicListFragment);
        coolPicListFragment.setIndex(i);
        ((ItemCoolpicDetailBinding) this.this$0.getBinding()).indicatorView.setSelectedIndex(i);
        if (i <= this.$sizeList.size() - 1) {
            TextView textView = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).sizeView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.sizeView");
            Object obj = this.$sizeList.get(i);
            if (obj == null) {
                obj = "";
            }
            textView.setText((CharSequence) obj);
        }
        CoolPicDetailViewHolder.access$setPicIndex$p(this.this$0, i);
        PagerAdapter adapter = this.$viewPager.getAdapter();
        ImageViewFragment imageViewFragment = null;
        Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) this.$viewPager, i) : null;
        if (instantiateItem instanceof ImageViewFragment) {
            imageViewFragment = instantiateItem;
        }
        ImageViewFragment imageViewFragment2 = imageViewFragment;
        if (imageViewFragment2 != null) {
            imageViewFragment2.initData();
        }
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable instanceof CoolPicDetailActivity) {
            CoolPicDetailViewHolder coolPicDetailViewHolder = this.this$0;
            String str = CoolPicDetailViewHolder.access$getFeedPresenter$p(coolPicDetailViewHolder).getFeed().getPicArray().get(CoolPicDetailViewHolder.access$getPicIndex$p(this.this$0));
            Intrinsics.checkNotNullExpressionValue(str, "feedPresenter.feed.picArray[picIndex]");
            CoolPicDetailViewHolder.access$setCompress$p(coolPicDetailViewHolder, ((CoolPicDetailActivity) activityNullable).isCompressUrl(str));
            TextView textView2 = ((ItemCoolpicDetailBinding) this.this$0.getBinding()).wallpaperSourceView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.wallpaperSourceView");
            int i2 = 0;
            if (!CoolPicDetailViewHolder.access$isCompress$p(this.this$0)) {
                i2 = 8;
            }
            textView2.setVisibility(i2);
        }
    }
}
