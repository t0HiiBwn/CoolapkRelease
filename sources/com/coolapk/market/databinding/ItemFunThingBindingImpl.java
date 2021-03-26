package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemFunThingBindingImpl extends ItemFunThingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final ImageView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFunThingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemFunThingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (AspectRatioImageView) objArr[2], (FrameLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coverView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.mboundView4 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.mboundView6 = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (198 == i) {
            setModel((FunThings) obj);
        } else if (121 == i) {
            setFollowNum((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFunThingBinding
    public void setModel(FunThings funThings) {
        this.mModel = funThings;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFunThingBinding
    public void setFollowNum(String str) {
        this.mFollowNum = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(121);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFunThingBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FunThings funThings = this.mModel;
        String str6 = this.mFollowNum;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (funThings != null) {
                str5 = funThings.getCoverPic();
                str4 = funThings.getTitle();
                userInfo = funThings.getUserInfo();
            } else {
                userInfo = null;
                str5 = null;
                str4 = null;
            }
            if (userInfo != null) {
                str3 = userInfo.getUserName();
                str2 = userInfo.getUserAvatar();
                str = str5;
            } else {
                str = str5;
                str3 = null;
                str2 = null;
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        int i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if (i != 0) {
            Boolean bool = null;
            String str7 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str, AppCompatResources.getDrawable(this.coverView.getContext(), 2131231707), 0, 0, bool, bool, bool, bool, bool, str7, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            TextViewBindingAdapter.setText(this.mboundView3, str4);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView4, str2, null, 0, 0, bool, bool, bool, bool, bool, str7, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            TextViewBindingAdapter.setText(this.mboundView5, str3);
        }
        if (i3 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
        if ((j & 8) != 0) {
            ViewBindingAdapters.clipView(this.mboundView4, "oval", null);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, str6);
        }
    }
}
