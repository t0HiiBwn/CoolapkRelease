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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Topic;

public abstract class ItemTopicBinding extends ViewDataBinding {
    public final TextView followNumView;
    public final ImageView iconView;
    public final TextView ignoreFlag;
    public final LinearLayout itemView;
    @Bindable
    protected Topic mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;
    public final TextView topicNumView;

    public abstract void setModel(Topic topic);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemTopicBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.followNumView = textView;
        this.iconView = imageView;
        this.ignoreFlag = textView2;
        this.itemView = linearLayout;
        this.titleView = textView3;
        this.topicNumView = textView4;
    }

    public Topic getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemTopicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558961, viewGroup, z, obj);
    }

    public static ItemTopicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558961, null, false, obj);
    }

    public static ItemTopicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopicBinding bind(View view, Object obj) {
        return (ItemTopicBinding) bind(obj, view, 2131558961);
    }
}
