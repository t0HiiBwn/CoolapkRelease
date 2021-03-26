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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.widget.FlowLayout;

public abstract class ItemMainCategoryDetailSBinding extends ViewDataBinding {
    public final FlowLayout childContainer;
    public final ImageView imageView;
    public final LinearLayout leftView;
    @Bindable
    protected AppCategory mAppCategory;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;

    public abstract void setAppCategory(AppCategory appCategory);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemMainCategoryDetailSBinding(Object obj, View view, int i, FlowLayout flowLayout, ImageView imageView2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.childContainer = flowLayout;
        this.imageView = imageView2;
        this.leftView = linearLayout;
        this.titleView = textView;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public AppCategory getAppCategory() {
        return this.mAppCategory;
    }

    public static ItemMainCategoryDetailSBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryDetailSBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainCategoryDetailSBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558826, viewGroup, z, obj);
    }

    public static ItemMainCategoryDetailSBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryDetailSBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainCategoryDetailSBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558826, null, false, obj);
    }

    public static ItemMainCategoryDetailSBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryDetailSBinding bind(View view, Object obj) {
        return (ItemMainCategoryDetailSBinding) bind(obj, view, 2131558826);
    }
}
