package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.CoolFlowLayout;

public abstract class ItemLiveLineViewPartBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final CoolFlowLayout flowLayout;
    public final FrameLayout itemView;
    public final FrameLayout portalView;
    public final ScrollView scrollView;
    public final TextView titleView;

    protected ItemLiveLineViewPartBinding(Object obj, View view, int i, ImageView imageView, CoolFlowLayout coolFlowLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ScrollView scrollView2, TextView textView) {
        super(obj, view, i);
        this.closeView = imageView;
        this.flowLayout = coolFlowLayout;
        this.itemView = frameLayout;
        this.portalView = frameLayout2;
        this.scrollView = scrollView2;
        this.titleView = textView;
    }

    public static ItemLiveLineViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveLineViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveLineViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558807, viewGroup, z, obj);
    }

    public static ItemLiveLineViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveLineViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveLineViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558807, null, false, obj);
    }

    public static ItemLiveLineViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveLineViewPartBinding bind(View view, Object obj) {
        return (ItemLiveLineViewPartBinding) bind(obj, view, 2131558807);
    }
}
