package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.CommentBar;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class AlbumDetailBinding extends ViewDataBinding {
    public final ImageView albumIconView;
    public final AppBarLayout appBar;
    public final CollapsingToolbarFixLayout collapsingToolbar;
    public final CommentBar commentBar;
    public final ImageView coverView;
    public final View coverViewMask;
    public final View diverView;
    public final View divider;
    public final LinearLayout headerView;
    public final LinearLayout infoViewContainer;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final CoordinatorLayout mainContent;
    public final LinearLayout recommendFeedContainer;
    public final FrameLayout tabContainer;
    public final TabLayout tabs;
    public final TextView titleView;
    public final Toolbar toolbar;
    public final LinearLayout userBgimage;
    public final TextView userInfoView;
    public final ScrollStateViewPager viewPager;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumDetailBinding(Object obj, View view, int i, ImageView imageView, AppBarLayout appBarLayout, CollapsingToolbarFixLayout collapsingToolbarFixLayout, CommentBar commentBar2, ImageView imageView2, View view2, View view3, View view4, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout3, FrameLayout frameLayout, TabLayout tabLayout, TextView textView, Toolbar toolbar2, LinearLayout linearLayout4, TextView textView2, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.albumIconView = imageView;
        this.appBar = appBarLayout;
        this.collapsingToolbar = collapsingToolbarFixLayout;
        this.commentBar = commentBar2;
        this.coverView = imageView2;
        this.coverViewMask = view2;
        this.diverView = view3;
        this.divider = view4;
        this.headerView = linearLayout;
        this.infoViewContainer = linearLayout2;
        this.loadingView = progressBar;
        this.mainContent = coordinatorLayout;
        this.recommendFeedContainer = linearLayout3;
        this.tabContainer = frameLayout;
        this.tabs = tabLayout;
        this.titleView = textView;
        this.toolbar = toolbar2;
        this.userBgimage = linearLayout4;
        this.userInfoView = textView2;
        this.viewPager = scrollStateViewPager;
    }

    public AlbumDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static AlbumDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558443, viewGroup, z, obj);
    }

    public static AlbumDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558443, null, false, obj);
    }

    public static AlbumDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailBinding bind(View view, Object obj) {
        return (AlbumDetailBinding) bind(obj, view, 2131558443);
    }
}
