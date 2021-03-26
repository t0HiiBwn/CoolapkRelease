package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemReplyPhotoAddBinding extends ViewDataBinding {
    public final ImageView iconView;

    protected ItemReplyPhotoAddBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.iconView = imageView;
    }

    public static ItemReplyPhotoAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyPhotoAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemReplyPhotoAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558901, viewGroup, z, obj);
    }

    public static ItemReplyPhotoAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyPhotoAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemReplyPhotoAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558901, null, false, obj);
    }

    public static ItemReplyPhotoAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyPhotoAddBinding bind(View view, Object obj) {
        return (ItemReplyPhotoAddBinding) bind(obj, view, 2131558901);
    }
}
