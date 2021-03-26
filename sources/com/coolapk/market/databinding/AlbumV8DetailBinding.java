package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.CommentBar;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public abstract class AlbumV8DetailBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final CommentBar commentBar;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final CoordinatorLayout mainContent;
    public final Toolbar toolbar;
    public final ScrollStateViewPager viewPager;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumV8DetailBinding(Object obj, View view, int i, AppBarLayout appBarLayout, CommentBar commentBar2, ProgressBar progressBar, CoordinatorLayout coordinatorLayout, Toolbar toolbar2, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.commentBar = commentBar2;
        this.loadingView = progressBar;
        this.mainContent = coordinatorLayout;
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

    public static AlbumV8DetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumV8DetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumV8DetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558452, viewGroup, z, obj);
    }

    public static AlbumV8DetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumV8DetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumV8DetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558452, null, false, obj);
    }

    public static AlbumV8DetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumV8DetailBinding bind(View view, Object obj) {
        return (AlbumV8DetailBinding) bind(obj, view, 2131558452);
    }
}
