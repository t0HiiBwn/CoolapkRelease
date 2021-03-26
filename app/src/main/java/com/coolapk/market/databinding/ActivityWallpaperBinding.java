package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.RatioImageView;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ActivityWallpaperBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final CollapsingToolbarFixLayout collapsingToolbar;
    public final FrameLayout coolpicViewRecycler;
    public final RatioImageView coverView;
    @Bindable
    protected Feed mFeed;
    @Bindable
    protected OnImageLoadListener mLoadListener;
    public final CoordinatorLayout mainContent;
    public final TextView setWallpaperView;
    public final TextView textView6;
    public final Toolbar toolbar;

    public abstract void setFeed(Feed feed);

    public abstract void setLoadListener(OnImageLoadListener onImageLoadListener);

    protected ActivityWallpaperBinding(Object obj, View view, int i, AppBarLayout appBarLayout, CollapsingToolbarFixLayout collapsingToolbarFixLayout, FrameLayout frameLayout, RatioImageView ratioImageView, CoordinatorLayout coordinatorLayout, TextView textView, TextView textView2, Toolbar toolbar2) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.collapsingToolbar = collapsingToolbarFixLayout;
        this.coolpicViewRecycler = frameLayout;
        this.coverView = ratioImageView;
        this.mainContent = coordinatorLayout;
        this.setWallpaperView = textView;
        this.textView6 = textView2;
        this.toolbar = toolbar2;
    }

    public Feed getFeed() {
        return this.mFeed;
    }

    public OnImageLoadListener getLoadListener() {
        return this.mLoadListener;
    }

    public static ActivityWallpaperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWallpaperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWallpaperBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558434, viewGroup, z, obj);
    }

    public static ActivityWallpaperBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWallpaperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWallpaperBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558434, null, false, obj);
    }

    public static ActivityWallpaperBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWallpaperBinding bind(View view, Object obj) {
        return (ActivityWallpaperBinding) bind(obj, view, 2131558434);
    }
}
