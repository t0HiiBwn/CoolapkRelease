package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedGoods;

public abstract class ItemBindGoodsChildBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final LinearLayout containerView;
    public final ImageView iconView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedGoods mModel;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedGoods feedGoods);

    protected ItemBindGoodsChildBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i);
        this.closeView = imageView;
        this.containerView = linearLayout;
        this.iconView = imageView2;
        this.itemView = frameLayout;
        this.titleView = textView;
    }

    public FeedGoods getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemBindGoodsChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBindGoodsChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBindGoodsChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558628, viewGroup, z, obj);
    }

    public static ItemBindGoodsChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBindGoodsChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBindGoodsChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558628, null, false, obj);
    }

    public static ItemBindGoodsChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBindGoodsChildBinding bind(View view, Object obj) {
        return (ItemBindGoodsChildBinding) bind(obj, view, 2131558628);
    }
}
