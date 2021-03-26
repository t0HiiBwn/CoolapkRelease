package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFoldedViewBinding extends ViewDataBinding {
    public final TextView textView;

    protected ItemFoldedViewBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static ItemFoldedViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFoldedViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFoldedViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558753, viewGroup, z, obj);
    }

    public static ItemFoldedViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFoldedViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFoldedViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558753, null, false, obj);
    }

    public static ItemFoldedViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFoldedViewBinding bind(View view, Object obj) {
        return (ItemFoldedViewBinding) bind(obj, view, 2131558753);
    }
}
