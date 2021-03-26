package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemAppCategoryBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final TextView textView;

    protected ItemAppCategoryBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.textView = textView2;
    }

    public static ItemAppCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558589, viewGroup, z, obj);
    }

    public static ItemAppCategoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppCategoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558589, null, false, obj);
    }

    public static ItemAppCategoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppCategoryBinding bind(View view, Object obj) {
        return (ItemAppCategoryBinding) bind(obj, view, 2131558589);
    }
}
