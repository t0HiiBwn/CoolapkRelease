package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class StaticDialogViewBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout contentView;

    protected StaticDialogViewBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout) {
        super(obj, view, i);
        this.contentView = drawSystemBarFrameLayout;
    }

    public static StaticDialogViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StaticDialogViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (StaticDialogViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559154, viewGroup, z, obj);
    }

    public static StaticDialogViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StaticDialogViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (StaticDialogViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559154, null, false, obj);
    }

    public static StaticDialogViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static StaticDialogViewBinding bind(View view, Object obj) {
        return (StaticDialogViewBinding) bind(obj, view, 2131559154);
    }
}
