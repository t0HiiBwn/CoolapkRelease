package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogListItemViewBinding extends ViewDataBinding {
    public final ImageView checkView;
    public final TextView descriptionView;
    public final TextView titleView;

    protected DialogListItemViewBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.checkView = imageView;
        this.descriptionView = textView;
        this.titleView = textView2;
    }

    public static DialogListItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogListItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogListItemViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558530, viewGroup, z, obj);
    }

    public static DialogListItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogListItemViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogListItemViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558530, null, false, obj);
    }

    public static DialogListItemViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogListItemViewBinding bind(View view, Object obj) {
        return (DialogListItemViewBinding) bind(obj, view, 2131558530);
    }
}
