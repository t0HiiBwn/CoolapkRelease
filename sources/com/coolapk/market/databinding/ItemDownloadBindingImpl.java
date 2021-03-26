package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.viewholder.DownloadViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemDownloadBindingImpl extends ItemDownloadBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363067, 11);
    }

    public ItemDownloadBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemDownloadBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[9], (ActionButtonFrameLayout) objArr[8], (TextView) objArr[6], (ImageView) objArr[1], (LinearLayout) objArr[0], (ImageView) objArr[7], (LinearLayout) objArr[11], (TextView) objArr[10], (TextView) objArr[2], (TextView) objArr[5], (LinearLayout) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.downloadSize.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.speedView.setTag(null);
        this.titleView.setTag(null);
        this.versionCodeView.setTag(null);
        this.versionInfoView.setTag(null);
        this.versionNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8192;
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
        if (307 != i) {
            return false;
        }
        setVh((DownloadViewHolder) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDownloadBinding
    public void setVh(DownloadViewHolder downloadViewHolder) {
        updateRegistration(0, downloadViewHolder);
        this.mVh = downloadViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVh((DownloadViewHolder) obj, i2);
    }

    private boolean onChangeVh(DownloadViewHolder downloadViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 190) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 76) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 30) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 262) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 306) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 304) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 77) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 1) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 2) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        } else if (i != 259) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4096;
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007b, code lost:
        if (r33 != false) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        int i2;
        String str6;
        String str7;
        String str8;
        int i3;
        int i4;
        int i5;
        String actionButtonBackground;
        String actionText;
        String versionName;
        String downloadSize;
        String appName;
        String speed;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DownloadViewHolder downloadViewHolder = this.mVh;
        int i6 = 0;
        if ((16383 & j) != 0) {
            int i7 = 8;
            int i8 = ((j & 12289) > 0 ? 1 : ((j & 12289) == 0 ? 0 : -1));
            if (i8 != 0) {
                if (downloadViewHolder != null) {
                    z2 = downloadViewHolder.isShowSpeed();
                } else {
                    z2 = false;
                }
                if (i8 != 0) {
                    j |= z2 ? 32768 : 16384;
                }
                if (!z2) {
                    i4 = 8;
                    str8 = ((j & 8257) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getVersionCode();
                    i5 = ((j & 8209) > 0 ? 1 : ((j & 8209) == 0 ? 0 : -1));
                    if (i5 != 0) {
                        if (downloadViewHolder != null) {
                            z = downloadViewHolder.isShowVersion();
                        } else {
                            z = false;
                        }
                        if (i5 != 0) {
                            j |= z ? 131072 : 65536;
                        }
                    }
                    i7 = 0;
                    actionButtonBackground = ((j & 8449) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getActionButtonBackground();
                    actionText = ((j & 8705) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getActionText();
                    versionName = ((j & 8225) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getVersionName();
                    if (!((j & 9217) == 0 || downloadViewHolder == null)) {
                        i6 = downloadViewHolder.getActionButtonTextColor();
                    }
                    downloadSize = ((j & 8321) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getDownloadSize();
                    appName = ((j & 8201) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getAppName();
                    speed = ((j & 10241) != 0 || downloadViewHolder == null) ? null : downloadViewHolder.getSpeed();
                    if ((j & 8199) != 0 || downloadViewHolder == null) {
                        i2 = i4;
                        i3 = i6;
                        str = null;
                        drawable = null;
                        i = i7;
                        str7 = actionButtonBackground;
                        str6 = actionText;
                        str3 = versionName;
                        str5 = downloadSize;
                        str4 = appName;
                        str2 = speed;
                    } else {
                        i2 = i4;
                        i3 = i6;
                        i = i7;
                        str7 = actionButtonBackground;
                        str6 = actionText;
                        str3 = versionName;
                        str5 = downloadSize;
                        str4 = appName;
                        str2 = speed;
                        str = downloadViewHolder.getLogo();
                        drawable = downloadViewHolder.getDownloadIconPlaceHolder();
                    }
                }
            }
            i4 = 0;
            if ((j & 8257) != 0) {
            }
            i5 = ((j & 8209) > 0 ? 1 : ((j & 8209) == 0 ? 0 : -1));
            if (i5 != 0) {
            }
            i7 = 0;
            if ((j & 8449) != 0) {
            }
            if ((j & 8705) != 0) {
            }
            if ((j & 8225) != 0) {
            }
            i6 = downloadViewHolder.getActionButtonTextColor();
            if ((j & 8321) != 0) {
            }
            if ((j & 8201) != 0) {
            }
            if ((j & 10241) != 0) {
            }
            if ((j & 8199) != 0) {
            }
            i2 = i4;
            i3 = i6;
            str = null;
            drawable = null;
            i = i7;
            str7 = actionButtonBackground;
            str6 = actionText;
            str3 = versionName;
            str5 = downloadSize;
            str4 = appName;
            str2 = speed;
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            drawable = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 8705) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str6);
        }
        if ((j & 9217) != 0) {
            this.actionButton.setTextColor(i3);
        }
        if ((8193 & j) != 0) {
            ViewBindingAdapters.clickListener(this.actionContainer, downloadViewHolder, true);
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.itemView, downloadViewHolder, bool);
            ViewBindingAdapters.clickListener(this.moreView, downloadViewHolder, bool);
        }
        if ((j & 8449) != 0) {
            Long l = null;
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, str7, l, l);
        }
        if ((j & 8321) != 0) {
            TextViewBindingAdapter.setText(this.downloadSize, str5);
        }
        if ((8199 & j) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, drawable, 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, true, bool2, bool2, null, bool2);
        }
        if ((10241 & j) != 0) {
            TextViewBindingAdapter.setText(this.speedView, str2);
        }
        if ((8192 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.speedView, "colorAccent");
        }
        if ((j & 12289) != 0) {
            this.speedView.setVisibility(i2);
        }
        if ((8201 & j) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
        if ((j & 8257) != 0) {
            TextViewBindingAdapter.setText(this.versionCodeView, str8);
        }
        if ((j & 8209) != 0) {
            this.versionInfoView.setVisibility(i);
        }
        if ((j & 8225) != 0) {
            TextViewBindingAdapter.setText(this.versionNameView, str3);
        }
    }
}
