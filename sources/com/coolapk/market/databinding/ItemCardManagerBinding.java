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

public abstract class ItemCardManagerBinding extends ViewDataBinding {
    public final ImageView addView;
    public final ImageView dragView;
    public final LinearLayout itemView;
    public final ImageView lessView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemCardManagerBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, TextView textView) {
        super(obj, view, i);
        this.addView = imageView;
        this.dragView = imageView2;
        this.itemView = linearLayout;
        this.lessView = imageView3;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCardManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558632, viewGroup, z, obj);
    }

    public static ItemCardManagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardManagerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558632, null, false, obj);
    }

    public static ItemCardManagerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardManagerBinding bind(View view, Object obj) {
        return (ItemCardManagerBinding) bind(obj, view, 2131558632);
    }
}
