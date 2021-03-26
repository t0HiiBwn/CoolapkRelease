package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.LocalApp;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemBackupAppBindingImpl extends ItemBackupAppBinding {
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
        sparseIntArray.put(2131361876, 6);
    }

    public ItemBackupAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemBackupAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (ActionButtonFrameLayout) objArr[5], (TextView) objArr[4], (LinearLayout) objArr[0], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionContainer.setTag(null);
        this.apkSizeView.setTag(null);
        this.appView.setTag(null);
        this.iconView.setTag(null);
        this.sourceNameView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
            setApp((LocalApp) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemBackupAppBinding
    public void setApp(LocalApp localApp) {
        this.mApp = localApp;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupAppBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LocalApp localApp = this.mApp;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i == 0 || localApp == null) {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        } else {
            str4 = localApp.getPackageName();
            str3 = localApp.getTitle();
            str2 = localApp.getApkSize();
            str = localApp.getPic();
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickListener(this.actionContainer, onClickListener, true);
            ViewBindingAdapters.clickListener(this.appView, onClickListener, null);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.apkSizeView, str2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.sourceNameView, str4);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
    }
}
