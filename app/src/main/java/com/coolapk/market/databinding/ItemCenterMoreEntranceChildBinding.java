package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCenterMoreEntranceChildBinding extends ViewDataBinding {
    public final TextView bubbleTextView;
    public final FrameLayout deleteView;
    public final ImageView imageView;
    public final FrameLayout itemView;
    public final TextView textView;

    protected ItemCenterMoreEntranceChildBinding(Object obj, View view, int i, TextView textView2, FrameLayout frameLayout, ImageView imageView2, FrameLayout frameLayout2, TextView textView3) {
        super(obj, view, i);
        this.bubbleTextView = textView2;
        this.deleteView = frameLayout;
        this.imageView = imageView2;
        this.itemView = frameLayout2;
        this.textView = textView3;
    }

    public static ItemCenterMoreEntranceChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreEntranceChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterMoreEntranceChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558640, viewGroup, z, obj);
    }

    public static ItemCenterMoreEntranceChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreEntranceChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterMoreEntranceChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558640, null, false, obj);
    }

    public static ItemCenterMoreEntranceChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreEntranceChildBinding bind(View view, Object obj) {
        return (ItemCenterMoreEntranceChildBinding) bind(obj, view, 2131558640);
    }
}
