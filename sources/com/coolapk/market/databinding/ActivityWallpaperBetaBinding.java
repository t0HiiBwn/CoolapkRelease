package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ActivityWallpaperBetaBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final FrameLayout coolpicViewRecycler;
    public final ImageView coverView;
    public final FrameLayout headerView;
    @Bindable
    protected Feed mFeed;
    public final ProgressBar progressBar;
    public final TextView recommendSplashView;
    public final TextView recommendView;
    public final TextView setWallpaperView;
    public final TextView textView6;
    public final Toolbar toolbar;
    public final CollapsingToolbarFixLayout toolbarLayout;

    public abstract void setFeed(Feed feed);

    protected ActivityWallpaperBetaBinding(Object obj, View view, int i, AppBarLayout appBarLayout, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, Toolbar toolbar2, CollapsingToolbarFixLayout collapsingToolbarFixLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.coolpicViewRecycler = frameLayout;
        this.coverView = imageView;
        this.headerView = frameLayout2;
        this.progressBar = progressBar2;
        this.recommendSplashView = textView;
        this.recommendView = textView2;
        this.setWallpaperView = textView3;
        this.textView6 = textView4;
        this.toolbar = toolbar2;
        this.toolbarLayout = collapsingToolbarFixLayout;
    }

    public Feed getFeed() {
        return this.mFeed;
    }

    public static ActivityWallpaperBetaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWallpaperBetaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWallpaperBetaBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558436, viewGroup, z, obj);
    }

    public static ActivityWallpaperBetaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWallpaperBetaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWallpaperBetaBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558436, null, false, obj);
    }

    public static ActivityWallpaperBetaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWallpaperBetaBinding bind(View view, Object obj) {
        return (ActivityWallpaperBetaBinding) bind(obj, view, 2131558436);
    }
}
