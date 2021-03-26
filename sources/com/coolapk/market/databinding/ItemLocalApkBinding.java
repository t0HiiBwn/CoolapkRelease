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
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.viewholder.LocalApkViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemLocalApkBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView apkSizeView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected LocalApk mApk;
    @Bindable
    protected LocalApkViewHolder mVh;
    public final ImageView moreView;
    public final LinearLayout optionLayout;
    public final TextView pathView;
    public final ImageView selectedView;
    public final TextView titleView;
    public final TextView versionCodeView;
    public final LinearLayout versionInfoView;
    public final TextView versionNameView;

    public abstract void setApk(LocalApk localApk);

    public abstract void setVh(LocalApkViewHolder localApkViewHolder);

    protected ItemLocalApkBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, TextView textView3, ImageView imageView3, TextView textView4, TextView textView5, LinearLayout linearLayout3, TextView textView6) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.apkSizeView = textView2;
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.moreView = imageView2;
        this.optionLayout = linearLayout2;
        this.pathView = textView3;
        this.selectedView = imageView3;
        this.titleView = textView4;
        this.versionCodeView = textView5;
        this.versionInfoView = linearLayout3;
        this.versionNameView = textView6;
    }

    public LocalApkViewHolder getVh() {
        return this.mVh;
    }

    public LocalApk getApk() {
        return this.mApk;
    }

    public static ItemLocalApkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocalApkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLocalApkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558818, viewGroup, z, obj);
    }

    public static ItemLocalApkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocalApkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLocalApkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558818, null, false, obj);
    }

    public static ItemLocalApkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocalApkBinding bind(View view, Object obj) {
        return (ItemLocalApkBinding) bind(obj, view, 2131558818);
    }
}
