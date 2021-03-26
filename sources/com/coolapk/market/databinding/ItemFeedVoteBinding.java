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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.ForegroundTextView;

public abstract class ItemFeedVoteBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final TextView countView;
    public final ForegroundTextView foregroundTextView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView textView;
    public final FrameLayout titleContainer;
    public final TextView titleTagView;
    public final TextView titleView;
    public final FrameLayout voteViewContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedVoteBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView2, ForegroundTextView foregroundTextView2, Space space, TextView textView3, FrameLayout frameLayout, TextView textView4, TextView textView5, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.countView = textView2;
        this.foregroundTextView = foregroundTextView2;
        this.headerSpaceView = space;
        this.textView = textView3;
        this.titleContainer = frameLayout;
        this.titleTagView = textView4;
        this.titleView = textView5;
        this.voteViewContainer = frameLayout2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558742, viewGroup, z, obj);
    }

    public static ItemFeedVoteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558742, null, false, obj);
    }

    public static ItemFeedVoteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteBinding bind(View view, Object obj) {
        return (ItemFeedVoteBinding) bind(obj, view, 2131558742);
    }
}
