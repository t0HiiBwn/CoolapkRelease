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

public class ItemAppViewBaseInfoGiftBindingImpl extends ItemAppViewBaseInfoGiftBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final ImageView mboundView3;
    private final TextView mboundView5;
    private final ImageView mboundView7;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362618, 10);
    }

    public ItemAppViewBaseInfoGiftBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemAppViewBaseInfoGiftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[8], (TextView) objArr[2], (TextView) objArr[6], (LinearLayout) objArr[10], (LinearLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.allGiftView.setTag(null);
        this.fetchGiftView.setTag(null);
        this.fetchGiftView2.setTag(null);
        this.giftView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.mboundView7 = imageView2;
        imageView2.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
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
        if (308 != i) {
            return false;
        }
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewBaseInfoGiftBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(0, appViewViewModel);
        this.mViewModel = appViewViewModel;
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
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 145) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 114) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 236) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 132) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Gift gift;
        boolean z;
        int i;
        int i2;
        String str;
        String str2;
        Gift gift2;
        int i3;
        String str3;
        int i4;
        long j2;
        int i5;
        long j3;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        String str4 = null;
        int i7 = 0;
        if ((63 & j) != 0) {
            boolean z5 = true;
            int i8 = ((j & 37) > 0 ? 1 : ((j & 37) == 0 ? 0 : -1));
            if (i8 != 0) {
                gift2 = appViewViewModel != null ? appViewViewModel.getFirstGift() : null;
                if (gift2 != null) {
                    z4 = gift2.isGet();
                } else {
                    z4 = false;
                }
                if (i8 != 0) {
                    j |= z4 ? 128 : 64;
                }
                z = gift2 != null;
                if ((j & 37) != 0) {
                    j = z ? j | 32768 : j | 16384;
                }
                str2 = z4 ? this.fetchGiftView.getResources().getString(2131886593) : this.fetchGiftView.getResources().getString(2131886821);
            } else {
                gift2 = null;
                str2 = null;
                z = false;
            }
            int i9 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
            if (i9 != 0) {
                gift = appViewViewModel != null ? appViewViewModel.getSecondGift() : null;
                if (gift != null) {
                    z3 = gift.isGet();
                } else {
                    z3 = false;
                }
                if (i9 != 0) {
                    j |= z3 ? 524288 : 262144;
                }
                i4 = gift != null ? 1 : 0;
                if ((j & 41) != 0) {
                    j = i4 != 0 ? j | 512 | 8192 : j | 256 | 4096;
                }
                str = z3 ? this.fetchGiftView2.getResources().getString(2131886593) : this.fetchGiftView2.getResources().getString(2131886821);
                i2 = i4 != 0 ? 0 : 8;
                j2 = 35;
            } else {
                str = null;
                gift = null;
                i2 = 0;
                j2 = 35;
                i4 = 0;
            }
            int i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
            if (i10 != 0) {
                if (appViewViewModel != null) {
                    z2 = appViewViewModel.isHasGift();
                } else {
                    z2 = false;
                }
                if (i10 != 0) {
                    j |= z2 ? 2048 : 1024;
                }
                i5 = z2 ? 0 : 8;
                j3 = 49;
            } else {
                j3 = 49;
                i5 = 0;
            }
            int i11 = ((j & j3) > 0 ? 1 : ((j & j3) == 0 ? 0 : -1));
            if (i11 != 0) {
                if (appViewViewModel != null) {
                    i6 = appViewViewModel.getGiftCount();
                } else {
                    i6 = 0;
                }
                if (i6 <= 1) {
                    z5 = false;
                }
                if (i11 != 0) {
                    j |= z5 ? 131072 : 65536;
                }
                if (!z5) {
                    i7 = 8;
                }
                i3 = i7;
                i = i5;
                i7 = i4;
            } else {
                i = i5;
                i7 = i4;
                i3 = 0;
            }
        } else {
            gift2 = null;
            str2 = null;
            str = null;
            gift = null;
            i3 = 0;
            i2 = 0;
            i = 0;
            z = false;
        }
        String title = ((8192 & j) == 0 || gift == null) ? null : gift.getTitle();
        if ((32768 & j) == 0 || gift2 == null) {
            str3 = null;
        } else {
            str3 = gift2.getTitle();
        }
        int i12 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
        if (i12 == 0 || i7 == 0) {
            title = null;
        }
        int i13 = ((j & 37) > 0 ? 1 : ((j & 37) == 0 ? 0 : -1));
        if (i13 != 0 && z) {
            str4 = str3;
        }
        if ((49 & j) != 0) {
            this.allGiftView.setVisibility(i3);
            this.mboundView7.setVisibility(i3);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.fetchGiftView, str2);
            TextViewBindingAdapter.setText(this.mboundView1, str4);
        }
        if ((32 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.fetchGiftView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.fetchGiftView2, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView9, "colorAccent");
        }
        if (i12 != 0) {
            TextViewBindingAdapter.setText(this.fetchGiftView2, str);
            this.giftView2.setVisibility(i2);
            this.mboundView3.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView5, title);
        }
        if ((j & 35) != 0) {
            this.mboundView0.setVisibility(i);
        }
    }
}
