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
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.view.FollowStyleTextView;

public abstract class ItemProductSeriesVerticalBinding extends ViewDataBinding {
    public final FollowStyleTextView actionButton;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Product mModel;
    public final ImageView maskView;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Product product);

    protected ItemProductSeriesVerticalBinding(Object obj, View view, int i, FollowStyleTextView followStyleTextView, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.actionButton = followStyleTextView;
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.maskView = imageView2;
        this.subtitleView = textView;
        this.titleView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Product getModel() {
        return this.mModel;
    }

    public static ItemProductSeriesVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558885, viewGroup, z, obj);
    }

    public static ItemProductSeriesVerticalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesVerticalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558885, null, false, obj);
    }

    public static ItemProductSeriesVerticalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesVerticalBinding bind(View view, Object obj) {
        return (ItemProductSeriesVerticalBinding) bind(obj, view, 2131558885);
    }
}
