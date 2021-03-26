package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemListCardBinding extends ViewDataBinding {
    public final RecyclerView listView;
    @Bindable
    protected String mTitle;

    public abstract void setTitle(String str);

    protected ItemListCardBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.listView = recyclerView;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558810, viewGroup, z, obj);
    }

    public static ItemListCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemListCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558810, null, false, obj);
    }

    public static ItemListCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemListCardBinding bind(View view, Object obj) {
        return (ItemListCardBinding) bind(obj, view, 2131558810);
    }
}
