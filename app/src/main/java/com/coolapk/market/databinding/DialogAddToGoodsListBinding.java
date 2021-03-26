package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FunThings;

public abstract class DialogAddToGoodsListBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FunThings mModel;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FunThings funThings);

    protected DialogAddToGoodsListBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.cardView = linearLayout;
    }

    public FunThings getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static DialogAddToGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddToGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAddToGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558512, viewGroup, z, obj);
    }

    public static DialogAddToGoodsListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddToGoodsListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAddToGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558512, null, false, obj);
    }

    public static DialogAddToGoodsListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddToGoodsListBinding bind(View view, Object obj) {
        return (DialogAddToGoodsListBinding) bind(obj, view, 2131558512);
    }
}
