package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.view.TabLayout;

public abstract class ItemTabViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout itemView;
    public final FrameLayout tabContainer;
    public final TabLayout tabs;

    protected ItemTabViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, LinearLayout linearLayout, FrameLayout frameLayout, TabLayout tabLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.itemView = linearLayout;
        this.tabContainer = frameLayout;
        this.tabs = tabLayout;
    }

    public static ItemTabViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTabViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558945, viewGroup, z, obj);
    }

    public static ItemTabViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTabViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558945, null, false, obj);
    }

    public static ItemTabViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabViewBinding bind(View view, Object obj) {
        return (ItemTabViewBinding) bind(obj, view, 2131558945);
    }
}
