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

public abstract class ItemTopicViewBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    public final LinearLayout rootView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemTopicViewBinding(Object obj, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.logoView = imageView;
        this.rootView = linearLayout;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemTopicViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopicViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTopicViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558969, viewGroup, z, obj);
    }

    public static ItemTopicViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopicViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTopicViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558969, null, false, obj);
    }

    public static ItemTopicViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopicViewBinding bind(View view, Object obj) {
        return (ItemTopicViewBinding) bind(obj, view, 2131558969);
    }
}
