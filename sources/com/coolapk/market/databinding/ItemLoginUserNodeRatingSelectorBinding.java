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

public abstract class ItemLoginUserNodeRatingSelectorBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView orderImage;
    public final TextView orderText;
    public final LinearLayout orderView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemLoginUserNodeRatingSelectorBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.orderImage = imageView;
        this.orderText = textView;
        this.orderView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemLoginUserNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginUserNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLoginUserNodeRatingSelectorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558823, viewGroup, z, obj);
    }

    public static ItemLoginUserNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginUserNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLoginUserNodeRatingSelectorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558823, null, false, obj);
    }

    public static ItemLoginUserNodeRatingSelectorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginUserNodeRatingSelectorBinding bind(View view, Object obj) {
        return (ItemLoginUserNodeRatingSelectorBinding) bind(obj, view, 2131558823);
    }
}
