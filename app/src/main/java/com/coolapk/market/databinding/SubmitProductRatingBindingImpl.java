package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;

public class SubmitProductRatingBindingImpl extends SubmitProductRatingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363230, 5);
        sparseIntArray.put(2131363279, 6);
        sparseIntArray.put(2131363194, 7);
        sparseIntArray.put(2131363097, 8);
        sparseIntArray.put(2131363955, 9);
        sparseIntArray.put(2131363221, 10);
        sparseIntArray.put(2131363397, 11);
    }

    public SubmitProductRatingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private SubmitProductRatingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (TextView) objArr[4], (AppCompatEditText) objArr[1], (RelativeLayout) objArr[8], (RatingBar) objArr[7], (RecyclerView) objArr[10], (LinearLayout) objArr[5], (TextView) objArr[6], (Space) objArr[11], (TextView) objArr[2], (LinearLayout) objArr[9]);
        this.mDirtyFlags = -1;
        this.commentBoardTip1.setTag(null);
        this.commentBoardTip2.setTag(null);
        this.editText.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        this.toArticleView.setTag(null);
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
        if (288 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.SubmitProductRatingBinding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SubmitProductRatingBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i == 0 || feedUIConfig == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            str2 = feedUIConfig.editTextHint();
            str = feedUIConfig.commentBoardTip2();
            str3 = feedUIConfig.commentBoardTip1();
        }
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i != 0) {
            TextViewBindingAdapter.setText(this.commentBoardTip1, str3);
            TextViewBindingAdapter.setText(this.commentBoardTip2, str);
            this.editText.setHint(str2);
        }
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setTextColor(this.toArticleView, "colorAccent");
            ViewBindingAdapters.clipView(this.toArticleView, "capsule", null);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.toArticleView, onClickListener, null);
        }
    }
}
