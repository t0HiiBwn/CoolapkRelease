package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemTitleBinding extends ViewDataBinding {
    public final TextView textView;

    protected ItemTitleBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static ItemTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558954, viewGroup, z, obj);
    }

    public static ItemTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558954, null, false, obj);
    }

    public static ItemTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleBinding bind(View view, Object obj) {
        return (ItemTitleBinding) bind(obj, view, 2131558954);
    }
}
