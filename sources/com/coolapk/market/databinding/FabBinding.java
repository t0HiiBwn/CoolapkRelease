package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class FabBinding extends ViewDataBinding {
    public final FloatingActionButton fab;

    protected FabBinding(Object obj, View view, int i, FloatingActionButton floatingActionButton) {
        super(obj, view, i);
        this.fab = floatingActionButton;
    }

    public static FabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558551, viewGroup, z, obj);
    }

    public static FabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FabBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558551, null, false, obj);
    }

    public static FabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FabBinding bind(View view, Object obj) {
        return (FabBinding) bind(obj, view, 2131558551);
    }
}
