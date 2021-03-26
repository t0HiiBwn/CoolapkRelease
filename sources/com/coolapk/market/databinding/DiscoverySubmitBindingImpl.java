package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class DiscoverySubmitBindingImpl extends DiscoverySubmitBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362322, 4);
        sparseIntArray.put(2131361923, 5);
    }

    public DiscoverySubmitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private DiscoverySubmitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[5], (LinearLayout) objArr[4], (EditText) objArr[1], (ImageView) objArr[2], (ProgressBar) objArr[3]);
        this.mDirtyFlags = -1;
        this.editText.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.menuPost.setTag(null);
        this.progressBar.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (226 == i) {
            setPosting((Boolean) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.DiscoverySubmitBinding
    public void setPosting(Boolean bool) {
        this.mPosting = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(226);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.DiscoverySubmitBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.DiscoverySubmitBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean bool = this.mPosting;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = 0;
        int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                if (safeUnbox) {
                    j3 = j | 32;
                    j2 = 128;
                } else {
                    j3 = j | 16;
                    j2 = 64;
                }
                j = j3 | j2;
            }
            i = safeUnbox ? 0 : 8;
            if (safeUnbox) {
                i2 = 8;
            }
        } else {
            i = 0;
        }
        int i4 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setEditTextTint(this.editText, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
        }
        if ((j & 9) != 0) {
            this.menuPost.setVisibility(i2);
            this.progressBar.setVisibility(i);
        }
        if (i4 != 0) {
            ViewBindingAdapters.clickListener(this.menuPost, onClickListener, null);
        }
    }
}
