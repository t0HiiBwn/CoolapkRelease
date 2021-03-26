package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public abstract class AlbumDetailtViewBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final Space commentBarSpaceView;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final DrawSystemBarFrameLayout mainContent;
    public final PhotoView maskView;
    public final Toolbar toolbar;
    public final ScrollStateViewPager viewPager;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumDetailtViewBinding(Object obj, View view, int i, AppBarLayout appBarLayout, Space space, ProgressBar progressBar, DrawSystemBarFrameLayout drawSystemBarFrameLayout, PhotoView photoView, Toolbar toolbar2, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.commentBarSpaceView = space;
        this.loadingView = progressBar;
        this.mainContent = drawSystemBarFrameLayout;
        this.maskView = photoView;
        this.toolbar = toolbar2;
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

    public static AlbumDetailtViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailtViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumDetailtViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558446, viewGroup, z, obj);
    }

    public static AlbumDetailtViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailtViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumDetailtViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558446, null, false, obj);
    }

    public static AlbumDetailtViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailtViewBinding bind(View view, Object obj) {
        return (AlbumDetailtViewBinding) bind(obj, view, 2131558446);
    }
}
