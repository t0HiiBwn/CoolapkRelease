package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemFeedVoteMultiBindingImpl extends ItemFeedVoteMultiBinding {
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
        sparseIntArray.put(2131363397, 5);
        sparseIntArray.put(2131362222, 6);
    }

    public ItemFeedVoteMultiBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemFeedVoteMultiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ImageView) objArr[2], (TextView) objArr[4], (LinearLayout) objArr[0], (Space) objArr[5], (TextView) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.checkView.setTag(null);
        this.percentView.setTag(null);
        this.rootView.setTag(null);
        this.titleView.setTag(null);
        this.totalVoteNumView.setTag(null);
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
        if (50 != i) {
            return false;
        }
        setClick((View.OnClickListener) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteMultiBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTintColor(this.checkView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.percentView, "colorAccent");
            ViewBindingAdapters.clipView(this.rootView, null, 3);
            ThemeBindingAdapters.setTextColor(this.titleView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.totalVoteNumView, "colorAccent");
        }
    }
}
