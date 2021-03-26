package com.coolapk.market.databinding;

import android.text.Html;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.widget.view.BadBadRatingBar;

public class ItemFeedRatingDetailBindingImpl extends ItemFeedRatingDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ItemFeedTargetViewBinding mboundView0;
    private final View mboundView1;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(19);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_feed_target_view"}, new int[]{6}, new int[]{2131558732});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 7);
        sparseIntArray.put(2131363211, 8);
        sparseIntArray.put(2131363194, 9);
        sparseIntArray.put(2131363281, 10);
        sparseIntArray.put(2131363063, 11);
        sparseIntArray.put(2131362627, 12);
        sparseIntArray.put(2131362626, 13);
        sparseIntArray.put(2131362109, 14);
        sparseIntArray.put(2131362108, 15);
        sparseIntArray.put(2131362603, 16);
        sparseIntArray.put(2131362602, 17);
        sparseIntArray.put(2131363229, 18);
    }

    public ItemFeedRatingDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private ItemFeedRatingDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Space) objArr[15], (TextView) objArr[14], (LinearLayout) objArr[0], (Space) objArr[17], (TextView) objArr[16], (Space) objArr[13], (TextView) objArr[12], (Space) objArr[7], (TextView) objArr[11], (LinearLayout) objArr[2], (BadBadRatingBar) objArr[9], (TextView) objArr[8], (Space) objArr[18], (TextView) objArr[10]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        ItemFeedTargetViewBinding itemFeedTargetViewBinding = (ItemFeedTargetViewBinding) objArr[6];
        this.mboundView0 = itemFeedTargetViewBinding;
        setContainedBinding(itemFeedTargetViewBinding);
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        this.ownerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.mboundView0.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.mboundView0.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (197 == i) {
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedRatingDetailBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedRatingDetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        FeedTarget feedTarget;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feed != null) {
                feedTarget = feed.getTargetRow();
                str6 = feed.getCommentGood();
                str5 = feed.getCommentGeneral();
                str4 = feed.getCommentBad();
            } else {
                feedTarget = null;
                str6 = null;
                str5 = null;
                str4 = null;
            }
            boolean z = feedTarget == null;
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                i = 8;
            }
            str3 = str5;
            str = str6;
            str2 = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((5 & j) != 0) {
            this.mboundView0.setModel(feed);
            this.mboundView1.setVisibility(i);
            Integer num = null;
            String str7 = null;
            Boolean bool = null;
            Html.ImageGetter imageGetter = null;
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView3, str, num, str7, bool, imageGetter, str7);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView4, str2, num, str7, bool, imageGetter, str7);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView5, str3, num, str7, bool, imageGetter, str7);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.ownerView, null, 4);
        }
        executeBindingsOn(this.mboundView0);
    }
}
