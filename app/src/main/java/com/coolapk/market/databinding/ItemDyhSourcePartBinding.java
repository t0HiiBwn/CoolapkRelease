package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public abstract class ItemDyhSourcePartBinding extends ViewDataBinding {
    public final FrameLayout contentContainer;
    public final FrameLayout headerContainer;
    @Bindable
    protected DyhViewModel mModel;
    public final LinearLayout sourceContainer;
    public final Space spaceView;

    public abstract void setModel(DyhViewModel dyhViewModel);

    protected ItemDyhSourcePartBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, Space space) {
        super(obj, view, i);
        this.contentContainer = frameLayout;
        this.headerContainer = frameLayout2;
        this.sourceContainer = linearLayout;
        this.spaceView = space;
    }

    public DyhViewModel getModel() {
        return this.mModel;
    }

    public static ItemDyhSourcePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSourcePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhSourcePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558683, viewGroup, z, obj);
    }

    public static ItemDyhSourcePartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSourcePartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhSourcePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558683, null, false, obj);
    }

    public static ItemDyhSourcePartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSourcePartBinding bind(View view, Object obj) {
        return (ItemDyhSourcePartBinding) bind(obj, view, 2131558683);
    }
}
