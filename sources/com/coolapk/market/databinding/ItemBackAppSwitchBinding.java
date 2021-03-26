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
import com.coolapk.market.view.backupList.BackupMobileAppFragment;

public abstract class ItemBackAppSwitchBinding extends ViewDataBinding {
    public final ProgressBar loading;
    @Bindable
    protected BackupMobileAppFragment.SwitchViewHolder mVh;
    public final SwitchCompat switchView;
    public final TextView textView;

    public abstract void setVh(BackupMobileAppFragment.SwitchViewHolder switchViewHolder);

    protected ItemBackAppSwitchBinding(Object obj, View view, int i, ProgressBar progressBar, SwitchCompat switchCompat, TextView textView2) {
        super(obj, view, i);
        this.loading = progressBar;
        this.switchView = switchCompat;
        this.textView = textView2;
    }

    public BackupMobileAppFragment.SwitchViewHolder getVh() {
        return this.mVh;
    }

    public static ItemBackAppSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackAppSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBackAppSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558622, viewGroup, z, obj);
    }

    public static ItemBackAppSwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackAppSwitchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBackAppSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558622, null, false, obj);
    }

    public static ItemBackAppSwitchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackAppSwitchBinding bind(View view, Object obj) {
        return (ItemBackAppSwitchBinding) bind(obj, view, 2131558622);
    }
}
