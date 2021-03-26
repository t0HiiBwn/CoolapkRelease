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

public class ItemCenterLoginBindingImpl extends ItemCenterLoginBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final LinearLayout mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363603, 7);
        sparseIntArray.put(2131362129, 8);
        sparseIntArray.put(2131362886, 9);
    }

    public ItemCenterLoginBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemCenterLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (LinearLayout) objArr[4], (LinearLayout) objArr[5], (TextView) objArr[6], (LinearLayout) objArr[1], (LinearLayout) objArr[3], (TextView) objArr[9], (ImageView) objArr[7]);
        this.mDirtyFlags = -1;
        this.buttonLoginByPhone.setTag(null);
        this.buttonLoginBySocial.setTag(null);
        this.buttonRegisterByPhone.setTag(null);
        this.itemView.setTag(null);
        this.loginItemText.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout;
        linearLayout.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemCenterLoginBinding
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
            ViewBindingAdapters.clickListener(this.buttonLoginByPhone, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonLoginBySocial, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonRegisterByPhone, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.loginItemText, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.mboundView2, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.itemView, null, 8);
        }
    }
}
