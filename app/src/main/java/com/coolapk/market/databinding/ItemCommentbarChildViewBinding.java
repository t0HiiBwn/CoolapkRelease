package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCommentbarChildViewBinding extends ViewDataBinding {
    public final RelativeLayout commentBarChild;
    public final ImageView iconView;
    public final TextView textView;

    protected ItemCommentbarChildViewBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.commentBarChild = relativeLayout;
        this.iconView = imageView;
        this.textView = textView2;
    }

    public static ItemCommentbarChildViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCommentbarChildViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCommentbarChildViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558659, viewGroup, z, obj);
    }

    public static ItemCommentbarChildViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCommentbarChildViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCommentbarChildViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558659, null, false, obj);
    }

    public static ItemCommentbarChildViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCommentbarChildViewBinding bind(View view, Object obj) {
        return (ItemCommentbarChildViewBinding) bind(obj, view, 2131558659);
    }
}
