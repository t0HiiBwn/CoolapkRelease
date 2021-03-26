package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class TagProductOwnerBinding extends ViewDataBinding {
    public final TextView ownerTextView;
    public final LinearLayout ownerView;

    protected TagProductOwnerBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.ownerTextView = textView;
        this.ownerView = linearLayout;
    }

    public static TagProductOwnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TagProductOwnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TagProductOwnerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559185, viewGroup, z, obj);
    }

    public static TagProductOwnerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TagProductOwnerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TagProductOwnerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559185, null, false, obj);
    }

    public static TagProductOwnerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TagProductOwnerBinding bind(View view, Object obj) {
        return (TagProductOwnerBinding) bind(obj, view, 2131559185);
    }
}
