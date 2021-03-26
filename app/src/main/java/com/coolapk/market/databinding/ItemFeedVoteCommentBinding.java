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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;

public abstract class ItemFeedVoteCommentBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final Space voteSpaceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedVoteCommentBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, Space space, Space space2, Space space3, TextView textView2, Space space4) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.headerSpaceView = space;
        this.nineImageSpaceView = space2;
        this.relativeSpaceView = space3;
        this.textView = textView2;
        this.voteSpaceView = space4;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVoteCommentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558736, viewGroup, z, obj);
    }

    public static ItemFeedVoteCommentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558736, null, false, obj);
    }

    public static ItemFeedVoteCommentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentBinding bind(View view, Object obj) {
        return (ItemFeedVoteCommentBinding) bind(obj, view, 2131558736);
    }
}
