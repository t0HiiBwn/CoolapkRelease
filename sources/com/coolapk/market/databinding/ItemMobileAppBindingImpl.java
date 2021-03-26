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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.viewholder.MobileAppViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemMobileAppBindingImpl extends ItemMobileAppBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363929, 8);
        sparseIntArray.put(2131363067, 9);
    }

    public ItemMobileAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemMobileAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[7], (ActionButtonFrameLayout) objArr[6], (TextView) objArr[4], (ImageView) objArr[1], (LinearLayout) objArr[0], (ImageView) objArr[5], (LinearLayout) objArr[9], (TextView) objArr[2], (TableLayout) objArr[8], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.apkSizeView.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.titleView.setTag(null);
        this.versionView.setTag(null);
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
        if (27 == i) {
            setApp((MobileApp) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewHolder((MobileAppViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemMobileAppBinding
    public void setApp(MobileApp mobileApp) {
        this.mApp = mobileApp;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMobileAppBinding
    public void setViewHolder(MobileAppViewHolder mobileAppViewHolder) {
        updateRegistration(0, mobileAppViewHolder);
        this.mViewHolder = mobileAppViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewHolder((MobileAppViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(MobileAppViewHolder mobileAppViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 3) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        long j2;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        MobileApp mobileApp = this.mApp;
        MobileAppViewHolder mobileAppViewHolder = this.mViewHolder;
        int i = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (mobileApp != null) {
                str3 = mobileApp.getAppName();
                str2 = mobileApp.getVersionName();
                str5 = mobileApp.getPackageName();
                j2 = mobileApp.getApkLength();
            } else {
                j2 = 0;
                str3 = null;
                str2 = null;
                str5 = null;
            }
            str4 = StringUtils.formatSize(j2);
            str = str5;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((13 & j) > 0 ? 1 : ((13 & j) == 0 ? 0 : -1));
        String actionText = (i2 == 0 || mobileAppViewHolder == null) ? null : mobileAppViewHolder.getActionText();
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.actionButton, actionText);
        }
        if ((9 & j) != 0) {
            ViewBindingAdapters.clickListener(this.actionContainer, mobileAppViewHolder, true);
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.itemView, mobileAppViewHolder, bool);
            ViewBindingAdapters.clickListener(this.moreView, mobileAppViewHolder, bool);
        }
        if ((j & 8) != 0) {
            Long l = null;
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, "uninstall", l, l);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.apkSizeView, str4);
            ImageViewBindingAdapters.setAppIconWithContext(this.mBindingComponent, this.iconView, str, null, null, 2131231374, null, true);
            TextViewBindingAdapter.setText(this.titleView, str3);
            TextViewBindingAdapter.setText(this.versionView, str2);
        }
    }
}
