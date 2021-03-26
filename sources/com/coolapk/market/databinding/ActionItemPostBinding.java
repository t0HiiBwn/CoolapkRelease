package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActionItemPostBinding extends ViewDataBinding {
    protected ActionItemPostBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActionItemPostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemPostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActionItemPostBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558431, viewGroup, z, obj);
    }

    public static ActionItemPostBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemPostBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActionItemPostBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558431, null, false, obj);
    }

    public static ActionItemPostBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemPostBinding bind(View view, Object obj) {
        return (ActionItemPostBinding) bind(obj, view, 2131558431);
    }
}
