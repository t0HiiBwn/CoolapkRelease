package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCenterUserMenuChildBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final LinearLayout itemView;
    public final TextView textView;

    protected ItemCenterUserMenuChildBinding(Object obj, View view, int i, ImageView imageView2, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.itemView = linearLayout;
        this.textView = textView2;
    }

    public static ItemCenterUserMenuChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterUserMenuChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterUserMenuChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558651, viewGroup, z, obj);
    }

    public static ItemCenterUserMenuChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterUserMenuChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterUserMenuChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558651, null, false, obj);
    }

    public static ItemCenterUserMenuChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterUserMenuChildBinding bind(View view, Object obj) {
        return (ItemCenterUserMenuChildBinding) bind(obj, view, 2131558651);
    }
}
