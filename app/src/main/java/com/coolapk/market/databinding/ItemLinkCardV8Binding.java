package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.CoolapkTagsView;

public abstract class ItemLinkCardV8Binding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final CoolapkTagsView keywordsScrollView;
    public final CoolapkTagsView keywordsView;
    @Bindable
    protected String mTitle;
    public final HorizontalScrollView scrollView;

    public abstract void setTitle(String str);

    protected ItemLinkCardV8Binding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, CoolapkTagsView coolapkTagsView, CoolapkTagsView coolapkTagsView2, HorizontalScrollView horizontalScrollView) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.keywordsScrollView = coolapkTagsView;
        this.keywordsView = coolapkTagsView2;
        this.scrollView = horizontalScrollView;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemLinkCardV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLinkCardV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558802, viewGroup, z, obj);
    }

    public static ItemLinkCardV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLinkCardV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558802, null, false, obj);
    }

    public static ItemLinkCardV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardV8Binding bind(View view, Object obj) {
        return (ItemLinkCardV8Binding) bind(obj, view, 2131558802);
    }
}
