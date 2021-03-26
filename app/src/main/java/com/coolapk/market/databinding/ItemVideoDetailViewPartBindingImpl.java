package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemVideoDetailViewPartBindingImpl extends ItemVideoDetailViewPartBinding {
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
        sparseIntArray.put(2131363918, 8);
        sparseIntArray.put(2131363912, 9);
        sparseIntArray.put(2131363604, 10);
        sparseIntArray.put(2131363582, 11);
        sparseIntArray.put(2131362131, 12);
        sparseIntArray.put(2131362348, 13);
        sparseIntArray.put(2131363332, 14);
        sparseIntArray.put(2131363613, 15);
        sparseIntArray.put(2131362873, 16);
        sparseIntArray.put(2131362872, 17);
        sparseIntArray.put(2131363146, 18);
        sparseIntArray.put(2131362285, 19);
    }

    public ItemVideoDetailViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ItemVideoDetailViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[12], (FrameLayout) objArr[19], (TextView) objArr[13], (ImageView) objArr[6], (FrameLayout) objArr[0], (TextView) objArr[17], (LinearLayout) objArr[16], (ImageView) objArr[4], (ImageView) objArr[1], (ImageView) objArr[3], (ImageView) objArr[5], (ProgressBar) objArr[18], (LinearLayout) objArr[7], (SeekBar) objArr[14], (TextView) objArr[11], (LinearLayout) objArr[10], (TextView) objArr[15], (FrameLayout) objArr[9], (FrameLayout) objArr[8], (ImageView) objArr[2]);
        this.mDirtyFlags = -1;
        this.fullScreenView.setTag(null);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.navigationView.setTag(null);
        this.pipView.setTag(null);
        this.playView.setTag(null);
        this.replayView.setTag(null);
        this.volumeView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemVideoDetailViewPartBinding
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
            ViewBindingAdapters.clickListener(this.fullScreenView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.navigationView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.pipView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.playView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.replayView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.volumeView, onClickListener, bool);
        }
    }
}
