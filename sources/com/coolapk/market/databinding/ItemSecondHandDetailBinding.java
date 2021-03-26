package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemSecondHandDetailBinding extends ViewDataBinding {
    public final RecyclerView paramsList;
    public final RecyclerView tagList;
    public final TextView titleView;

    protected ItemSecondHandDetailBinding(Object obj, View view, int i, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView) {
        super(obj, view, i);
        this.paramsList = recyclerView;
        this.tagList = recyclerView2;
        this.titleView = textView;
    }

    public static ItemSecondHandDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSecondHandDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558925, viewGroup, z, obj);
    }

    public static ItemSecondHandDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSecondHandDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558925, null, false, obj);
    }

    public static ItemSecondHandDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandDetailBinding bind(View view, Object obj) {
        return (ItemSecondHandDetailBinding) bind(obj, view, 2131558925);
    }
}
