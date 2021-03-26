package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LiveFloatNewMessageBinding extends ViewDataBinding {
    public final TextView newMessageView;

    protected LiveFloatNewMessageBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.newMessageView = textView;
    }

    public static LiveFloatNewMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveFloatNewMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LiveFloatNewMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559017, viewGroup, z, obj);
    }

    public static LiveFloatNewMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveFloatNewMessageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LiveFloatNewMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559017, null, false, obj);
    }

    public static LiveFloatNewMessageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveFloatNewMessageBinding bind(View view, Object obj) {
        return (LiveFloatNewMessageBinding) bind(obj, view, 2131559017);
    }
}
