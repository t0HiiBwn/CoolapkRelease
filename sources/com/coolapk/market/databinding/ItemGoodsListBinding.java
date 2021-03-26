package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FunThings;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public abstract class ItemGoodsListBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FunThings mModel;
    public final EllipsizeTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FunThings funThings);

    protected ItemGoodsListBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, ImageView imageView, EllipsizeTextView ellipsizeTextView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.iconView = imageView;
        this.titleView = ellipsizeTextView;
    }

    public FunThings getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558758, viewGroup, z, obj);
    }

    public static ItemGoodsListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558758, null, false, obj);
    }

    public static ItemGoodsListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListBinding bind(View view, Object obj) {
        return (ItemGoodsListBinding) bind(obj, view, 2131558758);
    }
}
