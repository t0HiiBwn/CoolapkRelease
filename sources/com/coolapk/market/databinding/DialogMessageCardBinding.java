package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class DialogMessageCardBinding extends ViewDataBinding {
    public final LinearLayout authorView;
    public final ImageView contactAuthorAvatar;
    public final TextView contactAuthorDes;
    public final ImageView contactAvatarView;
    public final CoolEllipsizeTextView contactMessage;
    public final TextView contactUserName;
    public final LinearLayout contentCard;
    public final LinearLayout contentLayout;
    public final RoundedImageView contentPicView;
    public final TextView dialogCancel;
    public final TextView dialogConfirm;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Contacts mContact;
    @Bindable
    protected String mContent;
    @Bindable
    protected String mContentTitle;
    @Bindable
    protected String mFromAvatar;
    @Bindable
    protected String mFromTitle;
    @Bindable
    protected String mPic;
    @Bindable
    protected String mToAvatar;
    @Bindable
    protected String mToTitle;
    public final TextView titleMessage;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setContact(Contacts contacts);

    public abstract void setContent(String str);

    public abstract void setContentTitle(String str);

    public abstract void setFromAvatar(String str);

    public abstract void setFromTitle(String str);

    public abstract void setPic(String str);

    public abstract void setToAvatar(String str);

    public abstract void setToTitle(String str);

    protected DialogMessageCardBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, ImageView imageView2, CoolEllipsizeTextView coolEllipsizeTextView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, RoundedImageView roundedImageView, TextView textView3, TextView textView4, ProgressBar progressBar, TextView textView5) {
        super(obj, view, i);
        this.authorView = linearLayout;
        this.contactAuthorAvatar = imageView;
        this.contactAuthorDes = textView;
        this.contactAvatarView = imageView2;
        this.contactMessage = coolEllipsizeTextView;
        this.contactUserName = textView2;
        this.contentCard = linearLayout2;
        this.contentLayout = linearLayout3;
        this.contentPicView = roundedImageView;
        this.dialogCancel = textView3;
        this.dialogConfirm = textView4;
        this.loadingView = progressBar;
        this.titleMessage = textView5;
    }

    public String getToTitle() {
        return this.mToTitle;
    }

    public String getToAvatar() {
        return this.mToAvatar;
    }

    public String getContentTitle() {
        return this.mContentTitle;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getFromTitle() {
        return this.mFromTitle;
    }

    public String getFromAvatar() {
        return this.mFromAvatar;
    }

    public String getPic() {
        return this.mPic;
    }

    public Contacts getContact() {
        return this.mContact;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static DialogMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558530, viewGroup, z, obj);
    }

    public static DialogMessageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMessageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558530, null, false, obj);
    }

    public static DialogMessageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMessageCardBinding bind(View view, Object obj) {
        return (DialogMessageCardBinding) bind(obj, view, 2131558530);
    }
}
