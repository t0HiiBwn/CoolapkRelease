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
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.view.FollowStyleTextView;

public abstract class ItemProductSeriesHorizontalBinding extends ViewDataBinding {
    public final FollowStyleTextView actionButton1;
    public final FollowStyleTextView actionButton2;
    public final FollowStyleTextView actionButton3;
    public final LinearLayout actionContainer;
    public final ImageView actionView;
    public final LinearLayout itemView;
    public final LinearLayout itemView1;
    public final LinearLayout itemView2;
    public final LinearLayout itemView3;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Product mModel1;
    @Bindable
    protected Product mModel2;
    @Bindable
    protected Product mModel3;
    public final TextView subtitleView1;
    public final TextView subtitleView2;
    public final TextView subtitleView3;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel1(Product product);

    public abstract void setModel2(Product product);

    public abstract void setModel3(Product product);

    protected ItemProductSeriesHorizontalBinding(Object obj, View view, int i, FollowStyleTextView followStyleTextView, FollowStyleTextView followStyleTextView2, FollowStyleTextView followStyleTextView3, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionButton1 = followStyleTextView;
        this.actionButton2 = followStyleTextView2;
        this.actionButton3 = followStyleTextView3;
        this.actionContainer = linearLayout;
        this.actionView = imageView;
        this.itemView = linearLayout2;
        this.itemView1 = linearLayout3;
        this.itemView2 = linearLayout4;
        this.itemView3 = linearLayout5;
        this.subtitleView1 = textView;
        this.subtitleView2 = textView2;
        this.subtitleView3 = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Product getModel1() {
        return this.mModel1;
    }

    public Product getModel2() {
        return this.mModel2;
    }

    public Product getModel3() {
        return this.mModel3;
    }

    public static ItemProductSeriesHorizontalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesHorizontalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesHorizontalBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558875, viewGroup, z, obj);
    }

    public static ItemProductSeriesHorizontalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesHorizontalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesHorizontalBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558875, null, false, obj);
    }

    public static ItemProductSeriesHorizontalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesHorizontalBinding bind(View view, Object obj) {
        return (ItemProductSeriesHorizontalBinding) bind(obj, view, 2131558875);
    }
}
