package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemSecondHandFallBinding extends ViewDataBinding {
    public final UserAvatarView avatarView;
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final TextView exchangePriceView;
    public final FrameLayout frameView;
    public final TextView infoText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final ScalingImageView picView;
    public final TextView priceText;
    public final ImageView selledView;
    public final ImageView signLink;
    public final TextView signLinkText;
    public final TextView titleTagView;
    public final TextView titleView;
    public final TextView userName;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemSecondHandFallBinding(Object obj, View view, int i, UserAvatarView userAvatarView, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView, FrameLayout frameLayout, TextView textView2, ScalingImageView scalingImageView, TextView textView3, ImageView imageView, ImageView imageView2, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.avatarView = userAvatarView;
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.exchangePriceView = textView;
        this.frameView = frameLayout;
        this.infoText = textView2;
        this.picView = scalingImageView;
        this.priceText = textView3;
        this.selledView = imageView;
        this.signLink = imageView2;
        this.signLinkText = textView4;
        this.titleTagView = textView5;
        this.titleView = textView6;
        this.userName = textView7;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemSecondHandFallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandFallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSecondHandFallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558926, viewGroup, z, obj);
    }

    public static ItemSecondHandFallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandFallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSecondHandFallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558926, null, false, obj);
    }

    public static ItemSecondHandFallBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandFallBinding bind(View view, Object obj) {
        return (ItemSecondHandFallBinding) bind(obj, view, 2131558926);
    }
}
