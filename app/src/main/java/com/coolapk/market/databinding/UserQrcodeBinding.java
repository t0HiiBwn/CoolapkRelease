package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.SquareImageView;
import com.coolapk.market.widget.UserAvatarView;

public abstract class UserQrcodeBinding extends ViewDataBinding {
    public final ImageView actionQrScan;
    public final ImageView actionSave;
    public final ImageView actionShare;
    public final FrameLayout contentView;
    public final TextView descriptionView;
    public final ImageView logoView;
    public final SquareImageView qrCodeView;
    public final LinearLayout qrViewContainer;
    public final LinearLayout topContainer;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    protected UserQrcodeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout, TextView textView, ImageView imageView4, SquareImageView squareImageView, LinearLayout linearLayout, LinearLayout linearLayout2, UserAvatarView userAvatarView2, TextView textView2) {
        super(obj, view, i);
        this.actionQrScan = imageView;
        this.actionSave = imageView2;
        this.actionShare = imageView3;
        this.contentView = frameLayout;
        this.descriptionView = textView;
        this.logoView = imageView4;
        this.qrCodeView = squareImageView;
        this.qrViewContainer = linearLayout;
        this.topContainer = linearLayout2;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView2;
    }

    public static UserQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserQrcodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559284, viewGroup, z, obj);
    }

    public static UserQrcodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserQrcodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserQrcodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559284, null, false, obj);
    }

    public static UserQrcodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserQrcodeBinding bind(View view, Object obj) {
        return (UserQrcodeBinding) bind(obj, view, 2131559284);
    }
}
