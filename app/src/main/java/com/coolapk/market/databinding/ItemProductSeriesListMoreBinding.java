package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProductSeriesListMoreBinding extends ViewDataBinding {
    public final TextView titleView;

    protected ItemProductSeriesListMoreBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.titleView = textView;
    }

    public static ItemProductSeriesListMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesListMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesListMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558876, viewGroup, z, obj);
    }

    public static ItemProductSeriesListMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesListMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesListMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558876, null, false, obj);
    }

    public static ItemProductSeriesListMoreBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesListMoreBinding bind(View view, Object obj) {
        return (ItemProductSeriesListMoreBinding) bind(obj, view, 2131558876);
    }
}
