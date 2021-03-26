package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemNewAddBindingImpl extends ItemNewAddBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemNewAddBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemNewAddBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.titleView.setTag(null);
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
        if (279 == i) {
            setTitleText((String) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (171 == i) {
            setIsMyAlbum(((Boolean) obj).booleanValue());
        } else if (3 != i) {
            return false;
        } else {
            setActionText((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNewAddBinding
    public void setTitleText(String str) {
        this.mTitleText = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(279);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNewAddBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNewAddBinding
    public void setIsMyAlbum(boolean z) {
        this.mIsMyAlbum = z;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(171);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNewAddBinding
    public void setActionText(String str) {
        this.mActionText = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mTitleText;
        View.OnClickListener onClickListener = this.mClick;
        boolean z = this.mIsMyAlbum;
        String str2 = this.mActionText;
        int i = 0;
        int i2 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (i2 != 0) {
                j |= z ? 64 : 32;
            }
            if (!z) {
                i = 8;
            }
        }
        if ((24 & j) != 0) {
            TextViewBindingAdapter.setText(this.actionView, str2);
        }
        if ((j & 20) != 0) {
            this.actionView.setVisibility(i);
        }
        if ((18 & j) != 0) {
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, null);
        }
        if ((j & 17) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str);
        }
    }
}
