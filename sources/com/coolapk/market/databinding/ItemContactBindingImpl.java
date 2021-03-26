package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.UserAvatarView;

public class ItemContactBindingImpl extends ItemContactBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362391, 10);
        sparseIntArray.put(2131362227, 11);
    }

    public ItemContactBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemContactBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (ActionButtonFrameLayout) objArr[8], (LinearLayout) objArr[0], (CheckBox) objArr[11], (LinearLayout) objArr[10], (UserAvatarView) objArr[1], (TextView) objArr[6], (TextView) objArr[5], (ImageView) objArr[7], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.introduceView.setTag(null);
        this.loginTimeView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        this.messageView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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
            setModel((Contacts) obj);
        } else if (102 == i) {
            setFans((String) obj);
        } else if (184 == i) {
            setListType(((Integer) obj).intValue());
        } else if (290 == i) {
            setUid((String) obj);
        } else if (189 == i) {
            setLoginTime((String) obj);
        } else if (212 == i) {
            setOnClick((View.OnClickListener) obj);
        } else if (116 == i) {
            setFollow((String) obj);
        } else if (288 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setModel(Contacts contacts) {
        this.mModel = contacts;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setFans(String str) {
        this.mFans = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(102);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setListType(int i) {
        this.mListType = i;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(184);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setUid(String str) {
        this.mUid = str;
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setLoginTime(String str) {
        this.mLoginTime = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(189);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(212);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setFollow(String str) {
        this.mFollow = str;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(116);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemContactBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0112  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i5;
        String str10;
        String str11;
        int i6;
        String str12;
        int i7;
        int i8;
        int i9;
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Contacts contacts = this.mModel;
        String str13 = this.mFans;
        int i10 = this.mListType;
        String str14 = this.mLoginTime;
        View.OnClickListener onClickListener = this.mOnClick;
        String str15 = this.mFollow;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        boolean z = true;
        int i11 = 0;
        int i12 = ((j & 257) > 0 ? 1 : ((j & 257) == 0 ? 0 : -1));
        if (i12 != 0) {
            if (contacts != null) {
                i8 = contacts.getIsFriend();
            } else {
                i8 = 0;
            }
            boolean z2 = i8 > 0;
            if (i12 != 0) {
                j |= z2 ? 4194304 : 2097152;
            }
            if (z2) {
                resources = this.actionButton.getResources();
                i9 = 2131886740;
            } else {
                resources = this.actionButton.getResources();
                i9 = 2131886741;
            }
            str = resources.getString(i9);
        } else {
            str = null;
        }
        int i13 = ((j & 258) > 0 ? 1 : ((j & 258) == 0 ? 0 : -1));
        if (i13 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str13);
            if (i13 != 0) {
                j |= isEmpty ? 262144 : 131072;
            }
            i = isEmpty ? 8 : 0;
        } else {
            i = 0;
        }
        if ((j & 389) != 0) {
            if (i10 <= 0) {
                z = false;
            }
            if ((j & 261) != 0) {
                j = z ? j | 1024 | 65536 | 16777216 : j | 512 | 32768 | 8388608;
            }
            if ((j & 389) != 0) {
                j = z ? j | 16384 : j | 8192;
            }
        } else {
            z = false;
        }
        int i14 = ((j & 272) > 0 ? 1 : ((j & 272) == 0 ? 0 : -1));
        if (i14 != 0) {
            boolean isEmpty2 = TextUtils.isEmpty(str14);
            if (i14 != 0) {
                j |= isEmpty2 ? 1048576 : 524288;
            }
            if (isEmpty2) {
                i2 = 8;
                i3 = ((j & 320) > 0 ? 1 : ((j & 320) == 0 ? 0 : -1));
                if (i3 == 0) {
                    boolean isEmpty3 = TextUtils.isEmpty(str15);
                    if (i3 != 0) {
                        j |= isEmpty3 ? 4096 : 2048;
                    }
                    if (isEmpty3) {
                        i11 = 8;
                    }
                    i4 = i11;
                } else {
                    i4 = 0;
                }
                if ((j & 25290240) == 0) {
                    str8 = ((j & 16384) == 0 || contacts == null) ? null : contacts.getFollowerUserAvatar();
                    if ((j & 8421376) != 0) {
                        UserInfo userInfo = contacts != null ? contacts.getUserInfo() : null;
                        str6 = ((j & 8388608) == 0 || userInfo == null) ? null : userInfo.getBio();
                        str7 = ((j & 32768) == 0 || userInfo == null) ? null : userInfo.getVerifyStatusIcon();
                    } else {
                        str7 = null;
                        str6 = null;
                    }
                    str2 = ((j & 512) == 0 || contacts == null) ? null : contacts.getUserName();
                    if ((j & 16842752) != 0) {
                        UserInfo followerUserInfo = contacts != null ? contacts.getFollowerUserInfo() : null;
                        str3 = ((j & 65536) == 0 || followerUserInfo == null) ? null : followerUserInfo.getVerifyStatusIcon();
                        str4 = ((j & 16777216) == 0 || followerUserInfo == null) ? null : followerUserInfo.getBio();
                    } else {
                        str4 = null;
                        str3 = null;
                    }
                    str5 = ((j & 8192) == 0 || contacts == null) ? null : contacts.getUserAvatar();
                    str9 = ((j & 1024) == 0 || contacts == null) ? null : contacts.getFollowUserName();
                } else {
                    str9 = null;
                    str8 = null;
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                }
                i5 = ((j & 261) > 0 ? 1 : ((j & 261) == 0 ? 0 : -1));
                if (i5 == 0) {
                    if (!z) {
                        str9 = str2;
                    }
                    if (z) {
                        str7 = str3;
                    }
                    if (z) {
                        str6 = str4;
                    }
                    str11 = str7;
                    str10 = str6;
                } else {
                    str9 = null;
                    str11 = null;
                    str10 = null;
                }
                i6 = ((j & 389) > 0 ? 1 : ((j & 389) == 0 ? 0 : -1));
                if (i6 == 0) {
                    if (!z) {
                        str8 = str5;
                    }
                    str12 = str8;
                } else {
                    str12 = null;
                }
                if ((257 & j) != 0) {
                    TextViewBindingAdapter.setText(this.actionButton, str);
                }
                if ((256 & j) != 0) {
                    ThemeBindingAdapters.setTextColor(this.actionButton, "colorAccent");
                    Long l = null;
                    ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, "reveal", l, l);
                }
                if ((288 & j) != 0) {
                    Boolean bool = null;
                    ViewBindingAdapters.clickListener(this.actionContainer, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.messageView, onClickListener, bool);
                }
                if (i6 == 0) {
                    i7 = i4;
                    Boolean bool2 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str12, null, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, null, null, onBitmapTransformListener, bool2, bool2, bool2, null, bool2);
                } else {
                    i7 = i4;
                }
                if (i5 != 0) {
                    ImageViewBindingAdapters.setVipSignView(this.iconView, str11, null);
                    TextViewBindingAdapter.setText(this.introduceView, str10);
                    TextViewBindingAdapter.setText(this.titleView, str9);
                }
                if ((j & 272) != 0) {
                    TextViewBindingAdapter.setText(this.loginTimeView, str14);
                    this.loginTimeView.setVisibility(i2);
                }
                if ((j & 320) != 0) {
                    TextViewBindingAdapter.setText(this.mboundView3, str15);
                    this.mboundView3.setVisibility(i7);
                }
                if ((j & 258) == 0) {
                    TextViewBindingAdapter.setText(this.mboundView4, str13);
                    this.mboundView4.setVisibility(i);
                    return;
                }
                return;
            }
        }
        i2 = 0;
        i3 = ((j & 320) > 0 ? 1 : ((j & 320) == 0 ? 0 : -1));
        if (i3 == 0) {
        }
        if ((j & 25290240) == 0) {
        }
        i5 = ((j & 261) > 0 ? 1 : ((j & 261) == 0 ? 0 : -1));
        if (i5 == 0) {
        }
        i6 = ((j & 389) > 0 ? 1 : ((j & 389) == 0 ? 0 : -1));
        if (i6 == 0) {
        }
        if ((257 & j) != 0) {
        }
        if ((256 & j) != 0) {
        }
        if ((288 & j) != 0) {
        }
        if (i6 == 0) {
        }
        if (i5 != 0) {
        }
        if ((j & 272) != 0) {
        }
        if ((j & 320) != 0) {
        }
        if ((j & 258) == 0) {
        }
    }
}
