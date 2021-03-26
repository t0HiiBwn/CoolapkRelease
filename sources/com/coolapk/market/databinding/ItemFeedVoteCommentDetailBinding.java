package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedVoteCommentDetailBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final FrameLayout textViewContainer;
    public final Space voteSpaceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedVoteCommentDetailBinding(Object obj, View view, int i, LinearLayout linearLayout, Space space, Space space2, Space space3, TextView textView2, FrameLayout frameLayout, Space space4) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.headerSpaceView = space;
        this.nineImageSpaceView = space2;
        this.relativeSpaceView = space3;
        this.textView = textView2;
        this.textViewContainer = frameLayout;
        this.voteSpaceView = space4;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVoteCommentDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteCommentDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558737, viewGroup, z, obj);
    }

    public static ItemFeedVoteCommentDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteCommentDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558737, null, false, obj);
    }

    public static ItemFeedVoteCommentDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentDetailBinding bind(View view, Object obj) {
        return (ItemFeedVoteCommentDetailBinding) bind(obj, view, 2131558737);
    }
}
