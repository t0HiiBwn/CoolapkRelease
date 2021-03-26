package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedSmallTitleBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout emptyView;
    public final TextView titleView;

    protected ItemFeedSmallTitleBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.actionView = textView;
        this.emptyView = linearLayout;
        this.titleView = textView2;
    }

    public static ItemFeedSmallTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSmallTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedSmallTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558728, viewGroup, z, obj);
    }

    public static ItemFeedSmallTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSmallTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedSmallTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558728, null, false, obj);
    }

    public static ItemFeedSmallTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSmallTitleBinding bind(View view, Object obj) {
        return (ItemFeedSmallTitleBinding) bind(obj, view, 2131558728);
    }
}
