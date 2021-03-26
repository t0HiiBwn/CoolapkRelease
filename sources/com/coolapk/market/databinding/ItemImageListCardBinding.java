package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.youth.banner.Banner;

public abstract class ItemImageListCardBinding extends ViewDataBinding {
    public final Banner bannerView;
    public final CoolapkCardView coolapkCardView;
    public final MaxWidthFrameLayout frameView;
    public final FrameLayout itemView;

    protected ItemImageListCardBinding(Object obj, View view, int i, Banner banner, CoolapkCardView coolapkCardView2, MaxWidthFrameLayout maxWidthFrameLayout, FrameLayout frameLayout) {
        super(obj, view, i);
        this.bannerView = banner;
        this.coolapkCardView = coolapkCardView2;
        this.frameView = maxWidthFrameLayout;
        this.itemView = frameLayout;
    }

    public static ItemImageListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558791, viewGroup, z, obj);
    }

    public static ItemImageListCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageListCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558791, null, false, obj);
    }

    public static ItemImageListCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageListCardBinding bind(View view, Object obj) {
        return (ItemImageListCardBinding) bind(obj, view, 2131558791);
    }
}
