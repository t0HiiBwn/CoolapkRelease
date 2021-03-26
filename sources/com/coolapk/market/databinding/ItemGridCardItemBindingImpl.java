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
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.GridCardViewHolder;

public class ItemGridCardItemBindingImpl extends ItemGridCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363453, 6);
    }

    public ItemGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemGridCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[4], (TextView) objArr[5], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[0], (LinearLayout) objArr[6], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionText.setTag(null);
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
        if (309 == i) {
            setViewModel((GridCardViewHolder.DataViewHolder) obj);
        } else if (245 != i) {
            return false;
        } else {
            setShowAction(((Boolean) obj).booleanValue());
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGridCardItemBinding
    public void setViewModel(GridCardViewHolder.DataViewHolder dataViewHolder) {
        updateRegistration(0, dataViewHolder);
        this.mViewModel = dataViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGridCardItemBinding
    public void setShowAction(boolean z) {
        this.mShowAction = z;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(245);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((GridCardViewHolder.DataViewHolder) obj, i2);
    }

    private boolean onChangeViewModel(GridCardViewHolder.DataViewHolder dataViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        OnBitmapTransformListener onBitmapTransformListener;
        String str;
        int i;
        String str2;
        int i2;
        ServiceApp serviceApp;
        String str3;
        int i3;
        OnBitmapTransformListener onBitmapTransformListener2;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        GridCardViewHolder.DataViewHolder dataViewHolder = this.mViewModel;
        boolean z = this.mShowAction;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (dataViewHolder != null) {
                str4 = dataViewHolder.logo;
                serviceApp = dataViewHolder.serviceApp;
                onBitmapTransformListener2 = dataViewHolder.circleTransform;
                i2 = dataViewHolder.titleLine;
                str2 = dataViewHolder.title;
                str3 = dataViewHolder.info;
            } else {
                str3 = null;
                str4 = null;
                serviceApp = null;
                onBitmapTransformListener2 = null;
                i2 = 0;
                str2 = null;
            }
            boolean z2 = str3 == null;
            if (i4 != 0) {
                j |= z2 ? 64 : 32;
            }
            i = z2 ? 8 : 0;
            str = str4;
            onBitmapTransformListener = onBitmapTransformListener2;
        } else {
            str3 = null;
            serviceApp = null;
            i2 = 0;
            str2 = null;
            i = 0;
            str = null;
            onBitmapTransformListener = null;
        }
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (i5 != 0) {
                j |= z ? 16 : 8;
            }
            if (!z) {
                i3 = 8;
                if ((j & 4) != 0) {
                    ThemeBindingAdapters.setTextColor(this.actionButton, "colorAccent");
                    ThemeBindingAdapters.setTextColor(this.actionText, "colorAccent");
                }
                if ((j & 5) != 0) {
                    ActionButtonBindingAdapters.setActionText(this.actionButton, serviceApp, true);
                    Boolean bool = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, true, bool, bool, null, bool);
                    TextViewBindingAdapter.setText(this.infoView, str3);
                    this.infoView.setVisibility(i);
                    this.titleView.setLines(i2);
                    TextViewBindingAdapter.setText(this.titleView, str2);
                }
                if ((j & 6) == 0) {
                    this.actionText.setVisibility(i3);
                    return;
                }
                return;
            }
        }
        i3 = 0;
        if ((j & 4) != 0) {
        }
        if ((j & 5) != 0) {
        }
        if ((j & 6) == 0) {
        }
    }
}
