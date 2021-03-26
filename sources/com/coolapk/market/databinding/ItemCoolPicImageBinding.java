package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemCoolPicImageBinding extends ViewDataBinding {
    public final ScalingImageView imageView;
    public final FrameLayout itemView;

    protected ItemCoolPicImageBinding(Object obj, View view, int i, ScalingImageView scalingImageView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.imageView = scalingImageView;
        this.itemView = frameLayout;
    }

    public static ItemCoolPicImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolPicImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCoolPicImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558661, viewGroup, z, obj);
    }

    public static ItemCoolPicImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolPicImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCoolPicImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558661, null, false, obj);
    }

    public static ItemCoolPicImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolPicImageBinding bind(View view, Object obj) {
        return (ItemCoolPicImageBinding) bind(obj, view, 2131558661);
    }
}
