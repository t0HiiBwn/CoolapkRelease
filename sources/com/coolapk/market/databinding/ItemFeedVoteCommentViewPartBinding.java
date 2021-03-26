package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedVoteCommentViewPartBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView remainTimeView;
    public final LinearLayout rootView;
    public final TextView subTitleView;
    public final TextView titleView;
    public final TextView toVoteTextView;
    public final LinearLayout toVoteView;
    public final FrameLayout voteContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemFeedVoteCommentViewPartBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.remainTimeView = textView;
        this.rootView = linearLayout;
        this.subTitleView = textView2;
        this.titleView = textView3;
        this.toVoteTextView = textView4;
        this.toVoteView = linearLayout2;
        this.voteContainer = frameLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVoteCommentViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteCommentViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558746, viewGroup, z, obj);
    }

    public static ItemFeedVoteCommentViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteCommentViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558746, null, false, obj);
    }

    public static ItemFeedVoteCommentViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteCommentViewPartBinding bind(View view, Object obj) {
        return (ItemFeedVoteCommentViewPartBinding) bind(obj, view, 2131558746);
    }
}
