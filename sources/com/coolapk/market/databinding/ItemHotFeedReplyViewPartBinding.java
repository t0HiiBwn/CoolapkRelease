package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemHotFeedReplyViewPartBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView newTagView;
    public final CoolEllipsizeTextView titleView;

    protected ItemHotFeedReplyViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, CoolEllipsizeTextView coolEllipsizeTextView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.newTagView = textView;
        this.titleView = coolEllipsizeTextView;
    }

    public static ItemHotFeedReplyViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotFeedReplyViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHotFeedReplyViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558774, viewGroup, z, obj);
    }

    public static ItemHotFeedReplyViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotFeedReplyViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHotFeedReplyViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558774, null, false, obj);
    }

    public static ItemHotFeedReplyViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotFeedReplyViewPartBinding bind(View view, Object obj) {
        return (ItemHotFeedReplyViewPartBinding) bind(obj, view, 2131558774);
    }
}
