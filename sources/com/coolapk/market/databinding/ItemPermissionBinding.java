package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.PermissionItem;

public abstract class ItemPermissionBinding extends ViewDataBinding {
    public final TextView descriptionView;
    @Bindable
    protected PermissionItem mPermission;
    public final TextView nameView;

    public abstract void setPermission(PermissionItem permissionItem);

    protected ItemPermissionBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.nameView = textView2;
    }

    public PermissionItem getPermission() {
        return this.mPermission;
    }

    public static ItemPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPermissionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558855, viewGroup, z, obj);
    }

    public static ItemPermissionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPermissionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPermissionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558855, null, false, obj);
    }

    public static ItemPermissionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPermissionBinding bind(View view, Object obj) {
        return (ItemPermissionBinding) bind(obj, view, 2131558855);
    }
}
