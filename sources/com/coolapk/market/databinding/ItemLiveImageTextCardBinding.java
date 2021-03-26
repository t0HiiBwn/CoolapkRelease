package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Live;

public abstract class ItemLiveImageTextCardBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final CoolapkCardView coolapkCardView;
    public final ImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected Live mLive;
    public final TextView numView;
    public final TextView statusView;
    public final TextView titleView;

    public abstract void setLive(Live live);

    protected ItemLiveImageTextCardBinding(Object obj, View view, int i, TextView textView, CoolapkCardView coolapkCardView2, ImageView imageView2, FrameLayout frameLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.coolapkCardView = coolapkCardView2;
        this.imageView = imageView2;
        this.itemView = frameLayout;
        this.numView = textView2;
        this.statusView = textView3;
        this.titleView = textView4;
    }

    public Live getLive() {
        return this.mLive;
    }

    public static ItemLiveImageTextCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveImageTextCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveImageTextCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558805, viewGroup, z, obj);
    }

    public static ItemLiveImageTextCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveImageTextCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveImageTextCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558805, null, false, obj);
    }

    public static ItemLiveImageTextCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveImageTextCardBinding bind(View view, Object obj) {
        return (ItemLiveImageTextCardBinding) bind(obj, view, 2131558805);
    }
}
