package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemFeedBindGoodsBinding extends ViewDataBinding {
    public final LinearLayout containerView;
    @Bindable
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemFeedBindGoodsBinding(Object obj, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.containerView = linearLayout;
        this.recyclerView = recyclerView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedBindGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedBindGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedBindGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558699, viewGroup, z, obj);
    }

    public static ItemFeedBindGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedBindGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedBindGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558699, null, false, obj);
    }

    public static ItemFeedBindGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedBindGoodsBinding bind(View view, Object obj) {
        return (ItemFeedBindGoodsBinding) bind(obj, view, 2131558699);
    }
}
