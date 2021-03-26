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
import com.coolapk.market.viewholder.IconGridCardItemViewHolder;

public class ItemIconGridCardItemBindingImpl extends ItemIconGridCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemIconGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemIconGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
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
            this.mDirtyFlags = 4;
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
        if (197 == i) {
            setModel((IconGridCardItemViewHolder) obj);
        } else if (224 != i) {
            return false;
        } else {
            setPlaceHolder((Integer) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemIconGridCardItemBinding
    public void setModel(IconGridCardItemViewHolder iconGridCardItemViewHolder) {
        updateRegistration(0, iconGridCardItemViewHolder);
        this.mModel = iconGridCardItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemIconGridCardItemBinding
    public void setPlaceHolder(Integer num) {
        this.mPlaceHolder = num;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(224);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((IconGridCardItemViewHolder) obj, i2);
    }

    private boolean onChangeModel(IconGridCardItemViewHolder iconGridCardItemViewHolder, int i) {
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
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        String str6;
        String str7;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        IconGridCardItemViewHolder iconGridCardItemViewHolder = this.mModel;
        Integer num = this.mPlaceHolder;
        int i4 = 0;
        if ((j & 7) != 0) {
            String logo = iconGridCardItemViewHolder != null ? iconGridCardItemViewHolder.getLogo() : null;
            int safeUnbox = ViewDataBinding.safeUnbox(num);
            int i5 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (iconGridCardItemViewHolder != null) {
                    str2 = iconGridCardItemViewHolder.getActionText();
                    str7 = iconGridCardItemViewHolder.getSubTitle();
                    str6 = iconGridCardItemViewHolder.getTitle();
                    i3 = iconGridCardItemViewHolder.getTitleLine();
                    z = iconGridCardItemViewHolder.isFollow();
                } else {
                    str2 = null;
                    str7 = null;
                    str6 = null;
                    z = false;
                    i3 = 0;
                }
                if (i5 != 0) {
                    j |= z ? 16 : 8;
                }
                boolean isEmpty = TextUtils.isEmpty(str7);
                str5 = z ? "textColorSecondary" : "white";
                if ((j & 5) != 0) {
                    j |= isEmpty ? 64 : 32;
                }
                if (isEmpty) {
                    i4 = 8;
                }
                i = safeUnbox;
                str3 = str6;
                i2 = i3;
                str = logo;
                str4 = str7;
            } else {
                i = safeUnbox;
                str = logo;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                i2 = 0;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(this.actionView, str2);
            ThemeBindingAdapters.setTextColor(this.actionView, str5);
            TextViewBindingAdapter.setText(this.infoView, str4);
            this.infoView.setVisibility(i4);
            this.titleView.setMaxLines(i2);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
        if ((j & 7) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, i, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
        }
    }
}
