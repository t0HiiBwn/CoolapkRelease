package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoCompleteBinding extends ViewDataBinding {
    public final LinearLayout replayView;
    public final LinearLayout shareView;

    protected VideoCompleteBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.replayView = linearLayout;
        this.shareView = linearLayout2;
    }

    public static VideoCompleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoCompleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoCompleteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559288, viewGroup, z, obj);
    }

    public static VideoCompleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoCompleteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoCompleteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559288, null, false, obj);
    }

    public static VideoCompleteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoCompleteBinding bind(View view, Object obj) {
        return (VideoCompleteBinding) bind(obj, view, 2131559288);
    }
}
