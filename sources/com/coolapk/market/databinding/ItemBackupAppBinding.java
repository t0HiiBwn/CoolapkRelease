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
import com.coolapk.market.model.LocalApp;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemBackupAppBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView apkSizeView;
    public final LinearLayout appView;
    public final ImageView iconView;
    @Bindable
    protected LocalApp mApp;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView sourceNameView;
    public final TextView titleView;

    public abstract void setApp(LocalApp localApp);

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemBackupAppBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, LinearLayout linearLayout, ImageView imageView, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.apkSizeView = textView2;
        this.appView = linearLayout;
        this.iconView = imageView;
        this.sourceNameView = textView3;
        this.titleView = textView4;
    }

    public LocalApp getApp() {
        return this.mApp;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemBackupAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBackupAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558624, viewGroup, z, obj);
    }

    public static ItemBackupAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBackupAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558624, null, false, obj);
    }

    public static ItemBackupAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupAppBinding bind(View view, Object obj) {
        return (ItemBackupAppBinding) bind(obj, view, 2131558624);
    }
}
