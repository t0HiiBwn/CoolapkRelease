package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemCreateGoodsListBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final AspectRatioImageView coverView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mFollowNum;
    @Bindable
    protected FunThings mModel;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFollowNum(String str);

    public abstract void setModel(FunThings funThings);

    protected ItemCreateGoodsListBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, AspectRatioImageView aspectRatioImageView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.coverView = aspectRatioImageView;
        this.itemView = frameLayout;
    }

    public FunThings getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getFollowNum() {
        return this.mFollowNum;
    }

    public static ItemCreateGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCreateGoodsListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCreateGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558672, viewGroup, z, obj);
    }

    public static ItemCreateGoodsListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCreateGoodsListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCreateGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558672, null, false, obj);
    }

    public static ItemCreateGoodsListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCreateGoodsListBinding bind(View view, Object obj) {
        return (ItemCreateGoodsListBinding) bind(obj, view, 2131558672);
    }
}
