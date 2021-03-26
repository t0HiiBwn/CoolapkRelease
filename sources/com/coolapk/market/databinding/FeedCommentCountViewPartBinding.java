package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.SimpleIndicatorView;

public abstract class FeedCommentCountViewPartBinding extends ViewDataBinding {
    public final LinearLayout actionContainer;
    public final FrameLayout cardView;
    public final ImageView closeView;
    public final View dividerView;
    public final ImageView filterImageView;
    public final TextView filterTextView;
    public final LinearLayout filterView;
    public final FrameLayout fixTopView;
    public final TextView forwardView;
    public final SimpleIndicatorView indicatorView;
    public final TextView likeView;
    public final Space spaceView;

    protected FeedCommentCountViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, View view2, ImageView imageView2, TextView textView, LinearLayout linearLayout2, FrameLayout frameLayout2, TextView textView2, SimpleIndicatorView simpleIndicatorView, TextView textView3, Space space) {
        super(obj, view, i);
        this.actionContainer = linearLayout;
        this.cardView = frameLayout;
        this.closeView = imageView;
        this.dividerView = view2;
        this.filterImageView = imageView2;
        this.filterTextView = textView;
        this.filterView = linearLayout2;
        this.fixTopView = frameLayout2;
        this.forwardView = textView2;
        this.indicatorView = simpleIndicatorView;
        this.likeView = textView3;
        this.spaceView = space;
    }

    public static FeedCommentCountViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedCommentCountViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedCommentCountViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558559, viewGroup, z, obj);
    }

    public static FeedCommentCountViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedCommentCountViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedCommentCountViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558559, null, false, obj);
    }

    public static FeedCommentCountViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedCommentCountViewPartBinding bind(View view, Object obj) {
        return (FeedCommentCountViewPartBinding) bind(obj, view, 2131558559);
    }
}
