package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.AppForum;

public abstract class ItemMarketAppsBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected AppForum mModel;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(AppForum appForum);

    protected ItemMarketAppsBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.titleView = textView;
    }

    public AppForum getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemMarketAppsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMarketAppsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMarketAppsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558822, viewGroup, z, obj);
    }

    public static ItemMarketAppsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMarketAppsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMarketAppsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558822, null, false, obj);
    }

    public static ItemMarketAppsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMarketAppsBinding bind(View view, Object obj) {
        return (ItemMarketAppsBinding) bind(obj, view, 2131558822);
    }
}
