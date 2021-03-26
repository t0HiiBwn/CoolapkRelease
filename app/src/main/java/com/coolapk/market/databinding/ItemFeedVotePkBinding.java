package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedVotePkBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView pkLeftCheckView;
    public final TextView pkLeftTextView;
    public final LinearLayout pkLeftView;
    public final ImageView pkRightCheckView;
    public final TextView pkRightTextView;
    public final LinearLayout pkRightView;
    public final TextView pkVsView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemFeedVotePkBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView2, TextView textView2, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, i);
        this.pkLeftCheckView = imageView;
        this.pkLeftTextView = textView;
        this.pkLeftView = linearLayout;
        this.pkRightCheckView = imageView2;
        this.pkRightTextView = textView2;
        this.pkRightView = linearLayout2;
        this.pkVsView = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVotePkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVotePkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVotePkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558742, viewGroup, z, obj);
    }

    public static ItemFeedVotePkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVotePkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVotePkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558742, null, false, obj);
    }

    public static ItemFeedVotePkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVotePkBinding bind(View view, Object obj) {
        return (ItemFeedVotePkBinding) bind(obj, view, 2131558742);
    }
}
