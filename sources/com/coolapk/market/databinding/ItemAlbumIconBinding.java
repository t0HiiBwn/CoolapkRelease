package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;

public abstract class ItemAlbumIconBinding extends ViewDataBinding {
    public final ImageView albumIconView;
    @Bindable
    protected String mIcon;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView moreCountView;

    public abstract void setIcon(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemAlbumIconBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.albumIconView = imageView;
        this.moreCountView = textView;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public static ItemAlbumIconBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumIconBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumIconBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558588, viewGroup, z, obj);
    }

    public static ItemAlbumIconBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumIconBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumIconBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558588, null, false, obj);
    }

    public static ItemAlbumIconBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumIconBinding bind(View view, Object obj) {
        return (ItemAlbumIconBinding) bind(obj, view, 2131558588);
    }
}
