package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemGoodsParamsBinding extends ViewDataBinding {
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final CheckedTextView titleParamsView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemGoodsParamsBinding(Object obj, View view, int i, FrameLayout frameLayout, CheckedTextView checkedTextView) {
        super(obj, view, i);
        this.itemView = frameLayout;
        this.titleParamsView = checkedTextView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGoodsParamsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsParamsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsParamsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558769, viewGroup, z, obj);
    }

    public static ItemGoodsParamsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsParamsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsParamsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558769, null, false, obj);
    }

    public static ItemGoodsParamsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsParamsBinding bind(View view, Object obj) {
        return (ItemGoodsParamsBinding) bind(obj, view, 2131558769);
    }
}
