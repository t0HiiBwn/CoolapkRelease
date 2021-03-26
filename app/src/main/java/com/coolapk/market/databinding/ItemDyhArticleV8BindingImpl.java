package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleVH;
import com.coolapk.market.widget.DyhActionView;

public class ItemDyhArticleV8BindingImpl extends ItemDyhArticleV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final View mboundView2;
    private final DyhActionView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362643, 8);
        sparseIntArray.put(2131362312, 9);
        sparseIntArray.put(2131362306, 10);
        sparseIntArray.put(2131363251, 11);
        sparseIntArray.put(2131362338, 12);
        sparseIntArray.put(2131362319, 13);
    }

    public ItemDyhArticleV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemDyhArticleV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FrameLayout) objArr[10], (LinearLayout) objArr[9], (FrameLayout) objArr[13], (CoolapkCardView) objArr[0], (FrameLayout) objArr[12], (LinearLayout) objArr[3], (FrameLayout) objArr[8], (TextView) objArr[6], (FrameLayout) objArr[11], (LinearLayout) objArr[1], (TextView) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.headerBottomLayout.setTag(null);
        View view2 = (View) objArr[2];
        this.mboundView2 = view2;
        view2.setTag(null);
        DyhActionView dyhActionView = (DyhActionView) objArr[7];
        this.mboundView7 = dyhActionView;
        dyhActionView.setTag(null);
        this.newsFromWhereView.setTag(null);
        this.rootView.setTag(null);
        this.sourceTimeView.setTag(null);
        this.sourceTitleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048;
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
            setModel((DyhArticle) obj);
        } else if (115 == i) {
            setFoldText((String) obj);
        } else if (183 == i) {
            setListType((String) obj);
        } else if (147 == i) {
            setHolder((DyhArticleVH) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (263 == i) {
            setSingleImg((String) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((DyhViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setModel(DyhArticle dyhArticle) {
        this.mModel = dyhArticle;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setFoldText(String str) {
        this.mFoldText = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setListType(String str) {
        this.mListType = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setHolder(DyhArticleVH dyhArticleVH) {
        this.mHolder = dyhArticleVH;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleV8Binding
    public void setViewModel(DyhViewModel dyhViewModel) {
        updateRegistration(1, dyhViewModel);
        this.mViewModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeHolder((DyhArticleVH) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((DyhViewModel) obj, i2);
    }

    private boolean onChangeHolder(DyhArticleVH dyhArticleVH, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModel(DyhViewModel dyhViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 36) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 64) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i != 253) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        Long l2;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhArticle dyhArticle = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        DyhViewModel dyhViewModel = this.mViewModel;
        int i5 = 0;
        if ((j & 3078) != 0) {
            if ((j & 2052) == 0 || dyhArticle == null) {
                str2 = null;
                l2 = null;
            } else {
                str2 = dyhArticle.getDyhShortName();
                l2 = dyhArticle.getCreatDate();
            }
            if (dyhArticle != null) {
                str3 = dyhArticle.getShowFromInfo();
            } else {
                str3 = null;
            }
            str = str3;
            z = str3 != null;
        } else {
            str2 = null;
            l2 = null;
            str = null;
            z = false;
        }
        if ((j & 3846) != 0) {
            if ((j & 2818) != 0) {
                if (dyhViewModel != null) {
                    z4 = dyhViewModel.isArticleNewsTemplate();
                    z3 = dyhViewModel.isDatelineVisible();
                } else {
                    z4 = false;
                    z3 = false;
                }
                if ((j & 2306) != 0) {
                    j |= z4 ? 131072 : 65536;
                }
                i3 = ((j & 2306) == 0 || z4) ? 0 : 8;
                boolean z5 = z4 & z3;
                if ((j & 2818) != 0) {
                    j |= z5 ? 8192 : 4096;
                }
                i4 = z5 ? 0 : 8;
            } else {
                i4 = 0;
                i3 = 0;
            }
            int i6 = ((j & 3078) > 0 ? 1 : ((j & 3078) == 0 ? 0 : -1));
            if (i6 != 0) {
                if (dyhViewModel != null) {
                    z2 = dyhViewModel.isShowNews();
                } else {
                    z2 = false;
                }
                boolean z6 = z2 & z;
                if (i6 != 0) {
                    j |= z6 ? 32768 : 16384;
                }
                if (!z6) {
                    i5 = 8;
                }
                i2 = i5;
                i = i4;
                i5 = i3;
            } else {
                i = i4;
                i5 = i3;
                i2 = 0;
            }
        } else {
            i2 = 0;
            i = 0;
        }
        if ((j & 2306) != 0) {
            this.headerBottomLayout.setVisibility(i5);
            this.mboundView2.setVisibility(i5);
            this.sourceTitleView.setVisibility(i5);
        }
        if ((j & 2052) != 0) {
            ViewBindingAdapters.updateDyhArticle(this.mboundView7, dyhArticle);
            String str4 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.newsFromWhereView, str, null, str4, null, null, str4);
            TextViewBindingAdapters.setTime(this.sourceTimeView, l2);
            TextViewBindingAdapter.setText(this.sourceTitleView, str2);
        }
        if ((3078 & j) != 0) {
            this.newsFromWhereView.setVisibility(i2);
        }
        if ((2176 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.newsFromWhereView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.rootView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.sourceTitleView, onClickListener, bool);
        }
        if ((j & 2818) != 0) {
            this.sourceTimeView.setVisibility(i);
        }
    }
}
