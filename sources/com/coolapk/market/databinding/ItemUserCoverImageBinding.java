package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.SquareImageView;

public abstract class ItemUserCoverImageBinding extends ViewDataBinding {
    public final FrameLayout contentView;
    public final TextView editView;
    public final View foregroundView;
    public final SquareImageView imageView;
    public final TextView textView;

    protected ItemUserCoverImageBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView2, View view2, SquareImageView squareImageView, TextView textView3) {
        super(obj, view, i);
        this.contentView = frameLayout;
        this.editView = textView2;
        this.foregroundView = view2;
        this.imageView = squareImageView;
        this.textView = textView3;
    }

    public static ItemUserCoverImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserCoverImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558976, viewGroup, z, obj);
    }

    public static ItemUserCoverImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserCoverImageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558976, null, false, obj);
    }

    public static ItemUserCoverImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserCoverImageBinding bind(View view, Object obj) {
        return (ItemUserCoverImageBinding) bind(obj, view, 2131558976);
    }
}
