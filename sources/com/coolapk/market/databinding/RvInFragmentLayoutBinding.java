package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.NestedCoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class RvInFragmentLayoutBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final FrameLayout contentFragment;
    public final NestedCoordinatorLayout mainContent;

    protected RvInFragmentLayoutBinding(Object obj, View view, int i, AppBarLayout appBarLayout, FrameLayout frameLayout, NestedCoordinatorLayout nestedCoordinatorLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.contentFragment = frameLayout;
        this.mainContent = nestedCoordinatorLayout;
    }

    public static RvInFragmentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RvInFragmentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RvInFragmentLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559125, viewGroup, z, obj);
    }

    public static RvInFragmentLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RvInFragmentLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RvInFragmentLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559125, null, false, obj);
    }

    public static RvInFragmentLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RvInFragmentLayoutBinding bind(View view, Object obj) {
        return (RvInFragmentLayoutBinding) bind(obj, view, 2131559125);
    }
}
