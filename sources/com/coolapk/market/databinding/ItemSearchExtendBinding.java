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

public abstract class ItemSearchExtendBinding extends ViewDataBinding {
    public final LinearLayout contentLayout;
    public final ImageView deleteView;
    @Bindable
    protected String mText;
    public final LinearLayout mainContent;
    public final TextView text1;

    public abstract void setText(String str);

    protected ItemSearchExtendBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.contentLayout = linearLayout;
        this.deleteView = imageView;
        this.mainContent = linearLayout2;
        this.text1 = textView;
    }

    public String getText() {
        return this.mText;
    }

    public static ItemSearchExtendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchExtendBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558915, viewGroup, z, obj);
    }

    public static ItemSearchExtendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchExtendBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558915, null, false, obj);
    }

    public static ItemSearchExtendBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendBinding bind(View view, Object obj) {
        return (ItemSearchExtendBinding) bind(obj, view, 2131558915);
    }
}
