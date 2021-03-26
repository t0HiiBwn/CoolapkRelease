package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.widget.ActionButton;
import java.util.List;

public abstract class ItemUpgradeCardBinding extends ViewDataBinding {
    public final ActionButton actionButton;
    public final ImageView deleteView;
    public final CoolapkCardView itemView;
    @Bindable
    protected List<MobileApp> mApps;
    @Bindable
    protected View.OnClickListener mClick;

    public abstract void setApps(List<MobileApp> list);

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemUpgradeCardBinding(Object obj, View view, int i, ActionButton actionButton2, ImageView imageView, CoolapkCardView coolapkCardView) {
        super(obj, view, i);
        this.actionButton = actionButton2;
        this.deleteView = imageView;
        this.itemView = coolapkCardView;
    }

    public List<MobileApp> getApps() {
        return this.mApps;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemUpgradeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUpgradeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUpgradeCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558973, viewGroup, z, obj);
    }

    public static ItemUpgradeCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUpgradeCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUpgradeCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558973, null, false, obj);
    }

    public static ItemUpgradeCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUpgradeCardBinding bind(View view, Object obj) {
        return (ItemUpgradeCardBinding) bind(obj, view, 2131558973);
    }
}
