package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AlbumCommentBarBinding extends ViewDataBinding {
    public final LinearLayout commentBox;
    public final TextView commentCount;
    public final ImageView commentIcon;
    public final TextView commentText;
    public final FrameLayout commentView;
    public final ImageView imageView;
    public final TextView likeCount;
    public final ImageView likeIcon;
    public final FrameLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout rootView;
    public final TextView shareCount;
    public final ImageView shareIcon;
    public final FrameLayout shareView;
    public final TextView starCount;
    public final ImageView starIcon;
    public final FrameLayout starView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected AlbumCommentBarBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, ImageView imageView2, TextView textView2, FrameLayout frameLayout, ImageView imageView3, TextView textView3, ImageView imageView4, FrameLayout frameLayout2, LinearLayout linearLayout2, TextView textView4, ImageView imageView5, FrameLayout frameLayout3, TextView textView5, ImageView imageView6, FrameLayout frameLayout4) {
        super(obj, view, i);
        this.commentBox = linearLayout;
        this.commentCount = textView;
        this.commentIcon = imageView2;
        this.commentText = textView2;
        this.commentView = frameLayout;
        this.imageView = imageView3;
        this.likeCount = textView3;
        this.likeIcon = imageView4;
        this.likeView = frameLayout2;
        this.rootView = linearLayout2;
        this.shareCount = textView4;
        this.shareIcon = imageView5;
        this.shareView = frameLayout3;
        this.starCount = textView5;
        this.starIcon = imageView6;
        this.starView = frameLayout4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static AlbumCommentBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumCommentBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumCommentBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558442, viewGroup, z, obj);
    }

    public static AlbumCommentBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumCommentBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumCommentBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558442, null, false, obj);
    }

    public static AlbumCommentBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumCommentBarBinding bind(View view, Object obj) {
        return (AlbumCommentBarBinding) bind(obj, view, 2131558442);
    }
}
