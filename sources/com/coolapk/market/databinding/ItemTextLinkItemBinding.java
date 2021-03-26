package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemTextLinkItemBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    @Bindable
    protected Entity mEntity;
    public final TextView subTitleView;
    public final TextView textView;

    public abstract void setEntity(Entity entity);

    protected ItemTextLinkItemBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.subTitleView = textView2;
        this.textView = textView3;
    }

    public Entity getEntity() {
        return this.mEntity;
    }

    public static ItemTextLinkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextLinkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextLinkItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558958, viewGroup, z, obj);
    }

    public static ItemTextLinkItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextLinkItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextLinkItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558958, null, false, obj);
    }

    public static ItemTextLinkItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextLinkItemBinding bind(View view, Object obj) {
        return (ItemTextLinkItemBinding) bind(obj, view, 2131558958);
    }
}
