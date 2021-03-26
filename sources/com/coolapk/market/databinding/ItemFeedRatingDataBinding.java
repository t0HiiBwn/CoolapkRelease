package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedTarget;

public abstract class ItemFeedRatingDataBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView imageView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedTarget mModel;
    public final RatingBar ratingBar;
    public final TextView scoreView;
    public final LinearLayout scoreViewContainer;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedTarget feedTarget);

    protected ItemFeedRatingDataBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView2, RatingBar ratingBar2, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.imageView = imageView2;
        this.ratingBar = ratingBar2;
        this.scoreView = textView;
        this.scoreViewContainer = linearLayout2;
        this.subtitleView = textView2;
        this.titleView = textView3;
    }

    public FeedTarget getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedRatingDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedRatingDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558719, viewGroup, z, obj);
    }

    public static ItemFeedRatingDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingDataBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedRatingDataBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558719, null, false, obj);
    }

    public static ItemFeedRatingDataBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingDataBinding bind(View view, Object obj) {
        return (ItemFeedRatingDataBinding) bind(obj, view, 2131558719);
    }
}
