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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Collection;
import com.coolapk.market.widget.view.ShapedImageView;

public class ItemCollectionBindingImpl extends ItemCollectionBinding {
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
        sparseIntArray.put(2131362727, 7);
    }

    public ItemCollectionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemCollectionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (TextView) objArr[4], (ImageView) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[1], (ShapedImageView) objArr[2], (TextView) objArr[5], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.descriptionView.setTag(null);
        this.infoView.setTag(null);
        this.itemView.setTag(null);
        this.logoView.setTag(null);
        this.statusView.setTag(null);
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
            setModel((Collection) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCollectionBinding
    public void setModel(Collection collection) {
        this.mModel = collection;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCollectionBinding
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
        String str3;
        String str4;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Collection collection = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (collection != null) {
                str4 = collection.getSubDes();
                str3 = collection.getDescription();
                str2 = collection.getStatusText();
                str6 = collection.getCoverPic();
                str5 = collection.getTitle();
            } else {
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str6 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str3);
            if (i2 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            i = isEmpty ? 8 : 0;
            str = str6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.descriptionView, str3);
            this.descriptionView.setVisibility(i);
            TextViewBindingAdapter.setText(this.infoView, str4);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str, null, 2131231696, 0, bool, bool, bool, false, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.statusView, str2);
            TextViewBindingAdapter.setText(this.titleView, str5);
        }
        if (i3 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
    }
}
