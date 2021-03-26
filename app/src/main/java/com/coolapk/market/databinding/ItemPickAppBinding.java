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

public abstract class ItemPickAppBinding extends ViewDataBinding {
    public final TextView apkSizeView;
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected MobileApp mApp;
    public final TextView titleView;
    public final TableLayout versionInfoView;
    public final TextView versionView;

    public abstract void setApp(MobileApp mobileApp);

    protected ItemPickAppBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2, TableLayout tableLayout, TextView textView3) {
        super(obj, view, i);
        this.apkSizeView = textView;
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.titleView = textView2;
        this.versionInfoView = tableLayout;
        this.versionView = textView3;
    }

    public MobileApp getApp() {
        return this.mApp;
    }

    public static ItemPickAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPickAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPickAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558855, viewGroup, z, obj);
    }

    public static ItemPickAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPickAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPickAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558855, null, false, obj);
    }

    public static ItemPickAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPickAppBinding bind(View view, Object obj) {
        return (ItemPickAppBinding) bind(obj, view, 2131558855);
    }
}
