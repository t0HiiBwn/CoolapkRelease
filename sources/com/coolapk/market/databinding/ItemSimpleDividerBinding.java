package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSimpleDividerBinding extends ViewDataBinding {
    public final View dividerView;
    public final LinearLayout itemView;

    protected ItemSimpleDividerBinding(Object obj, View view, int i, View view2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.dividerView = view2;
        this.itemView = linearLayout;
    }

    public static ItemSimpleDividerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleDividerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSimpleDividerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558928, viewGroup, z, obj);
    }

    public static ItemSimpleDividerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleDividerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSimpleDividerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558928, null, false, obj);
    }

    public static ItemSimpleDividerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleDividerBinding bind(View view, Object obj) {
        return (ItemSimpleDividerBinding) bind(obj, view, 2131558928);
    }
}
