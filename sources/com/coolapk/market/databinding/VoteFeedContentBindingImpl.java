package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.LinearMultiLayout;

public class VoteFeedContentBindingImpl extends VoteFeedContentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final View mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363604, 8);
        sparseIntArray.put(2131362970, 9);
        sparseIntArray.put(2131363972, 10);
    }

    public VoteFeedContentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private VoteFeedContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[4], (EditText) objArr[2], (LinearMultiLayout) objArr[9], (LinearLayout) objArr[7], (TextView) objArr[6], (TextView) objArr[5], (LinearLayout) objArr[1], (TextView) objArr[8], (TextView) objArr[10]);
        this.mDirtyFlags = -1;
        this.editText.setTag(null);
        this.editTitle.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        View view2 = (View) objArr[3];
        this.mboundView3 = view2;
        view2.setTag(null);
        this.moreSettingView.setTag(null);
        this.multiModeView.setTag(null);
        this.pkModeView.setTag(null);
        this.relativeView.setTag(null);
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
        if (289 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.VoteFeedContentBinding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(289);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.VoteFeedContentBinding
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
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feedUIConfig != null) {
                z = feedUIConfig.isEditTitleViewVisible();
                str = feedUIConfig.editTextHint();
                str2 = feedUIConfig.editTitleHint();
            } else {
                str2 = null;
                str = null;
                z = false;
            }
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (!z) {
                i = 8;
            }
        } else {
            str2 = null;
            str = null;
        }
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((5 & j) != 0) {
            this.editText.setHint(str);
            this.editTitle.setHint(str2);
            this.editTitle.setVisibility(i);
            this.mboundView3.setVisibility(i);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.moreSettingView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.multiModeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.pkModeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.relativeView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            String str3 = null;
            ViewBindingAdapters.clipView(this.multiModeView, str3, 3);
            ViewBindingAdapters.clipView(this.pkModeView, str3, 3);
        }
    }
}
