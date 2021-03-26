package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.collectionList.CollectionViewModel;
import com.coolapk.market.widget.UserAvatarView;

public class ItemCollectionHeaderBindingImpl extends ItemCollectionHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView4;
    private final TextView mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    public ItemCollectionHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemCollectionHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (UserAvatarView) objArr[5], (LinearLayout) objArr[2], (View) objArr[3]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.itemView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.mboundView7 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[8];
        this.mboundView8 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[9];
        this.mboundView9 = textView5;
        textView5.setTag(null);
        this.spaceHolder.setTag(null);
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
        if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((CollectionViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCollectionHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCollectionHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCollectionHeaderBinding
    public void setViewModel(CollectionViewModel collectionViewModel) {
        updateRegistration(0, collectionViewModel);
        this.mViewModel = collectionViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((CollectionViewModel) obj, i2);
    }

    private boolean onChangeViewModel(CollectionViewModel collectionViewModel, int i) {
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
        String str5;
        int i2;
        int i3;
        String str6;
        String str7;
        String str8;
        View.OnClickListener onClickListener;
        int i4;
        int i5;
        int i6;
        String str9;
        String str10;
        String str11;
        String str12;
        int i7;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        int i8;
        Collection collection;
        boolean z;
        String str20;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener2 = this.mClick;
        CollectionViewModel collectionViewModel = this.mViewModel;
        int i9 = 0;
        if ((j & 11) != 0) {
            int i10 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i10 != 0) {
                if (collectionViewModel != null) {
                    str20 = collectionViewModel.collectionUserName();
                    z = collectionViewModel.hasCover();
                    collection = collectionViewModel.collection();
                    str17 = collectionViewModel.collectionTitle();
                    str16 = collectionViewModel.collectionFollowNum();
                    str15 = collectionViewModel.collectionDescription();
                    str14 = collectionViewModel.collectionUpdateTime();
                    str13 = collectionViewModel.collectionCover();
                } else {
                    str20 = null;
                    collection = null;
                    str17 = null;
                    str16 = null;
                    str15 = null;
                    str14 = null;
                    str13 = null;
                    z = false;
                }
                if (i10 != 0) {
                    if (z) {
                        j3 = j | 32;
                        j2 = 512;
                    } else {
                        j3 = j | 16;
                        j2 = 256;
                    }
                    j = j3 | j2;
                }
                i7 = z ? 8 : 0;
                int i11 = z ? 0 : 8;
                boolean isEmpty = TextUtils.isEmpty(str15);
                if ((j & 9) != 0) {
                    j |= isEmpty ? 128 : 64;
                }
                UserInfo userInfo = collection != null ? collection.getUserInfo() : null;
                if (isEmpty) {
                    i9 = 8;
                }
                str18 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
                i8 = i9;
                i9 = i11;
                str19 = str20;
            } else {
                str19 = null;
                str18 = null;
                str17 = null;
                str16 = null;
                str15 = null;
                str14 = null;
                str13 = null;
                i8 = 0;
                i7 = 0;
            }
            if (collectionViewModel != null) {
                str5 = str19;
                str3 = str15;
                str2 = str14;
                str = str13;
                str4 = collectionViewModel.collectionUserAvatar();
                i3 = i9;
                str7 = str17;
                str8 = str16;
            } else {
                str5 = str19;
                str8 = str16;
                str3 = str15;
                str2 = str14;
                str = str13;
                str4 = null;
                i3 = i9;
                str7 = str17;
            }
            i = i7;
            i2 = i8;
            str6 = str18;
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i12 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((11 & j) != 0) {
            str12 = str7;
            str11 = str8;
            str10 = str6;
            Boolean bool = null;
            str9 = str5;
            i6 = i;
            i5 = i2;
            i4 = i3;
            onClickListener = onClickListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str4, null, 2131231162, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        } else {
            str11 = str8;
            str12 = str7;
            onClickListener = onClickListener2;
            str10 = str6;
            i4 = i3;
            i5 = i2;
            str9 = str5;
            i6 = i;
        }
        if ((j & 9) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setVipSignView(this.avatarView, str10, bool2);
            this.mboundView1.setVisibility(i4);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            TextViewBindingAdapter.setText(this.mboundView4, str12);
            TextViewBindingAdapter.setText(this.mboundView6, str9);
            TextViewBindingAdapter.setText(this.mboundView7, str2);
            TextViewBindingAdapter.setText(this.mboundView8, str11);
            TextViewBindingAdapter.setText(this.mboundView9, str3);
            this.mboundView9.setVisibility(i5);
            this.spaceHolder.setVisibility(i6);
        }
        if (i12 != 0) {
            Boolean bool3 = null;
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool3);
        }
    }
}
