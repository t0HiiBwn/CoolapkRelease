package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemAlertMessageCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout itemView;
    public final TextView textView;

    protected ItemAlertMessageCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.itemView = linearLayout;
        this.textView = textView2;
    }

    public static ItemAlertMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlertMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlertMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558586, viewGroup, z, obj);
    }

    public static ItemAlertMessageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlertMessageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlertMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558586, null, false, obj);
    }

    public static ItemAlertMessageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlertMessageCardBinding bind(View view, Object obj) {
        return (ItemAlertMessageCardBinding) bind(obj, view, 2131558586);
    }
}
