package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedFilterBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final TextView textView;

    protected ItemFeedFilterBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.textView = textView2;
    }

    public static ItemFeedFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558706, viewGroup, z, obj);
    }

    public static ItemFeedFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558706, null, false, obj);
    }

    public static ItemFeedFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedFilterBinding bind(View view, Object obj) {
        return (ItemFeedFilterBinding) bind(obj, view, 2131558706);
    }
}
