package com.coolapk.market.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.DyhArticle;

public class ItemDyharticleActionBindingImpl extends ItemDyharticleActionBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362598, 8);
        sparseIntArray.put(2131362292, 9);
    }

    public ItemDyharticleActionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemDyharticleActionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[9], (TextView) objArr[7], (LinearLayout) objArr[6], (ImageView) objArr[8], (TextView) objArr[2], (LinearLayout) objArr[1], (ImageView) objArr[4], (TextView) objArr[5], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.commentNum.setTag(null);
        this.commentView.setTag(null);
        this.forwardNum.setTag(null);
        this.forwardView.setTag(null);
        this.likeIcon.setTag(null);
        this.likeNum.setTag(null);
        this.likeView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
            setModel((DyhArticle) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyharticleActionBinding
    public void setModel(DyhArticle dyhArticle) {
        this.mModel = dyhArticle;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyharticleActionBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemDyharticleActionBinding
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
        boolean z2;
        int i;
        int i2;
        int i3;
        Drawable drawable;
        int i4;
        boolean z3;
        int i5;
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhArticle dyhArticle = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i6 = 0;
        int i7 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (dyhArticle != null) {
                i3 = dyhArticle.getLikeNum();
                i4 = dyhArticle.getForwardNum();
                i = dyhArticle.getReplyNum();
                z3 = dyhArticle.isLiked();
            } else {
                z3 = false;
                i3 = 0;
                i4 = 0;
                i = 0;
            }
            if (i7 != 0) {
                j |= z3 ? 2048 : 1024;
            }
            z2 = i3 > 0;
            z = i4 > 0;
            if (i > 0) {
                i6 = 1;
            }
            if (z3) {
                context = this.likeIcon.getContext();
                i5 = 2131231257;
            } else {
                context = this.likeIcon.getContext();
                i5 = 2131231693;
            }
            drawable = AppCompatResources.getDrawable(context, i5);
            if ((j & 9) != 0) {
                j = z2 ? j | 128 : j | 64;
            }
            if ((j & 9) != 0) {
                j = z ? j | 32 : j | 16;
            }
            if ((j & 9) != 0) {
                j |= i6 != 0 ? 512 : 256;
            }
            i6 = i4;
            i2 = i6;
        } else {
            drawable = null;
            i3 = 0;
            i2 = 0;
            i = 0;
            z2 = false;
            z = false;
        }
        int i8 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        String valueOf = (j & 32) != 0 ? String.valueOf(i6) : null;
        String valueOf2 = (512 & j) != 0 ? String.valueOf(i) : null;
        String valueOf3 = (128 & j) != 0 ? String.valueOf(i3) : null;
        int i9 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i9 != 0) {
            if (!z) {
                valueOf = this.forwardNum.getResources().getString(2131886851);
            }
            if (!z2) {
                valueOf3 = this.likeNum.getResources().getString(2131886852);
            }
            if (i2 == 0) {
                valueOf2 = this.commentNum.getResources().getString(2131887359);
            }
        } else {
            valueOf3 = null;
            valueOf = null;
            valueOf2 = null;
        }
        if (i9 != 0) {
            TextViewBindingAdapter.setText(this.commentNum, valueOf2);
            TextViewBindingAdapter.setText(this.forwardNum, valueOf);
            ImageViewBindingAdapter.setImageDrawable(this.likeIcon, drawable);
            TextViewBindingAdapter.setText(this.likeNum, valueOf3);
        }
        if (i8 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.forwardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
        }
    }
}
