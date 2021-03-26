package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.coolapk.market.widget.view.VXProxyFloatingView;

public abstract class VxLayoutBinding extends ViewDataBinding {
    public final FrameLayout appendView;
    public final IgnoreInsetFrameLayout backgroundView;
    public final LinearLayout contentView;
    public final VXProxyFloatingView floatingView;
    public final DrawSystemBarFrameLayout mainContent;
    public final VXNestedScrollView nestedBackgroundView;
    public final NestedScrollView tabContainer;
    public final TabLayout tabs;
    public final ScrollStateViewPager viewPager;

    protected VxLayoutBinding(Object obj, View view, int i, FrameLayout frameLayout, IgnoreInsetFrameLayout ignoreInsetFrameLayout, LinearLayout linearLayout, VXProxyFloatingView vXProxyFloatingView, DrawSystemBarFrameLayout drawSystemBarFrameLayout, VXNestedScrollView vXNestedScrollView, NestedScrollView nestedScrollView, TabLayout tabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appendView = frameLayout;
        this.backgroundView = ignoreInsetFrameLayout;
        this.contentView = linearLayout;
        this.floatingView = vXProxyFloatingView;
        this.mainContent = drawSystemBarFrameLayout;
        this.nestedBackgroundView = vXNestedScrollView;
        this.tabContainer = nestedScrollView;
        this.tabs = tabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static VxLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VxLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VxLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559300, viewGroup, z, obj);
    }

    public static VxLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VxLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VxLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559300, null, false, obj);
    }

    public static VxLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VxLayoutBinding bind(View view, Object obj) {
        return (VxLayoutBinding) bind(obj, view, 2131559300);
    }
}
