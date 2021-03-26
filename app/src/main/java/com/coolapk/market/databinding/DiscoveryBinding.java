package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;

public abstract class DiscoveryBinding extends ViewDataBinding {
    public final LinearLayout rootView;
    public final TabLayout tabs;
    public final ScrollStateViewPager viewPager;

    protected DiscoveryBinding(Object obj, View view, int i, LinearLayout linearLayout, TabLayout tabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.rootView = linearLayout;
        this.tabs = tabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static DiscoveryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiscoveryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DiscoveryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558539, viewGroup, z, obj);
    }

    public static DiscoveryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiscoveryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DiscoveryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558539, null, false, obj);
    }

    public static DiscoveryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiscoveryBinding bind(View view, Object obj) {
        return (DiscoveryBinding) bind(obj, view, 2131558539);
    }
}
