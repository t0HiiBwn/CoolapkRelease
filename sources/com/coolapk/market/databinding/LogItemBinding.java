package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LogItemBinding extends ViewDataBinding {
    @Bindable
    protected String mError;
    @Bindable
    protected String mMessage;
    @Bindable
    protected String mTime;

    public abstract void setError(String str);

    public abstract void setMessage(String str);

    public abstract void setTime(String str);

    protected LogItemBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getTime() {
        return this.mTime;
    }

    public String getError() {
        return this.mError;
    }

    public static LogItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LogItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LogItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559021, viewGroup, z, obj);
    }

    public static LogItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LogItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LogItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559021, null, false, obj);
    }

    public static LogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LogItemBinding bind(View view, Object obj) {
        return (LogItemBinding) bind(obj, view, 2131559021);
    }
}
