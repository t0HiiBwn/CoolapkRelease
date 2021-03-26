package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemFeedRatingBinding extends ViewDataBinding {
    public final CoolEllipsizeTextView badTextView;
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final CoolEllipsizeTextView generalTextView;
    public final CoolEllipsizeTextView goodTextView;
    public final Space headerSpaceView;
    public final Space hotReplySpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space ratingDataSpaceView;
    public final Space ratingSpaceView;
    public final Space relativeSpaceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedRatingBinding(Object obj, View view, int i, CoolEllipsizeTextView coolEllipsizeTextView, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, CoolEllipsizeTextView coolEllipsizeTextView2, CoolEllipsizeTextView coolEllipsizeTextView3, Space space, Space space2, Space space3, Space space4, Space space5, Space space6) {
        super(obj, view, i);
        this.badTextView = coolEllipsizeTextView;
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.generalTextView = coolEllipsizeTextView2;
        this.goodTextView = coolEllipsizeTextView3;
        this.headerSpaceView = space;
        this.hotReplySpaceView = space2;
        this.nineImageSpaceView = space3;
        this.ratingDataSpaceView = space4;
        this.ratingSpaceView = space5;
        this.relativeSpaceView = space6;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558718, viewGroup, z, obj);
    }

    public static ItemFeedRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558718, null, false, obj);
    }

    public static ItemFeedRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingBinding bind(View view, Object obj) {
        return (ItemFeedRatingBinding) bind(obj, view, 2131558718);
    }
}
