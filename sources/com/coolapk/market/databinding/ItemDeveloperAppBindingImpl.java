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
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;

public class ItemDeveloperAppBindingImpl extends ItemDeveloperAppBinding {
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
        sparseIntArray.put(2131362660, 4);
        sparseIntArray.put(2131362063, 5);
        sparseIntArray.put(2131363028, 6);
        sparseIntArray.put(2131362917, 7);
    }

    public ItemDeveloperAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemDeveloperAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (TextView) objArr[3], (LinearLayout) objArr[4], (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.extraTextView.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        this.titleView.setTag(null);
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
        setApp((ServiceApp) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDeveloperAppBinding
    public void setApp(ServiceApp serviceApp) {
        this.mApp = serviceApp;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
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
        ServiceApp serviceApp = this.mApp;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (serviceApp != null) {
                str3 = serviceApp.getExtraFlag();
                str2 = serviceApp.getAppName();
                str4 = serviceApp.getLogo();
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
            }
            boolean z = str3 == null;
            if (i2 != 0) {
                j |= z ? 8 : 4;
            }
            if (z) {
                i = 8;
            }
            str = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((3 & j) != 0) {
            TextViewBindingAdapter.setText(this.extraTextView, str3);
            this.extraTextView.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231374, 0, bool, bool, bool, true, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.extraTextView, "colorAccent");
        }
    }
}
