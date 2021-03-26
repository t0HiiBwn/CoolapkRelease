package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.AppExtensionBar;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.AlphableAppBarLayout;

public abstract class AppViewV8Binding extends ViewDataBinding {
    public final AlphableAppBarLayout appBar;
    public final AppExtensionBar appExtensionBar;
    public final FrameLayout appViewRecycler;
    public final FrameLayout bottomLayout;
    public final CoordinatorLayout contentContainer;
    public final TextView emptyTextView;
    public final ImageView loadingBgView;
    public final ProgressBar loadingView;
    @Bindable
    protected AppViewViewModel mViewModel;
    public final DrawSystemBarFrameLayout mainContent;
    public final Toolbar toolbar;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected AppViewV8Binding(Object obj, View view, int i, AlphableAppBarLayout alphableAppBarLayout, AppExtensionBar appExtensionBar2, FrameLayout frameLayout, FrameLayout frameLayout2, CoordinatorLayout coordinatorLayout, TextView textView, ImageView imageView, ProgressBar progressBar, DrawSystemBarFrameLayout drawSystemBarFrameLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.appBar = alphableAppBarLayout;
        this.appExtensionBar = appExtensionBar2;
        this.appViewRecycler = frameLayout;
        this.bottomLayout = frameLayout2;
        this.contentContainer = coordinatorLayout;
        this.emptyTextView = textView;
        this.loadingBgView = imageView;
        this.loadingView = progressBar;
        this.mainContent = drawSystemBarFrameLayout;
        this.toolbar = toolbar2;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static AppViewV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppViewV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558470, viewGroup, z, obj);
    }

    public static AppViewV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppViewV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558470, null, false, obj);
    }

    public static AppViewV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewV8Binding bind(View view, Object obj) {
        return (AppViewV8Binding) bind(obj, view, 2131558470);
    }
}
