package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedTitleBinding extends ViewDataBinding {
    public final TextView textView;

    protected ItemFeedTitleBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static ItemFeedTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558733, viewGroup, z, obj);
    }

    public static ItemFeedTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558733, null, false, obj);
    }

    public static ItemFeedTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedTitleBinding bind(View view, Object obj) {
        return (ItemFeedTitleBinding) bind(obj, view, 2131558733);
    }
}
