package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FeedAnswerViewPartBinding extends ViewDataBinding {
    public final ImageView addAnswerImage;
    public final ProgressBar addAnswerProgress;
    public final TextView addAnswerText;
    public final LinearLayout addAnswerView;
    public final LinearLayout commentBox;
    public final TextView commentCount;
    public final ImageView commentIcon;
    public final TextView commentText;
    public final LinearLayout commentView;
    public final ImageView imageView;
    public final TextView likeCount;
    public final ImageView likeIcon;
    public final LinearLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedAnswerViewPartBinding(Object obj, View view, int i, ImageView imageView2, ProgressBar progressBar, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, ImageView imageView3, TextView textView3, LinearLayout linearLayout3, ImageView imageView4, TextView textView4, ImageView imageView5, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        super(obj, view, i);
        this.addAnswerImage = imageView2;
        this.addAnswerProgress = progressBar;
        this.addAnswerText = textView;
        this.addAnswerView = linearLayout;
        this.commentBox = linearLayout2;
        this.commentCount = textView2;
        this.commentIcon = imageView3;
        this.commentText = textView3;
        this.commentView = linearLayout3;
        this.imageView = imageView4;
        this.likeCount = textView4;
        this.likeIcon = imageView5;
        this.likeView = linearLayout4;
        this.rootView = linearLayout5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedAnswerViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedAnswerViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedAnswerViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558553, viewGroup, z, obj);
    }

    public static FeedAnswerViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedAnswerViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedAnswerViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558553, null, false, obj);
    }

    public static FeedAnswerViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedAnswerViewPartBinding bind(View view, Object obj) {
        return (FeedAnswerViewPartBinding) bind(obj, view, 2131558553);
    }
}
