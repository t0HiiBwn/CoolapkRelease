package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemForwardEntityShareAppBinding extends ViewDataBinding {
    public final ImageView iconView;
    public final LinearLayout rootView;
    public final TextView titleView;

    protected ItemForwardEntityShareAppBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.iconView = imageView;
        this.rootView = linearLayout;
        this.titleView = textView;
    }

    public static ItemForwardEntityShareAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForwardEntityShareAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemForwardEntityShareAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558756, viewGroup, z, obj);
    }

    public static ItemForwardEntityShareAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForwardEntityShareAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemForwardEntityShareAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558756, null, false, obj);
    }

    public static ItemForwardEntityShareAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForwardEntityShareAppBinding bind(View view, Object obj) {
        return (ItemForwardEntityShareAppBinding) bind(obj, view, 2131558756);
    }
}
