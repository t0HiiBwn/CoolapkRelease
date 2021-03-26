package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.view.base.BaseChatActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.google.android.material.appbar.AppBarLayout;

public class BaseChattingBindingImpl extends BaseChattingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362069, 6);
        sparseIntArray.put(2131362322, 7);
        sparseIntArray.put(2131363614, 8);
        sparseIntArray.put(2131361923, 9);
        sparseIntArray.put(2131362457, 10);
    }

    public BaseChattingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private BaseChattingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[9], (AppBarLayout) objArr[6], (LinearLayout) objArr[7], (EditText) objArr[3], (EmotionPanel) objArr[10], (CoordinatorLayout) objArr[0], (ImageView) objArr[2], (ImageView) objArr[4], (ProgressBar) objArr[5], (Toolbar) objArr[1], (FrameLayout) objArr[8]);
        this.mDirtyFlags = -1;
        this.editText.setTag(null);
        this.mainContent.setTag(null);
        this.menuEmotion.setTag(null);
        this.menuPost.setTag(null);
        this.progressBar.setTag(null);
        this.toolbar.setTag(null);
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
        if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((BaseChatActivity.ViewMode) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.BaseChattingBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.BaseChattingBinding
    public void setViewModel(BaseChatActivity.ViewMode viewMode) {
        updateRegistration(0, viewMode);
        this.mViewModel = viewMode;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((BaseChatActivity.ViewMode) obj, i2);
    }

    private boolean onChangeViewModel(BaseChatActivity.ViewMode viewMode, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 226) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        BaseChatActivity.ViewMode viewMode = this.mViewModel;
        int i2 = 0;
        int i3 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (viewMode != null) {
                z = viewMode.isPosting();
            } else {
                z = false;
            }
            if (i3 != 0) {
                if (z) {
                    j3 = j | 32;
                    j2 = 128;
                } else {
                    j3 = j | 16;
                    j2 = 64;
                }
                j = j3 | j2;
            }
            int i4 = z ? 8 : 0;
            if (!z) {
                i2 = 8;
            }
            i = i2;
            i2 = i4;
        } else {
            i = 0;
        }
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setEditTextTint(this.editText, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
            ThemeBindingAdapters.setBackgroundColor(this.toolbar, "colorPrimary");
        }
        if ((10 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.editText, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuEmotion, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuPost, onClickListener, bool);
        }
        if ((j & 13) != 0) {
            this.menuPost.setVisibility(i2);
            this.progressBar.setVisibility(i);
        }
    }
}
