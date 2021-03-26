package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.SimpleImageView;

public abstract class ItemRelativeChildBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final SimpleImageView iconView;
    public final TextView titleView;

    protected ItemRelativeChildBinding(Object obj, View view, int i, LinearLayout linearLayout, SimpleImageView simpleImageView, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = simpleImageView;
        this.titleView = textView;
    }

    public static ItemRelativeChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelativeChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRelativeChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558896, viewGroup, z, obj);
    }

    public static ItemRelativeChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelativeChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRelativeChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558896, null, false, obj);
    }

    public static ItemRelativeChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRelativeChildBinding bind(View view, Object obj) {
        return (ItemRelativeChildBinding) bind(obj, view, 2131558896);
    }
}
