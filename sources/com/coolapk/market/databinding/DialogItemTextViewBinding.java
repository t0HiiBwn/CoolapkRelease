package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogItemTextViewBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final TextView textView;

    protected DialogItemTextViewBinding(Object obj, View view, int i, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.textView = textView2;
    }

    public static DialogItemTextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogItemTextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogItemTextViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558527, viewGroup, z, obj);
    }

    public static DialogItemTextViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogItemTextViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogItemTextViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558527, null, false, obj);
    }

    public static DialogItemTextViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogItemTextViewBinding bind(View view, Object obj) {
        return (DialogItemTextViewBinding) bind(obj, view, 2131558527);
    }
}
