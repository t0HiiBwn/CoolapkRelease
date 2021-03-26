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
import com.coolapk.market.widget.view.TimeTextView;

public class VideoControllerBindingImpl extends VideoControllerBinding {
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
        sparseIntArray.put(2131363626, 8);
        sparseIntArray.put(2131363604, 9);
        sparseIntArray.put(2131362134, 10);
        sparseIntArray.put(2131362354, 11);
        sparseIntArray.put(2131363348, 12);
        sparseIntArray.put(2131363635, 13);
        sparseIntArray.put(2131362884, 14);
        sparseIntArray.put(2131362883, 15);
        sparseIntArray.put(2131363160, 16);
    }

    public VideoControllerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private VideoControllerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[10], (TimeTextView) objArr[11], (ImageView) objArr[6], (FrameLayout) objArr[0], (TextView) objArr[15], (LinearLayout) objArr[14], (ImageView) objArr[4], (ImageView) objArr[1], (ImageView) objArr[2], (ImageView) objArr[5], (ProgressBar) objArr[16], (LinearLayout) objArr[7], (SeekBar) objArr[12], (ImageView) objArr[3], (TextView) objArr[9], (LinearLayout) objArr[8], (TimeTextView) objArr[13]);
        this.mDirtyFlags = -1;
        this.fullScreenView.setTag(null);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.navigationView.setTag(null);
        this.pipView.setTag(null);
        this.playView.setTag(null);
        this.replayView.setTag(null);
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

    @Override // com.coolapk.market.databinding.VideoControllerBinding
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
            ViewBindingAdapters.clickListener(this.shareView, onClickListener, bool);
        }
    }
}
