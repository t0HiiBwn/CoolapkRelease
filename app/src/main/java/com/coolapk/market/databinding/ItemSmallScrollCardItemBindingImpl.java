package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.viewholder.SmallScrollCardItemViewHolder;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.UserAvatarView;

public class ItemSmallScrollCardItemBindingImpl extends ItemSmallScrollCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363283, 7);
    }

    public ItemSmallScrollCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemSmallScrollCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ActionButton) objArr[6], (UserAvatarView) objArr[1], (TextView) objArr[5], (LinearLayout) objArr[0], (TextView) objArr[4], (ImageView) objArr[7], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionContainer.setTag(null);
        this.iconView.setTag(null);
        this.infoView.setTag(null);
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
            this.mDirtyFlags = 2;
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
        if (197 != i) {
            return false;
        }
        setModel((SmallScrollCardItemViewHolder) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSmallScrollCardItemBinding
    public void setModel(SmallScrollCardItemViewHolder smallScrollCardItemViewHolder) {
        updateRegistration(0, smallScrollCardItemViewHolder);
        this.mModel = smallScrollCardItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((SmallScrollCardItemViewHolder) obj, i2);
    }

    private boolean onChangeModel(SmallScrollCardItemViewHolder smallScrollCardItemViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        boolean z;
        String str2;
        int i2;
        String str3;
        int i3;
        String str4;
        int i4;
        boolean z2;
        int i5;
        int i6;
        String str5;
        int i7;
        boolean z3;
        String str6;
        String str7;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SmallScrollCardItemViewHolder smallScrollCardItemViewHolder = this.mModel;
        int i8 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (smallScrollCardItemViewHolder != null) {
                str4 = smallScrollCardItemViewHolder.getScore();
                str7 = smallScrollCardItemViewHolder.getLogo();
                str6 = smallScrollCardItemViewHolder.getSubTitle();
                z3 = smallScrollCardItemViewHolder.getHiddenScore();
                i7 = smallScrollCardItemViewHolder.getImagePlaceHolderId();
                str5 = smallScrollCardItemViewHolder.getTitle();
                i6 = smallScrollCardItemViewHolder.getTitleLine();
                z4 = smallScrollCardItemViewHolder.getShowDownloadButton();
            } else {
                str4 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                z4 = false;
                z3 = false;
                i7 = 0;
                i6 = 0;
            }
            if (i8 != 0) {
                j = z3 ? j | 512 : j | 256;
            }
            if ((j & 3) != 0) {
                j |= z4 ? 8 : 4;
            }
            boolean isEmpty = TextUtils.isEmpty(str6);
            i4 = z4 ? 0 : 8;
            if ((j & 3) != 0) {
                j |= isEmpty ? 128 : 64;
            }
            str3 = str5;
            i2 = i6;
            i = i7;
            str = str7;
            i3 = isEmpty ? 8 : 0;
            str2 = str6;
            z = z3;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z = false;
            i = 0;
        }
        if ((256 & j) != 0) {
            z2 = TextUtils.isEmpty(str4);
        } else {
            z2 = false;
        }
        int i9 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i9 != 0) {
            if (z) {
                z2 = true;
            }
            if (i9 != 0) {
                j |= z2 ? 32 : 16;
            }
            i5 = z2 ? 8 : 0;
        } else {
            i5 = 0;
        }
        if ((3 & j) != 0) {
            this.actionContainer.setVisibility(i4);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, i, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.infoView, str2);
            this.infoView.setVisibility(i3);
            this.mboundView3.setVisibility(i5);
            TextViewBindingAdapter.setText(this.scoreView, str4);
            this.titleView.setLines(i2);
            this.titleView.setMaxLines(i2);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.scoreView, "colorAccent");
        }
    }
}
