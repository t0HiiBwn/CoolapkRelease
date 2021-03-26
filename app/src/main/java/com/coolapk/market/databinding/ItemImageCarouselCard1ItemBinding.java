package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemImageCarouselCard1ItemBinding extends ViewDataBinding {
    public final ImageView imageView;
    @Bindable
    protected String mUrl;

    public abstract void setUrl(String str);

    protected ItemImageCarouselCard1ItemBinding(Object obj, View view, int i, ImageView imageView2) {
        super(obj, view, i);
        this.imageView = imageView2;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public static ItemImageCarouselCard1ItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard1ItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageCarouselCard1ItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558788, viewGroup, z, obj);
    }

    public static ItemImageCarouselCard1ItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard1ItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageCarouselCard1ItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558788, null, false, obj);
    }

    public static ItemImageCarouselCard1ItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard1ItemBinding bind(View view, Object obj) {
        return (ItemImageCarouselCard1ItemBinding) bind(obj, view, 2131558788);
    }
}
