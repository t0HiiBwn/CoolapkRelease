package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class GoodsCouponSearchBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final FrameLayout contentView;
    public final DrawSystemBarFrameLayout mainContent;
    public final TabLayout tabs;
    public final ScrollStateViewPager viewPager;

    protected GoodsCouponSearchBinding(Object obj, View view, int i, AppBarLayout appBarLayout, FrameLayout frameLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, TabLayout tabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.contentView = frameLayout;
        this.mainContent = drawSystemBarFrameLayout;
        this.tabs = tabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static GoodsCouponSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsCouponSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GoodsCouponSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558570, viewGroup, z, obj);
    }

    public static GoodsCouponSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsCouponSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GoodsCouponSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558570, null, false, obj);
    }

    public static GoodsCouponSearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsCouponSearchBinding bind(View view, Object obj) {
        return (GoodsCouponSearchBinding) bind(obj, view, 2131558570);
    }
}
