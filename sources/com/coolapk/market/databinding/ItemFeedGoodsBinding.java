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
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class ItemFeedGoodsBinding extends ViewDataBinding {
    public final TextView buyTextView;
    public final LinearLayout buyView;
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final FeedActionView2 feedActionView;
    public final Space goodsSpaceView;
    public final Space headerSpaceView;
    public final Space hotReplySpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final BadBadRatingBar ratingBar;
    public final Space relativeSpaceView;
    public final TextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedGoodsBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, FeedActionView2 feedActionView2, Space space, Space space2, Space space3, Space space4, BadBadRatingBar badBadRatingBar, Space space5, TextView textView3) {
        super(obj, view, i);
        this.buyTextView = textView2;
        this.buyView = linearLayout;
        this.cardView = linearLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.feedActionView = feedActionView2;
        this.goodsSpaceView = space;
        this.headerSpaceView = space2;
        this.hotReplySpaceView = space3;
        this.nineImageSpaceView = space4;
        this.ratingBar = badBadRatingBar;
        this.relativeSpaceView = space5;
        this.textView = textView3;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558702, viewGroup, z, obj);
    }

    public static ItemFeedGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558702, null, false, obj);
    }

    public static ItemFeedGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsBinding bind(View view, Object obj) {
        return (ItemFeedGoodsBinding) bind(obj, view, 2131558702);
    }
}
