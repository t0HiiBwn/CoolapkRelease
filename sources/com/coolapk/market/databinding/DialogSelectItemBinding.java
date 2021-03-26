package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogSelectItemBinding extends ViewDataBinding {
    public final ImageView checkView;
    public final TextView titleView;

    protected DialogSelectItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.checkView = imageView;
        this.titleView = textView;
    }

    public static DialogSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSelectItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558537, viewGroup, z, obj);
    }

    public static DialogSelectItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSelectItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSelectItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558537, null, false, obj);
    }

    public static DialogSelectItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSelectItemBinding bind(View view, Object obj) {
        return (DialogSelectItemBinding) bind(obj, view, 2131558537);
    }
}
