package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.widget.AutoLinkTextView;

public class ItemDyhArticleContentBindingImpl extends ItemDyhArticleContentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362312, 3);
    }

    public ItemDyhArticleContentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemDyhArticleContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[3], (TextView) objArr[1], (LinearLayout) objArr[0], (AutoLinkTextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.realTitleView.setTag(null);
        this.rootView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
            setModel((DyhViewModel) obj);
        } else if (183 == i) {
            setListType((String) obj);
        } else if (115 == i) {
            setFoldText((String) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (263 != i) {
            return false;
        } else {
            setSingleImg((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleContentBinding
    public void setModel(DyhViewModel dyhViewModel) {
        updateRegistration(0, dyhViewModel);
        this.mModel = dyhViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleContentBinding
    public void setListType(String str) {
        this.mListType = str;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleContentBinding
    public void setFoldText(String str) {
        this.mFoldText = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(115);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleContentBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemDyhArticleContentBinding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((DyhViewModel) obj, i2);
    }

    private boolean onChangeModel(DyhViewModel dyhViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 78) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i != 194) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        DyhArticle dyhArticle;
        Integer num;
        String str;
        DyhArticle dyhArticle2;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DyhViewModel dyhViewModel = this.mModel;
        String str3 = this.mFoldText;
        int i = 0;
        String str4 = null;
        if ((j & 229) != 0) {
            if (dyhViewModel != null) {
                num = dyhViewModel.getMaxArticleWords();
                dyhArticle2 = dyhViewModel.getDyhArticle();
            } else {
                dyhArticle2 = null;
                num = null;
            }
            int i2 = ((j & 161) > 0 ? 1 : ((j & 161) == 0 ? 0 : -1));
            if (i2 != 0) {
                str2 = dyhArticle2 != null ? dyhArticle2.getTitle() : null;
                boolean isEmpty = TextUtils.isEmpty(str2);
                if (i2 != 0) {
                    j |= isEmpty ? 512 : 256;
                }
                if (isEmpty) {
                    i = 8;
                }
            } else {
                str2 = null;
            }
            if (dyhArticle2 != null) {
                str4 = dyhArticle2.getFinalMessage();
            }
            dyhArticle = dyhArticle2;
            str = str4;
            str4 = str2;
        } else {
            str = null;
            num = null;
            dyhArticle = null;
        }
        if ((161 & j) != 0) {
            TextViewBindingAdapter.setText(this.realTitleView, str4);
            this.realTitleView.setVisibility(i);
        }
        if ((j & 229) != 0) {
            TextViewBindingAdapters.setAutoTextViewLinkable(this.titleView, str, num, str3, dyhArticle);
        }
    }
}
