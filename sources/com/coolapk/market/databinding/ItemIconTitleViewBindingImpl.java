package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.dyhv8.viewholder.IconThreeMoreViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemIconTitleViewBindingImpl extends ItemIconTitleViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363274, 5);
        sparseIntArray.put(2131362982, 6);
    }

    public ItemIconTitleViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemIconTitleViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CoolapkCardView) objArr[0], (RoundedImageView) objArr[3], (RoundedImageView) objArr[4], (TextView) objArr[6], (LinearLayout) objArr[5], (RoundedImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.iconView0.setTag(null);
        this.iconView1.setTag(null);
        this.titlePicView.setTag(null);
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
        if (198 == i) {
            setModel((EntityCard) obj);
        } else if (147 != i) {
            return false;
        } else {
            setHolder((IconThreeMoreViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemIconTitleViewBinding
    public void setModel(EntityCard entityCard) {
        this.mModel = entityCard;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemIconTitleViewBinding
    public void setHolder(IconThreeMoreViewHolder iconThreeMoreViewHolder) {
        updateRegistration(0, iconThreeMoreViewHolder);
        this.mHolder = iconThreeMoreViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(147);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeHolder((IconThreeMoreViewHolder) obj, i2);
    }

    private boolean onChangeHolder(IconThreeMoreViewHolder iconThreeMoreViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 174) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i != 175) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EntityCard entityCard = this.mModel;
        IconThreeMoreViewHolder iconThreeMoreViewHolder = this.mHolder;
        String str2 = null;
        int i4 = 8;
        int i5 = 0;
        int i6 = ((j & 18) > 0 ? 1 : ((j & 18) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (entityCard != null) {
                String title = entityCard.getTitle();
                str2 = entityCard.getPic();
                str = title;
            } else {
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (i6 != 0) {
                j |= isEmpty ? 64 : 32;
            }
            i = isEmpty ? 8 : 0;
            str2 = str;
        } else {
            i = 0;
        }
        if ((29 & j) != 0) {
            int i7 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
            if (i7 != 0) {
                if (iconThreeMoreViewHolder != null) {
                    z2 = iconThreeMoreViewHolder.getIsShowSecondIcon();
                } else {
                    z2 = false;
                }
                if (i7 != 0) {
                    j |= z2 ? 1024 : 512;
                }
                if (!z2) {
                    i2 = 8;
                    i3 = ((j & 21) > 0 ? 1 : ((j & 21) == 0 ? 0 : -1));
                    if (i3 != 0) {
                        if (iconThreeMoreViewHolder != null) {
                            z = iconThreeMoreViewHolder.getIsShowFirstIcon();
                        } else {
                            z = false;
                        }
                        if (i3 != 0) {
                            j |= z ? 256 : 128;
                        }
                        if (z) {
                            i4 = 0;
                        }
                        i5 = i4;
                    }
                }
            }
            i2 = 0;
            i3 = ((j & 21) > 0 ? 1 : ((j & 21) == 0 ? 0 : -1));
            if (i3 != 0) {
            }
        } else {
            i2 = 0;
        }
        if ((j & 21) != 0) {
            this.iconView0.setVisibility(i5);
        }
        if ((j & 25) != 0) {
            this.iconView1.setVisibility(i2);
        }
        if ((j & 18) != 0) {
            this.titlePicView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
