package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.HolderItem;

public abstract class ItemLargeTextBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected HolderItem mHolder;
    public final TextView titleView;

    public abstract void setHolder(HolderItem holderItem);

    protected ItemLargeTextBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.titleView = textView;
    }

    public HolderItem getHolder() {
        return this.mHolder;
    }

    public static ItemLargeTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLargeTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558804, viewGroup, z, obj);
    }

    public static ItemLargeTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLargeTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558804, null, false, obj);
    }

    public static ItemLargeTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeTextBinding bind(View view, Object obj) {
        return (ItemLargeTextBinding) bind(obj, view, 2131558804);
    }
}
