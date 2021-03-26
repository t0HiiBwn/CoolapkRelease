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

public abstract class ItemTabGroupCardItemBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected ServiceApp mServiceApp;
    public final TextView titleView;

    public abstract void setServiceApp(ServiceApp serviceApp);

    protected ItemTabGroupCardItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        super(obj, view, i);
        this.actionButton = textView;
        this.iconView = imageView;
        this.infoView = textView2;
        this.itemView = linearLayout;
        this.titleView = textView3;
    }

    public ServiceApp getServiceApp() {
        return this.mServiceApp;
    }

    public static ItemTabGroupCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabGroupCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTabGroupCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558943, viewGroup, z, obj);
    }

    public static ItemTabGroupCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabGroupCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTabGroupCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558943, null, false, obj);
    }

    public static ItemTabGroupCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabGroupCardItemBinding bind(View view, Object obj) {
        return (ItemTabGroupCardItemBinding) bind(obj, view, 2131558943);
    }
}
