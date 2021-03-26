package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public abstract class TabLayoutBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final DrawSystemBarFrameLayout baseView;
    public final CoordinatorLayout mainContent;
    public final Space tabs;
    public final Toolbar toolbar;
    public final ScrollStateViewPager viewPager;

    protected TabLayoutBinding(Object obj, View view, int i, AppBarLayout appBarLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, CoordinatorLayout coordinatorLayout, Space space, Toolbar toolbar2, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.baseView = drawSystemBarFrameLayout;
        this.mainContent = coordinatorLayout;
        this.tabs = space;
        this.toolbar = toolbar2;
        this.viewPager = scrollStateViewPager;
    }

    public static TabLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TabLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TabLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559184, viewGroup, z, obj);
    }

    public static TabLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TabLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TabLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559184, null, false, obj);
    }

    public static TabLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TabLayoutBinding bind(View view, Object obj) {
        return (TabLayoutBinding) bind(obj, view, 2131559184);
    }
}
