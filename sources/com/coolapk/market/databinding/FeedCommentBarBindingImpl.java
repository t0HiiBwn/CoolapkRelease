package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class FeedCommentBarBindingImpl extends FeedCommentBarBinding {
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
        sparseIntArray.put(2131363274, 14);
        sparseIntArray.put(2131362718, 15);
        sparseIntArray.put(2131362295, 16);
    }

    public FeedCommentBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private FeedCommentBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (TextView) objArr[4], (ImageView) objArr[3], (TextView) objArr[16], (FrameLayout) objArr[2], (ImageView) objArr[15], (TextView) objArr[7], (ImageView) objArr[6], (FrameLayout) objArr[5], (LinearLayout) objArr[14], (TextView) objArr[13], (ImageView) objArr[12], (FrameLayout) objArr[11], (TextView) objArr[10], (ImageView) objArr[9], (FrameLayout) objArr[8]);
        this.mDirtyFlags = -1;
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
        this.shareCount.setTag(null);
        this.shareIcon.setTag(null);
        this.shareView.setTag(null);
        this.starCount.setTag(null);
        this.starIcon.setTag(null);
        this.starView.setTag(null);
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

    @Override // com.coolapk.market.databinding.FeedCommentBarBinding
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
        if ((3 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.commentBox, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.shareView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.starView, onClickListener, bool);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.commentCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.commentIcon, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.likeCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.likeIcon, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.shareCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.shareIcon, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.starCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.starIcon, "textColorSecondary");
        }
    }
}
