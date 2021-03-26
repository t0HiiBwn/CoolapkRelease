package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemUserInfoPartBinding extends ViewDataBinding {
    @Bindable
    protected Integer mLevel;
    public final TextView textView;

    public abstract void setLevel(Integer num);

    protected ItemUserInfoPartBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public Integer getLevel() {
        return this.mLevel;
    }

    public static ItemUserInfoPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserInfoPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558976, viewGroup, z, obj);
    }

    public static ItemUserInfoPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserInfoPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558976, null, false, obj);
    }

    public static ItemUserInfoPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoPartBinding bind(View view, Object obj) {
        return (ItemUserInfoPartBinding) bind(obj, view, 2131558976);
    }
}
