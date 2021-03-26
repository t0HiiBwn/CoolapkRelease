package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.IgnoreInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.viewholder.UpgradeViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.expandable.ExpandTextView;

public class ItemUpgradeBindingImpl extends ItemUpgradeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362835, 12);
        sparseIntArray.put(2131363929, 13);
        sparseIntArray.put(2131363067, 14);
        sparseIntArray.put(2131363889, 15);
    }

    public ItemUpgradeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ItemUpgradeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[11], (ActionButtonFrameLayout) objArr[10], (TextView) objArr[6], (TextView) objArr[8], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[0], (LinearLayout) objArr[12], (ImageView) objArr[9], (LinearLayout) objArr[14], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[2], (ExpandTextView) objArr[15], (TableLayout) objArr[13], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.apkSizeView.setTag(null);
        this.extraTextView.setTag(null);
        this.iconView.setTag(null);
        this.ignoreFlag.setTag(null);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.patchSizeView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
        this.versionUpgradeView.setTag(null);
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
        if (308 == i) {
            setViewHolder((UpgradeViewHolder) obj);
        } else if (27 != i) {
            return false;
        } else {
            setApp((MobileApp) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUpgradeBinding
    public void setViewHolder(UpgradeViewHolder upgradeViewHolder) {
        updateRegistration(0, upgradeViewHolder);
        this.mViewHolder = upgradeViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUpgradeBinding
    public void setApp(MobileApp mobileApp) {
        this.mApp = mobileApp;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewHolder((UpgradeViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(UpgradeViewHolder upgradeViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 155) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 305) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 277) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 26) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016d  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        int i3;
        int i4;
        int i5;
        String str5;
        String str6;
        String str7;
        int i6;
        String str8;
        String str9;
        boolean z;
        IgnoreInfo ignoreInfo;
        boolean z2;
        int i7;
        int i8;
        int i9;
        String str10;
        UpgradeInfo upgradeInfo;
        String str11;
        String str12;
        String str13;
        String str14;
        String actionButtonBackground;
        String versionInfo;
        String actionText;
        String time;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UpgradeViewHolder upgradeViewHolder = this.mViewHolder;
        MobileApp mobileApp = this.mApp;
        int i10 = 8;
        if ((1021 & j) != 0) {
            int i11 = ((j & 517) > 0 ? 1 : ((j & 517) == 0 ? 0 : -1));
            if (i11 != 0) {
                if (upgradeViewHolder != null) {
                    z3 = upgradeViewHolder.isIgnoreTagShow();
                } else {
                    z3 = false;
                }
                if (i11 != 0) {
                    j |= z3 ? 32768 : 16384;
                }
                if (!z3) {
                    i3 = 8;
                    i2 = ((j & 545) != 0 || upgradeViewHolder == null) ? 0 : upgradeViewHolder.getApkSizePainFlags();
                    actionButtonBackground = ((j & 577) != 0 || upgradeViewHolder == null) ? null : upgradeViewHolder.getActionButtonBackground();
                    versionInfo = ((j & 521) != 0 || upgradeViewHolder == null) ? null : upgradeViewHolder.getVersionInfo();
                    actionText = ((j & 641) != 0 || upgradeViewHolder == null) ? null : upgradeViewHolder.getActionText();
                    time = ((j & 529) != 0 || upgradeViewHolder == null) ? null : upgradeViewHolder.getTime();
                    if ((j & 769) != 0 || upgradeViewHolder == null) {
                        str2 = actionButtonBackground;
                        str = versionInfo;
                        str4 = actionText;
                        str3 = time;
                    } else {
                        str2 = actionButtonBackground;
                        str = versionInfo;
                        str4 = actionText;
                        str3 = time;
                        i = upgradeViewHolder.getActionButtonTextColor();
                        i4 = ((j & 514) > 0 ? 1 : ((j & 514) == 0 ? 0 : -1));
                        if (i4 == 0) {
                            if (mobileApp != null) {
                                upgradeInfo = mobileApp.getUpgradeInfo();
                                str10 = mobileApp.getAppName();
                                ignoreInfo = mobileApp.getIgnoreInfo();
                            } else {
                                ignoreInfo = null;
                                upgradeInfo = null;
                                str10 = null;
                            }
                            if (upgradeInfo != null) {
                                str13 = upgradeInfo.getPatchSize();
                                str12 = upgradeInfo.getApkSize();
                                str11 = upgradeInfo.getLogo();
                                str14 = upgradeInfo.getExtraFlag();
                            } else {
                                str14 = null;
                                str13 = null;
                                str12 = null;
                                str11 = null;
                            }
                            z = ignoreInfo == null;
                            if (i4 != 0) {
                                j = z ? j | 2048 : j | 1024;
                            }
                            boolean z4 = str13 == null;
                            boolean z5 = str14 == null;
                            if ((j & 514) != 0) {
                                j |= z4 ? 8192 : 4096;
                            }
                            if ((j & 514) != 0) {
                                j |= z5 ? 524288 : 262144;
                            }
                            str9 = str14;
                            str8 = str10;
                            i6 = z4 ? 8 : 0;
                            str7 = str13;
                            str6 = str12;
                            str5 = str11;
                            i5 = z5 ? 8 : 0;
                        } else {
                            ignoreInfo = null;
                            str9 = null;
                            str8 = null;
                            str7 = null;
                            str6 = null;
                            str5 = null;
                            z = false;
                            i6 = 0;
                            i5 = 0;
                        }
                        if ((j & 1024) != 0) {
                            if (ignoreInfo != null) {
                                i9 = ignoreInfo.getType();
                            } else {
                                i9 = 0;
                            }
                            if (i9 == 0) {
                                z2 = true;
                                i7 = ((j & 514) > 0 ? 1 : ((j & 514) == 0 ? 0 : -1));
                                if (i7 != 0) {
                                    if (z) {
                                        z2 = true;
                                    }
                                    if (i7 != 0) {
                                        j |= z2 ? 131072 : 65536;
                                    }
                                    if (z2) {
                                        i10 = 0;
                                    }
                                    i8 = i10;
                                } else {
                                    i8 = 0;
                                }
                                if ((j & 641) != 0) {
                                    TextViewBindingAdapter.setText(this.actionButton, str4);
                                }
                                if ((j & 769) != 0) {
                                    this.actionButton.setTextColor(i);
                                }
                                if ((513 & j) != 0) {
                                    ViewBindingAdapters.clickListener(this.actionContainer, upgradeViewHolder, true);
                                    Boolean bool = null;
                                    ViewBindingAdapters.clickListener(this.itemView, upgradeViewHolder, bool);
                                    ViewBindingAdapters.clickListener(this.moreView, upgradeViewHolder, bool);
                                }
                                if ((577 & j) != 0) {
                                    Long l = null;
                                    ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, str2, l, l);
                                }
                                if ((j & 514) != 0) {
                                    TextViewBindingAdapter.setText(this.apkSizeView, str6);
                                    TextViewBindingAdapter.setText(this.extraTextView, str9);
                                    this.extraTextView.setVisibility(i5);
                                    Boolean bool2 = null;
                                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str5, null, 2131231374, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, true, null, bool2);
                                    this.moreView.setVisibility(i8);
                                    TextViewBindingAdapter.setText(this.patchSizeView, str7);
                                    this.patchSizeView.setVisibility(i6);
                                    TextViewBindingAdapter.setText(this.titleView, str8);
                                }
                                if ((j & 545) != 0) {
                                    this.apkSizeView.setPaintFlags(i2);
                                }
                                if ((512 & j) != 0) {
                                    ThemeBindingAdapters.setTextColor(this.extraTextView, "colorAccent");
                                }
                                if ((j & 517) != 0) {
                                    this.ignoreFlag.setVisibility(i3);
                                }
                                if ((529 & j) != 0) {
                                    TextViewBindingAdapter.setText(this.timeView, str3);
                                }
                                if ((j & 521) != 0) {
                                    TextViewBindingAdapter.setText(this.versionUpgradeView, str);
                                    return;
                                }
                                return;
                            }
                        }
                        z2 = false;
                        i7 = ((j & 514) > 0 ? 1 : ((j & 514) == 0 ? 0 : -1));
                        if (i7 != 0) {
                        }
                        if ((j & 641) != 0) {
                        }
                        if ((j & 769) != 0) {
                        }
                        if ((513 & j) != 0) {
                        }
                        if ((577 & j) != 0) {
                        }
                        if ((j & 514) != 0) {
                        }
                        if ((j & 545) != 0) {
                        }
                        if ((512 & j) != 0) {
                        }
                        if ((j & 517) != 0) {
                        }
                        if ((529 & j) != 0) {
                        }
                        if ((j & 521) != 0) {
                        }
                    }
                }
            }
            i3 = 0;
            if ((j & 545) != 0) {
            }
            if ((j & 577) != 0) {
            }
            if ((j & 521) != 0) {
            }
            if ((j & 641) != 0) {
            }
            if ((j & 529) != 0) {
            }
            if ((j & 769) != 0) {
            }
            str2 = actionButtonBackground;
            str = versionInfo;
            str4 = actionText;
            str3 = time;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
        }
        i = 0;
        i4 = ((j & 514) > 0 ? 1 : ((j & 514) == 0 ? 0 : -1));
        if (i4 == 0) {
        }
        if ((j & 1024) != 0) {
        }
        z2 = false;
        i7 = ((j & 514) > 0 ? 1 : ((j & 514) == 0 ? 0 : -1));
        if (i7 != 0) {
        }
        if ((j & 641) != 0) {
        }
        if ((j & 769) != 0) {
        }
        if ((513 & j) != 0) {
        }
        if ((577 & j) != 0) {
        }
        if ((j & 514) != 0) {
        }
        if ((j & 545) != 0) {
        }
        if ((512 & j) != 0) {
        }
        if ((j & 517) != 0) {
        }
        if ((529 & j) != 0) {
        }
        if ((j & 521) != 0) {
        }
    }
}
