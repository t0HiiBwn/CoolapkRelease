package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.ActionButton;

public class ItemPodiumCardItemBindingImpl extends ItemPodiumCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362100, 8);
        sparseIntArray.put(2131363034, 9);
        sparseIntArray.put(2131363283, 10);
    }

    public ItemPodiumCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemPodiumCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (ActionButton) objArr[6], (ImageView) objArr[8], (FrameLayout) objArr[1], (ImageView) objArr[7], (RelativeLayout) objArr[0], (ImageView) objArr[9], (TextView) objArr[4], (ImageView) objArr[10], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton2.setTag(null);
        this.actionContainer.setTag(null);
        this.contentLayout.setTag(null);
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        this.scoreView.setTag(null);
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
        if (189 == i) {
            setLogo((String) obj);
        } else if (27 == i) {
            setApp((ServiceApp) obj);
        } else if (233 == i) {
            setScore((String) obj);
        } else if (278 != i) {
            return false;
        } else {
            setTitle((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardItemBinding
    public void setLogo(String str) {
        this.mLogo = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(189);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardItemBinding
    public void setApp(ServiceApp serviceApp) {
        this.mApp = serviceApp;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardItemBinding
    public void setScore(String str) {
        this.mScore = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(233);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPodiumCardItemBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(278);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        int i5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str3 = this.mLogo;
        ServiceApp serviceApp = this.mApp;
        String str4 = this.mScore;
        String str5 = this.mTitle;
        int i6 = ((j & 18) > 0 ? 1 : ((j & 18) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean z = serviceApp == null;
            if (i6 != 0) {
                j |= z ? 64 : 32;
            }
            if (!z) {
                i = 8;
                i2 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
                if (i2 == 0) {
                    boolean isEmpty = TextUtils.isEmpty(str4);
                    if (i2 != 0) {
                        j |= isEmpty ? 256 : 128;
                    }
                    i3 = isEmpty ? 8 : 0;
                } else {
                    i3 = 0;
                }
                i4 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
                if ((18 & j) != 0) {
                    this.actionButton2.setVisibility(i);
                    ActionButtonBindingAdapters.setActionText(this.actionButton2, serviceApp);
                    ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, serviceApp, false);
                }
                if ((16 & j) != 0) {
                    ViewBindingAdapters.clipView(this.contentLayout, null, 8);
                }
                if ((17 & j) == 0) {
                    Boolean bool = null;
                    i5 = i3;
                    str2 = str5;
                    str = str4;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str3, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, true, bool, null, null, null, true, bool, bool, null, bool);
                } else {
                    str2 = str5;
                    i5 = i3;
                    str = str4;
                }
                if ((j & 20) != 0) {
                    this.mboundView3.setVisibility(i5);
                    TextViewBindingAdapter.setText(this.scoreView, str);
                }
                if (i4 == 0) {
                    TextViewBindingAdapter.setText(this.titleView, str2);
                    return;
                }
                return;
            }
        }
        i = 0;
        i2 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i2 == 0) {
        }
        i4 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if ((18 & j) != 0) {
        }
        if ((16 & j) != 0) {
        }
        if ((17 & j) == 0) {
        }
        if ((j & 20) != 0) {
        }
        if (i4 == 0) {
        }
    }
}
