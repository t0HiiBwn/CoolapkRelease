package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemCoolPicImageViewBinding extends ViewDataBinding {
    public final MaxWidthFrameLayout frameView;

    protected ItemCoolPicImageViewBinding(Object obj, View view, int i, MaxWidthFrameLayout maxWidthFrameLayout) {
        super(obj, view, i);
        this.frameView = maxWidthFrameLayout;
    }

    public static ItemCoolPicImageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolPicImageViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCoolPicImageViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558668, viewGroup, z, obj);
    }

    public static ItemCoolPicImageViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolPicImageViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCoolPicImageViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558668, null, false, obj);
    }

    public static ItemCoolPicImageViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolPicImageViewBinding bind(View view, Object obj) {
        return (ItemCoolPicImageViewBinding) bind(obj, view, 2131558668);
    }
}
