package com.coolapk.market.view.album.albumv8;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onDoubleClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
final class AlbumDetailActivity$showContent$1 implements ViewUtil.OnDoubleClickListener {
    final /* synthetic */ AlbumDetailActivity this$0;

    AlbumDetailActivity$showContent$1(AlbumDetailActivity albumDetailActivity) {
        this.this$0 = albumDetailActivity;
    }

    @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
    public final boolean onDoubleClick(View view) {
        AlbumDetailActivity albumDetailActivity = this.this$0;
        ScrollStateViewPager scrollStateViewPager = AlbumDetailActivity.access$getBinding$p(albumDetailActivity).viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        Fragment viewPagerFragment = albumDetailActivity.getViewPagerFragment(scrollStateViewPager.getCurrentItem());
        if (!(viewPagerFragment instanceof ScrollableFragment) || !viewPagerFragment.isVisible()) {
            return false;
        }
        ((ScrollableFragment) viewPagerFragment).scrollToTop(true);
        return true;
    }
}
