package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SecondHandCommentBarBinding extends ViewDataBinding {
    public final TextView commentCount;
    public final ImageView commentIcon;
    public final FrameLayout commentView;
    public final TextView goToSecongHand;
    public final TextView likeCount;
    public final ImageView likeIcon;
    public final FrameLayout likeView;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout rootView;
    public final FrameLayout secondHandAction;
    public final TextView shareCount;
    public final ImageView shareIcon;
    public final FrameLayout shareView;
    public final TextView starCount;
    public final ImageView starIcon;
    public final FrameLayout starView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SecondHandCommentBarBinding(Object obj, View view, int i, TextView textView, ImageView imageView, FrameLayout frameLayout, TextView textView2, TextView textView3, ImageView imageView2, FrameLayout frameLayout2, ProgressBar progressBar, LinearLayout linearLayout, FrameLayout frameLayout3, TextView textView4, ImageView imageView3, FrameLayout frameLayout4, TextView textView5, ImageView imageView4, FrameLayout frameLayout5) {
        super(obj, view, i);
        this.commentCount = textView;
        this.commentIcon = imageView;
        this.commentView = frameLayout;
        this.goToSecongHand = textView2;
        this.likeCount = textView3;
        this.likeIcon = imageView2;
        this.likeView = frameLayout2;
        this.loadingView = progressBar;
        this.rootView = linearLayout;
        this.secondHandAction = frameLayout3;
        this.shareCount = textView4;
        this.shareIcon = imageView3;
        this.shareView = frameLayout4;
        this.starCount = textView5;
        this.starIcon = imageView4;
        this.starView = frameLayout5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SecondHandCommentBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandCommentBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SecondHandCommentBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559132, viewGroup, z, obj);
    }

    public static SecondHandCommentBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandCommentBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SecondHandCommentBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559132, null, false, obj);
    }

    public static SecondHandCommentBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandCommentBarBinding bind(View view, Object obj) {
        return (SecondHandCommentBarBinding) bind(obj, view, 2131559132);
    }
}
