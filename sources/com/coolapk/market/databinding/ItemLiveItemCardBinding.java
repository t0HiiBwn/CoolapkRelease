package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Live;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemLiveItemCardBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final CoolapkCardView coolapkCardView;
    public final AspectRatioImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected Live mLive;
    public final TextView numView;
    public final TextView statusView;
    public final TextView timeView;
    public final TextView titlePlaceholderView;
    public final TextView titleView;

    public abstract void setLive(Live live);

    protected ItemLiveItemCardBinding(Object obj, View view, int i, TextView textView, CoolapkCardView coolapkCardView2, AspectRatioImageView aspectRatioImageView, FrameLayout frameLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.actionButton = textView;
        this.coolapkCardView = coolapkCardView2;
        this.imageView = aspectRatioImageView;
        this.itemView = frameLayout;
        this.numView = textView2;
        this.statusView = textView3;
        this.timeView = textView4;
        this.titlePlaceholderView = textView5;
        this.titleView = textView6;
    }

    public Live getLive() {
        return this.mLive;
    }

    public static ItemLiveItemCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveItemCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveItemCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558806, viewGroup, z, obj);
    }

    public static ItemLiveItemCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveItemCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveItemCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558806, null, false, obj);
    }

    public static ItemLiveItemCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveItemCardBinding bind(View view, Object obj) {
        return (ItemLiveItemCardBinding) bind(obj, view, 2131558806);
    }
}
