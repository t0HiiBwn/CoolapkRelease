package com.coolapk.market.view.album.albumv8;

import android.text.TextUtils;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailActivity$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
public final class AlbumDetailActivity$onPageChangeListener$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ AlbumDetailActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumDetailActivity$onPageChangeListener$1(AlbumDetailActivity albumDetailActivity) {
        this.this$0 = albumDetailActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Toolbar toolbar = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        boolean z = false;
        if (toolbar.isShown() && i == 0 && f != 0.0f && this.this$0.filter < 1.0f) {
            this.this$0.setAppBarShadow(f);
            AlbumDetailActivity.access$getBinding$p(this.this$0).appBar.setBackgroundColor(ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorPrimary(), f));
            if (this.this$0.filter != f || this.this$0.filter == 1.0f) {
                this.this$0.filter = f;
                Toolbar toolbar2 = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
                Intrinsics.checkNotNullExpressionValue(toolbar2, "binding.toolbar");
                ViewExtendsKt.adjustTintColorByAlpha$default(toolbar2, f, false, 2, null);
            } else {
                return;
            }
        }
        AlbumDetailActivity albumDetailActivity = this.this$0;
        if (i == 0) {
            z = true;
        }
        albumDetailActivity.setSlidrEnable(z);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i != 0) {
            if (i != 1) {
                Toolbar toolbar = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
                Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
                toolbar.setTitle("");
            } else {
                Toolbar toolbar2 = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
                Intrinsics.checkNotNullExpressionValue(toolbar2, "binding.toolbar");
                toolbar2.setTitle(this.this$0.getString(2131886667));
            }
        } else if (!(this.this$0.verticalTop)) {
            Toolbar toolbar3 = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar3, "binding.toolbar");
            toolbar3.setTitle(AlbumDetailActivity.access$getViewModel$p(this.this$0).getAlbumTitle());
        } else {
            Toolbar toolbar4 = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar4, "binding.toolbar");
            toolbar4.setTitle("");
        }
        this.this$0.notifyCommentBarChange();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            ScrollStateViewPager scrollStateViewPager = AlbumDetailActivity.access$getBinding$p(this.this$0).viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            int currentItem = scrollStateViewPager.getCurrentItem();
            LogUtils.d("Try to init fragment, index: %s", Integer.valueOf(currentItem));
            Fragment viewPagerFragment = this.this$0.getViewPagerFragment(currentItem);
            if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof InitBehavior)) {
                InitBehavior initBehavior = (InitBehavior) viewPagerFragment;
                LogUtils.v("Invoke %s's initData", initBehavior.getClass().getSimpleName());
                initBehavior.initData();
            }
            if (!(this.this$0.isInit) && !TextUtils.isEmpty(this.this$0.replyId) && this.this$0.getCurrentPage() == 1) {
                this.this$0.appBarInitStateFor2edPage();
            }
        }
    }
}
