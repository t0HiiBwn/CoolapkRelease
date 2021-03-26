package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProductConfigItemBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final LinearLayout itemView;
    public final TextView titleView;

    protected ItemProductConfigItemBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public static ItemProductConfigItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductConfigItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductConfigItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558862, viewGroup, z, obj);
    }

    public static ItemProductConfigItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductConfigItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductConfigItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558862, null, false, obj);
    }

    public static ItemProductConfigItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductConfigItemBinding bind(View view, Object obj) {
        return (ItemProductConfigItemBinding) bind(obj, view, 2131558862);
    }
}
