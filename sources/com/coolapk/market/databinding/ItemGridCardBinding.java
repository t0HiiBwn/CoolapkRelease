package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemGridCardBinding extends ViewDataBinding {
    public final RecyclerView gridView;
    @Bindable
    protected String mTitle;

    public abstract void setTitle(String str);

    protected ItemGridCardBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.gridView = recyclerView;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558772, viewGroup, z, obj);
    }

    public static ItemGridCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558772, null, false, obj);
    }

    public static ItemGridCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardBinding bind(View view, Object obj) {
        return (ItemGridCardBinding) bind(obj, view, 2131558772);
    }
}
