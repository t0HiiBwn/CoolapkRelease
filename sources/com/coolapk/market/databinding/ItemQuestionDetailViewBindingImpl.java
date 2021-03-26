package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
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
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import java.util.List;

public class ItemQuestionDetailViewBindingImpl extends ItemQuestionDetailViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ItemFeedTargetViewBinding mboundView0;
    private final LinearLayout mboundView01;
    private final View mboundView1;
    private final ImageView mboundView14;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(23);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_feed_target_view"}, new int[]{15}, new int[]{2131558739});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363557, 16);
        sparseIntArray.put(2131363551, 17);
        sparseIntArray.put(2131363030, 18);
        sparseIntArray.put(2131363243, 19);
        sparseIntArray.put(2131362588, 20);
        sparseIntArray.put(2131362153, 21);
        sparseIntArray.put(2131362336, 22);
    }

    public ItemQuestionDetailViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private ItemQuestionDetailViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[21], (LinearLayout) objArr[2], (TextView) objArr[22], (TextView) objArr[20], (TextView) objArr[11], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (TextView) objArr[6], (Space) objArr[18], (TextView) objArr[13], (LinearLayout) objArr[12], (Space) objArr[19], (TextView) objArr[17], (FrameLayout) objArr[16], (TextView) objArr[5], (TextView) objArr[3], (UserAvatarView) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.followView.setTag(null);
        this.imageView1.setTag(null);
        this.imageView2.setTag(null);
        this.imageView3.setTag(null);
        ItemFeedTargetViewBinding itemFeedTargetViewBinding = (ItemFeedTargetViewBinding) objArr[15];
        this.mboundView0 = itemFeedTargetViewBinding;
        setContainedBinding(itemFeedTargetViewBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView01 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
        ImageView imageView = (ImageView) objArr[14];
        this.mboundView14 = imageView;
        imageView.setTag(null);
        this.moreFollowerView.setTag(null);
        this.nameView.setTag(null);
        this.orderText.setTag(null);
        this.orderView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
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
        if (198 == i) {
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemQuestionDetailViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemQuestionDetailViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015d  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        String str3;
        String str4;
        int i4;
        int i5;
        List<RelatedData> list;
        String str5;
        String str6;
        String str7;
        int i6;
        String str8;
        String str9;
        String str10;
        List<RelatedData> list2;
        String str11;
        String str12;
        UserInfo userInfo;
        FeedTarget feedTarget;
        int i7;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i8 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (feed != null) {
                feedTarget = feed.getTargetRow();
                str4 = feed.getMessageTitle();
                userInfo = feed.getUserInfo();
                str12 = feed.getUserName();
                str11 = feed.getUserAvatar();
                list2 = feed.getUserFollowList();
            } else {
                feedTarget = null;
                str4 = null;
                userInfo = null;
                str12 = null;
                str11 = null;
                list2 = null;
            }
            boolean z4 = feedTarget == null;
            if (i8 != 0) {
                j |= z4 ? 65536 : 32768;
            }
            String verifyStatusIcon = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            if (list2 != null) {
                i7 = list2.size();
            } else {
                i7 = 0;
            }
            int i9 = 8;
            i4 = z4 ? 8 : 0;
            z3 = i7 > 0;
            z2 = i7 > 1;
            z = i7 > 2;
            boolean z5 = i7 > 3;
            if ((j & 5) != 0) {
                if (z3) {
                    j7 = j | 16;
                    j6 = 262144;
                } else {
                    j7 = j | 8;
                    j6 = 131072;
                }
                j = j7 | j6;
            }
            if ((j & 5) != 0) {
                if (z2) {
                    j5 = j | 64;
                    j4 = 16384;
                } else {
                    j5 = j | 32;
                    j4 = 8192;
                }
                j = j5 | j4;
            }
            if ((j & 5) != 0) {
                if (z) {
                    j3 = j | 256;
                    j2 = 4096;
                } else {
                    j3 = j | 128;
                    j2 = 2048;
                }
                j = j3 | j2;
            }
            if ((j & 5) != 0) {
                j |= z5 ? 1024 : 512;
            }
            i3 = z3 ? 0 : 8;
            int i10 = z2 ? 0 : 8;
            int i11 = z ? 0 : 8;
            if (z5) {
                i9 = 0;
            }
            str3 = verifyStatusIcon;
            str2 = str12;
            str = str11;
            list = list2;
            i5 = i9;
            i2 = i10;
            i = i11;
        } else {
            list = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            z3 = false;
            z2 = false;
            z = false;
            i2 = 0;
            i = 0;
        }
        int i12 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 256) != 0) {
            RelatedData relatedData = list != null ? list.get(2) : null;
            if (relatedData != null) {
                str5 = relatedData.getUserAvatar();
                if ((j & 64) != 0) {
                    RelatedData relatedData2 = list != null ? list.get(1) : null;
                    if (relatedData2 != null) {
                        str6 = relatedData2.getUserAvatar();
                        if ((16 & j) != 0) {
                            RelatedData relatedData3 = list != null ? list.get(0) : null;
                            if (relatedData3 != null) {
                                str7 = relatedData3.getUserAvatar();
                                i6 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
                                if (i6 == 0) {
                                    if (!z3) {
                                        str7 = null;
                                    }
                                    if (!z2) {
                                        str6 = null;
                                    }
                                    if (!z) {
                                        str5 = null;
                                    }
                                    str10 = str6;
                                    str9 = str7;
                                    str8 = str5;
                                } else {
                                    str10 = null;
                                    str9 = null;
                                    str8 = null;
                                }
                                if (i12 != 0) {
                                    Boolean bool = null;
                                    ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.followView, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.imageView1, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.imageView2, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.imageView3, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.moreFollowerView, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.orderView, onClickListener, bool);
                                    ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
                                }
                                if ((j & 4) != 0) {
                                    ThemeBindingAdapters.setBackgroundColor(this.followView, "colorAccent");
                                    ViewBindingAdapters.clipView(this.followView, null, 14);
                                    Number number = null;
                                    ViewBindingAdapters.clipView(this.imageView1, "oval", number);
                                    ViewBindingAdapters.clipView(this.imageView2, "oval", number);
                                    ViewBindingAdapters.clipView(this.imageView3, "oval", number);
                                    ThemeBindingAdapters.setTintColor(this.mboundView14, "colorAccent");
                                    ViewBindingAdapters.clipView(this.moreFollowerView, "oval", number);
                                    ThemeBindingAdapters.setTextColor(this.orderText, "colorAccent");
                                }
                                if (i6 != 0) {
                                    this.imageView1.setVisibility(i3);
                                    Drawable drawable = null;
                                    Boolean bool2 = null;
                                    String str13 = null;
                                    OnImageLoadListener onImageLoadListener = null;
                                    OnBitmapTransformListener onBitmapTransformListener = null;
                                    View.OnClickListener onClickListener2 = null;
                                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView1, str9, drawable, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str13, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
                                    this.imageView2.setVisibility(i2);
                                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView2, str10, drawable, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str13, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
                                    this.imageView3.setVisibility(i);
                                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView3, str8, drawable, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str13, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
                                    this.mboundView0.setModel(feed);
                                    this.mboundView1.setVisibility(i4);
                                    this.moreFollowerView.setVisibility(i5);
                                    TextViewBindingAdapter.setText(this.nameView, str2);
                                    TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
                                    TextViewBindingAdapter.setText(this.titleView, str4);
                                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, drawable, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str13, onImageLoadListener, onBitmapTransformListener, bool2, bool2, bool2, onClickListener2, bool2);
                                    ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
                                }
                                executeBindingsOn(this.mboundView0);
                            }
                        }
                        str7 = null;
                        i6 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
                        if (i6 == 0) {
                        }
                        if (i12 != 0) {
                        }
                        if ((j & 4) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        executeBindingsOn(this.mboundView0);
                    }
                }
                str6 = null;
                if ((16 & j) != 0) {
                }
                str7 = null;
                i6 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
                if (i6 == 0) {
                }
                if (i12 != 0) {
                }
                if ((j & 4) != 0) {
                }
                if (i6 != 0) {
                }
                executeBindingsOn(this.mboundView0);
            }
        }
        str5 = null;
        if ((j & 64) != 0) {
        }
        str6 = null;
        if ((16 & j) != 0) {
        }
        str7 = null;
        i6 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i6 == 0) {
        }
        if (i12 != 0) {
        }
        if ((j & 4) != 0) {
        }
        if (i6 != 0) {
        }
        executeBindingsOn(this.mboundView0);
    }
}
