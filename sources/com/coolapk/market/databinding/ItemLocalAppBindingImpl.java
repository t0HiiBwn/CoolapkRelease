package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.album.AlbumPickAPKViewModel;
import com.coolapk.market.view.backupList.AppViewHolder;

public class ItemLocalAppBindingImpl extends ItemLocalAppBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362316, 7);
        sparseIntArray.put(2131363906, 8);
    }

    public ItemLocalAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemLocalAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[4], (TextView) objArr[5], (LinearLayout) objArr[0], (LinearLayout) objArr[7], (ImageView) objArr[1], (CheckBox) objArr[6], (TextView) objArr[2], (TableLayout) objArr[8], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.apkSizeView.setTag(null);
        this.apkSystemView.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.mobileAppCheckView.setTag(null);
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
        } else if (307 == i) {
            setViewHolder((AppViewHolder) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((AlbumPickAPKViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemLocalAppBinding
    public void setApp(MobileApp mobileApp) {
        this.mApp = mobileApp;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemLocalAppBinding
    public void setViewHolder(AppViewHolder appViewHolder) {
        updateRegistration(0, appViewHolder);
        this.mViewHolder = appViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemLocalAppBinding
    public void setViewModel(AlbumPickAPKViewModel albumPickAPKViewModel) {
        this.mViewModel = albumPickAPKViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewHolder((AppViewHolder) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AlbumPickAPKViewModel) obj, i2);
    }

    private boolean onChangeViewHolder(AppViewHolder appViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModel(AlbumPickAPKViewModel albumPickAPKViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        long j2;
        boolean z;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        MobileApp mobileApp = this.mApp;
        AppViewHolder appViewHolder = this.mViewHolder;
        int i = 0;
        int i2 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (mobileApp != null) {
                str3 = mobileApp.getAppName();
                str6 = mobileApp.getVersionName();
                str5 = mobileApp.getPackageName();
                z = mobileApp.isSystemApp();
                j2 = mobileApp.getApkLength();
            } else {
                j2 = 0;
                str3 = null;
                str6 = null;
                str5 = null;
                z = false;
            }
            if (i2 != 0) {
                j |= z ? 32 : 16;
            }
            str4 = "v" + str6;
            if (!z) {
                i = 8;
            }
            str2 = StringUtils.formatSize(j2);
            str = str5;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i3 = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if ((12 & j) != 0) {
            TextViewBindingAdapter.setText(this.apkSizeView, str2);
            this.apkSystemView.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setAppIconWithContext(this.mBindingComponent, this.iconView, str, null, null, 2131231363, bool, bool);
            TextViewBindingAdapter.setText(this.titleView, str3);
            TextViewBindingAdapter.setText(this.versionView, str4);
        }
        if (i3 != 0) {
            ViewBindingAdapters.clickListener(this.cardView, appViewHolder, null);
        }
        if ((j & 8) != 0) {
            ThemeBindingAdapters.setTint(this.mobileAppCheckView, "colorAccent");
        }
    }
}
