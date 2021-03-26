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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Entity;

public class ItemGridItemLongTitleBindingImpl extends ItemGridItemLongTitleBinding {
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
        sparseIntArray.put(2131363453, 4);
    }

    public ItemGridItemLongTitleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemGridItemLongTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[0], (LinearLayout) objArr[4], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.iconView.setTag(null);
        this.infoView.setTag(null);
        this.itemView.setTag(null);
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
        if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((Entity) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGridItemLongTitleBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGridItemLongTitleBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGridItemLongTitleBinding
    public void setViewModel(Entity entity) {
        this.mViewModel = entity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        View.OnClickListener onClickListener;
        int i2;
        String str6;
        String str7;
        int i3;
        String str8;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener2 = this.mClick;
        Entity entity = this.mViewModel;
        boolean z = false;
        if ((j & 13) != 0) {
            int i4 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (entity != null) {
                    str9 = entity.getSubTitle();
                    str8 = entity.getTitle();
                } else {
                    str9 = null;
                    str8 = null;
                }
                boolean z2 = str9 == null;
                if (i4 != 0) {
                    j |= z2 ? 128 : 64;
                }
                if (z2) {
                    i3 = 8;
                    if (entity == null) {
                        str = entity.getPic();
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        z = true;
                    }
                    if ((j & 13) != 0) {
                        j = z ? j | 32 : j | 16;
                    }
                    str2 = str9;
                    str3 = str8;
                    i = i3;
                }
            } else {
                str9 = null;
                str8 = null;
            }
            i3 = 0;
            if (entity == null) {
            }
            if (str == null) {
            }
            if ((j & 13) != 0) {
            }
            str2 = str9;
            str3 = str8;
            i = i3;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i5 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if ((32 & j) == 0 || entity == null) {
            str4 = null;
        } else {
            str4 = entity.getLogo();
        }
        int i6 = ((13 & j) > 0 ? 1 : ((13 & j) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (z) {
                str = str4;
            }
            str5 = str;
        } else {
            str5 = null;
        }
        if (i6 != 0) {
            Boolean bool = null;
            str7 = str2;
            str6 = str3;
            i2 = i;
            onClickListener = onClickListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str5, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, true, bool, bool, null, bool);
        } else {
            onClickListener = onClickListener2;
            str6 = str3;
            i2 = i;
            str7 = str2;
        }
        if ((j & 12) != 0) {
            TextViewBindingAdapter.setText(this.infoView, str7);
            this.infoView.setVisibility(i2);
            TextViewBindingAdapter.setText(this.titleView, str6);
        }
        if (i5 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
    }
}
