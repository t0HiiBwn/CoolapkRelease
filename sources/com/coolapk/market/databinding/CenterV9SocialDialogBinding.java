package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class CenterV9SocialDialogBinding extends ViewDataBinding {
    public final TextView buttonLoginByPhone;
    public final LinearLayout buttonLoginByQq;
    public final LinearLayout buttonLoginByWechat;
    public final LinearLayout buttonLoginByWeibo;
    public final LinearLayout contentView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView textView;
    public final TextView tipsView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected CenterV9SocialDialogBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.buttonLoginByPhone = textView2;
        this.buttonLoginByQq = linearLayout;
        this.buttonLoginByWechat = linearLayout2;
        this.buttonLoginByWeibo = linearLayout3;
        this.contentView = linearLayout4;
        this.textView = textView3;
        this.tipsView = textView4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static CenterV9SocialDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CenterV9SocialDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CenterV9SocialDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558479, viewGroup, z, obj);
    }

    public static CenterV9SocialDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CenterV9SocialDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CenterV9SocialDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558479, null, false, obj);
    }

    public static CenterV9SocialDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CenterV9SocialDialogBinding bind(View view, Object obj) {
        return (CenterV9SocialDialogBinding) bind(obj, view, 2131558479);
    }
}
