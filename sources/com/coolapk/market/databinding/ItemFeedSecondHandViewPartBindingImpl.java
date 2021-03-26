package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemFeedSecondHandViewPartBindingImpl extends ItemFeedSecondHandViewPartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_second_hand_detail"}, new int[]{5}, new int[]{2131558918});
    }

    public ItemFeedSecondHandViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemFeedSecondHandViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[0], (TextView) objArr[4], (ItemSecondHandDetailBinding) objArr[5], (TextView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.goShoppingView.setTag(null);
        setContainedBinding(this.secondHandParams);
        this.textNotice.setTag(null);
        this.urlNotice.setTag(null);
        this.urlNoticeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.secondHandParams.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.secondHandParams.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.secondHandParams.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeSecondHandParams((ItemSecondHandDetailBinding) obj, i2);
    }

    private boolean onChangeSecondHandParams(ItemSecondHandDetailBinding itemSecondHandDetailBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.goShoppingView, "colorAccent");
            String str = null;
            ViewBindingAdapters.clipView(this.textNotice, str, 4);
            ThemeBindingAdapters.setTextColor(this.urlNotice, "colorAccent");
            ViewBindingAdapters.clipView(this.urlNoticeLayout, str, 4);
        }
        executeBindingsOn(this.secondHandParams);
    }
}
