package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.LinearAdapterLayout;

public abstract class ItemDiscoveryImageViewV8Binding extends ViewDataBinding {
    public final LinearAdapterLayout linearAdapterView;
    @Bindable
    protected AppViewViewModel mViewModel;
    public final HorizontalScrollView scrollView;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemDiscoveryImageViewV8Binding(Object obj, View view, int i, LinearAdapterLayout linearAdapterLayout, HorizontalScrollView horizontalScrollView) {
        super(obj, view, i);
        this.linearAdapterView = linearAdapterLayout;
        this.scrollView = horizontalScrollView;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemDiscoveryImageViewV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDiscoveryImageViewV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDiscoveryImageViewV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558670, viewGroup, z, obj);
    }

    public static ItemDiscoveryImageViewV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDiscoveryImageViewV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDiscoveryImageViewV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558670, null, false, obj);
    }

    public static ItemDiscoveryImageViewV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDiscoveryImageViewV8Binding bind(View view, Object obj) {
        return (ItemDiscoveryImageViewV8Binding) bind(obj, view, 2131558670);
    }
}
