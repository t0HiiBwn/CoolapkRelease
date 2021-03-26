package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Album;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class AlbumUserInfoBinding extends ViewDataBinding {
    public final ActionButtonFrameLayout actionContainer;
    public final TextView albumInfoView;
    @Bindable
    protected Album mAlbum;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView userFollowActionButton;
    public final ImageView userLogoView;
    public final TextView userNameView;

    public abstract void setAlbum(Album album);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected AlbumUserInfoBinding(Object obj, View view, int i, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView, TextView textView2, ImageView imageView, TextView textView3) {
        super(obj, view, i);
        this.actionContainer = actionButtonFrameLayout;
        this.albumInfoView = textView;
        this.userFollowActionButton = textView2;
        this.userLogoView = imageView;
        this.userNameView = textView3;
    }

    public Album getAlbum() {
        return this.mAlbum;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static AlbumUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558452, viewGroup, z, obj);
    }

    public static AlbumUserInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumUserInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558452, null, false, obj);
    }

    public static AlbumUserInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumUserInfoBinding bind(View view, Object obj) {
        return (AlbumUserInfoBinding) bind(obj, view, 2131558452);
    }
}
