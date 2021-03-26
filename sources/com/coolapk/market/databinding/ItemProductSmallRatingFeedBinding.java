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
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemProductSmallRatingFeedBinding extends ViewDataBinding {
    public final CoolEllipsizeTextView badTextView;
    public final ImageView commentIcon;
    public final TextView commentNum;
    public final LinearLayout commentView;
    public final CoolEllipsizeTextView generalTextView;
    public final CoolEllipsizeTextView goodTextView;
    public final LinearLayout itemView;
    public final ImageView likeIcon;
    public final TextView likeNum;
    public final LinearLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView nameView;
    public final RatingBar ratingBar;
    public final TextView scoreView;
    public final TextView timeView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemProductSmallRatingFeedBinding(Object obj, View view, int i, CoolEllipsizeTextView coolEllipsizeTextView, ImageView imageView, TextView textView, LinearLayout linearLayout, CoolEllipsizeTextView coolEllipsizeTextView2, CoolEllipsizeTextView coolEllipsizeTextView3, LinearLayout linearLayout2, ImageView imageView2, TextView textView2, LinearLayout linearLayout3, TextView textView3, RatingBar ratingBar2, TextView textView4, TextView textView5, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.badTextView = coolEllipsizeTextView;
        this.commentIcon = imageView;
        this.commentNum = textView;
        this.commentView = linearLayout;
        this.generalTextView = coolEllipsizeTextView2;
        this.goodTextView = coolEllipsizeTextView3;
        this.itemView = linearLayout2;
        this.likeIcon = imageView2;
        this.likeNum = textView2;
        this.likeView = linearLayout3;
        this.nameView = textView3;
        this.ratingBar = ratingBar2;
        this.scoreView = textView4;
        this.timeView = textView5;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemProductSmallRatingFeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSmallRatingFeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSmallRatingFeedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558880, viewGroup, z, obj);
    }

    public static ItemProductSmallRatingFeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSmallRatingFeedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSmallRatingFeedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558880, null, false, obj);
    }

    public static ItemProductSmallRatingFeedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSmallRatingFeedBinding bind(View view, Object obj) {
        return (ItemProductSmallRatingFeedBinding) bind(obj, view, 2131558880);
    }
}
