package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AppViewBaseInfoBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected AppViewBaseInfoBinding(Object obj, View view, int i, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
    }

    public static AppViewBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppViewBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558468, viewGroup, z, obj);
    }

    public static AppViewBaseInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewBaseInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppViewBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558468, null, false, obj);
    }

    public static AppViewBaseInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewBaseInfoBinding bind(View view, Object obj) {
        return (AppViewBaseInfoBinding) bind(obj, view, 2131558468);
    }
}
