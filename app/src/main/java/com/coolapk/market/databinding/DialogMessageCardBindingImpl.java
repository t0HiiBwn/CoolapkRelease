package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public class DialogMessageCardBindingImpl extends DialogMessageCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362093, 13);
    }

    public DialogMessageCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private DialogMessageCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[13], (ImageView) objArr[8], (TextView) objArr[9], (ImageView) objArr[1], (CoolEllipsizeTextView) objArr[7], (TextView) objArr[2], (LinearLayout) objArr[4], (LinearLayout) objArr[3], (RoundedImageView) objArr[5], (TextView) objArr[10], (TextView) objArr[11], (ProgressBar) objArr[12], (TextView) objArr[6]);
        this.mDirtyFlags = -1;
        this.contactAuthorAvatar.setTag(null);
        this.contactAuthorDes.setTag(null);
        this.contactAvatarView.setTag(null);
        this.contactMessage.setTag(null);
        this.contactUserName.setTag(null);
        this.contentCard.setTag(null);
        this.contentLayout.setTag(null);
        this.contentPicView.setTag(null);
        this.dialogCancel.setTag(null);
        this.dialogConfirm.setTag(null);
        this.loadingView.setTag(null);
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
            this.mDirtyFlags = 512;
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
        if (125 == i) {
            setFromAvatar((String) obj);
        } else if (54 == i) {
            setContact((Contacts) obj);
        } else if (220 == i) {
            setPic((String) obj);
        } else if (282 == i) {
            setToTitle((String) obj);
        } else if (127 == i) {
            setFromTitle((String) obj);
        } else if (55 == i) {
            setContent((String) obj);
        } else if (281 == i) {
            setToAvatar((String) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (57 != i) {
            return false;
        } else {
            setContentTitle((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setFromAvatar(String str) {
        this.mFromAvatar = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(125);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setContact(Contacts contacts) {
        this.mContact = contacts;
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setPic(String str) {
        this.mPic = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(220);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setToTitle(String str) {
        this.mToTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(282);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setFromTitle(String str) {
        this.mFromTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(127);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setContent(String str) {
        this.mContent = str;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setToAvatar(String str) {
        this.mToAvatar = str;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(281);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DialogMessageCardBinding
    public void setContentTitle(String str) {
        this.mContentTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(57);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        View.OnClickListener onClickListener;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str6 = this.mFromAvatar;
        String str7 = this.mPic;
        String str8 = this.mToTitle;
        String str9 = this.mFromTitle;
        String str10 = this.mContent;
        String str11 = this.mToAvatar;
        View.OnClickListener onClickListener2 = this.mClick;
        String str12 = this.mContentTitle;
        int i5 = ((j & 513) > 0 ? 1 : ((j & 513) == 0 ? 0 : -1));
        if (i5 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str6);
            if (i5 != 0) {
                j |= isEmpty ? 131072 : 65536;
            }
            i = isEmpty ? 8 : 0;
        } else {
            i = 0;
        }
        int i6 = ((j & 516) > 0 ? 1 : ((j & 516) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean isEmpty2 = TextUtils.isEmpty(str7);
            if (i6 != 0) {
                j |= isEmpty2 ? 8192 : 4096;
            }
            i2 = isEmpty2 ? 8 : 0;
        } else {
            i2 = 0;
        }
        int i7 = ((j & 544) > 0 ? 1 : ((j & 544) == 0 ? 0 : -1));
        if (i7 != 0) {
            boolean isEmpty3 = TextUtils.isEmpty(str10);
            if (i7 != 0) {
                j |= isEmpty3 ? 2048 : 1024;
            }
            i3 = isEmpty3 ? 8 : 0;
        } else {
            i3 = 0;
        }
        int i8 = ((j & 768) > 0 ? 1 : ((j & 768) == 0 ? 0 : -1));
        if (i8 != 0) {
            boolean isEmpty4 = TextUtils.isEmpty(str12);
            if (i8 != 0) {
                j |= isEmpty4 ? 32768 : 16384;
            }
            i4 = isEmpty4 ? 8 : 0;
        } else {
            i4 = 0;
        }
        if ((513 & j) != 0) {
            this.contactAuthorAvatar.setVisibility(i);
            str5 = str12;
            onClickListener = onClickListener2;
            Boolean bool = null;
            str4 = str11;
            str3 = str10;
            str2 = str9;
            str = str8;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contactAuthorAvatar, str6, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        } else {
            str5 = str12;
            onClickListener = onClickListener2;
            str = str8;
            str2 = str9;
            str4 = str11;
            str3 = str10;
        }
        if ((512 & j) != 0) {
            Number number = null;
            ViewBindingAdapters.clipView(this.contactAuthorAvatar, "oval", number);
            ViewBindingAdapters.clipView(this.contactAvatarView, "oval", number);
            String str13 = null;
            ViewBindingAdapters.clipView(this.contentLayout, str13, 8);
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
            ViewBindingAdapters.clipView(this.mboundView0, str13, 8);
        }
        if ((528 & j) != 0) {
            TextViewBindingAdapter.setText(this.contactAuthorDes, str2);
        }
        if ((576 & j) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contactAvatarView, str4, null, 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
        }
        if ((j & 544) != 0) {
            this.contactMessage.setVisibility(i3);
            TextViewBindingAdapters.setTextViewLinkable(this.contactMessage, str3, null, "textColorSecondary", null, null, null);
        }
        if ((520 & j) != 0) {
            TextViewBindingAdapter.setText(this.contactUserName, str);
        }
        if ((640 & j) != 0) {
            Boolean bool3 = null;
            ViewBindingAdapters.clickListener(this.contentCard, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.dialogCancel, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.dialogConfirm, onClickListener, bool3);
        }
        if ((j & 516) != 0) {
            this.contentPicView.setVisibility(i2);
            Boolean bool4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.contentPicView, str7, AppCompatResources.getDrawable(this.contentPicView.getContext(), 2131231691), 0, 0, bool4, bool4, bool4, bool4, bool4, null, null, null, bool4, bool4, bool4, null, bool4);
        }
        if ((j & 768) != 0) {
            this.titleMessage.setVisibility(i4);
            TextViewBindingAdapters.setTextViewLinkable(this.titleMessage, str5, null, "textColorPrimary", null, null, null);
        }
    }
}
