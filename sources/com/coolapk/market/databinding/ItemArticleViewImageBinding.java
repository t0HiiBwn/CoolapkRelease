package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemArticleViewImageBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final ScalingImageView ivCover;
    public final TextView longPicText;
    public final FrameLayout longPicTextContainer;
    public final LinearLayout lvTop;
    public final ImageLoadProgressBar progressBar;

    protected ItemArticleViewImageBinding(Object obj, View view, int i, TextView textView, ScalingImageView scalingImageView, TextView textView2, FrameLayout frameLayout, LinearLayout linearLayout, ImageLoadProgressBar imageLoadProgressBar) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.ivCover = scalingImageView;
        this.longPicText = textView2;
        this.longPicTextContainer = frameLayout;
        this.lvTop = linearLayout;
        this.progressBar = imageLoadProgressBar;
    }

    public static ItemArticleViewImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleViewImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleViewImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558620, viewGroup, z, obj);
    }

    public static ItemArticleViewImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleViewImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleViewImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558620, null, false, obj);
    }

    public static ItemArticleViewImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleViewImageBinding bind(View view, Object obj) {
        return (ItemArticleViewImageBinding) bind(obj, view, 2131558620);
    }
}
