package com.coolapk.market.view.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.widget.AdapterListChangedCallback;
import java.util.Arrays;
import java.util.Iterator;

public class AppViewViewModel extends BaseObservable {
    private static final float MIN_PERCENT = 0.01f;
    private String appName;
    private final Context context;
    private ObservableArrayList<ImageSize> imageSizeList = new ObservableArrayList<>();
    private boolean isFavor;
    private boolean isFollow;
    private boolean isFollowDeveloper;
    private boolean isShowChangeLogAll;
    private boolean isShrinkChangeLog;
    private String logo;
    private Integer maxWords = 60;
    private int myScore;
    private String myScoreText;
    private final AppViewContract.Presenter presenter;
    private String score = "0";
    private String[] urlMd5s;
    private int voteNum;
    private int voteNum1;
    private int voteNum2;
    private int voteNum3;
    private int voteNum4;
    private int voteNum5;
    private int voteNumMax;

    public AppViewViewModel(Context context2, AppViewContract.Presenter presenter2) {
        this.presenter = presenter2;
        this.context = context2.getApplicationContext();
    }

    private static String[] getUrlMd5s(ServiceApp serviceApp) {
        UpgradeInfo upgradeInfo;
        if (serviceApp == null) {
            return null;
        }
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
        String[] strArr = new String[4];
        strArr[0] = serviceApp.getDownloadUrlMd5(0);
        strArr[1] = serviceApp.getDownloadUrlMd5(2);
        if (!(mobileAppExistFast == null || (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) == null)) {
            strArr[2] = upgradeInfo.getDownloadUrlMd5(0);
            strArr[3] = upgradeInfo.getDownloadUrlMd5(1);
        }
        return strArr;
    }

    private static int getVoteNumMax(int[] iArr) {
        Arrays.sort(iArr);
        return Math.max(0, iArr[iArr.length - 1]);
    }

    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.urlMd5s = bundle.getStringArray("urlMd5s");
            this.voteNumMax = bundle.getInt("voteNumMax");
            this.isShowChangeLogAll = bundle.getBoolean("isShowChangeLogAll");
            this.isShrinkChangeLog = bundle.getBoolean("isShrinkChangeLog");
            this.logo = bundle.getString("logo");
            this.appName = bundle.getString("appName");
            this.myScore = bundle.getInt("myScore");
            this.myScoreText = bundle.getString("myScoreText");
            this.score = bundle.getString("score", "0");
            this.voteNum = bundle.getInt("voteNum");
            this.voteNum1 = bundle.getInt("voteNum1");
            this.voteNum2 = bundle.getInt("voteNum2");
            this.voteNum3 = bundle.getInt("voteNum3");
            this.voteNum4 = bundle.getInt("voteNum4");
            this.voteNum5 = bundle.getInt("voteNum5");
            this.isFollow = bundle.getBoolean("isFollow");
            this.isFavor = bundle.getBoolean("isFavor");
            this.isFollowDeveloper = bundle.getBoolean("isFollowDeveloper");
            Integer valueOf = Integer.valueOf(bundle.getInt("maxWords", -1));
            this.maxWords = valueOf;
            if (valueOf.intValue() == -1) {
                this.maxWords = null;
            }
            this.imageSizeList.addAll(bundle.getParcelableArrayList("imageSizeList"));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArray("urlMd5s", this.urlMd5s);
        bundle.putInt("voteNumMax", this.voteNumMax);
        bundle.putBoolean("isShowChangeLogAll", this.isShowChangeLogAll);
        bundle.putBoolean("isShrinkChangeLog", this.isShrinkChangeLog);
        bundle.putString("logo", this.logo);
        bundle.putString("appName", this.appName);
        bundle.putInt("myScore", this.myScore);
        bundle.putString("myScoreText", this.myScoreText);
        bundle.putString("score", this.score);
        bundle.putInt("voteNum", this.voteNum);
        bundle.putInt("voteNum1", this.voteNum1);
        bundle.putInt("voteNum2", this.voteNum2);
        bundle.putInt("voteNum3", this.voteNum3);
        bundle.putInt("voteNum4", this.voteNum4);
        bundle.putInt("voteNum5", this.voteNum5);
        bundle.putBoolean("isFollow", this.isFollow);
        bundle.putBoolean("isFavor", this.isFavor);
        bundle.putBoolean("isFollowDeveloper", this.isFollowDeveloper);
        Integer num = this.maxWords;
        bundle.putInt("maxWords", num != null ? num.intValue() : -1);
        bundle.putParcelableArrayList("imageSizeList", this.imageSizeList);
    }

    @Bindable
    public String getUpdateTime() {
        if (getServiceApp() != null) {
            return DateUtils.getTimeDescription(this.context, getServiceApp().getLastUpdate());
        }
        return null;
    }

    @Bindable
    public ServiceApp getServiceApp() {
        return this.presenter.getServiceApp();
    }

    @Bindable
    public boolean isLoading() {
        return this.presenter.isLoadingApp();
    }

    @Bindable
    public String getFollowCount() {
        return getServiceApp() != null ? this.context.getString(2131886878, getServiceApp().getFollowCount()) : "";
    }

    @Bindable
    public String getCommentCount() {
        return getServiceApp() != null ? this.context.getString(2131886737, getServiceApp().getCommentCount()) : "";
    }

    @Bindable
    public String getScore() {
        return this.score;
    }

    public void setScore(String str) {
        this.score = str;
        notifyPropertyChanged(234);
        notifyPropertyChanged(235);
    }

    @Bindable
    public float getScoreNum() {
        return Float.valueOf(this.score).floatValue();
    }

    @Bindable
    public String getLanguage() {
        return (getServiceApp() == null || TextUtils.isEmpty(getServiceApp().getLanguage())) ? "" : getServiceApp().getLanguage().substring(0, 1);
    }

    @Bindable
    public long getCurrentLength() {
        DownloadState findDownloadState = findDownloadState();
        if (findDownloadState != null) {
            return findDownloadState.getCurrentLength();
        }
        return 0;
    }

    @Bindable
    public long getTotalLength() {
        DownloadState findDownloadState = findDownloadState();
        if (findDownloadState != null) {
            return findDownloadState.getTotalLength();
        }
        return 0;
    }

    @Bindable
    public String getActionButtonBackground() {
        return StateUtils.getActionButtonBackground(findDownloadState());
    }

    @Bindable
    public int getActionButtonTextColor() {
        return StateUtils.getActionButtonTextColor(findDownloadState());
    }

    @Bindable
    public String getActionText() {
        if (getServiceApp() == null) {
            return null;
        }
        return StateUtils.getActionText(this.context, getServiceApp().getPackageName(), getServiceApp().getPackageName(), this.urlMd5s);
    }

    @Bindable
    public String getActionTextUseProcess() {
        if (getServiceApp() == null) {
            return null;
        }
        return StateUtils.getActionText(this.context, true, getServiceApp().getPackageName(), getServiceApp().getPackageName(), this.urlMd5s);
    }

    @Bindable
    public String getDownloadCount() {
        return getServiceApp() != null ? this.context.getString(2131886819, getServiceApp().getDownCount()) : "";
    }

    @Bindable
    public String getSize() {
        return getServiceApp() != null ? getServiceApp().getApkSizeFormat() : "";
    }

    @Bindable
    public Gift getFirstGift() {
        if (getServiceApp() == null || CollectionUtils.isEmpty(getServiceApp().getGiftRows())) {
            return null;
        }
        return getServiceApp().getGiftRows().get(0);
    }

    @Bindable
    public Gift getSecondGift() {
        if (getServiceApp() == null || CollectionUtils.isEmpty(getServiceApp().getGiftRows()) || getServiceApp().getGiftRows().size() <= 1) {
            return null;
        }
        return getServiceApp().getGiftRows().get(1);
    }

    @Bindable
    public int getGiftCount() {
        if (getServiceApp() != null) {
            return getServiceApp().getGiftCount();
        }
        return 0;
    }

    @Bindable
    public String getVoteNumString() {
        return this.context.getString(2131887001, Integer.valueOf(this.voteNum));
    }

    @Bindable
    public int getVotenum() {
        return this.voteNum;
    }

    @Bindable
    public int getVotenum1() {
        return this.voteNum1;
    }

    @Bindable
    public int getVotenum2() {
        return this.voteNum2;
    }

    @Bindable
    public int getVotenum3() {
        return this.voteNum3;
    }

    @Bindable
    public int getVotenum4() {
        return this.voteNum4;
    }

    @Bindable
    public int getVotenum5() {
        return this.voteNum5;
    }

    public void setVoteNums(int i, int[] iArr) {
        this.voteNum = i;
        int i2 = iArr[0];
        this.voteNum1 = i2;
        int i3 = iArr[1];
        this.voteNum2 = i3;
        int i4 = iArr[2];
        this.voteNum3 = i4;
        int i5 = iArr[3];
        this.voteNum4 = i5;
        int i6 = iArr[4];
        this.voteNum5 = i6;
        this.voteNumMax = getVoteNumMax(new int[]{i2, i3, i4, i5, i6});
        notifyPropertyChanged(310);
        notifyPropertyChanged(316);
        notifyPropertyChanged(317);
        notifyPropertyChanged(318);
        notifyPropertyChanged(319);
        notifyPropertyChanged(320);
        notifyPropertyChanged(321);
        notifyPropertyChanged(311);
        notifyPropertyChanged(312);
        notifyPropertyChanged(313);
        notifyPropertyChanged(314);
        notifyPropertyChanged(315);
    }

    @Bindable
    public float getVotePercent1() {
        return Math.max(0.01f, (((float) getVotenum1()) * 1.0f) / ((float) getVoteNumMax()));
    }

    @Bindable
    public float getVotePercent2() {
        return Math.max(0.01f, (((float) getVotenum2()) * 1.0f) / ((float) getVoteNumMax()));
    }

    @Bindable
    public float getVotePercent3() {
        return Math.max(0.01f, (((float) getVotenum3()) * 1.0f) / ((float) getVoteNumMax()));
    }

    @Bindable
    public float getVotePercent4() {
        return Math.max(0.01f, (((float) getVotenum4()) * 1.0f) / ((float) getVoteNumMax()));
    }

    @Bindable
    public float getVotePercent5() {
        return Math.max(0.01f, (((float) getVotenum5()) * 1.0f) / ((float) getVoteNumMax()));
    }

    public int getVoteWidth1() {
        return (int) (getVotePercent1() * ((float) DisplayUtils.dp2px(this.context, 120.0f)));
    }

    public int getVoteWidth2() {
        return (int) (getVotePercent2() * ((float) DisplayUtils.dp2px(this.context, 120.0f)));
    }

    public int getVoteWidth3() {
        return (int) (getVotePercent3() * ((float) DisplayUtils.dp2px(this.context, 120.0f)));
    }

    public int getVoteWidth4() {
        return (int) (getVotePercent4() * ((float) DisplayUtils.dp2px(this.context, 120.0f)));
    }

    public int getVoteWidth5() {
        return (int) (getVotePercent5() * ((float) DisplayUtils.dp2px(this.context, 120.0f)));
    }

    public int getVoteNumMax() {
        return this.voteNumMax;
    }

    @Bindable
    public int getMyScore() {
        return this.myScore;
    }

    @Bindable
    public String getMyScoreText() {
        if (!TextUtils.isEmpty(this.myScoreText)) {
            return this.myScoreText;
        }
        return getMyScore() + " 分";
    }

    public void setMyScoreText(String str) {
        this.myScoreText = str;
        notifyPropertyChanged(204);
    }

    public void setMyScore(int i) {
        this.myScore = i;
        notifyPropertyChanged(203);
        notifyPropertyChanged(204);
    }

    @Bindable
    public String getIntroduce() {
        if (getServiceApp() != null) {
            return getServiceApp().getIntroduce();
        }
        return null;
    }

    @Bindable
    public Integer getIntroduceMaxWords() {
        return this.maxWords;
    }

    public void setIntroduceMaxWords(Integer num) {
        this.maxWords = num;
        notifyPropertyChanged(163);
    }

    @Bindable
    public boolean isShowChangeLogAll() {
        return this.isShowChangeLogAll;
    }

    public void setShowChangeLogAll(boolean z) {
        this.isShowChangeLogAll = z;
        notifyPropertyChanged(246);
        notifyPropertyChanged(263);
    }

    @Bindable
    public boolean isShrinkChangeLog() {
        return this.isShrinkChangeLog && !this.isShowChangeLogAll;
    }

    public void setShrinkChangeLog(boolean z) {
        this.isShrinkChangeLog = z;
        notifyPropertyChanged(263);
    }

    @Bindable
    public String getLogo() {
        if (!TextUtils.isEmpty(this.logo)) {
            return this.logo;
        }
        if (getServiceApp() != null) {
            return getServiceApp().getLogo();
        }
        return null;
    }

    public void setLogo(String str) {
        this.logo = str;
        notifyPropertyChanged(190);
    }

    @Bindable
    public String getAppName() {
        if (!TextUtils.isEmpty(this.appName)) {
            return this.appName;
        }
        if (getServiceApp() != null) {
            return getServiceApp().getAppName();
        }
        return null;
    }

    public void setAppName(String str) {
        this.appName = str;
        notifyPropertyChanged(30);
    }

    @Bindable
    public boolean isNeedXposedFramework() {
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast("de.robv.android.xposed.installer");
        return (mobileAppExistFast == null || !mobileAppExistFast.isExist()) && getServiceApp() != null && getServiceApp().isXposedPlugin();
    }

    @Bindable
    public boolean isHasGift() {
        if (getServiceApp() == null || getServiceApp().getGiftCount() <= 0 || CollectionUtils.isEmpty(getServiceApp().getGiftRows())) {
            return false;
        }
        return true;
    }

    public void addThumbnailCallback(RecyclerView.Adapter adapter) {
        this.imageSizeList.addOnListChangedCallback(new AdapterListChangedCallback(adapter));
    }

    public void setThumbnailSize(String str, int i, int i2) {
        for (int i3 = 0; i3 < this.imageSizeList.size(); i3++) {
            if (TextUtils.equals(str, ((ImageSize) this.imageSizeList.get(i3)).url)) {
                this.imageSizeList.set(i3, new ImageSize(str, i, i2));
                return;
            }
        }
        if (!(getServiceApp() == null || CollectionUtils.isEmpty(getServiceApp().getThumbList()))) {
            for (int i4 = 0; i4 < getServiceApp().getThumbList().size(); i4++) {
                if (TextUtils.equals(getServiceApp().getThumbList().get(i4), str)) {
                    int size = this.imageSizeList.size();
                    if (size == 0) {
                        this.imageSizeList.add(size, new ImageSize(str, i, i2));
                        return;
                    }
                    int indexOf = getServiceApp().getThumbList().indexOf(((ImageSize) this.imageSizeList.get(size - 1)).url);
                    while (indexOf > i4) {
                        size--;
                        if (size == 0) {
                            break;
                        }
                        indexOf = getServiceApp().getThumbList().indexOf(((ImageSize) this.imageSizeList.get(size - 1)).url);
                    }
                    this.imageSizeList.add(size, new ImageSize(str, i, i2));
                    return;
                }
            }
        }
    }

    public ImageSize getThumbnailSize(String str) {
        Iterator<E> it2 = this.imageSizeList.iterator();
        while (it2.hasNext()) {
            E next = it2.next();
            if (TextUtils.equals(next.url, str)) {
                return next;
            }
        }
        return null;
    }

    public ImageSize getThumbnailSize(int i) {
        return (ImageSize) this.imageSizeList.get(i);
    }

    public int getThumbnailCount() {
        return this.imageSizeList.size();
    }

    @Bindable
    public boolean isFollow() {
        return this.isFollow;
    }

    @Bindable
    public boolean isFavor() {
        return this.isFavor;
    }

    public void setFavor(boolean z) {
        this.isFavor = z;
        notifyPropertyChanged(103);
    }

    @Bindable
    public boolean isFollowDeveloper() {
        return this.isFollowDeveloper;
    }

    public void setFollowDeveloper(boolean z) {
        this.isFollowDeveloper = z;
        notifyPropertyChanged(118);
    }

    @Bindable
    public String getDeveloperName() {
        if (getServiceApp() == null || getServiceApp().getDeveloperProfile() == null) {
            return null;
        }
        if ("3".equals(getServiceApp().getDeveloperProfile().getType())) {
            return this.context.getString(2131886764, getServiceApp().getDeveloperProfile().getTitle());
        }
        return this.context.getString(2131886764, getServiceApp().getDeveloperProfile().getUserName());
    }

    @Bindable
    public String getDeveloperTitle() {
        if (getServiceApp() == null || getServiceApp().getDeveloperProfile() == null) {
            return null;
        }
        if (TextUtils.isEmpty(getServiceApp().getDeveloperProfile().getTitle())) {
            return this.context.getString(2131886765, "开发者");
        }
        if ("3".equals(getServiceApp().getDeveloperProfile().getType())) {
            return "企业认证: " + getServiceApp().getDeveloperProfile().getTitle();
        }
        return "个人认证: " + getServiceApp().getDeveloperProfile().getTitle();
    }

    @Bindable
    public String getDeveloperAvatar() {
        if (getServiceApp() == null || getServiceApp().getDeveloperProfile() == null) {
            return null;
        }
        return getServiceApp().getDeveloperProfile().getUserAvatar();
    }

    public void setFollowApp(boolean z) {
        this.isFollow = z;
        notifyPropertyChanged(116);
    }

    public void updateAction() {
        notifyPropertyChanged(1);
        notifyPropertyChanged(2);
        notifyPropertyChanged(3);
        notifyPropertyChanged(62);
        notifyPropertyChanged(286);
        notifyPropertyChanged(5);
    }

    public void updateServiceApp() {
        this.urlMd5s = null;
        boolean z = false;
        this.voteNumMax = 0;
        this.score = null;
        this.myScore = 0;
        this.voteNum = 0;
        this.voteNum1 = 0;
        this.voteNum2 = 0;
        this.voteNum3 = 0;
        this.voteNum4 = 0;
        this.voteNum5 = 0;
        this.isFavor = false;
        this.isFollow = false;
        this.isFollowDeveloper = false;
        if (getServiceApp() != null) {
            this.urlMd5s = getUrlMd5s(getServiceApp());
            this.score = getServiceApp().getScore();
            if (getServiceApp().getUserAction() != null) {
                this.myScore = getServiceApp().getUserAction().getRating();
            }
            this.voteNum = getServiceApp().getVotenum();
            this.voteNum1 = getServiceApp().getVotenum1();
            this.voteNum2 = getServiceApp().getVotenum2();
            this.voteNum3 = getServiceApp().getVotenum3();
            this.voteNum4 = getServiceApp().getVotenum4();
            int votenum5 = getServiceApp().getVotenum5();
            this.voteNum5 = votenum5;
            this.voteNumMax = getVoteNumMax(new int[]{this.voteNum1, this.voteNum2, this.voteNum3, this.voteNum4, votenum5});
            this.isFavor = getServiceApp().getUserAction().getCollect() > 0;
            this.isFollow = getServiceApp().getUserAction().getFollow() > 0;
            if (getServiceApp().getDeveloperProfile() != null) {
                if (getServiceApp().getDeveloperProfile().getIsFollow() == 1) {
                    z = true;
                }
                this.isFollowDeveloper = z;
            }
            this.logo = getServiceApp().getLogo();
        }
        notifyPropertyChanged(243);
        notifyPropertyChanged(291);
        notifyPropertyChanged(187);
        notifyPropertyChanged(1);
        notifyPropertyChanged(2);
        notifyPropertyChanged(3);
        notifyPropertyChanged(62);
        notifyPropertyChanged(286);
        notifyPropertyChanged(75);
        notifyPropertyChanged(265);
        notifyPropertyChanged(117);
        notifyPropertyChanged(52);
        notifyPropertyChanged(234);
        notifyPropertyChanged(235);
        notifyPropertyChanged(179);
        notifyPropertyChanged(114);
        notifyPropertyChanged(237);
        notifyPropertyChanged(310);
        notifyPropertyChanged(316);
        notifyPropertyChanged(317);
        notifyPropertyChanged(318);
        notifyPropertyChanged(319);
        notifyPropertyChanged(320);
        notifyPropertyChanged(321);
        notifyPropertyChanged(311);
        notifyPropertyChanged(312);
        notifyPropertyChanged(313);
        notifyPropertyChanged(314);
        notifyPropertyChanged(315);
        notifyPropertyChanged(203);
        notifyPropertyChanged(204);
        notifyPropertyChanged(162);
        notifyPropertyChanged(163);
        notifyPropertyChanged(246);
        notifyPropertyChanged(263);
        notifyPropertyChanged(190);
        notifyPropertyChanged(30);
        notifyPropertyChanged(206);
        notifyPropertyChanged(145);
        notifyPropertyChanged(116);
        notifyPropertyChanged(103);
        notifyPropertyChanged(118);
        notifyPropertyChanged(71);
        notifyPropertyChanged(68);
        notifyPropertyChanged(70);
        notifyPropertyChanged(132);
        notifyPropertyChanged(5);
    }

    private DownloadState findDownloadState() {
        String[] strArr = this.urlMd5s;
        if (strArr != null) {
            return StateUtils.findLatestDownloadState(strArr);
        }
        return null;
    }

    public static class ImageSize implements Parcelable {
        public static final Parcelable.Creator<ImageSize> CREATOR = new Parcelable.Creator<ImageSize>() {
            /* class com.coolapk.market.view.app.AppViewViewModel.ImageSize.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public ImageSize createFromParcel(Parcel parcel) {
                return new ImageSize(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ImageSize[] newArray(int i) {
                return new ImageSize[i];
            }
        };
        public int height;
        public long id;
        public String url;
        public int width;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ImageSize(String str, int i, int i2) {
            this.url = str;
            this.id = TextUtils.isEmpty(str) ? -1 : (long) this.url.hashCode();
            this.width = i;
            this.height = i2;
        }

        protected ImageSize(Parcel parcel) {
            this.id = parcel.readLong();
            this.url = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }

        @Override // java.lang.Object
        public String toString() {
            return "ImageSize{id=" + this.id + ", url='" + this.url + "', width=" + this.width + ", height=" + this.height + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.id);
            parcel.writeString(this.url);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }
    }
}
