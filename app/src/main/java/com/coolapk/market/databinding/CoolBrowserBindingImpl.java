package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.google.android.material.appbar.AppBarLayout;

public class CoolBrowserBindingImpl extends CoolBrowserBinding {
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
        sparseIntArray.put(2131362860, 17);
        sparseIntArray.put(2131361886, 18);
        sparseIntArray.put(2131363592, 19);
        sparseIntArray.put(2131362150, 20);
        sparseIntArray.put(2131363068, 21);
    }

    public CoolBrowserBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private CoolBrowserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageButton) objArr[8], (ImageButton) objArr[5], (LinearLayout) objArr[18], (ImageButton) objArr[9], (ImageButton) objArr[11], (ImageButton) objArr[10], (ImageButton) objArr[6], (ImageButton) objArr[3], (ImageButton) objArr[2], (AppBarLayout) objArr[1], (FrameLayout) objArr[13], (LinearLayout) objArr[20], (ImageButton) objArr[16], (ImageButton) objArr[14], (ImageButton) objArr[15], (EditText) objArr[7], (RelativeLayout) objArr[17], (TextView) objArr[4], (CoordinatorLayout) objArr[0], (View) objArr[12], (RecyclerView) objArr[21], (FrameLayout) objArr[19]);
        this.mDirtyFlags = -1;
        this.actionBackward.setTag(null);
        this.actionClear.setTag(null);
        this.actionForward.setTag(null);
        this.actionMore.setTag(null);
        this.actionPage.setTag(null);
        this.actionQrcode.setTag(null);
        this.actionRefresh.setTag(null);
        this.actionSearchEngine.setTag(null);
        this.appBar.setTag(null);
        this.bottomMaskView.setTag(null);
        this.buttonAdd.setTag(null);
        this.buttonClearAll.setTag(null);
        this.buttonHome.setTag(null);
        this.editText.setTag(null);
        this.linkTextView.setTag(null);
        this.mainContent.setTag(null);
        this.maskView.setTag(null);
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

    @Override // com.coolapk.market.databinding.CoolBrowserBinding
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
            ViewBindingAdapters.clickListener(this.actionBackward, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionClear, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionForward, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionMore, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionPage, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionQrcode, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionRefresh, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionSearchEngine, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.bottomMaskView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonAdd, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonClearAll, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonHome, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.editText, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.linkTextView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.maskView, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
        }
    }
}
