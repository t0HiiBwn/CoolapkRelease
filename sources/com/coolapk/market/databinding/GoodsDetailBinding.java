package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.AlphableAppBarLayout;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class GoodsDetailBinding extends ViewDataBinding {
    public final LinearLayout actionView;
    public final AlphableAppBarLayout appBar;
    public final CoordinatorLayout coordinator;
    public final FloatingActionButton floatingButton;
    public final LinearLayout headerContainer;
    public final ImageView iconView;
    public final LoadingViewBinding loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedGoods mModel;
    public final DrawSystemBarFrameLayout mainContent;
    public final Space spaceHolder;
    public final IgnoreInsetFrameLayout tabContainer;
    public final TabLayout tabs;
    public final TextView titleView;
    public final Toolbar toolbar;
    public final UserToolbarBinding userToolbar;
    public final ScrollStateViewPager viewPager;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedGoods feedGoods);

    protected GoodsDetailBinding(Object obj, View view, int i, LinearLayout linearLayout, AlphableAppBarLayout alphableAppBarLayout, CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, LinearLayout linearLayout2, ImageView imageView, LoadingViewBinding loadingViewBinding, DrawSystemBarFrameLayout drawSystemBarFrameLayout, Space space, IgnoreInsetFrameLayout ignoreInsetFrameLayout, TabLayout tabLayout, TextView textView, Toolbar toolbar2, UserToolbarBinding userToolbarBinding, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.actionView = linearLayout;
        this.appBar = alphableAppBarLayout;
        this.coordinator = coordinatorLayout;
        this.floatingButton = floatingActionButton;
        this.headerContainer = linearLayout2;
        this.iconView = imageView;
        this.loadingView = loadingViewBinding;
        this.mainContent = drawSystemBarFrameLayout;
        this.spaceHolder = space;
        this.tabContainer = ignoreInsetFrameLayout;
        this.tabs = tabLayout;
        this.titleView = textView;
        this.toolbar = toolbar2;
        this.userToolbar = userToolbarBinding;
        this.viewPager = scrollStateViewPager;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public FeedGoods getModel() {
        return this.mModel;
    }

    public static GoodsDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GoodsDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558568, viewGroup, z, obj);
    }

    public static GoodsDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GoodsDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558568, null, false, obj);
    }

    public static GoodsDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GoodsDetailBinding bind(View view, Object obj) {
        return (GoodsDetailBinding) bind(obj, view, 2131558568);
    }
}
