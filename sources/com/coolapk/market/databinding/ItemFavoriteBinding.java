package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Favorite;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemFavoriteBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final LinearLayout itemView;
    @Bindable
    protected Favorite mModel;
    public final TextView titleView;
    public final RoundedImageView userAvatarView;
    public final TextView userNameView;

    public abstract void setModel(Favorite favorite);

    protected ItemFavoriteBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, RoundedImageView roundedImageView, TextView textView3) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.itemView = linearLayout;
        this.titleView = textView2;
        this.userAvatarView = roundedImageView;
        this.userNameView = textView3;
    }

    public Favorite getModel() {
        return this.mModel;
    }

    public static ItemFavoriteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFavoriteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFavoriteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558695, viewGroup, z, obj);
    }

    public static ItemFavoriteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFavoriteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFavoriteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558695, null, false, obj);
    }

    public static ItemFavoriteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFavoriteBinding bind(View view, Object obj) {
        return (ItemFavoriteBinding) bind(obj, view, 2131558695);
    }
}
