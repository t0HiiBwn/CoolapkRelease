package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedReplyTitleBinding extends ViewDataBinding {
    public final FrameLayout cardView;

    protected ItemFeedReplyTitleBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.cardView = frameLayout;
    }

    public static ItemFeedReplyTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedReplyTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558728, viewGroup, z, obj);
    }

    public static ItemFeedReplyTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedReplyTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558728, null, false, obj);
    }

    public static ItemFeedReplyTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyTitleBinding bind(View view, Object obj) {
        return (ItemFeedReplyTitleBinding) bind(obj, view, 2131558728);
    }
}
