package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.viewholder.GoodsSimpleInfo;

public abstract class ItemSubmitGoodsCardBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final FrameLayout itemView;
    @Bindable
    protected GoodsSimpleInfo mModel;
    public final Space spaceView;

    public abstract void setModel(GoodsSimpleInfo goodsSimpleInfo);

    protected ItemSubmitGoodsCardBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, Space space) {
        super(obj, view, i);
        this.closeView = imageView;
        this.itemView = frameLayout;
        this.spaceView = space;
    }

    public GoodsSimpleInfo getModel() {
        return this.mModel;
    }

    public static ItemSubmitGoodsCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSubmitGoodsCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSubmitGoodsCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558941, viewGroup, z, obj);
    }

    public static ItemSubmitGoodsCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSubmitGoodsCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSubmitGoodsCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558941, null, false, obj);
    }

    public static ItemSubmitGoodsCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSubmitGoodsCardBinding bind(View view, Object obj) {
        return (ItemSubmitGoodsCardBinding) bind(obj, view, 2131558941);
    }
}
