package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final EditText editText;
    public final ImageView imageView;

    protected ItemSearchViewBinding(Object obj, View view, int i, LinearLayout linearLayout, EditText editText2, ImageView imageView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.editText = editText2;
        this.imageView = imageView2;
    }

    public static ItemSearchViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558924, viewGroup, z, obj);
    }

    public static ItemSearchViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558924, null, false, obj);
    }

    public static ItemSearchViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchViewBinding bind(View view, Object obj) {
        return (ItemSearchViewBinding) bind(obj, view, 2131558924);
    }
}
