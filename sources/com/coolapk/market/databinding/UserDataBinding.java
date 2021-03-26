package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class UserDataBinding extends ViewDataBinding {
    public final LinearLayout contentView;
    public final LinearLayout infoDataContent;
    public final TextView regDateView;
    public final TextView signatureView;

    protected UserDataBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.contentView = linearLayout;
        this.infoDataContent = linearLayout2;
        this.regDateView = textView;
        this.signatureView = textView2;
    }

    public static UserDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559291, viewGroup, z, obj);
    }

    public static UserDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559291, null, false, obj);
    }

    public static UserDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserDataBinding bind(View view, Object obj) {
        return (UserDataBinding) bind(obj, view, 2131559291);
    }
}
