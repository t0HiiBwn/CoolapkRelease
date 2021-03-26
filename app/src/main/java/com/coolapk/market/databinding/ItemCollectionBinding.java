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
import com.coolapk.market.model.Collection;
import com.coolapk.market.widget.view.ShapedImageView;

public abstract class ItemCollectionBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final ImageView imgView;
    public final TextView infoView;
    public final LinearLayout itemView;
    public final ShapedImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Collection mModel;
    public final TextView statusView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Collection collection);

    protected ItemCollectionBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, ShapedImageView shapedImageView, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView;
        this.imgView = imageView;
        this.infoView = textView2;
        this.itemView = linearLayout;
        this.logoView = shapedImageView;
        this.statusView = textView3;
        this.titleView = textView4;
    }

    public Collection getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCollectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCollectionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558653, viewGroup, z, obj);
    }

    public static ItemCollectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCollectionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558653, null, false, obj);
    }

    public static ItemCollectionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionBinding bind(View view, Object obj) {
        return (ItemCollectionBinding) bind(obj, view, 2131558653);
    }
}
