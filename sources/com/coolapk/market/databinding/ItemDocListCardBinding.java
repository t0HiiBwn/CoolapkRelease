package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemDocListCardBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected ItemDocListCardBinding(Object obj, View view, int i, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
    }

    public static ItemDocListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDocListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558678, viewGroup, z, obj);
    }

    public static ItemDocListCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocListCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDocListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558678, null, false, obj);
    }

    public static ItemDocListCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocListCardBinding bind(View view, Object obj) {
        return (ItemDocListCardBinding) bind(obj, view, 2131558678);
    }
}
