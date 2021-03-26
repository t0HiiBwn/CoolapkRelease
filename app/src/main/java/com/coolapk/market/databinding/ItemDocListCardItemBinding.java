package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemDocListCardItemBinding extends ViewDataBinding {
    public final TextView entityTypeNameView;
    public final TextView getView;
    public final ImageView iconView;
    @Bindable
    protected String mEntityTypeName;
    @Bindable
    protected boolean mIsGift;
    @Bindable
    protected String mLogo;
    @Bindable
    protected String mTitle;

    public abstract void setEntityTypeName(String str);

    public abstract void setIsGift(boolean z);

    public abstract void setLogo(String str);

    public abstract void setTitle(String str);

    protected ItemDocListCardItemBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.entityTypeNameView = textView;
        this.getView = textView2;
        this.iconView = imageView;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getEntityTypeName() {
        return this.mEntityTypeName;
    }

    public boolean getIsGift() {
        return this.mIsGift;
    }

    public static ItemDocListCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocListCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDocListCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558673, viewGroup, z, obj);
    }

    public static ItemDocListCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocListCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDocListCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558673, null, false, obj);
    }

    public static ItemDocListCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDocListCardItemBinding bind(View view, Object obj) {
        return (ItemDocListCardItemBinding) bind(obj, view, 2131558673);
    }
}
