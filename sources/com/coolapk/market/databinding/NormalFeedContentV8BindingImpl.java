package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedUIConfig;
import java.util.List;

public class NormalFeedContentV8BindingImpl extends NormalFeedContentV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final LinearLayout mboundView1;
    private final TextView mboundView11;
    private final TextView mboundView12;
    private final RelativeLayout mboundView3;
    private final View mboundView4;
    private final View mboundView6;
    private final LinearLayout mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(28);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"feed_warning"}, new int[]{19}, new int[]{2131558563});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363194, 20);
        sparseIntArray.put(2131363212, 21);
        sparseIntArray.put(2131362443, 22);
        sparseIntArray.put(2131363917, 23);
        sparseIntArray.put(2131363955, 24);
        sparseIntArray.put(2131363221, 25);
        sparseIntArray.put(2131362592, 26);
        sparseIntArray.put(2131363397, 27);
    }

    public NormalFeedContentV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 28, sIncludes, sViewsWithIds));
    }

    private NormalFeedContentV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FeedWarningBinding) objArr[19], (TextView) objArr[17], (TextView) objArr[18], (EditText) objArr[7], (EditText) objArr[5], (TextView) objArr[22], (CardView) objArr[8], (FrameLayout) objArr[14], (LinearLayout) objArr[26], (ImageView) objArr[10], (RelativeLayout) objArr[16], (RatingBar) objArr[20], (TextView) objArr[21], (RecyclerView) objArr[25], (LinearLayout) objArr[2], (ImageView) objArr[15], (ImageView) objArr[13], (Space) objArr[27], (Space) objArr[23], (LinearLayout) objArr[24]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.commentBoardTip1.setTag(null);
        this.commentBoardTip2.setTag(null);
        this.editText.setTag(null);
        this.editTitle.setTag(null);
        this.extraView.setTag(null);
        this.extraViewContainer.setTag(null);
        this.logoView.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.mboundView11 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.mboundView12 = textView2;
        textView2.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[3];
        this.mboundView3 = relativeLayout;
        relativeLayout.setTag(null);
        View view2 = (View) objArr[4];
        this.mboundView4 = view2;
        view2.setTag(null);
        View view3 = (View) objArr[6];
        this.mboundView6 = view3;
        view3.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[9];
        this.mboundView9 = linearLayout2;
        linearLayout2.setTag(null);
        this.photoContainer.setTag(null);
        this.relativeView.setTag(null);
        this.removeExtraEntityView.setTag(null);
        this.removeExtraView.setTag(null);
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
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.NormalFeedContentV8Binding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.NormalFeedContentV8Binding
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
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        String str7;
        int i9;
        boolean z3;
        String str8;
        boolean z4;
        String str9;
        String str10;
        String str11;
        List<Entity> list;
        boolean z5;
        boolean z6;
        boolean z7;
        int i10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i11 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i11 != 0) {
            if (feedUIConfig != null) {
                z2 = feedUIConfig.isPickPhotoContainerVisible();
                z6 = feedUIConfig.isEditTitleViewVisible();
                str6 = feedUIConfig.commentBoardTip2();
                z5 = feedUIConfig.isRatingBarVisible();
                list = feedUIConfig.extraEntities();
                str11 = feedUIConfig.commentBoardTip1();
                str5 = feedUIConfig.extraViewContent();
                z = feedUIConfig.isPickPhotoItemVisible();
                str10 = feedUIConfig.extraViewTitle();
                str9 = feedUIConfig.extraViewLogoUrl();
                z4 = feedUIConfig.isRemoveExtraViewVisible();
                str8 = feedUIConfig.editTextHint();
                z3 = feedUIConfig.isExtraViewVisible();
                str7 = feedUIConfig.editTitleHint();
            } else {
                str7 = null;
                str6 = null;
                list = null;
                str11 = null;
                str5 = null;
                str10 = null;
                str9 = null;
                str8 = null;
                z2 = false;
                z6 = false;
                z5 = false;
                z = false;
                z4 = false;
                z3 = false;
            }
            if (i11 != 0) {
                j |= z2 ? 2048 : 1024;
            }
            if ((j & 10) != 0) {
                j |= z6 ? 32 : 16;
            }
            if ((j & 10) != 0) {
                j |= z5 ? 131072 : 65536;
            }
            if ((j & 10) != 0) {
                j |= z ? 524288 : 262144;
            }
            if ((j & 10) != 0) {
                j |= z4 ? 8388608 : 4194304;
            }
            if ((j & 10) != 0) {
                j |= z3 ? 2097152 : 1048576;
            }
            i5 = z2 ? 3 : 5;
            i8 = z6 ? 0 : 8;
            int i12 = z5 ? 0 : 8;
            boolean isEmpty = TextUtils.isEmpty(str5);
            int i13 = z4 ? 0 : 8;
            int i14 = z3 ? 0 : 8;
            if ((j & 10) != 0) {
                j |= isEmpty ? 512 : 256;
            }
            if (list != null) {
                z7 = list.isEmpty();
            } else {
                z7 = false;
            }
            if ((j & 10) != 0) {
                j |= z7 ? 32768 : 16384;
            }
            if (str10 != null) {
                i10 = str10.length();
            } else {
                i10 = 0;
            }
            int i15 = isEmpty ? 8 : 0;
            int i16 = z7 ? 8 : 0;
            boolean z8 = i10 == 0;
            if ((j & 10) != 0) {
                j |= z8 ? 8192 : 4096;
            }
            i7 = i12;
            i6 = i16;
            str4 = str11;
            str3 = str10;
            str2 = str9;
            i4 = i13;
            str = str8;
            i3 = i14;
            i2 = i15;
            i = z8 ? 8 : 0;
        } else {
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z2 = false;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            z = false;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i17 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i17 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i17 != 0) {
                j |= z2 ? 128 : 64;
            }
            i9 = z2 ? 0 : 8;
        } else {
            i9 = 0;
        }
        if ((j & 12) != 0) {
            this.alertView.setClick(onClickListener);
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.extraView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.relativeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.removeExtraEntityView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.removeExtraView, onClickListener, bool);
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.commentBoardTip1, str4);
            TextViewBindingAdapter.setText(this.commentBoardTip2, str6);
            this.editText.setHint(str);
            this.editText.setMinLines(i5);
            this.editTitle.setHint(str7);
            this.editTitle.setVisibility(i8);
            this.extraView.setVisibility(i3);
            this.extraViewContainer.setVisibility(i6);
            Boolean bool2 = null;
            String str12 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str2, null, 0, 0, bool2, bool2, bool2, bool2, bool2, str12, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapter.setText(this.mboundView11, str3);
            this.mboundView12.setVisibility(i2);
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView12, str5, null, "textColorSecondary", bool2, null, str12);
            this.mboundView3.setVisibility(i7);
            this.mboundView4.setVisibility(i7);
            this.mboundView6.setVisibility(i8);
            this.mboundView9.setVisibility(i);
            this.photoContainer.setVisibility(i9);
            this.removeExtraView.setVisibility(i4);
        }
        if ((j & 8) != 0) {
            ViewBindingAdapters.clipView(this.logoView, null, 4);
        }
        executeBindingsOn(this.alertView);
    }
}
