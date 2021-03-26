package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ServiceApp;

public abstract class ItemTopGroupCardItemBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final View flagBgView;
    public final TextView flagTextView;
    public final FrameLayout flagView;
    public final ImageView iconView;
    public final TextView infoView;
    public final FrameLayout itemView;
    @Bindable
    protected ServiceApp mServiceApp;
    public final TextView titleView;

    public abstract void setServiceApp(ServiceApp serviceApp);

    protected ItemTopGroupCardItemBinding(Object obj, View view, int i, TextView textView, View view2, TextView textView2, FrameLayout frameLayout, ImageView imageView, TextView textView3, FrameLayout frameLayout2, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.flagBgView = view2;
        this.flagTextView = textView2;
        this.flagView = frameLayout;
        this.iconView = imageView;
        this.infoView = textView3;
        this.itemView = frameLayout2;
        this.titleView = textView4;
    }

    public ServiceApp getServiceApp() {
        return this.mServiceApp;
    }

    public static ItemTopGroupCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopGroupCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTopGroupCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558967, viewGroup, z, obj);
    }

    public static ItemTopGroupCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopGroupCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTopGroupCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558967, null, false, obj);
    }

    public static ItemTopGroupCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopGroupCardItemBinding bind(View view, Object obj) {
        return (ItemTopGroupCardItemBinding) bind(obj, view, 2131558967);
    }
}
