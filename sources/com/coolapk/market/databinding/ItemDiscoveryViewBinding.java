package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;

public abstract class ItemDiscoveryViewBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final LinearLayout cardView;
    public final LinearLayout contentContainer;
    public final CoolapkCardView coolapkCardView;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final TextView fromWhereView;
    public final Space headerSpaceView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemDiscoveryViewBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, TextView textView3, Space space, ImageView imageView, Space space2, Space space3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.actionButton = textView2;
        this.cardView = linearLayout;
        this.contentContainer = linearLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.fromWhereView = textView3;
        this.headerSpaceView = space;
        this.iconView = imageView;
        this.nineImageSpaceView = space2;
        this.relativeSpaceView = space3;
        this.textView = textView4;
        this.titleView = textView5;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemDiscoveryViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDiscoveryViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDiscoveryViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558677, viewGroup, z, obj);
    }

    public static ItemDiscoveryViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDiscoveryViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDiscoveryViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558677, null, false, obj);
    }

    public static ItemDiscoveryViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDiscoveryViewBinding bind(View view, Object obj) {
        return (ItemDiscoveryViewBinding) bind(obj, view, 2131558677);
    }
}
