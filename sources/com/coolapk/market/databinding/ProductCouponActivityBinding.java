package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.SlideUpView;

public abstract class ProductCouponActivityBinding extends ViewDataBinding {
    public final SlideUpView bottomSheet;
    public final ImageView closeView;
    public final FrameLayout contentContainer;
    public final TextView createView;
    public final LinearLayout headContainer;
    public final DrawSystemBarFrameLayout mainContent;
    public final View searchViewDivider;

    protected ProductCouponActivityBinding(Object obj, View view, int i, SlideUpView slideUpView, ImageView imageView, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, View view2) {
        super(obj, view, i);
        this.bottomSheet = slideUpView;
        this.closeView = imageView;
        this.contentContainer = frameLayout;
        this.createView = textView;
        this.headContainer = linearLayout;
        this.mainContent = drawSystemBarFrameLayout;
        this.searchViewDivider = view2;
    }

    public static ProductCouponActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductCouponActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ProductCouponActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559115, viewGroup, z, obj);
    }

    public static ProductCouponActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductCouponActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ProductCouponActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559115, null, false, obj);
    }

    public static ProductCouponActivityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductCouponActivityBinding bind(View view, Object obj) {
        return (ProductCouponActivityBinding) bind(obj, view, 2131559115);
    }
}
