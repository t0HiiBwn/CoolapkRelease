package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedReplyHotBinding extends ViewDataBinding {
    public final TextView actionView;
    public final TextView textView;

    protected ItemFeedReplyHotBinding(Object obj, View view, int i, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView2;
        this.textView = textView3;
    }

    public static ItemFeedReplyHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedReplyHotBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558717, viewGroup, z, obj);
    }

    public static ItemFeedReplyHotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyHotBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedReplyHotBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558717, null, false, obj);
    }

    public static ItemFeedReplyHotBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyHotBinding bind(View view, Object obj) {
        return (ItemFeedReplyHotBinding) bind(obj, view, 2131558717);
    }
}
