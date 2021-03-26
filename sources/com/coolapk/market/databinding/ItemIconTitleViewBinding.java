package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.dyhv8.viewholder.IconThreeMoreViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemIconTitleViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final RoundedImageView iconView0;
    public final RoundedImageView iconView1;
    @Bindable
    protected IconThreeMoreViewHolder mHolder;
    @Bindable
    protected EntityCard mModel;
    public final TextView moreView;
    public final LinearLayout rootView;
    public final RoundedImageView titlePicView;
    public final TextView titleView;

    public abstract void setHolder(IconThreeMoreViewHolder iconThreeMoreViewHolder);

    public abstract void setModel(EntityCard entityCard);

    protected ItemIconTitleViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, RoundedImageView roundedImageView, RoundedImageView roundedImageView2, TextView textView, LinearLayout linearLayout, RoundedImageView roundedImageView3, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.iconView0 = roundedImageView;
        this.iconView1 = roundedImageView2;
        this.moreView = textView;
        this.rootView = linearLayout;
        this.titlePicView = roundedImageView3;
        this.titleView = textView2;
    }

    public EntityCard getModel() {
        return this.mModel;
    }

    public IconThreeMoreViewHolder getHolder() {
        return this.mHolder;
    }

    public static ItemIconTitleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconTitleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconTitleViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558791, viewGroup, z, obj);
    }

    public static ItemIconTitleViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconTitleViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconTitleViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558791, null, false, obj);
    }

    public static ItemIconTitleViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconTitleViewBinding bind(View view, Object obj) {
        return (ItemIconTitleViewBinding) bind(obj, view, 2131558791);
    }
}
