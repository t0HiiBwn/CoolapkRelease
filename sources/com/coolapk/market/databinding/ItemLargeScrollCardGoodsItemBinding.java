package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.viewholder.LargeScrollCardGoodsItemViewHolder;

public abstract class ItemLargeScrollCardGoodsItemBinding extends ViewDataBinding {
    public final TextView actionView;
    public final CardView itemView;
    public final ImageView logoView;
    @Bindable
    protected LargeScrollCardGoodsItemViewHolder mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView subTitleView;
    public final TextView titleView;

    public abstract void setModel(LargeScrollCardGoodsItemViewHolder largeScrollCardGoodsItemViewHolder);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemLargeScrollCardGoodsItemBinding(Object obj, View view, int i, TextView textView, CardView cardView, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = cardView;
        this.logoView = imageView;
        this.subTitleView = textView2;
        this.titleView = textView3;
    }

    public LargeScrollCardGoodsItemViewHolder getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemLargeScrollCardGoodsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeScrollCardGoodsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLargeScrollCardGoodsItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558795, viewGroup, z, obj);
    }

    public static ItemLargeScrollCardGoodsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeScrollCardGoodsItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLargeScrollCardGoodsItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558795, null, false, obj);
    }

    public static ItemLargeScrollCardGoodsItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeScrollCardGoodsItemBinding bind(View view, Object obj) {
        return (ItemLargeScrollCardGoodsItemBinding) bind(obj, view, 2131558795);
    }
}
