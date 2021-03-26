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

public abstract class ItemProductTimelineChildBinding extends ViewDataBinding {
    public final TextView dateView;
    public final View dividerView;
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    public final TextView titleView;
    public final TextView yearView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemProductTimelineChildBinding(Object obj, View view, int i, TextView textView, View view2, ImageView imageView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.dateView = textView;
        this.dividerView = view2;
        this.iconView = imageView;
        this.infoView = textView2;
        this.itemView = linearLayout;
        this.titleView = textView3;
        this.yearView = textView4;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemProductTimelineChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductTimelineChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductTimelineChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558888, viewGroup, z, obj);
    }

    public static ItemProductTimelineChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductTimelineChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductTimelineChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558888, null, false, obj);
    }

    public static ItemProductTimelineChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductTimelineChildBinding bind(View view, Object obj) {
        return (ItemProductTimelineChildBinding) bind(obj, view, 2131558888);
    }
}
