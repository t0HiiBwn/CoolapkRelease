package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.goodsList.GoodsListDetailViewModel;
import com.coolapk.market.widget.AspectRatioImageView;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public abstract class ItemGoodsListEditHeaderBinding extends ViewDataBinding {
    public final FrameLayout addPicView;
    public final LinearLayout contentTitle;
    public final FrameLayout contentView;
    public final EllipsizeTextView etDes;
    public final TextView etTitle;
    public final AspectRatioImageView ivCover;
    public final LinearLayout lvTop;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected GoodsListDetailViewModel mModel;
    public final ImageView picCloseView;
    public final LinearLayout relativeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(GoodsListDetailViewModel goodsListDetailViewModel);

    protected ItemGoodsListEditHeaderBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, EllipsizeTextView ellipsizeTextView, TextView textView, AspectRatioImageView aspectRatioImageView, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.addPicView = frameLayout;
        this.contentTitle = linearLayout;
        this.contentView = frameLayout2;
        this.etDes = ellipsizeTextView;
        this.etTitle = textView;
        this.ivCover = aspectRatioImageView;
        this.lvTop = linearLayout2;
        this.picCloseView = imageView;
        this.relativeView = linearLayout3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public GoodsListDetailViewModel getModel() {
        return this.mModel;
    }

    public static ItemGoodsListEditHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListEditHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsListEditHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558759, viewGroup, z, obj);
    }

    public static ItemGoodsListEditHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListEditHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsListEditHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558759, null, false, obj);
    }

    public static ItemGoodsListEditHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListEditHeaderBinding bind(View view, Object obj) {
        return (ItemGoodsListEditHeaderBinding) bind(obj, view, 2131558759);
    }
}
