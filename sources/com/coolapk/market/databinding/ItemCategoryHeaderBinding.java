package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCategoryHeaderBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final TextView textView;

    protected ItemCategoryHeaderBinding(Object obj, View view, int i, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.textView = textView2;
    }

    public static ItemCategoryHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCategoryHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCategoryHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558643, viewGroup, z, obj);
    }

    public static ItemCategoryHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCategoryHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCategoryHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558643, null, false, obj);
    }

    public static ItemCategoryHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCategoryHeaderBinding bind(View view, Object obj) {
        return (ItemCategoryHeaderBinding) bind(obj, view, 2131558643);
    }
}
