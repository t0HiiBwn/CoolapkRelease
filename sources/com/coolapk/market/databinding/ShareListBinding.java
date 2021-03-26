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

public abstract class ShareListBinding extends ViewDataBinding {
    public final LinearLayout bottomView;
    public final TextView cancelButton;
    @Bindable
    protected View.OnClickListener mClick;
    public final DrawSystemBarFrameLayout maskView;
    public final RecyclerView recyclerView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ShareListBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, DrawSystemBarFrameLayout drawSystemBarFrameLayout, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.bottomView = linearLayout;
        this.cancelButton = textView;
        this.maskView = drawSystemBarFrameLayout;
        this.recyclerView = recyclerView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ShareListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShareListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559147, viewGroup, z, obj);
    }

    public static ShareListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShareListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559147, null, false, obj);
    }

    public static ShareListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareListBinding bind(View view, Object obj) {
        return (ShareListBinding) bind(obj, view, 2131559147);
    }
}
