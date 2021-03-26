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
import com.coolapk.market.viewholder.DownloadViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemDownloadBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView downloadSize;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected DownloadViewHolder mVh;
    public final ImageView moreView;
    public final LinearLayout optionLayout;
    public final TextView speedView;
    public final TextView titleView;
    public final TextView versionCodeView;
    public final LinearLayout versionInfoView;
    public final TextView versionNameView;

    public abstract void setVh(DownloadViewHolder downloadViewHolder);

    protected ItemDownloadBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout3, TextView textView6) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.downloadSize = textView2;
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.moreView = imageView2;
        this.optionLayout = linearLayout2;
        this.speedView = textView3;
        this.titleView = textView4;
        this.versionCodeView = textView5;
        this.versionInfoView = linearLayout3;
        this.versionNameView = textView6;
    }

    public DownloadViewHolder getVh() {
        return this.mVh;
    }

    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558681, viewGroup, z, obj);
    }

    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558681, null, false, obj);
    }

    public static ItemDownloadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDownloadBinding bind(View view, Object obj) {
        return (ItemDownloadBinding) bind(obj, view, 2131558681);
    }
}
