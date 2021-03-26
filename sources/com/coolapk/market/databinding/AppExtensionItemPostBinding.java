package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AppExtensionItemPostBinding extends ViewDataBinding {
    public final ImageView iconView;

    protected AppExtensionItemPostBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.iconView = imageView;
    }

    public static AppExtensionItemPostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionItemPostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppExtensionItemPostBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558460, viewGroup, z, obj);
    }

    public static AppExtensionItemPostBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionItemPostBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppExtensionItemPostBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558460, null, false, obj);
    }

    public static AppExtensionItemPostBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionItemPostBinding bind(View view, Object obj) {
        return (AppExtensionItemPostBinding) bind(obj, view, 2131558460);
    }
}
