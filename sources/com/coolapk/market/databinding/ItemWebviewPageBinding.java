package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemWebviewPageBinding extends ViewDataBinding {
    public final ImageButton closeView;
    public final ImageView iconView;
    public final TextView titleView;

    protected ItemWebviewPageBinding(Object obj, View view, int i, ImageButton imageButton, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.closeView = imageButton;
        this.iconView = imageView;
        this.titleView = textView;
    }

    public static ItemWebviewPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWebviewPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemWebviewPageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558991, viewGroup, z, obj);
    }

    public static ItemWebviewPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWebviewPageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemWebviewPageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558991, null, false, obj);
    }

    public static ItemWebviewPageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWebviewPageBinding bind(View view, Object obj) {
        return (ItemWebviewPageBinding) bind(obj, view, 2131558991);
    }
}
