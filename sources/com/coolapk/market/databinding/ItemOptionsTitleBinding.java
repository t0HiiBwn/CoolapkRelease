package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemOptionsTitleBinding extends ViewDataBinding {
    @Bindable
    protected String mOption1;
    @Bindable
    protected String mOption2;
    @Bindable
    protected String mTitle;
    public final TextView option1View;
    public final TextView option2View;
    public final TextView titleView;

    public abstract void setOption1(String str);

    public abstract void setOption2(String str);

    public abstract void setTitle(String str);

    protected ItemOptionsTitleBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.option1View = textView;
        this.option2View = textView2;
        this.titleView = textView3;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getOption1() {
        return this.mOption1;
    }

    public String getOption2() {
        return this.mOption2;
    }

    public static ItemOptionsTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOptionsTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOptionsTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558854, viewGroup, z, obj);
    }

    public static ItemOptionsTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOptionsTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOptionsTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558854, null, false, obj);
    }

    public static ItemOptionsTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemOptionsTitleBinding bind(View view, Object obj) {
        return (ItemOptionsTitleBinding) bind(obj, view, 2131558854);
    }
}
