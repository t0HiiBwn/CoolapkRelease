package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.ControlGifImageView;
import com.coolapk.market.widget.view.DividerView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemProductMediaBinding extends ViewDataBinding {
    public final DividerView dividerView;
    public final ControlGifImageView imageView;
    public final MaxWidthFrameLayout itemView;
    @Bindable
    protected String mImgUrl;
    public final FrameLayout videoMaskView;

    public abstract void setImgUrl(String str);

    protected ItemProductMediaBinding(Object obj, View view, int i, DividerView dividerView2, ControlGifImageView controlGifImageView, MaxWidthFrameLayout maxWidthFrameLayout, FrameLayout frameLayout) {
        super(obj, view, i);
        this.dividerView = dividerView2;
        this.imageView = controlGifImageView;
        this.itemView = maxWidthFrameLayout;
        this.videoMaskView = frameLayout;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public static ItemProductMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductMediaBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558868, viewGroup, z, obj);
    }

    public static ItemProductMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductMediaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductMediaBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558868, null, false, obj);
    }

    public static ItemProductMediaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductMediaBinding bind(View view, Object obj) {
        return (ItemProductMediaBinding) bind(obj, view, 2131558868);
    }
}
