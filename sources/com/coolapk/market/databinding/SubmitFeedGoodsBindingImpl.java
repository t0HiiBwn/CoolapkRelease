package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.view.BadBadRatingBar;

public class SubmitFeedGoodsBindingImpl extends SubmitFeedGoodsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final LinearLayout mboundView1;
    private final ImageView mboundView2;
    private final TextView mboundView4;
    private final ImageView mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362322, 11);
        sparseIntArray.put(2131363208, 12);
        sparseIntArray.put(2131363994, 13);
        sparseIntArray.put(2131362189, 14);
        sparseIntArray.put(2131363111, 15);
        sparseIntArray.put(2131363981, 16);
        sparseIntArray.put(2131363235, 17);
        sparseIntArray.put(2131362423, 18);
    }

    public SubmitFeedGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private SubmitFeedGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[6], (CheckBox) objArr[14], (ImageView) objArr[5], (TextView) objArr[9], (TextView) objArr[10], (LinearLayout) objArr[11], (View) objArr[18], (EditText) objArr[8], (RelativeLayout) objArr[15], (BadBadRatingBar) objArr[12], (RecyclerView) objArr[17], (TextView) objArr[3], (LinearLayout) objArr[16], (CheckBox) objArr[13]);
        this.mDirtyFlags = -1;
        this.addGoodsView.setTag(null);
        this.closeView.setTag(null);
        this.commentBoardTip1.setTag(null);
        this.commentBoardTip2.setTag(null);
        this.editText.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.mboundView7 = imageView2;
        imageView2.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (109 == i) {
            setFeedGoods((FeedGoods) obj);
        } else if (289 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.SubmitFeedGoodsBinding
    public void setFeedGoods(FeedGoods feedGoods) {
        this.mFeedGoods = feedGoods;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(109);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SubmitFeedGoodsBinding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(289);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SubmitFeedGoodsBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        int i2;
        String str3;
        int i3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedGoods feedGoods = this.mFeedGoods;
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feedGoods != null) {
                str3 = feedGoods.getTitle();
                str8 = feedGoods.getPrice();
                str7 = feedGoods.getCover();
            } else {
                str3 = null;
                str8 = null;
                str7 = null;
            }
            boolean z = feedGoods == null;
            boolean z2 = feedGoods != null;
            if (i4 != 0) {
                j |= z ? 512 : 256;
            }
            if ((j & 9) != 0) {
                j |= z2 ? 32 : 16;
            }
            str2 = "￥" + str8;
            boolean isEmpty = TextUtils.isEmpty(str8);
            int i5 = z ? 8 : 0;
            int i6 = z2 ? 8 : 0;
            if ((j & 9) != 0) {
                j |= isEmpty ? 128 : 64;
            }
            i2 = isEmpty ? 8 : 0;
            str = str7;
            i = i6;
            i3 = i5;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i7 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i7 == 0 || feedUIConfig == null) {
            str6 = null;
            str5 = null;
            str4 = null;
        } else {
            String commentBoardTip2 = feedUIConfig.commentBoardTip2();
            String commentBoardTip1 = feedUIConfig.commentBoardTip1();
            str6 = feedUIConfig.editTextHint();
            str5 = commentBoardTip2;
            str4 = commentBoardTip1;
        }
        int i8 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((9 & j) != 0) {
            this.addGoodsView.setVisibility(i);
            this.mboundView1.setVisibility(i3);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView2, str, null, 2131231374, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, true, null, bool);
            TextViewBindingAdapter.setText(this.mboundView4, str2);
            this.mboundView4.setVisibility(i2);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
        if (i8 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.addGoodsView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.closeView, onClickListener, bool2);
        }
        if ((j & 8) != 0) {
            String str9 = null;
            ViewBindingAdapters.clipView(this.addGoodsView, str9, 8);
            ViewBindingAdapters.clipView(this.closeView, "oval", null);
            ViewBindingAdapters.clipView(this.mboundView1, str9, 8);
            ViewBindingAdapters.clipView(this.mboundView2, str9, 8);
            ViewBindingAdapters.clipView(this.mboundView7, str9, 8);
        }
        if (i7 != 0) {
            TextViewBindingAdapter.setText(this.commentBoardTip1, str4);
            TextViewBindingAdapter.setText(this.commentBoardTip2, str5);
            this.editText.setHint(str6);
        }
    }
}
