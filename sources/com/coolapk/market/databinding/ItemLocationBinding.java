package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemLocationBinding extends ViewDataBinding {
    public final TextView contentView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    public final TextView titleView;

    protected ItemLocationBinding(Object obj, View view, int i, TextView textView, ImageView imageView2, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.contentView = textView;
        this.imageView = imageView2;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public static ItemLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLocationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558820, viewGroup, z, obj);
    }

    public static ItemLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLocationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558820, null, false, obj);
    }

    public static ItemLocationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocationBinding bind(View view, Object obj) {
        return (ItemLocationBinding) bind(obj, view, 2131558820);
    }
}
