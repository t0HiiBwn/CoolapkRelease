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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.RecentHistory;

public abstract class ItemRecentHistoryBinding extends ViewDataBinding {
    public final CoolapkCardView cardView;
    public final TextView descriptionView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected RecentHistory mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView tagView;
    public final TextView titleView;

    public abstract void setModel(RecentHistory recentHistory);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemRecentHistoryBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cardView = coolapkCardView;
        this.descriptionView = textView;
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.tagView = textView2;
        this.titleView = textView3;
    }

    public RecentHistory getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemRecentHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRecentHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558898, viewGroup, z, obj);
    }

    public static ItemRecentHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRecentHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558898, null, false, obj);
    }

    public static ItemRecentHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentHistoryBinding bind(View view, Object obj) {
        return (ItemRecentHistoryBinding) bind(obj, view, 2131558898);
    }
}
