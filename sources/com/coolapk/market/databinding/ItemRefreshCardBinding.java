package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DividerView;

public abstract class ItemRefreshCardBinding extends ViewDataBinding {
    public final DividerView actionDividerLeft;
    public final DividerView actionDividerRight;
    public final LinearLayout cardView;
    @Bindable
    protected View.OnClickListener mOnClick;
    public final TextView titleView;

    public abstract void setOnClick(View.OnClickListener onClickListener);

    protected ItemRefreshCardBinding(Object obj, View view, int i, DividerView dividerView, DividerView dividerView2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.actionDividerLeft = dividerView;
        this.actionDividerRight = dividerView2;
        this.cardView = linearLayout;
        this.titleView = textView;
    }

    public View.OnClickListener getOnClick() {
        return this.mOnClick;
    }

    public static ItemRefreshCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRefreshCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRefreshCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558893, viewGroup, z, obj);
    }

    public static ItemRefreshCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRefreshCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRefreshCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558893, null, false, obj);
    }

    public static ItemRefreshCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRefreshCardBinding bind(View view, Object obj) {
        return (ItemRefreshCardBinding) bind(obj, view, 2131558893);
    }
}
