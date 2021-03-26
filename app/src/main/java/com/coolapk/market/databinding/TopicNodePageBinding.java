package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.ShapedImageView;
import com.coolapk.market.widget.view.TabLayout;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.coolapk.market.widget.view.VXProxyFloatingView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class TopicNodePageBinding extends ViewDataBinding {
    public final FrameLayout appBar;
    public final FrameLayout appendView;
    public final FrameLayout backgroundView;
    public final LinearLayout contentView;
    public final View divider;
    public final FloatingActionButton floatingButton;
    public final VXProxyFloatingView floatingView;
    public final TextView hintView;
    public final FrameLayout loadingContainer;
    public final ShapedImageView loadingPlaceHolder;
    public final ProgressBar loadingView;
    public final DrawSystemBarFrameLayout mainContent;
    public final VXNestedScrollView nestedBackgroundView;
    public final NestedScrollView tabContainer;
    public final FrameLayout tabSuperContainer;
    public final TabLayout tabs;
    public final Toolbar toolbar;
    public final FrameLayout toolbarContent;
    public final ScrollStateViewPager viewPager;

    protected TopicNodePageBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout, View view2, FloatingActionButton floatingActionButton, VXProxyFloatingView vXProxyFloatingView, TextView textView, FrameLayout frameLayout4, ShapedImageView shapedImageView, ProgressBar progressBar, DrawSystemBarFrameLayout drawSystemBarFrameLayout, VXNestedScrollView vXNestedScrollView, NestedScrollView nestedScrollView, FrameLayout frameLayout5, TabLayout tabLayout, Toolbar toolbar2, FrameLayout frameLayout6, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = frameLayout;
        this.appendView = frameLayout2;
        this.backgroundView = frameLayout3;
        this.contentView = linearLayout;
        this.divider = view2;
        this.floatingButton = floatingActionButton;
        this.floatingView = vXProxyFloatingView;
        this.hintView = textView;
        this.loadingContainer = frameLayout4;
        this.loadingPlaceHolder = shapedImageView;
        this.loadingView = progressBar;
        this.mainContent = drawSystemBarFrameLayout;
        this.nestedBackgroundView = vXNestedScrollView;
        this.tabContainer = nestedScrollView;
        this.tabSuperContainer = frameLayout5;
        this.tabs = tabLayout;
        this.toolbar = toolbar2;
        this.toolbarContent = frameLayout6;
        this.viewPager = scrollStateViewPager;
    }

    public static TopicNodePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TopicNodePageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559204, viewGroup, z, obj);
    }

    public static TopicNodePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodePageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TopicNodePageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559204, null, false, obj);
    }

    public static TopicNodePageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodePageBinding bind(View view, Object obj) {
        return (TopicNodePageBinding) bind(obj, view, 2131559204);
    }
}
