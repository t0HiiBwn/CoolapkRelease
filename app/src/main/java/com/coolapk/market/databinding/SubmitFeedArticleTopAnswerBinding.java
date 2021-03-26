package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitFeedArticleTopAnswerBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final TextView etTitle;
    public final LinearLayout lvTop;

    protected SubmitFeedArticleTopAnswerBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.etTitle = textView;
        this.lvTop = linearLayout;
    }

    public static SubmitFeedArticleTopAnswerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTopAnswerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedArticleTopAnswerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559153, viewGroup, z, obj);
    }

    public static SubmitFeedArticleTopAnswerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTopAnswerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedArticleTopAnswerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559153, null, false, obj);
    }

    public static SubmitFeedArticleTopAnswerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTopAnswerBinding bind(View view, Object obj) {
        return (SubmitFeedArticleTopAnswerBinding) bind(obj, view, 2131559153);
    }
}
