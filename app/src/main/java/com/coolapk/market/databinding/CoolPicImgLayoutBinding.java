package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;

public abstract class CoolPicImgLayoutBinding extends ViewDataBinding {
    public final LinearLayout frontView;
    public final PhotoView gifImageView;
    public final SubsamplingScaleImageView imageView;
    @Bindable
    protected String mUrl;
    public final ImageLoadProgressBar progressBar;

    public abstract void setUrl(String str);

    protected CoolPicImgLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, PhotoView photoView, SubsamplingScaleImageView subsamplingScaleImageView, ImageLoadProgressBar imageLoadProgressBar) {
        super(obj, view, i);
        this.frontView = linearLayout;
        this.gifImageView = photoView;
        this.imageView = subsamplingScaleImageView;
        this.progressBar = imageLoadProgressBar;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public static CoolPicImgLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolPicImgLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CoolPicImgLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558488, viewGroup, z, obj);
    }

    public static CoolPicImgLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolPicImgLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CoolPicImgLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558488, null, false, obj);
    }

    public static CoolPicImgLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolPicImgLayoutBinding bind(View view, Object obj) {
        return (CoolPicImgLayoutBinding) bind(obj, view, 2131558488);
    }
}
