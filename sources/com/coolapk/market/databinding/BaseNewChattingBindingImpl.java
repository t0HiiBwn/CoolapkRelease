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
import com.coolapk.market.view.message.NewBaseChatActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.google.android.material.appbar.AppBarLayout;

public class BaseNewChattingBindingImpl extends BaseNewChattingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362067, 7);
        sparseIntArray.put(2131362316, 8);
        sparseIntArray.put(2131363592, 9);
        sparseIntArray.put(2131361922, 10);
        sparseIntArray.put(2131362450, 11);
    }

    public BaseNewChattingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private BaseNewChattingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[10], (AppBarLayout) objArr[7], (LinearLayout) objArr[8], (EditText) objArr[3], (EmotionPanel) objArr[11], (ImageView) objArr[5], (CoordinatorLayout) objArr[0], (ImageView) objArr[2], (ImageView) objArr[4], (ProgressBar) objArr[6], (Toolbar) objArr[1], (FrameLayout) objArr[9]);
        this.mDirtyFlags = -1;
        this.editText.setTag(null);
        this.imagePick.setTag(null);
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
            this.mDirtyFlags = 32;
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
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((NewBaseChatActivity.ViewMode) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.BaseNewChattingBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.BaseNewChattingBinding
    public void setViewModel(NewBaseChatActivity.ViewMode viewMode) {
        updateRegistration(0, viewMode);
        this.mViewModel = viewMode;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((NewBaseChatActivity.ViewMode) obj, i2);
    }

    private boolean onChangeViewModel(NewBaseChatActivity.ViewMode viewMode, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 255) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 251) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 225) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        NewBaseChatActivity.ViewMode viewMode = this.mViewModel;
        int i5 = 0;
        if ((61 & j) != 0) {
            int i6 = ((j & 37) > 0 ? 1 : ((j & 37) == 0 ? 0 : -1));
            if (i6 != 0) {
                if (viewMode != null) {
                    z3 = viewMode.isShowPostView();
                } else {
                    z3 = false;
                }
                if (i6 != 0) {
                    j |= z3 ? 128 : 64;
                }
                if (!z3) {
                    i2 = 8;
                    i3 = ((j & 49) > 0 ? 1 : ((j & 49) == 0 ? 0 : -1));
                    if (i3 != 0) {
                        if (viewMode != null) {
                            z2 = viewMode.isPosting();
                        } else {
                            z2 = false;
                        }
                        if (i3 != 0) {
                            j |= z2 ? 2048 : 1024;
                        }
                        if (!z2) {
                            i = 8;
                            i4 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
                            if (i4 != 0) {
                                if (viewMode != null) {
                                    z = viewMode.isShowImapick();
                                } else {
                                    z = false;
                                }
                                if (i4 != 0) {
                                    j |= z ? 512 : 256;
                                }
                                if (!z) {
                                    i5 = 8;
                                }
                            }
                        }
                    }
                    i = 0;
                    i4 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
                    if (i4 != 0) {
                    }
                }
            }
            i2 = 0;
            i3 = ((j & 49) > 0 ? 1 : ((j & 49) == 0 ? 0 : -1));
            if (i3 != 0) {
            }
            i = 0;
            i4 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
            if (i4 != 0) {
            }
        } else {
            i2 = 0;
            i = 0;
        }
        if ((j & 34) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.editText, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.imagePick, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuEmotion, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuPost, onClickListener, bool);
        }
        if ((j & 41) != 0) {
            this.imagePick.setVisibility(i5);
        }
        if ((32 & j) != 0) {
            ThemeBindingAdapters.setTintColor(this.menuPost, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
            ThemeBindingAdapters.setBackgroundColor(this.toolbar, "colorPrimary");
        }
        if ((j & 37) != 0) {
            this.menuPost.setVisibility(i2);
        }
        if ((j & 49) != 0) {
            this.progressBar.setVisibility(i);
        }
    }
}
