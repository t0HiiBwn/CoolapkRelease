package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class FeedAnswerViewPartBindingImpl extends FeedAnswerViewPartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363274, 12);
        sparseIntArray.put(2131362718, 13);
        sparseIntArray.put(2131362295, 14);
    }

    public FeedAnswerViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FeedAnswerViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[9], (ProgressBar) objArr[11], (TextView) objArr[10], (LinearLayout) objArr[8], (LinearLayout) objArr[1], (TextView) objArr[4], (ImageView) objArr[3], (TextView) objArr[14], (LinearLayout) objArr[2], (ImageView) objArr[13], (TextView) objArr[7], (ImageView) objArr[6], (LinearLayout) objArr[5], (LinearLayout) objArr[12]);
        this.mDirtyFlags = -1;
        this.addAnswerImage.setTag(null);
        this.addAnswerProgress.setTag(null);
        this.addAnswerText.setTag(null);
        this.addAnswerView.setTag(null);
        this.commentBox.setTag(null);
        this.commentCount.setTag(null);
        this.commentIcon.setTag(null);
        this.commentView.setTag(null);
        this.likeCount.setTag(null);
        this.likeIcon.setTag(null);
        this.likeView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (50 != i) {
            return false;
        }
        setClick((View.OnClickListener) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.FeedAnswerViewPartBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
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
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTintColor(this.addAnswerImage, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.addAnswerProgress, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.addAnswerText, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.commentCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.commentIcon, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.likeCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.likeIcon, "textColorSecondary");
        }
        if (i != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.addAnswerView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentBox, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
        }
    }
}
