package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedGoodsDetailImageBinding extends ViewDataBinding {
    public final FrameLayout frameView;
    public final TextView gifIndicator;
    public final ImageView imageView;

    protected ItemFeedGoodsDetailImageBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView2) {
        super(obj, view, i);
        this.frameView = frameLayout;
        this.gifIndicator = textView;
        this.imageView = imageView2;
    }

    public static ItemFeedGoodsDetailImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsDetailImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedGoodsDetailImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558711, viewGroup, z, obj);
    }

    public static ItemFeedGoodsDetailImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsDetailImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedGoodsDetailImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558711, null, false, obj);
    }

    public static ItemFeedGoodsDetailImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsDetailImageBinding bind(View view, Object obj) {
        return (ItemFeedGoodsDetailImageBinding) bind(obj, view, 2131558711);
    }
}
