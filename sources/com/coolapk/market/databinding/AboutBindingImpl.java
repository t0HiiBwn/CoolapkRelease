package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class AboutBindingImpl extends AboutBinding {
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
        sparseIntArray.put(2131362734, 8);
    }

    public AboutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AboutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (LinearLayout) objArr[5], (TextView) objArr[6], (TextView) objArr[8], (ImageView) objArr[1], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.baseView.setTag(null);
        this.checkUpgradeLayout.setTag(null);
        this.checkUpgradeView.setTag(null);
        this.logoView.setTag(null);
        this.openSource.setTag(null);
        this.sloganView.setTag(null);
        this.titleView.setTag(null);
        this.version.setTag(null);
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

    @Override // com.coolapk.market.databinding.AboutBinding
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
            ViewBindingAdapters.clickListener(this.checkUpgradeLayout, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.logoView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.openSource, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.sloganView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.titleView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.version, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            String str = null;
            ViewBindingAdapters.clipView(this.checkUpgradeLayout, str, 24);
            ThemeBindingAdapters.setTextColor(this.checkUpgradeView, "colorAccent");
            ViewBindingAdapters.clipView(this.openSource, str, 23);
        }
    }
}
