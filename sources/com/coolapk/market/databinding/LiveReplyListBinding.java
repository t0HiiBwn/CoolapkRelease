package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.SlideUpView;

public abstract class LiveReplyListBinding extends ViewDataBinding {
    public final FrameLayout contentFragment;
    public final LinearLayout mainContent;
    public final SlideUpView slideUpView;
    public final Toolbar toolbar;

    protected LiveReplyListBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, SlideUpView slideUpView2, Toolbar toolbar2) {
        super(obj, view, i);
        this.contentFragment = frameLayout;
        this.mainContent = linearLayout;
        this.slideUpView = slideUpView2;
        this.toolbar = toolbar2;
    }

    public static LiveReplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveReplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LiveReplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559019, viewGroup, z, obj);
    }

    public static LiveReplyListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveReplyListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LiveReplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559019, null, false, obj);
    }

    public static LiveReplyListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveReplyListBinding bind(View view, Object obj) {
        return (LiveReplyListBinding) bind(obj, view, 2131559019);
    }
}
