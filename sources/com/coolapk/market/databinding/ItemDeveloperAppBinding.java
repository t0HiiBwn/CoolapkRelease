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
import com.coolapk.market.model.ServiceApp;

public abstract class ItemDeveloperAppBinding extends ViewDataBinding {
    public final TextView apkInfoView;
    public final TextView extraTextView;
    public final LinearLayout headerView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected ServiceApp mApp;
    public final TextView marketInfoView;
    public final TextView newTagView;
    public final TextView titleView;

    public abstract void setApp(ServiceApp serviceApp);

    protected ItemDeveloperAppBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.apkInfoView = textView;
        this.extraTextView = textView2;
        this.headerView = linearLayout;
        this.iconView = imageView;
        this.itemView = linearLayout2;
        this.marketInfoView = textView3;
        this.newTagView = textView4;
        this.titleView = textView5;
    }

    public ServiceApp getApp() {
        return this.mApp;
    }

    public static ItemDeveloperAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeveloperAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDeveloperAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558673, viewGroup, z, obj);
    }

    public static ItemDeveloperAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeveloperAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDeveloperAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558673, null, false, obj);
    }

    public static ItemDeveloperAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeveloperAppBinding bind(View view, Object obj) {
        return (ItemDeveloperAppBinding) bind(obj, view, 2131558673);
    }
}
