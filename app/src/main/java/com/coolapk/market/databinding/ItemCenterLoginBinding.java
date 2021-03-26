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

public abstract class ItemCenterLoginBinding extends ViewDataBinding {
    public final ImageView bottomBgView;
    public final LinearLayout buttonLoginByPhone;
    public final LinearLayout buttonLoginBySocial;
    public final TextView buttonRegisterByPhone;
    public final LinearLayout itemView;
    public final LinearLayout loginItemText;
    public final TextView loginItemTextView;
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView topBgView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemCenterLoginBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, ImageView imageView2) {
        super(obj, view, i);
        this.bottomBgView = imageView;
        this.buttonLoginByPhone = linearLayout;
        this.buttonLoginBySocial = linearLayout2;
        this.buttonRegisterByPhone = textView;
        this.itemView = linearLayout3;
        this.loginItemText = linearLayout4;
        this.loginItemTextView = textView2;
        this.topBgView = imageView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCenterLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558638, viewGroup, z, obj);
    }

    public static ItemCenterLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558638, null, false, obj);
    }

    public static ItemCenterLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterLoginBinding bind(View view, Object obj) {
        return (ItemCenterLoginBinding) bind(obj, view, 2131558638);
    }
}
