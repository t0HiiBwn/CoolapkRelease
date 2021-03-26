package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.model.Live;
import com.coolapk.market.view.live.LiveViewModel;

public class LiveIntroduceBindingImpl extends LiveIntroduceBinding {
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
        sparseIntArray.put(2131362300, 4);
        sparseIntArray.put(2131363582, 5);
        sparseIntArray.put(2131363138, 6);
    }

    public LiveIntroduceBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private LiveIntroduceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[4], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[2], (FrameLayout) objArr[6], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.liveIntroduceView.setTag(null);
        this.liveTime.setTag(null);
        this.liveType.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (308 != i) {
            return false;
        }
        setViewModel((LiveViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.LiveIntroduceBinding
    public void setViewModel(LiveViewModel liveViewModel) {
        this.mViewModel = liveViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        Live live;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LiveViewModel liveViewModel = this.mViewModel;
        String str4 = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (liveViewModel != null) {
                str3 = liveViewModel.getLiveTypeString();
                live = liveViewModel.getLive();
            } else {
                str3 = null;
                live = null;
            }
            if (live != null) {
                String showLiveTime = live.getShowLiveTime();
                String description = live.getDescription();
                str = str3;
                str2 = showLiveTime;
                str4 = description;
            } else {
                str = str3;
                str2 = null;
            }
        } else {
            str2 = null;
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.liveIntroduceView, str4);
            TextViewBindingAdapter.setText(this.liveTime, str2);
            TextViewBindingAdapter.setText(this.liveType, str);
        }
    }
}
