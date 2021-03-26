package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.florent37.shapeofview.shapes.RoundRectView;

public abstract class ItemAppNodeThumbnailBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final TextView longPicTextView;
    public final RoundRectView shapeView;

    protected ItemAppNodeThumbnailBinding(Object obj, View view, int i, ImageView imageView2, TextView textView, RoundRectView roundRectView) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.longPicTextView = textView;
        this.shapeView = roundRectView;
    }

    public static ItemAppNodeThumbnailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeThumbnailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppNodeThumbnailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558596, viewGroup, z, obj);
    }

    public static ItemAppNodeThumbnailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeThumbnailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppNodeThumbnailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558596, null, false, obj);
    }

    public static ItemAppNodeThumbnailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeThumbnailBinding bind(View view, Object obj) {
        return (ItemAppNodeThumbnailBinding) bind(obj, view, 2131558596);
    }
}
