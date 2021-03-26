package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Goods;

public abstract class ItemGoodsBinding extends ViewDataBinding {
    public final LinearLayout actionView;
    public final LinearLayout contentView;
    public final CoolapkCardView coolapkCardView;
    public final TextView discountPriceView;
    public final TextView goShoppingView;
    public final LinearLayout itemView;
    @Bindable
    protected Goods mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final ImageView picView;
    public final Space tagSpaceView;
    public final TextView titleView;

    public abstract void setModel(Goods goods);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemGoodsBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, TextView textView, TextView textView2, LinearLayout linearLayout3, ImageView imageView, Space space, TextView textView3) {
        super(obj, view, i);
        this.actionView = linearLayout;
        this.contentView = linearLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.discountPriceView = textView;
        this.goShoppingView = textView2;
        this.itemView = linearLayout3;
        this.picView = imageView;
        this.tagSpaceView = space;
        this.titleView = textView3;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public Goods getModel() {
        return this.mModel;
    }

    public static ItemGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558755, viewGroup, z, obj);
    }

    public static ItemGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558755, null, false, obj);
    }

    public static ItemGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsBinding bind(View view, Object obj) {
        return (ItemGoodsBinding) bind(obj, view, 2131558755);
    }
}
