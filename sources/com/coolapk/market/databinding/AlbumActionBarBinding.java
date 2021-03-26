package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AlbumActionBarBinding extends ViewDataBinding {
    public final LinearLayout commentLayout;
    public final TextView commentText;
    public final ImageView commentView;
    public final LinearLayout downloadLayout;
    public final TextView downloadText;
    public final ImageView downloadView;
    public final LinearLayout likeLayout;
    public final TextView likeText;
    public final ImageView likeView;
    public final LinearLayout starLayout;
    public final TextView starText;
    public final ImageView starView;

    protected AlbumActionBarBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, ImageView imageView, LinearLayout linearLayout2, TextView textView2, ImageView imageView2, LinearLayout linearLayout3, TextView textView3, ImageView imageView3, LinearLayout linearLayout4, TextView textView4, ImageView imageView4) {
        super(obj, view, i);
        this.commentLayout = linearLayout;
        this.commentText = textView;
        this.commentView = imageView;
        this.downloadLayout = linearLayout2;
        this.downloadText = textView2;
        this.downloadView = imageView2;
        this.likeLayout = linearLayout3;
        this.likeText = textView3;
        this.likeView = imageView3;
        this.starLayout = linearLayout4;
        this.starText = textView4;
        this.starView = imageView4;
    }

    public static AlbumActionBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumActionBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumActionBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558438, viewGroup, z, obj);
    }

    public static AlbumActionBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumActionBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumActionBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558438, null, false, obj);
    }

    public static AlbumActionBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumActionBarBinding bind(View view, Object obj) {
        return (AlbumActionBarBinding) bind(obj, view, 2131558438);
    }
}
