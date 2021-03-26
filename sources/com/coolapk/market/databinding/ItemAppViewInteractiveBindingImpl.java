package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.RatingBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.InteractivePeopleViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.InteractivePeopleView;
import java.util.List;

public class ItemAppViewInteractiveBindingImpl extends ItemAppViewInteractiveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final ImageView mboundView12;
    private final ImageView mboundView14;
    private final TextView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363187, 16);
        sparseIntArray.put(2131363186, 17);
        sparseIntArray.put(2131363185, 18);
        sparseIntArray.put(2131363184, 19);
        sparseIntArray.put(2131363183, 20);
        sparseIntArray.put(2131363213, 21);
    }

    public ItemAppViewInteractiveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private ItemAppViewInteractiveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (InteractivePeopleView) objArr[15], (View) objArr[20], (View) objArr[19], (View) objArr[18], (View) objArr[17], (View) objArr[16], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[1], (RatingBar) objArr[2], (TextView) objArr[3], (InteractivePeopleView) objArr[13], (LinearLayout) objArr[21]);
        this.mDirtyFlags = -1;
        this.discoveryOfTheirsView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.mboundView11 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[12];
        this.mboundView12 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[14];
        this.mboundView14 = imageView2;
        imageView2.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
        this.rateNum1.setTag(null);
        this.rateNum2.setTag(null);
        this.rateNum3.setTag(null);
        this.rateNum4.setTag(null);
        this.rateNum5.setTag(null);
        this.ratingAverage.setTag(null);
        this.ratingBarAverage.setTag(null);
        this.ratingCount.setTag(null);
        this.ratingOfTheirsView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096;
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
        if (308 != i) {
            return false;
        }
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewInteractiveBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(0, appViewViewModel);
        this.mViewModel = appViewViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 233) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 234) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 309) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 320) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 319) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 318) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 317) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 316) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 202) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 242) {
            synchronized (this) {
                this.mDirtyFlags |= 1024;
            }
            return true;
        } else if (i != 315) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0120  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        float f;
        List<RelatedData> list;
        long j2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        int i2;
        int i3;
        int i4;
        List<RelatedData> list2;
        String str7;
        String str8;
        int i5;
        int i6;
        List<RelatedData> list3;
        int i7;
        List<RelatedData> list4;
        String score;
        String voteNumString;
        int i8;
        long j3;
        int i9;
        ServiceApp serviceApp;
        int i10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        int i11 = 0;
        if ((8191 & j) != 0) {
            int i12 = 8;
            if ((j & 7169) != 0) {
                if (appViewViewModel != null) {
                    serviceApp = appViewViewModel.getServiceApp();
                    i9 = appViewViewModel.getVotenum();
                } else {
                    serviceApp = null;
                    i9 = 0;
                }
                int i13 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
                if (i13 != 0) {
                    list3 = serviceApp != null ? serviceApp.getDiscoveryRows() : null;
                    boolean isEmpty = CollectionUtils.isEmpty(list3);
                    if (i13 != 0) {
                        j |= isEmpty ? 16384 : 8192;
                    }
                    if (isEmpty) {
                        i6 = 8;
                        list4 = serviceApp == null ? serviceApp.getRatingRows() : null;
                        i7 = i9 - 1;
                        i10 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
                        if (i10 != 0) {
                            boolean isEmpty2 = CollectionUtils.isEmpty(list4);
                            if (i10 != 0) {
                                j |= isEmpty2 ? 262144 : 131072;
                            }
                            if (isEmpty2) {
                                i5 = 8;
                                score = ((j & 4099) != 0 || appViewViewModel == null) ? null : appViewViewModel.getScore();
                                voteNumString = ((j & 4105) != 0 || appViewViewModel == null) ? null : appViewViewModel.getVoteNumString();
                                if ((j & 4113) == 0) {
                                    str6 = "" + (appViewViewModel != null ? appViewViewModel.getVotenum5() : 0);
                                } else {
                                    str6 = null;
                                }
                                if ((j & 4161) == 0) {
                                    str5 = "" + (appViewViewModel != null ? appViewViewModel.getVotenum3() : 0);
                                } else {
                                    str5 = null;
                                }
                                if ((j & 4353) == 0) {
                                    str3 = "" + (appViewViewModel != null ? appViewViewModel.getVotenum1() : 0);
                                } else {
                                    str3 = null;
                                }
                                i8 = ((j & 4609) > 0 ? 1 : ((j & 4609) == 0 ? 0 : -1));
                                if (i8 == 0) {
                                    int myScore = appViewViewModel != null ? appViewViewModel.getMyScore() : 0;
                                    boolean z = myScore != 0;
                                    boolean z2 = myScore == 0;
                                    str8 = this.mboundView9.getResources().getString(2131887169, Integer.valueOf(myScore));
                                    if (i8 != 0) {
                                        j |= z ? 65536 : 32768;
                                    }
                                    if ((j & 4609) != 0) {
                                        j |= z2 ? 1048576 : 524288;
                                    }
                                    i = z ? 0 : 8;
                                    if (z2) {
                                        i12 = 0;
                                    }
                                    j3 = 4129;
                                } else {
                                    str8 = null;
                                    i = 0;
                                    j3 = 4129;
                                    i12 = 0;
                                }
                                if ((j & j3) == 0) {
                                    str4 = "" + (appViewViewModel != null ? appViewViewModel.getVotenum4() : 0);
                                } else {
                                    str4 = null;
                                }
                                if ((j & 4225) == 0) {
                                    str7 = "" + (appViewViewModel != null ? appViewViewModel.getVotenum2() : 0);
                                } else {
                                    str7 = null;
                                }
                                j2 = 0;
                                if ((j & 4101) != 0 || appViewViewModel == null) {
                                    list = list4;
                                    i11 = i7;
                                    i3 = i12;
                                    list2 = list3;
                                    i4 = i6;
                                    i2 = i5;
                                    str2 = score;
                                    str = voteNumString;
                                } else {
                                    float scoreNum = appViewViewModel.getScoreNum();
                                    list = list4;
                                    i11 = i7;
                                    i3 = i12;
                                    i4 = i6;
                                    i2 = i5;
                                    str2 = score;
                                    str = voteNumString;
                                    f = scoreNum;
                                    list2 = list3;
                                    if ((j & 5121) != j2) {
                                        this.discoveryOfTheirsView.setVisibility(i4);
                                        InteractivePeopleViewBindingAdapters.setAvatarList(this.discoveryOfTheirsView, list2, null);
                                        this.mboundView12.setVisibility(i2);
                                        this.mboundView14.setVisibility(i4);
                                        this.ratingOfTheirsView.setVisibility(i2);
                                    }
                                    if ((4096 & j) != 0) {
                                        InteractivePeopleViewBindingAdapters.setTitle(this.discoveryOfTheirsView, this.discoveryOfTheirsView.getResources().getString(2131886739));
                                        TextViewBindingAdapter.setText(this.mboundView10, this.mboundView10.getResources().getString(2131886654) + " ");
                                        ThemeBindingAdapters.setTextColor(this.mboundView10, "colorAccent");
                                        TextViewBindingAdapter.setText(this.mboundView11, this.mboundView11.getResources().getString(2131886655) + " ");
                                        ThemeBindingAdapters.setTextColor(this.mboundView11, "colorAccent");
                                        InteractivePeopleViewBindingAdapters.setTitle(this.ratingOfTheirsView, this.ratingOfTheirsView.getResources().getString(2131886944));
                                    }
                                    if ((j & 4609) != 0) {
                                        this.mboundView10.setVisibility(i);
                                        this.mboundView11.setVisibility(i3);
                                        TextViewBindingAdapter.setText(this.mboundView9, str8);
                                        this.mboundView9.setVisibility(i);
                                    }
                                    if ((j & 4353) != 0) {
                                        TextViewBindingAdapter.setText(this.rateNum1, str3);
                                    }
                                    if ((4225 & j) != 0) {
                                        TextViewBindingAdapter.setText(this.rateNum2, str7);
                                    }
                                    if ((4161 & j) != 0) {
                                        TextViewBindingAdapter.setText(this.rateNum3, str5);
                                    }
                                    if ((4129 & j) != 0) {
                                        TextViewBindingAdapter.setText(this.rateNum4, str4);
                                    }
                                    if ((j & 4113) != 0) {
                                        TextViewBindingAdapter.setText(this.rateNum5, str6);
                                    }
                                    if ((j & 4099) != 0) {
                                        TextViewBindingAdapter.setText(this.ratingAverage, str2);
                                    }
                                    if ((4101 & j) != 0) {
                                        RatingBarBindingAdapter.setRating(this.ratingBarAverage, f);
                                    }
                                    if ((j & 4105) != 0) {
                                        TextViewBindingAdapter.setText(this.ratingCount, str);
                                    }
                                    if ((j & 7169) == 0) {
                                        InteractivePeopleViewBindingAdapters.setAvatarList(this.ratingOfTheirsView, list, Integer.valueOf(i11));
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    list3 = null;
                }
                i6 = 0;
                if (serviceApp == null) {
                }
                i7 = i9 - 1;
                i10 = ((j & 5121) > 0 ? 1 : ((j & 5121) == 0 ? 0 : -1));
                if (i10 != 0) {
                }
            } else {
                list4 = null;
                list3 = null;
                i7 = 0;
                i6 = 0;
            }
            i5 = 0;
            if ((j & 4099) != 0) {
            }
            if ((j & 4105) != 0) {
            }
            if ((j & 4113) == 0) {
            }
            if ((j & 4161) == 0) {
            }
            if ((j & 4353) == 0) {
            }
            i8 = ((j & 4609) > 0 ? 1 : ((j & 4609) == 0 ? 0 : -1));
            if (i8 == 0) {
            }
            if ((j & j3) == 0) {
            }
            if ((j & 4225) == 0) {
            }
            j2 = 0;
            if ((j & 4101) != 0) {
            }
            list = list4;
            i11 = i7;
            i3 = i12;
            list2 = list3;
            i4 = i6;
            i2 = i5;
            str2 = score;
            str = voteNumString;
        } else {
            j2 = 0;
            str8 = null;
            str7 = null;
            list2 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            list = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        f = 0.0f;
        if ((j & 5121) != j2) {
        }
        if ((4096 & j) != 0) {
        }
        if ((j & 4609) != 0) {
        }
        if ((j & 4353) != 0) {
        }
        if ((4225 & j) != 0) {
        }
        if ((4161 & j) != 0) {
        }
        if ((4129 & j) != 0) {
        }
        if ((j & 4113) != 0) {
        }
        if ((j & 4099) != 0) {
        }
        if ((4101 & j) != 0) {
        }
        if ((j & 4105) != 0) {
        }
        if ((j & 7169) == 0) {
        }
    }
}
