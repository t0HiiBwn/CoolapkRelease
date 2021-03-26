package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public abstract class NewV8AlbumBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final UserAvatarView avatarView;
    public final View baseView;
    public final CardView cardView;
    public final ImageView coverView;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final CoordinatorLayout mainContent;
    public final TextView titleView;
    public final Toolbar toolbar;
    public final ScrollStateViewPager viewPager;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected NewV8AlbumBinding(Object obj, View view, int i, AppBarLayout appBarLayout, UserAvatarView userAvatarView, View view2, CardView cardView2, ImageView imageView, TextView textView, CoordinatorLayout coordinatorLayout, TextView textView2, Toolbar toolbar2, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.avatarView = userAvatarView;
        this.baseView = view2;
        this.cardView = cardView2;
        this.coverView = imageView;
        this.infoView = textView;
        this.mainContent = coordinatorLayout;
        this.titleView = textView2;
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

    public static NewV8AlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewV8AlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NewV8AlbumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559061, viewGroup, z, obj);
    }

    public static NewV8AlbumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewV8AlbumBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NewV8AlbumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559061, null, false, obj);
    }

    public static NewV8AlbumBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewV8AlbumBinding bind(View view, Object obj) {
        return (NewV8AlbumBinding) bind(obj, view, 2131559061);
    }
}
