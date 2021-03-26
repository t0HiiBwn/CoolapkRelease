package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.viewholder.GoodsSimpleInfo;

public abstract class ItemFeedGoodsInfoBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected GoodsSimpleInfo mModel;
    @Bindable
    protected String mSubTitle;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(GoodsSimpleInfo goodsSimpleInfo);

    public abstract void setSubTitle(String str);

    protected ItemFeedGoodsInfoBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public GoodsSimpleInfo getModel() {
        return this.mModel;
    }

    public static ItemFeedGoodsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedGoodsInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558712, viewGroup, z, obj);
    }

    public static ItemFeedGoodsInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedGoodsInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558712, null, false, obj);
    }

    public static ItemFeedGoodsInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedGoodsInfoBinding bind(View view, Object obj) {
        return (ItemFeedGoodsInfoBinding) bind(obj, view, 2131558712);
    }
}
