package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemGridDyhCardBinding extends ViewDataBinding {
    public final RecyclerView gridView;
    @Bindable
    protected String mSubTitle;
    @Bindable
    protected String mTitle;
    public final TextView moreView;
    public final TextView titleView;

    public abstract void setSubTitle(String str);

    public abstract void setTitle(String str);

    protected ItemGridDyhCardBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.gridView = recyclerView;
        this.moreView = textView;
        this.titleView = textView2;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public static ItemGridDyhCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridDyhCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridDyhCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558768, viewGroup, z, obj);
    }

    public static ItemGridDyhCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridDyhCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridDyhCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558768, null, false, obj);
    }

    public static ItemGridDyhCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridDyhCardBinding bind(View view, Object obj) {
        return (ItemGridDyhCardBinding) bind(obj, view, 2131558768);
    }
}
