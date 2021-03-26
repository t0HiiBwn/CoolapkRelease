package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ForwardFeed;

public class ItemFeedForwardViewBindingImpl extends ItemFeedForwardViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFeedForwardViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemFeedForwardViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.replyReplyInfoText.setTag(null);
        this.textView.setTag(null);
        this.titleView.setTag(null);
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
        if (197 == i) {
            setModel((ForwardFeed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedForwardViewBinding
    public void setModel(ForwardFeed forwardFeed) {
        this.mModel = forwardFeed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedForwardViewBinding
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
        ForwardFeed forwardFeed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i == 0 || forwardFeed == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            str3 = forwardFeed.getUserName();
            str2 = forwardFeed.getMessage();
            str = forwardFeed.getUserAvatar();
        }
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.iconView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.titleView, onClickListener, bool);
        }
        if (i != 0) {
            Boolean bool2 = null;
            String str4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231152, 0, bool2, bool2, bool2, bool2, bool2, str4, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapters.setDatelineByEntity(this.replyReplyInfoText, forwardFeed);
            TextViewBindingAdapters.setTextViewLinkable(this.textView, str2, null, str4, bool2, null, str4);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.iconView, "oval", null);
            ThemeBindingAdapters.setTextColor(this.titleView, "colorAccent");
        }
    }
}
