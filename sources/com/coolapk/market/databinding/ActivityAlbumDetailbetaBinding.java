package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.CommentBar;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ActivityAlbumDetailbetaBinding extends ViewDataBinding {
    public final FrameLayout albumList;
    public final AppBarLayout appBar;
    public final CommentBar commentBar;
    public final ProgressBar loadingView;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final CoordinatorLayout mainContent;
    public final Toolbar toolbar;

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected ActivityAlbumDetailbetaBinding(Object obj, View view, int i, FrameLayout frameLayout, AppBarLayout appBarLayout, CommentBar commentBar2, ProgressBar progressBar, CoordinatorLayout coordinatorLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.albumList = frameLayout;
        this.appBar = appBarLayout;
        this.commentBar = commentBar2;
        this.loadingView = progressBar;
        this.mainContent = coordinatorLayout;
        this.toolbar = toolbar2;
    }

    public AlbumDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ActivityAlbumDetailbetaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAlbumDetailbetaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAlbumDetailbetaBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558432, viewGroup, z, obj);
    }

    public static ActivityAlbumDetailbetaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAlbumDetailbetaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAlbumDetailbetaBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558432, null, false, obj);
    }

    public static ActivityAlbumDetailbetaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAlbumDetailbetaBinding bind(View view, Object obj) {
        return (ActivityAlbumDetailbetaBinding) bind(obj, view, 2131558432);
    }
}
