package com.coolapk.market.view.photo;

import android.view.ViewGroup;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.widget.CatchErrorViewPager;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/view/photo/PhotoViewActivity$onCreate$3", "Lcom/coolapk/market/widget/view/SwipeScaleView$OnCanSwipeListener;", "canSwipe", "", "isIgnoreTrack", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity$onCreate$3 implements SwipeScaleView.OnCanSwipeListener {
    final /* synthetic */ PhotoViewActivity.ImageViewPagerAdapter $adapter;
    final /* synthetic */ CatchErrorViewPager $viewPager;

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnCanSwipeListener
    public boolean isIgnoreTrack() {
        return false;
    }

    PhotoViewActivity$onCreate$3(PhotoViewActivity.ImageViewPagerAdapter imageViewPagerAdapter, CatchErrorViewPager catchErrorViewPager) {
        this.$adapter = imageViewPagerAdapter;
        this.$viewPager = catchErrorViewPager;
    }

    @Override // com.coolapk.market.widget.view.SwipeScaleView.OnCanSwipeListener
    public boolean canSwipe() {
        PhotoViewActivity.ImageViewPagerAdapter imageViewPagerAdapter = this.$adapter;
        CatchErrorViewPager catchErrorViewPager = this.$viewPager;
        Object instantiateItem = imageViewPagerAdapter.instantiateItem((ViewGroup) catchErrorViewPager, catchErrorViewPager.getCurrentItem());
        Boolean bool = null;
        if (!(instantiateItem instanceof PhotoViewActivity.ImageFragment)) {
            instantiateItem = null;
        }
        PhotoViewActivity.ImageFragment imageFragment = (PhotoViewActivity.ImageFragment) instantiateItem;
        if (imageFragment != null) {
            bool = Boolean.valueOf(imageFragment.canSwipe());
        }
        if (bool == null) {
            bool = false;
        }
        return bool.booleanValue();
    }
}
