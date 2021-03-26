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

public abstract class ItemPermissionsBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView selectView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemPermissionsBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.itemView = linearLayout;
        this.selectView = imageView;
        this.titleView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPermissionsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558849, viewGroup, z, obj);
    }

    public static ItemPermissionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPermissionsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPermissionsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558849, null, false, obj);
    }

    public static ItemPermissionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPermissionsBinding bind(View view, Object obj) {
        return (ItemPermissionsBinding) bind(obj, view, 2131558849);
    }
}
