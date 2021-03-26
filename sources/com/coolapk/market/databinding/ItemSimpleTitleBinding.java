package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSimpleTitleBinding extends ViewDataBinding {
    public final TextView titleView;

    protected ItemSimpleTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.titleView = textView;
    }

    public static ItemSimpleTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSimpleTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558939, viewGroup, z, obj);
    }

    public static ItemSimpleTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSimpleTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558939, null, false, obj);
    }

    public static ItemSimpleTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleTitleBinding bind(View view, Object obj) {
        return (ItemSimpleTitleBinding) bind(obj, view, 2131558939);
    }
}
