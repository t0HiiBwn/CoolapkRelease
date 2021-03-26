package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class RefreshRecyclerTabsBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final View divider;
    public final CoordinatorLayout mainContent;
    public final FrameLayout tabContainer;
    public final TabLayout tabs;
    public final ScrollStateViewPager viewPager;

    protected RefreshRecyclerTabsBinding(Object obj, View view, int i, AppBarLayout appBarLayout, View view2, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, TabLayout tabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.divider = view2;
        this.mainContent = coordinatorLayout;
        this.tabContainer = frameLayout;
        this.tabs = tabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static RefreshRecyclerTabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshRecyclerTabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RefreshRecyclerTabsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559122, viewGroup, z, obj);
    }

    public static RefreshRecyclerTabsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshRecyclerTabsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RefreshRecyclerTabsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559122, null, false, obj);
    }

    public static RefreshRecyclerTabsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshRecyclerTabsBinding bind(View view, Object obj) {
        return (RefreshRecyclerTabsBinding) bind(obj, view, 2131559122);
    }
}
