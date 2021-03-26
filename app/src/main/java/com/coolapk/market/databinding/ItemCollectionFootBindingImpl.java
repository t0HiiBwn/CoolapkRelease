package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemCollectionFootBindingImpl extends ItemCollectionFootBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362316, 4);
        sparseIntArray.put(2131362579, 5);
        sparseIntArray.put(2131362581, 6);
        sparseIntArray.put(2131362843, 7);
        sparseIntArray.put(2131362849, 8);
        sparseIntArray.put(2131363355, 9);
        sparseIntArray.put(2131363357, 10);
    }

    public ItemCollectionFootBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemCollectionFootBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[4], (ImageView) objArr[5], (TextView) objArr[6], (LinearLayout) objArr[1], (ImageView) objArr[7], (TextView) objArr[8], (LinearLayout) objArr[2], (ImageView) objArr[9], (TextView) objArr[10], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.followView.setTag(null);
        this.likeView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemCollectionFootBinding
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
            ViewBindingAdapters.clickListener(this.followView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.shareView, onClickListener, bool);
        }
    }
}
