package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class LayoutPrivacyClauseBinding extends ViewDataBinding {
    public final TextView agreeView;
    public final LinearLayout contentView;
    public final TextView descriptionView;
    public final TextView descriptionView2;
    public final RecyclerView listView;
    @Bindable
    protected View.OnClickListener mClick;
    public final DrawSystemBarFrameLayout mainContent;
    public final TextView onlyView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected LayoutPrivacyClauseBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, RecyclerView recyclerView, DrawSystemBarFrameLayout drawSystemBarFrameLayout, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.agreeView = textView;
        this.contentView = linearLayout;
        this.descriptionView = textView2;
        this.descriptionView2 = textView3;
        this.listView = recyclerView;
        this.mainContent = drawSystemBarFrameLayout;
        this.onlyView = textView4;
        this.titleView = textView5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static LayoutPrivacyClauseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutPrivacyClauseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutPrivacyClauseBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559006, viewGroup, z, obj);
    }

    public static LayoutPrivacyClauseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutPrivacyClauseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutPrivacyClauseBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559006, null, false, obj);
    }

    public static LayoutPrivacyClauseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutPrivacyClauseBinding bind(View view, Object obj) {
        return (LayoutPrivacyClauseBinding) bind(obj, view, 2131559006);
    }
}
