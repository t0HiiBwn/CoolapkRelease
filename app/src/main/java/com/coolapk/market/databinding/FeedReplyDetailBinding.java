package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.SlideUpView;

public abstract class FeedReplyDetailBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout mainContent;
    public final SlideUpView slideUpView;
    public final FrameLayout toolbarContentFragment;

    protected FeedReplyDetailBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout, SlideUpView slideUpView2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mainContent = drawSystemBarFrameLayout;
        this.slideUpView = slideUpView2;
        this.toolbarContentFragment = frameLayout;
    }

    public static FeedReplyDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedReplyDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedReplyDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558560, viewGroup, z, obj);
    }

    public static FeedReplyDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedReplyDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedReplyDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558560, null, false, obj);
    }

    public static FeedReplyDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedReplyDetailBinding bind(View view, Object obj) {
        return (FeedReplyDetailBinding) bind(obj, view, 2131558560);
    }
}
