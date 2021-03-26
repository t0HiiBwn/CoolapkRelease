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
import com.coolapk.market.viewholder.UpgradeViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.expandable.ExpandTextView;

public abstract class ItemUpgradeBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView apkSizeView;
    public final TextView extraTextView;
    public final ImageView iconView;
    public final TextView ignoreFlag;
    public final LinearLayout itemView;
    public final LinearLayout layoutOne;
    @Bindable
    protected MobileApp mApp;
    @Bindable
    protected UpgradeViewHolder mViewHolder;
    public final ImageView moreView;
    public final LinearLayout optionLayout;
    public final TextView patchSizeView;
    public final TextView timeView;
    public final TextView titleView;
    public final ExpandTextView upgradeInfoView;
    public final TableLayout versionInfoView;
    public final TextView versionUpgradeView;

    public abstract void setApp(MobileApp mobileApp);

    public abstract void setViewHolder(UpgradeViewHolder upgradeViewHolder);

    protected ItemUpgradeBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, LinearLayout linearLayout3, TextView textView5, TextView textView6, TextView textView7, ExpandTextView expandTextView, TableLayout tableLayout, TextView textView8) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.apkSizeView = textView2;
        this.extraTextView = textView3;
        this.iconView = imageView;
        this.ignoreFlag = textView4;
        this.itemView = linearLayout;
        this.layoutOne = linearLayout2;
        this.moreView = imageView2;
        this.optionLayout = linearLayout3;
        this.patchSizeView = textView5;
        this.timeView = textView6;
        this.titleView = textView7;
        this.upgradeInfoView = expandTextView;
        this.versionInfoView = tableLayout;
        this.versionUpgradeView = textView8;
    }

    public UpgradeViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public MobileApp getApp() {
        return this.mApp;
    }

    public static ItemUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUpgradeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558972, viewGroup, z, obj);
    }

    public static ItemUpgradeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUpgradeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUpgradeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558972, null, false, obj);
    }

    public static ItemUpgradeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUpgradeBinding bind(View view, Object obj) {
        return (ItemUpgradeBinding) bind(obj, view, 2131558972);
    }
}
