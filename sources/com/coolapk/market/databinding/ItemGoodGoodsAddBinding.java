package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemGoodGoodsAddBinding extends ViewDataBinding {
    public final TextView actionAdd;
    public final FrameLayout bgView;
    public final LinearLayout cardView;
    @Bindable
    protected View.OnClickListener mClick;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemGoodGoodsAddBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionAdd = textView;
        this.bgView = frameLayout;
        this.cardView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGoodGoodsAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodGoodsAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558753, viewGroup, z, obj);
    }

    public static ItemGoodGoodsAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodGoodsAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558753, null, false, obj);
    }

    public static ItemGoodGoodsAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsAddBinding bind(View view, Object obj) {
        return (ItemGoodGoodsAddBinding) bind(obj, view, 2131558753);
    }
}
