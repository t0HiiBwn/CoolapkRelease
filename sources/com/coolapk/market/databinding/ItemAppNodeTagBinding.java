package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemAppNodeTagBinding extends ViewDataBinding {
    @Bindable
    protected String mName;

    public abstract void setName(String str);

    protected ItemAppNodeTagBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public String getName() {
        return this.mName;
    }

    public static ItemAppNodeTagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeTagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppNodeTagBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558599, viewGroup, z, obj);
    }

    public static ItemAppNodeTagBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeTagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppNodeTagBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558599, null, false, obj);
    }

    public static ItemAppNodeTagBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeTagBinding bind(View view, Object obj) {
        return (ItemAppNodeTagBinding) bind(obj, view, 2131558599);
    }
}
