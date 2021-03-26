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
import com.coolapk.market.widget.AlbumActionView;
import com.coolapk.market.widget.CommentBar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public abstract class AlbumDetailV8V2Binding extends ViewDataBinding {
    public final AlbumActionView albumAction;
    public final FrameLayout albumList;
    public final AppBarLayout appBar;
    public final CollapsingToolbarLayout collapsingToolbar;
    public final CommentBar commentBar;
    public final ImageView coverView;
    public final TextView infoView;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final CoordinatorLayout mainContent;
    public final LinearLayout maskBackView;
    public final ImageView maskView;
    public final LinearLayout textContainer;
    public final TextView titleView;
    public final Toolbar toolbar;
    public final LinearLayout userBgimage;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumDetailV8V2Binding(Object obj, View view, int i, AlbumActionView albumActionView, FrameLayout frameLayout, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, CommentBar commentBar2, ImageView imageView, TextView textView, ProgressBar progressBar, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, TextView textView2, Toolbar toolbar2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.albumAction = albumActionView;
        this.albumList = frameLayout;
        this.appBar = appBarLayout;
        this.collapsingToolbar = collapsingToolbarLayout;
        this.commentBar = commentBar2;
        this.coverView = imageView;
        this.infoView = textView;
        this.loadingView = progressBar;
        this.mainContent = coordinatorLayout;
        this.maskBackView = linearLayout;
        this.maskView = imageView2;
        this.textContainer = linearLayout2;
        this.titleView = textView2;
        this.toolbar = toolbar2;
        this.userBgimage = linearLayout3;
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

    public static AlbumDetailV8V2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailV8V2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumDetailV8V2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558444, viewGroup, z, obj);
    }

    public static AlbumDetailV8V2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailV8V2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumDetailV8V2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558444, null, false, obj);
    }

    public static AlbumDetailV8V2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumDetailV8V2Binding bind(View view, Object obj) {
        return (AlbumDetailV8V2Binding) bind(obj, view, 2131558444);
    }
}
