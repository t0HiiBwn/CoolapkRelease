package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.TagsView;

public abstract class ItemSearchExtendHeaderBinding extends ViewDataBinding {
    public final TagsView keywordsView;

    protected ItemSearchExtendHeaderBinding(Object obj, View view, int i, TagsView tagsView) {
        super(obj, view, i);
        this.keywordsView = tagsView;
    }

    public static ItemSearchExtendHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchExtendHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558910, viewGroup, z, obj);
    }

    public static ItemSearchExtendHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchExtendHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558910, null, false, obj);
    }

    public static ItemSearchExtendHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchExtendHeaderBinding bind(View view, Object obj) {
        return (ItemSearchExtendHeaderBinding) bind(obj, view, 2131558910);
    }
}
