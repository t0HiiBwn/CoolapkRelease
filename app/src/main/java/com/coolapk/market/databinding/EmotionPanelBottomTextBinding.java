package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class EmotionPanelBottomTextBinding extends ViewDataBinding {
    public final TextView textView;

    protected EmotionPanelBottomTextBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static EmotionPanelBottomTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmotionPanelBottomTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EmotionPanelBottomTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558547, viewGroup, z, obj);
    }

    public static EmotionPanelBottomTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmotionPanelBottomTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EmotionPanelBottomTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558547, null, false, obj);
    }

    public static EmotionPanelBottomTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmotionPanelBottomTextBinding bind(View view, Object obj) {
        return (EmotionPanelBottomTextBinding) bind(obj, view, 2131558547);
    }
}
