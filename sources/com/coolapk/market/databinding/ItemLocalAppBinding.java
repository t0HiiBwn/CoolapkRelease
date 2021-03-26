package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.album.AlbumPickAPKViewModel;
import com.coolapk.market.view.backupList.AppViewHolder;

public abstract class ItemLocalAppBinding extends ViewDataBinding {
    public final TextView apkSizeView;
    public final TextView apkSystemView;
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final ImageView iconView;
    @Bindable
    protected MobileApp mApp;
    @Bindable
    protected AppViewHolder mViewHolder;
    @Bindable
    protected AlbumPickAPKViewModel mViewModel;
    public final CheckBox mobileAppCheckView;
    public final TextView titleView;
    public final TableLayout versionInfoView;
    public final TextView versionView;

    public abstract void setApp(MobileApp mobileApp);

    public abstract void setViewHolder(AppViewHolder appViewHolder);

    public abstract void setViewModel(AlbumPickAPKViewModel albumPickAPKViewModel);

    protected ItemLocalAppBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, CheckBox checkBox, TextView textView3, TableLayout tableLayout, TextView textView4) {
        super(obj, view, i);
        this.apkSizeView = textView;
        this.apkSystemView = textView2;
        this.cardView = linearLayout;
        this.contentView = linearLayout2;
        this.iconView = imageView;
        this.mobileAppCheckView = checkBox;
        this.titleView = textView3;
        this.versionInfoView = tableLayout;
        this.versionView = textView4;
    }

    public AppViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public MobileApp getApp() {
        return this.mApp;
    }

    public AlbumPickAPKViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemLocalAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocalAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLocalAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558819, viewGroup, z, obj);
    }

    public static ItemLocalAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocalAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLocalAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558819, null, false, obj);
    }

    public static ItemLocalAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLocalAppBinding bind(View view, Object obj) {
        return (ItemLocalAppBinding) bind(obj, view, 2131558819);
    }
}
