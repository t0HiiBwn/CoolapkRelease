package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemTextImageCardBindingImpl extends ItemTextImageCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AspectRatioImageView mboundView1;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362768, 4);
        sparseIntArray.put(2131362858, 5);
    }

    public ItemTextImageCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemTextImageCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (LinearLayout) objArr[4], (LinearLayout) objArr[5], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        AspectRatioImageView aspectRatioImageView = (AspectRatioImageView) objArr[1];
        this.mboundView1 = aspectRatioImageView;
        aspectRatioImageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.textView7.setTag(null);
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
        setCard((EntityCard) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTextImageCardBinding
    public void setCard(EntityCard entityCard) {
        this.mCard = entityCard;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EntityCard entityCard = this.mCard;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (entityCard != null) {
                str3 = entityCard.getSubTitle();
                str2 = entityCard.getDescription();
                str = entityCard.getPic();
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str3);
            int i4 = str == null ? 1 : 0;
            if (i3 != 0) {
                j |= isEmpty ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j = i4 != 0 ? j | 32 : j | 16;
            }
            if (isEmpty) {
                i2 = 8;
            }
            i = i2;
            i2 = i4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((32 & j) == 0 || entityCard == null) {
            str4 = null;
        } else {
            str4 = entityCard.getLogo();
        }
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (i2 != 0) {
                str = str4;
            }
            str5 = str;
        } else {
            str5 = null;
        }
        if (i5 != 0) {
            DataBindingComponent dataBindingComponent = this.mBindingComponent;
            AspectRatioImageView aspectRatioImageView = this.mboundView1;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(dataBindingComponent, aspectRatioImageView, str5, AppCompatResources.getDrawable(aspectRatioImageView.getContext(), 2131231363), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, true, bool, null, bool);
            TextViewBindingAdapter.setText(this.mboundView3, str3);
            this.mboundView3.setVisibility(i);
            TextViewBindingAdapter.setText(this.textView7, str2);
        }
    }
}
