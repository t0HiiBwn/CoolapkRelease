package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedSecondHandViewPartBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView goShoppingView;
    public final ItemSecondHandDetailBinding secondHandParams;
    public final TextView textNotice;
    public final TextView urlNotice;
    public final LinearLayout urlNoticeLayout;

    protected ItemFeedSecondHandViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, ItemSecondHandDetailBinding itemSecondHandDetailBinding, TextView textView2, TextView textView3, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.goShoppingView = textView;
        this.secondHandParams = itemSecondHandDetailBinding;
        this.textNotice = textView2;
        this.urlNotice = textView3;
        this.urlNoticeLayout = linearLayout2;
    }

    public static ItemFeedSecondHandViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSecondHandViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedSecondHandViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558732, viewGroup, z, obj);
    }

    public static ItemFeedSecondHandViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSecondHandViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedSecondHandViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558732, null, false, obj);
    }

    public static ItemFeedSecondHandViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSecondHandViewPartBinding bind(View view, Object obj) {
        return (ItemFeedSecondHandViewPartBinding) bind(obj, view, 2131558732);
    }
}
