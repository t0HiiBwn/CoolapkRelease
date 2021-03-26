package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;

public abstract class HomeBinding extends ViewDataBinding {
    public final ProgressBar loadingView;
    public final RelativeLayout rootView;
    public final ScrollStateViewPager viewPager;

    protected HomeBinding(Object obj, View view, int i, ProgressBar progressBar, RelativeLayout relativeLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.loadingView = progressBar;
        this.rootView = relativeLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static HomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HomeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558574, viewGroup, z, obj);
    }

    public static HomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HomeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558574, null, false, obj);
    }

    public static HomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeBinding bind(View view, Object obj) {
        return (HomeBinding) bind(obj, view, 2131558574);
    }
}
