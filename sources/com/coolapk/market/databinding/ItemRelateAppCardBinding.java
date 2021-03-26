package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemRelateAppCardBinding extends ViewDataBinding {
    public final RecyclerView gridView;
    @Bindable
    protected String mTitle;
    public final LinearLayout moreView;

    public abstract void setTitle(String str);

    protected ItemRelateAppCardBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.gridView = recyclerView;
        this.moreView = linearLayout;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemRelateAppCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelateAppCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRelateAppCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558901, viewGroup, z, obj);
    }

    public static ItemRelateAppCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelateAppCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRelateAppCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558901, null, false, obj);
    }

    public static ItemRelateAppCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelateAppCardBinding bind(View view, Object obj) {
        return (ItemRelateAppCardBinding) bind(obj, view, 2131558901);
    }
}
