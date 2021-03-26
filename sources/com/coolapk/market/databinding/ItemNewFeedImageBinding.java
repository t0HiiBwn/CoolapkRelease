package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.SquareImageView;

public abstract class ItemNewFeedImageBinding extends ViewDataBinding {
    public final FrameLayout cardView;
    public final SquareImageView closeView;
    public final SquareImageView imageView;
    public final TextView indicatorView;

    protected ItemNewFeedImageBinding(Object obj, View view, int i, FrameLayout frameLayout, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView) {
        super(obj, view, i);
        this.cardView = frameLayout;
        this.closeView = squareImageView;
        this.imageView = squareImageView2;
        this.indicatorView = textView;
    }

    public static ItemNewFeedImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewFeedImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNewFeedImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558841, viewGroup, z, obj);
    }

    public static ItemNewFeedImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewFeedImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNewFeedImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558841, null, false, obj);
    }

    public static ItemNewFeedImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewFeedImageBinding bind(View view, Object obj) {
        return (ItemNewFeedImageBinding) bind(obj, view, 2131558841);
    }
}
