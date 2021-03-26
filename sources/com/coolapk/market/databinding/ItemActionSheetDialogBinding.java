package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemActionSheetDialogBinding extends ViewDataBinding {
    public final TextView bandageTextView;
    public final FrameLayout expandView;
    public final ImageView iconView;
    public final View rightDividerView;
    public final RelativeLayout rootView;
    public final TextView titleView;

    protected ItemActionSheetDialogBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, ImageView imageView, View view2, RelativeLayout relativeLayout, TextView textView2) {
        super(obj, view, i);
        this.bandageTextView = textView;
        this.expandView = frameLayout;
        this.iconView = imageView;
        this.rightDividerView = view2;
        this.rootView = relativeLayout;
        this.titleView = textView2;
    }

    public static ItemActionSheetDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemActionSheetDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemActionSheetDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558577, viewGroup, z, obj);
    }

    public static ItemActionSheetDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemActionSheetDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemActionSheetDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558577, null, false, obj);
    }

    public static ItemActionSheetDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemActionSheetDialogBinding bind(View view, Object obj) {
        return (ItemActionSheetDialogBinding) bind(obj, view, 2131558577);
    }
}
