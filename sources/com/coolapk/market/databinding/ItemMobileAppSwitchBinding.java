package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.appmanager.MobileAppFragment;

public abstract class ItemMobileAppSwitchBinding extends ViewDataBinding {
    public final ProgressBar loading;
    @Bindable
    protected MobileAppFragment.SwitchViewHolder mVh;
    public final SwitchCompat switchView;
    public final TextView textView;

    public abstract void setVh(MobileAppFragment.SwitchViewHolder switchViewHolder);

    protected ItemMobileAppSwitchBinding(Object obj, View view, int i, ProgressBar progressBar, SwitchCompat switchCompat, TextView textView2) {
        super(obj, view, i);
        this.loading = progressBar;
        this.switchView = switchCompat;
        this.textView = textView2;
    }

    public MobileAppFragment.SwitchViewHolder getVh() {
        return this.mVh;
    }

    public static ItemMobileAppSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAppSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMobileAppSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558830, viewGroup, z, obj);
    }

    public static ItemMobileAppSwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAppSwitchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMobileAppSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558830, null, false, obj);
    }

    public static ItemMobileAppSwitchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAppSwitchBinding bind(View view, Object obj) {
        return (ItemMobileAppSwitchBinding) bind(obj, view, 2131558830);
    }
}
