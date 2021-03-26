package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchExtendFooterBinding extends ViewDataBinding {
    public final TextView clearButton;

    protected ItemSearchExtendFooterBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.clearButton = textView;
    }

    public static ItemSearchExtendFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchExtendFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558916, viewGroup, z, obj);
    }

    public static ItemSearchExtendFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendFooterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchExtendFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558916, null, false, obj);
    }

    public static ItemSearchExtendFooterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendFooterBinding bind(View view, Object obj) {
        return (ItemSearchExtendFooterBinding) bind(obj, view, 2131558916);
    }
}
