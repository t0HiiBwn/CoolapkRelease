package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class MorePageBinding extends ViewDataBinding {
    public final Button button;

    protected MorePageBinding(Object obj, View view, int i, Button button2) {
        super(obj, view, i);
        this.button = button2;
    }

    public static MorePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MorePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MorePageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559028, viewGroup, z, obj);
    }

    public static MorePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MorePageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MorePageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559028, null, false, obj);
    }

    public static MorePageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MorePageBinding bind(View view, Object obj) {
        return (MorePageBinding) bind(obj, view, 2131559028);
    }
}
