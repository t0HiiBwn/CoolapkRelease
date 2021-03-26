package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemAppViewHolderBinding extends ViewDataBinding {
    protected ItemAppViewHolderBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemAppViewHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558609, viewGroup, z, obj);
    }

    public static ItemAppViewHolderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558609, null, false, obj);
    }

    public static ItemAppViewHolderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewHolderBinding bind(View view, Object obj) {
        return (ItemAppViewHolderBinding) bind(obj, view, 2131558609);
    }
}
