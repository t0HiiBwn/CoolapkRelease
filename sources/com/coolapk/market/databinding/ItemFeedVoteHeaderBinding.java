package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemFeedVoteHeaderBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout anonymousCheckContainer;
    public final ImageView anonymousCheckView;
    public final TextView anonymousTextView;
    public final Space appBarHolder;
    public final LinearLayout authorView;
    public final TextView descriptionView;
    public final FrameLayout descriptionViewContainer;
    public final View dividerView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView timeView;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;
    public final LinearLayout voteBottomContainer;
    public final TextView voteSubtitleView;
    public final LinearLayout voteTitleContainer;
    public final TextView voteTitleView;
    public final FrameLayout voteViewContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedVoteHeaderBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2, Space space, LinearLayout linearLayout2, TextView textView3, FrameLayout frameLayout, View view2, TextView textView4, TextView textView5, UserAvatarView userAvatarView2, TextView textView6, LinearLayout linearLayout3, TextView textView7, LinearLayout linearLayout4, TextView textView8, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.actionView = textView;
        this.anonymousCheckContainer = linearLayout;
        this.anonymousCheckView = imageView;
        this.anonymousTextView = textView2;
        this.appBarHolder = space;
        this.authorView = linearLayout2;
        this.descriptionView = textView3;
        this.descriptionViewContainer = frameLayout;
        this.dividerView = view2;
        this.timeView = textView4;
        this.titleView = textView5;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView6;
        this.voteBottomContainer = linearLayout3;
        this.voteSubtitleView = textView7;
        this.voteTitleContainer = linearLayout4;
        this.voteTitleView = textView8;
        this.voteViewContainer = frameLayout2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public static ItemFeedVoteHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558747, viewGroup, z, obj);
    }

    public static ItemFeedVoteHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558747, null, false, obj);
    }

    public static ItemFeedVoteHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteHeaderBinding bind(View view, Object obj) {
        return (ItemFeedVoteHeaderBinding) bind(obj, view, 2131558747);
    }
}
