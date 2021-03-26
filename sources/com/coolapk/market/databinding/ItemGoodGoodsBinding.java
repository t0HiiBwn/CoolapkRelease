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
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemGoodGoodsBinding extends ViewDataBinding {
    public final TextView actionView;
    public final FrameLayout bgView;
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected GoodsListItem mModel;
    public final CoolEllipsizeTextView titleView;
    public final CoolEllipsizeTextView versionView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(GoodsListItem goodsListItem);

    protected ItemGoodGoodsBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, CoolEllipsizeTextView coolEllipsizeTextView, CoolEllipsizeTextView coolEllipsizeTextView2) {
        super(obj, view, i);
        this.actionView = textView;
        this.bgView = frameLayout;
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.titleView = coolEllipsizeTextView;
        this.versionView = coolEllipsizeTextView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public GoodsListItem getModel() {
        return this.mModel;
    }

    public static ItemGoodGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558759, viewGroup, z, obj);
    }

    public static ItemGoodGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558759, null, false, obj);
    }

    public static ItemGoodGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsBinding bind(View view, Object obj) {
        return (ItemGoodGoodsBinding) bind(obj, view, 2131558759);
    }
}
