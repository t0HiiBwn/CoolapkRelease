package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Message;
import com.coolapk.market.widget.view.ShapedImageView;

public abstract class ItemChatingMineBinding extends ViewDataBinding {
    public final RelativeLayout cardView;
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
    public final ShapedImageView picView;
    public final TextView textView;
    public final ImageView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Message message);

    public abstract void setPic(String str);

    public abstract void setShowError(Boolean bool);

    public abstract void setShowPic(Boolean bool);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemChatingMineBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView2, LinearLayout linearLayout, ShapedImageView shapedImageView, TextView textView3, ImageView imageView) {
        super(obj, view, i);
        this.cardView = relativeLayout;
        this.errorPicView = textView2;
        this.messageView = linearLayout;
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

    public static ItemChatingMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingMineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatingMineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558654, viewGroup, z, obj);
    }

    public static ItemChatingMineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingMineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatingMineBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558654, null, false, obj);
    }

    public static ItemChatingMineBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingMineBinding bind(View view, Object obj) {
        return (ItemChatingMineBinding) bind(obj, view, 2131558654);
    }
}
