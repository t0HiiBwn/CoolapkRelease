package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.feedv8.util.ArticleEditText;

public abstract class SubmitFeedArticleTopPartBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final ImageView closeView;
    public final ArticleEditText etTitle;
    public final ImageView ivCover;
    public final LinearLayout lvTop;
    public final RatingBar ratingBar;
    public final TextView ratingTextView;
    public final LinearLayout relativeView;

    protected SubmitFeedArticleTopPartBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, ImageView imageView, ArticleEditText articleEditText, ImageView imageView2, LinearLayout linearLayout, RatingBar ratingBar2, TextView textView, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.closeView = imageView;
        this.etTitle = articleEditText;
        this.ivCover = imageView2;
        this.lvTop = linearLayout;
        this.ratingBar = ratingBar2;
        this.ratingTextView = textView;
        this.relativeView = linearLayout2;
    }

    public static SubmitFeedArticleTopPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTopPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedArticleTopPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559154, viewGroup, z, obj);
    }

    public static SubmitFeedArticleTopPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTopPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedArticleTopPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559154, null, false, obj);
    }

    public static SubmitFeedArticleTopPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTopPartBinding bind(View view, Object obj) {
        return (SubmitFeedArticleTopPartBinding) bind(obj, view, 2131559154);
    }
}
