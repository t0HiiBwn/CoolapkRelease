package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemChannelTitleBinding extends ViewDataBinding {
    public final TextView actionView;
    public final TextView subtitleView;
    public final TextView titleView;

    protected ItemChannelTitleBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.subtitleView = textView2;
        this.titleView = textView3;
    }

    public static ItemChannelTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChannelTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChannelTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558653, viewGroup, z, obj);
    }

    public static ItemChannelTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChannelTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChannelTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558653, null, false, obj);
    }

    public static ItemChannelTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChannelTitleBinding bind(View view, Object obj) {
        return (ItemChannelTitleBinding) bind(obj, view, 2131558653);
    }
}
