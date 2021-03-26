package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCardManagerTitleBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView subTitleView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemCardManagerTitleBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.subTitleView = textView;
        this.titleView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCardManagerTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardManagerTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardManagerTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558639, viewGroup, z, obj);
    }

    public static ItemCardManagerTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardManagerTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardManagerTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558639, null, false, obj);
    }

    public static ItemCardManagerTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardManagerTitleBinding bind(View view, Object obj) {
        return (ItemCardManagerTitleBinding) bind(obj, view, 2131558639);
    }
}
