package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.CoolFlowLayout;

public abstract class ItemSearchFeedFilterBinding extends ViewDataBinding {
    public final LinearLayout feedTypeLayout;
    public final CoolFlowLayout feedTypeList;
    public final TextView sortDateline;
    public final TextView sortHot;
    public final TextView sortReply;
    public final LinearLayout sortView;

    protected ItemSearchFeedFilterBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolFlowLayout coolFlowLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.feedTypeLayout = linearLayout;
        this.feedTypeList = coolFlowLayout;
        this.sortDateline = textView;
        this.sortHot = textView2;
        this.sortReply = textView3;
        this.sortView = linearLayout2;
    }

    public static ItemSearchFeedFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchFeedFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchFeedFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558911, viewGroup, z, obj);
    }

    public static ItemSearchFeedFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchFeedFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchFeedFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558911, null, false, obj);
    }

    public static ItemSearchFeedFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchFeedFilterBinding bind(View view, Object obj) {
        return (ItemSearchFeedFilterBinding) bind(obj, view, 2131558911);
    }
}
