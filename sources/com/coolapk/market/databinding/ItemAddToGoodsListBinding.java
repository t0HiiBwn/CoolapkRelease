package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FunThings;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public abstract class ItemAddToGoodsListBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CheckBox checkView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FunThings mModel;
    public final EllipsizeTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FunThings funThings);

    protected ItemAddToGoodsListBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox, ImageView imageView, EllipsizeTextView ellipsizeTextView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.checkView = checkBox;
        this.iconView = imageView;
        this.titleView = ellipsizeTextView;
    }

    public FunThings getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAddToGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAddToGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558580, viewGroup, z, obj);
    }

    public static ItemAddToGoodsListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToGoodsListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAddToGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558580, null, false, obj);
    }

    public static ItemAddToGoodsListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAddToGoodsListBinding bind(View view, Object obj) {
        return (ItemAddToGoodsListBinding) bind(obj, view, 2131558580);
    }
}
