package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemRelatedDataBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final RoundedImageView iconView;
    @Bindable
    protected String mAvatar;
    @Bindable
    protected String mName;
    public final TextView titleView;

    public abstract void setAvatar(String str);

    public abstract void setName(String str);

    protected ItemRelatedDataBinding(Object obj, View view, int i, LinearLayout linearLayout, RoundedImageView roundedImageView, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = roundedImageView;
        this.titleView = textView;
    }

    public String getName() {
        return this.mName;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public static ItemRelatedDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelatedDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRelatedDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558902, viewGroup, z, obj);
    }

    public static ItemRelatedDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelatedDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRelatedDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558902, null, false, obj);
    }

    public static ItemRelatedDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelatedDataBinding bind(View view, Object obj) {
        return (ItemRelatedDataBinding) bind(obj, view, 2131558902);
    }
}
