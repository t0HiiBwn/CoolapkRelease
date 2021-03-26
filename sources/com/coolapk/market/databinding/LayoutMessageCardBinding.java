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

public abstract class LayoutMessageCardBinding extends ViewDataBinding {
    public final ImageView contactAuthorAvatar;
    public final TextView contactAuthorDes;
    public final TextView contactMessage;
    public final LinearLayout contentCard;
    public final LinearLayout contentLayout;
    public final ImageView contentPicView;
    @Bindable
    protected String mAvatar;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mContent;
    @Bindable
    protected String mPic;
    @Bindable
    protected String mSubtitle;
    @Bindable
    protected String mTitle;
    public final TextView titleMessage;

    public abstract void setAvatar(String str);

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setContent(String str);

    public abstract void setPic(String str);

    public abstract void setSubtitle(String str);

    public abstract void setTitle(String str);

    protected LayoutMessageCardBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, TextView textView3) {
        super(obj, view, i);
        this.contactAuthorAvatar = imageView;
        this.contactAuthorDes = textView;
        this.contactMessage = textView2;
        this.contentCard = linearLayout;
        this.contentLayout = linearLayout2;
        this.contentPicView = imageView2;
        this.titleMessage = textView3;
    }

    public String getPic() {
        return this.mPic;
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

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static LayoutMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558998, viewGroup, z, obj);
    }

    public static LayoutMessageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutMessageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558998, null, false, obj);
    }

    public static LayoutMessageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutMessageCardBinding bind(View view, Object obj) {
        return (LayoutMessageCardBinding) bind(obj, view, 2131558998);
    }
}
