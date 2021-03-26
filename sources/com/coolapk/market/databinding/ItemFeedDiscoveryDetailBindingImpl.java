package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.text.TextUtils;
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
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.FeedUtils;

public class ItemFeedDiscoveryDetailBindingImpl extends ItemFeedDiscoveryDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362657, 8);
        sparseIntArray.put(2131363030, 9);
        sparseIntArray.put(2131363557, 10);
        sparseIntArray.put(2131363243, 11);
    }

    public ItemFeedDiscoveryDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemFeedDiscoveryDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (LinearLayout) objArr[0], (LinearLayout) objArr[1], (TextView) objArr[5], (Space) objArr[8], (ImageView) objArr[3], (LinearLayout) objArr[2], (Space) objArr[9], (Space) objArr[11], (TextView) objArr[7], (FrameLayout) objArr[10], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.cardView.setTag(null);
        this.contentContainer.setTag(null);
        this.fromWhereView.setTag(null);
        this.iconView.setTag(null);
        this.infoView.setTag(null);
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
        if (198 == i) {
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedDiscoveryDetailBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedDiscoveryDetailBinding
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
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z;
        String str9;
        int i2;
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i3 = 0;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feed != null) {
                str4 = feed.getExtraTitle();
                z = feed.isIncludedDiscoveryFeed();
                str8 = feed.getExtraPic();
                str7 = feed.getMessage();
                str6 = feed.getExtraInfo();
                str9 = feed.getFeedType();
            } else {
                str9 = null;
                str4 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                z = false;
            }
            if (i4 != 0) {
                j |= z ? 256 : 128;
            }
            if (z) {
                resources = this.actionButton.getResources();
                i2 = 2131886840;
            } else {
                resources = this.actionButton.getResources();
                i2 = 2131886841;
            }
            str3 = resources.getString(i2);
            boolean isEmpty = TextUtils.isEmpty(str6);
            boolean isDiscoveryType = FeedUtils.isDiscoveryType(str9);
            if ((j & 5) != 0) {
                j |= isEmpty ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= isDiscoveryType ? 16 : 8;
            }
            i = isEmpty ? 8 : 0;
            if (!isDiscoveryType) {
                i3 = 8;
            }
            str5 = str7;
            str = str8;
            str2 = str6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.actionButton, "colorAccent");
            String str10 = null;
            ViewBindingAdapters.clipView(this.actionButton, str10, 13);
            ViewBindingAdapters.clipView(this.contentContainer, str10, 4);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str3);
            this.actionButton.setVisibility(i3);
            TextViewBindingAdapter.setText(this.fromWhereView, str2);
            this.fromWhereView.setVisibility(i);
            Boolean bool = null;
            String str11 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231374, 0, bool, bool, bool, bool, bool, str11, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapters.setTextViewLinkable(this.textView, str5, null, str11, bool, null, str11);
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
        if (i5 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.actionButton, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.iconView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.infoView, onClickListener, bool2);
        }
    }
}
