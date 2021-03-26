package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.TimeTextView;

public class ItemFeedVideoDetailViewPartBindingImpl extends ItemFeedVideoDetailViewPartBinding {
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
        sparseIntArray.put(2131363943, 8);
        sparseIntArray.put(2131363937, 9);
        sparseIntArray.put(2131363626, 10);
        sparseIntArray.put(2131362538, 11);
        sparseIntArray.put(2131363900, 12);
        sparseIntArray.put(2131363914, 13);
        sparseIntArray.put(2131362544, 14);
        sparseIntArray.put(2131363604, 15);
        sparseIntArray.put(2131362134, 16);
        sparseIntArray.put(2131362354, 17);
        sparseIntArray.put(2131363348, 18);
        sparseIntArray.put(2131363635, 19);
        sparseIntArray.put(2131362884, 20);
        sparseIntArray.put(2131362883, 21);
        sparseIntArray.put(2131363551, 22);
        sparseIntArray.put(2131361887, 23);
        sparseIntArray.put(2131362862, 24);
        sparseIntArray.put(2131362854, 25);
        sparseIntArray.put(2131362858, 26);
        sparseIntArray.put(2131362296, 27);
        sparseIntArray.put(2131362295, 28);
        sparseIntArray.put(2131362527, 29);
        sparseIntArray.put(2131362525, 30);
        sparseIntArray.put(2131362526, 31);
        sparseIntArray.put(2131363374, 32);
        sparseIntArray.put(2131363372, 33);
        sparseIntArray.put(2131363160, 34);
        sparseIntArray.put(2131362290, 35);
    }

    public ItemFeedVideoDetailViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 36, sIncludes, sViewsWithIds));
    }

    private ItemFeedVideoDetailViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[23], (LinearLayout) objArr[16], (FrameLayout) objArr[35], (TextView) objArr[28], (LinearLayout) objArr[27], (TimeTextView) objArr[17], (ImageView) objArr[30], (TextView) objArr[31], (LinearLayout) objArr[29], (RelativeLayout) objArr[11], (TextView) objArr[14], (ImageView) objArr[6], (FrameLayout) objArr[0], (ImageView) objArr[25], (TextView) objArr[26], (LinearLayout) objArr[24], (TextView) objArr[21], (LinearLayout) objArr[20], (ImageView) objArr[4], (ImageView) objArr[1], (ImageView) objArr[3], (ImageView) objArr[5], (ProgressBar) objArr[34], (LinearLayout) objArr[7], (SeekBar) objArr[18], (TextView) objArr[33], (LinearLayout) objArr[32], (TextView) objArr[22], (TextView) objArr[15], (LinearLayout) objArr[10], (TimeTextView) objArr[19], (UserAvatarView) objArr[12], (TextView) objArr[13], (FrameLayout) objArr[9], (FrameLayout) objArr[8], (ImageView) objArr[2]);
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

    @Override // com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBinding
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
