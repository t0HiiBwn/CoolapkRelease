package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;

public abstract class ItemTripleAvatarViewPartBinding extends ViewDataBinding {
    @Bindable
    protected String mAvatar1;
    @Bindable
    protected String mAvatar2;
    @Bindable
    protected String mAvatar3;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;

    public abstract void setAvatar1(String str);

    public abstract void setAvatar2(String str);

    public abstract void setAvatar3(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemTripleAvatarViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.rootView = linearLayout;
    }

    public String getAvatar1() {
        return this.mAvatar1;
    }

    public String getAvatar2() {
        return this.mAvatar2;
    }

    public String getAvatar3() {
        return this.mAvatar3;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemTripleAvatarViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTripleAvatarViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTripleAvatarViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558970, viewGroup, z, obj);
    }

    public static ItemTripleAvatarViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTripleAvatarViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTripleAvatarViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558970, null, false, obj);
    }

    public static ItemTripleAvatarViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTripleAvatarViewPartBinding bind(View view, Object obj) {
        return (ItemTripleAvatarViewPartBinding) bind(obj, view, 2131558970);
    }
}
