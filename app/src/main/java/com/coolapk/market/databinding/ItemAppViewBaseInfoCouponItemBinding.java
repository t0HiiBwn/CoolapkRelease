package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.CouponInfo;

public abstract class ItemAppViewBaseInfoCouponItemBinding extends ViewDataBinding {
    public final ImageView couponFetchedView;
    public final TextView fetchCouponView;
    public final LinearLayout itemView;
    @Bindable
    protected CouponInfo mCoupon;

    public abstract void setCoupon(CouponInfo couponInfo);

    protected ItemAppViewBaseInfoCouponItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.couponFetchedView = imageView;
        this.fetchCouponView = textView;
        this.itemView = linearLayout;
    }

    public CouponInfo getCoupon() {
        return this.mCoupon;
    }

    public static ItemAppViewBaseInfoCouponItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoCouponItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewBaseInfoCouponItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558600, viewGroup, z, obj);
    }

    public static ItemAppViewBaseInfoCouponItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoCouponItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewBaseInfoCouponItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558600, null, false, obj);
    }

    public static ItemAppViewBaseInfoCouponItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoCouponItemBinding bind(View view, Object obj) {
        return (ItemAppViewBaseInfoCouponItemBinding) bind(obj, view, 2131558600);
    }
}
