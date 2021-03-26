package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemBlockHeaderBinding extends ViewDataBinding {
    public final LinearLayout blockKeyView;
    public final LinearLayout blockNodeView;
    public final LinearLayout blockUserView;
    public final LinearLayout cardView;

    protected ItemBlockHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.blockKeyView = linearLayout;
        this.blockNodeView = linearLayout2;
        this.blockUserView = linearLayout3;
        this.cardView = linearLayout4;
    }

    public static ItemBlockHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBlockHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558625, viewGroup, z, obj);
    }

    public static ItemBlockHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBlockHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558625, null, false, obj);
    }

    public static ItemBlockHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockHeaderBinding bind(View view, Object obj) {
        return (ItemBlockHeaderBinding) bind(obj, view, 2131558625);
    }
}
