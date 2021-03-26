package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ShareListViewBinding extends ViewDataBinding {
    public final TextView dialogCancelView;
    public final RecyclerView recyclerView;

    protected ShareListViewBinding(Object obj, View view, int i, TextView textView, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.dialogCancelView = textView;
        this.recyclerView = recyclerView2;
    }

    public static ShareListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShareListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559148, viewGroup, z, obj);
    }

    public static ShareListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareListViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShareListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559148, null, false, obj);
    }

    public static ShareListViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareListViewBinding bind(View view, Object obj) {
        return (ShareListViewBinding) bind(obj, view, 2131559148);
    }
}
