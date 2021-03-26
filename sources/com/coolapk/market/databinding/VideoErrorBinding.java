package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoErrorBinding extends ViewDataBinding {
    public final TextView actionView;
    public final TextView actionView2;
    public final TextView infoView;

    protected VideoErrorBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.actionView2 = textView2;
        this.infoView = textView3;
    }

    public static VideoErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoErrorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559300, viewGroup, z, obj);
    }

    public static VideoErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoErrorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoErrorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559300, null, false, obj);
    }

    public static VideoErrorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoErrorBinding bind(View view, Object obj) {
        return (VideoErrorBinding) bind(obj, view, 2131559300);
    }
}
