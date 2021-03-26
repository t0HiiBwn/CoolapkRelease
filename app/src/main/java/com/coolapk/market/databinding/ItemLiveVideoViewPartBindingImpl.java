package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class ItemLiveVideoViewPartBindingImpl extends ItemLiveVideoViewPartBinding {
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
        sparseIntArray.put(2131363916, 10);
        sparseIntArray.put(2131363870, 11);
        sparseIntArray.put(2131362692, 12);
        sparseIntArray.put(2131363582, 13);
        sparseIntArray.put(2131363869, 14);
        sparseIntArray.put(2131363459, 15);
        sparseIntArray.put(2131362734, 16);
        sparseIntArray.put(2131363868, 17);
        sparseIntArray.put(2131362871, 18);
        sparseIntArray.put(2131362356, 19);
        sparseIntArray.put(2131362131, 20);
        sparseIntArray.put(2131362868, 21);
        sparseIntArray.put(2131362348, 22);
        sparseIntArray.put(2131363332, 23);
        sparseIntArray.put(2131362358, 24);
        sparseIntArray.put(2131362359, 25);
        sparseIntArray.put(2131362362, 26);
        sparseIntArray.put(2131362361, 27);
        sparseIntArray.put(2131363613, 28);
        sparseIntArray.put(2131362873, 29);
        sparseIntArray.put(2131362870, 30);
        sparseIntArray.put(2131363604, 31);
        sparseIntArray.put(2131363086, 32);
        sparseIntArray.put(2131363336, 33);
    }

    public ItemLiveVideoViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 34, sIncludes, sViewsWithIds));
    }

    private ItemLiveVideoViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[20], (TextView) objArr[22], (FrameLayout) objArr[19], (ImageView) objArr[4], (ImageView) objArr[24], (EditText) objArr[25], (LinearLayout) objArr[3], (ProgressBar) objArr[27], (ImageView) objArr[26], (ImageView) objArr[5], (ImageView) objArr[12], (TextView) objArr[16], (MaxWidthFrameLayout) objArr[0], (TextView) objArr[7], (TextView) objArr[21], (TextView) objArr[30], (TextView) objArr[18], (LinearLayout) objArr[29], (ImageView) objArr[9], (ImageView) objArr[6], (TextView) objArr[32], (ImageView) objArr[1], (ImageView) objArr[2], (SeekBar) objArr[23], (FrameLayout) objArr[33], (ImageView) objArr[8], (TextView) objArr[15], (TextView) objArr[13], (LinearLayout) objArr[31], (TextView) objArr[28], (LinearLayout) objArr[17], (RelativeLayout) objArr[14], (FrameLayout) objArr[11], (FrameLayout) objArr[10]);
        this.mDirtyFlags = -1;
        this.danmakuOpenView.setTag(null);
        this.danmakuSendLayout.setTag(null);
        this.fullScreenView.setTag(null);
        this.itemView.setTag(null);
        this.lineTextView.setTag(null);
        this.moreView.setTag(null);
        this.navigationView.setTag(null);
        this.playView.setTag(null);
        this.refreshView.setTag(null);
        this.shareView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemLiveVideoViewPartBinding
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
            ViewBindingAdapters.clickListener(this.danmakuOpenView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.fullScreenView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.lineTextView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.navigationView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.playView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.refreshView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.shareView, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.danmakuSendLayout, null, 3);
        }
    }
}
