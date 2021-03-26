package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.AlphableAppBarLayout;

public abstract class AlphaToolbarBinding extends ViewDataBinding {
    public final AlphableAppBarLayout appBar;
    public final FrameLayout contentView;
    public final TextView hintView;
    public final FrameLayout loadingContainer;
    public final ProgressBar loadingView;
    public final DrawSystemBarFrameLayout mainContent;
    public final Toolbar toolbar;

    protected AlphaToolbarBinding(Object obj, View view, int i, AlphableAppBarLayout alphableAppBarLayout, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, ProgressBar progressBar, DrawSystemBarFrameLayout drawSystemBarFrameLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.appBar = alphableAppBarLayout;
        this.contentView = frameLayout;
        this.hintView = textView;
        this.loadingContainer = frameLayout2;
        this.loadingView = progressBar;
        this.mainContent = drawSystemBarFrameLayout;
        this.toolbar = toolbar2;
    }

    public static AlphaToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlphaToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlphaToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558457, viewGroup, z, obj);
    }

    public static AlphaToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlphaToolbarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlphaToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558457, null, false, obj);
    }

    public static AlphaToolbarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlphaToolbarBinding bind(View view, Object obj) {
        return (AlphaToolbarBinding) bind(obj, view, 2131558457);
    }
}
