package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class TopicDetailDescriptionBinding extends ViewDataBinding {
    public final View dividerView;
    public final TextView textView;

    protected TopicDetailDescriptionBinding(Object obj, View view, int i, View view2, TextView textView2) {
        super(obj, view, i);
        this.dividerView = view2;
        this.textView = textView2;
    }

    public static TopicDetailDescriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicDetailDescriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TopicDetailDescriptionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559208, viewGroup, z, obj);
    }

    public static TopicDetailDescriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicDetailDescriptionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TopicDetailDescriptionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559208, null, false, obj);
    }

    public static TopicDetailDescriptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicDetailDescriptionBinding bind(View view, Object obj) {
        return (TopicDetailDescriptionBinding) bind(obj, view, 2131559208);
    }
}
