package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.view.KeyBoardLayout;

public class SubmitFeedV8BindingImpl extends SubmitFeedV8Binding {
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
        sparseIntArray.put(2131363615, 17);
        sparseIntArray.put(2131362322, 18);
        sparseIntArray.put(2131362130, 19);
        sparseIntArray.put(2131361923, 20);
        sparseIntArray.put(2131362518, 21);
        sparseIntArray.put(2131362517, 22);
    }

    public SubmitFeedV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private SubmitFeedV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[20], (LinearLayout) objArr[19], (ImageView) objArr[1], (FrameLayout) objArr[18], (FrameLayout) objArr[22], (LinearLayout) objArr[21], (KeyBoardLayout) objArr[0], (FrameLayout) objArr[13], (View) objArr[14], (ImageView) objArr[15], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[16], (ImageView) objArr[7], (ImageView) objArr[11], (ImageView) objArr[12], (ImageView) objArr[10], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[4], (LinearLayout) objArr[17]);
        this.mDirtyFlags = -1;
        this.closeView.setTag(null);
        this.keyBoardInteractLayout.setTag(null);
        this.menuAddGoods.setTag(null);
        this.menuAddGoodsBandageView.setTag(null);
        this.menuAddMore.setTag(null);
        this.menuAddPhoto.setTag(null);
        this.menuAtItem.setTag(null);
        this.menuCloseKeyboard.setTag(null);
        this.menuEmotion.setTag(null);
        this.menuFont.setTag(null);
        this.menuShareApp.setTag(null);
        this.menuTopicItem.setTag(null);
        this.previewView.setTag(null);
        this.submitView.setTag(null);
        this.subtitleView.setTag(null);
        this.titleView.setTag(null);
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
        if (289 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.SubmitFeedV8Binding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(289);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SubmitFeedV8Binding
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
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        boolean z;
        float f;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        float f2;
        int i7;
        String str4;
        String str5;
        String str6;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        boolean z6;
        boolean z7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        float f3 = 0.0f;
        int i12 = 0;
        if ((j & 7) != 0) {
            if (feedUIConfig != null) {
                z3 = feedUIConfig.isMenuItemEnabled();
                z2 = feedUIConfig.addPhotoMenuEnable();
            } else {
                z3 = false;
                z2 = false;
            }
            if ((j & 5) != 0) {
                j |= z3 ? 4096 : 2048;
            }
            if ((j & 5) != 0) {
                j |= z2 ? 16384 : 8192;
            }
            int i13 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
            if (i13 != 0) {
                float f4 = 1.0f;
                float f5 = z3 ? 1.0f : 0.25f;
                if (!z2) {
                    f4 = 0.25f;
                }
                f2 = f4;
                f3 = f5;
            } else {
                f2 = 0.0f;
            }
            if (i13 != 0) {
                if (feedUIConfig != null) {
                    z = feedUIConfig.isShowAddGoodsInMenuBar();
                    z7 = feedUIConfig.isRichTextItemVisible();
                    z6 = feedUIConfig.isPickPhotoItemVisible();
                    z5 = feedUIConfig.isAddExtraItemVisible();
                    str6 = feedUIConfig.subtitle();
                    str5 = feedUIConfig.submitText();
                    str4 = feedUIConfig.title();
                    z4 = feedUIConfig.isShareAppItemVisible();
                } else {
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    z4 = false;
                    z = false;
                    z7 = false;
                    z6 = false;
                    z5 = false;
                }
                if (i13 != 0) {
                    j |= z ? 64 : 32;
                }
                if ((j & 5) != 0) {
                    j |= z7 ? 1048576 : 524288;
                }
                if ((j & 5) != 0) {
                    j |= z6 ? 16 : 8;
                }
                if ((j & 5) != 0) {
                    j |= z5 ? 1024 : 512;
                }
                if ((j & 5) != 0) {
                    j = z4 ? j | 262144 : j | 131072;
                }
                i11 = z ? 0 : 8;
                i10 = z7 ? 0 : 8;
                i9 = z6 ? 0 : 8;
                i8 = z5 ? 0 : 8;
                boolean isEmpty = TextUtils.isEmpty(str6);
                if ((j & 5) != 0) {
                    j |= isEmpty ? 65536 : 32768;
                }
                if (isEmpty) {
                    i7 = 8;
                    f = f2;
                    i5 = i11;
                    i4 = i10;
                    i3 = i9;
                    i2 = i8;
                    str3 = str6;
                    str2 = str5;
                    str = str4;
                    i = i7;
                }
            } else {
                str6 = null;
                str5 = null;
                str4 = null;
                z4 = false;
                z = false;
                i11 = 0;
                i10 = 0;
                i9 = 0;
                i8 = 0;
            }
            i7 = 0;
            f = f2;
            i5 = i11;
            i4 = i10;
            i3 = i9;
            i2 = i8;
            str3 = str6;
            str2 = str5;
            str = str4;
            i = i7;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            z4 = false;
            i5 = 0;
            i4 = 0;
            z3 = false;
            z2 = false;
            f = 0.0f;
            z = false;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        boolean z8 = (262144 & j) != 0 ? !z : false;
        int i14 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i14 != 0) {
            if (!z4) {
                z8 = false;
            }
            if (i14 != 0) {
                j |= z8 ? 256 : 128;
            }
            if (!z8) {
                i12 = 8;
            }
            i6 = i12;
        } else {
            i6 = 0;
        }
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.closeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuCloseKeyboard, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.previewView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.submitView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.toArticleView, onClickListener, bool);
        }
        if ((j & 5) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.menuAddGoods.setAlpha(f3);
                this.menuAddMore.setAlpha(f3);
                this.menuAddPhoto.setAlpha(f);
                this.menuAtItem.setAlpha(f3);
                this.menuEmotion.setAlpha(f3);
                this.menuFont.setAlpha(f3);
                this.menuShareApp.setAlpha(f3);
                this.menuTopicItem.setAlpha(f3);
            }
            this.menuAddGoods.setVisibility(i5);
            this.menuAddMore.setVisibility(i2);
            this.menuAddPhoto.setVisibility(i3);
            this.menuFont.setVisibility(i4);
            this.menuShareApp.setVisibility(i6);
            TextViewBindingAdapter.setText(this.submitView, str2);
            TextViewBindingAdapter.setText(this.subtitleView, str3);
            this.subtitleView.setVisibility(i);
            TextViewBindingAdapter.setText(this.titleView, str);
        }
        if ((7 & j) != 0) {
            ViewBindingAdapter.setOnClick(this.menuAddGoods, onClickListener, z3);
            ViewBindingAdapter.setOnClick(this.menuAddMore, onClickListener, z3);
            ViewBindingAdapter.setOnClick(this.menuAddPhoto, onClickListener, z2);
            ViewBindingAdapter.setOnClick(this.menuAtItem, onClickListener, z3);
            ViewBindingAdapter.setOnClick(this.menuEmotion, onClickListener, z3);
            ViewBindingAdapter.setOnClick(this.menuFont, onClickListener, z3);
            ViewBindingAdapter.setOnClick(this.menuShareApp, onClickListener, z3);
            ViewBindingAdapter.setOnClick(this.menuTopicItem, onClickListener, z3);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.menuAddGoodsBandageView, "oval", null);
            ThemeBindingAdapters.setTextColor(this.toArticleView, "colorAccent");
        }
    }
}
