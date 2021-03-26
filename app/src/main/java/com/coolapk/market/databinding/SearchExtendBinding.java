package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class SearchExtendBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final CoordinatorLayout coordinator;
    public final DrawSystemBarFrameLayout mainContent;
    public final FrameLayout searchContentFragment;
    public final SearchBackHeaderBinding searchHeader;
    public final FrameLayout searchPopupFragment;
    public final LinearLayout searchPopupLayout;

    protected SearchExtendBinding(Object obj, View view, int i, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, FrameLayout frameLayout, SearchBackHeaderBinding searchBackHeaderBinding, FrameLayout frameLayout2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.coordinator = coordinatorLayout;
        this.mainContent = drawSystemBarFrameLayout;
        this.searchContentFragment = frameLayout;
        this.searchHeader = searchBackHeaderBinding;
        this.searchPopupFragment = frameLayout2;
        this.searchPopupLayout = linearLayout;
    }

    public static SearchExtendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchExtendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchExtendBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559124, viewGroup, z, obj);
    }

    public static SearchExtendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchExtendBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchExtendBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559124, null, false, obj);
    }

    public static SearchExtendBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchExtendBinding bind(View view, Object obj) {
        return (SearchExtendBinding) bind(obj, view, 2131559124);
    }
}
