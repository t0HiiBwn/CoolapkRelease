package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AppDetailBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected AppDetailBinding(Object obj, View view, int i, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
    }

    public static AppDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558458, viewGroup, z, obj);
    }

    public static AppDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558458, null, false, obj);
    }

    public static AppDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppDetailBinding bind(View view, Object obj) {
        return (AppDetailBinding) bind(obj, view, 2131558458);
    }
}
