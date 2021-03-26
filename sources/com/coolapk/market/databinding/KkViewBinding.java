package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.DyhModel;
import com.google.android.material.appbar.AppBarLayout;

public abstract class KkViewBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final FrameLayout dyhArticleRecycler;
    @Bindable
    protected DyhModel mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final CoordinatorLayout mainContent;
    public final Toolbar toolbar;

    public abstract void setModel(DyhModel dyhModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected KkViewBinding(Object obj, View view, int i, AppBarLayout appBarLayout, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout, Toolbar toolbar2) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.dyhArticleRecycler = frameLayout;
        this.mainContent = coordinatorLayout;
        this.toolbar = toolbar2;
    }

    public DyhModel getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static KkViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static KkViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (KkViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559002, viewGroup, z, obj);
    }

    public static KkViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static KkViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (KkViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559002, null, false, obj);
    }

    public static KkViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static KkViewBinding bind(View view, Object obj) {
        return (KkViewBinding) bind(obj, view, 2131559002);
    }
}
