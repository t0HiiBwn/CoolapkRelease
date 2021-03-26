package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedReplyMeBinding extends ViewDataBinding {
    public final TextView actionView;
    public final TextView textView;

    protected ItemFeedReplyMeBinding(Object obj, View view, int i, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView2;
        this.textView = textView3;
    }

    public static ItemFeedReplyMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedReplyMeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558725, viewGroup, z, obj);
    }

    public static ItemFeedReplyMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyMeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedReplyMeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558725, null, false, obj);
    }

    public static ItemFeedReplyMeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyMeBinding bind(View view, Object obj) {
        return (ItemFeedReplyMeBinding) bind(obj, view, 2131558725);
    }
}
