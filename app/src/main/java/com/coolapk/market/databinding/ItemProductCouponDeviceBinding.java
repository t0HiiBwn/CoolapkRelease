package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemProductCouponDeviceBinding extends ViewDataBinding {
    @Bindable
    protected String mTitle;

    public abstract void setTitle(String str);

    protected ItemProductCouponDeviceBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemProductCouponDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCouponDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductCouponDeviceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558865, viewGroup, z, obj);
    }

    public static ItemProductCouponDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCouponDeviceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductCouponDeviceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558865, null, false, obj);
    }

    public static ItemProductCouponDeviceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductCouponDeviceBinding bind(View view, Object obj) {
        return (ItemProductCouponDeviceBinding) bind(obj, view, 2131558865);
    }
}
