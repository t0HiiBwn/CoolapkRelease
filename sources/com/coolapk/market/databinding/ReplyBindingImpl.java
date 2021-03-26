package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.view.feed.ReplyActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.KeyBoardLayout;
import java.util.List;

public class ReplyBindingImpl extends ReplyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView13;
    private final TextView mboundView3;
    private final LinearLayout mboundView8;
    private final LinearLayout mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(26);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"feed_warning"}, new int[]{22}, new int[]{2131558563});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362150, 23);
        sparseIntArray.put(2131362510, 24);
        sparseIntArray.put(2131362450, 25);
    }

    public ReplyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private ReplyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FeedWarningBinding) objArr[22], (LinearLayout) objArr[23], (CheckBox) objArr[14], (TextView) objArr[15], (LinearLayout) objArr[2], (EditText) objArr[5], (EmotionPanel) objArr[25], (LinearLayout) objArr[24], (ImageView) objArr[10], (KeyBoardLayout) objArr[0], (FrameLayout) objArr[1], (ImageView) objArr[17], (ImageView) objArr[18], (ImageView) objArr[21], (ImageView) objArr[16], (ImageView) objArr[20], (ImageView) objArr[19], (RecyclerView) objArr[12], (TextView) objArr[4], (TextView) objArr[7], (LinearLayout) objArr[6], (CoolEllipsizeTextView) objArr[11]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.checkBox.setTag(null);
        this.checkBoxText.setTag(null);
        this.contentView.setTag(null);
        this.editText.setTag(null);
        this.iconView.setTag(null);
        this.keyBoardInteractLayout.setTag(null);
        this.maskView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[13];
        this.mboundView13 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[8];
        this.mboundView8 = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[9];
        this.mboundView9 = linearLayout3;
        linearLayout3.setTag(null);
        this.menuAddPhoto.setTag(null);
        this.menuAtItem.setTag(null);
        this.menuCloseKeyboard.setTag(null);
        this.menuEmotion.setTag(null);
        this.menuShareApp.setTag(null);
        this.menuTopicItem.setTag(null);
        this.photoListView.setTag(null);
        this.postButton.setTag(null);
        this.sourceTextView.setTag(null);
        this.sourceView.setTag(null);
        this.textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.alertView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.alertView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (288 == i) {
            setUiConfig((ReplyActivity.ReplyUiConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ReplyBinding
    public void setUiConfig(ReplyActivity.ReplyUiConfig replyUiConfig) {
        this.mUiConfig = replyUiConfig;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ReplyBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        int i3;
        String str5;
        int i4;
        String str6;
        int i5;
        int i6;
        int i7;
        String str7;
        String str8;
        String str9;
        boolean z;
        boolean z2;
        String str10;
        boolean z3;
        String str11;
        List<String> list;
        boolean z4;
        boolean z5;
        String str12;
        int i8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ReplyActivity.ReplyUiConfig replyUiConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i9 = 0;
        int i10 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i10 != 0) {
            if (replyUiConfig != null) {
                z4 = replyUiConfig.getSourceViewVisible();
                list = replyUiConfig.getImageUrls();
                str11 = replyUiConfig.getSourceMessage();
                z3 = replyUiConfig.getPickAppVisible();
                str10 = replyUiConfig.getTitleText();
                z2 = replyUiConfig.getTopicViewVisible();
                z = replyUiConfig.getAtUserViewVisible();
                str9 = replyUiConfig.getCheckBoxText();
                str8 = replyUiConfig.getEditTextHint();
                str7 = replyUiConfig.getImageHint();
                z5 = replyUiConfig.getCheckBoxViewVisible();
            } else {
                list = null;
                str11 = null;
                str10 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            }
            if (i10 != 0) {
                j |= z4 ? 2048 : 1024;
            }
            if ((j & 10) != 0) {
                j |= z3 ? 131072 : 65536;
            }
            if ((j & 10) != 0) {
                j |= z2 ? 524288 : 262144;
            }
            if ((j & 10) != 0) {
                j |= z ? 512 : 256;
            }
            if ((j & 10) != 0) {
                j |= z5 ? 128 : 64;
            }
            int i11 = z4 ? 0 : 8;
            int i12 = z3 ? 0 : 4;
            int i13 = z2 ? 0 : 4;
            int i14 = z ? 0 : 4;
            int i15 = z5 ? 0 : 8;
            if (list != null) {
                str12 = (String) getFromList(list, 0);
                i8 = list.size();
            } else {
                str12 = null;
                i8 = 0;
            }
            boolean z6 = i8 == 0;
            boolean z7 = i8 == 1;
            boolean z8 = i8 > 1;
            if ((j & 10) != 0) {
                j |= z6 ? 8192 : 4096;
            }
            if ((j & 10) != 0) {
                j |= z7 ? 32 : 16;
            }
            if ((j & 10) != 0) {
                j |= z8 ? 32768 : 16384;
            }
            int i16 = z6 ? 8 : 0;
            int i17 = z7 ? 0 : 8;
            if (!z8) {
                i9 = 8;
            }
            i = i11;
            i2 = i9;
            i4 = i12;
            str4 = str10;
            i3 = i13;
            i5 = i14;
            str6 = str9;
            str3 = str8;
            str2 = str7;
            str = str12;
            i6 = i17;
            i9 = i15;
            str5 = str11;
            i7 = i16;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 12) != 0) {
            this.alertView.setClick(onClickListener);
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.checkBoxText, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.iconView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.maskView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuAddPhoto, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuAtItem, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuCloseKeyboard, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuEmotion, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuShareApp, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.menuTopicItem, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.postButton, onClickListener, bool);
        }
        if ((8 & j) != 0) {
            ThemeBindingAdapters.setTint(this.checkBox, "colorAccent");
            String str13 = null;
            ViewBindingAdapters.clipView(this.iconView, str13, 4);
            ViewBindingAdapters.clipView(this.mboundView9, str13, 4);
            ThemeBindingAdapters.setTextColor(this.postButton, "colorAccent");
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.checkBoxText, str6);
            this.editText.setHint(str3);
            Boolean bool2 = null;
            String str14 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231696), 0, 0, bool2, bool2, bool2, bool2, bool2, str14, null, null, bool2, bool2, true, null, bool2);
            this.mboundView13.setVisibility(i9);
            TextViewBindingAdapter.setText(this.mboundView3, str4);
            this.mboundView8.setVisibility(i7);
            this.mboundView9.setVisibility(i6);
            this.menuAtItem.setVisibility(i5);
            this.menuShareApp.setVisibility(i4);
            this.menuTopicItem.setVisibility(i3);
            this.photoListView.setVisibility(i2);
            TextViewBindingAdapters.setTextViewLinkable(this.sourceTextView, str5, null, str14, bool2, null, str14);
            this.sourceView.setVisibility(i);
            TextViewBindingAdapter.setText(this.textView, str2);
        }
        executeBindingsOn(this.alertView);
    }
}
