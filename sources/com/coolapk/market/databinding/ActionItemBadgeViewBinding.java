package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActionItemBadgeViewBinding extends ViewDataBinding {
    public final TextView menuBadge;
    public final ImageView menuBadgeIcon;

    protected ActionItemBadgeViewBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.menuBadge = textView;
        this.menuBadgeIcon = imageView;
    }

    public static ActionItemBadgeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemBadgeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActionItemBadgeViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558430, viewGroup, z, obj);
    }

    public static ActionItemBadgeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemBadgeViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActionItemBadgeViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558430, null, false, obj);
    }

    public static ActionItemBadgeViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemBadgeViewBinding bind(View view, Object obj) {
        return (ActionItemBadgeViewBinding) bind(obj, view, 2131558430);
    }
}
