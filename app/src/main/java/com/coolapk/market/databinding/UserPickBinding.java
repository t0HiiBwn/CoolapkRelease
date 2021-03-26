package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;

public abstract class UserPickBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final FabBinding fab;
    public final CoordinatorLayout mainContent;
    public final FrameLayout searchContentFragment;
    public final SearchBackHeaderBinding searchHeader;
    public final FrameLayout searchPopupFragment;
    public final LinearLayout searchPopupLayout;

    protected UserPickBinding(Object obj, View view, int i, AppBarLayout appBarLayout, FabBinding fabBinding, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, SearchBackHeaderBinding searchBackHeaderBinding, FrameLayout frameLayout2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.fab = fabBinding;
        this.mainContent = coordinatorLayout;
        this.searchContentFragment = frameLayout;
        this.searchHeader = searchBackHeaderBinding;
        this.searchPopupFragment = frameLayout2;
        this.searchPopupLayout = linearLayout;
    }

    public static UserPickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserPickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserPickBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559283, viewGroup, z, obj);
    }

    public static UserPickBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserPickBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserPickBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559283, null, false, obj);
    }

    public static UserPickBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserPickBinding bind(View view, Object obj) {
        return (UserPickBinding) bind(obj, view, 2131559283);
    }
}
