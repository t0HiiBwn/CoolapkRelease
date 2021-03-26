package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCenterMoreMenuBinding extends ViewDataBinding {
    public final ImageView addView;
    public final TextView bubbleTextView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    public final ImageView moreView;
    public final TextView textView;

    protected ItemCenterMoreMenuBinding(Object obj, View view, int i, ImageView imageView2, TextView textView2, ImageView imageView3, LinearLayout linearLayout, ImageView imageView4, TextView textView3) {
        super(obj, view, i);
        this.addView = imageView2;
        this.bubbleTextView = textView2;
        this.imageView = imageView3;
        this.itemView = linearLayout;
        this.moreView = imageView4;
        this.textView = textView3;
    }

    public static ItemCenterMoreMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterMoreMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558641, viewGroup, z, obj);
    }

    public static ItemCenterMoreMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterMoreMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558641, null, false, obj);
    }

    public static ItemCenterMoreMenuBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreMenuBinding bind(View view, Object obj) {
        return (ItemCenterMoreMenuBinding) bind(obj, view, 2131558641);
    }
}
