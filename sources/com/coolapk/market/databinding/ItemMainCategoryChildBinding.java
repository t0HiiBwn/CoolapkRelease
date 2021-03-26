package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Link;

public abstract class ItemMainCategoryChildBinding extends ViewDataBinding {
    @Bindable
    protected Link mLinkCard;
    public final TextView titleView;

    public abstract void setLinkCard(Link link);

    protected ItemMainCategoryChildBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.titleView = textView;
    }

    public Link getLinkCard() {
        return this.mLinkCard;
    }

    public static ItemMainCategoryChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainCategoryChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558817, viewGroup, z, obj);
    }

    public static ItemMainCategoryChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainCategoryChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558817, null, false, obj);
    }

    public static ItemMainCategoryChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryChildBinding bind(View view, Object obj) {
        return (ItemMainCategoryChildBinding) bind(obj, view, 2131558817);
    }
}
