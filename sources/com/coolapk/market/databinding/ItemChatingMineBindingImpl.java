package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Message;
import com.coolapk.market.widget.view.ShapedImageView;

public class ItemChatingMineBindingImpl extends ItemChatingMineBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemChatingMineBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemChatingMineBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[0], (TextView) objArr[5], (LinearLayout) objArr[2], (ShapedImageView) objArr[4], (TextView) objArr[3], (ImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.errorPicView.setTag(null);
        this.messageView.setTag(null);
        this.picView.setTag(null);
        this.textView.setTag(null);
        this.userAvatarView.setTag(null);
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
        if (198 == i) {
            setModel((Message) obj);
        } else if (255 == i) {
            setShowPic((Boolean) obj);
        } else if (250 == i) {
            setShowError((Boolean) obj);
        } else if (221 == i) {
            setPic((String) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemChatingMineBinding
    public void setModel(Message message) {
        this.mModel = message;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingMineBinding
    public void setShowPic(Boolean bool) {
        this.mShowPic = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(255);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingMineBinding
    public void setShowError(Boolean bool) {
        this.mShowError = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(250);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingMineBinding
    public void setPic(String str) {
        this.mPic = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(221);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingMineBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingMineBinding
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
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        OnBitmapTransformListener onBitmapTransformListener;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Message message = this.mModel;
        Boolean bool = this.mShowPic;
        Boolean bool2 = this.mShowError;
        String str3 = this.mPic;
        OnBitmapTransformListener onBitmapTransformListener2 = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 81) != 0) {
            String message2 = ((j & 65) == 0 || message == null) ? null : message.getMessage();
            if (message != null) {
                str = message.getFromUserAvatar();
                str2 = message2;
            } else {
                str2 = message2;
                str = null;
            }
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 70) != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean safeUnbox2 = ViewDataBinding.safeUnbox(bool2);
            if ((j & 66) != 0) {
                j |= safeUnbox ? 256 : 128;
            }
            if ((j & 68) != 0) {
                j |= safeUnbox2 ? 1024 : 512;
            }
            i3 = 8;
            i2 = ((j & 66) == 0 || safeUnbox) ? 0 : 8;
            i = ((j & 68) == 0 || safeUnbox2) ? 0 : 8;
            boolean z = safeUnbox | safeUnbox2;
            if ((j & 70) != 0) {
                j |= z ? 4096 : 2048;
            }
            if (!z) {
                i3 = 0;
            }
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i4 = ((72 & j) > 0 ? 1 : ((72 & j) == 0 ? 0 : -1));
        if ((96 & j) != 0) {
            Boolean bool3 = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.picView, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool3);
        }
        if ((j & 68) != 0) {
            this.errorPicView.setVisibility(i);
        }
        if ((64 & j) != 0) {
            ThemeBindingAdapters.setBackgroundTint(this.messageView, "colorAccent");
        }
        if ((j & 70) != 0) {
            this.messageView.setVisibility(i3);
        }
        if ((j & 66) != 0) {
            this.picView.setVisibility(i2);
        }
        if (i4 != 0) {
            Boolean bool4 = null;
            onBitmapTransformListener = onBitmapTransformListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.picView, str3, null, 2131231702, 0, bool4, bool4, bool4, false, bool4, null, null, null, bool4, bool4, bool4, null, true);
        } else {
            onBitmapTransformListener = onBitmapTransformListener2;
        }
        if ((j & 65) != 0) {
            String str4 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.textView, str2, null, str4, null, null, str4);
        }
        if ((j & 81) != 0) {
            Boolean bool5 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool5, bool5, bool5, bool5, bool5, null, null, onBitmapTransformListener, bool5, bool5, bool5, null, bool5);
        }
    }
}
