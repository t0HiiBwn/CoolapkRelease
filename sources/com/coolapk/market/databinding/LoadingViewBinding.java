package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LoadingViewBinding extends ViewDataBinding {
    public final TextView hintView;
    public final FrameLayout loadingContainer;
    public final ProgressBar loadingView;

    protected LoadingViewBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, ProgressBar progressBar) {
        super(obj, view, i);
        this.hintView = textView;
        this.loadingContainer = frameLayout;
        this.loadingView = progressBar;
    }

    public static LoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LoadingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559013, viewGroup, z, obj);
    }

    public static LoadingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoadingViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LoadingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559013, null, false, obj);
    }

    public static LoadingViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoadingViewBinding bind(View view, Object obj) {
        return (LoadingViewBinding) bind(obj, view, 2131559013);
    }
}
