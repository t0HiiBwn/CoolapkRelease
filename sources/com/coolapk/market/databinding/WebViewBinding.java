package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.CoolWebView;
import com.coolapk.market.widget.ScrollChildSwipeRefreshLayout;

public abstract class WebViewBinding extends ViewDataBinding {
    public final ProgressBar progressBar;
    public final ScrollChildSwipeRefreshLayout swipeRefreshView;
    public final FrameLayout webRoot;
    public final CoolWebView webView;

    protected WebViewBinding(Object obj, View view, int i, ProgressBar progressBar2, ScrollChildSwipeRefreshLayout scrollChildSwipeRefreshLayout, FrameLayout frameLayout, CoolWebView coolWebView) {
        super(obj, view, i);
        this.progressBar = progressBar2;
        this.swipeRefreshView = scrollChildSwipeRefreshLayout;
        this.webRoot = frameLayout;
        this.webView = coolWebView;
    }

    public static WebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (WebViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559302, viewGroup, z, obj);
    }

    public static WebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WebViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (WebViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559302, null, false, obj);
    }

    public static WebViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WebViewBinding bind(View view, Object obj) {
        return (WebViewBinding) bind(obj, view, 2131559302);
    }
}
