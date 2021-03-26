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

public class SecondHandCommentBarBindingImpl extends SecondHandCommentBarBinding {
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
        sparseIntArray.put(2131363260, 15);
        sparseIntArray.put(2131362882, 16);
    }

    public SecondHandCommentBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private SecondHandCommentBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (ImageView) objArr[2], (FrameLayout) objArr[1], (TextView) objArr[14], (TextView) objArr[6], (ImageView) objArr[5], (FrameLayout) objArr[4], (ProgressBar) objArr[16], (LinearLayout) objArr[15], (FrameLayout) objArr[13], (TextView) objArr[12], (ImageView) objArr[11], (FrameLayout) objArr[10], (TextView) objArr[9], (ImageView) objArr[8], (FrameLayout) objArr[7]);
        this.mDirtyFlags = -1;
        this.commentCount.setTag(null);
        this.commentIcon.setTag(null);
        this.commentView.setTag(null);
        this.goToSecongHand.setTag(null);
        this.likeCount.setTag(null);
        this.likeIcon.setTag(null);
        this.likeView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.secondHandAction.setTag(null);
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

    @Override // com.coolapk.market.databinding.SecondHandCommentBarBinding
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
            ThemeBindingAdapters.setTextColor(this.commentCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.commentIcon, "textColorSecondary");
            ThemeBindingAdapters.setBackgroundColor(this.goToSecongHand, "colorAccent");
            ViewBindingAdapters.clipView(this.goToSecongHand, null, 4);
            ThemeBindingAdapters.setTextColor(this.likeCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.likeIcon, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.shareCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.shareIcon, "textColorSecondary");
            ThemeBindingAdapters.setTextColor(this.starCount, "textColorSecondary");
            ThemeBindingAdapters.setTintColor(this.starIcon, "textColorSecondary");
        }
        if (i != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.goToSecongHand, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.secondHandAction, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.shareView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.starView, onClickListener, bool);
        }
    }
}
