package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.coolapk.market.widget.SearchAppHeader;

public abstract class MainFragmentBinding extends ViewDataBinding {
    public final SearchAppHeader appBar;
    public final FrameLayout bottomBackgroundPlaceholderView;
    public final AHBottomNavigation bottomNavigation;
    public final CoordinatorLayout coordinator;
    public final FrameLayout fullFragment;
    public final FrameLayout mainContent;
    public final FrameLayout mainFragment;

    protected MainFragmentBinding(Object obj, View view, int i, SearchAppHeader searchAppHeader, FrameLayout frameLayout, AHBottomNavigation aHBottomNavigation, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4) {
        super(obj, view, i);
        this.appBar = searchAppHeader;
        this.bottomBackgroundPlaceholderView = frameLayout;
        this.bottomNavigation = aHBottomNavigation;
        this.coordinator = coordinatorLayout;
        this.fullFragment = frameLayout2;
        this.mainContent = frameLayout3;
        this.mainFragment = frameLayout4;
    }

    public static MainFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MainFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559018, viewGroup, z, obj);
    }

    public static MainFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MainFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559018, null, false, obj);
    }

    public static MainFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainFragmentBinding bind(View view, Object obj) {
        return (MainFragmentBinding) bind(obj, view, 2131559018);
    }
}
