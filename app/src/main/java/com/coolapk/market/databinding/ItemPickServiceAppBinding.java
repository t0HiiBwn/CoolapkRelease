package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ServiceApp;

public abstract class ItemPickServiceAppBinding extends ViewDataBinding {
    public final TextView apkInfoView;
    public final CheckBox appCheckView;
    public final LinearLayout headerView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected ServiceApp mApp;
    public final TextView marketInfoView;
    public final TextView titleView;

    public abstract void setApp(ServiceApp serviceApp);

    protected ItemPickServiceAppBinding(Object obj, View view, int i, TextView textView, CheckBox checkBox, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.apkInfoView = textView;
        this.appCheckView = checkBox;
        this.headerView = linearLayout;
        this.iconView = imageView;
        this.itemView = linearLayout2;
        this.marketInfoView = textView2;
        this.titleView = textView3;
    }

    public ServiceApp getApp() {
        return this.mApp;
    }

    public static ItemPickServiceAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPickServiceAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPickServiceAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558856, viewGroup, z, obj);
    }

    public static ItemPickServiceAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPickServiceAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPickServiceAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558856, null, false, obj);
    }

    public static ItemPickServiceAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPickServiceAppBinding bind(View view, Object obj) {
        return (ItemPickServiceAppBinding) bind(obj, view, 2131558856);
    }
}
