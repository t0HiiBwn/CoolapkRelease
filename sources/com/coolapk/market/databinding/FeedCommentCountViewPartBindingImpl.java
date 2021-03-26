package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.SimpleIndicatorView;

public class FeedCommentCountViewPartBindingImpl extends FeedCommentCountViewPartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362570, 1);
        sparseIntArray.put(2131361887, 2);
        sparseIntArray.put(2131362262, 3);
        sparseIntArray.put(2131362862, 4);
        sparseIntArray.put(2131362563, 5);
        sparseIntArray.put(2131362562, 6);
        sparseIntArray.put(2131362561, 7);
        sparseIntArray.put(2131363414, 8);
        sparseIntArray.put(2131362600, 9);
        sparseIntArray.put(2131362423, 10);
        sparseIntArray.put(2131362741, 11);
    }

    public FeedCommentCountViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private FeedCommentCountViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (FrameLayout) objArr[0], (ImageView) objArr[3], (View) objArr[10], (ImageView) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[5], (FrameLayout) objArr[1], (TextView) objArr[9], (SimpleIndicatorView) objArr[11], (TextView) objArr[4], (Space) objArr[8]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
