package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public class ItemGridDyhCardItemBindingImpl extends ItemGridDyhCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363453, 5);
    }

    public ItemGridDyhCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemGridDyhCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[0], (LinearLayout) objArr[5], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionText.setTag(null);
        this.iconView.setTag(null);
        this.infoView.setTag(null);
        this.itemView.setTag(null);
        this.titleView.setTag(null);
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
        if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((DyhViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGridDyhCardItemBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGridDyhCardItemBinding
    public void setViewModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mViewModel = dyhViewModel;
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
        return onChangeViewModel((DyhViewModel) obj, i2);
    }

    private boolean onChangeViewModel(DyhViewModel dyhViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 84) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 86) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 81) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i != 168) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Drawable drawable;
        String str6;
        boolean z;
        String str7;
        ?? r8;
        String str8;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        DyhViewModel dyhViewModel = this.mViewModel;
        boolean z2 = false;
        if ((127 & j) != 0) {
            int i2 = ((j & 81) > 0 ? 1 : ((j & 81) == 0 ? 0 : -1));
            if (i2 != 0) {
                if (dyhViewModel != null) {
                    str8 = dyhViewModel.getDyhFollowNum();
                } else {
                    str8 = null;
                }
                boolean z3 = str8 == null;
                if (i2 != 0) {
                    j |= z3 ? 256 : 128;
                }
                if (z3) {
                    r8 = 8;
                    String dyhLogo = ((j & 71) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhLogo();
                    str2 = ((j & 73) != 0 || dyhViewModel == null) ? null : dyhViewModel.getDyhTitle();
                    i = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
                    if (i == 0) {
                        if (dyhViewModel != null) {
                            z2 = dyhViewModel.getIsFollowDyh();
                        }
                        if (i != 0) {
                            if (z2) {
                                j3 = j | 1024 | 4096;
                                j2 = 16384;
                            } else {
                                j3 = j | 512 | 2048;
                                j2 = 8192;
                            }
                            j = j3 | j2;
                        }
                        drawable = AppCompatResources.getDrawable(this.actionText.getContext(), z2 ? 2131230821 : 2131230813);
                        str4 = z2 ? "textColorSecondary" : "white";
                        str3 = this.actionText.getResources().getString(z2 ? 2131886823 : 2131886822);
                        z2 = r8;
                        str = dyhLogo;
                    } else {
                        z2 = r8 == true ? 1 : 0;
                        str = dyhLogo;
                        drawable = null;
                        str4 = null;
                        str3 = null;
                    }
                    str5 = str8;
                }
            } else {
                str8 = null;
            }
            r8 = 0;
            if ((j & 71) != 0) {
            }
            if ((j & 73) != 0) {
            }
            i = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
            if (i == 0) {
            }
            str5 = str8;
        } else {
            drawable = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((97 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionText, str4);
            ViewBindingAdapter.setBackground(this.actionText, drawable);
            TextViewBindingAdapter.setText(this.actionText, str3);
        }
        if ((71 & j) != 0) {
            Boolean bool = null;
            str7 = str2;
            z = z2;
            str6 = str5;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, true, bool, bool, null, bool);
        } else {
            str6 = str5;
            z = z2;
            str7 = str2;
        }
        if ((j & 81) != 0) {
            TextViewBindingAdapter.setText(this.infoView, str6);
            TextView textView = this.infoView;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            textView.setVisibility(i3);
        }
        if ((j & 73) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str7);
        }
    }
}
