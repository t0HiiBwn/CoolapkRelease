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
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.StringUtils;

public class ItemPickAppBindingImpl extends ItemPickAppBinding {
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
        sparseIntArray.put(2131363906, 5);
    }

    public ItemPickAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemPickAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (LinearLayout) objArr[0], (ImageView) objArr[1], (TextView) objArr[2], (TableLayout) objArr[5], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.apkSizeView.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.titleView.setTag(null);
        this.versionView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (27 != i) {
            return false;
        }
        setApp((MobileApp) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemPickAppBinding
    public void setApp(MobileApp mobileApp) {
        this.mApp = mobileApp;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            j2 = 0;
            this.mDirtyFlags = 0;
        }
        MobileApp mobileApp = this.mApp;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (mobileApp != null) {
                str6 = mobileApp.getVersionName();
                str5 = mobileApp.getPackageName();
                j2 = mobileApp.getApkLength();
                str2 = mobileApp.getAppName();
            } else {
                str6 = null;
                str5 = null;
                str2 = null;
            }
            str4 = "v" + str6;
            str3 = StringUtils.formatSize(j2);
            str = str5;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.apkSizeView, str3);
            ImageViewBindingAdapters.setAppIconWithContext(this.mBindingComponent, this.iconView, str, null, null, 2131231363, null, true);
            TextViewBindingAdapter.setText(this.titleView, str2);
            TextViewBindingAdapter.setText(this.versionView, str4);
        }
    }
}
