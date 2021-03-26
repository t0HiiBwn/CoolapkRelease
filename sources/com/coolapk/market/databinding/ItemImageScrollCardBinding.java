package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemImageScrollCardBinding extends ViewDataBinding {
    @Bindable
    protected String mTitle;
    public final LinearLayout moreView;
    public final RecyclerView recyclerView;

    public abstract void setTitle(String str);

    protected ItemImageScrollCardBinding(Object obj, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.moreView = linearLayout;
        this.recyclerView = recyclerView2;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemImageScrollCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageScrollCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageScrollCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558799, viewGroup, z, obj);
    }

    public static ItemImageScrollCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageScrollCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageScrollCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558799, null, false, obj);
    }

    public static ItemImageScrollCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageScrollCardBinding bind(View view, Object obj) {
        return (ItemImageScrollCardBinding) bind(obj, view, 2131558799);
    }
}
