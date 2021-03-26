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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.widget.UserAvatarView;

public abstract class NodeRatingFeedLikeViewBinding extends ViewDataBinding {
    public final RatingBar averageRatingBar;
    public final TextView averageScoreView;
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final ImageView imageView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected NodeRating mModel;
    public final TextView nameView;
    public final RatingBar ratingBar;
    public final LinearLayout scoreViewContainer;
    public final TextView subtitleView;
    public final TextView timeView;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(NodeRating nodeRating);

    protected NodeRatingFeedLikeViewBinding(Object obj, View view, int i, RatingBar ratingBar2, TextView textView, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, ImageView imageView2, TextView textView2, RatingBar ratingBar3, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.averageRatingBar = ratingBar2;
        this.averageScoreView = textView;
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.imageView = imageView2;
        this.nameView = textView2;
        this.ratingBar = ratingBar3;
        this.scoreViewContainer = linearLayout2;
        this.subtitleView = textView3;
        this.timeView = textView4;
        this.titleView = textView5;
        this.userAvatarView = userAvatarView2;
    }

    public NodeRating getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static NodeRatingFeedLikeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NodeRatingFeedLikeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NodeRatingFeedLikeViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559057, viewGroup, z, obj);
    }

    public static NodeRatingFeedLikeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NodeRatingFeedLikeViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NodeRatingFeedLikeViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559057, null, false, obj);
    }

    public static NodeRatingFeedLikeViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NodeRatingFeedLikeViewBinding bind(View view, Object obj) {
        return (NodeRatingFeedLikeViewBinding) bind(obj, view, 2131559057);
    }
}
