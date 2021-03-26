package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_UserProfile;
import com.coolapk.market.model.C$AutoValue_UserProfile;
import com.coolapk.market.model.IUser;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Locale;

public abstract class UserProfile implements Entity, IUser {
    public static final String HOME_TAB_CARD_ROWS = "homeTabCardRows";

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract UserProfile build();

        public abstract Builder setAlbumFavorNum(int i);

        public abstract Builder setAlbumNum(int i);

        public abstract Builder setApkCommentNum(int i);

        public abstract Builder setApkDevNum(int i);

        public abstract Builder setApkFollowNum(int i);

        public abstract Builder setApkRatingNum(int i);

        public abstract Builder setBeLikeNum(int i);

        public abstract Builder setBirthday(int i);

        public abstract Builder setBirthmonth(int i);

        public abstract Builder setBirthyear(int i);

        public abstract Builder setCity(String str);

        public abstract Builder setCover(String str);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setDiscoveryNum(int i);

        public abstract Builder setEMail(String str);

        public abstract Builder setEmailStatus(int i);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFansNum(int i);

        public abstract Builder setFeedNum(int i);

        public abstract Builder setFollowNum(int i);

        public abstract Builder setGender(int i);

        public abstract Builder setHomeTabCardRows(List<Entity> list);

        public abstract Builder setId(String str);

        public abstract Builder setIsDeveloper(int i);

        public abstract Builder setIsFans(int i);

        public abstract Builder setIsFollow(int i);

        public abstract Builder setIsInBlackList(int i);

        public abstract Builder setIsInIgnoreList(int i);

        public abstract Builder setIsInLimitList(int i);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLevel(int i);

        public abstract Builder setLevelDetailUrl(String str);

        public abstract Builder setLevelExperience(int i);

        public abstract Builder setLevelTodayMessage(String str);

        public abstract Builder setLoginTime(long j);

        public abstract Builder setLogo(String str);

        public abstract Builder setMobileStatus(int i);

        public abstract Builder setNextLevelExperience(int i);

        public abstract Builder setNextLevelPercentage(float f);

        public abstract Builder setPhoneNumber(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setProvince(String str);

        public abstract Builder setRegDate(long j);

        public abstract Builder setReplyNum(int i);

        public abstract Builder setSelectedTab(String str);

        public abstract Builder setSignature(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTips(Tips tips);

        public abstract Builder setTitle(String str);

        public abstract Builder setTopIds(List<String> list);

        public abstract Builder setUrl(String str);

        public abstract Builder setUserGroupName(String str);

        public abstract Builder setUserNameStatus(int i);

        public abstract Builder setVerifyIcon(String str);

        public abstract Builder setVerifyLabel(String str);

        public abstract Builder setVerifyStatus(int i);

        public abstract Builder setVerifyTitle(String str);

        public abstract Builder setWeibo(String str);

        public abstract Builder setZodiacSign(String str);
    }

    public abstract int getAlbumFavorNum();

    public abstract int getAlbumNum();

    public abstract int getApkCommentNum();

    public abstract int getApkDevNum();

    public abstract int getApkFollowNum();

    public abstract int getApkRatingNum();

    @SerializedName("be_like_num")
    public abstract int getBeLikeNum();

    public abstract int getBirthday();

    public abstract int getBirthmonth();

    public abstract int getBirthyear();

    @SerializedName("city")
    public abstract String getCity();

    @SerializedName("cover")
    public abstract String getCover();

    public abstract int getDiscoveryNum();

    @SerializedName("email")
    public abstract String getEMail();

    @SerializedName("emailstatus")
    public abstract int getEmailStatus();

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityType();

    @SerializedName("fans")
    public abstract int getFansNum();

    @SerializedName("feed")
    public abstract int getFeedNum();

    @SerializedName("follow")
    public abstract int getFollowNum();

    public abstract int getGender();

    @SerializedName("homeTabCardRows")
    public abstract List<Entity> getHomeTabCardRows();

    @SerializedName("isDeveloper")
    public abstract int getIsDeveloper();

    @SerializedName("isFans")
    public abstract int getIsFans();

    public abstract int getIsFollow();

    @SerializedName("isBlackList")
    public abstract int getIsInBlackList();

    @SerializedName("isIgnoreList")
    public abstract int getIsInIgnoreList();

    @SerializedName("isLimitList")
    public abstract int getIsInLimitList();

    public abstract int getLevel();

    @SerializedName("level_detail_url")
    public abstract String getLevelDetailUrl();

    @SerializedName("experience")
    public abstract int getLevelExperience();

    @SerializedName("level_today_message")
    public abstract String getLevelTodayMessage();

    @SerializedName("logintime")
    public abstract long getLoginTime();

    @SerializedName("mobilestatus")
    public abstract int getMobileStatus();

    @SerializedName("next_level_experience")
    public abstract int getNextLevelExperience();

    @SerializedName("next_level_percentage")
    public abstract float getNextLevelPercentage();

    @SerializedName("mobile")
    public abstract String getPhoneNumber();

    @SerializedName("province")
    public abstract String getProvince();

    @SerializedName("regdate")
    public abstract long getRegDate();

    @SerializedName("replyNum")
    public abstract int getReplyNum();

    @SerializedName("selectedTab")
    public abstract String getSelectedTab();

    @SerializedName("bio")
    public abstract String getSignature();

    @SerializedName("tips")
    public abstract Tips getTips();

    @SerializedName("top_ids")
    public abstract List<String> getTopIds();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public abstract String getUserGroupName();

    @SerializedName("usernamestatus")
    public abstract int getUserNameStatus();

    @SerializedName("verify_icon")
    public abstract String getVerifyIcon();

    @SerializedName("verify_label")
    public abstract String getVerifyLabel();

    @SerializedName("verify_status")
    public abstract int getVerifyStatus();

    @SerializedName("verify_title")
    public abstract String getVerifyTitle();

    @SerializedName("weibo")
    public abstract String getWeibo();

    @SerializedName("astro")
    public abstract String getZodiacSign();

    public static TypeAdapter<UserProfile> typeAdapter(Gson gson) {
        return new C$AutoValue_UserProfile.GsonTypeAdapter(gson);
    }

    public static Builder builder(UserProfile userProfile) {
        return new C$$AutoValue_UserProfile.Builder(userProfile);
    }

    public String getUserAvatar() {
        return IUser.IUserGetter.getUserAvatar(this);
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public String getAddressString() {
        if (TextUtils.equals(getProvince(), getCity())) {
            return StringUtils.emptyIfNull(getProvince());
        }
        return StringUtils.emptyIfNull(getProvince()) + " " + StringUtils.emptyIfNull(getCity());
    }

    public String getBirthDayString() {
        return (getBirthday() <= 0 || getBirthmonth() <= 0 || getBirthyear() <= 0) ? "" : String.format(Locale.getDefault(), "%d-%d-%d", Integer.valueOf(getBirthyear()), Integer.valueOf(getBirthmonth()), Integer.valueOf(getBirthday()));
    }

    public String getSingleBio() {
        return getSignature().replace("\n", "");
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getVerifyStatusIcon() {
        if (getVerifyStatus() == 1) {
            return getVerifyIcon();
        }
        return null;
    }
}
