package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.SlideUpView;

public abstract class PicReplyListBinding extends ViewDataBinding {
    public final SlideUpView bottomSheet;
    public final FrameLayout contentContainer;
    public final DrawSystemBarFrameLayout mainContent;

    protected PicReplyListBinding(Object obj, View view, int i, SlideUpView slideUpView, FrameLayout frameLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout) {
        super(obj, view, i);
        this.bottomSheet = slideUpView;
        this.contentContainer = frameLayout;
        this.mainContent = drawSystemBarFrameLayout;
    }

    public static PicReplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PicReplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PicReplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559081, viewGroup, z, obj);
    }

    public static PicReplyListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PicReplyListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PicReplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559081, null, false, obj);
    }

    public static PicReplyListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PicReplyListBinding bind(View view, Object obj) {
        return (PicReplyListBinding) bind(obj, view, 2131559081);
    }
}
