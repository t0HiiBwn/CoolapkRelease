package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ToolbarLayoutBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final ViewStubProxy fabStub;
    public final CoordinatorLayout mainContent;
    public final Toolbar toolbar;
    public final FrameLayout toolbarContentFragment;

    protected ToolbarLayoutBinding(Object obj, View view, int i, AppBarLayout appBarLayout, ViewStubProxy viewStubProxy, CoordinatorLayout coordinatorLayout, Toolbar toolbar2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.fabStub = viewStubProxy;
        this.mainContent = coordinatorLayout;
        this.toolbar = toolbar2;
        this.toolbarContentFragment = frameLayout;
    }

    public static ToolbarLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ToolbarLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ToolbarLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559199, viewGroup, z, obj);
    }

    public static ToolbarLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ToolbarLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ToolbarLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559199, null, false, obj);
    }

    public static ToolbarLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ToolbarLayoutBinding bind(View view, Object obj) {
        return (ToolbarLayoutBinding) bind(obj, view, 2131559199);
    }
}
