package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemTextLinkCardItemBinding extends ViewDataBinding {
    @Bindable
    protected Entity mEntity;
    public final TextView textView;

    public abstract void setEntity(Entity entity);

    protected ItemTextLinkCardItemBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public Entity getEntity() {
        return this.mEntity;
    }

    public static ItemTextLinkCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextLinkCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextLinkCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558950, viewGroup, z, obj);
    }

    public static ItemTextLinkCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextLinkCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextLinkCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558950, null, false, obj);
    }

    public static ItemTextLinkCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextLinkCardItemBinding bind(View view, Object obj) {
        return (ItemTextLinkCardItemBinding) bind(obj, view, 2131558950);
    }
}
