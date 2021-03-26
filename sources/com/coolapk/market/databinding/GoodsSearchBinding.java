package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class GoodsSearchBinding extends ViewDataBinding {
    public final LinearLayout addGoodsView;
    public final AppBarLayout appBar;
    public final DrawSystemBarFrameLayout mainContent;
    public final TabLayout tabs;
    public final ScrollStateViewPager viewPager;

    protected GoodsSearchBinding(Object obj, View view, int i, LinearLayout linearLayout, AppBarLayout appBarLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, TabLayout tabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.addGoodsView = linearLayout;
        this.appBar = appBarLayout;
        this.mainContent = drawSystemBarFrameLayout;
        this.tabs = tabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static GoodsSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GoodsSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558572, viewGroup, z, obj);
    }

    public static GoodsSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GoodsSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558572, null, false, obj);
    }

    public static GoodsSearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsSearchBinding bind(View view, Object obj) {
        return (GoodsSearchBinding) bind(obj, view, 2131558572);
    }
}
