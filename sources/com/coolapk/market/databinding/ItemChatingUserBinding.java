package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Message;
import com.coolapk.market.widget.view.ShapedImageView;

public abstract class ItemChatingUserBinding extends ViewDataBinding {
    public final FrameLayout cardView;
    public final TextView errorPicView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Message mModel;
    @Bindable
    protected String mPic;
    @Bindable
    protected Boolean mShowError;
    @Bindable
    protected Boolean mShowPic;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout messageView;
    public final LinearLayout messageViewRoot;
    public final ShapedImageView picView;
    public final TextView textView;
    public final ImageView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Message message);

    public abstract void setPic(String str);

    public abstract void setShowError(Boolean bool);

    public abstract void setShowPic(Boolean bool);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemChatingUserBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, ShapedImageView shapedImageView, TextView textView3, ImageView imageView) {
        super(obj, view, i);
        this.cardView = frameLayout;
        this.errorPicView = textView2;
        this.messageView = linearLayout;
        this.messageViewRoot = linearLayout2;
        this.picView = shapedImageView;
        this.textView = textView3;
        this.userAvatarView = imageView;
    }

    public Message getModel() {
        return this.mModel;
    }

    public String getPic() {
        return this.mPic;
    }

    public Boolean getShowError() {
        return this.mShowError;
    }

    public Boolean getShowPic() {
        return this.mShowPic;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemChatingUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatingUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558650, viewGroup, z, obj);
    }

    public static ItemChatingUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatingUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558650, null, false, obj);
    }

    public static ItemChatingUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingUserBinding bind(View view, Object obj) {
        return (ItemChatingUserBinding) bind(obj, view, 2131558650);
    }
}
