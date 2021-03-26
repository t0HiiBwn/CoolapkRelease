package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.view.KeyBoardLayout;

public abstract class CreateFunThingsBinding extends ViewDataBinding {
    public final FrameLayout addPicView;
    public final ImageView closeView;
    public final FrameLayout contentView;
    public final EditText etDes;
    public final EditText etTitle;
    public final FrameLayout fakeKeyboardExtraContainer;
    public final LinearLayout fakeKeyboardView;
    public final AspectRatioImageView ivCover;
    public final KeyBoardLayout keyBoardInteractLayout;
    public final LinearLayout lvTop;
    @Bindable
    protected String mActionTitle;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mToolbarTitle;
    public final ImageView picCloseView;
    public final LinearLayout relativeView;
    public final TextView submitView;
    public final TextView titleView;
    public final LinearLayout toolbarLayout;

    public abstract void setActionTitle(String str);

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setToolbarTitle(String str);

    protected CreateFunThingsBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, EditText editText, EditText editText2, FrameLayout frameLayout3, LinearLayout linearLayout, AspectRatioImageView aspectRatioImageView, KeyBoardLayout keyBoardLayout, LinearLayout linearLayout2, ImageView imageView2, LinearLayout linearLayout3, TextView textView, TextView textView2, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.addPicView = frameLayout;
        this.closeView = imageView;
        this.contentView = frameLayout2;
        this.etDes = editText;
        this.etTitle = editText2;
        this.fakeKeyboardExtraContainer = frameLayout3;
        this.fakeKeyboardView = linearLayout;
        this.ivCover = aspectRatioImageView;
        this.keyBoardInteractLayout = keyBoardLayout;
        this.lvTop = linearLayout2;
        this.picCloseView = imageView2;
        this.relativeView = linearLayout3;
        this.submitView = textView;
        this.titleView = textView2;
        this.toolbarLayout = linearLayout4;
    }

    public String getToolbarTitle() {
        return this.mToolbarTitle;
    }

    public String getActionTitle() {
        return this.mActionTitle;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static CreateFunThingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateFunThingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CreateFunThingsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558490, viewGroup, z, obj);
    }

    public static CreateFunThingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateFunThingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CreateFunThingsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558490, null, false, obj);
    }

    public static CreateFunThingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateFunThingsBinding bind(View view, Object obj) {
        return (CreateFunThingsBinding) bind(obj, view, 2131558490);
    }
}
