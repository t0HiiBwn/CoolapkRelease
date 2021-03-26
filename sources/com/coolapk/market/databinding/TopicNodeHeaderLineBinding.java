package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class TopicNodeHeaderLineBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    public final TextView textView;

    protected TopicNodeHeaderLineBinding(Object obj, View view, int i, TextView textView2, ImageView imageView2, LinearLayout linearLayout, TextView textView3) {
        super(obj, view, i);
        this.descriptionView = textView2;
        this.imageView = imageView2;
        this.itemView = linearLayout;
        this.textView = textView3;
    }

    public static TopicNodeHeaderLineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodeHeaderLineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TopicNodeHeaderLineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559211, viewGroup, z, obj);
    }

    public static TopicNodeHeaderLineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodeHeaderLineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TopicNodeHeaderLineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559211, null, false, obj);
    }

    public static TopicNodeHeaderLineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodeHeaderLineBinding bind(View view, Object obj) {
        return (TopicNodeHeaderLineBinding) bind(obj, view, 2131559211);
    }
}
