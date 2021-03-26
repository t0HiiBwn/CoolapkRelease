package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Entity;

public abstract class ItemCapsuleListBinding extends ViewDataBinding {
    public final ImageView imageView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    public final RecyclerView recyclerView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemCapsuleListBinding(Object obj, View view, int i, ImageView imageView2, RecyclerView recyclerView2, TextView textView) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.recyclerView = recyclerView2;
        this.titleView = textView;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCapsuleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCapsuleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCapsuleListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558634, viewGroup, z, obj);
    }

    public static ItemCapsuleListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCapsuleListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCapsuleListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558634, null, false, obj);
    }

    public static ItemCapsuleListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCapsuleListBinding bind(View view, Object obj) {
        return (ItemCapsuleListBinding) bind(obj, view, 2131558634);
    }
}
