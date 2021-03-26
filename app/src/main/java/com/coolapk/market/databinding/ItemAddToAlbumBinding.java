package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Album;

public abstract class ItemAddToAlbumBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected Album mAlbum;
    public final TextView titleView;

    public abstract void setAlbum(Album album);

    protected ItemAddToAlbumBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.titleView = textView;
    }

    public Album getAlbum() {
        return this.mAlbum;
    }

    public static ItemAddToAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAddToAlbumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558574, viewGroup, z, obj);
    }

    public static ItemAddToAlbumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToAlbumBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAddToAlbumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558574, null, false, obj);
    }

    public static ItemAddToAlbumBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToAlbumBinding bind(View view, Object obj) {
        return (ItemAddToAlbumBinding) bind(obj, view, 2131558574);
    }
}
