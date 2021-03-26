package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.ProductCoupon;
import com.coolapk.market.widget.DividerView;

public abstract class ItemProductCouponBinding extends ViewDataBinding {
    public final DividerView actionDivider;
    public final TextView dateView;
    public final ImageView deviceArrow;
    public final ImageView deviceDivider;
    public final RecyclerView deviceListView;
    public final TextView fetchCouponView;
    public final LinearLayout itemLeftView;
    public final ConstraintLayout itemRightView;
    public final LinearLayout itemView;
    @Bindable
    protected ProductCoupon mCoupon;
    public final TextView moneyView;
    public final TextView priceView;
    public final TextView rmbView;
    public final TextView titleView;
    public final TextView useCouponPriceView;

    public abstract void setCoupon(ProductCoupon productCoupon);

    protected ItemProductCouponBinding(Object obj, View view, int i, DividerView dividerView, TextView textView, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView2, LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.actionDivider = dividerView;
        this.dateView = textView;
        this.deviceArrow = imageView;
        this.deviceDivider = imageView2;
        this.deviceListView = recyclerView;
        this.fetchCouponView = textView2;
        this.itemLeftView = linearLayout;
        this.itemRightView = constraintLayout;
        this.itemView = linearLayout2;
        this.moneyView = textView3;
        this.priceView = textView4;
        this.rmbView = textView5;
        this.titleView = textView6;
        this.useCouponPriceView = textView7;
    }

    public ProductCoupon getCoupon() {
        return this.mCoupon;
    }

    public static ItemProductCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductCouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558864, viewGroup, z, obj);
    }

    public static ItemProductCouponBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCouponBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductCouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558864, null, false, obj);
    }

    public static ItemProductCouponBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCouponBinding bind(View view, Object obj) {
        return (ItemProductCouponBinding) bind(obj, view, 2131558864);
    }
}
