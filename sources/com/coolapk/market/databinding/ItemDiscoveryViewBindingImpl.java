package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;

public class ItemDiscoveryViewBindingImpl extends ItemDiscoveryViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AutoLinkTextView mboundView8;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362657, 10);
        sparseIntArray.put(2131363030, 11);
        sparseIntArray.put(2131363551, 12);
        sparseIntArray.put(2131363243, 13);
    }

    public ItemDiscoveryViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemDiscoveryViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (LinearLayout) objArr[1], (LinearLayout) objArr[2], (CoolapkCardView) objArr[0], (FeedActionView2) objArr[7], (ForegroundTextView) objArr[9], (TextView) objArr[5], (Space) objArr[10], (ImageView) objArr[3], (Space) objArr[11], (Space) objArr[13], (TextView) objArr[12], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.cardView.setTag(null);
        this.contentContainer.setTag(null);
        this.coolapkCardView.setTag(null);
        this.feedActionView.setTag(null);
        this.foregroundTextView.setTag(null);
        this.fromWhereView.setTag(null);
        this.iconView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[8];
        this.mboundView8 = autoLinkTextView;
        autoLinkTextView.setTag(null);
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
        if (198 == i) {
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDiscoveryViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDiscoveryViewBinding
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
        int i;
        String str3;
        int i2;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feed != null) {
                str5 = feed.getExtraTitle();
                str9 = feed.getAdminInfo();
                z = feed.isIncludedDiscoveryFeed();
                str8 = feed.getExtraPic();
                str7 = feed.getExtraInfo();
                str6 = feed.getFeedType();
            } else {
                str5 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                z = false;
            }
            if (i4 != 0) {
                j |= z ? 1024 : 512;
            }
            boolean isEmpty = TextUtils.isEmpty(str9);
            str4 = z ? this.actionButton.getResources().getString(2131886840) : this.actionButton.getResources().getString(2131886841);
            boolean isEmpty2 = TextUtils.isEmpty(str7);
            boolean isDiscoveryType = FeedUtils.isDiscoveryType(str6);
            if ((j & 5) != 0) {
                j |= isEmpty ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= isEmpty2 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j |= isDiscoveryType ? 16 : 8;
            }
            int i5 = isEmpty ? 8 : 0;
            int i6 = isEmpty2 ? 8 : 0;
            str = str7;
            str3 = str9;
            i3 = isDiscoveryType ? 0 : 8;
            str2 = str8;
            i = i5;
            i2 = i6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i7 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.actionButton, "colorAccent");
            String str10 = null;
            ViewBindingAdapters.clipView(this.actionButton, str10, 13);
            ViewBindingAdapters.clipView(this.contentContainer, str10, 4);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str4);
            this.actionButton.setVisibility(i3);
            ViewBindingAdapters.updateFeed(this.feedActionView, feed);
            ViewBindingAdapters.updateFeed(this.foregroundTextView, feed);
            TextViewBindingAdapter.setText(this.fromWhereView, str);
            this.fromWhereView.setVisibility(i2);
            Boolean bool = null;
            String str11 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str2, null, 2131231374, 0, bool, bool, bool, bool, bool, str11, null, null, true, bool, bool, null, bool);
            this.mboundView8.setVisibility(i);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView8, str3, null, str11, bool, null, str11);
            TextViewBindingAdapter.setText(this.titleView, str5);
        }
        if (i7 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.actionButton, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.iconView, onClickListener, bool2);
        }
    }
}
