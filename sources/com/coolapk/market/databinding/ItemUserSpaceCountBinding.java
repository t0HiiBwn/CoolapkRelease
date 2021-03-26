package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemUserSpaceCountBinding extends ViewDataBinding {
    public final TextView titleView;

    protected ItemUserSpaceCountBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.titleView = textView;
    }

    public static ItemUserSpaceCountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserSpaceCountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserSpaceCountBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558989, viewGroup, z, obj);
    }

    public static ItemUserSpaceCountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserSpaceCountBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserSpaceCountBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558989, null, false, obj);
    }

    public static ItemUserSpaceCountBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserSpaceCountBinding bind(View view, Object obj) {
        return (ItemUserSpaceCountBinding) bind(obj, view, 2131558989);
    }
}
