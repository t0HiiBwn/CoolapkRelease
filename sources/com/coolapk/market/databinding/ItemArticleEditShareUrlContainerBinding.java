package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.viewholder.GoodsSimpleInfo;

public abstract class ItemArticleEditShareUrlContainerBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected GoodsSimpleInfo mModel;
    @Bindable
    protected String mSubTitle;
    public final Space spaceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(GoodsSimpleInfo goodsSimpleInfo);

    public abstract void setSubTitle(String str);

    protected ItemArticleEditShareUrlContainerBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, Space space) {
        super(obj, view, i);
        this.closeView = imageView;
        this.itemView = frameLayout;
        this.spaceView = space;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public GoodsSimpleInfo getModel() {
        return this.mModel;
    }

    public static ItemArticleEditShareUrlContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleEditShareUrlContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleEditShareUrlContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558617, viewGroup, z, obj);
    }

    public static ItemArticleEditShareUrlContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleEditShareUrlContainerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleEditShareUrlContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558617, null, false, obj);
    }

    public static ItemArticleEditShareUrlContainerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleEditShareUrlContainerBinding bind(View view, Object obj) {
        return (ItemArticleEditShareUrlContainerBinding) bind(obj, view, 2131558617);
    }
}
