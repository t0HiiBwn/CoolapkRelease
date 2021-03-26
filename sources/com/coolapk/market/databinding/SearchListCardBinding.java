package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SearchListCardBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected SearchListCardBinding(Object obj, View view, int i, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
    }

    public static SearchListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559135, viewGroup, z, obj);
    }

    public static SearchListCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchListCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559135, null, false, obj);
    }

    public static SearchListCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchListCardBinding bind(View view, Object obj) {
        return (SearchListCardBinding) bind(obj, view, 2131559135);
    }
}
