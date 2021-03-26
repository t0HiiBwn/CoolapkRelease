package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedGoods;

public class ShareGoodDialogBindingImpl extends ShareGoodDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363604, 5);
        sparseIntArray.put(2131363455, 6);
        sparseIntArray.put(2131362640, 7);
        sparseIntArray.put(2131362200, 8);
    }

    public ShareGoodDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ShareGoodDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (LinearLayout) objArr[0], (TextView) objArr[7], (LinearLayout) objArr[1], (ProgressBar) objArr[3], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.contentView.setTag(null);
        this.itemView.setTag(null);
        this.loadingView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        this.okButton.setTag(null);
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
        if (198 != i) {
            return false;
        }
        setModel((FeedGoods) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ShareGoodDialogBinding
    public void setModel(FeedGoods feedGoods) {
        this.mModel = feedGoods;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedGoods feedGoods = this.mModel;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean z = feedGoods == null;
            if (i3 != 0) {
                if (z) {
                    j3 = j | 8;
                    j2 = 32;
                } else {
                    j3 = j | 4;
                    j2 = 16;
                }
                j = j3 | j2;
            }
            if (feedGoods != null) {
                str2 = feedGoods.getCover();
            } else {
                str2 = null;
            }
            i = z ? 0 : 8;
            if (z) {
                i2 = 8;
            }
            str = str2;
        } else {
            str = null;
            i = 0;
        }
        if ((3 & j) != 0) {
            this.itemView.setVisibility(i2);
            this.loadingView.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView2, str, null, 2131231419, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
            ViewBindingAdapters.clipView(this.mboundView2, null, 8);
            ThemeBindingAdapters.setTextColor(this.okButton, "colorAccent");
        }
    }
}
