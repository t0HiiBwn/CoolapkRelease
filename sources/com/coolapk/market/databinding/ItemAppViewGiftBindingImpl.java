package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.Gift;
import com.coolapk.market.view.app.AppViewViewModel;

public class ItemAppViewGiftBindingImpl extends ItemAppViewGiftBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final LinearLayout mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final ImageView mboundView6;
    private final TextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362090, 8);
    }

    public ItemAppViewGiftBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemAppViewGiftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[8]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.mboundView5 = textView4;
        textView4.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.mboundView6 = imageView;
        imageView.setTag(null);
        TextView textView5 = (TextView) objArr[7];
        this.mboundView7 = textView5;
        textView5.setTag(null);
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
        if (309 != i) {
            return false;
        }
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewGiftBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(0, appViewViewModel);
        this.mViewModel = appViewViewModel;
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
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 114) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i != 237) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        Gift gift;
        Gift gift2;
        String title;
        String str;
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        int i5 = 0;
        String str2 = null;
        if ((15 & j) != 0) {
            z = true;
            int i6 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
            if (i6 != 0) {
                if (appViewViewModel != null) {
                    gift = appViewViewModel.getFirstGift();
                } else {
                    gift = null;
                }
                i4 = gift != null ? 1 : 0;
                if (i6 != 0) {
                    j = i4 != 0 ? j | 32 : j | 16;
                }
            } else {
                gift = null;
                i4 = 0;
            }
            int i7 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i7 != 0) {
                if (appViewViewModel != null) {
                    gift2 = appViewViewModel.getSecondGift();
                } else {
                    gift2 = null;
                }
                if (gift2 == null) {
                    z = false;
                }
                if (i7 != 0) {
                    j = z ? j | 128 | 512 : j | 64 | 256;
                }
                if (!z) {
                    i5 = 8;
                }
                i5 = i4;
                i = i5;
                title = ((512 & j) != 0 || gift2 == null) ? null : gift2.getTitle();
                if ((32 & j) != 0 || gift == null) {
                    str = null;
                } else {
                    str = gift.getTitle();
                }
                i2 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
                if (i2 == 0 || i5 == 0) {
                    str = null;
                }
                i3 = ((13 & j) > 0 ? 1 : ((13 & j) == 0 ? 0 : -1));
                if (i3 != 0 && z) {
                    str2 = title;
                }
                if (i2 != 0) {
                    TextViewBindingAdapter.setText(this.mboundView1, str);
                }
                if ((j & 8) != 0) {
                    ThemeBindingAdapters.setTextColor(this.mboundView2, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.mboundView5, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.mboundView7, "colorAccent");
                }
                if (i3 == 0) {
                    this.mboundView3.setVisibility(i);
                    TextViewBindingAdapter.setText(this.mboundView4, str2);
                    this.mboundView6.setVisibility(i);
                    return;
                }
                return;
            }
            i5 = i4;
            gift2 = null;
        } else {
            gift2 = null;
            gift = null;
        }
        i = 0;
        z = false;
        if ((512 & j) != 0) {
        }
        if ((32 & j) != 0) {
        }
        str = null;
        i2 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
        str = null;
        i3 = ((13 & j) > 0 ? 1 : ((13 & j) == 0 ? 0 : -1));
        str2 = title;
        if (i2 != 0) {
        }
        if ((j & 8) != 0) {
        }
        if (i3 == 0) {
        }
    }
}
