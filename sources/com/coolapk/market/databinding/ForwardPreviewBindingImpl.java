package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ForwardPreviewBindingImpl extends ForwardPreviewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362316, 8);
        sparseIntArray.put(2131362441, 9);
        sparseIntArray.put(2131363533, 10);
        sparseIntArray.put(2131362150, 11);
        sparseIntArray.put(2131363221, 12);
    }

    public ForwardPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ForwardPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[11], (TextView) objArr[7], (LinearLayout) objArr[8], (EditText) objArr[9], (TextView) objArr[3], (CheckBox) objArr[2], (TextView) objArr[4], (ImageView) objArr[6], (DrawSystemBarFrameLayout) objArr[0], (TextView) objArr[1], (RecyclerView) objArr[12], (CoolEllipsizeTextView) objArr[10]);
        this.mDirtyFlags = -1;
        this.cancelButton.setTag(null);
        this.forwardAndReplyTextView.setTag(null);
        this.forwardAndReplyView.setTag(null);
        this.fullScreenButton.setTag(null);
        this.iconView.setTag(null);
        this.maskView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[5];
        this.mboundView5 = linearLayout;
        linearLayout.setTag(null);
        this.postButton.setTag(null);
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

    @Override // com.coolapk.market.databinding.ForwardPreviewBinding
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
            ViewBindingAdapters.clickListener(this.cancelButton, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.forwardAndReplyTextView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.fullScreenButton, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.maskView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.postButton, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTint(this.forwardAndReplyView, "colorAccent");
            String str = null;
            ViewBindingAdapters.clipView(this.iconView, str, 4);
            ViewBindingAdapters.clipView(this.mboundView5, str, 4);
            ThemeBindingAdapters.setTextColor(this.postButton, "colorAccent");
        }
    }
}
