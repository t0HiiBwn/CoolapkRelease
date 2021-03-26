package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Message;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.FatTextView;

public class ItemMessageBindingImpl extends ItemMessageBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemMessageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (CheckBox) objArr[1], (CoolEllipsizeTextView) objArr[5], (TextView) objArr[3], (FatTextView) objArr[6], (UserAvatarView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.checkBox.setTag(null);
        this.infoView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.titleView.setTag(null);
        this.unreadView.setTag(null);
        this.userAvatarView.setTag(null);
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
        if (197 == i) {
            setModel((Message) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemMessageBinding
    public void setModel(Message message) {
        this.mModel = message;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMessageBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMessageBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d2, code lost:
        if (r11 > 0) goto L_0x00d6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        int i;
        boolean z2;
        String str5;
        int i2;
        boolean z3;
        String str6;
        String str7;
        int i3;
        UserInfo userInfo;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Message message = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        boolean z4 = true;
        boolean z5 = false;
        if ((j & 11) != 0) {
            int i5 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (message != null) {
                    i4 = message.getIsNew();
                    userInfo = message.getMessageUserInfo();
                    str7 = message.getMessageUserName();
                    str6 = message.getShowUnreadNum();
                } else {
                    userInfo = null;
                    str7 = null;
                    str6 = null;
                    i4 = 0;
                }
                z = i4 > 0;
                boolean isEmpty = TextUtils.isEmpty(str6);
                if (i5 != 0) {
                    j = z ? j | 32 : j | 16;
                }
                if ((j & 9) != 0) {
                    j |= isEmpty ? 2048 : 1024;
                }
                str3 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
                if (isEmpty) {
                    i3 = 8;
                    if (message == null) {
                        i = i3;
                        str4 = str7;
                        str = str6;
                        str2 = message.getMessageUserAvatar();
                    } else {
                        i = i3;
                        str2 = null;
                        str4 = str7;
                        str = str6;
                    }
                }
            } else {
                str3 = null;
                str7 = null;
                str6 = null;
                z = false;
            }
            i3 = 0;
            if (message == null) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
            z = false;
        }
        if ((32 & j) != 0) {
            if (message != null) {
                z3 = message.isSentFromMe();
            } else {
                z3 = false;
            }
            z2 = !z3;
        } else {
            z2 = false;
        }
        int i6 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i6 != 0) {
                j = z2 ? j | 512 : j | 256;
            }
        } else {
            z2 = false;
        }
        if ((j & 512) != 0) {
            if (message != null) {
                i2 = message.getUnreadNum();
            } else {
                i2 = 0;
            }
        }
        z4 = false;
        int i7 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (z2) {
                z5 = z4;
            }
            if (i7 != 0) {
                j |= z5 ? 128 : 64;
            }
            str5 = z5 ? "colorAccent" : "textColorSecondary";
        } else {
            str5 = null;
        }
        if ((12 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setTint(this.checkBox, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.unreadView, "colorAccent");
        }
        if ((j & 9) != 0) {
            ThemeBindingAdapters.setTextColor(this.infoView, str5);
            TextViewBindingAdapters.setDatelineByEntity(this.mboundView4, message);
            TextViewBindingAdapter.setText(this.titleView, str4);
            TextViewBindingAdapter.setText(this.unreadView, str);
            this.unreadView.setVisibility(i);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, null);
        }
        if ((j & 11) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231152, 0, bool2, bool2, bool2, bool2, bool2, null, null, onBitmapTransformListener, bool2, bool2, bool2, null, bool2);
        }
    }
}
