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

public abstract class SearchDropdownItemBinding extends ViewDataBinding {
    public final TextView clearButton;
    public final LinearLayout contentLayout;
    public final ImageView divider;
    @Bindable
    protected String mText;
    public final LinearLayout mainContent;
    public final ImageView navigationView;
    public final TextView text1;

    public abstract void setText(String str);

    protected SearchDropdownItemBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.clearButton = textView;
        this.contentLayout = linearLayout;
        this.divider = imageView;
        this.mainContent = linearLayout2;
        this.navigationView = imageView2;
        this.text1 = textView2;
    }

    public String getText() {
        return this.mText;
    }

    public static SearchDropdownItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchDropdownItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchDropdownItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559123, viewGroup, z, obj);
    }

    public static SearchDropdownItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchDropdownItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchDropdownItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559123, null, false, obj);
    }

    public static SearchDropdownItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchDropdownItemBinding bind(View view, Object obj) {
        return (SearchDropdownItemBinding) bind(obj, view, 2131559123);
    }
}
