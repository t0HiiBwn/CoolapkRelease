package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.RecentHistory;

public abstract class ItemRecentLoginBinding extends ViewDataBinding {
    public final FrameLayout itemView;
    @Bindable
    protected RecentHistory mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;

    public abstract void setModel(RecentHistory recentHistory);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemRecentLoginBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i);
        this.itemView = frameLayout;
        this.titleView = textView;
    }

    public RecentHistory getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemRecentLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRecentLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558892, viewGroup, z, obj);
    }

    public static ItemRecentLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRecentLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558892, null, false, obj);
    }

    public static ItemRecentLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRecentLoginBinding bind(View view, Object obj) {
        return (ItemRecentLoginBinding) bind(obj, view, 2131558892);
    }
}
