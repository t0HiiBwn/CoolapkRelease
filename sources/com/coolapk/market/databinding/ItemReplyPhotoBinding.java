package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.SquareImageView;

public abstract class ItemReplyPhotoBinding extends ViewDataBinding {
    public final SquareImageView closeView;
    public final ImageView iconView;
    @Bindable
    protected String mUrl;

    public abstract void setUrl(String str);

    protected ItemReplyPhotoBinding(Object obj, View view, int i, SquareImageView squareImageView, ImageView imageView) {
        super(obj, view, i);
        this.closeView = squareImageView;
        this.iconView = imageView;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public static ItemReplyPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemReplyPhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558900, viewGroup, z, obj);
    }

    public static ItemReplyPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyPhotoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemReplyPhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558900, null, false, obj);
    }

    public static ItemReplyPhotoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyPhotoBinding bind(View view, Object obj) {
        return (ItemReplyPhotoBinding) bind(obj, view, 2131558900);
    }
}
