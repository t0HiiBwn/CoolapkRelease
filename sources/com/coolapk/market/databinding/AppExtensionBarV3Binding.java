package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AppExtensionBarV3Binding extends ViewDataBinding {
    public final LinearLayout commentBox;
    public final TextView commentCount;
    public final TextView commentText;
    public final LinearLayout commentView;
    public final LinearLayout extendMenu;

    protected AppExtensionBarV3Binding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.commentBox = linearLayout;
        this.commentCount = textView;
        this.commentText = textView2;
        this.commentView = linearLayout2;
        this.extendMenu = linearLayout3;
    }

    public static AppExtensionBarV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionBarV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppExtensionBarV3Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558458, viewGroup, z, obj);
    }

    public static AppExtensionBarV3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionBarV3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppExtensionBarV3Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558458, null, false, obj);
    }

    public static AppExtensionBarV3Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppExtensionBarV3Binding bind(View view, Object obj) {
        return (AppExtensionBarV3Binding) bind(obj, view, 2131558458);
    }
}
