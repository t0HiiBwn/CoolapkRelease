package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Gift;

public abstract class ItemAppNodeGiftBinding extends ViewDataBinding {
    public final LinearLayout fetchGiftView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Gift mGift;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setGift(Gift gift);

    protected ItemAppNodeGiftBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.fetchGiftView = linearLayout;
        this.itemView = linearLayout2;
    }

    public Gift getGift() {
        return this.mGift;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAppNodeGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppNodeGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558594, viewGroup, z, obj);
    }

    public static ItemAppNodeGiftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppNodeGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558594, null, false, obj);
    }

    public static ItemAppNodeGiftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppNodeGiftBinding bind(View view, Object obj) {
        return (ItemAppNodeGiftBinding) bind(obj, view, 2131558594);
    }
}
