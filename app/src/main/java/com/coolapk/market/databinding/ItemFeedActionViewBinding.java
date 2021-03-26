package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedActionViewBinding extends ViewDataBinding {
    public final TextView actionView;

    protected ItemFeedActionViewBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.actionView = textView;
    }

    public static ItemFeedActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedActionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558690, viewGroup, z, obj);
    }

    public static ItemFeedActionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedActionViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedActionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558690, null, false, obj);
    }

    public static ItemFeedActionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedActionViewBinding bind(View view, Object obj) {
        return (ItemFeedActionViewBinding) bind(obj, view, 2131558690);
    }
}
