package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutListEditButtonBinding extends ViewDataBinding {
    public final LinearLayout actionAdd;
    public final LinearLayout actionDel;
    public final LinearLayout layoutContainer;

    protected LayoutListEditButtonBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.actionAdd = linearLayout;
        this.actionDel = linearLayout2;
        this.layoutContainer = linearLayout3;
    }

    public static LayoutListEditButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutListEditButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutListEditButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558997, viewGroup, z, obj);
    }

    public static LayoutListEditButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutListEditButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutListEditButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558997, null, false, obj);
    }

    public static LayoutListEditButtonBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutListEditButtonBinding bind(View view, Object obj) {
        return (LayoutListEditButtonBinding) bind(obj, view, 2131558997);
    }
}
