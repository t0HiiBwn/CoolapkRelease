package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemWebViewBindingImpl extends ItemWebViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362768, 2);
        sparseIntArray.put(2131362658, 3);
        sparseIntArray.put(2131363961, 4);
        sparseIntArray.put(2131362598, 5);
        sparseIntArray.put(2131362338, 6);
    }

    public ItemWebViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemWebViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (AspectRatioImageView) objArr[6], (ImageView) objArr[5], (FrameLayout) objArr[3], (LinearLayout) objArr[2], (FrameLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
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
        if (44 != i) {
            return false;
        }
        setCard((Entity) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemWebViewBinding
    public void setCard(Entity entity) {
        this.mCard = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mCard;
        String str = null;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (entity != null) {
                str = entity.getTitle();
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            if (i2 != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if (isEmpty) {
                i = 8;
            }
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str);
            this.mboundView1.setVisibility(i);
        }
    }
}
