package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public class LayoutPrivacyClauseBindingImpl extends LayoutPrivacyClauseBinding {
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
        sparseIntArray.put(2131363604, 4);
        sparseIntArray.put(2131362382, 5);
        sparseIntArray.put(2131362876, 6);
        sparseIntArray.put(2131362383, 7);
    }

    public LayoutPrivacyClauseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private LayoutPrivacyClauseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (LinearLayout) objArr[1], (TextView) objArr[5], (TextView) objArr[7], (RecyclerView) objArr[6], (DrawSystemBarFrameLayout) objArr[0], (TextView) objArr[2], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.agreeView.setTag(null);
        this.contentView.setTag(null);
        this.mainContent.setTag(null);
        this.onlyView.setTag(null);
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

    @Override // com.coolapk.market.databinding.LayoutPrivacyClauseBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((3 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.agreeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.contentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.mainContent, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.onlyView, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            String str = null;
            ViewBindingAdapters.clipView(this.agreeView, str, 22);
            ViewBindingAdapters.clipView(this.onlyView, str, 22);
        }
    }
}
