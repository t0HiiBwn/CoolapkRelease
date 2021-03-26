package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.ControlGifImageView;
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;

public abstract class ItemFeedImageBinding extends ViewDataBinding {
    public final DividerLineView dividerView;
    public final FrameLayout frameView;
    public final TextView gifIndicator;
    public final ControlGifImageView imageView;
    @Bindable
    protected String mGifImage;
    @Bindable
    protected String mImgUrl;
    public final ImageLoadProgressBar progressBar;

    public abstract void setGifImage(String str);

    public abstract void setImgUrl(String str);

    protected ItemFeedImageBinding(Object obj, View view, int i, DividerLineView dividerLineView, FrameLayout frameLayout, TextView textView, ControlGifImageView controlGifImageView, ImageLoadProgressBar imageLoadProgressBar) {
        super(obj, view, i);
        this.dividerView = dividerLineView;
        this.frameView = frameLayout;
        this.gifIndicator = textView;
        this.imageView = controlGifImageView;
        this.progressBar = imageLoadProgressBar;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public String getGifImage() {
        return this.mGifImage;
    }

    public static ItemFeedImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558714, viewGroup, z, obj);
    }

    public static ItemFeedImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558714, null, false, obj);
    }

    public static ItemFeedImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedImageBinding bind(View view, Object obj) {
        return (ItemFeedImageBinding) bind(obj, view, 2131558714);
    }
}
