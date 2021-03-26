package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Gift;

public class ItemAppNodeGiftBindingImpl extends ItemAppNodeGiftBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemAppNodeGiftBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemAppNodeGiftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.fetchGiftView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
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
        if (131 == i) {
            setGift((Gift) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppNodeGiftBinding
    public void setGift(Gift gift) {
        this.mGift = gift;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(131);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAppNodeGiftBinding
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
        int i;
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Gift gift = this.mGift;
        boolean z = false;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (gift != null) {
                z = gift.isGet();
                str2 = gift.getTitle();
            } else {
                str2 = null;
            }
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                resources = this.mboundView3.getResources();
                i = 2131886655;
            } else {
                resources = this.mboundView3.getResources();
                i = 2131886883;
            }
            str = resources.getString(i);
        } else {
            str2 = null;
            str = null;
        }
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.fetchGiftView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
        }
        if ((4 & j) != 0) {
            ViewBindingAdapters.clipView(this.itemView, null, 8);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str2);
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
    }
}
