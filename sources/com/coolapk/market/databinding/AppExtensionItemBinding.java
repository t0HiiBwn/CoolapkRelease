package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AppExtensionItemBinding extends ViewDataBinding {
    public final ImageView menuView;
    public final TextView subTitleView;
    public final TextView titleView;
    public final ImageView upView;

    protected AppExtensionItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2) {
        super(obj, view, i);
        this.menuView = imageView;
        this.subTitleView = textView;
        this.titleView = textView2;
        this.upView = imageView2;
    }

    public static AppExtensionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppExtensionItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558460, viewGroup, z, obj);
    }

    public static AppExtensionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppExtensionItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558460, null, false, obj);
    }

    public static AppExtensionItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionItemBinding bind(View view, Object obj) {
        return (AppExtensionItemBinding) bind(obj, view, 2131558460);
    }
}
