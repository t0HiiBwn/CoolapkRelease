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

public abstract class ItemCardAddBinding extends ViewDataBinding {
    public final LinearLayout buttonView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemCardAddBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.buttonView = linearLayout;
        this.iconView = imageView;
        this.itemView = linearLayout2;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCardAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558629, viewGroup, z, obj);
    }

    public static ItemCardAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558629, null, false, obj);
    }

    public static ItemCardAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardAddBinding bind(View view, Object obj) {
        return (ItemCardAddBinding) bind(obj, view, 2131558629);
    }
}
