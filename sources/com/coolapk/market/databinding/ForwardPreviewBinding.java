package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ForwardPreviewBinding extends ViewDataBinding {
    public final LinearLayout bottomView;
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView forwardAndReplyTextView;
    public final CheckBox forwardAndReplyView;
    public final TextView fullScreenButton;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    public final DrawSystemBarFrameLayout maskView;
    public final TextView postButton;
    public final RecyclerView recyclerView;
    public final CoolEllipsizeTextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ForwardPreviewBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, EditText editText2, TextView textView3, CheckBox checkBox, TextView textView4, ImageView imageView, DrawSystemBarFrameLayout drawSystemBarFrameLayout, TextView textView5, RecyclerView recyclerView2, CoolEllipsizeTextView coolEllipsizeTextView) {
        super(obj, view, i);
        this.bottomView = linearLayout;
        this.cancelButton = textView2;
        this.contentView = linearLayout2;
        this.editText = editText2;
        this.forwardAndReplyTextView = textView3;
        this.forwardAndReplyView = checkBox;
        this.fullScreenButton = textView4;
        this.iconView = imageView;
        this.maskView = drawSystemBarFrameLayout;
        this.postButton = textView5;
        this.recyclerView = recyclerView2;
        this.textView = coolEllipsizeTextView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ForwardPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ForwardPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ForwardPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558569, viewGroup, z, obj);
    }

    public static ForwardPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ForwardPreviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ForwardPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558569, null, false, obj);
    }

    public static ForwardPreviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ForwardPreviewBinding bind(View view, Object obj) {
        return (ForwardPreviewBinding) bind(obj, view, 2131558569);
    }
}
