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

public abstract class ItemFeedSecondHandHeaderViewPartBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView exchangePriceView;
    public final TextView messageView;
    public final TextView provinceView;
    public final ImageView signLink;
    public final TextView signLinkText;
    public final TextView textView;
    public final FrameLayout titleContainer;
    public final TextView titleTagView;
    public final TextView titleView;

    protected ItemFeedSecondHandHeaderViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, TextView textView5, TextView textView6, FrameLayout frameLayout, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.exchangePriceView = textView2;
        this.messageView = textView3;
        this.provinceView = textView4;
        this.signLink = imageView;
        this.signLinkText = textView5;
        this.textView = textView6;
        this.titleContainer = frameLayout;
        this.titleTagView = textView7;
        this.titleView = textView8;
    }

    public static ItemFeedSecondHandHeaderViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSecondHandHeaderViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedSecondHandHeaderViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558724, viewGroup, z, obj);
    }

    public static ItemFeedSecondHandHeaderViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSecondHandHeaderViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedSecondHandHeaderViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558724, null, false, obj);
    }

    public static ItemFeedSecondHandHeaderViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSecondHandHeaderViewPartBinding bind(View view, Object obj) {
        return (ItemFeedSecondHandHeaderViewPartBinding) bind(obj, view, 2131558724);
    }
}
