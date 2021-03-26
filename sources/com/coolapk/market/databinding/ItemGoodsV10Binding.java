package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FeedGoods;

public abstract class ItemGoodsV10Binding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final Space goodsSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedGoods mModel;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedGoods feedGoods);

    protected ItemGoodsV10Binding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, Space space) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.goodsSpaceView = space;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public FeedGoods getModel() {
        return this.mModel;
    }

    public static ItemGoodsV10Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsV10Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsV10Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558763, viewGroup, z, obj);
    }

    public static ItemGoodsV10Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsV10Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsV10Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558763, null, false, obj);
    }

    public static ItemGoodsV10Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsV10Binding bind(View view, Object obj) {
        return (ItemGoodsV10Binding) bind(obj, view, 2131558763);
    }
}
