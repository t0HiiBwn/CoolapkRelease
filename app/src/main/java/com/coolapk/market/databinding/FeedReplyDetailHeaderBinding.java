package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FeedReplyDetailHeaderBinding extends ViewDataBinding {
    public final TextView actionView;
    public final FrameLayout frameView;
    public final LinearLayout linearView;
    public final Toolbar toolbar;

    protected FeedReplyDetailHeaderBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.actionView = textView;
        this.frameView = frameLayout;
        this.linearView = linearLayout;
        this.toolbar = toolbar2;
    }

    public static FeedReplyDetailHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedReplyDetailHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedReplyDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558561, viewGroup, z, obj);
    }

    public static FeedReplyDetailHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedReplyDetailHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedReplyDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558561, null, false, obj);
    }

    public static FeedReplyDetailHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedReplyDetailHeaderBinding bind(View view, Object obj) {
        return (FeedReplyDetailHeaderBinding) bind(obj, view, 2131558561);
    }
}
