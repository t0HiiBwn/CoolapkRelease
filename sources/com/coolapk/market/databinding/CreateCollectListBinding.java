package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.view.KeyBoardLayout;

public abstract class CreateCollectListBinding extends ViewDataBinding {
    public final LinearLayout addPicView;
    public final ImageView arrowView;
    public final ImageView closeView;
    public final FrameLayout contentView;
    public final FrameLayout coverView;
    public final TextView descriptionView;
    public final EditText etDes;
    public final EditText etTitle;
    public final FrameLayout fakeKeyboardExtraContainer;
    public final LinearLayout fakeKeyboardView;
    public final ImageView imageView;
    public final AspectRatioImageView ivCover;
    public final KeyBoardLayout keyBoardInteractLayout;
    public final LinearLayout lvTop;
    @Bindable
    protected String mActionTitle;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mToolbarTitle;
    public final LinearLayout picAddPh;
    public final TextView picAddTv;
    public final ImageView picCloseView;
    public final LinearLayout relativeView;
    public final TextView submitView;
    public final SwitchCompat switchView;
    public final TextView titleView;
    public final LinearLayout toolbarLayout;

    public abstract void setActionTitle(String str);

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setToolbarTitle(String str);

    protected CreateCollectListBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, EditText editText, EditText editText2, FrameLayout frameLayout3, LinearLayout linearLayout2, ImageView imageView4, AspectRatioImageView aspectRatioImageView, KeyBoardLayout keyBoardLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, ImageView imageView5, LinearLayout linearLayout5, TextView textView3, SwitchCompat switchCompat, TextView textView4, LinearLayout linearLayout6) {
        super(obj, view, i);
        this.addPicView = linearLayout;
        this.arrowView = imageView2;
        this.closeView = imageView3;
        this.contentView = frameLayout;
        this.coverView = frameLayout2;
        this.descriptionView = textView;
        this.etDes = editText;
        this.etTitle = editText2;
        this.fakeKeyboardExtraContainer = frameLayout3;
        this.fakeKeyboardView = linearLayout2;
        this.imageView = imageView4;
        this.ivCover = aspectRatioImageView;
        this.keyBoardInteractLayout = keyBoardLayout;
        this.lvTop = linearLayout3;
        this.picAddPh = linearLayout4;
        this.picAddTv = textView2;
        this.picCloseView = imageView5;
        this.relativeView = linearLayout5;
        this.submitView = textView3;
        this.switchView = switchCompat;
        this.titleView = textView4;
        this.toolbarLayout = linearLayout6;
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

    public static CreateCollectListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateCollectListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CreateCollectListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558490, viewGroup, z, obj);
    }

    public static CreateCollectListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateCollectListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CreateCollectListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558490, null, false, obj);
    }

    public static CreateCollectListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateCollectListBinding bind(View view, Object obj) {
        return (CreateCollectListBinding) bind(obj, view, 2131558490);
    }
}
