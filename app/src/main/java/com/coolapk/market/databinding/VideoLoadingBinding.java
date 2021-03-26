package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoLoadingBinding extends ViewDataBinding {
    public final ProgressBar loadingView;

    protected VideoLoadingBinding(Object obj, View view, int i, ProgressBar progressBar) {
        super(obj, view, i);
        this.loadingView = progressBar;
    }

    public static VideoLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559294, viewGroup, z, obj);
    }

    public static VideoLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559294, null, false, obj);
    }

    public static VideoLoadingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoLoadingBinding bind(View view, Object obj) {
        return (VideoLoadingBinding) bind(obj, view, 2131559294);
    }
}
