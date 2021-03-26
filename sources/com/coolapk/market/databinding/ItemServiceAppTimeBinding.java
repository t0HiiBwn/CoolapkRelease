package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemServiceAppTimeBinding extends ViewDataBinding {
    @Bindable
    protected String mTime;
    public final TextView timeView;

    public abstract void setTime(String str);

    protected ItemServiceAppTimeBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.timeView = textView;
    }

    public String getTime() {
        return this.mTime;
    }

    public static ItemServiceAppTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemServiceAppTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemServiceAppTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558925, viewGroup, z, obj);
    }

    public static ItemServiceAppTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemServiceAppTimeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemServiceAppTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558925, null, false, obj);
    }

    public static ItemServiceAppTimeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemServiceAppTimeBinding bind(View view, Object obj) {
        return (ItemServiceAppTimeBinding) bind(obj, view, 2131558925);
    }
}
