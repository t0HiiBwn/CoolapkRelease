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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.view.goodsList.GoodsListItemViewModel;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemEditGoodsBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CheckBox checkView;
    public final CoolapkCardView coolapkCardView;
    public final ImageView dragView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected GoodsListItemViewModel mModel;
    public final ImageView noteEdit;
    public final CoolEllipsizeTextView titleView;
    public final CoolEllipsizeTextView versionView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(GoodsListItemViewModel goodsListItemViewModel);

    protected ItemEditGoodsBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox, CoolapkCardView coolapkCardView2, ImageView imageView, ImageView imageView2, ImageView imageView3, CoolEllipsizeTextView coolEllipsizeTextView, CoolEllipsizeTextView coolEllipsizeTextView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.checkView = checkBox;
        this.coolapkCardView = coolapkCardView2;
        this.dragView = imageView;
        this.iconView = imageView2;
        this.noteEdit = imageView3;
        this.titleView = coolEllipsizeTextView;
        this.versionView = coolEllipsizeTextView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public GoodsListItemViewModel getModel() {
        return this.mModel;
    }

    public static ItemEditGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEditGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemEditGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558692, viewGroup, z, obj);
    }

    public static ItemEditGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEditGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemEditGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558692, null, false, obj);
    }

    public static ItemEditGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEditGoodsBinding bind(View view, Object obj) {
        return (ItemEditGoodsBinding) bind(obj, view, 2131558692);
    }
}
