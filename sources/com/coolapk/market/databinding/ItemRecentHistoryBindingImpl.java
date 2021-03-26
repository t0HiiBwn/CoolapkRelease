package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.RecentHistory;

public class ItemRecentHistoryBindingImpl extends ItemRecentHistoryBinding {
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
        sparseIntArray.put(2131362768, 2);
        sparseIntArray.put(2131363505, 3);
        sparseIntArray.put(2131363582, 4);
        sparseIntArray.put(2131362376, 5);
    }

    public ItemRecentHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemRecentHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (TextView) objArr[5], (ImageView) objArr[1], (LinearLayout) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.iconView.setTag(null);
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
        if (197 == i) {
            setModel((RecentHistory) obj);
        } else if (287 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemRecentHistoryBinding
    public void setModel(RecentHistory recentHistory) {
        this.mModel = recentHistory;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemRecentHistoryBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        RecentHistory recentHistory = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        String logo = (i == 0 || recentHistory == null) ? null : recentHistory.getLogo();
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, logo, null, 2131231691, 0, bool, bool, bool, true, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        }
    }
}
