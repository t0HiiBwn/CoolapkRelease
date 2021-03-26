package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemFeedSourcePartBindingImpl extends ItemFeedSourcePartBinding {
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
        sparseIntArray.put(2131363533, 2);
        sparseIntArray.put(2131363326, 3);
        sparseIntArray.put(2131363397, 4);
        sparseIntArray.put(2131363917, 5);
    }

    public ItemFeedSourcePartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemFeedSourcePartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolEllipsizeTextView) objArr[1], (Space) objArr[3], (LinearLayout) objArr[0], (Space) objArr[4], (CoolEllipsizeTextView) objArr[2], (Space) objArr[5]);
        this.mDirtyFlags = -1;
        this.bottomTextView.setTag(null);
        this.sourceContainer.setTag(null);
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
        if (197 != i) {
            return false;
        }
        setModel((Feed) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedSourcePartBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.bottomTextView, "textColorPrimary");
            ViewBindingAdapters.clipView(this.sourceContainer, null, 8);
        }
    }
}
