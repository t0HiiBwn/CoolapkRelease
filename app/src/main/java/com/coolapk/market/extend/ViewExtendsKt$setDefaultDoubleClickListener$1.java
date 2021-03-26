package com.coolapk.market.extend;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.main.CircleFeedV8Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "child", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$setDefaultDoubleClickListener$1 implements ViewUtil.OnDoubleClickListener {
    final /* synthetic */ ViewPager $viewPager;

    ViewExtendsKt$setDefaultDoubleClickListener$1(ViewPager viewPager) {
        this.$viewPager = viewPager;
    }

    /* renamed from: invoke */
    public final boolean onDoubleClick(View view) {
        int intValue;
        Intrinsics.checkNotNullExpressionValue(view, "child");
        ViewParent parent = view.getParent();
        BaseFragment baseFragment = null;
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        Integer valueOf = viewGroup != null ? Integer.valueOf(viewGroup.indexOfChild(view)) : null;
        if (valueOf == null || this.$viewPager.getCurrentItem() != (intValue = valueOf.intValue())) {
            return false;
        }
        PagerAdapter adapter = this.$viewPager.getAdapter();
        if (!(adapter instanceof FragmentStatePagerAdapter)) {
            adapter = null;
        }
        FragmentStatePagerAdapter fragmentStatePagerAdapter = (FragmentStatePagerAdapter) adapter;
        Object instantiateItem = fragmentStatePagerAdapter != null ? fragmentStatePagerAdapter.instantiateItem((ViewGroup) this.$viewPager, intValue) : null;
        if (instantiateItem instanceof BaseFragment) {
            baseFragment = instantiateItem;
        }
        BaseFragment baseFragment2 = baseFragment;
        if ((baseFragment2 instanceof ScrollableFragment) && baseFragment2.isVisible() && !(baseFragment2 instanceof CircleFeedV8Fragment)) {
            ((ScrollableFragment) baseFragment2).scrollToTop(true);
            return true;
        }
        return false;
    }
}
