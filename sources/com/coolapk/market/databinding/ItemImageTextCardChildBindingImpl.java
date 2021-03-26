package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemImageTextCardChildBindingImpl extends ItemImageTextCardChildBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemImageTextCardChildBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemImageTextCardChildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[0], (AspectRatioImageView) objArr[1], (FrameLayout) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.imageView.setTag(null);
        this.titleContainer.setTag(null);
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
        if (198 == i) {
            setModel((Entity) obj);
        } else if (60 != i) {
            return false;
        } else {
            setCover((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemImageTextCardChildBinding
    public void setModel(Entity entity) {
        this.mModel = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemImageTextCardChildBinding
    public void setCover(String str) {
        this.mCover = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(60);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mModel;
        String str4 = this.mCover;
        boolean z = false;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            str = entity != null ? entity.getTitle() : null;
            boolean isEmpty = TextUtils.isEmpty(str);
            if (i4 != 0) {
                j |= isEmpty ? 64 : 32;
            }
            if (isEmpty) {
                i = 8;
                i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
                if (i2 != 0) {
                    if (str4 == null) {
                        z = true;
                    }
                    if (i2 != 0) {
                        j = z ? j | 16 : j | 8;
                    }
                }
                if ((j & 16) != 0 || entity == null) {
                    str2 = null;
                } else {
                    str2 = entity.getLogo();
                }
                i3 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
                if (i3 == 0) {
                    if (z) {
                        str4 = str2;
                    }
                    str3 = str4;
                } else {
                    str3 = null;
                }
                if (i3 != 0) {
                    Boolean bool = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str3, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231707), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, true, bool, null, bool);
                }
                if ((j & 5) == 0) {
                    this.titleContainer.setVisibility(i);
                    TextViewBindingAdapter.setText(this.titleView, str);
                    return;
                }
                return;
            }
        } else {
            str = null;
        }
        i = 0;
        i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        if ((j & 16) != 0) {
        }
        str2 = null;
        i3 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i3 == 0) {
        }
        if (i3 != 0) {
        }
        if ((j & 5) == 0) {
        }
    }
}
