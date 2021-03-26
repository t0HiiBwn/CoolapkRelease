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

public abstract class ItemProductSmallRatingArticleBinding extends ViewDataBinding {
    public final ImageView commentIcon;
    public final TextView commentNum;
    public final LinearLayout commentView;
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
    public final CoolEllipsizeTextView textView;
    public final TextView timeView;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemProductSmallRatingArticleBinding(Object obj, View view, int i, ImageView imageView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, TextView textView3, LinearLayout linearLayout3, TextView textView4, RatingBar ratingBar2, TextView textView5, CoolEllipsizeTextView coolEllipsizeTextView, TextView textView6, TextView textView7, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.commentIcon = imageView;
        this.commentNum = textView2;
        this.commentView = linearLayout;
        this.itemView = linearLayout2;
        this.likeIcon = imageView2;
        this.likeNum = textView3;
        this.likeView = linearLayout3;
        this.nameView = textView4;
        this.ratingBar = ratingBar2;
        this.scoreView = textView5;
        this.textView = coolEllipsizeTextView;
        this.timeView = textView6;
        this.titleView = textView7;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemProductSmallRatingArticleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSmallRatingArticleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSmallRatingArticleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558886, viewGroup, z, obj);
    }

    public static ItemProductSmallRatingArticleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSmallRatingArticleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSmallRatingArticleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558886, null, false, obj);
    }

    public static ItemProductSmallRatingArticleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSmallRatingArticleBinding bind(View view, Object obj) {
        return (ItemProductSmallRatingArticleBinding) bind(obj, view, 2131558886);
    }
}
