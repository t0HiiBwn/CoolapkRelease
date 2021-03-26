package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedDiscoveryDetailBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final LinearLayout cardView;
    public final LinearLayout contentContainer;
    public final TextView fromWhereView;
    public final Space headerSpaceView;
    public final ImageView iconView;
    public final LinearLayout infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final FrameLayout textViewContainer;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedDiscoveryDetailBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, Space space, ImageView imageView, LinearLayout linearLayout3, Space space2, Space space3, TextView textView4, FrameLayout frameLayout, TextView textView5) {
        super(obj, view, i);
        this.actionButton = textView2;
        this.cardView = linearLayout;
        this.contentContainer = linearLayout2;
        this.fromWhereView = textView3;
        this.headerSpaceView = space;
        this.iconView = imageView;
        this.infoView = linearLayout3;
        this.nineImageSpaceView = space2;
        this.relativeSpaceView = space3;
        this.textView = textView4;
        this.textViewContainer = frameLayout;
        this.titleView = textView5;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedDiscoveryDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedDiscoveryDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedDiscoveryDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558697, viewGroup, z, obj);
    }

    public static ItemFeedDiscoveryDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedDiscoveryDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedDiscoveryDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558697, null, false, obj);
    }

    public static ItemFeedDiscoveryDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedDiscoveryDetailBinding bind(View view, Object obj) {
        return (ItemFeedDiscoveryDetailBinding) bind(obj, view, 2131558697);
    }
}
