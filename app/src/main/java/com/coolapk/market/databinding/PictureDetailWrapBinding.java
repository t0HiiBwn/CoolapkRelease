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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class PictureDetailWrapBinding extends ViewDataBinding {
    public final LinearLayout actionInfoView;
    public final AppBarLayout appBar;
    public final FrameLayout bottomView;
    public final FrameLayout coolpicContent;
    public final View coverMaskView;
    public final ImageView coverView;
    public final View fakeBgView;
    public final Toolbar holderView;
    @Bindable
    protected Feed mFeed;
    public final ProgressBar progressBar;
    public final TextView recommendSplashView;
    public final TextView recommendView;
    public final TextView setWallpaperView;
    public final CollapsingToolbarFixLayout toolbarLayout;

    public abstract void setFeed(Feed feed);

    protected PictureDetailWrapBinding(Object obj, View view, int i, LinearLayout linearLayout, AppBarLayout appBarLayout, FrameLayout frameLayout, FrameLayout frameLayout2, View view2, ImageView imageView, View view3, Toolbar toolbar, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, CollapsingToolbarFixLayout collapsingToolbarFixLayout) {
        super(obj, view, i);
        this.actionInfoView = linearLayout;
        this.appBar = appBarLayout;
        this.bottomView = frameLayout;
        this.coolpicContent = frameLayout2;
        this.coverMaskView = view2;
        this.coverView = imageView;
        this.fakeBgView = view3;
        this.holderView = toolbar;
        this.progressBar = progressBar2;
        this.recommendSplashView = textView;
        this.recommendView = textView2;
        this.setWallpaperView = textView3;
        this.toolbarLayout = collapsingToolbarFixLayout;
    }

    public Feed getFeed() {
        return this.mFeed;
    }

    public static PictureDetailWrapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PictureDetailWrapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PictureDetailWrapBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559087, viewGroup, z, obj);
    }

    public static PictureDetailWrapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PictureDetailWrapBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PictureDetailWrapBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559087, null, false, obj);
    }

    public static PictureDetailWrapBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PictureDetailWrapBinding bind(View view, Object obj) {
        return (PictureDetailWrapBinding) bind(obj, view, 2131559087);
    }
}
