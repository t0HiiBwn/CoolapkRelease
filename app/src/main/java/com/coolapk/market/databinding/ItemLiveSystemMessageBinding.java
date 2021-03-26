package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemLiveSystemMessageBinding extends ViewDataBinding {
    public final ImageView indicatorView;
    public final TextView messageView;

    protected ItemLiveSystemMessageBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.indicatorView = imageView;
        this.messageView = textView;
    }

    public static ItemLiveSystemMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveSystemMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveSystemMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558809, viewGroup, z, obj);
    }

    public static ItemLiveSystemMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveSystemMessageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveSystemMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558809, null, false, obj);
    }

    public static ItemLiveSystemMessageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveSystemMessageBinding bind(View view, Object obj) {
        return (ItemLiveSystemMessageBinding) bind(obj, view, 2131558809);
    }
}
