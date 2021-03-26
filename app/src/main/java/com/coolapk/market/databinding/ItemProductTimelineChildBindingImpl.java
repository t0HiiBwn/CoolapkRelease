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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Entity;

public class ItemProductTimelineChildBindingImpl extends ItemProductTimelineChildBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final View mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362367, 4);
        sparseIntArray.put(2131363984, 5);
        sparseIntArray.put(2131362417, 6);
        sparseIntArray.put(2131362734, 7);
    }

    public ItemProductTimelineChildBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemProductTimelineChildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (View) objArr[6], (ImageView) objArr[2], (TextView) objArr[7], (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.iconView.setTag(null);
        this.itemView.setTag(null);
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
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
            setModel((Entity) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductTimelineChildBinding
    public void setModel(Entity entity) {
        this.mModel = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductTimelineChildBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        boolean z = false;
        int i = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i != 0) {
            if (entity != null) {
                str2 = entity.getTitle();
                str = entity.getPic();
            } else {
                str2 = null;
                str = null;
            }
            if (str == null) {
                z = true;
            }
            if (i != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            str2 = null;
            str = null;
        }
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((16 & j) == 0 || entity == null) {
            str3 = null;
        } else {
            str3 = entity.getLogo();
        }
        int i3 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (z) {
                str = str3;
            }
            str4 = str;
        } else {
            str4 = null;
        }
        if (i3 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str4, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.iconView, null, 8);
            ViewBindingAdapters.clipView(this.mboundView1, "oval", null);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
    }
}
