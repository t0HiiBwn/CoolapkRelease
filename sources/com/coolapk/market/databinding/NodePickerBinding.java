package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public abstract class NodePickerBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final CoordinatorLayout mainContent;
    public final ScrollStateViewPager viewPager;

    protected NodePickerBinding(Object obj, View view, int i, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.mainContent = coordinatorLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static NodePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NodePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NodePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559056, viewGroup, z, obj);
    }

    public static NodePickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NodePickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NodePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559056, null, false, obj);
    }

    public static NodePickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NodePickerBinding bind(View view, Object obj) {
        return (NodePickerBinding) bind(obj, view, 2131559056);
    }
}
