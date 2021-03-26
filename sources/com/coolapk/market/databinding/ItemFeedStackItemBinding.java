package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.stackcard.StackFrameLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemFeedStackItemBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final Space headerSpaceView;
    public final StackFrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final CoolEllipsizeTextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedStackItemBinding(Object obj, View view, int i, LinearLayout linearLayout, Space space, StackFrameLayout stackFrameLayout, CoolEllipsizeTextView coolEllipsizeTextView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.headerSpaceView = space;
        this.itemView = stackFrameLayout;
        this.textView = coolEllipsizeTextView;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedStackItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedStackItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedStackItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558731, viewGroup, z, obj);
    }

    public static ItemFeedStackItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedStackItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedStackItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558731, null, false, obj);
    }

    public static ItemFeedStackItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedStackItemBinding bind(View view, Object obj) {
        return (ItemFeedStackItemBinding) bind(obj, view, 2131558731);
    }
}
