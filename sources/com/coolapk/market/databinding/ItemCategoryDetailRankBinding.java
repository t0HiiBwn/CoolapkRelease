package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCategoryDetailRankBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final TextView textView;

    protected ItemCategoryDetailRankBinding(Object obj, View view, int i, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.textView = textView2;
    }

    public static ItemCategoryDetailRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCategoryDetailRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCategoryDetailRankBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558636, viewGroup, z, obj);
    }

    public static ItemCategoryDetailRankBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCategoryDetailRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCategoryDetailRankBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558636, null, false, obj);
    }

    public static ItemCategoryDetailRankBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCategoryDetailRankBinding bind(View view, Object obj) {
        return (ItemCategoryDetailRankBinding) bind(obj, view, 2131558636);
    }
}
