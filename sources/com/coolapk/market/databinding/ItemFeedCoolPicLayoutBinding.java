package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public abstract class ItemFeedCoolPicLayoutBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final Space coolPicSpaceView;
    public final CoolapkCardView coolapkCardView;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final Space headerSpaceView;
    public final Space hotReplySpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space relativeSpaceView;
    public final TextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedCoolPicLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, Space space, CoolapkCardView coolapkCardView2, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, Space space2, Space space3, Space space4, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolPicSpaceView = space;
        this.coolapkCardView = coolapkCardView2;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.headerSpaceView = space2;
        this.hotReplySpaceView = space3;
        this.relativeSpaceView = space4;
        this.textView = textView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedCoolPicLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoolPicLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedCoolPicLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558694, viewGroup, z, obj);
    }

    public static ItemFeedCoolPicLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoolPicLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedCoolPicLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558694, null, false, obj);
    }

    public static ItemFeedCoolPicLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoolPicLayoutBinding bind(View view, Object obj) {
        return (ItemFeedCoolPicLayoutBinding) bind(obj, view, 2131558694);
    }
}
