package com.coolapk.market.databinding;

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
import com.coolapk.market.model.Gift;

public class ItemUserGiftBindingImpl extends ItemUserGiftBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362612, 5);
    }

    public ItemUserGiftBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemUserGiftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[4], (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.giftContent.setTag(null);
        this.giftGetText.setTag(null);
        this.giftLogoView.setTag(null);
        this.itemView.setTag(null);
        this.titleGameView.setTag(null);
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
        if (131 != i) {
            return false;
        }
        setGift((Gift) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUserGiftBinding
    public void setGift(Gift gift) {
        this.mGift = gift;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(131);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Gift gift = this.mGift;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i == 0 || gift == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            String apkLogo = gift.getApkLogo();
            str2 = gift.getTitle();
            str3 = gift.getGiftData();
            str = apkLogo;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.giftContent, str3);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.giftLogoView, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.titleGameView, str2);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.giftGetText, "colorAccent");
        }
    }
}
