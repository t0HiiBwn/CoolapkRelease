package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemAddToAlbumHeaderBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView iconView;
    public final TextView titleView;

    protected ItemAddToAlbumHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.titleView = textView;
    }

    public static ItemAddToAlbumHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToAlbumHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAddToAlbumHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558575, viewGroup, z, obj);
    }

    public static ItemAddToAlbumHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToAlbumHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAddToAlbumHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558575, null, false, obj);
    }

    public static ItemAddToAlbumHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToAlbumHeaderBinding bind(View view, Object obj) {
        return (ItemAddToAlbumHeaderBinding) bind(obj, view, 2131558575);
    }
}
