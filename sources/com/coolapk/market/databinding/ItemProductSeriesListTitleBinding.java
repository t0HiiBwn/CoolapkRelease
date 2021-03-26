package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProductSeriesListTitleBinding extends ViewDataBinding {
    public final TextView titleView;

    protected ItemProductSeriesListTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.titleView = textView;
    }

    public static ItemProductSeriesListTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesListTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesListTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558884, viewGroup, z, obj);
    }

    public static ItemProductSeriesListTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesListTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesListTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558884, null, false, obj);
    }

    public static ItemProductSeriesListTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesListTitleBinding bind(View view, Object obj) {
        return (ItemProductSeriesListTitleBinding) bind(obj, view, 2131558884);
    }
}
