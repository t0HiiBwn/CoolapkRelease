package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.gongwen.marqueen.MarqueeView;

public abstract class ItemDocMarqueeCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final MarqueeView marqueeView;

    protected ItemDocMarqueeCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, MarqueeView marqueeView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.marqueeView = marqueeView2;
    }

    public static ItemDocMarqueeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocMarqueeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDocMarqueeCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558680, viewGroup, z, obj);
    }

    public static ItemDocMarqueeCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocMarqueeCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDocMarqueeCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558680, null, false, obj);
    }

    public static ItemDocMarqueeCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocMarqueeCardBinding bind(View view, Object obj) {
        return (ItemDocMarqueeCardBinding) bind(obj, view, 2131558680);
    }
}
