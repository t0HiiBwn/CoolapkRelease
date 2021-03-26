package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActionItemAppManagerViewBinding extends ViewDataBinding {
    public final TextView menuBadge;
    public final ImageView menuBadgeIcon;

    protected ActionItemAppManagerViewBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.menuBadge = textView;
        this.menuBadgeIcon = imageView;
    }

    public static ActionItemAppManagerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemAppManagerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActionItemAppManagerViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558429, viewGroup, z, obj);
    }

    public static ActionItemAppManagerViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemAppManagerViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActionItemAppManagerViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558429, null, false, obj);
    }

    public static ActionItemAppManagerViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionItemAppManagerViewBinding bind(View view, Object obj) {
        return (ActionItemAppManagerViewBinding) bind(obj, view, 2131558429);
    }
}
