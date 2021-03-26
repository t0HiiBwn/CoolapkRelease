package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemMoreActionBinding extends ViewDataBinding {
    public final ImageView actionIcon;
    public final TextView actionTitle;
    public final LinearLayout actionView;

    protected ItemMoreActionBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionIcon = imageView;
        this.actionTitle = textView;
        this.actionView = linearLayout;
    }

    public static ItemMoreActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoreActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMoreActionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558838, viewGroup, z, obj);
    }

    public static ItemMoreActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoreActionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMoreActionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558838, null, false, obj);
    }

    public static ItemMoreActionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMoreActionBinding bind(View view, Object obj) {
        return (ItemMoreActionBinding) bind(obj, view, 2131558838);
    }
}
