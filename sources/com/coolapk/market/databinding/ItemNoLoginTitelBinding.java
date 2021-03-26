package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemNoLoginTitelBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemNoLoginTitelBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemNoLoginTitelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNoLoginTitelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNoLoginTitelBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558836, viewGroup, z, obj);
    }

    public static ItemNoLoginTitelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNoLoginTitelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNoLoginTitelBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558836, null, false, obj);
    }

    public static ItemNoLoginTitelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNoLoginTitelBinding bind(View view, Object obj) {
        return (ItemNoLoginTitelBinding) bind(obj, view, 2131558836);
    }
}
