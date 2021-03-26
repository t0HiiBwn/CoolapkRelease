package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FunThings;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemGoodsListSimpleBindingImpl extends ItemGoodsListSimpleBinding {
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
        sparseIntArray.put(2131363435, 5);
        sparseIntArray.put(2131363219, 6);
    }

    public ItemGoodsListSimpleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemGoodsListSimpleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (RoundedImageView) objArr[2], (LinearLayout) objArr[1], (TextView) objArr[6], (LinearLayout) objArr[5], (EllipsizeTextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        this.itemAlbumView.setTag(null);
        this.titleView.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
            setModel((FunThings) obj);
        } else if (295 == i) {
            setUserInfo((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListSimpleBinding
    public void setModel(FunThings funThings) {
        this.mModel = funThings;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListSimpleBinding
    public void setUserInfo(String str) {
        this.mUserInfo = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(295);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListSimpleBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FunThings funThings = this.mModel;
        String str3 = this.mUserInfo;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (i == 0 || funThings == null) {
            str2 = null;
            str = null;
        } else {
            String coverPic = funThings.getCoverPic();
            str2 = funThings.getTitle();
            str = coverPic;
        }
        int i2 = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        int i3 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231363), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if (i3 != 0) {
            ViewBindingAdapters.clickListener(this.itemAlbumView, onClickListener, null);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.userNameView, str3);
        }
    }
}
