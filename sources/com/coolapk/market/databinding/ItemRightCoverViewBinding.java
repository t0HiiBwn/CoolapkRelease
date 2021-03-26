package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;

public abstract class ItemRightCoverViewBinding extends ViewDataBinding {
    public final TextView contentView;
    public final ImageView extraImageView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mMessage;
    @Bindable
    protected String mPic;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setMessage(String str);

    public abstract void setPic(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemRightCoverViewBinding(Object obj, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.contentView = textView;
        this.extraImageView = imageView;
        this.rootView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getPic() {
        return this.mPic;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemRightCoverViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRightCoverViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRightCoverViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558909, viewGroup, z, obj);
    }

    public static ItemRightCoverViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRightCoverViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRightCoverViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558909, null, false, obj);
    }

    public static ItemRightCoverViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRightCoverViewBinding bind(View view, Object obj) {
        return (ItemRightCoverViewBinding) bind(obj, view, 2131558909);
    }
}
