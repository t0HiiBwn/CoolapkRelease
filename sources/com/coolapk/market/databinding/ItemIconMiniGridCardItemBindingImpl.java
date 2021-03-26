package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Entity;

public class ItemIconMiniGridCardItemBindingImpl extends ItemIconMiniGridCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView2;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362780, 6);
    }

    public ItemIconMiniGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemIconMiniGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[4], (LinearLayout) objArr[6], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.imageView1.setTag(null);
        this.imageView2.setTag(null);
        this.itemView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
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
        if (95 == i) {
            setEntity2((Entity) obj);
        } else if (94 != i) {
            return false;
        } else {
            setEntity1((Entity) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemIconMiniGridCardItemBinding
    public void setEntity2(Entity entity) {
        this.mEntity2 = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(95);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemIconMiniGridCardItemBinding
    public void setEntity1(Entity entity) {
        this.mEntity1 = entity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(94);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mEntity2;
        Entity entity2 = this.mEntity1;
        boolean z2 = false;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (entity != null) {
                str2 = entity.getPic();
                str = entity.getTitle();
            } else {
                str2 = null;
                str = null;
            }
            boolean z3 = entity == null;
            if (i2 != 0) {
                j |= z3 ? 16 : 8;
            }
            z = str2 == null;
            int i3 = z3 ? 4 : 0;
            if ((j & 5) != 0) {
                j = z ? j | 64 : j | 32;
            }
            i = i3;
        } else {
            str2 = null;
            str = null;
            i = 0;
            z = false;
        }
        int i4 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (entity2 != null) {
                str4 = entity2.getPic();
                str8 = entity2.getTitle();
            } else {
                str4 = null;
                str8 = null;
            }
            boolean z4 = str4 == null;
            if (i4 != 0) {
                j = z4 ? j | 256 : j | 128;
            }
            z2 = z4;
            str3 = str8;
        } else {
            str4 = null;
            str3 = null;
        }
        String logo = ((64 & j) == 0 || entity == null) ? null : entity.getLogo();
        if ((j & 256) == 0 || entity2 == null) {
            str5 = null;
        } else {
            str5 = entity2.getLogo();
        }
        int i5 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (z) {
                str2 = logo;
            }
            str6 = str2;
        } else {
            str6 = null;
        }
        int i6 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (z2) {
                str4 = str5;
            }
            str7 = str4;
        } else {
            str7 = null;
        }
        if (i6 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView1, str7, AppCompatResources.getDrawable(this.imageView1.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.mboundView2, str3);
        }
        if (i5 != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView2, str6, AppCompatResources.getDrawable(this.imageView2.getContext(), 2131231374), 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            this.itemView2.setVisibility(i);
            TextViewBindingAdapter.setText(this.mboundView5, str);
        }
    }
}
