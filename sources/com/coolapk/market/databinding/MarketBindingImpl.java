package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;

public class MarketBindingImpl extends MarketBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"item_headline_title"}, new int[]{6}, new int[]{2131558773});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363490, 7);
        sparseIntArray.put(2131363934, 8);
        sparseIntArray.put(2131363224, 9);
        sparseIntArray.put(2131363223, 10);
        sparseIntArray.put(2131362501, 11);
        sparseIntArray.put(2131362499, 12);
        sparseIntArray.put(2131362502, 13);
        sparseIntArray.put(2131362498, 14);
    }

    public MarketBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private MarketBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (View) objArr[5], (FrameLayout) objArr[14], (View) objArr[12], (TextView) objArr[3], (FrameLayout) objArr[11], (FrameLayout) objArr[13], (ItemHeadlineTitleBinding) objArr[6], (FrameLayout) objArr[2], (RelativeLayout) objArr[10], (FrameLayout) objArr[9], (RelativeLayout) objArr[0], (TabLayout) objArr[7], (FrameLayout) objArr[1], (ScrollStateViewPager) objArr[8]);
        this.mDirtyFlags = -1;
        this.fabRefreshIcon.setTag(null);
        this.fabRefreshIconDividerView.setTag(null);
        this.fabRefreshTextView.setTag(null);
        setContainedBinding(this.floatHeadlineTitleView);
        this.floatHeadlineView.setTag(null);
        this.rootView.setTag(null);
        this.tabsWrap.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.floatHeadlineTitleView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.floatHeadlineTitleView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.floatHeadlineTitleView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFloatHeadlineTitleView((ItemHeadlineTitleBinding) obj, i2);
    }

    private boolean onChangeFloatHeadlineTitleView(ItemHeadlineTitleBinding itemHeadlineTitleBinding, int i) {
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
            ThemeBindingAdapters.setTintColor(this.fabRefreshIcon, "colorAccent");
            ThemeBindingAdapters.setBackgroundColor(this.fabRefreshIconDividerView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.fabRefreshTextView, "colorAccent");
            ThemeBindingAdapters.setBackgroundColor(this.tabsWrap, "colorPrimary");
        }
        executeBindingsOn(this.floatHeadlineTitleView);
    }
}
