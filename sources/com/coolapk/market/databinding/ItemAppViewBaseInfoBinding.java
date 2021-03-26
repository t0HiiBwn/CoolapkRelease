package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.TagView;
import com.github.florent37.arclayout.ArcLayout;

public abstract class ItemAppViewBaseInfoBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView actionFollow;
    public final TextView actionOpenWithPlay;
    public final TextView actionRank;
    public final LinearLayout allCouponView;
    public final ArcLayout arcLayout;
    public final ImageView arrowView;
    public final TextView changeLogContentView;
    public final LinearLayout changeLogLayout;
    public final TextView changeLogTimeView;
    public final TextView changeLogTitleView;
    public final ImageView clickToShowChangeLogView;
    public final LinearLayout couponLayout;
    public final RecyclerView couponList;
    public final ImageView coverView;
    public final LinearLayout detailClickLayout;
    public final TextView extraTextView;
    public final TagView flowLayout;
    public final ItemAppViewBaseInfoGiftBinding giftLayout;
    public final LinearLayout headerView;
    public final FrameLayout introduceClickView;
    public final TextView introduceView;
    public final ImageView logoView;
    @Bindable
    protected AppViewViewModel mViewModel;
    public final TextView moreView;
    public final TextView ratingAverage;
    public final RatingBar ratingBarAverage;
    public final RecyclerView thumbnailView;
    public final TextView titleView;
    public final LinearLayout xposedPluginLayout;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemAppViewBaseInfoBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout, ArcLayout arcLayout2, ImageView imageView, TextView textView5, LinearLayout linearLayout2, TextView textView6, TextView textView7, ImageView imageView2, LinearLayout linearLayout3, RecyclerView recyclerView, ImageView imageView3, LinearLayout linearLayout4, TextView textView8, TagView tagView, ItemAppViewBaseInfoGiftBinding itemAppViewBaseInfoGiftBinding, LinearLayout linearLayout5, FrameLayout frameLayout, TextView textView9, ImageView imageView4, TextView textView10, TextView textView11, RatingBar ratingBar, RecyclerView recyclerView2, TextView textView12, LinearLayout linearLayout6) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.actionFollow = textView2;
        this.actionOpenWithPlay = textView3;
        this.actionRank = textView4;
        this.allCouponView = linearLayout;
        this.arcLayout = arcLayout2;
        this.arrowView = imageView;
        this.changeLogContentView = textView5;
        this.changeLogLayout = linearLayout2;
        this.changeLogTimeView = textView6;
        this.changeLogTitleView = textView7;
        this.clickToShowChangeLogView = imageView2;
        this.couponLayout = linearLayout3;
        this.couponList = recyclerView;
        this.coverView = imageView3;
        this.detailClickLayout = linearLayout4;
        this.extraTextView = textView8;
        this.flowLayout = tagView;
        this.giftLayout = itemAppViewBaseInfoGiftBinding;
        this.headerView = linearLayout5;
        this.introduceClickView = frameLayout;
        this.introduceView = textView9;
        this.logoView = imageView4;
        this.moreView = textView10;
        this.ratingAverage = textView11;
        this.ratingBarAverage = ratingBar;
        this.thumbnailView = recyclerView2;
        this.titleView = textView12;
        this.xposedPluginLayout = linearLayout6;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppViewBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558603, viewGroup, z, obj);
    }

    public static ItemAppViewBaseInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558603, null, false, obj);
    }

    public static ItemAppViewBaseInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoBinding bind(View view, Object obj) {
        return (ItemAppViewBaseInfoBinding) bind(obj, view, 2131558603);
    }
}
