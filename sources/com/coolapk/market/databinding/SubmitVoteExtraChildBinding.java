package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitVoteExtraChildBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final TextView descriptionView;
    public final EditText editText;
    public final ImageView extraImageView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    public final TextView titleView;

    protected SubmitVoteExtraChildBinding(Object obj, View view, int i, ImageView imageView2, TextView textView, EditText editText2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.arrowView = imageView2;
        this.descriptionView = textView;
        this.editText = editText2;
        this.extraImageView = imageView3;
        this.imageView = imageView4;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public static SubmitVoteExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVoteExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitVoteExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559174, viewGroup, z, obj);
    }

    public static SubmitVoteExtraChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVoteExtraChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitVoteExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559174, null, false, obj);
    }

    public static SubmitVoteExtraChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVoteExtraChildBinding bind(View view, Object obj) {
        return (SubmitVoteExtraChildBinding) bind(obj, view, 2131559174);
    }
}
