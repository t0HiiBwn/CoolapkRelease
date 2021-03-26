package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedRoughDraftBinding extends ViewDataBinding {
    public final ImageView actionView;
    public final ImageView logoView;
    public final TextView textView;
    public final TextView timeView;
    public final TextView titleView;
    public final TextView typeView;

    protected ItemFeedRoughDraftBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.actionView = imageView;
        this.logoView = imageView2;
        this.textView = textView2;
        this.timeView = textView3;
        this.titleView = textView4;
        this.typeView = textView5;
    }

    public static ItemFeedRoughDraftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRoughDraftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedRoughDraftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558729, viewGroup, z, obj);
    }

    public static ItemFeedRoughDraftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRoughDraftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedRoughDraftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558729, null, false, obj);
    }

    public static ItemFeedRoughDraftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRoughDraftBinding bind(View view, Object obj) {
        return (ItemFeedRoughDraftBinding) bind(obj, view, 2131558729);
    }
}
