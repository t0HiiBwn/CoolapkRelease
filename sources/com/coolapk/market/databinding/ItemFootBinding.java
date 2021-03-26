package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFootBinding extends ViewDataBinding {
    protected ItemFootBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFootBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558748, viewGroup, z, obj);
    }

    public static ItemFootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFootBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFootBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558748, null, false, obj);
    }

    public static ItemFootBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFootBinding bind(View view, Object obj) {
        return (ItemFootBinding) bind(obj, view, 2131558748);
    }
}
