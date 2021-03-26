package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemLinkCardBinding extends ViewDataBinding {
    public final LinearLayout tabLayout;

    protected ItemLinkCardBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.tabLayout = linearLayout;
    }

    public static ItemLinkCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLinkCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558807, viewGroup, z, obj);
    }

    public static ItemLinkCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLinkCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558807, null, false, obj);
    }

    public static ItemLinkCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardBinding bind(View view, Object obj) {
        return (ItemLinkCardBinding) bind(obj, view, 2131558807);
    }
}
