package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemHotSearchListBinding extends ViewDataBinding {
    public final TextView hotNumView;
    public final LinearLayout itemView;
    public final TextView rankTextView;
    public final TextView titleView;

    protected ItemHotSearchListBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.hotNumView = textView;
        this.itemView = linearLayout;
        this.rankTextView = textView2;
        this.titleView = textView3;
    }

    public static ItemHotSearchListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotSearchListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHotSearchListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558775, viewGroup, z, obj);
    }

    public static ItemHotSearchListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotSearchListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHotSearchListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558775, null, false, obj);
    }

    public static ItemHotSearchListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotSearchListBinding bind(View view, Object obj) {
        return (ItemHotSearchListBinding) bind(obj, view, 2131558775);
    }
}
