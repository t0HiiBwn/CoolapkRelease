package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProductParamsBinding extends ViewDataBinding {
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleParamsView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemProductParamsBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i);
        this.itemView = frameLayout;
        this.titleParamsView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemProductParamsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductParamsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductParamsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558870, viewGroup, z, obj);
    }

    public static ItemProductParamsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductParamsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductParamsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558870, null, false, obj);
    }

    public static ItemProductParamsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductParamsBinding bind(View view, Object obj) {
        return (ItemProductParamsBinding) bind(obj, view, 2131558870);
    }
}
