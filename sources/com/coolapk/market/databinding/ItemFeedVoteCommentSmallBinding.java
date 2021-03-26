package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemFeedVoteCommentSmallBinding extends ViewDataBinding {
    public final FrameLayout cardView;
    public final ImageView commentIcon;
    public final TextView commentNum;
    public final LinearLayout commentView;
    public final ImageView likeIcon;
    public final TextView likeNum;
    public final LinearLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final CoolEllipsizeTextView textView;
    public final UserAvatarView userAvatarView;
    public final ImageView waterMarkView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedVoteCommentSmallBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, TextView textView2, LinearLayout linearLayout, ImageView imageView2, TextView textView3, LinearLayout linearLayout2, CoolEllipsizeTextView coolEllipsizeTextView, UserAvatarView userAvatarView2, ImageView imageView3) {
        super(obj, view, i);
        this.cardView = frameLayout;
        this.commentIcon = imageView;
        this.commentNum = textView2;
        this.commentView = linearLayout;
        this.likeIcon = imageView2;
        this.likeNum = textView3;
        this.likeView = linearLayout2;
        this.textView = coolEllipsizeTextView;
        this.userAvatarView = userAvatarView2;
        this.waterMarkView = imageView3;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVoteCommentSmallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentSmallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteCommentSmallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558745, viewGroup, z, obj);
    }

    public static ItemFeedVoteCommentSmallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentSmallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteCommentSmallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558745, null, false, obj);
    }

    public static ItemFeedVoteCommentSmallBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentSmallBinding bind(View view, Object obj) {
        return (ItemFeedVoteCommentSmallBinding) bind(obj, view, 2131558745);
    }
}
