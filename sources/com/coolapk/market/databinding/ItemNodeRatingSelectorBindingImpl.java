package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemNodeRatingSelectorBindingImpl extends ItemNodeRatingSelectorBinding {
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
        sparseIntArray.put(2131362645, 7);
        sparseIntArray.put(2131363032, 8);
        sparseIntArray.put(2131363926, 9);
        sparseIntArray.put(2131362188, 10);
        sparseIntArray.put(2131363076, 11);
    }

    public ItemNodeRatingSelectorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemNodeRatingSelectorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckBox) objArr[10], (CheckBox) objArr[7], (LinearLayout) objArr[0], (CheckBox) objArr[8], (CheckBox) objArr[11], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1], (CheckBox) objArr[9]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.star1View.setTag(null);
        this.star2View.setTag(null);
        this.star3View.setTag(null);
        this.star4View.setTag(null);
        this.star5View.setTag(null);
        this.starAllView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemNodeRatingSelectorBinding
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
            ViewBindingAdapters.clickListener(this.star1View, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.star2View, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.star3View, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.star4View, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.star5View, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.starAllView, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            String str = null;
            ViewBindingAdapters.clipView(this.star1View, str, 4);
            ViewBindingAdapters.clipView(this.star2View, str, 4);
            ViewBindingAdapters.clipView(this.star3View, str, 4);
            ViewBindingAdapters.clipView(this.star4View, str, 4);
            ViewBindingAdapters.clipView(this.star5View, str, 4);
            ViewBindingAdapters.clipView(this.starAllView, str, 4);
        }
    }
}
