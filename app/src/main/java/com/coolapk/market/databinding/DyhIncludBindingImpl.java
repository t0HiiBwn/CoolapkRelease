package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.SlideUpView;
import com.flyco.tablayout.SlidingTabLayout;

public class DyhIncludBindingImpl extends DyhIncludBinding {
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
        sparseIntArray.put(2131362146, 4);
        sparseIntArray.put(2131362639, 5);
        sparseIntArray.put(2131363481, 6);
        sparseIntArray.put(2131362257, 7);
        sparseIntArray.put(2131362656, 8);
        sparseIntArray.put(2131363321, 9);
        sparseIntArray.put(2131362244, 10);
        sparseIntArray.put(2131363305, 11);
        sparseIntArray.put(2131363322, 12);
        sparseIntArray.put(2131363934, 13);
        sparseIntArray.put(2131362306, 14);
        sparseIntArray.put(2131361899, 15);
    }

    public DyhIncludBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private DyhIncludBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[15], (SlideUpView) objArr[4], (ImageView) objArr[10], (ImageView) objArr[7], (FrameLayout) objArr[14], (EditText) objArr[3], (LinearLayout) objArr[5], (TextView) objArr[2], (LinearLayout) objArr[8], (DrawSystemBarFrameLayout) objArr[0], (ImageView) objArr[11], (LinearLayout) objArr[9], (View) objArr[12], (SlidingTabLayout) objArr[6], (ImageView) objArr[1], (ScrollStateViewPager) objArr[13]);
        this.mDirtyFlags = -1;
        this.editText.setTag(null);
        this.hintText.setTag(null);
        this.mainContent.setTag(null);
        this.titleImgView.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 1) != 0) {
            ThemeBindingAdapters.setEditTextTint(this.editText, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.hintText, "colorAccent");
            ThemeBindingAdapters.setTintColor(this.titleImgView, "colorAccent");
        }
    }
}
