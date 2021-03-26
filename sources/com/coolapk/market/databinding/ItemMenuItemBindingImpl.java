package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;

public class ItemMenuItemBindingImpl extends ItemMenuItemBinding {
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
        sparseIntArray.put(2131362472, 5);
    }

    public ItemMenuItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemMenuItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (ImageView) objArr[5], (ImageView) objArr[2], (TextView) objArr[4], (LinearLayout) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.logoView.setTag(null);
        this.moreTextView.setTag(null);
        this.rootView.setTag(null);
        this.titleView.setTag(null);
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
        if (198 == i) {
            setModel((Entity) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemMenuItemBinding
    public void setModel(Entity entity) {
        this.mModel = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemMenuItemBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemMenuItemBinding
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
        boolean z;
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
        Entity entity = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = 0;
        int i3 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (entity != null) {
                str3 = entity.getSubTitle();
                str2 = entity.getTitle();
                str = entity.getPic();
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str3);
            z = str == null;
            if (i3 != 0) {
                j |= isEmpty ? 512 : 256;
            }
            if ((j & 9) != 0) {
                j = z ? j | 32 : j | 16;
            }
            i = isEmpty ? 8 : 0;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
            z = false;
        }
        if ((32 & j) == 0 || entity == null) {
            str4 = null;
        } else {
            str4 = entity.getLogo();
        }
        int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (z) {
                str = str4;
            }
            boolean isEmpty2 = TextUtils.isEmpty(str);
            if (i4 != 0) {
                j |= isEmpty2 ? 128 : 64;
            }
            i2 = isEmpty2 ? 8 : 0;
            str5 = str;
        } else {
            str5 = null;
        }
        if ((9 & j) != 0) {
            this.logoView.setVisibility(i2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str5, AppCompatResources.getDrawable(this.logoView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.moreTextView, str3);
            this.moreTextView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if ((j & 12) != 0) {
            ViewBindingAdapters.clickListener(this.rootView, onClickListener, null);
        }
    }
}
