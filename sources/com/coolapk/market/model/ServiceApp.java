package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_ServiceApp;
import com.coolapk.market.model.C$AutoValue_ServiceApp;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class ServiceApp implements Entity {
    public static final int DOWNLOAD_URL_TYPE_APK = 0;
    public static final int DOWNLOAD_URL_TYPE_EXTRA = 2;
    public static final String UPDATE_FLAG_DEV = "Dev";
    public static final String UPDATE_FLAG_GIFT = "有礼包";
    public static final String UPDATE_FLAG_HOT = "Hot";
    public static final String UPDATE_FLAG_NEW = "New";
    public static final String UPDATE_FLAG_UPDATE = "Update";
    private String apkUrlCache;
    private String apkUrlMd5Cache;
    private String extraUrlCache;
    private String extraUrlMd5Cache;

    public static abstract class Builder {
        public abstract ServiceApp build();

        public abstract Builder setAlbumRows(List<Album> list);

        public abstract Builder setApkLength(long j);

        public abstract Builder setApkRomVersion(String str);

        public abstract Builder setApkSize(String str);

        public abstract Builder setApkSubTitle(String str);

        public abstract Builder setApkType(String str);

        public abstract Builder setApkUrl(String str);

        public abstract Builder setAppName(String str);

        public abstract Builder setBgColor(String str);

        public abstract Builder setCategoryId(String str);

        public abstract Builder setCategoryName(String str);

        public abstract Builder setChangeHistory(String str);

        public abstract Builder setChangeLog(String str);

        public abstract Builder setCollectionInfo(Collection collection);

        public abstract Builder setCollectionItem(CollectionItem collectionItem);

        public abstract Builder setCommentBlockNum(int i);

        public abstract Builder setCommentCount(String str);

        public abstract Builder setCommentStatus(int i);

        public abstract Builder setCouponInfo(List<CouponInfo> list);

        public abstract Builder setCover(String str);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setDeveloperName(String str);

        public abstract Builder setDeveloperProfile(User user);

        public abstract Builder setDeveloperRows(List<ServiceApp> list);

        public abstract Builder setDigest(int i);

        public abstract Builder setDiscoveryRows(List<RelatedData> list);

        public abstract Builder setDisplayVersionName(String str);

        public abstract Builder setDownCount(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtendFile(String str);

        public abstract Builder setExtendName(String str);

        public abstract Builder setExtraAnalysisData(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setExtraFlag(String str);

        public abstract Builder setExtraFromApi(String str);

        public abstract Builder setFollowCount(String str);

        public abstract Builder setFollowerRows(List<RelatedData> list);

        public abstract Builder setGiftCount(int i);

        public abstract Builder setGiftRows(List<Gift> list);

        public abstract Builder setHasCoupon(boolean z);

        public abstract Builder setHotNum(int i);

        public abstract Builder setId(String str);

        public abstract Builder setIntroduce(String str);

        public abstract Builder setIsDownloadApp(int i);

        public abstract Builder setIsForumApp(int i);

        public abstract Builder setKeywords(String str);

        public abstract Builder setLanguage(String str);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLoginUserRate(String str);

        public abstract Builder setLogo(String str);

        public abstract Builder setMenuCards(List<MenuCard> list);

        public abstract Builder setOpenLink(String str);

        public abstract Builder setPackageName(String str);

        public abstract Builder setPermissions(List<String> list);

        public abstract Builder setPic(String str);

        public abstract Builder setPublicUpdate(long j);

        public abstract Builder setRatingRows(List<RelatedData> list);

        public abstract Builder setRatingStar(float f);

        public abstract Builder setRecentFollowList(List<User> list);

        public abstract Builder setRecommend(int i);

        public abstract Builder setRecommendRows(List<NewHeadLine> list);

        public abstract Builder setRelatedRows(List<ServiceApp> list);

        public abstract Builder setRemark(String str);

        public abstract Builder setRequestContext(String str);

        public abstract Builder setReviewer(String str);

        public abstract Builder setScore(String str);

        public abstract Builder setScreenList(List<String> list);

        public abstract Builder setSelectedTab(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setSupportAndroidVersion(int i);

        public abstract Builder setTabApiList(List<ConfigPage> list);

        public abstract Builder setTagList(List<String> list);

        public abstract Builder setTargetId(String str);

        public abstract Builder setThumbList(List<String> list);

        public abstract Builder setTitle(String str);

        public abstract Builder setTopIds(List<String> list);

        public abstract Builder setUpDown(int i);

        public abstract Builder setUpdateFlag(String str);

        public abstract Builder setUrl(String str);

        public abstract Builder setUserAction(UserAction userAction);

        public abstract Builder setVersionCode(int i);

        public abstract Builder setVersionName(String str);

        public abstract Builder setVotenum(int i);

        public abstract Builder setVotenum1(int i);

        public abstract Builder setVotenum2(int i);

        public abstract Builder setVotenum3(int i);

        public abstract Builder setVotenum4(int i);

        public abstract Builder setVotenum5(int i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract List<Album> getAlbumRows();

    @SerializedName("apklength")
    public abstract long getApkLength();

    public abstract String getApkRomVersion();

    @SerializedName("apksize")
    public abstract String getApkSize();

    @SerializedName("subtitle")
    public abstract String getApkSubTitle();

    @SerializedName("apktype")
    public abstract String getApkType();

    public abstract String getApkUrl();

    @SerializedName("shorttitle")
    public abstract String getAppName();

    @SerializedName("bgColor")
    public abstract String getBgColor();

    @SerializedName("catid")
    public abstract String getCategoryId();

    @SerializedName("catName")
    public abstract String getCategoryName();

    @SerializedName("changehistory")
    public abstract String getChangeHistory();

    @SerializedName("changelog")
    public abstract String getChangeLog();

    @SerializedName("collection_info")
    public abstract Collection getCollectionInfo();

    @SerializedName("collection_item_info")
    public abstract CollectionItem getCollectionItem();

    @SerializedName("comment_block_num")
    public abstract int getCommentBlockNum();

    public abstract String getCommentCount();

    @SerializedName("comment_status")
    public abstract int getCommentStatus();

    public abstract List<CouponInfo> getCouponInfo();

    public abstract String getCover();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    @SerializedName("developername")
    public abstract String getDeveloperName();

    public abstract User getDeveloperProfile();

    public abstract List<ServiceApp> getDeveloperRows();

    public abstract int getDigest();

    public abstract List<RelatedData> getDiscoveryRows();

    @SerializedName("version")
    public abstract String getDisplayVersionName();

    public abstract String getDownCount();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "apk";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    @SerializedName("extendfile")
    public abstract String getExtendFile();

    @SerializedName("extendname")
    public abstract String getExtendName();

    public abstract String getExtraAnalysisData();

    public abstract String getExtraFlag();

    @SerializedName("extra_fromApi")
    public abstract String getExtraFromApi();

    public abstract String getFollowCount();

    public abstract List<RelatedData> getFollowerRows();

    public abstract int getGiftCount();

    public abstract List<Gift> getGiftRows();

    public abstract boolean getHasCoupon();

    @SerializedName("hot_num")
    public abstract int getHotNum();

    public abstract String getIntroduce();

    @SerializedName("is_download_app")
    public abstract int getIsDownloadApp();

    @SerializedName("is_forum_app")
    public abstract int getIsForumApp();

    public abstract String getKeywords();

    public abstract String getLanguage();

    @SerializedName("star")
    public abstract String getLoginUserRate();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @SerializedName("extendedMenus")
    public abstract List<MenuCard> getMenuCards();

    @SerializedName("open_link")
    public abstract String getOpenLink();

    public abstract String getPackageName();

    public abstract List<String> getPermissions();

    @SerializedName("pubdate")
    public abstract long getPublicUpdate();

    public abstract List<RelatedData> getRatingRows();

    @SerializedName("rating_star")
    public abstract float getRatingStar();

    @SerializedName("recent_follow_list")
    public abstract List<User> getRecentFollowList();

    public abstract int getRecommend();

    @SerializedName("recommendRows")
    public abstract List<NewHeadLine> getRecommendRows();

    public abstract List<ServiceApp> getRelatedRows();

    public abstract String getRemark();

    @SerializedName("requestContext")
    public abstract String getRequestContext();

    public abstract String getReviewer();

    public abstract String getScore();

    public abstract List<String> getScreenList();

    @SerializedName("selectedTab")
    public abstract String getSelectedTab();

    @SerializedName("sdkversion")
    public abstract int getSupportAndroidVersion();

    @SerializedName("tabList")
    public abstract List<ConfigPage> getTabApiList();

    public abstract List<String> getTagList();

    @SerializedName("target_id")
    public abstract String getTargetId();

    public abstract List<String> getThumbList();

    @SerializedName("top_ids")
    public abstract List<String> getTopIds();

    public abstract int getUpDown();

    public abstract String getUpdateFlag();

    public abstract UserAction getUserAction();

    @SerializedName("apkversioncode")
    public abstract int getVersionCode();

    @SerializedName("apkversionname")
    public abstract String getVersionName();

    public abstract int getVotenum();

    public abstract int getVotenum1();

    public abstract int getVotenum2();

    public abstract int getVotenum3();

    public abstract int getVotenum4();

    public abstract int getVotenum5();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getApkId() {
        return getId();
    }

    public String getAppFullName() {
        return getTitle();
    }

    public boolean isCollectionTop() {
        return getCollectionItem() != null && getCollectionItem().isTop();
    }

    public boolean isXposedPlugin() {
        return !isXposedFramework() && TextUtils.equals("[Xposed]", getExtraFlag());
    }

    public boolean isXposedFramework() {
        return !TextUtils.isEmpty(getPackageName()) && getPackageName().startsWith("de.robv.android.xposed.installer");
    }

    public String getApkSizeFormat() {
        String apkSize = getApkSize();
        return TextUtils.isEmpty(apkSize) ? StringUtils.formatSize(getApkLength()) : apkSize;
    }

    public String getDownloadUrl(int i) {
        cacheUrl();
        if (i != 2) {
            return this.apkUrlCache;
        }
        return this.extraUrlCache;
    }

    public String getDownloadUrlMd5(int i) {
        cacheUrl();
        if (i != 2) {
            return this.apkUrlMd5Cache;
        }
        return this.extraUrlMd5Cache;
    }

    private void cacheUrl() {
        if (this.apkUrlCache == null) {
            String apkDownloadUrl = CacheUrlUtils.getApkDownloadUrl(getPackageName(), getApkId(), getVersionCode(), false);
            this.apkUrlCache = apkDownloadUrl;
            this.apkUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl);
        }
        if (this.extraUrlCache == null) {
            String apkDownloadUrl2 = CacheUrlUtils.getApkDownloadUrl(getPackageName(), getApkId(), getVersionCode(), true);
            this.extraUrlCache = apkDownloadUrl2;
            this.extraUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl2);
        }
    }

    public static TypeAdapter<ServiceApp> typeAdapter(Gson gson) {
        return new C$AutoValue_ServiceApp.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_ServiceApp.Builder();
    }

    public static Builder builder(ServiceApp serviceApp) {
        return new C$$AutoValue_ServiceApp.Builder(serviceApp);
    }
}
