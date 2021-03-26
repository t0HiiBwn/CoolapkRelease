package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.feedv8.util.ArticleEditText;
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class SubmitProductArticleTopPartBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final CheckBox buyStateView;
    public final ImageView closeView;
    public final ArticleEditText etTitle;
    public final ImageView ivCover;
    public final LinearLayout lvTop;
    public final BadBadRatingBar ratingBar;
    public final LinearLayout relativeView;
    public final TextView scoreTextView;

    protected SubmitProductArticleTopPartBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, CheckBox checkBox, ImageView imageView, ArticleEditText articleEditText, ImageView imageView2, LinearLayout linearLayout, BadBadRatingBar badBadRatingBar, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.buyStateView = checkBox;
        this.closeView = imageView;
        this.etTitle = articleEditText;
        this.ivCover = imageView2;
        this.lvTop = linearLayout;
        this.ratingBar = badBadRatingBar;
        this.relativeView = linearLayout2;
        this.scoreTextView = textView;
    }

    public static SubmitProductArticleTopPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductArticleTopPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitProductArticleTopPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559173, viewGroup, z, obj);
    }

    public static SubmitProductArticleTopPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductArticleTopPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitProductArticleTopPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559173, null, false, obj);
    }

    public static SubmitProductArticleTopPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductArticleTopPartBinding bind(View view, Object obj) {
        return (SubmitProductArticleTopPartBinding) bind(obj, view, 2131559173);
    }
}
