package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.view.base.refresh.RefreshRecyclerViewModel;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.ScrollChildSwipeRefreshLayout;

public class RefreshRecyclerBindingImpl extends RefreshRecyclerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363489, 6);
        sparseIntArray.put(2131362213, 7);
    }

    public RefreshRecyclerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private RefreshRecyclerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Space) objArr[7], (ImageView) objArr[4], (TextView) objArr[5], (RelativeLayout) objArr[3], (ProgressBar) objArr[2], (PreventAutoScrollRecyclerView) objArr[1], (ScrollChildSwipeRefreshLayout) objArr[6]);
        this.mDirtyFlags = -1;
        this.emptyImageView.setTag(null);
        this.emptyTextView.setTag(null);
        this.emptyView.setTag(null);
        this.loadingView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (309 != i) {
            return false;
        }
        setViewModel((RefreshRecyclerViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.RefreshRecyclerBinding
    public void setViewModel(RefreshRecyclerViewModel refreshRecyclerViewModel) {
        updateRegistration(0, refreshRecyclerViewModel);
        this.mViewModel = refreshRecyclerViewModel;
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
        return onChangeViewModel((RefreshRecyclerViewModel) obj, i2);
    }

    private boolean onChangeViewModel(RefreshRecyclerViewModel refreshRecyclerViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 230) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 187) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 92) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 90) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i != 91) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        String str2;
        int i11;
        int i12;
        int i13;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        RefreshRecyclerViewModel refreshRecyclerViewModel = this.mViewModel;
        int i14 = 0;
        if ((127 & j) != 0) {
            int i15 = ((j & 67) > 0 ? 1 : ((j & 67) == 0 ? 0 : -1));
            if (i15 != 0) {
                if (refreshRecyclerViewModel != null) {
                    z3 = refreshRecyclerViewModel.getRecyclerViewVisibility();
                } else {
                    z3 = false;
                }
                if (i15 != 0) {
                    j |= z3 ? 4096 : 2048;
                }
                if (!z3) {
                    i6 = 4;
                    i3 = 8;
                    i7 = ((j & 69) > 0 ? 1 : ((j & 69) == 0 ? 0 : -1));
                    if (i7 != 0) {
                        if (refreshRecyclerViewModel != null) {
                            z2 = refreshRecyclerViewModel.isLoading();
                        } else {
                            z2 = false;
                        }
                        if (i7 != 0) {
                            j |= z2 ? 65536 : 32768;
                        }
                        if (!z2) {
                            i8 = 8;
                            boolean z4 = true;
                            i9 = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
                            if (i9 != 0) {
                                if (refreshRecyclerViewModel != null) {
                                    str2 = refreshRecyclerViewModel.getEmptyText();
                                } else {
                                    str2 = null;
                                }
                                boolean z5 = str2 != null;
                                if (i9 != 0) {
                                    j |= z5 ? 16384 : 8192;
                                }
                                if (!z5) {
                                    i10 = 8;
                                    i11 = ((j & 81) > 0 ? 1 : ((j & 81) == 0 ? 0 : -1));
                                    if (i11 == 0) {
                                        if (refreshRecyclerViewModel != null) {
                                            i12 = refreshRecyclerViewModel.getEmptyImageRes();
                                        } else {
                                            i12 = 0;
                                        }
                                        if (i12 == 0) {
                                            z4 = false;
                                        }
                                        if (i11 != 0) {
                                            j |= z4 ? 256 : 128;
                                        }
                                        if (z4) {
                                            i3 = 0;
                                        }
                                    } else {
                                        i3 = 0;
                                        i12 = 0;
                                    }
                                    i13 = ((j & 73) > 0 ? 1 : ((j & 73) == 0 ? 0 : -1));
                                    if (i13 == 0) {
                                        if (refreshRecyclerViewModel != null) {
                                            z = refreshRecyclerViewModel.getEmptyViewVisibility();
                                        } else {
                                            z = false;
                                        }
                                        if (i13 != 0) {
                                            j |= z ? 1024 : 512;
                                        }
                                        if (!z) {
                                            i14 = 4;
                                        }
                                        i = i6;
                                        i4 = i14;
                                        i2 = i8;
                                        i5 = i10;
                                        i14 = i12;
                                    } else {
                                        i = i6;
                                        i2 = i8;
                                        i5 = i10;
                                        i14 = i12;
                                        i4 = 0;
                                    }
                                    str = str2;
                                }
                            } else {
                                str2 = null;
                            }
                            i10 = 0;
                            i11 = ((j & 81) > 0 ? 1 : ((j & 81) == 0 ? 0 : -1));
                            if (i11 == 0) {
                            }
                            i13 = ((j & 73) > 0 ? 1 : ((j & 73) == 0 ? 0 : -1));
                            if (i13 == 0) {
                            }
                            str = str2;
                        }
                    }
                    i8 = 0;
                    boolean z4 = true;
                    i9 = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
                    if (i9 != 0) {
                    }
                    i10 = 0;
                    i11 = ((j & 81) > 0 ? 1 : ((j & 81) == 0 ? 0 : -1));
                    if (i11 == 0) {
                    }
                    i13 = ((j & 73) > 0 ? 1 : ((j & 73) == 0 ? 0 : -1));
                    if (i13 == 0) {
                    }
                    str = str2;
                }
            }
            i6 = 0;
            i3 = 8;
            i7 = ((j & 69) > 0 ? 1 : ((j & 69) == 0 ? 0 : -1));
            if (i7 != 0) {
            }
            i8 = 0;
            boolean z4 = true;
            i9 = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
            if (i9 != 0) {
            }
            i10 = 0;
            i11 = ((j & 81) > 0 ? 1 : ((j & 81) == 0 ? 0 : -1));
            if (i11 == 0) {
            }
            i13 = ((j & 73) > 0 ? 1 : ((j & 73) == 0 ? 0 : -1));
            if (i13 == 0) {
            }
            str = str2;
        } else {
            str = null;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 81) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.emptyImageView, Converters.convertColorToDrawable(i14));
            this.emptyImageView.setVisibility(i3);
        }
        if ((j & 97) != 0) {
            this.emptyTextView.setVisibility(i5);
            String str3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.emptyTextView, str, null, str3, null, null, str3);
        }
        if ((j & 73) != 0) {
            this.emptyView.setVisibility(i4);
        }
        if ((69 & j) != 0) {
            this.loadingView.setVisibility(i2);
        }
        if ((j & 67) != 0) {
            this.recyclerView.setVisibility(i);
        }
    }
}
