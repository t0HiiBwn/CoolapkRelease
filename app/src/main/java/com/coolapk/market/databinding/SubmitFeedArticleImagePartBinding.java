package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class SubmitFeedArticleImagePartBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final EditText descriptionView;
    public final ScalingImageView ivCover;
    public final TextView longPicText;
    public final FrameLayout longPicTextContainer;
    public final LinearLayout lvTop;

    protected SubmitFeedArticleImagePartBinding(Object obj, View view, int i, ImageView imageView, EditText editText, ScalingImageView scalingImageView, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.closeView = imageView;
        this.descriptionView = editText;
        this.ivCover = scalingImageView;
        this.longPicText = textView;
        this.longPicTextContainer = frameLayout;
        this.lvTop = linearLayout;
    }

    public static SubmitFeedArticleImagePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleImagePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedArticleImagePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559151, viewGroup, z, obj);
    }

    public static SubmitFeedArticleImagePartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleImagePartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedArticleImagePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559151, null, false, obj);
    }

    public static SubmitFeedArticleImagePartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleImagePartBinding bind(View view, Object obj) {
        return (SubmitFeedArticleImagePartBinding) bind(obj, view, 2131559151);
    }
}
