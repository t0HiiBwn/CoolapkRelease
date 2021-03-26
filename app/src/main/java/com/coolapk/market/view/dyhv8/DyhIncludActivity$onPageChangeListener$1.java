package com.coolapk.market.view.dyhv8;

import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/dyhv8/DyhIncludActivity$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhIncludActivity.kt */
public final class DyhIncludActivity$onPageChangeListener$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ DyhIncludActivity this$0;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    DyhIncludActivity$onPageChangeListener$1(DyhIncludActivity dyhIncludActivity) {
        this.this$0 = dyhIncludActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        LinkedHashMap linkedHashMap = this.this$0.dyhMap;
        Intrinsics.checkNotNull(linkedHashMap);
        if (!linkedHashMap.isEmpty()) {
            LinkedHashMap linkedHashMap2 = this.this$0.dyhMap;
            Intrinsics.checkNotNull(linkedHashMap2);
            linkedHashMap2.clear();
        }
        boolean z = i == 1;
        LinearLayout linearLayout = DyhIncludActivity.access$getBinding$p(this.this$0).hintView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.hintView");
        linearLayout.setVisibility(z ? 0 : 8);
        if (z) {
            ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getColorAccent());
            colorDrawable.setAlpha(26);
            LinearLayout linearLayout2 = DyhIncludActivity.access$getBinding$p(this.this$0).hintView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.hintView");
            linearLayout2.setBackground(colorDrawable);
        }
        this.this$0.setPage(i);
        if (i == 1) {
            LinearLayout linearLayout3 = DyhIncludActivity.access$getBinding$p(this.this$0).searchView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.searchView");
            linearLayout3.setVisibility(0);
            View view = DyhIncludActivity.access$getBinding$p(this.this$0).searchViewDivider;
            Intrinsics.checkNotNullExpressionValue(view, "binding.searchViewDivider");
            view.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DyhIncludActivity.access$getBinding$p(this.this$0).searchView, View.TRANSLATION_Y, 36.0f, -16.0f, 10.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
            ofFloat.setDuration(400L);
            LinearLayout linearLayout4 = DyhIncludActivity.access$getBinding$p(this.this$0).searchView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.searchView");
            linearLayout4.setTranslationY(36.0f);
            ofFloat.start();
            return;
        }
        LinearLayout linearLayout5 = DyhIncludActivity.access$getBinding$p(this.this$0).searchView;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.searchView");
        linearLayout5.setVisibility(8);
        View view2 = DyhIncludActivity.access$getBinding$p(this.this$0).searchViewDivider;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.searchViewDivider");
        view2.setVisibility(8);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            ScrollStateViewPager scrollStateViewPager = DyhIncludActivity.access$getBinding$p(this.this$0).viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            Fragment viewPagerFragment = this.this$0.getViewPagerFragment(scrollStateViewPager.getCurrentItem());
            if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof InitBehavior)) {
                InitBehavior initBehavior = (InitBehavior) viewPagerFragment;
                LogUtils.v("Invoke %s's initData", initBehavior.getClass().getSimpleName());
                initBehavior.initData();
            }
        }
    }
}
