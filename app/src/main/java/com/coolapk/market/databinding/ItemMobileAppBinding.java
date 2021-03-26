package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.viewholder.MobileAppViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemMobileAppBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView apkSizeView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected MobileApp mApp;
    @Bindable
    protected MobileAppViewHolder mViewHolder;
    public final ImageView moreView;
    public final LinearLayout optionLayout;
    public final TextView titleView;
    public final TableLayout versionInfoView;
    public final TextView versionView;

    public abstract void setApp(MobileApp mobileApp);

    public abstract void setViewHolder(MobileAppViewHolder mobileAppViewHolder);

    protected ItemMobileAppBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, TextView textView3, TableLayout tableLayout, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.apkSizeView = textView2;
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.moreView = imageView2;
        this.optionLayout = linearLayout2;
        this.titleView = textView3;
        this.versionInfoView = tableLayout;
        this.versionView = textView4;
    }

    public MobileAppViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public MobileApp getApp() {
        return this.mApp;
    }

    public static ItemMobileAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMobileAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558829, viewGroup, z, obj);
    }

    public static ItemMobileAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMobileAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558829, null, false, obj);
    }

    public static ItemMobileAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAppBinding bind(View view, Object obj) {
        return (ItemMobileAppBinding) bind(obj, view, 2131558829);
    }
}
