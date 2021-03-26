package com.coolapk.market.model;

import com.coolapk.market.model.UserProfile;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_UserProfile  reason: invalid class name */
abstract class C$$AutoValue_UserProfile extends UserProfile {
    private final String EMail;
    private final int albumFavorNum;
    private final int albumNum;
    private final int apkCommentNum;
    private final int apkDevNum;
    private final int apkFollowNum;
    private final int apkRatingNum;
    private final int beLikeNum;
    private final int birthday;
    private final int birthmonth;
    private final int birthyear;
    private final String city;
    private final String cover;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final int discoveryNum;
    private final String displayUserName;
    private final int emailStatus;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final int fansNum;
    private final int feedNum;
    private final int followNum;
    private final int gender;
    private final List<Entity> homeTabCardRows;
    private final String id;
    private final int isDeveloper;
    private final int isFans;
    private final int isFollow;
    private final int isInBlackList;
    private final int isInIgnoreList;
    private final int isInLimitList;
    private final Long lastUpdate;
    private final int level;
    private final String levelDetailUrl;
    private final int levelExperience;
    private final String levelTodayMessage;
    private final long loginTime;
    private final String logo;
    private final int mobileStatus;
    private final int nextLevelExperience;
    private final float nextLevelPercentage;
    private final String phoneNumber;
    private final String pic;
    private final String province;
    private final long regDate;
    private final int replyNum;
    private final String selectedTab;
    private final String signature;
    private final String subTitle;
    private final Tips tips;
    private final String title;
    private final List<String> topIds;
    private final String uid;
    private final String url;
    private final String userGroupName;
    private final UserInfo userInfo;
    private final int userNameStatus;
    private final String verifyIcon;
    private final String verifyLabel;
    private final int verifyStatus;
    private final String verifyTitle;
    private final String weibo;
    private final String zodiacSign;

    C$$AutoValue_UserProfile(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, UserInfo userInfo2, String str13, String str14, String str15, int i, String str16, String str17, int i2, String str18, int i3, int i4, float f, String str19, String str20, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str21, String str22, String str23, String str24, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, String str25, String str26, int i25, int i26, long j, long j2, int i27, List<Entity> list, String str27, String str28, int i28, Tips tips2, int i29, String str29, String str30, String str31, List<String> list2) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.id = str10;
        this.extraData = str11;
        this.dateline = l;
        this.lastUpdate = l2;
        this.deprecatedUserAvatar = str12;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str13;
        this.displayUserName = str14;
        Objects.requireNonNull(str15, "Null uid");
        this.uid = str15;
        this.gender = i;
        this.userGroupName = str16;
        this.EMail = str17;
        this.level = i2;
        this.signature = str18;
        this.levelExperience = i3;
        this.nextLevelExperience = i4;
        this.nextLevelPercentage = f;
        this.levelTodayMessage = str19;
        this.levelDetailUrl = str20;
        this.apkFollowNum = i5;
        this.apkCommentNum = i6;
        this.apkRatingNum = i7;
        this.albumNum = i8;
        this.albumFavorNum = i9;
        this.discoveryNum = i10;
        this.isFollow = i11;
        this.beLikeNum = i12;
        this.feedNum = i13;
        this.followNum = i14;
        this.fansNum = i15;
        this.isDeveloper = i16;
        this.weibo = str21;
        this.city = str22;
        this.province = str23;
        this.cover = str24;
        this.birthday = i17;
        this.birthmonth = i18;
        this.birthyear = i19;
        this.apkDevNum = i20;
        this.replyNum = i21;
        this.isInBlackList = i22;
        this.isInIgnoreList = i23;
        this.isInLimitList = i24;
        this.phoneNumber = str25;
        this.zodiacSign = str26;
        this.mobileStatus = i25;
        this.emailStatus = i26;
        this.regDate = j;
        this.loginTime = j2;
        this.isFans = i27;
        Objects.requireNonNull(list, "Null homeTabCardRows");
        this.homeTabCardRows = list;
        this.selectedTab = str27;
        this.entityType = str28;
        this.userNameStatus = i28;
        this.tips = tips2;
        this.verifyStatus = i29;
        this.verifyIcon = str29;
        this.verifyLabel = str30;
        this.verifyTitle = str31;
        Objects.requireNonNull(list2, "Null topIds");
        this.topIds = list2;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
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
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
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

    @Override // com.coolapk.market.model.IUser
    @SerializedName("userAvatar")
    public String getDeprecatedUserAvatar() {
        return this.deprecatedUserAvatar;
    }

    @Override // com.coolapk.market.model.IUser
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.UserProfile, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getGender() {
        return this.gender;
    }

    @Override // com.coolapk.market.model.UserProfile
    public String getUserGroupName() {
        return this.userGroupName;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("email")
    public String getEMail() {
        return this.EMail;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getLevel() {
        return this.level;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("bio")
    public String getSignature() {
        return this.signature;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("experience")
    public int getLevelExperience() {
        return this.levelExperience;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("next_level_experience")
    public int getNextLevelExperience() {
        return this.nextLevelExperience;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("next_level_percentage")
    public float getNextLevelPercentage() {
        return this.nextLevelPercentage;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("level_today_message")
    public String getLevelTodayMessage() {
        return this.levelTodayMessage;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("level_detail_url")
    public String getLevelDetailUrl() {
        return this.levelDetailUrl;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getApkFollowNum() {
        return this.apkFollowNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getApkCommentNum() {
        return this.apkCommentNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getApkRatingNum() {
        return this.apkRatingNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getAlbumNum() {
        return this.albumNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getAlbumFavorNum() {
        return this.albumFavorNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getDiscoveryNum() {
        return this.discoveryNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getIsFollow() {
        return this.isFollow;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("be_like_num")
    public int getBeLikeNum() {
        return this.beLikeNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("feed")
    public int getFeedNum() {
        return this.feedNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("follow")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("fans")
    public int getFansNum() {
        return this.fansNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("isDeveloper")
    public int getIsDeveloper() {
        return this.isDeveloper;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("weibo")
    public String getWeibo() {
        return this.weibo;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("city")
    public String getCity() {
        return this.city;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("province")
    public String getProvince() {
        return this.province;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("cover")
    public String getCover() {
        return this.cover;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getBirthday() {
        return this.birthday;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getBirthmonth() {
        return this.birthmonth;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getBirthyear() {
        return this.birthyear;
    }

    @Override // com.coolapk.market.model.UserProfile
    public int getApkDevNum() {
        return this.apkDevNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("replyNum")
    public int getReplyNum() {
        return this.replyNum;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("isBlackList")
    public int getIsInBlackList() {
        return this.isInBlackList;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("isIgnoreList")
    public int getIsInIgnoreList() {
        return this.isInIgnoreList;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("isLimitList")
    public int getIsInLimitList() {
        return this.isInLimitList;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("mobile")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("astro")
    public String getZodiacSign() {
        return this.zodiacSign;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("mobilestatus")
    public int getMobileStatus() {
        return this.mobileStatus;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("emailstatus")
    public int getEmailStatus() {
        return this.emailStatus;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("regdate")
    public long getRegDate() {
        return this.regDate;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("logintime")
    public long getLoginTime() {
        return this.loginTime;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("isFans")
    public int getIsFans() {
        return this.isFans;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("homeTabCardRows")
    public List<Entity> getHomeTabCardRows() {
        return this.homeTabCardRows;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("selectedTab")
    public String getSelectedTab() {
        return this.selectedTab;
    }

    @Override // com.coolapk.market.model.UserProfile, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("usernamestatus")
    public int getUserNameStatus() {
        return this.userNameStatus;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("tips")
    public Tips getTips() {
        return this.tips;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("verify_status")
    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("verify_icon")
    public String getVerifyIcon() {
        return this.verifyIcon;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("verify_label")
    public String getVerifyLabel() {
        return this.verifyLabel;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("verify_title")
    public String getVerifyTitle() {
        return this.verifyTitle;
    }

    @Override // com.coolapk.market.model.UserProfile
    @SerializedName("top_ids")
    public List<String> getTopIds() {
        return this.topIds;
    }

    @Override // java.lang.Object
    public String toString() {
        return "UserProfile{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", uid=" + this.uid + ", gender=" + this.gender + ", userGroupName=" + this.userGroupName + ", EMail=" + this.EMail + ", level=" + this.level + ", signature=" + this.signature + ", levelExperience=" + this.levelExperience + ", nextLevelExperience=" + this.nextLevelExperience + ", nextLevelPercentage=" + this.nextLevelPercentage + ", levelTodayMessage=" + this.levelTodayMessage + ", levelDetailUrl=" + this.levelDetailUrl + ", apkFollowNum=" + this.apkFollowNum + ", apkCommentNum=" + this.apkCommentNum + ", apkRatingNum=" + this.apkRatingNum + ", albumNum=" + this.albumNum + ", albumFavorNum=" + this.albumFavorNum + ", discoveryNum=" + this.discoveryNum + ", isFollow=" + this.isFollow + ", beLikeNum=" + this.beLikeNum + ", feedNum=" + this.feedNum + ", followNum=" + this.followNum + ", fansNum=" + this.fansNum + ", isDeveloper=" + this.isDeveloper + ", weibo=" + this.weibo + ", city=" + this.city + ", province=" + this.province + ", cover=" + this.cover + ", birthday=" + this.birthday + ", birthmonth=" + this.birthmonth + ", birthyear=" + this.birthyear + ", apkDevNum=" + this.apkDevNum + ", replyNum=" + this.replyNum + ", isInBlackList=" + this.isInBlackList + ", isInIgnoreList=" + this.isInIgnoreList + ", isInLimitList=" + this.isInLimitList + ", phoneNumber=" + this.phoneNumber + ", zodiacSign=" + this.zodiacSign + ", mobileStatus=" + this.mobileStatus + ", emailStatus=" + this.emailStatus + ", regDate=" + this.regDate + ", loginTime=" + this.loginTime + ", isFans=" + this.isFans + ", homeTabCardRows=" + this.homeTabCardRows + ", selectedTab=" + this.selectedTab + ", entityType=" + this.entityType + ", userNameStatus=" + this.userNameStatus + ", tips=" + this.tips + ", verifyStatus=" + this.verifyStatus + ", verifyIcon=" + this.verifyIcon + ", verifyLabel=" + this.verifyLabel + ", verifyTitle=" + this.verifyTitle + ", topIds=" + this.topIds + "}";
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
        String str11;
        String str12;
        String str13;
        Tips tips2;
        String str14;
        String str15;
        String str16;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserProfile)) {
            return false;
        }
        UserProfile userProfile = (UserProfile) obj;
        String str17 = this.entityTypeName;
        if (str17 != null ? str17.equals(userProfile.getEntityTypeName()) : userProfile.getEntityTypeName() == null) {
            String str18 = this.entityTemplate;
            if (str18 != null ? str18.equals(userProfile.getEntityTemplate()) : userProfile.getEntityTemplate() == null) {
                String str19 = this.entityId;
                if (str19 != null ? str19.equals(userProfile.getEntityId()) : userProfile.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(userProfile.getEntityFixed()) : userProfile.getEntityFixed() == null) {
                        String str20 = this.title;
                        if (str20 != null ? str20.equals(userProfile.getTitle()) : userProfile.getTitle() == null) {
                            String str21 = this.url;
                            if (str21 != null ? str21.equals(userProfile.getUrl()) : userProfile.getUrl() == null) {
                                String str22 = this.description;
                                if (str22 != null ? str22.equals(userProfile.getDescription()) : userProfile.getDescription() == null) {
                                    String str23 = this.pic;
                                    if (str23 != null ? str23.equals(userProfile.getPic()) : userProfile.getPic() == null) {
                                        String str24 = this.logo;
                                        if (str24 != null ? str24.equals(userProfile.getLogo()) : userProfile.getLogo() == null) {
                                            String str25 = this.subTitle;
                                            if (str25 != null ? str25.equals(userProfile.getSubTitle()) : userProfile.getSubTitle() == null) {
                                                String str26 = this.id;
                                                if (str26 != null ? str26.equals(userProfile.getId()) : userProfile.getId() == null) {
                                                    String str27 = this.extraData;
                                                    if (str27 != null ? str27.equals(userProfile.getExtraData()) : userProfile.getExtraData() == null) {
                                                        Long l = this.dateline;
                                                        if (l != null ? l.equals(userProfile.getDateline()) : userProfile.getDateline() == null) {
                                                            Long l2 = this.lastUpdate;
                                                            if (l2 != null ? l2.equals(userProfile.getLastUpdate()) : userProfile.getLastUpdate() == null) {
                                                                String str28 = this.deprecatedUserAvatar;
                                                                if (str28 != null ? str28.equals(userProfile.getDeprecatedUserAvatar()) : userProfile.getDeprecatedUserAvatar() == null) {
                                                                    UserInfo userInfo2 = this.userInfo;
                                                                    if (userInfo2 != null ? userInfo2.equals(userProfile.getUserInfo()) : userProfile.getUserInfo() == null) {
                                                                        String str29 = this.deprecatedUserName;
                                                                        if (str29 != null ? str29.equals(userProfile.getDeprecatedUserName()) : userProfile.getDeprecatedUserName() == null) {
                                                                            String str30 = this.displayUserName;
                                                                            if (str30 != null ? str30.equals(userProfile.getDisplayUserName()) : userProfile.getDisplayUserName() == null) {
                                                                                if (this.uid.equals(userProfile.getUid()) && this.gender == userProfile.getGender() && ((str = this.userGroupName) != null ? str.equals(userProfile.getUserGroupName()) : userProfile.getUserGroupName() == null) && ((str2 = this.EMail) != null ? str2.equals(userProfile.getEMail()) : userProfile.getEMail() == null) && this.level == userProfile.getLevel() && ((str3 = this.signature) != null ? str3.equals(userProfile.getSignature()) : userProfile.getSignature() == null) && this.levelExperience == userProfile.getLevelExperience() && this.nextLevelExperience == userProfile.getNextLevelExperience() && Float.floatToIntBits(this.nextLevelPercentage) == Float.floatToIntBits(userProfile.getNextLevelPercentage()) && ((str4 = this.levelTodayMessage) != null ? str4.equals(userProfile.getLevelTodayMessage()) : userProfile.getLevelTodayMessage() == null) && ((str5 = this.levelDetailUrl) != null ? str5.equals(userProfile.getLevelDetailUrl()) : userProfile.getLevelDetailUrl() == null) && this.apkFollowNum == userProfile.getApkFollowNum() && this.apkCommentNum == userProfile.getApkCommentNum() && this.apkRatingNum == userProfile.getApkRatingNum() && this.albumNum == userProfile.getAlbumNum() && this.albumFavorNum == userProfile.getAlbumFavorNum() && this.discoveryNum == userProfile.getDiscoveryNum() && this.isFollow == userProfile.getIsFollow() && this.beLikeNum == userProfile.getBeLikeNum() && this.feedNum == userProfile.getFeedNum() && this.followNum == userProfile.getFollowNum() && this.fansNum == userProfile.getFansNum() && this.isDeveloper == userProfile.getIsDeveloper() && ((str6 = this.weibo) != null ? str6.equals(userProfile.getWeibo()) : userProfile.getWeibo() == null) && ((str7 = this.city) != null ? str7.equals(userProfile.getCity()) : userProfile.getCity() == null) && ((str8 = this.province) != null ? str8.equals(userProfile.getProvince()) : userProfile.getProvince() == null) && ((str9 = this.cover) != null ? str9.equals(userProfile.getCover()) : userProfile.getCover() == null) && this.birthday == userProfile.getBirthday() && this.birthmonth == userProfile.getBirthmonth() && this.birthyear == userProfile.getBirthyear() && this.apkDevNum == userProfile.getApkDevNum() && this.replyNum == userProfile.getReplyNum() && this.isInBlackList == userProfile.getIsInBlackList() && this.isInIgnoreList == userProfile.getIsInIgnoreList() && this.isInLimitList == userProfile.getIsInLimitList() && ((str10 = this.phoneNumber) != null ? str10.equals(userProfile.getPhoneNumber()) : userProfile.getPhoneNumber() == null) && ((str11 = this.zodiacSign) != null ? str11.equals(userProfile.getZodiacSign()) : userProfile.getZodiacSign() == null) && this.mobileStatus == userProfile.getMobileStatus() && this.emailStatus == userProfile.getEmailStatus() && this.regDate == userProfile.getRegDate() && this.loginTime == userProfile.getLoginTime() && this.isFans == userProfile.getIsFans() && this.homeTabCardRows.equals(userProfile.getHomeTabCardRows()) && ((str12 = this.selectedTab) != null ? str12.equals(userProfile.getSelectedTab()) : userProfile.getSelectedTab() == null) && ((str13 = this.entityType) != null ? str13.equals(userProfile.getEntityType()) : userProfile.getEntityType() == null) && this.userNameStatus == userProfile.getUserNameStatus() && ((tips2 = this.tips) != null ? tips2.equals(userProfile.getTips()) : userProfile.getTips() == null) && this.verifyStatus == userProfile.getVerifyStatus() && ((str14 = this.verifyIcon) != null ? str14.equals(userProfile.getVerifyIcon()) : userProfile.getVerifyIcon() == null) && ((str15 = this.verifyLabel) != null ? str15.equals(userProfile.getVerifyLabel()) : userProfile.getVerifyLabel() == null) && ((str16 = this.verifyTitle) != null ? str16.equals(userProfile.getVerifyTitle()) : userProfile.getVerifyTitle() == null) && this.topIds.equals(userProfile.getTopIds())) {
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
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.url;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.description;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.id;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode13 = (hashCode12 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode14 = (hashCode13 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str12 = this.deprecatedUserAvatar;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode16 = (hashCode15 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str13 = this.deprecatedUserName;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.displayUserName;
        int hashCode18 = (((((hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.gender) * 1000003;
        String str15 = this.userGroupName;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.EMail;
        int hashCode20 = (((hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.level) * 1000003;
        String str17 = this.signature;
        int hashCode21 = (((((((hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003) ^ this.levelExperience) * 1000003) ^ this.nextLevelExperience) * 1000003) ^ Float.floatToIntBits(this.nextLevelPercentage)) * 1000003;
        String str18 = this.levelTodayMessage;
        int hashCode22 = (hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.levelDetailUrl;
        int hashCode23 = (((((((((((((((((((((((((hashCode22 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003) ^ this.apkFollowNum) * 1000003) ^ this.apkCommentNum) * 1000003) ^ this.apkRatingNum) * 1000003) ^ this.albumNum) * 1000003) ^ this.albumFavorNum) * 1000003) ^ this.discoveryNum) * 1000003) ^ this.isFollow) * 1000003) ^ this.beLikeNum) * 1000003) ^ this.feedNum) * 1000003) ^ this.followNum) * 1000003) ^ this.fansNum) * 1000003) ^ this.isDeveloper) * 1000003;
        String str20 = this.weibo;
        int hashCode24 = (hashCode23 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.city;
        int hashCode25 = (hashCode24 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        String str22 = this.province;
        int hashCode26 = (hashCode25 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
        String str23 = this.cover;
        int hashCode27 = (((((((((((((((((hashCode26 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003) ^ this.birthday) * 1000003) ^ this.birthmonth) * 1000003) ^ this.birthyear) * 1000003) ^ this.apkDevNum) * 1000003) ^ this.replyNum) * 1000003) ^ this.isInBlackList) * 1000003) ^ this.isInIgnoreList) * 1000003) ^ this.isInLimitList) * 1000003;
        String str24 = this.phoneNumber;
        int hashCode28 = (hashCode27 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.zodiacSign;
        int hashCode29 = str25 == null ? 0 : str25.hashCode();
        long j = this.regDate;
        long j2 = this.loginTime;
        int hashCode30 = ((((((int) (((long) (((int) (((long) ((((((hashCode28 ^ hashCode29) * 1000003) ^ this.mobileStatus) * 1000003) ^ this.emailStatus) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.isFans) * 1000003) ^ this.homeTabCardRows.hashCode()) * 1000003;
        String str26 = this.selectedTab;
        int hashCode31 = (hashCode30 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
        String str27 = this.entityType;
        int hashCode32 = (((hashCode31 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003) ^ this.userNameStatus) * 1000003;
        Tips tips2 = this.tips;
        int hashCode33 = (((hashCode32 ^ (tips2 == null ? 0 : tips2.hashCode())) * 1000003) ^ this.verifyStatus) * 1000003;
        String str28 = this.verifyIcon;
        int hashCode34 = (hashCode33 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
        String str29 = this.verifyLabel;
        int hashCode35 = (hashCode34 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
        String str30 = this.verifyTitle;
        if (str30 != null) {
            i = str30.hashCode();
        }
        return ((hashCode35 ^ i) * 1000003) ^ this.topIds.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_UserProfile$Builder */
    /* compiled from: $$AutoValue_UserProfile */
    static final class Builder extends UserProfile.Builder {
        private String EMail;
        private Integer albumFavorNum;
        private Integer albumNum;
        private Integer apkCommentNum;
        private Integer apkDevNum;
        private Integer apkFollowNum;
        private Integer apkRatingNum;
        private Integer beLikeNum;
        private Integer birthday;
        private Integer birthmonth;
        private Integer birthyear;
        private String city;
        private String cover;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private Integer discoveryNum;
        private String displayUserName;
        private Integer emailStatus;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private Integer fansNum;
        private Integer feedNum;
        private Integer followNum;
        private Integer gender;
        private List<Entity> homeTabCardRows;
        private String id;
        private Integer isDeveloper;
        private Integer isFans;
        private Integer isFollow;
        private Integer isInBlackList;
        private Integer isInIgnoreList;
        private Integer isInLimitList;
        private Long lastUpdate;
        private Integer level;
        private String levelDetailUrl;
        private Integer levelExperience;
        private String levelTodayMessage;
        private Long loginTime;
        private String logo;
        private Integer mobileStatus;
        private Integer nextLevelExperience;
        private Float nextLevelPercentage;
        private String phoneNumber;
        private String pic;
        private String province;
        private Long regDate;
        private Integer replyNum;
        private String selectedTab;
        private String signature;
        private String subTitle;
        private Tips tips;
        private String title;
        private List<String> topIds;
        private String uid;
        private String url;
        private String userGroupName;
        private UserInfo userInfo;
        private Integer userNameStatus;
        private String verifyIcon;
        private String verifyLabel;
        private Integer verifyStatus;
        private String verifyTitle;
        private String weibo;
        private String zodiacSign;

        Builder() {
        }

        Builder(UserProfile userProfile) {
            this.entityTypeName = userProfile.getEntityTypeName();
            this.entityTemplate = userProfile.getEntityTemplate();
            this.entityId = userProfile.getEntityId();
            this.entityFixed = userProfile.getEntityFixed();
            this.title = userProfile.getTitle();
            this.url = userProfile.getUrl();
            this.description = userProfile.getDescription();
            this.pic = userProfile.getPic();
            this.logo = userProfile.getLogo();
            this.subTitle = userProfile.getSubTitle();
            this.id = userProfile.getId();
            this.extraData = userProfile.getExtraData();
            this.dateline = userProfile.getDateline();
            this.lastUpdate = userProfile.getLastUpdate();
            this.deprecatedUserAvatar = userProfile.getDeprecatedUserAvatar();
            this.userInfo = userProfile.getUserInfo();
            this.deprecatedUserName = userProfile.getDeprecatedUserName();
            this.displayUserName = userProfile.getDisplayUserName();
            this.uid = userProfile.getUid();
            this.gender = Integer.valueOf(userProfile.getGender());
            this.userGroupName = userProfile.getUserGroupName();
            this.EMail = userProfile.getEMail();
            this.level = Integer.valueOf(userProfile.getLevel());
            this.signature = userProfile.getSignature();
            this.levelExperience = Integer.valueOf(userProfile.getLevelExperience());
            this.nextLevelExperience = Integer.valueOf(userProfile.getNextLevelExperience());
            this.nextLevelPercentage = Float.valueOf(userProfile.getNextLevelPercentage());
            this.levelTodayMessage = userProfile.getLevelTodayMessage();
            this.levelDetailUrl = userProfile.getLevelDetailUrl();
            this.apkFollowNum = Integer.valueOf(userProfile.getApkFollowNum());
            this.apkCommentNum = Integer.valueOf(userProfile.getApkCommentNum());
            this.apkRatingNum = Integer.valueOf(userProfile.getApkRatingNum());
            this.albumNum = Integer.valueOf(userProfile.getAlbumNum());
            this.albumFavorNum = Integer.valueOf(userProfile.getAlbumFavorNum());
            this.discoveryNum = Integer.valueOf(userProfile.getDiscoveryNum());
            this.isFollow = Integer.valueOf(userProfile.getIsFollow());
            this.beLikeNum = Integer.valueOf(userProfile.getBeLikeNum());
            this.feedNum = Integer.valueOf(userProfile.getFeedNum());
            this.followNum = Integer.valueOf(userProfile.getFollowNum());
            this.fansNum = Integer.valueOf(userProfile.getFansNum());
            this.isDeveloper = Integer.valueOf(userProfile.getIsDeveloper());
            this.weibo = userProfile.getWeibo();
            this.city = userProfile.getCity();
            this.province = userProfile.getProvince();
            this.cover = userProfile.getCover();
            this.birthday = Integer.valueOf(userProfile.getBirthday());
            this.birthmonth = Integer.valueOf(userProfile.getBirthmonth());
            this.birthyear = Integer.valueOf(userProfile.getBirthyear());
            this.apkDevNum = Integer.valueOf(userProfile.getApkDevNum());
            this.replyNum = Integer.valueOf(userProfile.getReplyNum());
            this.isInBlackList = Integer.valueOf(userProfile.getIsInBlackList());
            this.isInIgnoreList = Integer.valueOf(userProfile.getIsInIgnoreList());
            this.isInLimitList = Integer.valueOf(userProfile.getIsInLimitList());
            this.phoneNumber = userProfile.getPhoneNumber();
            this.zodiacSign = userProfile.getZodiacSign();
            this.mobileStatus = Integer.valueOf(userProfile.getMobileStatus());
            this.emailStatus = Integer.valueOf(userProfile.getEmailStatus());
            this.regDate = Long.valueOf(userProfile.getRegDate());
            this.loginTime = Long.valueOf(userProfile.getLoginTime());
            this.isFans = Integer.valueOf(userProfile.getIsFans());
            this.homeTabCardRows = userProfile.getHomeTabCardRows();
            this.selectedTab = userProfile.getSelectedTab();
            this.entityType = userProfile.getEntityType();
            this.userNameStatus = Integer.valueOf(userProfile.getUserNameStatus());
            this.tips = userProfile.getTips();
            this.verifyStatus = Integer.valueOf(userProfile.getVerifyStatus());
            this.verifyIcon = userProfile.getVerifyIcon();
            this.verifyLabel = userProfile.getVerifyLabel();
            this.verifyTitle = userProfile.getVerifyTitle();
            this.topIds = userProfile.getTopIds();
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserProfile.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserProfile.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserProfile.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserProfile.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserProfile.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setGender(int i) {
            this.gender = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setUserGroupName(String str) {
            this.userGroupName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEMail(String str) {
            this.EMail = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLevel(int i) {
            this.level = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setSignature(String str) {
            this.signature = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLevelExperience(int i) {
            this.levelExperience = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setNextLevelExperience(int i) {
            this.nextLevelExperience = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setNextLevelPercentage(float f) {
            this.nextLevelPercentage = Float.valueOf(f);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLevelTodayMessage(String str) {
            this.levelTodayMessage = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLevelDetailUrl(String str) {
            this.levelDetailUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setApkFollowNum(int i) {
            this.apkFollowNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setApkCommentNum(int i) {
            this.apkCommentNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setApkRatingNum(int i) {
            this.apkRatingNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setAlbumNum(int i) {
            this.albumNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setAlbumFavorNum(int i) {
            this.albumFavorNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setDiscoveryNum(int i) {
            this.discoveryNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setIsFollow(int i) {
            this.isFollow = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setBeLikeNum(int i) {
            this.beLikeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setFeedNum(int i) {
            this.feedNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setFollowNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setFansNum(int i) {
            this.fansNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setIsDeveloper(int i) {
            this.isDeveloper = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setWeibo(String str) {
            this.weibo = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setCity(String str) {
            this.city = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setProvince(String str) {
            this.province = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setCover(String str) {
            this.cover = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setBirthday(int i) {
            this.birthday = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setBirthmonth(int i) {
            this.birthmonth = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setBirthyear(int i) {
            this.birthyear = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setApkDevNum(int i) {
            this.apkDevNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setReplyNum(int i) {
            this.replyNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setIsInBlackList(int i) {
            this.isInBlackList = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setIsInIgnoreList(int i) {
            this.isInIgnoreList = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setIsInLimitList(int i) {
            this.isInLimitList = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setPhoneNumber(String str) {
            this.phoneNumber = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setZodiacSign(String str) {
            this.zodiacSign = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setMobileStatus(int i) {
            this.mobileStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEmailStatus(int i) {
            this.emailStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setRegDate(long j) {
            this.regDate = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setLoginTime(long j) {
            this.loginTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setIsFans(int i) {
            this.isFans = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setHomeTabCardRows(List<Entity> list) {
            this.homeTabCardRows = list;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setSelectedTab(String str) {
            this.selectedTab = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setUserNameStatus(int i) {
            this.userNameStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setTips(Tips tips2) {
            this.tips = tips2;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setVerifyStatus(int i) {
            this.verifyStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setVerifyIcon(String str) {
            this.verifyIcon = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setVerifyLabel(String str) {
            this.verifyLabel = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setVerifyTitle(String str) {
            this.verifyTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile.Builder setTopIds(List<String> list) {
            this.topIds = list;
            return this;
        }

        @Override // com.coolapk.market.model.UserProfile.Builder
        public UserProfile build() {
            String str = "";
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.gender == null) {
                str = str + " gender";
            }
            if (this.level == null) {
                str = str + " level";
            }
            if (this.levelExperience == null) {
                str = str + " levelExperience";
            }
            if (this.nextLevelExperience == null) {
                str = str + " nextLevelExperience";
            }
            if (this.nextLevelPercentage == null) {
                str = str + " nextLevelPercentage";
            }
            if (this.apkFollowNum == null) {
                str = str + " apkFollowNum";
            }
            if (this.apkCommentNum == null) {
                str = str + " apkCommentNum";
            }
            if (this.apkRatingNum == null) {
                str = str + " apkRatingNum";
            }
            if (this.albumNum == null) {
                str = str + " albumNum";
            }
            if (this.albumFavorNum == null) {
                str = str + " albumFavorNum";
            }
            if (this.discoveryNum == null) {
                str = str + " discoveryNum";
            }
            if (this.isFollow == null) {
                str = str + " isFollow";
            }
            if (this.beLikeNum == null) {
                str = str + " beLikeNum";
            }
            if (this.feedNum == null) {
                str = str + " feedNum";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.fansNum == null) {
                str = str + " fansNum";
            }
            if (this.isDeveloper == null) {
                str = str + " isDeveloper";
            }
            if (this.birthday == null) {
                str = str + " birthday";
            }
            if (this.birthmonth == null) {
                str = str + " birthmonth";
            }
            if (this.birthyear == null) {
                str = str + " birthyear";
            }
            if (this.apkDevNum == null) {
                str = str + " apkDevNum";
            }
            if (this.replyNum == null) {
                str = str + " replyNum";
            }
            if (this.isInBlackList == null) {
                str = str + " isInBlackList";
            }
            if (this.isInIgnoreList == null) {
                str = str + " isInIgnoreList";
            }
            if (this.isInLimitList == null) {
                str = str + " isInLimitList";
            }
            if (this.mobileStatus == null) {
                str = str + " mobileStatus";
            }
            if (this.emailStatus == null) {
                str = str + " emailStatus";
            }
            if (this.regDate == null) {
                str = str + " regDate";
            }
            if (this.loginTime == null) {
                str = str + " loginTime";
            }
            if (this.isFans == null) {
                str = str + " isFans";
            }
            if (this.homeTabCardRows == null) {
                str = str + " homeTabCardRows";
            }
            if (this.userNameStatus == null) {
                str = str + " userNameStatus";
            }
            if (this.verifyStatus == null) {
                str = str + " verifyStatus";
            }
            if (this.topIds == null) {
                str = str + " topIds";
            }
            if (str.isEmpty()) {
                return new AutoValue_UserProfile(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.uid, this.gender.intValue(), this.userGroupName, this.EMail, this.level.intValue(), this.signature, this.levelExperience.intValue(), this.nextLevelExperience.intValue(), this.nextLevelPercentage.floatValue(), this.levelTodayMessage, this.levelDetailUrl, this.apkFollowNum.intValue(), this.apkCommentNum.intValue(), this.apkRatingNum.intValue(), this.albumNum.intValue(), this.albumFavorNum.intValue(), this.discoveryNum.intValue(), this.isFollow.intValue(), this.beLikeNum.intValue(), this.feedNum.intValue(), this.followNum.intValue(), this.fansNum.intValue(), this.isDeveloper.intValue(), this.weibo, this.city, this.province, this.cover, this.birthday.intValue(), this.birthmonth.intValue(), this.birthyear.intValue(), this.apkDevNum.intValue(), this.replyNum.intValue(), this.isInBlackList.intValue(), this.isInIgnoreList.intValue(), this.isInLimitList.intValue(), this.phoneNumber, this.zodiacSign, this.mobileStatus.intValue(), this.emailStatus.intValue(), this.regDate.longValue(), this.loginTime.longValue(), this.isFans.intValue(), this.homeTabCardRows, this.selectedTab, this.entityType, this.userNameStatus.intValue(), this.tips, this.verifyStatus.intValue(), this.verifyIcon, this.verifyLabel, this.verifyTitle, this.topIds);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
