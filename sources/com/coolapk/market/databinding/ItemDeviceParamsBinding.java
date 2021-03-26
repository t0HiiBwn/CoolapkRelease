package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemDeviceParamsBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final RecyclerView paramsList;
    public final TextView paramsTitle;

    protected ItemDeviceParamsBinding(Object obj, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.paramsList = recyclerView;
        this.paramsTitle = textView;
    }

    public static ItemDeviceParamsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeviceParamsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDeviceParamsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558675, viewGroup, z, obj);
    }

    public static ItemDeviceParamsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeviceParamsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDeviceParamsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558675, null, false, obj);
    }

    public static ItemDeviceParamsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeviceParamsBinding bind(View view, Object obj) {
        return (ItemDeviceParamsBinding) bind(obj, view, 2131558675);
    }
}
