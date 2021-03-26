package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Live;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemLiveCardBinding extends ViewDataBinding {
    public final AspectRatioImageView imageView;
    @Bindable
    protected Live mLive;
    public final TextView numView;
    public final TextView statusView;
    public final TextView titleView;

    public abstract void setLive(Live live);

    protected ItemLiveCardBinding(Object obj, View view, int i, AspectRatioImageView aspectRatioImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.imageView = aspectRatioImageView;
        this.numView = textView;
        this.statusView = textView2;
        this.titleView = textView3;
    }

    public Live getLive() {
        return this.mLive;
    }

    public static ItemLiveCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558804, viewGroup, z, obj);
    }

    public static ItemLiveCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558804, null, false, obj);
    }

    public static ItemLiveCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveCardBinding bind(View view, Object obj) {
        return (ItemLiveCardBinding) bind(obj, view, 2131558804);
    }
}
