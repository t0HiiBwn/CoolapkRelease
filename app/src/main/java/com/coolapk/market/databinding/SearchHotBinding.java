package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SearchHotBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final LinearLayout refreshView;
    public final TextView titleView;

    protected SearchHotBinding(Object obj, View view, int i, RecyclerView recyclerView2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
        this.refreshView = linearLayout;
        this.titleView = textView;
    }

    public static SearchHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchHotBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559126, viewGroup, z, obj);
    }

    public static SearchHotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchHotBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchHotBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559126, null, false, obj);
    }

    public static SearchHotBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchHotBinding bind(View view, Object obj) {
        return (SearchHotBinding) bind(obj, view, 2131559126);
    }
}
