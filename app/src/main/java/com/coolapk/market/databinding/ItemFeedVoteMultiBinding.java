package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedVoteMultiBinding extends ViewDataBinding {
    public final ImageView checkBox;
    public final ImageView checkView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView percentView;
    public final LinearLayout rootView;
    public final Space spaceView;
    public final TextView titleView;
    public final TextView totalVoteNumView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemFeedVoteMultiBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, LinearLayout linearLayout, Space space, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.checkBox = imageView;
        this.checkView = imageView2;
        this.percentView = textView;
        this.rootView = linearLayout;
        this.spaceView = space;
        this.titleView = textView2;
        this.totalVoteNumView = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVoteMultiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteMultiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVoteMultiBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558741, viewGroup, z, obj);
    }

    public static ItemFeedVoteMultiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteMultiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVoteMultiBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558741, null, false, obj);
    }

    public static ItemFeedVoteMultiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVoteMultiBinding bind(View view, Object obj) {
        return (ItemFeedVoteMultiBinding) bind(obj, view, 2131558741);
    }
}
