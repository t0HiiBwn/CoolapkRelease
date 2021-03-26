package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PermissionBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected PermissionBinding(Object obj, View view, int i, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
    }

    public static PermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559085, viewGroup, z, obj);
    }

    public static PermissionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PermissionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559085, null, false, obj);
    }

    public static PermissionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PermissionBinding bind(View view, Object obj) {
        return (PermissionBinding) bind(obj, view, 2131559085);
    }
}
