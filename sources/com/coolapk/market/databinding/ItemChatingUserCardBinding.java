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
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemChatingUserCardBinding extends ViewDataBinding {
    public final ImageView contactAuthorAvatar;
    public final TextView contactAuthorDes;
    public final CoolEllipsizeTextView contactMessage;
    public final LinearLayout contentCard;
    public final LinearLayout contentLayout;
    public final RoundedImageView contentPicView;
    public final RelativeLayout itemView;
    @Bindable
    protected String mAvatar;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mContent;
    @Bindable
    protected String mContentPic;
    @Bindable
    protected Message mModel;
    @Bindable
    protected String mPic;
    @Bindable
    protected Boolean mShowError;
    @Bindable
    protected Boolean mShowPic;
    @Bindable
    protected String mSubtitle;
    @Bindable
    protected String mTitle;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout messageViewRoot;
    public final TextView titleMessage;
    public final ImageView userAvatarView;

    public abstract void setAvatar(String str);

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setContent(String str);

    public abstract void setContentPic(String str);

    public abstract void setModel(Message message);

    public abstract void setPic(String str);

    public abstract void setShowError(Boolean bool);

    public abstract void setShowPic(Boolean bool);

    public abstract void setSubtitle(String str);

    public abstract void setTitle(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemChatingUserCardBinding(Object obj, View view, int i, ImageView imageView, TextView textView, CoolEllipsizeTextView coolEllipsizeTextView, LinearLayout linearLayout, LinearLayout linearLayout2, RoundedImageView roundedImageView, RelativeLayout relativeLayout, LinearLayout linearLayout3, TextView textView2, ImageView imageView2) {
        super(obj, view, i);
        this.contactAuthorAvatar = imageView;
        this.contactAuthorDes = textView;
        this.contactMessage = coolEllipsizeTextView;
        this.contentCard = linearLayout;
        this.contentLayout = linearLayout2;
        this.contentPicView = roundedImageView;
        this.itemView = relativeLayout;
        this.messageViewRoot = linearLayout3;
        this.titleMessage = textView2;
        this.userAvatarView = imageView2;
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

    public String getContentPic() {
        return this.mContentPic;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getSubtitle() {
        return this.mSubtitle;
    }

    public static ItemChatingUserCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingUserCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatingUserCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558651, viewGroup, z, obj);
    }

    public static ItemChatingUserCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingUserCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatingUserCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558651, null, false, obj);
    }

    public static ItemChatingUserCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChatingUserCardBinding bind(View view, Object obj) {
        return (ItemChatingUserCardBinding) bind(obj, view, 2131558651);
    }
}
