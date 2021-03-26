package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.viewholder.GoodsSimpleInfo;

public abstract class ItemArticleCardGoodsBinding extends ViewDataBinding {
    public final FrameLayout itemView;
    @Bindable
    protected GoodsSimpleInfo mModel;
    public final Space spaceView;

    public abstract void setModel(GoodsSimpleInfo goodsSimpleInfo);

    protected ItemArticleCardGoodsBinding(Object obj, View view, int i, FrameLayout frameLayout, Space space) {
        super(obj, view, i);
        this.itemView = frameLayout;
        this.spaceView = space;
    }

    public GoodsSimpleInfo getModel() {
        return this.mModel;
    }

    public static ItemArticleCardGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleCardGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleCardGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558609, viewGroup, z, obj);
    }

    public static ItemArticleCardGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleCardGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleCardGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558609, null, false, obj);
    }

    public static ItemArticleCardGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleCardGoodsBinding bind(View view, Object obj) {
        return (ItemArticleCardGoodsBinding) bind(obj, view, 2131558609);
    }
}
