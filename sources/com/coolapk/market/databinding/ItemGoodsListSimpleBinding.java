package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FunThings;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemGoodsListSimpleBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final RoundedImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FunThings mModel;
    @Bindable
    protected String mUserInfo;
    public final TextView recommendView;
    public final LinearLayout strokeView;
    public final EllipsizeTextView titleView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FunThings funThings);

    public abstract void setUserInfo(String str);

    protected ItemGoodsListSimpleBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, RoundedImageView roundedImageView, TextView textView, LinearLayout linearLayout2, EllipsizeTextView ellipsizeTextView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.iconView = roundedImageView;
        this.recommendView = textView;
        this.strokeView = linearLayout2;
        this.titleView = ellipsizeTextView;
        this.userNameView = textView2;
    }

    public FunThings getModel() {
        return this.mModel;
    }

    public String getUserInfo() {
        return this.mUserInfo;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGoodsListSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsListSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558768, viewGroup, z, obj);
    }

    public static ItemGoodsListSimpleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListSimpleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsListSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558768, null, false, obj);
    }

    public static ItemGoodsListSimpleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListSimpleBinding bind(View view, Object obj) {
        return (ItemGoodsListSimpleBinding) bind(obj, view, 2131558768);
    }
}
