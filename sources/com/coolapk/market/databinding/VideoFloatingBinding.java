package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoFloatingBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final LinearLayout errorView;
    public final ProgressBar progressBar;
    public final LinearLayout replayView;
    public final TextView retryView;

    protected VideoFloatingBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, ProgressBar progressBar2, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.closeView = imageView;
        this.errorView = linearLayout;
        this.progressBar = progressBar2;
        this.replayView = linearLayout2;
        this.retryView = textView;
    }

    public static VideoFloatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoFloatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoFloatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559291, viewGroup, z, obj);
    }

    public static VideoFloatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoFloatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoFloatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559291, null, false, obj);
    }

    public static VideoFloatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoFloatingBinding bind(View view, Object obj) {
        return (VideoFloatingBinding) bind(obj, view, 2131559291);
    }
}
