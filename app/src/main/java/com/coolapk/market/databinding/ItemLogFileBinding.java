package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemLogFileBinding extends ViewDataBinding {
    public final TextView textView;

    protected ItemLogFileBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static ItemLogFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLogFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLogFileBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558814, viewGroup, z, obj);
    }

    public static ItemLogFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLogFileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLogFileBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558814, null, false, obj);
    }

    public static ItemLogFileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLogFileBinding bind(View view, Object obj) {
        return (ItemLogFileBinding) bind(obj, view, 2131558814);
    }
}
