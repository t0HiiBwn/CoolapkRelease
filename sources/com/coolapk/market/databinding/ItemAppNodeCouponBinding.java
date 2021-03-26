package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.CouponInfo;

public abstract class ItemAppNodeCouponBinding extends ViewDataBinding {
    public final TextView fetchCouponTextView;
    public final LinearLayout fetchCouponView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected CouponInfo mCoupon;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setCoupon(CouponInfo couponInfo);

    protected ItemAppNodeCouponBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.fetchCouponTextView = textView;
        this.fetchCouponView = linearLayout;
        this.itemView = linearLayout2;
    }

    public CouponInfo getCoupon() {
        return this.mCoupon;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAppNodeCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeCouponBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppNodeCouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558593, viewGroup, z, obj);
    }

    public static ItemAppNodeCouponBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeCouponBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppNodeCouponBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558593, null, false, obj);
    }

    public static ItemAppNodeCouponBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeCouponBinding bind(View view, Object obj) {
        return (ItemAppNodeCouponBinding) bind(obj, view, 2131558593);
    }
}
