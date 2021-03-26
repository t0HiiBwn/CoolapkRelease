package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.UserProfile;

public abstract class ItemAccountTipsBinding extends ViewDataBinding {
    public final TextView buttonView;
    public final ImageView closeView;
    public final CoolapkCardView coolapkCardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected UserProfile mModel;
    public final ImageView tipsIconView;
    public final LinearLayout tipsView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(UserProfile userProfile);

    protected ItemAccountTipsBinding(Object obj, View view, int i, TextView textView, ImageView imageView, CoolapkCardView coolapkCardView2, ImageView imageView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.buttonView = textView;
        this.closeView = imageView;
        this.coolapkCardView = coolapkCardView2;
        this.tipsIconView = imageView2;
        this.tipsView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public UserProfile getModel() {
        return this.mModel;
    }

    public static ItemAccountTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAccountTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAccountTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558572, viewGroup, z, obj);
    }

    public static ItemAccountTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAccountTipsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAccountTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558572, null, false, obj);
    }

    public static ItemAccountTipsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAccountTipsBinding bind(View view, Object obj) {
        return (ItemAccountTipsBinding) bind(obj, view, 2131558572);
    }
}
