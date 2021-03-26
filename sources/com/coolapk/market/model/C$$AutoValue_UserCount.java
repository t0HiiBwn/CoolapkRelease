package com.coolapk.market.model;

import com.coolapk.market.model.UserCount;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_UserCount  reason: invalid class name */
abstract class C$$AutoValue_UserCount extends UserCount {
    private final int atMeCount;
    private final int atMeInCommentCount;
    private final int badge;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final int fans;
    private final int feed;
    private final int follow;
    private final int followApp;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final int message;
    private final int notification;
    private final String pic;
    private final int replyMeCount;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_UserCount(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, UserInfo userInfo2, String str13, String str14, String str15, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
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
        this.uid = str15;
        this.followApp = i;
        this.feed = i2;
        this.follow = i3;
        this.fans = i4;
        this.notification = i5;
        this.message = i6;
        this.atMeCount = i7;
        this.atMeInCommentCount = i8;
        this.replyMeCount = i9;
        this.badge = i10;
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

    @Override // com.coolapk.market.model.UserCount, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("count2")
    public int getFollowApp() {
        return this.followApp;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("feed")
    public int getFeed() {
        return this.feed;
    }

    @Override // com.coolapk.market.model.UserCount
    public int getFollow() {
        return this.follow;
    }

    @Override // com.coolapk.market.model.UserCount
    public int getFans() {
        return this.fans;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("notification")
    public int getNotification() {
        return this.notification;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("message")
    public int getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("atme")
    public int getAtMeCount() {
        return this.atMeCount;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("atcommentme")
    public int getAtMeInCommentCount() {
        return this.atMeInCommentCount;
    }

    @Override // com.coolapk.market.model.UserCount
    @SerializedName("commentme")
    public int getReplyMeCount() {
        return this.replyMeCount;
    }

    @Override // com.coolapk.market.model.UserCount
    public int getBadge() {
        return this.badge;
    }

    @Override // java.lang.Object
    public String toString() {
        return "UserCount{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", uid=" + this.uid + ", followApp=" + this.followApp + ", feed=" + this.feed + ", follow=" + this.follow + ", fans=" + this.fans + ", notification=" + this.notification + ", message=" + this.message + ", atMeCount=" + this.atMeCount + ", atMeInCommentCount=" + this.atMeInCommentCount + ", replyMeCount=" + this.replyMeCount + ", badge=" + this.badge + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserCount)) {
            return false;
        }
        UserCount userCount = (UserCount) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(userCount.getEntityTypeName()) : userCount.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(userCount.getEntityTemplate()) : userCount.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(userCount.getEntityId()) : userCount.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(userCount.getEntityFixed()) : userCount.getEntityFixed() == null) {
                        String str4 = this.title;
                        if (str4 != null ? str4.equals(userCount.getTitle()) : userCount.getTitle() == null) {
                            String str5 = this.url;
                            if (str5 != null ? str5.equals(userCount.getUrl()) : userCount.getUrl() == null) {
                                String str6 = this.description;
                                if (str6 != null ? str6.equals(userCount.getDescription()) : userCount.getDescription() == null) {
                                    String str7 = this.pic;
                                    if (str7 != null ? str7.equals(userCount.getPic()) : userCount.getPic() == null) {
                                        String str8 = this.logo;
                                        if (str8 != null ? str8.equals(userCount.getLogo()) : userCount.getLogo() == null) {
                                            String str9 = this.subTitle;
                                            if (str9 != null ? str9.equals(userCount.getSubTitle()) : userCount.getSubTitle() == null) {
                                                String str10 = this.id;
                                                if (str10 != null ? str10.equals(userCount.getId()) : userCount.getId() == null) {
                                                    String str11 = this.extraData;
                                                    if (str11 != null ? str11.equals(userCount.getExtraData()) : userCount.getExtraData() == null) {
                                                        Long l = this.dateline;
                                                        if (l != null ? l.equals(userCount.getDateline()) : userCount.getDateline() == null) {
                                                            Long l2 = this.lastUpdate;
                                                            if (l2 != null ? l2.equals(userCount.getLastUpdate()) : userCount.getLastUpdate() == null) {
                                                                String str12 = this.deprecatedUserAvatar;
                                                                if (str12 != null ? str12.equals(userCount.getDeprecatedUserAvatar()) : userCount.getDeprecatedUserAvatar() == null) {
                                                                    UserInfo userInfo2 = this.userInfo;
                                                                    if (userInfo2 != null ? userInfo2.equals(userCount.getUserInfo()) : userCount.getUserInfo() == null) {
                                                                        String str13 = this.deprecatedUserName;
                                                                        if (str13 != null ? str13.equals(userCount.getDeprecatedUserName()) : userCount.getDeprecatedUserName() == null) {
                                                                            String str14 = this.displayUserName;
                                                                            if (str14 != null ? str14.equals(userCount.getDisplayUserName()) : userCount.getDisplayUserName() == null) {
                                                                                String str15 = this.uid;
                                                                                if (str15 != null ? str15.equals(userCount.getUid()) : userCount.getUid() == null) {
                                                                                    if (this.followApp == userCount.getFollowApp() && this.feed == userCount.getFeed() && this.follow == userCount.getFollow() && this.fans == userCount.getFans() && this.notification == userCount.getNotification() && this.message == userCount.getMessage() && this.atMeCount == userCount.getAtMeCount() && this.atMeInCommentCount == userCount.getAtMeInCommentCount() && this.replyMeCount == userCount.getReplyMeCount() && this.badge == userCount.getBadge()) {
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
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.uid;
        if (str15 != null) {
            i = str15.hashCode();
        }
        return ((((((((((((((((((((hashCode18 ^ i) * 1000003) ^ this.followApp) * 1000003) ^ this.feed) * 1000003) ^ this.follow) * 1000003) ^ this.fans) * 1000003) ^ this.notification) * 1000003) ^ this.message) * 1000003) ^ this.atMeCount) * 1000003) ^ this.atMeInCommentCount) * 1000003) ^ this.replyMeCount) * 1000003) ^ this.badge;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_UserCount$Builder */
    /* compiled from: $$AutoValue_UserCount */
    static final class Builder extends UserCount.Builder {
        private Integer atMeCount;
        private Integer atMeInCommentCount;
        private Integer badge;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private Integer fans;
        private Integer feed;
        private Integer follow;
        private Integer followApp;
        private String id;
        private Long lastUpdate;
        private String logo;
        private Integer message;
        private Integer notification;
        private String pic;
        private Integer replyMeCount;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(UserCount userCount) {
            this.entityTypeName = userCount.getEntityTypeName();
            this.entityTemplate = userCount.getEntityTemplate();
            this.entityId = userCount.getEntityId();
            this.entityFixed = userCount.getEntityFixed();
            this.title = userCount.getTitle();
            this.url = userCount.getUrl();
            this.description = userCount.getDescription();
            this.pic = userCount.getPic();
            this.logo = userCount.getLogo();
            this.subTitle = userCount.getSubTitle();
            this.id = userCount.getId();
            this.extraData = userCount.getExtraData();
            this.dateline = userCount.getDateline();
            this.lastUpdate = userCount.getLastUpdate();
            this.deprecatedUserAvatar = userCount.getDeprecatedUserAvatar();
            this.userInfo = userCount.getUserInfo();
            this.deprecatedUserName = userCount.getDeprecatedUserName();
            this.displayUserName = userCount.getDisplayUserName();
            this.uid = userCount.getUid();
            this.followApp = Integer.valueOf(userCount.getFollowApp());
            this.feed = Integer.valueOf(userCount.getFeed());
            this.follow = Integer.valueOf(userCount.getFollow());
            this.fans = Integer.valueOf(userCount.getFans());
            this.notification = Integer.valueOf(userCount.getNotification());
            this.message = Integer.valueOf(userCount.getMessage());
            this.atMeCount = Integer.valueOf(userCount.getAtMeCount());
            this.atMeInCommentCount = Integer.valueOf(userCount.getAtMeInCommentCount());
            this.replyMeCount = Integer.valueOf(userCount.getReplyMeCount());
            this.badge = Integer.valueOf(userCount.getBadge());
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserCount.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserCount.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserCount.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public UserCount.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder, com.coolapk.market.model.IUser.BuilderM1
        public UserCount.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setFollowApp(int i) {
            this.followApp = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setFeed(int i) {
            this.feed = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setFollow(int i) {
            this.follow = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setFans(int i) {
            this.fans = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setNotification(int i) {
            this.notification = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setMessage(int i) {
            this.message = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setAtMeCount(int i) {
            this.atMeCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setAtMeInCommentCount(int i) {
            this.atMeInCommentCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setReplyMeCount(int i) {
            this.replyMeCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount.Builder setBadge(int i) {
            this.badge = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UserCount.Builder
        public UserCount build() {
            String str = "";
            if (this.followApp == null) {
                str = str + " followApp";
            }
            if (this.feed == null) {
                str = str + " feed";
            }
            if (this.follow == null) {
                str = str + " follow";
            }
            if (this.fans == null) {
                str = str + " fans";
            }
            if (this.notification == null) {
                str = str + " notification";
            }
            if (this.message == null) {
                str = str + " message";
            }
            if (this.atMeCount == null) {
                str = str + " atMeCount";
            }
            if (this.atMeInCommentCount == null) {
                str = str + " atMeInCommentCount";
            }
            if (this.replyMeCount == null) {
                str = str + " replyMeCount";
            }
            if (this.badge == null) {
                str = str + " badge";
            }
            if (str.isEmpty()) {
                return new AutoValue_UserCount(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.uid, this.followApp.intValue(), this.feed.intValue(), this.follow.intValue(), this.fans.intValue(), this.notification.intValue(), this.message.intValue(), this.atMeCount.intValue(), this.atMeInCommentCount.intValue(), this.replyMeCount.intValue(), this.badge.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
