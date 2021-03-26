package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemNewAddBinding extends ViewDataBinding {
    public final TextView actionView;
    @Bindable
    protected String mActionText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected boolean mIsMyAlbum;
    @Bindable
    protected String mTitleText;
    public final TextView titleView;

    public abstract void setActionText(String str);

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setIsMyAlbum(boolean z);

    public abstract void setTitleText(String str);

    protected ItemNewAddBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.actionView = textView;
        this.titleView = textView2;
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public String getActionText() {
        return this.mActionText;
    }

    public boolean getIsMyAlbum() {
        return this.mIsMyAlbum;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemNewAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNewAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558833, viewGroup, z, obj);
    }

    public static ItemNewAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNewAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558833, null, false, obj);
    }

    public static ItemNewAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewAddBinding bind(View view, Object obj) {
        return (ItemNewAddBinding) bind(obj, view, 2131558833);
    }
}
