package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedCoolPicDetailBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final FrameLayout textViewContainer;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedCoolPicDetailBinding(Object obj, View view, int i, LinearLayout linearLayout, Space space, Space space2, TextView textView2, FrameLayout frameLayout, TextView textView3) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.headerSpaceView = space;
        this.relativeSpaceView = space2;
        this.textView = textView2;
        this.textViewContainer = frameLayout;
        this.titleView = textView3;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedCoolPicDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoolPicDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedCoolPicDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558693, viewGroup, z, obj);
    }

    public static ItemFeedCoolPicDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoolPicDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedCoolPicDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558693, null, false, obj);
    }

    public static ItemFeedCoolPicDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoolPicDetailBinding bind(View view, Object obj) {
        return (ItemFeedCoolPicDetailBinding) bind(obj, view, 2131558693);
    }
}
