package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemRightCoverViewBindingImpl extends ItemRightCoverViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemRightCoverViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemRightCoverViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (ImageView) objArr[2], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.contentView.setTag(null);
        this.extraImageView.setTag(null);
        this.rootView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (221 == i) {
            setPic((String) obj);
        } else if (197 == i) {
            setMessage((String) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemRightCoverViewBinding
    public void setPic(String str) {
        this.mPic = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(221);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemRightCoverViewBinding
    public void setMessage(String str) {
        this.mMessage = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemRightCoverViewBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemRightCoverViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        View.OnClickListener onClickListener;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mPic;
        String str2 = this.mMessage;
        View.OnClickListener onClickListener2 = this.mClick;
        int i = ((17 & j) > 0 ? 1 : ((17 & j) == 0 ? 0 : -1));
        int i2 = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if ((18 & j) != 0) {
            TextViewBindingAdapter.setText(this.contentView, str2);
        }
        if (i != 0) {
            Boolean bool = null;
            onClickListener = onClickListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extraImageView, str, null, 2131231702, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        } else {
            onClickListener = onClickListener2;
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.extraImageView, onClickListener, null);
        }
        if ((j & 16) != 0) {
            ViewBindingAdapters.clipView(this.rootView, null, 3);
        }
    }
}
