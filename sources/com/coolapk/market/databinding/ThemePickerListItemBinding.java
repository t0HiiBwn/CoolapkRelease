package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppTheme;
import com.coolapk.market.view.theme.ThemeListActivity;

public abstract class ThemePickerListItemBinding extends ViewDataBinding {
    public final ImageView checkIndicator;
    public final TextView colorText;
    @Bindable
    protected AppTheme.ThemeItem mThemeItem;
    @Bindable
    protected ThemeListActivity.ThemePickerFragment.ThemeViewHolder mViewHolder;
    public final TextView textView;
    public final TextView tipText;

    public abstract void setThemeItem(AppTheme.ThemeItem themeItem);

    public abstract void setViewHolder(ThemeListActivity.ThemePickerFragment.ThemeViewHolder themeViewHolder);

    protected ThemePickerListItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.checkIndicator = imageView;
        this.colorText = textView2;
        this.textView = textView3;
        this.tipText = textView4;
    }

    public AppTheme.ThemeItem getThemeItem() {
        return this.mThemeItem;
    }

    public ThemeListActivity.ThemePickerFragment.ThemeViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public static ThemePickerListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThemePickerListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ThemePickerListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559204, viewGroup, z, obj);
    }

    public static ThemePickerListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThemePickerListItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ThemePickerListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559204, null, false, obj);
    }

    public static ThemePickerListItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThemePickerListItemBinding bind(View view, Object obj) {
        return (ThemePickerListItemBinding) bind(obj, view, 2131559204);
    }
}
