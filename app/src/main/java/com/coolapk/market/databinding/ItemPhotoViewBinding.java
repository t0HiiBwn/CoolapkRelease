package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.subsamplingview.SubsamplingScaleImageView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import com.coolapk.market.widget.view.PhotoViewCompat;

public abstract class ItemPhotoViewBinding extends ViewDataBinding {
    public final PhotoViewCompat gifImageView;
    public final SubsamplingScaleImageView imageView;
    public final TextView loadSourceButton;
    public final ImageLoadProgressBar progressBar;
    public final PhotoViewCompat thumbnailView;

    protected ItemPhotoViewBinding(Object obj, View view, int i, PhotoViewCompat photoViewCompat, SubsamplingScaleImageView subsamplingScaleImageView, TextView textView, ImageLoadProgressBar imageLoadProgressBar, PhotoViewCompat photoViewCompat2) {
        super(obj, view, i);
        this.gifImageView = photoViewCompat;
        this.imageView = subsamplingScaleImageView;
        this.loadSourceButton = textView;
        this.progressBar = imageLoadProgressBar;
        this.thumbnailView = photoViewCompat2;
    }

    public static ItemPhotoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPhotoViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558852, viewGroup, z, obj);
    }

    public static ItemPhotoViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPhotoViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558852, null, false, obj);
    }

    public static ItemPhotoViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoViewBinding bind(View view, Object obj) {
        return (ItemPhotoViewBinding) bind(obj, view, 2131558852);
    }
}
