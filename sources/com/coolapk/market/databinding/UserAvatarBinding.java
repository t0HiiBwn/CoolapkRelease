package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class UserAvatarBinding extends ViewDataBinding {
    public final ImageView iconView;
    @Bindable
    protected String mAvatar;
    public final TextView pickButton;

    public abstract void setAvatar(String str);

    protected UserAvatarBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.iconView = imageView;
        this.pickButton = textView;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public static UserAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserAvatarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559280, viewGroup, z, obj);
    }

    public static UserAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserAvatarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserAvatarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559280, null, false, obj);
    }

    public static UserAvatarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserAvatarBinding bind(View view, Object obj) {
        return (UserAvatarBinding) bind(obj, view, 2131559280);
    }
}
