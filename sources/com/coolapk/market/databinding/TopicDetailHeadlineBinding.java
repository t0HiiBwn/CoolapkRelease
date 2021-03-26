package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.NewHeadLine;

public abstract class TopicDetailHeadlineBinding extends ViewDataBinding {
    public final LinearLayout clickView;
    @Bindable
    protected NewHeadLine mModel;
    public final TextView textView;

    public abstract void setModel(NewHeadLine newHeadLine);

    protected TopicDetailHeadlineBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.clickView = linearLayout;
        this.textView = textView2;
    }

    public NewHeadLine getModel() {
        return this.mModel;
    }

    public static TopicDetailHeadlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicDetailHeadlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TopicDetailHeadlineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559209, viewGroup, z, obj);
    }

    public static TopicDetailHeadlineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicDetailHeadlineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TopicDetailHeadlineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559209, null, false, obj);
    }

    public static TopicDetailHeadlineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicDetailHeadlineBinding bind(View view, Object obj) {
        return (TopicDetailHeadlineBinding) bind(obj, view, 2131559209);
    }
}
