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
import com.coolapk.market.model.ForwardFeed;

public abstract class ItemFeedForwardViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected ForwardFeed mModel;
    public final TextView replyReplyInfoText;
    public final TextView textView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(ForwardFeed forwardFeed);

    protected ItemFeedForwardViewBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.replyReplyInfoText = textView2;
        this.textView = textView3;
        this.titleView = textView4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public ForwardFeed getModel() {
        return this.mModel;
    }

    public static ItemFeedForwardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedForwardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedForwardViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558701, viewGroup, z, obj);
    }

    public static ItemFeedForwardViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedForwardViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedForwardViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558701, null, false, obj);
    }

    public static ItemFeedForwardViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedForwardViewBinding bind(View view, Object obj) {
        return (ItemFeedForwardViewBinding) bind(obj, view, 2131558701);
    }
}
