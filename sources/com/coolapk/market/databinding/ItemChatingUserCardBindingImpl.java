package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Message;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemChatingUserCardBindingImpl extends ItemChatingUserCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362305, 9);
    }

    public ItemChatingUserCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemChatingUserCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[7], (TextView) objArr[8], (CoolEllipsizeTextView) objArr[6], (LinearLayout) objArr[9], (LinearLayout) objArr[3], (RoundedImageView) objArr[4], (RelativeLayout) objArr[0], (LinearLayout) objArr[2], (TextView) objArr[5], (ImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.contactAuthorAvatar.setTag(null);
        this.contactAuthorDes.setTag(null);
        this.contactMessage.setTag(null);
        this.contentLayout.setTag(null);
        this.contentPicView.setTag(null);
        this.itemView.setTag(null);
        this.messageViewRoot.setTag(null);
        this.titleMessage.setTag(null);
        this.userAvatarView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048;
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
        if (197 == i) {
            setModel((Message) obj);
        } else if (56 == i) {
            setContentPic((String) obj);
        } else if (220 == i) {
            setPic((String) obj);
        } else if (55 == i) {
            setContent((String) obj);
        } else if (254 == i) {
            setShowPic((Boolean) obj);
        } else if (39 == i) {
            setAvatar((String) obj);
        } else if (272 == i) {
            setSubtitle((String) obj);
        } else if (249 == i) {
            setShowError((Boolean) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (278 == i) {
            setTitle((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setModel(Message message) {
        this.mModel = message;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setContentPic(String str) {
        this.mContentPic = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(56);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setPic(String str) {
        this.mPic = str;
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setContent(String str) {
        this.mContent = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setShowPic(Boolean bool) {
        this.mShowPic = bool;
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setAvatar(String str) {
        this.mAvatar = str;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(39);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setSubtitle(String str) {
        this.mSubtitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(272);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setShowError(Boolean bool) {
        this.mShowError = bool;
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(278);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserCardBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        int i3;
        OnBitmapTransformListener onBitmapTransformListener;
        int i4;
        View.OnClickListener onClickListener;
        int i5;
        String str2;
        OnBitmapTransformListener onBitmapTransformListener2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Message message = this.mModel;
        String str3 = this.mContentPic;
        String str4 = this.mContent;
        String str5 = this.mAvatar;
        String str6 = this.mSubtitle;
        OnBitmapTransformListener onBitmapTransformListener3 = this.mTransformer;
        String str7 = this.mTitle;
        View.OnClickListener onClickListener2 = this.mClick;
        String fromUserAvatar = ((j & 2305) == 0 || message == null) ? null : message.getFromUserAvatar();
        int i6 = 0;
        int i7 = ((j & 2050) > 0 ? 1 : ((j & 2050) == 0 ? 0 : -1));
        if (i7 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str3);
            if (i7 != 0) {
                j |= isEmpty ? 32768 : 16384;
            }
            i = isEmpty ? 8 : 0;
        } else {
            i = 0;
        }
        if ((j & 2568) != 0) {
            int i8 = ((j & 2056) > 0 ? 1 : ((j & 2056) == 0 ? 0 : -1));
            if (i8 != 0) {
                boolean isEmpty2 = TextUtils.isEmpty(str4);
                if (i8 != 0) {
                    j |= isEmpty2 ? 131072 : 65536;
                }
                if (isEmpty2) {
                    i3 = 8;
                    boolean isEmpty3 = TextUtils.isEmpty(str7);
                    if ((j & 2568) != 0) {
                        j |= isEmpty3 ? 524288 : 262144;
                    }
                    if ((j & 2560) != 0) {
                        j |= isEmpty3 ? 2097152 : 1048576;
                    }
                    String str8 = !isEmpty3 ? "textColorPrimary" : "textColorSecondary";
                    i2 = ((j & 2560) != 0 || !isEmpty3) ? 0 : 8;
                    str = str8;
                }
            }
            i3 = 0;
            boolean isEmpty3 = TextUtils.isEmpty(str7);
            if ((j & 2568) != 0) {
            }
            if ((j & 2560) != 0) {
            }
            if (!isEmpty3) {
            }
            i2 = ((j & 2560) != 0 || !isEmpty3) ? 0 : 8;
            str = str8;
        } else {
            str = null;
            i3 = 0;
            i2 = 0;
        }
        int i9 = ((j & 2080) > 0 ? 1 : ((j & 2080) == 0 ? 0 : -1));
        if (i9 != 0) {
            boolean isEmpty4 = TextUtils.isEmpty(str5);
            if (i9 != 0) {
                j |= isEmpty4 ? 8192 : 4096;
            }
            if (isEmpty4) {
                i6 = 8;
            }
        }
        int i10 = ((j & 2112) > 0 ? 1 : ((j & 2112) == 0 ? 0 : -1));
        int i11 = ((j & 3072) > 0 ? 1 : ((j & 3072) == 0 ? 0 : -1));
        if ((j & 2080) != 0) {
            this.contactAuthorAvatar.setVisibility(i6);
            i5 = i3;
            i4 = i;
            onBitmapTransformListener = onBitmapTransformListener3;
            onClickListener = onClickListener2;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contactAuthorAvatar, str5, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        } else {
            onBitmapTransformListener = onBitmapTransformListener3;
            i5 = i3;
            i4 = i;
            onClickListener = onClickListener2;
        }
        if ((2048 & j) != 0) {
            ViewBindingAdapters.clipView(this.contactAuthorAvatar, "oval", null);
            ViewBindingAdapters.clipView(this.messageViewRoot, null, 8);
        }
        if (i10 != 0) {
            TextViewBindingAdapters.setTextViewLinkable(this.contactAuthorDes, str6, null, "textColorSecondary", null, null, null);
        }
        if ((j & 2560) != 0) {
            str2 = str;
            ThemeBindingAdapters.setTextColor(this.contactMessage, str2);
            this.titleMessage.setVisibility(i2);
            TextViewBindingAdapters.setTextViewLinkable(this.titleMessage, str7, null, "textColorPrimary", null, null, null);
        } else {
            str2 = str;
        }
        if ((j & 2056) != 0) {
            this.contactMessage.setVisibility(i5);
        }
        if ((j & 2568) != 0) {
            TextViewBindingAdapters.setTextViewLinkable(this.contactMessage, str4, null, str2, null, null, null);
        }
        if (i11 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.contentLayout, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
        }
        if ((j & 2050) != 0) {
            this.contentPicView.setVisibility(i4);
            onBitmapTransformListener2 = onBitmapTransformListener;
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contentPicView, str3, AppCompatResources.getDrawable(this.contentPicView.getContext(), 2131231691), 0, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, bool3, bool3, null, bool3);
        } else {
            onBitmapTransformListener2 = onBitmapTransformListener;
        }
        if ((j & 2305) != 0) {
            Boolean bool4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, fromUserAvatar, null, 2131231152, 0, bool4, bool4, bool4, bool4, bool4, null, null, onBitmapTransformListener2, bool4, bool4, bool4, null, bool4);
        }
    }
}
