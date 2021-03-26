package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Album;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemNotificationAlbumLikeBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final TextView desView;
    public final ImageView iconView;
    public final LinearLayout itemAlbumView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Album mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView recommendView;
    public final LinearLayout strokeView;
    public final TextView textView;
    public final UserAvatarView userAvatarView;
    public final TextView userName;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Album album);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemNotificationAlbumLikeBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView2, ImageView imageView, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, TextView textView4, UserAvatarView userAvatarView2, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.desView = textView2;
        this.iconView = imageView;
        this.itemAlbumView = linearLayout2;
        this.recommendView = textView3;
        this.strokeView = linearLayout3;
        this.textView = textView4;
        this.userAvatarView = userAvatarView2;
        this.userName = textView5;
        this.userNameView = textView6;
    }

    public Album getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemNotificationAlbumLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationAlbumLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNotificationAlbumLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558850, viewGroup, z, obj);
    }

    public static ItemNotificationAlbumLikeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationAlbumLikeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNotificationAlbumLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558850, null, false, obj);
    }

    public static ItemNotificationAlbumLikeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationAlbumLikeBinding bind(View view, Object obj) {
        return (ItemNotificationAlbumLikeBinding) bind(obj, view, 2131558850);
    }
}
