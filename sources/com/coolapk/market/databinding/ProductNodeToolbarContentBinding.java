package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ProductNodeToolbarContentBinding extends ViewDataBinding {
    public final RatingBar ratingBar;
    public final TextView scoreView;
    public final LinearLayout scoreViewContainer;
    public final TextView subtitleView;
    public final TextView toolbarActionView;
    public final TextView toolbarNameView;
    public final ImageView toolbarUserAvatarView;

    protected ProductNodeToolbarContentBinding(Object obj, View view, int i, RatingBar ratingBar2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, ImageView imageView) {
        super(obj, view, i);
        this.ratingBar = ratingBar2;
        this.scoreView = textView;
        this.scoreViewContainer = linearLayout;
        this.subtitleView = textView2;
        this.toolbarActionView = textView3;
        this.toolbarNameView = textView4;
        this.toolbarUserAvatarView = imageView;
    }

    public static ProductNodeToolbarContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductNodeToolbarContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ProductNodeToolbarContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559110, viewGroup, z, obj);
    }

    public static ProductNodeToolbarContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductNodeToolbarContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ProductNodeToolbarContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559110, null, false, obj);
    }

    public static ProductNodeToolbarContentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductNodeToolbarContentBinding bind(View view, Object obj) {
        return (ProductNodeToolbarContentBinding) bind(obj, view, 2131559110);
    }
}
