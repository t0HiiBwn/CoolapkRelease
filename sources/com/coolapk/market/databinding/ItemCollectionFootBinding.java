package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCollectionFootBinding extends ViewDataBinding {
    public final LinearLayout contentView;
    public final ImageView followImageView;
    public final TextView followTextView;
    public final LinearLayout followView;
    public final ImageView likeImageView;
    public final TextView likeTextView;
    public final LinearLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView shareImageView;
    public final TextView shareTextView;
    public final LinearLayout shareView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemCollectionFootBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, ImageView imageView2, TextView textView2, LinearLayout linearLayout3, ImageView imageView3, TextView textView3, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.contentView = linearLayout;
        this.followImageView = imageView;
        this.followTextView = textView;
        this.followView = linearLayout2;
        this.likeImageView = imageView2;
        this.likeTextView = textView2;
        this.likeView = linearLayout3;
        this.shareImageView = imageView3;
        this.shareTextView = textView3;
        this.shareView = linearLayout4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCollectionFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionFootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCollectionFootBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558660, viewGroup, z, obj);
    }

    public static ItemCollectionFootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionFootBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCollectionFootBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558660, null, false, obj);
    }

    public static ItemCollectionFootBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionFootBinding bind(View view, Object obj) {
        return (ItemCollectionFootBinding) bind(obj, view, 2131558660);
    }
}
