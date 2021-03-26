package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedRatingViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView ownerTextView;
    public final LinearLayout ownerView;
    public final RatingBar ratingBar;
    public final TextView scoreView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedRatingViewBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, RatingBar ratingBar2, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.ownerTextView = textView;
        this.ownerView = linearLayout2;
        this.ratingBar = ratingBar2;
        this.scoreView = textView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedRatingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedRatingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558722, viewGroup, z, obj);
    }

    public static ItemFeedRatingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedRatingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558722, null, false, obj);
    }

    public static ItemFeedRatingViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingViewBinding bind(View view, Object obj) {
        return (ItemFeedRatingViewBinding) bind(obj, view, 2131558722);
    }
}
