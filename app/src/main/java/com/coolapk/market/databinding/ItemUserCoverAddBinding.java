package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.SquareImageView;

public abstract class ItemUserCoverAddBinding extends ViewDataBinding {
    public final SquareImageView imageView;

    protected ItemUserCoverAddBinding(Object obj, View view, int i, SquareImageView squareImageView) {
        super(obj, view, i);
        this.imageView = squareImageView;
    }

    public static ItemUserCoverAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserCoverAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558968, viewGroup, z, obj);
    }

    public static ItemUserCoverAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserCoverAddBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558968, null, false, obj);
    }

    public static ItemUserCoverAddBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverAddBinding bind(View view, Object obj) {
        return (ItemUserCoverAddBinding) bind(obj, view, 2131558968);
    }
}
