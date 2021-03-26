package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemNodeTopContenItemBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView imageView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemNodeTopContenItemBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.imageView = imageView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemNodeTopContenItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeTopContenItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNodeTopContenItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558848, viewGroup, z, obj);
    }

    public static ItemNodeTopContenItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeTopContenItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNodeTopContenItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558848, null, false, obj);
    }

    public static ItemNodeTopContenItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeTopContenItemBinding bind(View view, Object obj) {
        return (ItemNodeTopContenItemBinding) bind(obj, view, 2131558848);
    }
}
