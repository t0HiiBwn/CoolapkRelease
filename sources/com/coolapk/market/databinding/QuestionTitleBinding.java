package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class QuestionTitleBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final EditText editText;
    public final LinearLayout keyBoardInteractLayout;
    @Bindable
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final LinearLayout relativeView;
    public final TextView submitView;
    public final LinearLayout toolbarLayout;
    public final TextView warningView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected QuestionTitleBinding(Object obj, View view, int i, ImageView imageView, EditText editText2, LinearLayout linearLayout, RecyclerView recyclerView2, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, TextView textView2) {
        super(obj, view, i);
        this.closeView = imageView;
        this.editText = editText2;
        this.keyBoardInteractLayout = linearLayout;
        this.recyclerView = recyclerView2;
        this.relativeView = linearLayout2;
        this.submitView = textView;
        this.toolbarLayout = linearLayout3;
        this.warningView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static QuestionTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (QuestionTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559120, viewGroup, z, obj);
    }

    public static QuestionTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (QuestionTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559120, null, false, obj);
    }

    public static QuestionTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionTitleBinding bind(View view, Object obj) {
        return (QuestionTitleBinding) bind(obj, view, 2131559120);
    }
}
