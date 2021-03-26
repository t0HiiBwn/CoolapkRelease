package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class SubmitSecondHandDealExtraChildBindingImpl extends SubmitSecondHandDealExtraChildBinding {
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
        sparseIntArray.put(2131362707, 4);
        sparseIntArray.put(2131363582, 5);
        sparseIntArray.put(2131363475, 6);
        sparseIntArray.put(2131362376, 7);
        sparseIntArray.put(2131362087, 8);
    }

    public SubmitSecondHandDealExtraChildBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private SubmitSecondHandDealExtraChildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (TextView) objArr[7], (ImageView) objArr[4], (LinearLayout) objArr[0], (CheckedTextView) objArr[2], (LinearLayout) objArr[6], (CheckedTextView) objArr[1], (CheckedTextView) objArr[3], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.switchCenter.setTag(null);
        this.switchLeft.setTag(null);
        this.switchRight.setTag(null);
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

    @Override // com.coolapk.market.databinding.SubmitSecondHandDealExtraChildBinding
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
        if ((j & 3) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.switchCenter, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.switchLeft, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.switchRight, onClickListener, bool);
        }
    }
}
