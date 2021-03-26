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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.viewholder.LargeScrollCardItemViewHolder;
import com.coolapk.market.widget.UserAvatarView;

public class ItemLargeScrollCardItemBindingImpl extends ItemLargeScrollCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public ItemLargeScrollCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemLargeScrollCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[4], (LinearLayout) objArr[0], (UserAvatarView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.itemView.setTag(null);
        this.logoView.setTag(null);
        this.subTitleView.setTag(null);
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
            setModel((LargeScrollCardItemViewHolder) obj);
        } else if (288 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemLargeScrollCardItemBinding
    public void setModel(LargeScrollCardItemViewHolder largeScrollCardItemViewHolder) {
        updateRegistration(0, largeScrollCardItemViewHolder);
        this.mModel = largeScrollCardItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemLargeScrollCardItemBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((LargeScrollCardItemViewHolder) obj, i2);
    }

    private boolean onChangeModel(LargeScrollCardItemViewHolder largeScrollCardItemViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        int i;
        String str5;
        String str6;
        int i2;
        String str7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LargeScrollCardItemViewHolder largeScrollCardItemViewHolder = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        boolean z2 = false;
        if ((j & 7) != 0) {
            String logo = largeScrollCardItemViewHolder != null ? largeScrollCardItemViewHolder.getLogo() : null;
            int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (largeScrollCardItemViewHolder != null) {
                    String actionText = largeScrollCardItemViewHolder.getActionText();
                    str3 = largeScrollCardItemViewHolder.getSubTitle();
                    str2 = largeScrollCardItemViewHolder.getTitle();
                    str7 = largeScrollCardItemViewHolder.getVerifyStatusIcon();
                    i2 = largeScrollCardItemViewHolder.getTitleLine();
                    z2 = largeScrollCardItemViewHolder.isFollow();
                    str6 = actionText;
                } else {
                    str6 = null;
                    str3 = null;
                    str2 = null;
                    str7 = null;
                    i2 = 0;
                }
                if (i3 != 0) {
                    j |= z2 ? 16 : 8;
                }
                boolean isEmpty = TextUtils.isEmpty(str7);
                str4 = z2 ? "textColorSecondary" : "white";
                if ((j & 5) != 0) {
                    j |= isEmpty ? 64 : 32;
                }
                z = !isEmpty;
                str = logo;
                str5 = str7;
                i = i2;
                if ((5 & j) != 0) {
                    TextViewBindingAdapter.setText(this.actionView, str6);
                    ThemeBindingAdapters.setTextColor(this.actionView, str4);
                    ImageViewBindingAdapters.setVipSignView(this.logoView, str5, Boolean.valueOf(z));
                    TextViewBindingAdapter.setText(this.subTitleView, str3);
                    this.titleView.setLines(i);
                    TextViewBindingAdapter.setText(this.titleView, str2);
                }
                if ((4 & j) != 0) {
                    ViewBindingAdapters.clipView(this.itemView, null, 4);
                }
                if ((j & 7) == 0) {
                    Boolean bool = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str, AppCompatResources.getDrawable(this.logoView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
                    return;
                }
                return;
            }
            str = logo;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        i = 0;
        z = false;
        if ((5 & j) != 0) {
        }
        if ((4 & j) != 0) {
        }
        if ((j & 7) == 0) {
        }
    }
}
