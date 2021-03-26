package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;

public class ItemQuestionDetailBottomBindingImpl extends ItemQuestionDetailBottomBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView2;
    private final TextView mboundView3;
    private final ImageView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363260, 11);
    }

    public ItemQuestionDetailBottomBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemQuestionDetailBottomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[8], (ProgressBar) objArr[10], (TextView) objArr[9], (LinearLayout) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[4], (LinearLayout) objArr[1], (LinearLayout) objArr[11]);
        this.mDirtyFlags = -1;
        this.actionViewContainer.setTag(null);
        this.addAnswerImage.setTag(null);
        this.addAnswerProgress.setTag(null);
        this.addAnswerText.setTag(null);
        this.addAnswerView.setTag(null);
        this.followTextView.setTag(null);
        this.followView.setTag(null);
        this.inviteFriendView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.mboundView5 = imageView2;
        imageView2.setTag(null);
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
            setModel((Feed) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemQuestionDetailBottomBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
    }

    @Override // com.coolapk.market.databinding.ItemQuestionDetailBottomBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemQuestionDetailBottomBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        int i = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((j & 8) != 0) {
            ThemeBindingAdapters.setTintColor(this.addAnswerImage, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.addAnswerProgress, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.addAnswerText, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.followTextView, "colorAccent");
            ThemeBindingAdapters.setTintColor(this.mboundView2, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView3, "colorAccent");
            ThemeBindingAdapters.setTintColor(this.mboundView5, "colorAccent");
        }
        if (i != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.addAnswerView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.followView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.inviteFriendView, onClickListener, bool);
        }
    }
}
