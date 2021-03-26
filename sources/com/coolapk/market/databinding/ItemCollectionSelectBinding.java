package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Collection;

public abstract class ItemCollectionSelectBinding extends ViewDataBinding {
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Collection mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final CheckBox selectView;
    public final TextView statusView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Collection collection);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemCollectionSelectBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, CheckBox checkBox, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.infoView = textView;
        this.itemView = linearLayout;
        this.selectView = checkBox;
        this.statusView = textView2;
        this.titleView = textView3;
    }

    public Collection getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemCollectionSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCollectionSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558662, viewGroup, z, obj);
    }

    public static ItemCollectionSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionSelectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCollectionSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558662, null, false, obj);
    }

    public static ItemCollectionSelectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionSelectBinding bind(View view, Object obj) {
        return (ItemCollectionSelectBinding) bind(obj, view, 2131558662);
    }
}
