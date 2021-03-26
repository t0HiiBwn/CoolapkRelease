package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.loopeer.shadow.ShadowView;

public abstract class ItemImageCarouselCard2ItemBinding extends ViewDataBinding {
    public final ImageView imageView;
    @Bindable
    protected OnBitmapTransformListener mTransform;
    @Bindable
    protected String mUrl;
    public final ShadowView shadowView;

    public abstract void setTransform(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setUrl(String str);

    protected ItemImageCarouselCard2ItemBinding(Object obj, View view, int i, ImageView imageView2, ShadowView shadowView2) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.shadowView = shadowView2;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public OnBitmapTransformListener getTransform() {
        return this.mTransform;
    }

    public static ItemImageCarouselCard2ItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard2ItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageCarouselCard2ItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558790, viewGroup, z, obj);
    }

    public static ItemImageCarouselCard2ItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard2ItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageCarouselCard2ItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558790, null, false, obj);
    }

    public static ItemImageCarouselCard2ItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard2ItemBinding bind(View view, Object obj) {
        return (ItemImageCarouselCard2ItemBinding) bind(obj, view, 2131558790);
    }
}
