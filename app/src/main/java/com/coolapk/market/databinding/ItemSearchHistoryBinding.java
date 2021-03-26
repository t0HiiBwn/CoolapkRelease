package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchHistoryBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final TextView textView;

    protected ItemSearchHistoryBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.textView = textView2;
    }

    public static ItemSearchHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558912, viewGroup, z, obj);
    }

    public static ItemSearchHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558912, null, false, obj);
    }

    public static ItemSearchHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchHistoryBinding bind(View view, Object obj) {
        return (ItemSearchHistoryBinding) bind(obj, view, 2131558912);
    }
}
