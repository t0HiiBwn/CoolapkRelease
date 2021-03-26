package com.coolapk.market.databinding;

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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.viewholder.LocalApkViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemLocalApkBindingImpl extends ItemLocalApkBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363929, 11);
        sparseIntArray.put(2131363067, 12);
    }

    public ItemLocalApkBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ItemLocalApkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[8], (ActionButtonFrameLayout) objArr[7], (TextView) objArr[5], (ImageView) objArr[1], (LinearLayout) objArr[0], (ImageView) objArr[6], (LinearLayout) objArr[12], (TextView) objArr[10], (ImageView) objArr[9], (TextView) objArr[2], (TextView) objArr[4], (LinearLayout) objArr[11], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.apkSizeView.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.pathView.setTag(null);
        this.selectedView.setTag(null);
        this.titleView.setTag(null);
        this.versionCodeView.setTag(null);
        this.versionNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (307 == i) {
            setVh((LocalApkViewHolder) obj);
        } else if (24 != i) {
            return false;
        } else {
            setApk((LocalApk) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemLocalApkBinding
    public void setVh(LocalApkViewHolder localApkViewHolder) {
        updateRegistration(0, localApkViewHolder);
        this.mVh = localApkViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemLocalApkBinding
    public void setApk(LocalApk localApk) {
        this.mApk = localApk;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVh((LocalApkViewHolder) obj, i2);
    }

    private boolean onChangeVh(LocalApkViewHolder localApkViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i != 242) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j2;
        String str7;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LocalApkViewHolder localApkViewHolder = this.mVh;
        LocalApk localApk = this.mApk;
        int i2 = 0;
        if ((29 & j) != 0) {
            int i3 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (localApkViewHolder != null) {
                    z = localApkViewHolder.isSelected();
                } else {
                    z = false;
                }
                if (i3 != 0) {
                    j |= z ? 64 : 32;
                }
                if (!z) {
                    i = 8;
                    str = ((j & 21) != 0 || localApkViewHolder == null) ? null : localApkViewHolder.getActionText();
                }
            }
            i = 0;
            if ((j & 21) != 0) {
            }
        } else {
            str = null;
            i = 0;
        }
        int i4 = ((18 & j) > 0 ? 1 : ((18 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (localApk != null) {
                String appName = localApk.getAppName();
                String filePath = localApk.getFilePath();
                int versionCode = localApk.getVersionCode();
                j2 = localApk.getApkLength();
                str6 = localApk.getVersionName();
                str2 = appName;
                i2 = versionCode;
                str7 = filePath;
            } else {
                j2 = 0;
                str6 = null;
                str2 = null;
                str7 = null;
            }
            str4 = StringUtils.formatSize(j2);
            str5 = ("(" + i2) + ")";
            str3 = str7;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
        }
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str);
        }
        if ((16 & j) != 0) {
            Long l = null;
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, "normal", l, l);
        }
        if ((17 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionContainer, localApkViewHolder, bool);
            ViewBindingAdapters.setOnLongClickListener(this.itemView, localApkViewHolder);
            ViewBindingAdapters.clickListener(this.moreView, localApkViewHolder, bool);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.apkSizeView, str4);
            ImageViewBindingAdapters.setAppIconWithContext(this.mBindingComponent, this.iconView, null, str3, null, 2131231374, null, true);
            TextViewBindingAdapter.setText(this.pathView, str3);
            TextViewBindingAdapter.setText(this.titleView, str2);
            TextViewBindingAdapter.setText(this.versionCodeView, str5);
            TextViewBindingAdapter.setText(this.versionNameView, str6);
        }
        if ((j & 25) != 0) {
            this.selectedView.setVisibility(i);
        }
    }
}
