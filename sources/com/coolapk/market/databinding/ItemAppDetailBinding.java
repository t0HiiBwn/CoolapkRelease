package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppDetailViewModel;

public abstract class ItemAppDetailBinding extends ViewDataBinding {
    public final TextView apkSizeView;
    public final TextView changeHistoryTextView;
    public final TableRow changeHistoryTitleView;
    public final TableRow changeHistoryView;
    public final TableRow developerLayout;
    public final TextView developerView;
    public final TextView languageView;
    @Bindable
    protected AppDetailViewModel mViewModel;
    public final TextView packageNameView;
    public final TableLayout permissionClickView;
    public final TableRow permissionNumView;
    public final TextView permissionTextView;
    public final TextView permissionTitleTextView;
    public final TableRow permissionTitleView;
    public final TableRow permissionView;
    public final TextView romSupportView;
    public final TextView updateDateView;
    public final TextView versionHistoryView;
    public final TextView versionView;
    public final TextView viewAllPermissionView;

    public abstract void setViewModel(AppDetailViewModel appDetailViewModel);

    protected ItemAppDetailBinding(Object obj, View view, int i, TextView textView, TextView textView2, TableRow tableRow, TableRow tableRow2, TableRow tableRow3, TextView textView3, TextView textView4, TextView textView5, TableLayout tableLayout, TableRow tableRow4, TextView textView6, TextView textView7, TableRow tableRow5, TableRow tableRow6, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        super(obj, view, i);
        this.apkSizeView = textView;
        this.changeHistoryTextView = textView2;
        this.changeHistoryTitleView = tableRow;
        this.changeHistoryView = tableRow2;
        this.developerLayout = tableRow3;
        this.developerView = textView3;
        this.languageView = textView4;
        this.packageNameView = textView5;
        this.permissionClickView = tableLayout;
        this.permissionNumView = tableRow4;
        this.permissionTextView = textView6;
        this.permissionTitleTextView = textView7;
        this.permissionTitleView = tableRow5;
        this.permissionView = tableRow6;
        this.romSupportView = textView8;
        this.updateDateView = textView9;
        this.versionHistoryView = textView10;
        this.versionView = textView11;
        this.viewAllPermissionView = textView12;
    }

    public AppDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558594, viewGroup, z, obj);
    }

    public static ItemAppDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558594, null, false, obj);
    }

    public static ItemAppDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppDetailBinding bind(View view, Object obj) {
        return (ItemAppDetailBinding) bind(obj, view, 2131558594);
    }
}
