package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ImageUrl;

public abstract class CreateGoodsBinding extends ViewDataBinding {
    public final TextView actionDone;
    public final LinearLayout containerView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected ImageUrl mImage;
    public final RadioGroup radioGroup;
    public final EditText titleEditText;
    public final EditText urlEditText;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setImage(ImageUrl imageUrl);

    protected CreateGoodsBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, RadioGroup radioGroup2, EditText editText, EditText editText2) {
        super(obj, view, i);
        this.actionDone = textView;
        this.containerView = linearLayout;
        this.iconView = imageView;
        this.radioGroup = radioGroup2;
        this.titleEditText = editText;
        this.urlEditText = editText2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public ImageUrl getImage() {
        return this.mImage;
    }

    public static CreateGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CreateGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558492, viewGroup, z, obj);
    }

    public static CreateGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CreateGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558492, null, false, obj);
    }

    public static CreateGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CreateGoodsBinding bind(View view, Object obj) {
        return (CreateGoodsBinding) bind(obj, view, 2131558492);
    }
}
