package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class LayoutMessageCardBindingImpl extends LayoutMessageCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public LayoutMessageCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private LayoutMessageCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (TextView) objArr[7], (TextView) objArr[5], (LinearLayout) objArr[2], (LinearLayout) objArr[1], (ImageView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.contactAuthorAvatar.setTag(null);
        this.contactAuthorDes.setTag(null);
        this.contactMessage.setTag(null);
        this.contentCard.setTag(null);
        this.contentLayout.setTag(null);
        this.contentPicView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.titleMessage.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (55 == i) {
            setContent((String) obj);
        } else if (39 == i) {
            setAvatar((String) obj);
        } else if (272 == i) {
            setSubtitle((String) obj);
        } else if (220 == i) {
            setPic((String) obj);
        } else if (278 == i) {
            setTitle((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.LayoutMessageCardBinding
    public void setContent(String str) {
        this.mContent = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.LayoutMessageCardBinding
    public void setAvatar(String str) {
        this.mAvatar = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(39);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.LayoutMessageCardBinding
    public void setSubtitle(String str) {
        this.mSubtitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(272);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.LayoutMessageCardBinding
    public void setPic(String str) {
        this.mPic = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(220);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.LayoutMessageCardBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(278);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.LayoutMessageCardBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        View.OnClickListener onClickListener;
        int i3;
        int i4;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str3 = this.mContent;
        String str4 = this.mAvatar;
        String str5 = this.mSubtitle;
        String str6 = this.mPic;
        String str7 = this.mTitle;
        View.OnClickListener onClickListener2 = this.mClick;
        int i5 = 0;
        int i6 = ((j & 65) > 0 ? 1 : ((j & 65) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str3);
            if (i6 != 0) {
                j |= isEmpty ? 256 : 128;
            }
            i = isEmpty ? 8 : 0;
        } else {
            i = 0;
        }
        int i7 = ((j & 80) > 0 ? 1 : ((j & 80) == 0 ? 0 : -1));
        if (i7 != 0) {
            boolean isEmpty2 = TextUtils.isEmpty(str7);
            if (i7 != 0) {
                j |= isEmpty2 ? 1024 : 512;
            }
            if (isEmpty2) {
                i5 = 8;
            }
            i2 = i5;
        } else {
            i2 = 0;
        }
        int i8 = ((96 & j) > 0 ? 1 : ((96 & j) == 0 ? 0 : -1));
        if ((66 & j) != 0) {
            i4 = i2;
            i3 = i;
            Boolean bool = null;
            onClickListener = onClickListener2;
            str = str7;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contactAuthorAvatar, str4, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        } else {
            i4 = i2;
            i3 = i;
            str = str7;
            onClickListener = onClickListener2;
        }
        if ((64 & j) != 0) {
            ViewBindingAdapters.clipView(this.contactAuthorAvatar, "oval", null);
            String str8 = null;
            ViewBindingAdapters.clipView(this.contentLayout, str8, 8);
            ViewBindingAdapters.clipView(this.contentPicView, str8, 4);
        }
        if ((68 & j) != 0) {
            TextViewBindingAdapter.setText(this.contactAuthorDes, str5);
        }
        if ((j & 65) != 0) {
            this.contactMessage.setVisibility(i3);
            str2 = str6;
            TextViewBindingAdapters.setTextViewLinkable(this.contactMessage, str3, null, "textColorPrimary", null, null, null);
        } else {
            str2 = str6;
        }
        if (i8 != 0) {
            ViewBindingAdapters.clickListener(this.contentCard, onClickListener, null);
        }
        if ((72 & j) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contentPicView, str2, null, 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
        }
        if ((j & 80) != 0) {
            this.titleMessage.setVisibility(i4);
            TextViewBindingAdapters.setTextViewLinkable(this.titleMessage, str, null, "textColorPrimary", null, null, null);
        }
    }
}
