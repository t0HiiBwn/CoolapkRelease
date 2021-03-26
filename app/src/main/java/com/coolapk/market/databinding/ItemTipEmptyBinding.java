package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemTipEmptyBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView subTitleView;
    public final TextView tipsView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemTipEmptyBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.itemView = linearLayout;
        this.subTitleView = textView;
        this.tipsView = textView2;
        this.titleView = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemTipEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTipEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTipEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558953, viewGroup, z, obj);
    }

    public static ItemTipEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTipEmptyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTipEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558953, null, false, obj);
    }

    public static ItemTipEmptyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTipEmptyBinding bind(View view, Object obj) {
        return (ItemTipEmptyBinding) bind(obj, view, 2131558953);
    }
}
