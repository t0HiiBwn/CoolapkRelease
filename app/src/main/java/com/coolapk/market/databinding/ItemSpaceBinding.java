package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSpaceBinding extends ViewDataBinding {
    public final Space spaceView;

    protected ItemSpaceBinding(Object obj, View view, int i, Space space) {
        super(obj, view, i);
        this.spaceView = space;
    }

    public static ItemSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558937, viewGroup, z, obj);
    }

    public static ItemSpaceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSpaceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558937, null, false, obj);
    }

    public static ItemSpaceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSpaceBinding bind(View view, Object obj) {
        return (ItemSpaceBinding) bind(obj, view, 2131558937);
    }
}
