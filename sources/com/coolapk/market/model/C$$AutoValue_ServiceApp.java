package com.coolapk.market.model;

import com.coolapk.market.model.ServiceApp;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ServiceApp  reason: invalid class name */
abstract class C$$AutoValue_ServiceApp extends ServiceApp {
    private final List<Album> albumRows;
    private final long apkLength;
    private final String apkRomVersion;
    private final String apkSize;
    private final String apkSubTitle;
    private final String apkType;
    private final String apkUrl;
    private final String appName;
    private final String bgColor;
    private final String categoryId;
    private final String categoryName;
    private final String changeHistory;
    private final String changeLog;
    private final Collection collectionInfo;
    private final CollectionItem collectionItem;
    private final int commentBlockNum;
    private final String commentCount;
    private final int commentStatus;
    private final List<CouponInfo> couponInfo;
    private final String cover;
    private final Long dateline;
    private final String description;
    private final String developerName;
    private final User developerProfile;
    private final List<ServiceApp> developerRows;
    private final int digest;
    private final List<RelatedData> discoveryRows;
    private final String displayVersionName;
    private final String downCount;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extendFile;
    private final String extendName;
    private final String extraAnalysisData;
    private final String extraData;
    private final String extraFlag;
    private final String extraFromApi;
    private final String followCount;
    private final List<RelatedData> followerRows;
    private final int giftCount;
    private final List<Gift> giftRows;
    private final boolean hasCoupon;
    private final int hotNum;
    private final String id;
    private final String introduce;
    private final int isDownloadApp;
    private final int isForumApp;
    private final String keywords;
    private final String language;
    private final Long lastUpdate;
    private final String loginUserRate;
    private final String logo;
    private final List<MenuCard> menuCards;
    private final String openLink;
    private final String packageName;
    private final List<String> permissions;
    private final String pic;
    private final long publicUpdate;
    private final List<RelatedData> ratingRows;
    private final float ratingStar;
    private final List<User> recentFollowList;
    private final int recommend;
    private final List<NewHeadLine> recommendRows;
    private final List<ServiceApp> relatedRows;
    private final String remark;
    private final String requestContext;
    private final String reviewer;
    private final String score;
    private final List<String> screenList;
    private final String selectedTab;
    private final String subTitle;
    private final int supportAndroidVersion;
    private final List<ConfigPage> tabApiList;
    private final List<String> tagList;
    private final String targetId;
    private final List<String> thumbList;
    private final String title;
    private final List<String> topIds;
    private final int upDown;
    private final String updateFlag;
    private final String url;
    private final UserAction userAction;
    private final int versionCode;
    private final String versionName;
    private final int votenum;
    private final int votenum1;
    private final int votenum2;
    private final int votenum3;
    private final int votenum4;
    private final int votenum5;

    C$$AutoValue_ServiceApp(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, String str10, String str11, String str12, String str13, String str14, int i, String str15, long j, long j2, String str16, String str17, int i2, int i3, String str18, String str19, String str20, String str21, String str22, String str23, float f, String str24, String str25, String str26, String str27, List<String> list, List<String> list2, String str28, String str29, String str30, String str31, int i4, String str32, int i5, List<Gift> list3, int i6, int i7, int i8, int i9, int i10, int i11, UserAction userAction2, List<RelatedData> list4, List<RelatedData> list5, List<User> list6, List<RelatedData> list7, String str33, String str34, List<String> list8, String str35, String str36, List<String> list9, List<ServiceApp> list10, List<ServiceApp> list11, List<Album> list12, String str37, int i12, User user, String str38, String str39, String str40, int i13, List<MenuCard> list13, String str41, int i14, int i15, int i16, Collection collection, CollectionItem collectionItem2, boolean z, String str42, String str43, List<CouponInfo> list14, List<ConfigPage> list15, String str44, int i17, String str45, String str46, List<NewHeadLine> list16, List<String> list17, String str47) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.title = str3;
        this.url = str4;
        this.pic = str5;
        this.subTitle = str6;
        this.id = str7;
        this.extraData = str8;
        this.dateline = l;
        this.lastUpdate = l2;
        this.entityTypeName = str9;
        this.packageName = str10;
        this.targetId = str11;
        this.apkType = str12;
        Objects.requireNonNull(str13, "Null displayVersionName");
        this.displayVersionName = str13;
        Objects.requireNonNull(str14, "Null versionName");
        this.versionName = str14;
        this.versionCode = i;
        Objects.requireNonNull(str15, "Null apkSize");
        this.apkSize = str15;
        this.publicUpdate = j;
        this.apkLength = j2;
        this.extraFlag = str16;
        Objects.requireNonNull(str17, "Null description");
        this.description = str17;
        this.recommend = i2;
        this.digest = i3;
        this.changeLog = str18;
        Objects.requireNonNull(str19, "Null logo");
        this.logo = str19;
        this.cover = str20;
        this.followCount = str21;
        this.commentCount = str22;
        this.downCount = str23;
        this.ratingStar = f;
        this.score = str24;
        this.updateFlag = str25;
        this.appName = str26;
        this.apkRomVersion = str27;
        this.thumbList = list;
        this.screenList = list2;
        this.introduce = str28;
        this.loginUserRate = str29;
        this.remark = str30;
        this.reviewer = str31;
        this.supportAndroidVersion = i4;
        this.language = str32;
        this.giftCount = i5;
        this.giftRows = list3;
        this.votenum = i6;
        this.votenum1 = i7;
        this.votenum2 = i8;
        this.votenum3 = i9;
        this.votenum4 = i10;
        this.votenum5 = i11;
        this.userAction = userAction2;
        this.discoveryRows = list4;
        this.followerRows = list5;
        this.recentFollowList = list6;
        this.ratingRows = list7;
        this.categoryId = str33;
        this.categoryName = str34;
        this.tagList = list8;
        this.apkUrl = str35;
        this.developerName = str36;
        this.permissions = list9;
        this.developerRows = list10;
        this.relatedRows = list11;
        this.albumRows = list12;
        this.keywords = str37;
        this.upDown = i12;
        this.developerProfile = user;
        this.extendFile = str38;
        this.extendName = str39;
        this.changeHistory = str40;
        this.commentBlockNum = i13;
        this.menuCards = list13;
        this.extraAnalysisData = str41;
        this.isDownloadApp = i14;
        this.isForumApp = i15;
        this.commentStatus = i16;
        this.collectionInfo = collection;
        this.collectionItem = collectionItem2;
        this.hasCoupon = z;
        this.extraFromApi = str42;
        this.apkSubTitle = str43;
        this.couponInfo = list14;
        this.tabApiList = list15;
        this.selectedTab = str44;
        this.hotNum = i17;
        this.bgColor = str45;
        this.requestContext = str46;
        Objects.requireNonNull(list16, "Null recommendRows");
        this.recommendRows = list16;
        Objects.requireNonNull(list17, "Null topIds");
        this.topIds = list17;
        this.openLink = str47;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.ServiceApp, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("target_id")
    public String getTargetId() {
        return this.targetId;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("apktype")
    public String getApkType() {
        return this.apkType;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("version")
    public String getDisplayVersionName() {
        return this.displayVersionName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("apkversionname")
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("apkversioncode")
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("apksize")
    public String getApkSize() {
        return this.apkSize;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("pubdate")
    public long getPublicUpdate() {
        return this.publicUpdate;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("apklength")
    public long getApkLength() {
        return this.apkLength;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getExtraFlag() {
        return this.extraFlag;
    }

    @Override // com.coolapk.market.model.ServiceApp, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getRecommend() {
        return this.recommend;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getDigest() {
        return this.digest;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("changelog")
    public String getChangeLog() {
        return this.changeLog;
    }

    @Override // com.coolapk.market.model.ServiceApp, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getCover() {
        return this.cover;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getFollowCount() {
        return this.followCount;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getCommentCount() {
        return this.commentCount;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getDownCount() {
        return this.downCount;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("rating_star")
    public float getRatingStar() {
        return this.ratingStar;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getScore() {
        return this.score;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getUpdateFlag() {
        return this.updateFlag;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("shorttitle")
    public String getAppName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getApkRomVersion() {
        return this.apkRomVersion;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<String> getThumbList() {
        return this.thumbList;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<String> getScreenList() {
        return this.screenList;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getIntroduce() {
        return this.introduce;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("star")
    public String getLoginUserRate() {
        return this.loginUserRate;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getRemark() {
        return this.remark;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getReviewer() {
        return this.reviewer;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("sdkversion")
    public int getSupportAndroidVersion() {
        return this.supportAndroidVersion;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getLanguage() {
        return this.language;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getGiftCount() {
        return this.giftCount;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<Gift> getGiftRows() {
        return this.giftRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getVotenum() {
        return this.votenum;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getVotenum1() {
        return this.votenum1;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getVotenum2() {
        return this.votenum2;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getVotenum3() {
        return this.votenum3;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getVotenum4() {
        return this.votenum4;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getVotenum5() {
        return this.votenum5;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<RelatedData> getDiscoveryRows() {
        return this.discoveryRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<RelatedData> getFollowerRows() {
        return this.followerRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("recent_follow_list")
    public List<User> getRecentFollowList() {
        return this.recentFollowList;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<RelatedData> getRatingRows() {
        return this.ratingRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("catid")
    public String getCategoryId() {
        return this.categoryId;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("catName")
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<String> getTagList() {
        return this.tagList;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getApkUrl() {
        return this.apkUrl;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("developername")
    public String getDeveloperName() {
        return this.developerName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<String> getPermissions() {
        return this.permissions;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<ServiceApp> getDeveloperRows() {
        return this.developerRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<ServiceApp> getRelatedRows() {
        return this.relatedRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<Album> getAlbumRows() {
        return this.albumRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public int getUpDown() {
        return this.upDown;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public User getDeveloperProfile() {
        return this.developerProfile;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("extendfile")
    public String getExtendFile() {
        return this.extendFile;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("extendname")
    public String getExtendName() {
        return this.extendName;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("changehistory")
    public String getChangeHistory() {
        return this.changeHistory;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("comment_block_num")
    public int getCommentBlockNum() {
        return this.commentBlockNum;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("extendedMenus")
    public List<MenuCard> getMenuCards() {
        return this.menuCards;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public String getExtraAnalysisData() {
        return this.extraAnalysisData;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("is_download_app")
    public int getIsDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("is_forum_app")
    public int getIsForumApp() {
        return this.isForumApp;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("comment_status")
    public int getCommentStatus() {
        return this.commentStatus;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("collection_info")
    public Collection getCollectionInfo() {
        return this.collectionInfo;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("collection_item_info")
    public CollectionItem getCollectionItem() {
        return this.collectionItem;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public boolean getHasCoupon() {
        return this.hasCoupon;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("extra_fromApi")
    public String getExtraFromApi() {
        return this.extraFromApi;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("subtitle")
    public String getApkSubTitle() {
        return this.apkSubTitle;
    }

    @Override // com.coolapk.market.model.ServiceApp
    public List<CouponInfo> getCouponInfo() {
        return this.couponInfo;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("tabList")
    public List<ConfigPage> getTabApiList() {
        return this.tabApiList;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("selectedTab")
    public String getSelectedTab() {
        return this.selectedTab;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("hot_num")
    public int getHotNum() {
        return this.hotNum;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("bgColor")
    public String getBgColor() {
        return this.bgColor;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("requestContext")
    public String getRequestContext() {
        return this.requestContext;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("recommendRows")
    public List<NewHeadLine> getRecommendRows() {
        return this.recommendRows;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("top_ids")
    public List<String> getTopIds() {
        return this.topIds;
    }

    @Override // com.coolapk.market.model.ServiceApp
    @SerializedName("open_link")
    public String getOpenLink() {
        return this.openLink;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ServiceApp{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", entityTypeName=" + this.entityTypeName + ", packageName=" + this.packageName + ", targetId=" + this.targetId + ", apkType=" + this.apkType + ", displayVersionName=" + this.displayVersionName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", apkSize=" + this.apkSize + ", publicUpdate=" + this.publicUpdate + ", apkLength=" + this.apkLength + ", extraFlag=" + this.extraFlag + ", description=" + this.description + ", recommend=" + this.recommend + ", digest=" + this.digest + ", changeLog=" + this.changeLog + ", logo=" + this.logo + ", cover=" + this.cover + ", followCount=" + this.followCount + ", commentCount=" + this.commentCount + ", downCount=" + this.downCount + ", ratingStar=" + this.ratingStar + ", score=" + this.score + ", updateFlag=" + this.updateFlag + ", appName=" + this.appName + ", apkRomVersion=" + this.apkRomVersion + ", thumbList=" + this.thumbList + ", screenList=" + this.screenList + ", introduce=" + this.introduce + ", loginUserRate=" + this.loginUserRate + ", remark=" + this.remark + ", reviewer=" + this.reviewer + ", supportAndroidVersion=" + this.supportAndroidVersion + ", language=" + this.language + ", giftCount=" + this.giftCount + ", giftRows=" + this.giftRows + ", votenum=" + this.votenum + ", votenum1=" + this.votenum1 + ", votenum2=" + this.votenum2 + ", votenum3=" + this.votenum3 + ", votenum4=" + this.votenum4 + ", votenum5=" + this.votenum5 + ", userAction=" + this.userAction + ", discoveryRows=" + this.discoveryRows + ", followerRows=" + this.followerRows + ", recentFollowList=" + this.recentFollowList + ", ratingRows=" + this.ratingRows + ", categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", tagList=" + this.tagList + ", apkUrl=" + this.apkUrl + ", developerName=" + this.developerName + ", permissions=" + this.permissions + ", developerRows=" + this.developerRows + ", relatedRows=" + this.relatedRows + ", albumRows=" + this.albumRows + ", keywords=" + this.keywords + ", upDown=" + this.upDown + ", developerProfile=" + this.developerProfile + ", extendFile=" + this.extendFile + ", extendName=" + this.extendName + ", changeHistory=" + this.changeHistory + ", commentBlockNum=" + this.commentBlockNum + ", menuCards=" + this.menuCards + ", extraAnalysisData=" + this.extraAnalysisData + ", isDownloadApp=" + this.isDownloadApp + ", isForumApp=" + this.isForumApp + ", commentStatus=" + this.commentStatus + ", collectionInfo=" + this.collectionInfo + ", collectionItem=" + this.collectionItem + ", hasCoupon=" + this.hasCoupon + ", extraFromApi=" + this.extraFromApi + ", apkSubTitle=" + this.apkSubTitle + ", couponInfo=" + this.couponInfo + ", tabApiList=" + this.tabApiList + ", selectedTab=" + this.selectedTab + ", hotNum=" + this.hotNum + ", bgColor=" + this.bgColor + ", requestContext=" + this.requestContext + ", recommendRows=" + this.recommendRows + ", topIds=" + this.topIds + ", openLink=" + this.openLink + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        List<String> list;
        List<String> list2;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        List<Gift> list3;
        UserAction userAction2;
        List<RelatedData> list4;
        List<RelatedData> list5;
        List<User> list6;
        List<RelatedData> list7;
        String str16;
        String str17;
        List<String> list8;
        String str18;
        String str19;
        List<String> list9;
        List<ServiceApp> list10;
        List<ServiceApp> list11;
        List<Album> list12;
        String str20;
        User user;
        String str21;
        String str22;
        String str23;
        List<MenuCard> list13;
        String str24;
        Collection collection;
        CollectionItem collectionItem2;
        String str25;
        String str26;
        List<CouponInfo> list14;
        List<ConfigPage> list15;
        String str27;
        String str28;
        String str29;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceApp)) {
            return false;
        }
        ServiceApp serviceApp = (ServiceApp) obj;
        String str30 = this.entityTemplate;
        if (str30 != null ? str30.equals(serviceApp.getEntityTemplate()) : serviceApp.getEntityTemplate() == null) {
            String str31 = this.entityId;
            if (str31 != null ? str31.equals(serviceApp.getEntityId()) : serviceApp.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(serviceApp.getEntityFixed()) : serviceApp.getEntityFixed() == null) {
                    String str32 = this.title;
                    if (str32 != null ? str32.equals(serviceApp.getTitle()) : serviceApp.getTitle() == null) {
                        String str33 = this.url;
                        if (str33 != null ? str33.equals(serviceApp.getUrl()) : serviceApp.getUrl() == null) {
                            String str34 = this.pic;
                            if (str34 != null ? str34.equals(serviceApp.getPic()) : serviceApp.getPic() == null) {
                                String str35 = this.subTitle;
                                if (str35 != null ? str35.equals(serviceApp.getSubTitle()) : serviceApp.getSubTitle() == null) {
                                    String str36 = this.id;
                                    if (str36 != null ? str36.equals(serviceApp.getId()) : serviceApp.getId() == null) {
                                        String str37 = this.extraData;
                                        if (str37 != null ? str37.equals(serviceApp.getExtraData()) : serviceApp.getExtraData() == null) {
                                            Long l = this.dateline;
                                            if (l != null ? l.equals(serviceApp.getDateline()) : serviceApp.getDateline() == null) {
                                                Long l2 = this.lastUpdate;
                                                if (l2 != null ? l2.equals(serviceApp.getLastUpdate()) : serviceApp.getLastUpdate() == null) {
                                                    String str38 = this.entityTypeName;
                                                    if (str38 != null ? str38.equals(serviceApp.getEntityTypeName()) : serviceApp.getEntityTypeName() == null) {
                                                        String str39 = this.packageName;
                                                        if (str39 != null ? str39.equals(serviceApp.getPackageName()) : serviceApp.getPackageName() == null) {
                                                            String str40 = this.targetId;
                                                            if (str40 != null ? str40.equals(serviceApp.getTargetId()) : serviceApp.getTargetId() == null) {
                                                                String str41 = this.apkType;
                                                                if (str41 != null ? str41.equals(serviceApp.getApkType()) : serviceApp.getApkType() == null) {
                                                                    if (this.displayVersionName.equals(serviceApp.getDisplayVersionName()) && this.versionName.equals(serviceApp.getVersionName()) && this.versionCode == serviceApp.getVersionCode() && this.apkSize.equals(serviceApp.getApkSize()) && this.publicUpdate == serviceApp.getPublicUpdate() && this.apkLength == serviceApp.getApkLength() && ((str = this.extraFlag) != null ? str.equals(serviceApp.getExtraFlag()) : serviceApp.getExtraFlag() == null) && this.description.equals(serviceApp.getDescription()) && this.recommend == serviceApp.getRecommend() && this.digest == serviceApp.getDigest() && ((str2 = this.changeLog) != null ? str2.equals(serviceApp.getChangeLog()) : serviceApp.getChangeLog() == null) && this.logo.equals(serviceApp.getLogo()) && ((str3 = this.cover) != null ? str3.equals(serviceApp.getCover()) : serviceApp.getCover() == null) && ((str4 = this.followCount) != null ? str4.equals(serviceApp.getFollowCount()) : serviceApp.getFollowCount() == null) && ((str5 = this.commentCount) != null ? str5.equals(serviceApp.getCommentCount()) : serviceApp.getCommentCount() == null) && ((str6 = this.downCount) != null ? str6.equals(serviceApp.getDownCount()) : serviceApp.getDownCount() == null) && Float.floatToIntBits(this.ratingStar) == Float.floatToIntBits(serviceApp.getRatingStar()) && ((str7 = this.score) != null ? str7.equals(serviceApp.getScore()) : serviceApp.getScore() == null) && ((str8 = this.updateFlag) != null ? str8.equals(serviceApp.getUpdateFlag()) : serviceApp.getUpdateFlag() == null) && ((str9 = this.appName) != null ? str9.equals(serviceApp.getAppName()) : serviceApp.getAppName() == null) && ((str10 = this.apkRomVersion) != null ? str10.equals(serviceApp.getApkRomVersion()) : serviceApp.getApkRomVersion() == null) && ((list = this.thumbList) != null ? list.equals(serviceApp.getThumbList()) : serviceApp.getThumbList() == null) && ((list2 = this.screenList) != null ? list2.equals(serviceApp.getScreenList()) : serviceApp.getScreenList() == null) && ((str11 = this.introduce) != null ? str11.equals(serviceApp.getIntroduce()) : serviceApp.getIntroduce() == null) && ((str12 = this.loginUserRate) != null ? str12.equals(serviceApp.getLoginUserRate()) : serviceApp.getLoginUserRate() == null) && ((str13 = this.remark) != null ? str13.equals(serviceApp.getRemark()) : serviceApp.getRemark() == null) && ((str14 = this.reviewer) != null ? str14.equals(serviceApp.getReviewer()) : serviceApp.getReviewer() == null) && this.supportAndroidVersion == serviceApp.getSupportAndroidVersion() && ((str15 = this.language) != null ? str15.equals(serviceApp.getLanguage()) : serviceApp.getLanguage() == null) && this.giftCount == serviceApp.getGiftCount() && ((list3 = this.giftRows) != null ? list3.equals(serviceApp.getGiftRows()) : serviceApp.getGiftRows() == null) && this.votenum == serviceApp.getVotenum() && this.votenum1 == serviceApp.getVotenum1() && this.votenum2 == serviceApp.getVotenum2() && this.votenum3 == serviceApp.getVotenum3() && this.votenum4 == serviceApp.getVotenum4() && this.votenum5 == serviceApp.getVotenum5() && ((userAction2 = this.userAction) != null ? userAction2.equals(serviceApp.getUserAction()) : serviceApp.getUserAction() == null) && ((list4 = this.discoveryRows) != null ? list4.equals(serviceApp.getDiscoveryRows()) : serviceApp.getDiscoveryRows() == null) && ((list5 = this.followerRows) != null ? list5.equals(serviceApp.getFollowerRows()) : serviceApp.getFollowerRows() == null) && ((list6 = this.recentFollowList) != null ? list6.equals(serviceApp.getRecentFollowList()) : serviceApp.getRecentFollowList() == null) && ((list7 = this.ratingRows) != null ? list7.equals(serviceApp.getRatingRows()) : serviceApp.getRatingRows() == null) && ((str16 = this.categoryId) != null ? str16.equals(serviceApp.getCategoryId()) : serviceApp.getCategoryId() == null) && ((str17 = this.categoryName) != null ? str17.equals(serviceApp.getCategoryName()) : serviceApp.getCategoryName() == null) && ((list8 = this.tagList) != null ? list8.equals(serviceApp.getTagList()) : serviceApp.getTagList() == null) && ((str18 = this.apkUrl) != null ? str18.equals(serviceApp.getApkUrl()) : serviceApp.getApkUrl() == null) && ((str19 = this.developerName) != null ? str19.equals(serviceApp.getDeveloperName()) : serviceApp.getDeveloperName() == null) && ((list9 = this.permissions) != null ? list9.equals(serviceApp.getPermissions()) : serviceApp.getPermissions() == null) && ((list10 = this.developerRows) != null ? list10.equals(serviceApp.getDeveloperRows()) : serviceApp.getDeveloperRows() == null) && ((list11 = this.relatedRows) != null ? list11.equals(serviceApp.getRelatedRows()) : serviceApp.getRelatedRows() == null) && ((list12 = this.albumRows) != null ? list12.equals(serviceApp.getAlbumRows()) : serviceApp.getAlbumRows() == null) && ((str20 = this.keywords) != null ? str20.equals(serviceApp.getKeywords()) : serviceApp.getKeywords() == null) && this.upDown == serviceApp.getUpDown() && ((user = this.developerProfile) != null ? user.equals(serviceApp.getDeveloperProfile()) : serviceApp.getDeveloperProfile() == null) && ((str21 = this.extendFile) != null ? str21.equals(serviceApp.getExtendFile()) : serviceApp.getExtendFile() == null) && ((str22 = this.extendName) != null ? str22.equals(serviceApp.getExtendName()) : serviceApp.getExtendName() == null) && ((str23 = this.changeHistory) != null ? str23.equals(serviceApp.getChangeHistory()) : serviceApp.getChangeHistory() == null) && this.commentBlockNum == serviceApp.getCommentBlockNum() && ((list13 = this.menuCards) != null ? list13.equals(serviceApp.getMenuCards()) : serviceApp.getMenuCards() == null) && ((str24 = this.extraAnalysisData) != null ? str24.equals(serviceApp.getExtraAnalysisData()) : serviceApp.getExtraAnalysisData() == null) && this.isDownloadApp == serviceApp.getIsDownloadApp() && this.isForumApp == serviceApp.getIsForumApp() && this.commentStatus == serviceApp.getCommentStatus() && ((collection = this.collectionInfo) != null ? collection.equals(serviceApp.getCollectionInfo()) : serviceApp.getCollectionInfo() == null) && ((collectionItem2 = this.collectionItem) != null ? collectionItem2.equals(serviceApp.getCollectionItem()) : serviceApp.getCollectionItem() == null) && this.hasCoupon == serviceApp.getHasCoupon() && ((str25 = this.extraFromApi) != null ? str25.equals(serviceApp.getExtraFromApi()) : serviceApp.getExtraFromApi() == null) && ((str26 = this.apkSubTitle) != null ? str26.equals(serviceApp.getApkSubTitle()) : serviceApp.getApkSubTitle() == null) && ((list14 = this.couponInfo) != null ? list14.equals(serviceApp.getCouponInfo()) : serviceApp.getCouponInfo() == null) && ((list15 = this.tabApiList) != null ? list15.equals(serviceApp.getTabApiList()) : serviceApp.getTabApiList() == null) && ((str27 = this.selectedTab) != null ? str27.equals(serviceApp.getSelectedTab()) : serviceApp.getSelectedTab() == null) && this.hotNum == serviceApp.getHotNum() && ((str28 = this.bgColor) != null ? str28.equals(serviceApp.getBgColor()) : serviceApp.getBgColor() == null) && ((str29 = this.requestContext) != null ? str29.equals(serviceApp.getRequestContext()) : serviceApp.getRequestContext() == null) && this.recommendRows.equals(serviceApp.getRecommendRows()) && this.topIds.equals(serviceApp.getTopIds())) {
                                                                        String str42 = this.openLink;
                                                                        if (str42 == null) {
                                                                            if (serviceApp.getOpenLink() == null) {
                                                                                return true;
                                                                            }
                                                                        } else if (str42.equals(serviceApp.getOpenLink())) {
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.title;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.subTitle;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.id;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode10 = (hashCode9 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode11 = (hashCode10 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str9 = this.entityTypeName;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.packageName;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.targetId;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.apkType;
        int hashCode15 = str12 == null ? 0 : str12.hashCode();
        long j = this.publicUpdate;
        long j2 = this.apkLength;
        int hashCode16 = ((int) (((long) (((int) (((long) ((((((((((hashCode14 ^ hashCode15) * 1000003) ^ this.displayVersionName.hashCode()) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.versionCode) * 1000003) ^ this.apkSize.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003;
        String str13 = this.extraFlag;
        int hashCode17 = (((((((hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.recommend) * 1000003) ^ this.digest) * 1000003;
        String str14 = this.changeLog;
        int hashCode18 = (((hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.logo.hashCode()) * 1000003;
        String str15 = this.cover;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.followCount;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.commentCount;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.downCount;
        int hashCode22 = (((hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003) ^ Float.floatToIntBits(this.ratingStar)) * 1000003;
        String str19 = this.score;
        int hashCode23 = (hashCode22 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.updateFlag;
        int hashCode24 = (hashCode23 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.appName;
        int hashCode25 = (hashCode24 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        String str22 = this.apkRomVersion;
        int hashCode26 = (hashCode25 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
        List<String> list = this.thumbList;
        int hashCode27 = (hashCode26 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.screenList;
        int hashCode28 = (hashCode27 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        String str23 = this.introduce;
        int hashCode29 = (hashCode28 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        String str24 = this.loginUserRate;
        int hashCode30 = (hashCode29 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.remark;
        int hashCode31 = (hashCode30 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
        String str26 = this.reviewer;
        int hashCode32 = (((hashCode31 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003) ^ this.supportAndroidVersion) * 1000003;
        String str27 = this.language;
        int hashCode33 = (((hashCode32 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003) ^ this.giftCount) * 1000003;
        List<Gift> list3 = this.giftRows;
        int hashCode34 = (((((((((((((hashCode33 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003) ^ this.votenum) * 1000003) ^ this.votenum1) * 1000003) ^ this.votenum2) * 1000003) ^ this.votenum3) * 1000003) ^ this.votenum4) * 1000003) ^ this.votenum5) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode35 = (hashCode34 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003;
        List<RelatedData> list4 = this.discoveryRows;
        int hashCode36 = (hashCode35 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
        List<RelatedData> list5 = this.followerRows;
        int hashCode37 = (hashCode36 ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
        List<User> list6 = this.recentFollowList;
        int hashCode38 = (hashCode37 ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
        List<RelatedData> list7 = this.ratingRows;
        int hashCode39 = (hashCode38 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
        String str28 = this.categoryId;
        int hashCode40 = (hashCode39 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
        String str29 = this.categoryName;
        int hashCode41 = (hashCode40 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
        List<String> list8 = this.tagList;
        int hashCode42 = (hashCode41 ^ (list8 == null ? 0 : list8.hashCode())) * 1000003;
        String str30 = this.apkUrl;
        int hashCode43 = (hashCode42 ^ (str30 == null ? 0 : str30.hashCode())) * 1000003;
        String str31 = this.developerName;
        int hashCode44 = (hashCode43 ^ (str31 == null ? 0 : str31.hashCode())) * 1000003;
        List<String> list9 = this.permissions;
        int hashCode45 = (hashCode44 ^ (list9 == null ? 0 : list9.hashCode())) * 1000003;
        List<ServiceApp> list10 = this.developerRows;
        int hashCode46 = (hashCode45 ^ (list10 == null ? 0 : list10.hashCode())) * 1000003;
        List<ServiceApp> list11 = this.relatedRows;
        int hashCode47 = (hashCode46 ^ (list11 == null ? 0 : list11.hashCode())) * 1000003;
        List<Album> list12 = this.albumRows;
        int hashCode48 = (hashCode47 ^ (list12 == null ? 0 : list12.hashCode())) * 1000003;
        String str32 = this.keywords;
        int hashCode49 = (((hashCode48 ^ (str32 == null ? 0 : str32.hashCode())) * 1000003) ^ this.upDown) * 1000003;
        User user = this.developerProfile;
        int hashCode50 = (hashCode49 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        String str33 = this.extendFile;
        int hashCode51 = (hashCode50 ^ (str33 == null ? 0 : str33.hashCode())) * 1000003;
        String str34 = this.extendName;
        int hashCode52 = (hashCode51 ^ (str34 == null ? 0 : str34.hashCode())) * 1000003;
        String str35 = this.changeHistory;
        int hashCode53 = (((hashCode52 ^ (str35 == null ? 0 : str35.hashCode())) * 1000003) ^ this.commentBlockNum) * 1000003;
        List<MenuCard> list13 = this.menuCards;
        int hashCode54 = (hashCode53 ^ (list13 == null ? 0 : list13.hashCode())) * 1000003;
        String str36 = this.extraAnalysisData;
        int hashCode55 = (((((((hashCode54 ^ (str36 == null ? 0 : str36.hashCode())) * 1000003) ^ this.isDownloadApp) * 1000003) ^ this.isForumApp) * 1000003) ^ this.commentStatus) * 1000003;
        Collection collection = this.collectionInfo;
        int hashCode56 = (hashCode55 ^ (collection == null ? 0 : collection.hashCode())) * 1000003;
        CollectionItem collectionItem2 = this.collectionItem;
        int hashCode57 = (((hashCode56 ^ (collectionItem2 == null ? 0 : collectionItem2.hashCode())) * 1000003) ^ (this.hasCoupon ? 1231 : 1237)) * 1000003;
        String str37 = this.extraFromApi;
        int hashCode58 = (hashCode57 ^ (str37 == null ? 0 : str37.hashCode())) * 1000003;
        String str38 = this.apkSubTitle;
        int hashCode59 = (hashCode58 ^ (str38 == null ? 0 : str38.hashCode())) * 1000003;
        List<CouponInfo> list14 = this.couponInfo;
        int hashCode60 = (hashCode59 ^ (list14 == null ? 0 : list14.hashCode())) * 1000003;
        List<ConfigPage> list15 = this.tabApiList;
        int hashCode61 = (hashCode60 ^ (list15 == null ? 0 : list15.hashCode())) * 1000003;
        String str39 = this.selectedTab;
        int hashCode62 = (((hashCode61 ^ (str39 == null ? 0 : str39.hashCode())) * 1000003) ^ this.hotNum) * 1000003;
        String str40 = this.bgColor;
        int hashCode63 = (hashCode62 ^ (str40 == null ? 0 : str40.hashCode())) * 1000003;
        String str41 = this.requestContext;
        int hashCode64 = (((((hashCode63 ^ (str41 == null ? 0 : str41.hashCode())) * 1000003) ^ this.recommendRows.hashCode()) * 1000003) ^ this.topIds.hashCode()) * 1000003;
        String str42 = this.openLink;
        if (str42 != null) {
            i = str42.hashCode();
        }
        return hashCode64 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_ServiceApp$Builder */
    /* compiled from: $$AutoValue_ServiceApp */
    static final class Builder extends ServiceApp.Builder {
        private List<Album> albumRows;
        private Long apkLength;
        private String apkRomVersion;
        private String apkSize;
        private String apkSubTitle;
        private String apkType;
        private String apkUrl;
        private String appName;
        private String bgColor;
        private String categoryId;
        private String categoryName;
        private String changeHistory;
        private String changeLog;
        private Collection collectionInfo;
        private CollectionItem collectionItem;
        private Integer commentBlockNum;
        private String commentCount;
        private Integer commentStatus;
        private List<CouponInfo> couponInfo;
        private String cover;
        private Long dateline;
        private String description;
        private String developerName;
        private User developerProfile;
        private List<ServiceApp> developerRows;
        private Integer digest;
        private List<RelatedData> discoveryRows;
        private String displayVersionName;
        private String downCount;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extendFile;
        private String extendName;
        private String extraAnalysisData;
        private String extraData;
        private String extraFlag;
        private String extraFromApi;
        private String followCount;
        private List<RelatedData> followerRows;
        private Integer giftCount;
        private List<Gift> giftRows;
        private Boolean hasCoupon;
        private Integer hotNum;
        private String id;
        private String introduce;
        private Integer isDownloadApp;
        private Integer isForumApp;
        private String keywords;
        private String language;
        private Long lastUpdate;
        private String loginUserRate;
        private String logo;
        private List<MenuCard> menuCards;
        private String openLink;
        private String packageName;
        private List<String> permissions;
        private String pic;
        private Long publicUpdate;
        private List<RelatedData> ratingRows;
        private Float ratingStar;
        private List<User> recentFollowList;
        private Integer recommend;
        private List<NewHeadLine> recommendRows;
        private List<ServiceApp> relatedRows;
        private String remark;
        private String requestContext;
        private String reviewer;
        private String score;
        private List<String> screenList;
        private String selectedTab;
        private String subTitle;
        private Integer supportAndroidVersion;
        private List<ConfigPage> tabApiList;
        private List<String> tagList;
        private String targetId;
        private List<String> thumbList;
        private String title;
        private List<String> topIds;
        private Integer upDown;
        private String updateFlag;
        private String url;
        private UserAction userAction;
        private Integer versionCode;
        private String versionName;
        private Integer votenum;
        private Integer votenum1;
        private Integer votenum2;
        private Integer votenum3;
        private Integer votenum4;
        private Integer votenum5;

        Builder() {
        }

        Builder(ServiceApp serviceApp) {
            this.entityTemplate = serviceApp.getEntityTemplate();
            this.entityId = serviceApp.getEntityId();
            this.entityFixed = serviceApp.getEntityFixed();
            this.title = serviceApp.getTitle();
            this.url = serviceApp.getUrl();
            this.pic = serviceApp.getPic();
            this.subTitle = serviceApp.getSubTitle();
            this.id = serviceApp.getId();
            this.extraData = serviceApp.getExtraData();
            this.dateline = serviceApp.getDateline();
            this.lastUpdate = serviceApp.getLastUpdate();
            this.entityTypeName = serviceApp.getEntityTypeName();
            this.packageName = serviceApp.getPackageName();
            this.targetId = serviceApp.getTargetId();
            this.apkType = serviceApp.getApkType();
            this.displayVersionName = serviceApp.getDisplayVersionName();
            this.versionName = serviceApp.getVersionName();
            this.versionCode = Integer.valueOf(serviceApp.getVersionCode());
            this.apkSize = serviceApp.getApkSize();
            this.publicUpdate = Long.valueOf(serviceApp.getPublicUpdate());
            this.apkLength = Long.valueOf(serviceApp.getApkLength());
            this.extraFlag = serviceApp.getExtraFlag();
            this.description = serviceApp.getDescription();
            this.recommend = Integer.valueOf(serviceApp.getRecommend());
            this.digest = Integer.valueOf(serviceApp.getDigest());
            this.changeLog = serviceApp.getChangeLog();
            this.logo = serviceApp.getLogo();
            this.cover = serviceApp.getCover();
            this.followCount = serviceApp.getFollowCount();
            this.commentCount = serviceApp.getCommentCount();
            this.downCount = serviceApp.getDownCount();
            this.ratingStar = Float.valueOf(serviceApp.getRatingStar());
            this.score = serviceApp.getScore();
            this.updateFlag = serviceApp.getUpdateFlag();
            this.appName = serviceApp.getAppName();
            this.apkRomVersion = serviceApp.getApkRomVersion();
            this.thumbList = serviceApp.getThumbList();
            this.screenList = serviceApp.getScreenList();
            this.introduce = serviceApp.getIntroduce();
            this.loginUserRate = serviceApp.getLoginUserRate();
            this.remark = serviceApp.getRemark();
            this.reviewer = serviceApp.getReviewer();
            this.supportAndroidVersion = Integer.valueOf(serviceApp.getSupportAndroidVersion());
            this.language = serviceApp.getLanguage();
            this.giftCount = Integer.valueOf(serviceApp.getGiftCount());
            this.giftRows = serviceApp.getGiftRows();
            this.votenum = Integer.valueOf(serviceApp.getVotenum());
            this.votenum1 = Integer.valueOf(serviceApp.getVotenum1());
            this.votenum2 = Integer.valueOf(serviceApp.getVotenum2());
            this.votenum3 = Integer.valueOf(serviceApp.getVotenum3());
            this.votenum4 = Integer.valueOf(serviceApp.getVotenum4());
            this.votenum5 = Integer.valueOf(serviceApp.getVotenum5());
            this.userAction = serviceApp.getUserAction();
            this.discoveryRows = serviceApp.getDiscoveryRows();
            this.followerRows = serviceApp.getFollowerRows();
            this.recentFollowList = serviceApp.getRecentFollowList();
            this.ratingRows = serviceApp.getRatingRows();
            this.categoryId = serviceApp.getCategoryId();
            this.categoryName = serviceApp.getCategoryName();
            this.tagList = serviceApp.getTagList();
            this.apkUrl = serviceApp.getApkUrl();
            this.developerName = serviceApp.getDeveloperName();
            this.permissions = serviceApp.getPermissions();
            this.developerRows = serviceApp.getDeveloperRows();
            this.relatedRows = serviceApp.getRelatedRows();
            this.albumRows = serviceApp.getAlbumRows();
            this.keywords = serviceApp.getKeywords();
            this.upDown = Integer.valueOf(serviceApp.getUpDown());
            this.developerProfile = serviceApp.getDeveloperProfile();
            this.extendFile = serviceApp.getExtendFile();
            this.extendName = serviceApp.getExtendName();
            this.changeHistory = serviceApp.getChangeHistory();
            this.commentBlockNum = Integer.valueOf(serviceApp.getCommentBlockNum());
            this.menuCards = serviceApp.getMenuCards();
            this.extraAnalysisData = serviceApp.getExtraAnalysisData();
            this.isDownloadApp = Integer.valueOf(serviceApp.getIsDownloadApp());
            this.isForumApp = Integer.valueOf(serviceApp.getIsForumApp());
            this.commentStatus = Integer.valueOf(serviceApp.getCommentStatus());
            this.collectionInfo = serviceApp.getCollectionInfo();
            this.collectionItem = serviceApp.getCollectionItem();
            this.hasCoupon = Boolean.valueOf(serviceApp.getHasCoupon());
            this.extraFromApi = serviceApp.getExtraFromApi();
            this.apkSubTitle = serviceApp.getApkSubTitle();
            this.couponInfo = serviceApp.getCouponInfo();
            this.tabApiList = serviceApp.getTabApiList();
            this.selectedTab = serviceApp.getSelectedTab();
            this.hotNum = Integer.valueOf(serviceApp.getHotNum());
            this.bgColor = serviceApp.getBgColor();
            this.requestContext = serviceApp.getRequestContext();
            this.recommendRows = serviceApp.getRecommendRows();
            this.topIds = serviceApp.getTopIds();
            this.openLink = serviceApp.getOpenLink();
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setTargetId(String str) {
            this.targetId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setApkType(String str) {
            this.apkType = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDisplayVersionName(String str) {
            this.displayVersionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVersionName(String str) {
            this.versionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVersionCode(int i) {
            this.versionCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setApkSize(String str) {
            this.apkSize = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setPublicUpdate(long j) {
            this.publicUpdate = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setApkLength(long j) {
            this.apkLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setExtraFlag(String str) {
            this.extraFlag = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRecommend(int i) {
            this.recommend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDigest(int i) {
            this.digest = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setChangeLog(String str) {
            this.changeLog = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCover(String str) {
            this.cover = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setFollowCount(String str) {
            this.followCount = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCommentCount(String str) {
            this.commentCount = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDownCount(String str) {
            this.downCount = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRatingStar(float f) {
            this.ratingStar = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setScore(String str) {
            this.score = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setUpdateFlag(String str) {
            this.updateFlag = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setApkRomVersion(String str) {
            this.apkRomVersion = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setThumbList(List<String> list) {
            this.thumbList = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setScreenList(List<String> list) {
            this.screenList = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setIntroduce(String str) {
            this.introduce = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setLoginUserRate(String str) {
            this.loginUserRate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRemark(String str) {
            this.remark = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setReviewer(String str) {
            this.reviewer = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setSupportAndroidVersion(int i) {
            this.supportAndroidVersion = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setGiftCount(int i) {
            this.giftCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setGiftRows(List<Gift> list) {
            this.giftRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVotenum(int i) {
            this.votenum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVotenum1(int i) {
            this.votenum1 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVotenum2(int i) {
            this.votenum2 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVotenum3(int i) {
            this.votenum3 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVotenum4(int i) {
            this.votenum4 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setVotenum5(int i) {
            this.votenum5 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setUserAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDiscoveryRows(List<RelatedData> list) {
            this.discoveryRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setFollowerRows(List<RelatedData> list) {
            this.followerRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRecentFollowList(List<User> list) {
            this.recentFollowList = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRatingRows(List<RelatedData> list) {
            this.ratingRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCategoryId(String str) {
            this.categoryId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCategoryName(String str) {
            this.categoryName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setTagList(List<String> list) {
            this.tagList = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setApkUrl(String str) {
            this.apkUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDeveloperName(String str) {
            this.developerName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setPermissions(List<String> list) {
            this.permissions = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDeveloperRows(List<ServiceApp> list) {
            this.developerRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRelatedRows(List<ServiceApp> list) {
            this.relatedRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setAlbumRows(List<Album> list) {
            this.albumRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setKeywords(String str) {
            this.keywords = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setUpDown(int i) {
            this.upDown = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setDeveloperProfile(User user) {
            this.developerProfile = user;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setExtendFile(String str) {
            this.extendFile = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setExtendName(String str) {
            this.extendName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setChangeHistory(String str) {
            this.changeHistory = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCommentBlockNum(int i) {
            this.commentBlockNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setMenuCards(List<MenuCard> list) {
            this.menuCards = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setExtraAnalysisData(String str) {
            this.extraAnalysisData = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setIsDownloadApp(int i) {
            this.isDownloadApp = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setIsForumApp(int i) {
            this.isForumApp = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCommentStatus(int i) {
            this.commentStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCollectionInfo(Collection collection) {
            this.collectionInfo = collection;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCollectionItem(CollectionItem collectionItem2) {
            this.collectionItem = collectionItem2;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setHasCoupon(boolean z) {
            this.hasCoupon = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setExtraFromApi(String str) {
            this.extraFromApi = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setApkSubTitle(String str) {
            this.apkSubTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setCouponInfo(List<CouponInfo> list) {
            this.couponInfo = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setTabApiList(List<ConfigPage> list) {
            this.tabApiList = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setSelectedTab(String str) {
            this.selectedTab = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setHotNum(int i) {
            this.hotNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setBgColor(String str) {
            this.bgColor = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRequestContext(String str) {
            this.requestContext = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setRecommendRows(List<NewHeadLine> list) {
            this.recommendRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setTopIds(List<String> list) {
            this.topIds = list;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp.Builder setOpenLink(String str) {
            this.openLink = str;
            return this;
        }

        @Override // com.coolapk.market.model.ServiceApp.Builder
        public ServiceApp build() {
            String str = "";
            if (this.displayVersionName == null) {
                str = str + " displayVersionName";
            }
            if (this.versionName == null) {
                str = str + " versionName";
            }
            if (this.versionCode == null) {
                str = str + " versionCode";
            }
            if (this.apkSize == null) {
                str = str + " apkSize";
            }
            if (this.publicUpdate == null) {
                str = str + " publicUpdate";
            }
            if (this.apkLength == null) {
                str = str + " apkLength";
            }
            if (this.description == null) {
                str = str + " description";
            }
            if (this.recommend == null) {
                str = str + " recommend";
            }
            if (this.digest == null) {
                str = str + " digest";
            }
            if (this.logo == null) {
                str = str + " logo";
            }
            if (this.ratingStar == null) {
                str = str + " ratingStar";
            }
            if (this.supportAndroidVersion == null) {
                str = str + " supportAndroidVersion";
            }
            if (this.giftCount == null) {
                str = str + " giftCount";
            }
            if (this.votenum == null) {
                str = str + " votenum";
            }
            if (this.votenum1 == null) {
                str = str + " votenum1";
            }
            if (this.votenum2 == null) {
                str = str + " votenum2";
            }
            if (this.votenum3 == null) {
                str = str + " votenum3";
            }
            if (this.votenum4 == null) {
                str = str + " votenum4";
            }
            if (this.votenum5 == null) {
                str = str + " votenum5";
            }
            if (this.upDown == null) {
                str = str + " upDown";
            }
            if (this.commentBlockNum == null) {
                str = str + " commentBlockNum";
            }
            if (this.isDownloadApp == null) {
                str = str + " isDownloadApp";
            }
            if (this.isForumApp == null) {
                str = str + " isForumApp";
            }
            if (this.commentStatus == null) {
                str = str + " commentStatus";
            }
            if (this.hasCoupon == null) {
                str = str + " hasCoupon";
            }
            if (this.hotNum == null) {
                str = str + " hotNum";
            }
            if (this.recommendRows == null) {
                str = str + " recommendRows";
            }
            if (this.topIds == null) {
                str = str + " topIds";
            }
            if (str.isEmpty()) {
                return new AutoValue_ServiceApp(this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.pic, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.entityTypeName, this.packageName, this.targetId, this.apkType, this.displayVersionName, this.versionName, this.versionCode.intValue(), this.apkSize, this.publicUpdate.longValue(), this.apkLength.longValue(), this.extraFlag, this.description, this.recommend.intValue(), this.digest.intValue(), this.changeLog, this.logo, this.cover, this.followCount, this.commentCount, this.downCount, this.ratingStar.floatValue(), this.score, this.updateFlag, this.appName, this.apkRomVersion, this.thumbList, this.screenList, this.introduce, this.loginUserRate, this.remark, this.reviewer, this.supportAndroidVersion.intValue(), this.language, this.giftCount.intValue(), this.giftRows, this.votenum.intValue(), this.votenum1.intValue(), this.votenum2.intValue(), this.votenum3.intValue(), this.votenum4.intValue(), this.votenum5.intValue(), this.userAction, this.discoveryRows, this.followerRows, this.recentFollowList, this.ratingRows, this.categoryId, this.categoryName, this.tagList, this.apkUrl, this.developerName, this.permissions, this.developerRows, this.relatedRows, this.albumRows, this.keywords, this.upDown.intValue(), this.developerProfile, this.extendFile, this.extendName, this.changeHistory, this.commentBlockNum.intValue(), this.menuCards, this.extraAnalysisData, this.isDownloadApp.intValue(), this.isForumApp.intValue(), this.commentStatus.intValue(), this.collectionInfo, this.collectionItem, this.hasCoupon.booleanValue(), this.extraFromApi, this.apkSubTitle, this.couponInfo, this.tabApiList, this.selectedTab, this.hotNum.intValue(), this.bgColor, this.requestContext, this.recommendRows, this.topIds, this.openLink);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
