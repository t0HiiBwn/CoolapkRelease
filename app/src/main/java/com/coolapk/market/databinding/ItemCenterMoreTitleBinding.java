package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCenterMoreTitleBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final TextView titleView;

    protected ItemCenterMoreTitleBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.titleView = textView;
    }

    public static ItemCenterMoreTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterMoreTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558642, viewGroup, z, obj);
    }

    public static ItemCenterMoreTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterMoreTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558642, null, false, obj);
    }

    public static ItemCenterMoreTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreTitleBinding bind(View view, Object obj) {
        return (ItemCenterMoreTitleBinding) bind(obj, view, 2131558642);
    }
}
