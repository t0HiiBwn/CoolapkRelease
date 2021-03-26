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
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemAppUpdataManagerBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final ImageView iconView1;
    public final ImageView iconView2;
    public final ImageView iconView3;
    public final ImageView iconView4;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemAppUpdataManagerBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.iconView1 = imageView;
        this.iconView2 = imageView2;
        this.iconView3 = imageView3;
        this.iconView4 = imageView4;
        this.itemView = linearLayout;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAppUpdataManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppUpdataManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppUpdataManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558602, viewGroup, z, obj);
    }

    public static ItemAppUpdataManagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppUpdataManagerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppUpdataManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558602, null, false, obj);
    }

    public static ItemAppUpdataManagerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppUpdataManagerBinding bind(View view, Object obj) {
        return (ItemAppUpdataManagerBinding) bind(obj, view, 2131558602);
    }
}
