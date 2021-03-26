package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class CenterV9SocialDialogBindingImpl extends CenterV9SocialDialogBinding {
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
        sparseIntArray.put(2131363533, 5);
        sparseIntArray.put(2131363562, 6);
    }

    public CenterV9SocialDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private CenterV9SocialDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (LinearLayout) objArr[2], (LinearLayout) objArr[1], (LinearLayout) objArr[3], (LinearLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[6]);
        this.mDirtyFlags = -1;
        this.buttonLoginByPhone.setTag(null);
        this.buttonLoginByQq.setTag(null);
        this.buttonLoginByWechat.setTag(null);
        this.buttonLoginByWeibo.setTag(null);
        this.contentView.setTag(null);
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

    @Override // com.coolapk.market.databinding.CenterV9SocialDialogBinding
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
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.buttonLoginByPhone, "colorAccent");
        }
        if (i != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.buttonLoginByPhone, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonLoginByQq, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonLoginByWechat, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonLoginByWeibo, onClickListener, bool);
        }
    }
}
