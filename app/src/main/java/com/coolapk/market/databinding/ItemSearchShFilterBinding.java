package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchShFilterBinding extends ViewDataBinding {
    public final ImageView erShouSortChevronView;
    public final TextView erShouSortTextView;
    public final LinearLayout erShouSortView;
    public final ImageView shOtherFilterChevronView;
    public final TextView shOtherFilterTextView;
    public final LinearLayout shOtherFilterView;

    protected ItemSearchShFilterBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView2, TextView textView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.erShouSortChevronView = imageView;
        this.erShouSortTextView = textView;
        this.erShouSortView = linearLayout;
        this.shOtherFilterChevronView = imageView2;
        this.shOtherFilterTextView = textView2;
        this.shOtherFilterView = linearLayout2;
    }

    public static ItemSearchShFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchShFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchShFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558916, viewGroup, z, obj);
    }

    public static ItemSearchShFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchShFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchShFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558916, null, false, obj);
    }

    public static ItemSearchShFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchShFilterBinding bind(View view, Object obj) {
        return (ItemSearchShFilterBinding) bind(obj, view, 2131558916);
    }
}
