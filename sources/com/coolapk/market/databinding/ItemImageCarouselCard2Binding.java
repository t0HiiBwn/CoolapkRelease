package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.percentlayout.widget.PercentFrameLayout;
import com.coolapk.market.design.CoolapkCardView;
import com.youth.banner.Banner;

public abstract class ItemImageCarouselCard2Binding extends ViewDataBinding {
    public final Banner bannerView;
    public final CoolapkCardView coolapkCardView;
    public final PercentFrameLayout frameView;

    protected ItemImageCarouselCard2Binding(Object obj, View view, int i, Banner banner, CoolapkCardView coolapkCardView2, PercentFrameLayout percentFrameLayout) {
        super(obj, view, i);
        this.bannerView = banner;
        this.coolapkCardView = coolapkCardView2;
        this.frameView = percentFrameLayout;
    }

    public static ItemImageCarouselCard2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageCarouselCard2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558796, viewGroup, z, obj);
    }

    public static ItemImageCarouselCard2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageCarouselCard2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558796, null, false, obj);
    }

    public static ItemImageCarouselCard2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCarouselCard2Binding bind(View view, Object obj) {
        return (ItemImageCarouselCard2Binding) bind(obj, view, 2131558796);
    }
}
