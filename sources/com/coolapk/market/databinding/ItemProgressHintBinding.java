package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProgressHintBinding extends ViewDataBinding {
    public final FrameLayout emptyView;
    public final ProgressBar progressBar;
    public final TextView titleView;

    protected ItemProgressHintBinding(Object obj, View view, int i, FrameLayout frameLayout, ProgressBar progressBar2, TextView textView) {
        super(obj, view, i);
        this.emptyView = frameLayout;
        this.progressBar = progressBar2;
        this.titleView = textView;
    }

    public static ItemProgressHintBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProgressHintBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProgressHintBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558890, viewGroup, z, obj);
    }

    public static ItemProgressHintBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProgressHintBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProgressHintBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558890, null, false, obj);
    }

    public static ItemProgressHintBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProgressHintBinding bind(View view, Object obj) {
        return (ItemProgressHintBinding) bind(obj, view, 2131558890);
    }
}
