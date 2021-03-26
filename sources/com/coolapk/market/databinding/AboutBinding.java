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

public abstract class AboutBinding extends ViewDataBinding {
    public final LinearLayout baseView;
    public final LinearLayout checkUpgradeLayout;
    public final TextView checkUpgradeView;
    public final TextView infoView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView openSource;
    public final TextView sloganView;
    public final TextView titleView;
    public final TextView version;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected AboutBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.baseView = linearLayout;
        this.checkUpgradeLayout = linearLayout2;
        this.checkUpgradeView = textView;
        this.infoView = textView2;
        this.logoView = imageView;
        this.openSource = textView3;
        this.sloganView = textView4;
        this.titleView = textView5;
        this.version = textView6;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static AboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AboutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558428, viewGroup, z, obj);
    }

    public static AboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AboutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AboutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558428, null, false, obj);
    }

    public static AboutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AboutBinding bind(View view, Object obj) {
        return (AboutBinding) bind(obj, view, 2131558428);
    }
}
