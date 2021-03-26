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
import com.coolapk.market.model.Entity;

public abstract class ItemTextTitleScrollChildBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView imageView;
    @Bindable
    protected Entity mModel;
    public final TextView newTagView;
    public final TextView titleView;

    public abstract void setModel(Entity entity);

    protected ItemTextTitleScrollChildBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.imageView = imageView2;
        this.newTagView = textView;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public static ItemTextTitleScrollChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextTitleScrollChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextTitleScrollChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558959, viewGroup, z, obj);
    }

    public static ItemTextTitleScrollChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextTitleScrollChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextTitleScrollChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558959, null, false, obj);
    }

    public static ItemTextTitleScrollChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextTitleScrollChildBinding bind(View view, Object obj) {
        return (ItemTextTitleScrollChildBinding) bind(obj, view, 2131558959);
    }
}
