package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnImageLoadListener;

public abstract class AppPhotoThumbnailBinding extends ViewDataBinding {
    public final ImageView image;
    @Bindable
    protected OnImageLoadListener mOnImageLoad;
    @Bindable
    protected String mUrl;

    public abstract void setOnImageLoad(OnImageLoadListener onImageLoadListener);

    public abstract void setUrl(String str);

    protected AppPhotoThumbnailBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.image = imageView;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public OnImageLoadListener getOnImageLoad() {
        return this.mOnImageLoad;
    }

    public static AppPhotoThumbnailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppPhotoThumbnailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppPhotoThumbnailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558601, viewGroup, z, obj);
    }

    public static AppPhotoThumbnailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppPhotoThumbnailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppPhotoThumbnailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558601, null, false, obj);
    }

    public static AppPhotoThumbnailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppPhotoThumbnailBinding bind(View view, Object obj) {
        return (AppPhotoThumbnailBinding) bind(obj, view, 2131558601);
    }
}
