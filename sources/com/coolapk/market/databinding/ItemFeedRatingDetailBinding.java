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
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class ItemFeedRatingDetailBinding extends ViewDataBinding {
    public final Space badImageSpaceView;
    public final TextView badTagsView;
    public final LinearLayout cardView;
    public final Space generalImageSpaceView;
    public final TextView generalTagsView;
    public final Space goodImageSpaceView;
    public final TextView goodTagsView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView ownerTextView;
    public final LinearLayout ownerView;
    public final BadBadRatingBar ratingBar;
    public final TextView ratingTagsView;
    public final Space relativeSpaceView;
    public final TextView scoreView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedRatingDetailBinding(Object obj, View view, int i, Space space, TextView textView, LinearLayout linearLayout, Space space2, TextView textView2, Space space3, TextView textView3, Space space4, TextView textView4, LinearLayout linearLayout2, BadBadRatingBar badBadRatingBar, TextView textView5, Space space5, TextView textView6) {
        super(obj, view, i);
        this.badImageSpaceView = space;
        this.badTagsView = textView;
        this.cardView = linearLayout;
        this.generalImageSpaceView = space2;
        this.generalTagsView = textView2;
        this.goodImageSpaceView = space3;
        this.goodTagsView = textView3;
        this.headerSpaceView = space4;
        this.ownerTextView = textView4;
        this.ownerView = linearLayout2;
        this.ratingBar = badBadRatingBar;
        this.ratingTagsView = textView5;
        this.relativeSpaceView = space5;
        this.scoreView = textView6;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedRatingDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedRatingDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558720, viewGroup, z, obj);
    }

    public static ItemFeedRatingDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedRatingDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558720, null, false, obj);
    }

    public static ItemFeedRatingDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingDetailBinding bind(View view, Object obj) {
        return (ItemFeedRatingDetailBinding) bind(obj, view, 2131558720);
    }
}
