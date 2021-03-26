package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class MainBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout contentView;

    protected MainBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout) {
        super(obj, view, i);
        this.contentView = drawSystemBarFrameLayout;
    }

    public static MainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MainBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559015, viewGroup, z, obj);
    }

    public static MainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MainBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559015, null, false, obj);
    }

    public static MainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainBinding bind(View view, Object obj) {
        return (MainBinding) bind(obj, view, 2131559015);
    }
}
