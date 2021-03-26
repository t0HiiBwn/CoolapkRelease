package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedReplyTextBinding extends ViewDataBinding {
    public final TextView textView;

    protected ItemFeedReplyTextBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static ItemFeedReplyTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedReplyTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558727, viewGroup, z, obj);
    }

    public static ItemFeedReplyTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedReplyTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558727, null, false, obj);
    }

    public static ItemFeedReplyTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyTextBinding bind(View view, Object obj) {
        return (ItemFeedReplyTextBinding) bind(obj, view, 2131558727);
    }
}
