package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class ItemOptionsTitleBindingImpl extends ItemOptionsTitleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemOptionsTitleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemOptionsTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.option1View.setTag(null);
        this.option2View.setTag(null);
        this.titleView.setTag(null);
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
        if (214 == i) {
            setOption2((String) obj);
        } else if (213 == i) {
            setOption1((String) obj);
        } else if (278 != i) {
            return false;
        } else {
            setTitle((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemOptionsTitleBinding
    public void setOption2(String str) {
        this.mOption2 = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(214);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemOptionsTitleBinding
    public void setOption1(String str) {
        this.mOption1 = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(213);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemOptionsTitleBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(278);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mOption2;
        String str2 = this.mOption1;
        String str3 = this.mTitle;
        int i4 = 8;
        boolean z = true;
        int i5 = 0;
        int i6 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean z2 = str != null;
            if (i6 != 0) {
                j |= z2 ? 128 : 64;
            }
            if (!z2) {
                i = 8;
                i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
                if (i2 != 0) {
                    if (str2 == null) {
                        z = false;
                    }
                    if (i2 != 0) {
                        j |= z ? 32 : 16;
                    }
                    if (z) {
                        i4 = 0;
                    }
                    i5 = i4;
                }
                i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
                if ((j & 10) != 0) {
                    TextViewBindingAdapter.setText(this.option1View, str2);
                    this.option1View.setVisibility(i5);
                }
                if ((8 & j) != 0) {
                    ThemeBindingAdapters.setTextColor(this.option1View, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.option2View, "colorAccent");
                }
                if ((j & 9) != 0) {
                    TextViewBindingAdapter.setText(this.option2View, str);
                    this.option2View.setVisibility(i);
                }
                if (i3 == 0) {
                    TextViewBindingAdapter.setText(this.titleView, str3);
                    return;
                }
                return;
            }
        }
        i = 0;
        i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((j & 10) != 0) {
        }
        if ((8 & j) != 0) {
        }
        if ((j & 9) != 0) {
        }
        if (i3 == 0) {
        }
    }
}
