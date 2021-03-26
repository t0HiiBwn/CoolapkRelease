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
import androidx.viewpager2.widget.ViewPager2;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemFeedGoodsDetailBinding extends ViewDataBinding {
    public final TextView buyTextView;
    public final LinearLayout buyView;
    public final LinearLayout cardView;
    public final Space goodsSpaceView;
    public final Space headerSpaceView;
    public final IndicatorView indicatorView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final BadBadRatingBar ratingBar;
    public final TextView ratingTagsView;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final ViewPager2 viewPager;
    public final MaxWidthFrameLayout viewPagerContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedGoodsDetailBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, Space space, Space space2, IndicatorView indicatorView2, BadBadRatingBar badBadRatingBar, TextView textView3, Space space3, TextView textView4, ViewPager2 viewPager2, MaxWidthFrameLayout maxWidthFrameLayout) {
        super(obj, view, i);
        this.buyTextView = textView2;
        this.buyView = linearLayout;
        this.cardView = linearLayout2;
        this.goodsSpaceView = space;
        this.headerSpaceView = space2;
        this.indicatorView = indicatorView2;
        this.ratingBar = badBadRatingBar;
        this.ratingTagsView = textView3;
        this.relativeSpaceView = space3;
        this.textView = textView4;
        this.viewPager = viewPager2;
        this.viewPagerContainer = maxWidthFrameLayout;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedGoodsDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedGoodsDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558710, viewGroup, z, obj);
    }

    public static ItemFeedGoodsDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedGoodsDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558710, null, false, obj);
    }

    public static ItemFeedGoodsDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsDetailBinding bind(View view, Object obj) {
        return (ItemFeedGoodsDetailBinding) bind(obj, view, 2131558710);
    }
}
