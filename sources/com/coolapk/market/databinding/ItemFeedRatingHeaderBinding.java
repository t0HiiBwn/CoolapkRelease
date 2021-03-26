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
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemFeedRatingHeaderBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final ImageView moreView;
    public final TextView nameView;
    public final RatingBar ratingBar;
    public final TextView scoreView;
    public final LinearLayout setTopView;
    public final TextView timeView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedRatingHeaderBinding(Object obj, View view, int i, ImageView imageView, TextView textView, RatingBar ratingBar2, TextView textView2, LinearLayout linearLayout, TextView textView3, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.moreView = imageView;
        this.nameView = textView;
        this.ratingBar = ratingBar2;
        this.scoreView = textView2;
        this.setTopView = linearLayout;
        this.timeView = textView3;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedRatingHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedRatingHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558714, viewGroup, z, obj);
    }

    public static ItemFeedRatingHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedRatingHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558714, null, false, obj);
    }

    public static ItemFeedRatingHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedRatingHeaderBinding bind(View view, Object obj) {
        return (ItemFeedRatingHeaderBinding) bind(obj, view, 2131558714);
    }
}
