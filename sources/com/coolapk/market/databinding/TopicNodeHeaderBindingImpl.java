package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Topic;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class TopicNodeHeaderBindingImpl extends TopicNodeHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362102, 6);
        sparseIntArray.put(2131362104, 7);
        sparseIntArray.put(2131362105, 8);
        sparseIntArray.put(2131362101, 9);
        sparseIntArray.put(2131362779, 10);
        sparseIntArray.put(2131362345, 11);
        sparseIntArray.put(2131362726, 12);
        sparseIntArray.put(2131362920, 13);
        sparseIntArray.put(2131362741, 14);
        sparseIntArray.put(2131362651, 15);
        sparseIntArray.put(2131362675, 16);
        sparseIntArray.put(2131363645, 17);
        sparseIntArray.put(2131362588, 18);
        sparseIntArray.put(2131362382, 19);
    }

    public TopicNodeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private TopicNodeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (View) objArr[9], (LinearLayout) objArr[6], (Space) objArr[7], (View) objArr[8], (MaxWidthFrameLayout) objArr[11], (TextView) objArr[19], (TextView) objArr[18], (LinearLayout) objArr[15], (TextView) objArr[16], (ViewPager) objArr[12], (IndicatorView) objArr[14], (LinearLayout) objArr[10], (LinearAdapterLayout) objArr[5], (ImageView) objArr[1], (View) objArr[13], (LinearLayout) objArr[3], (Space) objArr[17]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.linearView.setTag(null);
        this.logoView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        this.moreFollowerView.setTag(null);
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
        if (198 == i) {
            setModel((Topic) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.TopicNodeHeaderBinding
    public void setModel(Topic topic) {
        this.mModel = topic;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.TopicNodeHeaderBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Topic topic = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        String title = (i == 0 || topic == null) ? null : topic.getTitle();
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            String str = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str, null, 0, 0, bool, bool, bool, bool, bool, str, null, null, bool, bool, bool, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.moreFollowerView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.actionView, "capsule", null);
            String str2 = null;
            ViewBindingAdapters.clipView(this.linearView, str2, 8);
            ViewBindingAdapters.clipView(this.logoView, str2, 8);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, title);
        }
    }
}
