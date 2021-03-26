package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ProductPostViewBinding extends ViewDataBinding {
    public final FrameLayout bgView;
    public final LinearLayout itemView1;
    public final LinearLayout itemView2;
    public final LinearLayout itemView3;
    public final LinearLayout itemView4;
    public final LinearLayout itemView6;
    public final LinearLayout itemView7;
    @Bindable
    protected View.OnClickListener mClick;
    public final FrameLayout parentView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ProductPostViewBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.bgView = frameLayout;
        this.itemView1 = linearLayout;
        this.itemView2 = linearLayout2;
        this.itemView3 = linearLayout3;
        this.itemView4 = linearLayout4;
        this.itemView6 = linearLayout5;
        this.itemView7 = linearLayout6;
        this.parentView = frameLayout2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ProductPostViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductPostViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ProductPostViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559111, viewGroup, z, obj);
    }

    public static ProductPostViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductPostViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ProductPostViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559111, null, false, obj);
    }

    public static ProductPostViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductPostViewBinding bind(View view, Object obj) {
        return (ProductPostViewBinding) bind(obj, view, 2131559111);
    }
}
