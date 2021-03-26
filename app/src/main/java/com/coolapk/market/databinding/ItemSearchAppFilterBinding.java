package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchAppFilterBinding extends ViewDataBinding {
    public final ImageView appCategoryChevronView;
    public final TextView appCategoryTextView;
    public final LinearLayout appCategoryView;
    public final ImageView appSortChevronView;
    public final TextView appSortTextView;
    public final LinearLayout appSortView;

    protected ItemSearchAppFilterBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView2, TextView textView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.appCategoryChevronView = imageView;
        this.appCategoryTextView = textView;
        this.appCategoryView = linearLayout;
        this.appSortChevronView = imageView2;
        this.appSortTextView = textView2;
        this.appSortView = linearLayout2;
    }

    public static ItemSearchAppFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchAppFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchAppFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558905, viewGroup, z, obj);
    }

    public static ItemSearchAppFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchAppFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchAppFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558905, null, false, obj);
    }

    public static ItemSearchAppFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchAppFilterBinding bind(View view, Object obj) {
        return (ItemSearchAppFilterBinding) bind(obj, view, 2131558905);
    }
}
