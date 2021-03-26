package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemWeuiBinding extends ViewDataBinding {
    public final TextView actionTextView;
    public final EditText editText;
    public final ImageView endImg;
    @Bindable
    protected String mImg;
    public final LinearLayout mainInputContainer;
    public final ImageView startImg;
    public final TextView textView;
    public final TextView titleText;

    public abstract void setImg(String str);

    protected ItemWeuiBinding(Object obj, View view, int i, TextView textView2, EditText editText2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionTextView = textView2;
        this.editText = editText2;
        this.endImg = imageView;
        this.mainInputContainer = linearLayout;
        this.startImg = imageView2;
        this.textView = textView3;
        this.titleText = textView4;
    }

    public String getImg() {
        return this.mImg;
    }

    public static ItemWeuiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWeuiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemWeuiBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558999, viewGroup, z, obj);
    }

    public static ItemWeuiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWeuiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemWeuiBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558999, null, false, obj);
    }

    public static ItemWeuiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWeuiBinding bind(View view, Object obj) {
        return (ItemWeuiBinding) bind(obj, view, 2131558999);
    }
}
