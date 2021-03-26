package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.view.KeyBoardLayout;

public class ShareFeedV8BindingImpl extends ShareFeedV8Binding {
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
        sparseIntArray.put(2131363593, 5);
        sparseIntArray.put(2131362441, 6);
        sparseIntArray.put(2131363397, 7);
        sparseIntArray.put(2131362127, 8);
        sparseIntArray.put(2131362903, 9);
        sparseIntArray.put(2131362883, 10);
    }

    public ShareFeedV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ShareFeedV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (LinearLayout) objArr[8], (ImageView) objArr[1], (EditText) objArr[6], (KeyBoardLayout) objArr[0], (TextView) objArr[10], (ImageView) objArr[9], (ImageView) objArr[4], (View) objArr[7], (TextView) objArr[2], (LinearLayout) objArr[5]);
        this.mDirtyFlags = -1;
        this.actionDiscovery.setTag(null);
        this.closeView.setTag(null);
        this.keyBoardInteractLayout.setTag(null);
        this.menuCloseKeyboard.setTag(null);
        this.submitView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ShareFeedV8Binding
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
            ViewBindingAdapters.clickListener(this.actionDiscovery, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.closeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuCloseKeyboard, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.submitView, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.submitView, "colorAccent");
        }
    }
}
