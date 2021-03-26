package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Product;

public abstract class ItemProductViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Product mModel;
    public final ImageView maskView;
    public final TextView noOneRatedView;
    public final RatingBar ratingBar;
    public final LinearLayout releaseTimeContainer;
    public final TextView releaseTimeTitle;
    public final TextView releaseTimeView;
    public final TextView scoreView;
    public final LinearLayout scoreViewContainer;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Product product);

    protected ItemProductViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView, RatingBar ratingBar2, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout3, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.maskView = imageView2;
        this.noOneRatedView = textView;
        this.ratingBar = ratingBar2;
        this.releaseTimeContainer = linearLayout2;
        this.releaseTimeTitle = textView2;
        this.releaseTimeView = textView3;
        this.scoreView = textView4;
        this.scoreViewContainer = linearLayout3;
        this.subtitleView = textView5;
        this.titleView = textView6;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Product getModel() {
        return this.mModel;
    }

    public static ItemProductViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558882, viewGroup, z, obj);
    }

    public static ItemProductViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558882, null, false, obj);
    }

    public static ItemProductViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductViewBinding bind(View view, Object obj) {
        return (ItemProductViewBinding) bind(obj, view, 2131558882);
    }
}
