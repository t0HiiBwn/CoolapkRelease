package com.coolapk.market.view.photo;

import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.widget.CatchErrorViewPager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/photo/PhotoViewActivity$onCreate$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewActivity.kt */
public final class PhotoViewActivity$onCreate$2 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ CatchErrorViewPager $viewPager;

    PhotoViewActivity$onCreate$2(CatchErrorViewPager catchErrorViewPager) {
        this.$viewPager = catchErrorViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        PagerAdapter adapter = this.$viewPager.getAdapter();
        PhotoViewActivity.ImageFragment imageFragment = null;
        Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) this.$viewPager, i) : null;
        if (instantiateItem instanceof PhotoViewActivity.ImageFragment) {
            imageFragment = instantiateItem;
        }
        PhotoViewActivity.ImageFragment imageFragment2 = imageFragment;
        if (imageFragment2 != null) {
            imageFragment2.initData();
        }
    }
}
