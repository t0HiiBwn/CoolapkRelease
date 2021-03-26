package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemUserCoverTitleBinding extends ViewDataBinding {
    public final TextView titleView;

    protected ItemUserCoverTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.titleView = textView;
    }

    public static ItemUserCoverTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserCoverTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558970, viewGroup, z, obj);
    }

    public static ItemUserCoverTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserCoverTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558970, null, false, obj);
    }

    public static ItemUserCoverTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverTitleBinding bind(View view, Object obj) {
        return (ItemUserCoverTitleBinding) bind(obj, view, 2131558970);
    }
}
