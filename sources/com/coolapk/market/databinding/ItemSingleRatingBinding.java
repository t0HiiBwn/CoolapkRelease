package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemSingleRatingBinding extends ViewDataBinding {
    public final CoolapkCardView itemView;
    @Bindable
    protected int mBuyStatus;
    @Bindable
    protected String mLogo;
    public final BadBadRatingBar ratingBar;
    public final TextView scoreTitle;
    public final RoundedImageView userAvatarView;

    public abstract void setBuyStatus(int i);

    public abstract void setLogo(String str);

    protected ItemSingleRatingBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView, BadBadRatingBar badBadRatingBar, TextView textView, RoundedImageView roundedImageView) {
        super(obj, view, i);
        this.itemView = coolapkCardView;
        this.ratingBar = badBadRatingBar;
        this.scoreTitle = textView;
        this.userAvatarView = roundedImageView;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public int getBuyStatus() {
        return this.mBuyStatus;
    }

    public static ItemSingleRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSingleRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSingleRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558941, viewGroup, z, obj);
    }

    public static ItemSingleRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSingleRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSingleRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558941, null, false, obj);
    }

    public static ItemSingleRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSingleRatingBinding bind(View view, Object obj) {
        return (ItemSingleRatingBinding) bind(obj, view, 2131558941);
    }
}
