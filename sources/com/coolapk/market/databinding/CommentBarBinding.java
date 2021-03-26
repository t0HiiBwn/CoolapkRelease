package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class CommentBarBinding extends ViewDataBinding {
    public final LinearLayout actionContainer;
    public final LinearLayout commentBox;
    public final TextView commentCount;
    public final ImageView commentIcon;
    public final TextView commentText;
    public final LinearLayout commentView;
    public final ImageView imageView;
    public final LinearLayout rootView;
    public final LinearLayout shareView;

    protected CommentBarBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView2, TextView textView2, LinearLayout linearLayout3, ImageView imageView3, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        super(obj, view, i);
        this.actionContainer = linearLayout;
        this.commentBox = linearLayout2;
        this.commentCount = textView;
        this.commentIcon = imageView2;
        this.commentText = textView2;
        this.commentView = linearLayout3;
        this.imageView = imageView3;
        this.rootView = linearLayout4;
        this.shareView = linearLayout5;
    }

    public static CommentBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CommentBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558485, viewGroup, z, obj);
    }

    public static CommentBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CommentBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558485, null, false, obj);
    }

    public static CommentBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentBarBinding bind(View view, Object obj) {
        return (CommentBarBinding) bind(obj, view, 2131558485);
    }
}
